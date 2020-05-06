package flow.subflow.Prepaid_Start;

import java.util.ArrayList;
import java.util.Hashtable;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.servion.triplefive.utils.AppConstant;
import com.servion.triplefive.utils.Constants;
import com.servion.triplefive.utils.PrintStackTrace;
import com.servion.triplefive.utils.SetPushSMS;
import com.servion.util.AppProperties;

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
 * Last generated by Orchestration Designer at: 2015-MAR-17  01:42:51 PM
 */
public class Set_Store_Global extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAR-17  01:42:51 PM
	 */
	public Set_Store_Global() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:51 PM
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
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:51 PM
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
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:51 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(2);
		actions.add(new com.avaya.sce.runtime.varoperations.Assign("Prepaid_dmInputParameter:propertyFileName", "Prepaid_propertyFileName:GPMenuRepeat", false).setDebugId(9829));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "Prepaid_Flag:PushSMSDone", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Prepaid_constant:Key_False", true).setDebugId(9830)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("Prepaid_Flag:PushSMSDone", "Prepaid_constant:Key_true", false).setDebugId(9831));
			actions.add(new com.avaya.sce.runtime.Next("Prepaid_Start-PushSMS_StoreAddress", "pushSMS").setDebugId(9832));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("Prepaid_Start-Store_GlobalMenu", "Global").setDebugId(9834));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


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
		ArrayList<String> arrAddress = null;
		String address = AppConstant.EMPTY_STRING;
		/**Assign**/
		trace = mySession.getTraceOutput();
		try {
			trace = mySession.getTraceOutput();
			pushSMSkey = AppProperties.GetInstance(Constants.IVR_CONFIG).getIVRProp(AppConstant.STORE_ADDRESS_SUCCESS);
			address = mySession.getVariableField(IProjectVariables.PREPAID__APP_VARIABLES,IProjectVariables.PREPAID__APP_VARIABLES_FIELD_ADDRESS).getStringValue();
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Recharge Push SMS Succes Key :"+pushSMSkey);
			objSetPushSMS = new SetPushSMS();
			arrAddress = new ArrayList<>();
			arrAddress.add(address);
			dynamicValueMap = objSetPushSMS.generatePushSMSDataMap(pushSMSkey, arrAddress);
			mySession.setProperty(AppConstant.SMSDataMap,dynamicValueMap);
		
		} catch (Exception e) {
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR,"Error in Push SMS Formation Failure :"+e);
			PrintStackTrace.PrintException(e);
		}
	
	
	
	}
}