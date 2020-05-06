package flow.subflow.Prepaid;

import java.util.Hashtable;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.prepaid.model.IntelligentLayerInfo;
import com.servion.hsd.utils.AppConstant;
import com.servion.hsd.utils.AppDataMap;
import com.servion.hsd.utils.StackTrace;



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
 * Last generated by Orchestration Designer at: 2015-MAR-13  12:01:14 AM
 */
public class Intelligent_Flag extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAR-13  12:01:14 AM
	 */
	public Intelligent_Flag() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:39:00 PM
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
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:39:00 PM
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
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:39:00 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(3);
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "Intelligent Layer Enable Flag :", "Flag:IntelligentLayerEnabled").setDebugId(590));
		actions.add(new com.avaya.sce.runtime.varoperations.Assign("Postpaid_CallData:mdn", "session:ani", false).setDebugId(11469));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "Flag:IntelligentLayerEnabled", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:Y", true).setDebugId(591)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("HotFlashInfo:annoID", "HotFlashIDs:HSDI_PA_0005", false).setDebugId(592));
			actions.add(new com.avaya.sce.runtime.Next("Prepaid-Intelligent_HotFlash", "continue").setDebugId(593));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("Prepaid-checkMainMenuCount", "disabled").setDebugId(595));
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

		
		/**Declaration **/
		String appName = AppConstant.EMPTY_STRING,hostOutput = AppConstant.ERROR,language = AppConstant.EMPTY_STRING;
		String circleID =  AppConstant.EMPTY_STRING,IntelligentLayerKey = AppConstant.EMPTY_STRING,status = AppConstant.EMPTY_STRING;
		IntelligentLayerInfo objIntelligentLayerInfo= null;
		Hashtable<String, IntelligentLayerInfo> objMapIntelligentLayerInfo = null;
		ITraceInfo trace = mySession.getTraceOutput();
		
		try {
			
			/**Assigning**/
			appName = mySession.getVariableField(IProjectVariables.APP__NAME).getStringValue();
			circleID = mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_CIRCLE_ID).getStringValue();
			IntelligentLayerKey = AppConstant.INTELLIGENT_KEY+appName;
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"App Name :" + appName);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Intelligent Layer Key :" + IntelligentLayerKey);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Intelligent circle ID :" + circleID);
			
			objMapIntelligentLayerInfo = (Hashtable<String, IntelligentLayerInfo>) AppDataMap.getInstance(appName).getAppData(IntelligentLayerKey);
			
			
			/**DB Hit**/

			if(objMapIntelligentLayerInfo!=null){
				objIntelligentLayerInfo = objMapIntelligentLayerInfo.get(circleID);
				if(objIntelligentLayerInfo!=null){
					status= objIntelligentLayerInfo.getStatus();
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Intelligent Layer status :" + status);
				}else{
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Intelligent Object is not available for Circle ID :" +circleID);
				}
			}else{
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Hash Table Map is not available for application");
			}
			
		} catch (Exception e) {
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "Error in Intelligent Layer :" +e);
			StackTrace.PrintException(e);
		}
		mySession.getVariableField(IProjectVariables.FLAG,IProjectVariables.FLAG_FIELD_INTELLIGENT_LAYER_ENABLED).setValue(status);
	
	}
}