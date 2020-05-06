package flow;

import java.util.ArrayList;
import java.util.Hashtable;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.servion.util.AppConstant;
import com.servion.util.AppProperties;
import com.servion.util.SetPushSMS;
import com.servion.util.StackTrace;

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
 * Last generated by Orchestration Designer at: 2015-JUN-12  04:09:28 PM
 */
public class Push_SMS_topup1 extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-JUN-12  04:09:28 PM
	 */
	public Push_SMS_topup1() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-AUG-29  03:09:19 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("PuchSMS_Topup");
		next.setDebugId(8233);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2017-AUG-29  03:09:19 PM
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
	 * Last generated by Orchestration Designer at: 2017-AUG-29  03:09:19 PM
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


		/**Declaration**/
		String pushSMSkey = AppConstant.EMPTY_STRING;
		ITraceInfo trace = null;
		SetPushSMS objSetPushSMS = null;
		Hashtable<String, String> dynamicValueMap = null;
		String minAmount = AppConstant.EMPTY_STRING,maxAmount = AppConstant.EMPTY_STRING;
		String minTalkTimet = AppConstant.EMPTY_STRING,maxTalkTime = AppConstant.EMPTY_STRING;
		String amountSelected = AppConstant.EMPTY_STRING;
		ArrayList<String> dynamicValueList =null;
		/**Assign**/
		trace = mySession.getTraceOutput();
		try {
			pushSMSkey = AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp(AppConstant.TOPUP_SUCCESS);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Account Balance Push SMS Success Key :"+pushSMSkey);
			
			minAmount = mySession.getVariableField(IProjectVariables.TOP_UP_DETAIL,IProjectVariables.TOP_UP_DETAIL_FIELD_MIN_AMOUNT).getStringValue();
			minTalkTimet = mySession.getVariableField(IProjectVariables.TOP_UP_DETAIL,IProjectVariables.TOP_UP_DETAIL_FIELD_MIN_TALK_TIME).getStringValue();
			maxAmount = mySession.getVariableField(IProjectVariables.TOP_UP_DETAIL,IProjectVariables.TOP_UP_DETAIL_FIELD_MAX_AMOUNT).getStringValue();
			maxTalkTime = mySession.getVariableField(IProjectVariables.TOP_UP_DETAIL,IProjectVariables.TOP_UP_DETAIL_FIELD_MAX_TALK_TIME).getStringValue();
			
			amountSelected = mySession.getVariableField(IProjectVariables.TOP_UP_SELECT_AMT,IProjectVariables.TOP_UP_SELECT_AMT_FIELD_VALUE).getStringValue();
			if(amountSelected.equalsIgnoreCase(minAmount)){
				dynamicValueList=new ArrayList<String>();
				dynamicValueList.add(minAmount);
				dynamicValueList.add(minTalkTimet);
			}else{
				dynamicValueList=new ArrayList<String>();
				dynamicValueList.add(maxAmount);
				dynamicValueList.add(maxTalkTime);
			}
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Top Up Amount :: "+minAmount +":: TopUp talkTime ::"+minTalkTimet);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Top Up Amount :: "+maxAmount +":: TopUp talkTime ::"+maxTalkTime);
			
			objSetPushSMS = new SetPushSMS();
			
			dynamicValueMap = objSetPushSMS.generatePushSMSDataMap(pushSMSkey, dynamicValueList);
			mySession.setProperty(AppConstant.SMSDataMap,dynamicValueMap);
		
		} catch (Exception e) {
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR,"Error in Push SMS Account Failure :"+e);
			StackTrace.PrintException(e);
		}
		
	}
}
