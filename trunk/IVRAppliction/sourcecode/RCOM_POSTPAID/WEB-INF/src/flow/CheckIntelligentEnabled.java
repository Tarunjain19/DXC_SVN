package flow;

import java.util.Hashtable;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.avaya.sce.runtimecommon.VariableTypeException;
import com.rcom.postpaid.model.IntelligentLayerInfo;
import com.servion.postpaid.utils.AppDataMap;
import com.servion.postpaid.utils.Constants;
import com.servion.postpaid.utils.PrintStackTrace;

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
			strApplicationName = mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_APPLICATION_NAME).getStringValue();
			strIntelligentLayerKey = Constants.INTELLIGENT_KEY+strApplicationName;
			
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->Application Name:"+strApplicationName);
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->Intelligent layer key:"+strIntelligentLayerKey);
			objIntelligentLayerInfo = (Hashtable<String, IntelligentLayerInfo>) AppDataMap.getInstance(strApplicationName).getAppData(strIntelligentLayerKey);
			
			if(objIntelligentLayerInfo != null){
				strCircle = mySession.getVariableField(IProjectVariables.ROUTING_INFO, IProjectVariables.ROUTING_INFO_FIELD_CIRCLE).getStringValue(); 
				intelligentLayerInfo = objIntelligentLayerInfo.get(strCircle);
				if(intelligentLayerInfo != null){
					strStatus = intelligentLayerInfo.getStatus();
					if(strStatus.equalsIgnoreCase(Constants.Y)){
						info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->Intelligent is enabled:"+strStatus);
						mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_INTELLIGENT_LAYER_ENABLED).setValue(Constants.Yes);
					}else{
						info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->Intelligent is disenabled:"+strStatus);
						mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_INTELLIGENT_LAYER_ENABLED).setValue(Constants.No);
					}
				}else{
					info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->Intelligent is disenabled, no circle info found");
					mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_INTELLIGENT_LAYER_ENABLED).setValue(Constants.No);
				}
			}else{
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->Intelligent is disenabled, no application info found");
				mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_INTELLIGENT_LAYER_ENABLED).setValue(Constants.No);
			}
		} catch (VariableTypeException e) {
			PrintStackTrace.PrintException(e);
			mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_INTELLIGENT_LAYER_ENABLED).setValue(Constants.Yes);
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
	 * Last generated by Orchestration Designer at: 2017-AUG-28  03:36:19 PM
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
	 * Last generated by Orchestration Designer at: 2017-AUG-28  03:36:19 PM
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
	 * Last generated by Orchestration Designer at: 2017-AUG-28  03:36:19 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "Flag:isIntelligentLayerEnabled", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:yes", true).setDebugId(1205)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("Flag:isFromIntelligentLayer", "Constants:yes", false).setDebugId(1622));
			actions.add(new com.avaya.sce.runtime.Next("AccessDB_CheckDunnedCaller", "Enabled").setDebugId(1204));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("Initialize_MN_0005", "Disabled").setDebugId(1207));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
