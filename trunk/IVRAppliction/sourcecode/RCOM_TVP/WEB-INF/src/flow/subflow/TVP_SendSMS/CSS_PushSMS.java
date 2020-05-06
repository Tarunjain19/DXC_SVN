package flow.subflow.TVP_SendSMS;

//import flow.subflow.PushSMS.SCESession;
import java.util.Hashtable;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
//import com.rcom.prepaid.model.PushSMSInfo;
import com.servion.rcom.hostinterface.view.ReqPushSMS;
import com.servion.rcom.hostinterface.view.ResPushSMS;
import com.servion.rcom.hostinterface.wrapper.IVRWebService;
import com.servion.rcom.hostinterface.wrapper.IVRWebServiceImpl;
import com.servion.util.AppConstant;
import com.servion.util.IVRDataBean;
import com.servion.util.SetPushSMS;
import com.servion.util.StackTrace;

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
 * Last generated by Orchestration Designer at: 2015-NOV-06  02:20:37 PM
 */
public class CSS_PushSMS extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-NOV-06  02:20:37 PM
	 */
	public CSS_PushSMS() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-JUL-12  01:45:39 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("TVP_SendSMS-end", "Default");
		next.setDebugId(7);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2017-JUL-12  01:45:39 PM
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
	 * Last generated by Orchestration Designer at: 2017-JUL-12  01:45:39 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
	@Override
	public void requestBegin(SCESession mySession) {

		super.requestBegin(mySession);

		ITraceInfo trace = mySession.getTraceOutput();

		Hashtable<String, String> smsHashTable = null;
		SetPushSMS setPushSMS = null;
		String strKeyword = AppConstant.EMPTY_STRING;
	//	PushSMSInfo pushSMSInfo = null;
		String strApplicationName = AppConstant.EMPTY_STRING, strCircle = AppConstant.EMPTY_STRING, strMsgText = AppConstant.EMPTY_STRING;
	//	Hashtable<String, PushSMSInfo> pushSMSHashTable = null;
		IVRDataBean ivrDataBean = null;
		String completeSMSText = AppConstant.EMPTY_STRING;
		ReqPushSMS reqPushSMS = null;
		ResPushSMS resPushSMS = null;
		IVRWebService ivrWebService = null;

		try {

		//	pushSMSInfo = new PushSMSInfo();
			setPushSMS = new SetPushSMS();
			smsHashTable = (Hashtable<String, String>) mySession.getProperty(AppConstant.SMSDataMap);
			completeSMSText = mySession.getVariableField(IProjectVariables.PUSH_SMS,IProjectVariables.PUSH_SMS_FIELD_PUSH_SMSTEXT).getStringValue();
			ivrDataBean = (IVRDataBean) mySession.getProperty(AppConstant.IVRDATABEAN);

			if (completeSMSText != null && !AppConstant.EMPTY_STRING.equalsIgnoreCase(completeSMSText)) {
				
				strMsgText = completeSMSText;
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "SMS Text :"+ strMsgText);

				reqPushSMS = new ReqPushSMS();
				ivrWebService = new IVRWebServiceImpl();
				reqPushSMS.setMDN(mySession.getVariableField(IProjectVariables.CALL_INFO,IProjectVariables.CALL_INFO_FIELD_TVP_MDN).getStringValue());
				reqPushSMS.setMessageText(strMsgText);
				resPushSMS = ivrWebService.executePushSMS(ivrDataBean,reqPushSMS);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "SMSText:"+ resPushSMS.getResponseCode());
			}
			
			mySession.getVariableField(IProjectVariables.TVP__VARS, IProjectVariables.TVP__VARS_FIELD_JAVA__ERROR).setValue(false);

		} catch (Exception e) {
			StackTrace.PrintException(e);
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR,"Exception in sending SMS");
			mySession.getVariableField(IProjectVariables.TVP__VARS, IProjectVariables.TVP__VARS_FIELD_JAVA__ERROR).setValue(true);
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "# CSS_PushSMS.java Java_Error is set to: " + e );
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "# ERROR: Exception - CSS_PushSMS.java:- " + e);
			
		

		} finally {
			ivrDataBean = null;
			//pushSMSInfo = null;
			reqPushSMS = null;
			setPushSMS = null;
			resPushSMS = null;
			ivrWebService = null;
		}

	}
}
