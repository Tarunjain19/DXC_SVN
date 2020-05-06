package flow.subflow.AccountInformation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.servion.postpaid.utils.Constants;
import com.servion.postpaid.utils.PrintStackTrace;
import com.servion.postpaid.utils.SetPushSMS;
import com.servion.rcom.hostinterface.view.ReqDuplicateBill;
import com.servion.rcom.hostinterface.view.ResDuplicateBill;
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
 * Last generated by Orchestration Designer at: 2015-APR-16  04:33:59 PM
 */
public class AccessHost_RequestDuplicateBill extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS
	
	@Override
	public void requestBegin(SCESession mySession) {
		super.requestBegin(mySession);
		
		ITraceInfo info = mySession.getTraceOutput();
		
		IVRDataBean ivrDataBean = null;
		ReqDuplicateBill reqDuplicateBill = null;
		ResDuplicateBill resDuplicateBill = null;
		IVRWebService ivrWebService = null;
		String strUnbilledDate = "";
		Date unbilledDate = null;
		DateFormat dateFormat = null;
		SetPushSMS setPushSMS = null;
		String strSMSFrame = "";
		ArrayList<String> arrSMSData = null;
		Hashtable<String, String> smsHashTable = null;
		AppProperties appProperties = null;
		
		try {
			
			setPushSMS = new SetPushSMS();
			arrSMSData = new ArrayList<String>();
			appProperties = (AppProperties) mySession.getProperty(Constants.IvrPropertyInstance);
			
			dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			ivrDataBean = (IVRDataBean) mySession.getProperty(Constants.IVRDATABEAN);
			reqDuplicateBill = new ReqDuplicateBill();
			reqDuplicateBill.setMDN(mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_MDN).getStringValue());
			
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->MDN: "+reqDuplicateBill.getMDN());
			ivrWebService = new IVRWebServiceImpl();
			resDuplicateBill = ivrWebService.executeDuplicateBillRequest(ivrDataBean, reqDuplicateBill);
			
			mySession.getVariableField(IProjectVariables.REQUEST_DUPLICATE_BILL, IProjectVariables.REQUEST_DUPLICATE_BILL_FIELD_RESPONSE_CODE).setValue(resDuplicateBill.getResponseCode());
			if((resDuplicateBill.getResponseCode()).equals(Constants.zero)){
				mySession.getVariableField(IProjectVariables.REQUEST_DUPLICATE_BILL, IProjectVariables.REQUEST_DUPLICATE_BILL_FIELD_CODE).setValue(resDuplicateBill.getCaseId());
				mySession.getVariableField(IProjectVariables.REQUEST_DUPLICATE_BILL, IProjectVariables.REQUEST_DUPLICATE_BILL_FIELD_STATUS).setValue(resDuplicateBill.getMessageText());
				mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_MSG_TEXT).setValue(resDuplicateBill.getMessageText());
				
				/*strSMSFrame = appProperties.getIVRProp(Constants.MYPLAN_Success);
				smsHashTable = setPushSMS.generatePushSMSDataMap(strSMSFrame, arrSMSData);*/
				
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->Request Bill Code: "+resDuplicateBill.getCaseId()+", Msg Text: "+resDuplicateBill.getMessageText());
			}else{
				
				/*strSMSFrame = appProperties.getIVRProp(Constants.MYPLAN_Success);
				smsHashTable = setPushSMS.generatePushSMSDataMap(strSMSFrame, arrSMSData);*/
				
				mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.Yes);
			}
		} catch (Exception e) {
			PrintStackTrace.PrintException(e);
			mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.Yes);
		}
	}

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-APR-16  04:33:59 PM
	 */
	public AccessHost_RequestDuplicateBill() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2015-NOV-08  05:50:23 PM
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
	 * Last generated by Orchestration Designer at: 2015-NOV-08  05:50:23 PM
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
	 * Last generated by Orchestration Designer at: 2015-NOV-08  05:50:23 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(2);
		actions.add(new com.avaya.sce.runtime.varoperations.Assign("CallData:repeatTries", "0", true).setDebugId(5306));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "Flag:isLinkDown", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:yes", true).setDebugId(2867)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("CallData:transferReasonCode", "TR_0124", true).setDebugId(5849));
			actions.add(new com.avaya.sce.runtime.Next("AccountInformation-LinkDown", "LinkDown").setDebugId(2866));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("AccountInformation-Initialize_PA_0028", "Continue").setDebugId(2869));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
