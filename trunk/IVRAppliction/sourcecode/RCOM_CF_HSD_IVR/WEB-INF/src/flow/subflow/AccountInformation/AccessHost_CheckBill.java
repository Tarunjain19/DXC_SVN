package flow.subflow.AccountInformation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;

import com.servion.hsd.utils.AppConstant;
import com.servion.hsd.utils.Constants;
import com.servion.hsd.utils.PrintStackTrace;
import com.servion.hsd.utils.SetPushSMS;
import com.servion.rcom.hostinterface.view.ReqBillInfo;
import com.servion.rcom.hostinterface.view.ResBillInfo;
import com.servion.rcom.hostinterface.wrapper.IVRWebService;
import com.servion.rcom.hostinterface.wrapper.IVRWebServiceImpl;
import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;

import flow.IProjectVariables;

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
 * Last generated by Orchestration Designer at: 2015-MAY-13  10:13:18 PM
 */
public class AccessHost_CheckBill extends com.avaya.sce.runtime.Data {

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
		
		SetPushSMS setPushSMS = null;
		String strSMSFrame = "";
		ArrayList<String> arrSMSData = null;
		Hashtable<String, String> smsHashTable = null;
		AppProperties appProperties = null;
		
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = null;
		
		try {
			
			setPushSMS = new SetPushSMS();
			arrSMSData = new ArrayList<String>();
			
			callDate = new Date();
			dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			
			ivrDataBean = (IVRDataBean) mySession.getProperty(Constants.IVRDATABEAN);
			reqBillInfo = new ReqBillInfo();
			reqBillInfo.setMDN(mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_ANI).getStringValue());
			
			appProperties = AppProperties.GetInstance(AppConstant.IVR_CONFIG);

			ivrWebService = new IVRWebServiceImpl();
			resBillInfo = ivrWebService.executeBillInfo(ivrDataBean, reqBillInfo);
			
			mySession.getVariableField(IProjectVariables.POSTPAID__CHECK_BILL_DETAIL, IProjectVariables.POSTPAID__CREDIT_INFO_FIELD_RESPONSE_CODE).setValue(resBillInfo.getResponseCode());
			if((resBillInfo.getResponseCode()).equals(Constants.zero)){
				
				strDueDate = resBillInfo.getPaymentDueDate();
				dueDate = dateFormat.parse(strDueDate);
				
				strBillDate = resBillInfo.getBillIssueDate();
				billDate = dateFormat.parse(strBillDate);
				
				strBillDate = dateFormat.format(billDate);
				strDueDate = dateFormat.format(dueDate);
				
				dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				mySession.getVariableField(IProjectVariables.POSTPAID__CHECK_BILL_DETAIL, IProjectVariables.POSTPAID__CHECK_BILL_DETAIL_FIELD_ACCOUNT_BALANCE).setValue(resBillInfo.getAccountBalance());
				mySession.getVariableField(IProjectVariables.POSTPAID__CHECK_BILL_DETAIL, IProjectVariables.POSTPAID__CHECK_BILL_DETAIL_FIELD_DUE_DATE).setValue(dateFormat.format(dueDate));
				mySession.getVariableField(IProjectVariables.POSTPAID__CHECK_BILL_DETAIL, IProjectVariables.POSTPAID__CHECK_BILL_DETAIL_FIELD_INVOICE_AMOUNT).setValue(resBillInfo.getInvoiceAmount());
				mySession.getVariableField(IProjectVariables.POSTPAID__CHECK_BILL_DETAIL, IProjectVariables.POSTPAID__CHECK_BILL_DETAIL_FIELD_ISSUE_DATE).setValue(dateFormat.format(billDate));
				
				dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				
				dateDiff = dateFormat.parse(strBillDate).getTime() - callDate.getTime(); 
				dateDiff = (dateDiff / (24 * 60 * 60 * 1000))*24;
				
				mySession.getVariableField(IProjectVariables.POSTPAID__CHECK_BILL_DETAIL, IProjectVariables.POSTPAID__CHECK_BILL_DETAIL_FIELD_BILL_DATE_DIFF).setValue(dateDiff);
				
				cal.setTime(dateFormat.parse(strBillDate));
				cal.add(Calendar.DATE, 2);
				
				validationStartDate = cal.getTime();
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Validation Start Date:"+validationStartDate);
				
				cal.setTime(dateFormat.parse(strBillDate));
				cal.add(Calendar.DATE, 6);
				validationEndDate = cal.getTime();
				
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Validation End Date:"+validationEndDate);
				
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "---> Validation Start Date comparision:"+callDate.compareTo(validationStartDate));
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "---> Validation End Date comparision:"+callDate.compareTo(validationEndDate));
				
				if((callDate.compareTo(validationStartDate)>=0)&&(callDate.compareTo(validationEndDate)<=0))
					mySession.getVariableField(IProjectVariables.POSTPAID__CHECK_BILL_DETAIL, IProjectVariables.POSTPAID__CHECK_BILL_DETAIL_FIELD_IS_CALL_DATE_VALID).setValue(Constants.Yes);
				else
					mySession.getVariableField(IProjectVariables.POSTPAID__CHECK_BILL_DETAIL, IProjectVariables.POSTPAID__CHECK_BILL_DETAIL_FIELD_IS_CALL_DATE_VALID).setValue(Constants.No);
				
				arrSMSData.add(resBillInfo.getBillIssueDate());
				arrSMSData.add(resBillInfo.getInvoiceAmount());
				arrSMSData.add(resBillInfo.getAccountBalance());
				arrSMSData.add(resBillInfo.getPaymentDueDate());
				strSMSFrame = appProperties.getIVRProp(Constants.CHECK_BILL_Success);
				smsHashTable = setPushSMS.generatePushSMSDataMap(strSMSFrame, arrSMSData);
				
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Date Diff:"+dateDiff);
			}else{
				
				strSMSFrame = appProperties.getIVRProp(Constants.CHECK_BILL_Failure);
				smsHashTable = setPushSMS.generatePushSMSDataMap(strSMSFrame, arrSMSData);
				
				mySession.getVariableField(IProjectVariables.POSTPAID__FLAG, IProjectVariables.POSTPAID__FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.Yes);
			}
			

		} catch (Exception e) {
			strSMSFrame = appProperties.getIVRProp(Constants.CHECK_BILL_Failure);
			smsHashTable = setPushSMS.generatePushSMSDataMap(strSMSFrame, arrSMSData);
			PrintStackTrace.PrintException(e);
			mySession.getVariableField(IProjectVariables.POSTPAID__FLAG, IProjectVariables.POSTPAID__FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.Yes);
		}finally{
			mySession.setProperty(Constants.SMSDataMap, smsHashTable);
		}
	}

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-13  10:13:18 PM
	 */
	public AccessHost_CheckBill() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:39:22 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = null;
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:39:22 PM
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
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:39:22 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(2);
		actions.add(new com.avaya.sce.runtime.varoperations.Assign("Postpaid_CallData:repeatTries", "0", true).setDebugId(5304));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "Postpaid_Flag:isLinkDown", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Postpaid_Constants:yes", true).setDebugId(1922)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("Postpaid_Flag:isLinkDown", "Postpaid_Constants:no", false).setDebugId(5855));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "Flag:CalledFromIntelligent", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Postpaid_Constants:yes", true).setDebugId(1925)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("AccountInformation-MainMenu", "mainmenu").setDebugId(1931));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("dmInputParameter:propertyFileName", "propertyFileName:GlobalPromptFeature", false).setDebugId(5958));
				actions.add(new com.avaya.sce.runtime.Next("AccountInformation-PushSMSCheckBillLinkDown", "PushSMS").setDebugId(1928));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


		} else {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "Postpaid_Flag:isFromEventBased", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Postpaid_Constants:yes", true).setDebugId(1932)).evaluate(mySession)) {

				if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition4", "Postpaid_CheckBillDetail:isCallDateValid", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Postpaid_Constants:yes", true).setDebugId(1935)).evaluate(mySession)) {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.Next("AccountInformation-CheckBillDateDiff", "CheckBillDateDiff").setDebugId(1938));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;

				} else {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.Next("AccountInformation-AccessHost_CheckPayment", "Return").setDebugId(1934));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;
				}


			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("AccountInformation-CheckBillDateDiff", "CheckBillDateDiff").setDebugId(1924));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}

		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
