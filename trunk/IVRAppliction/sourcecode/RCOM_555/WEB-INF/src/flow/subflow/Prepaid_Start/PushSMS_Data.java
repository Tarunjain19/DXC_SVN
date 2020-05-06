package flow.subflow.Prepaid_Start;

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
 * Last generated by Orchestration Designer at: 2015-MAR-12  07:21:42 PM
 */
public class PushSMS_Data extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAR-12  07:21:42 PM
	 */
	public PushSMS_Data() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:55 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("Prepaid_Start-PuchSMS_DataOffer", "Default");
		next.setDebugId(13515);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:55 PM
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
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:55 PM
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
		String offerCode = AppConstant.EMPTY_STRING,key = AppConstant.EMPTY_STRING;
		/**Assign**/
		trace = mySession.getTraceOutput();
		try {
			trace = mySession.getTraceOutput();
			offerCode = mySession.getVariableField(IProjectVariables.DATA_OFFERS_MENU,IProjectVariables.DATA_OFFERS_MENU_FIELD_VALUE).getStringValue();
			key = AppConstant.DATA_OFFER_SUCCESS+AppConstant.SEPERATOR_UNDERSCORE+offerCode;
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"offer Code "+offerCode);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Offer key"+ key);
			
			pushSMSkey = AppProperties.GetInstance(Constants.IVR_CONFIG).getIVRProp(key);
			if(AppConstant.N.equalsIgnoreCase(pushSMSkey)){
				pushSMSkey = AppProperties.GetInstance(Constants.IVR_CONFIG).getIVRProp(AppConstant.DATA_OFFER_SUCCESS);
			}
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Data Push SMS Failure Key :"+pushSMSkey);
			objSetPushSMS = new SetPushSMS();
			dynamicValueMap = objSetPushSMS.generatePushSMSDataMap(pushSMSkey, null);
			mySession.setProperty(AppConstant.SMSDataMap,dynamicValueMap);
		
		} catch (Exception e) {
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR,"Error in Push SMS Formation Failure :"+e);
			PrintStackTrace.PrintException(e);
		}
	}
}
