package flow;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.servion.rcom.hni.hostinterface.view.ReqBillInfo;
import com.servion.rcom.hni.hostinterface.view.ResBillInfo;
import com.servion.rcom.hni.hostinterface.wrapper.IVRWebService;
import com.servion.rcom.hni.hostinterface.wrapper.IVRWebServiceImpl;
import com.servion.triplefive.utils.Constants;
import com.servion.triplefive.utils.PrintStackTrace;
import com.servion.util.IVRDataBean;

/**
 * The Data class handles many types of server-side operations including data
 * collection (from a data sources such as a database, or web service), variable
 * assignments and operations (like copying variable values, performing mathematic
 * operations, and collection iteration), conditional evaluation to control callflow
 * execution based on variable values, and logging/tracing statements.
 * 
 * Items created in the getDataActions() method are executed/evaluated in order
 * and if a condional branch condition evaluates to "true" then the branch is
 * activated and the execution of data actions is halted.  If no "true" conditions
 * are encountered, then all data actions will be executed/evaluated and the 
 * application will proceed to the "Default" servlet.
 * Last generated by Orchestration Designer at: 2015-MAY-24  04:11:25 PM
 */
public class AccessHost_OutstandingInfo extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS
	
	@Override
	public void requestBegin(SCESession mySession) {
		super.requestBegin(mySession);
		
		ITraceInfo info = mySession.getTraceOutput();
		
		IVRDataBean ivrDataBean = null;
		ReqBillInfo reqBillInfo = null;
		ResBillInfo resBillInfo = null;
		IVRWebService ivrWebService = null;
		String strBillDate = "", strDueDate = "";
		Date validationStartDate = null, billDate = null, dueDate = null;
		Date validationEndDate = null;
		Date callDate = null;
		long dateDiff = 0;
		
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = null;
		
		try {
			callDate = new Date();
			dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			
			ivrDataBean = (IVRDataBean) mySession.getProperty(Constants.IVRDATABEAN);
			reqBillInfo = new ReqBillInfo();
			reqBillInfo.setMDN(mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_MDN).getStringValue());
			
			ivrWebService = new IVRWebServiceImpl();
			resBillInfo = ivrWebService.executeBillInfo(ivrDataBean, reqBillInfo);
			
			mySession.getVariableField(IProjectVariables.CHECK_BILL_DETAIL, IProjectVariables.CREDIT_INFO_FIELD_RESPONSE_CODE).setValue(resBillInfo.getResponseCode());
			if((resBillInfo.getResponseCode()).equals(Constants.zero)){
				
				strDueDate = resBillInfo.getPaymentDueDate();
				dueDate = dateFormat.parse(strDueDate);
				strBillDate = resBillInfo.getBillIssueDate();
				billDate = dateFormat.parse(strBillDate);
				dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				strBillDate = dateFormat.format(billDate);
				strDueDate = dateFormat.format(dueDate);
				
				mySession.getVariableField(IProjectVariables.CHECK_BILL_DETAIL, IProjectVariables.CHECK_BILL_DETAIL_FIELD_ACCOUNT_BALANCE).setValue(resBillInfo.getAccountBalance());
				mySession.getVariableField(IProjectVariables.CHECK_BILL_DETAIL, IProjectVariables.CHECK_BILL_DETAIL_FIELD_DUE_DATE).setValue(strDueDate);
				mySession.getVariableField(IProjectVariables.CHECK_BILL_DETAIL, IProjectVariables.CHECK_BILL_DETAIL_FIELD_INVOICE_AMOUNT).setValue(resBillInfo.getInvoiceAmount());
				mySession.getVariableField(IProjectVariables.CHECK_BILL_DETAIL, IProjectVariables.CHECK_BILL_DETAIL_FIELD_ISSUE_DATE).setValue(strBillDate);
				
				dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				
				cal.setTime(dateFormat.parse(strBillDate));
				cal.add(Calendar.DATE, 2);
				
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Validation Start Date:"+validationStartDate);
				
				validationStartDate = cal.getTime();
				cal.setTime(dateFormat.parse(strBillDate));
				cal.add(Calendar.DATE, 6);
				validationEndDate = cal.getTime();
				
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Validation End Date:"+validationEndDate);
				
				if((callDate.getTime()>=validationStartDate.getTime())&&(callDate.getTime()<=validationStartDate.getTime()))
					mySession.getVariableField(IProjectVariables.CHECK_BILL_DETAIL, IProjectVariables.CHECK_BILL_DETAIL_FIELD_IS_CALL_DATE_VALID).setValue(Constants.Yes);
				else
					mySession.getVariableField(IProjectVariables.CHECK_BILL_DETAIL, IProjectVariables.CHECK_BILL_DETAIL_FIELD_IS_CALL_DATE_VALID).setValue(Constants.No);
				
				dateDiff = dateFormat.parse(strBillDate).getTime() - callDate.getTime();
				dateDiff = (dateDiff / (24 * 60 * 60 * 1000))*24;
				
				mySession.getVariableField(IProjectVariables.CHECK_BILL_DETAIL, IProjectVariables.CHECK_BILL_DETAIL_FIELD_BILL_DATE_DIFF).setValue(dateDiff);
			
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Date Diff:"+dateDiff);
			}else{
				mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.Yes);
			}
		} catch (Exception e) {
			PrintStackTrace.PrintException(e);
			mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.Yes);
		}
	}


	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-24  04:11:25 PM
	 */
	public AccessHost_OutstandingInfo() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2015-MAY-24  04:11:25 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("AccessHost_CreditLimit", "Coninue");
		next.setDebugId(1230);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2015-MAY-24  04:11:25 PM
	 */
	public java.util.Collection<VariableInfo> getLocalVariables(){
		java.util.Collection<VariableInfo> variables = new java.util.ArrayList<VariableInfo>();

		return variables;
	}
	/**
	 * Creates and conditionally executes operations that have been configured
	 * in the Callflow.  This method will build a collection of operations and
	 * have the framework execute the operations by calling evaluateActions().
	 * If the evaluation causes the framework to forward to a different servlet
	 * then execution stops.
	 * Returning true from this method means that the framework has forwarded the
	 * request to a different servlet.  Returning false means that the default
	 * Next will be invoked.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2015-MAY-24  04:11:25 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "Flag:isLinkDown", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:yes", true).setDebugId(1228)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("Initialize_MN_0005", "LinkDown").setDebugId(1229));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		}

		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}