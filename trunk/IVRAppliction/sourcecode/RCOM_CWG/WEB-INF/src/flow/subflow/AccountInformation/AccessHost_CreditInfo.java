package flow.subflow.AccountInformation;

import java.util.ArrayList;
import java.util.Hashtable;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.servion.postpaid.utils.Constants;
import com.servion.postpaid.utils.PrintStackTrace;
import com.servion.postpaid.utils.SetPushSMS;
import com.servion.rcom.hostinterface.view.ReqCreditLimitInfo;
import com.servion.rcom.hostinterface.view.ResCreditLimitInfo;
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
 * Last generated by Orchestration Designer at: 2015-APR-16  12:35:35 PM
 */
public class AccessHost_CreditInfo extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS
	
	@Override
	public void requestBegin(SCESession mySession) {
		super.requestBegin(mySession);
		
		ITraceInfo info = mySession.getTraceOutput();
		
		IVRDataBean ivrDataBean = null;
		ReqCreditLimitInfo reqCreditLimitInfo = null;
		ResCreditLimitInfo resCreditLimitInfo = null;
		IVRWebService ivrWebService = null;
		SetPushSMS setPushSMS = null;
		String strSMSFrame = "";
		ArrayList<String> arrSMSData = null;
		Hashtable<String, String> smsHashTable = null;
		AppProperties appProperties = null;
		
		try {
			
			setPushSMS = new SetPushSMS();
			arrSMSData = new ArrayList<String>();
			
			ivrDataBean = (IVRDataBean) mySession.getProperty(Constants.IVRDATABEAN);
			reqCreditLimitInfo = new ReqCreditLimitInfo();
			reqCreditLimitInfo.setMDN(mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_MDN).getStringValue());
			appProperties = (AppProperties) mySession.getProperty(Constants.IvrPropertyInstance);

			
			ivrWebService = new IVRWebServiceImpl();
			resCreditLimitInfo = ivrWebService.executeCreditLimitInfo(ivrDataBean, reqCreditLimitInfo);
			
			mySession.getVariableField(IProjectVariables.CREDIT_INFO, IProjectVariables.CREDIT_INFO_FIELD_RESPONSE_CODE).setValue(resCreditLimitInfo.getResponseCode());
			if((resCreditLimitInfo.getResponseCode()).equals(Constants.zero)){
				mySession.getVariableField(IProjectVariables.CREDIT_INFO, IProjectVariables.CREDIT_INFO_FIELD_CREDIT_AMOUNT).setValue(resCreditLimitInfo.getCreditLimit());
				mySession.getVariableField(IProjectVariables.CREDIT_INFO, IProjectVariables.CREDIT_INFO_FIELD_DATE).setValue(resCreditLimitInfo.getSysDate());
				
				arrSMSData.add(resCreditLimitInfo.getCreditLimit());
				strSMSFrame = appProperties.getIVRProp(Constants.CREDIT_INFO_Success);
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "SMS Frame:"+strSMSFrame);
				smsHashTable = setPushSMS.generatePushSMSDataMap(strSMSFrame, arrSMSData);
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "SMS Frame:"+smsHashTable);
				
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Credit Limit Amount: "+resCreditLimitInfo.getCreditLimit()+", Date: "+resCreditLimitInfo.getSysDate());
			}else{
				
				strSMSFrame = appProperties.getIVRProp(Constants.CREDIT_INFO_Failure);
				smsHashTable = setPushSMS.generatePushSMSDataMap(strSMSFrame, arrSMSData);
				
				mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.Yes);
			}
			

		} catch (Exception e) {
			strSMSFrame = appProperties.getIVRProp(Constants.CREDIT_INFO_Failure);
			smsHashTable = setPushSMS.generatePushSMSDataMap(strSMSFrame, arrSMSData);
			PrintStackTrace.PrintException(e);
			mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.Yes);
		}finally{
			mySession.setProperty(Constants.SMSDataMap, smsHashTable);
		}
	}

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-APR-16  12:35:35 PM
	 */
	public AccessHost_CreditInfo() {
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

		actions = new java.util.ArrayList(3);
		actions.add(new com.avaya.sce.runtime.varoperations.Assign("CallData:globalMenuType", "Constants:FeatureLevel", false).setDebugId(4410));
		actions.add(new com.avaya.sce.runtime.varoperations.Assign("CallData:repeatTries", "0", true).setDebugId(5301));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "Flag:isLinkDown", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:yes", true).setDebugId(1452)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("CallData:transferReasonCode", "Constants:TR_0042", false).setDebugId(4749));
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("Flag:isLinkDown", "Constants:no", false).setDebugId(5854));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "Flag:isFromInteractionHistory", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:yes", true).setDebugId(1453)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("AccountInformation-MainMenu", "LinkDown_MainMenu").setDebugId(1454));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("AccountInformation-PushSMSCreditInfoLinkDown", "LinkDown_PushSMS").setDebugId(1456));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


		} else {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("CallData:transferReasonCode", "Constants:TR_0043", false).setDebugId(4750));
			actions.add(new com.avaya.sce.runtime.Next("AccountInformation-Initialize_PA_0018", "Continue").setDebugId(1458));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
