package flow;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.servion.postpaid.utils.Constants;
import com.servion.postpaid.utils.PrintStackTrace;
import com.servion.util.AppProperties;

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
 * Last generated by Orchestration Designer at: 2015-MAY-11  04:01:16 PM
 */
public class Evaluate_MN_0043 extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS
	
	@Override
	public void requestBegin(SCESession mySession) {
		super.requestBegin(mySession);
		
		ITraceInfo info = mySession.getTraceOutput();
		
		String strReturnCode = "", strPropKey = "", strApplicationName = "", strPropertyFilePath = "", strReturnValue = "";
		AppProperties appProperties = null;
		
		try {
			
			strReturnCode = mySession.getVariableField(IProjectVariables.CHANGE_LANGUAGE__MN___0_0_4_3, IProjectVariables.CHANGE_LANGUAGE__MN___0_0_4_3_FIELD_RETURN_CODE).getStringValue();
			strReturnValue = mySession.getVariableField(IProjectVariables.CHANGE_LANGUAGE__MN___0_0_4_3, IProjectVariables.CHANGE_LANGUAGE__MN___0_0_4_3_FIELD_VALUE).getStringValue();
			
			if((strReturnCode.equalsIgnoreCase(Constants.Success))&&(!strReturnValue.equalsIgnoreCase("Transfer"))&&(!strReturnValue.equalsIgnoreCase("Previous"))&&(!strReturnValue.equalsIgnoreCase("MainMenu"))){
				
				
				strApplicationName = mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_APPLICATION_NAME).getStringValue();
				strPropKey = strApplicationName+Constants.HYPEN+strReturnValue+Constants.UNDERSCORE+Constants.PROPERTY_FILE_PATH;
				appProperties = (AppProperties) mySession.getProperty(Constants.IvrPropertyInstance);
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->Property file path: "+appProperties.getIVRProp(strPropKey));
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->Key: "+strPropKey);
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->Property file path: "+appProperties.getIVRProp(strPropKey));
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "---> ApplicationName:"+strApplicationName);
				
				strPropertyFilePath = appProperties.getIVRProp(strPropKey);
				
				if((strPropertyFilePath != "N")||(strPropertyFilePath != null))
					mySession.getVariableField(IProjectVariables.DMPROPERTIES, IProjectVariables.DMPROPERTIES_FIELD_CONFIG_FILE_PATH).setValue(strPropertyFilePath);
				
			}
			
		} catch (Exception e) {
			PrintStackTrace.PrintException(e);
		}
		
		
	}

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-11  04:01:16 PM
	 */
	public Evaluate_MN_0043() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2015-NOV-08  05:50:16 PM
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
	 * Last generated by Orchestration Designer at: 2015-NOV-08  05:50:16 PM
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
	 * Last generated by Orchestration Designer at: 2015-NOV-08  05:50:16 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(2);
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "---> Link down flag : ", "Flag:isLinkDown").setDebugId(3072));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "ChangeLanguage_MN_0043:ReturnCode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:success", true).setDebugId(2576)).evaluate(mySession)) {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "ChangeLanguage_MN_0043:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Grammars:Transfer", true).setDebugId(3704)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("SetTransferData", "Transfer").setDebugId(3705));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "ChangeLanguage_MN_0043:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Grammars:Previous", true).setDebugId(3706)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("Initialize_MN_0005", "Previous").setDebugId(3707));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition4", "ChangeLanguage_MN_0043:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Grammars:MainMenu", true).setDebugId(3708)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("Initialize_MN_0005", "MainMenu").setDebugId(3709));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition5", "ChangeLanguage_MN_0043:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Grammars:Repeat", true).setDebugId(3710)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.varoperations.Increment("CallData:menuRepeatTries").setDebugId(3711));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

				if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition6", "CallData:menuRepeatTries", com.avaya.sce.runtime.Expression.INT_GREATER_THEN_EQUAL, "3", false).setDebugId(3712)).evaluate(mySession)) {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.Next("RepeatTriesExceeded_PA_0090cCopy", "TriesExceed").setDebugId(3713));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;

				} else {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.Next("Initialize_MN_0043", "Repeat").setDebugId(3715));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;
				}


			} else {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.SetCurrentLanguage("ChangeLanguage_MN_0043:Value", false).setDebugId(3075));
				actions.add(new com.avaya.sce.runtime.Next("AccessDB_UpdatePrefLanguage", "UpdateLanguage").setDebugId(2578));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


		} else {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition7", "Flag:isFromIntelligentLayer", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:yes", true).setDebugId(2584)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("Initialize_MN_0005", "NINM_MainMenu").setDebugId(2585));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("CallData:transferReasonCode", "TR_0115", true).setDebugId(2587));
				actions.add(new com.avaya.sce.runtime.Next("SetTransferData", "NINM_Transfer").setDebugId(2588));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}

		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
