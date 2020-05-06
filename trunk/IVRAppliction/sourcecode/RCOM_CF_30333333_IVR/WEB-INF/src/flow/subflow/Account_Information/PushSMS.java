package flow.subflow.Account_Information;

import java.util.ArrayList;
import java.util.Hashtable;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.servion.util.AppConstant;
import com.servion.util.AppProperties;
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
 * Last generated by Orchestration Designer at: 2015-MAR-11  04:21:16 PM
 */
public class PushSMS extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAR-11  04:21:16 PM
	 */
	public PushSMS() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	@Override
	public void requestBegin(SCESession mySession) {
		/**Declaration**/
		String pushSMSkey = AppConstant.EMPTY_STRING;
		ITraceInfo trace = null;
		SetPushSMS objSetPushSMS = null;
		Hashtable<String, String> dynamicValueMap = null;
		String accountBalance = AppConstant.EMPTY_STRING;
		String expiryDate = AppConstant.EMPTY_STRING;
		ArrayList<String> dynamicValueList =null;
		/**Assign**/
		trace = mySession.getTraceOutput();
		try {
			pushSMSkey = AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp(AppConstant.ACCOUNT_BAL_SUCCESS);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Account Balance Push SMS Success Key :"+pushSMSkey);
			
			expiryDate = mySession.getVariableField(IProjectVariables.MAIN_ACCOUNT_BALANCE_AND_VALIDITY, IProjectVariables.MAIN_ACCOUNT_BALANCE_AND_VALIDITY_FIELD_SMS_DATE).getStringValue();
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Expiry Date :: "+expiryDate);
			
			accountBalance = mySession.getVariableField(IProjectVariables.MAIN_ACCOUNT_BALANCE_AND_VALIDITY, IProjectVariables.MAIN_ACCOUNT_BALANCE_AND_VALIDITY_FIELD_BAL).getStringValue();
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Account Balance :: "+accountBalance);
			
			dynamicValueList=new ArrayList<String>();
			dynamicValueList.add(accountBalance);
			dynamicValueList.add(expiryDate);
			
			objSetPushSMS = new SetPushSMS();
			dynamicValueMap = objSetPushSMS.generatePushSMSDataMap(pushSMSkey, dynamicValueList);
			mySession.setProperty(AppConstant.SMSDataMap,dynamicValueMap);
		
		} catch (Exception e) {
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR,"Error in Push SMS Account Failure :"+e);
			StackTrace.PrintException(e);
		}
		
		
	}
	
	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-JUL-05  10:39:21 AM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("Account_Information-PushSMSNonZeroBal", "Default");
		next.setDebugId(3066);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2017-JUL-05  10:39:21 AM
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
	 * Last generated by Orchestration Designer at: 2017-JUL-05  10:39:21 AM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(3);
		actions.add(new com.avaya.sce.runtime.varoperations.Assign("dmInputParameter:propertyFileName", "propertyFileName:GPMenuRepeat", false).setDebugId(3065));
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "Push SMS Bal Success :", "PushSMSFlag:BalSuccess").setDebugId(3493));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "PushSMSFlag:BalSuccess", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:Key_true", true).setDebugId(3494)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("Account_Information-GPMenuRepeat1", "Skip").setDebugId(3495));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		}

		actions = new java.util.ArrayList(1);
		actions.add(new com.avaya.sce.runtime.varoperations.Assign("PushSMSFlag:BalSuccess", "constant:Key_true", false).setDebugId(3496));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
