package flow.subflow.PostpaidStartFlow;

import java.util.Hashtable;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.avaya.sce.runtimecommon.VariableTypeException;
import com.rcom.prepaid.model.IntelligentLayerInfo;
import com.servion.hsd.utils.AppDataMap;
import com.servion.hsd.utils.Constants;
import com.servion.hsd.utils.PrintStackTrace;

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
 * Last generated by Orchestration Designer at: 2015-MAY-24  04:42:19 PM
 */
public class CheckIntelligentEnabled extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS
	
	@Override
	public void requestBegin(SCESession mySession) {
		super.requestBegin(mySession);
		
		ITraceInfo info = mySession.getTraceOutput();
		IntelligentLayerInfo intelligentLayerInfo = null;
		String strApplicationName = "";
		String strIntelligentLayerKey = "";
		Hashtable<String, IntelligentLayerInfo> objIntelligentLayerInfo = null;
		String strCircle = "", strStatus = "";
		
		try {
			strApplicationName = mySession.getVariableField(IProjectVariables.POSTPAID__CALL_DATA, IProjectVariables.POSTPAID__CALL_DATA_FIELD_APPLICATION_NAME).getStringValue();
			strIntelligentLayerKey = Constants.INTELLIGENT_KEY+strApplicationName;
			
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->Application Name:"+strApplicationName);
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->Intelligent layer key:"+strIntelligentLayerKey);
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->Application Data:"+AppDataMap.listApplicationNameInList());
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->Application Service:"+AppDataMap.getInstance(strApplicationName).listofAppDataServiceNames());
			
			objIntelligentLayerInfo = (Hashtable<String, IntelligentLayerInfo>) AppDataMap.getInstance(strApplicationName).getAppData(strIntelligentLayerKey);
			
			if(objIntelligentLayerInfo != null){
				strCircle = mySession.getVariableField(IProjectVariables.POSTPAID__ROUTING_INFO, IProjectVariables.POSTPAID__ROUTING_INFO_FIELD_CIRCLE).getStringValue(); 
				intelligentLayerInfo = objIntelligentLayerInfo.get(strCircle);
				if(intelligentLayerInfo != null){
					strStatus = intelligentLayerInfo.getStatus();
					if(strStatus.equalsIgnoreCase(Constants.Y)){
						info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->Intelligent is enabled:"+strStatus);
						mySession.getVariableField(IProjectVariables.POSTPAID__FLAG, IProjectVariables.POSTPAID__FLAG_FIELD_IS_INTELLIGENT_LAYER_ENABLED).setValue(Constants.Yes);
					}else{
						info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->Intelligent is disabled:"+strStatus);
						mySession.getVariableField(IProjectVariables.POSTPAID__FLAG, IProjectVariables.POSTPAID__FLAG_FIELD_IS_INTELLIGENT_LAYER_ENABLED).setValue(Constants.No);
					}
				}else{
					info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->Intelligent is disabled, no circle info found");
					mySession.getVariableField(IProjectVariables.POSTPAID__FLAG, IProjectVariables.POSTPAID__FLAG_FIELD_IS_INTELLIGENT_LAYER_ENABLED).setValue(Constants.No);
				}
			}else{
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->Intelligent is disabled, no application info found");
				mySession.getVariableField(IProjectVariables.POSTPAID__FLAG, IProjectVariables.POSTPAID__FLAG_FIELD_IS_INTELLIGENT_LAYER_ENABLED).setValue(Constants.No);
			}
		} catch (VariableTypeException e) {
			PrintStackTrace.PrintException(e);
			mySession.getVariableField(IProjectVariables.POSTPAID__FLAG, IProjectVariables.POSTPAID__FLAG_FIELD_IS_INTELLIGENT_LAYER_ENABLED).setValue(Constants.Yes);
		}
	}

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-24  04:42:19 PM
	 */
	public CheckIntelligentEnabled() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:39:05 PM
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
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:39:05 PM
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
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:39:05 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "Postpaid_Flag:isIntelligentLayerEnabled", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Postpaid_Constants:yes", true).setDebugId(8337)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("Flag:CalledFromIntelligent", "Postpaid_Constants:yes", false).setDebugId(8338));
			actions.add(new com.avaya.sce.runtime.Next("PostpaidStartFlow-AccessDB_CheckDunnedCaller", "Enabled").setDebugId(8339));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("PostpaidStartFlow-Initialize_MN_0005", "Disabled").setDebugId(8341));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
