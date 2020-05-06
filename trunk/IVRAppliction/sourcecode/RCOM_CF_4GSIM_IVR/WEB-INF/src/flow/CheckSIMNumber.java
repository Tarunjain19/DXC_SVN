package flow;

import java.util.ArrayList;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.Data.utils.AppConstant;
import com.rcom.Data.utils.DynamicMenu;
import com.rcom.Data.utils.StackTrace;
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
 * Last generated by Orchestration Designer at: 2016-APR-12  01:01:53 PM
 */
public class CheckSIMNumber extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2016-APR-12  01:01:53 PM
	 */
	public CheckSIMNumber() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	@Override
	public void requestBegin(SCESession mySession) {
	
		try
		{
			ITraceInfo trace = mySession.getTraceOutput();
			
			AppProperties ivrProperties = AppProperties.GetInstance(AppConstant.IVR_SIM_CONFIG);
			String appName = null;
			String key = null;
			String initialPrompt = null;
			ArrayList<String> dynamicList = new ArrayList<String>();
			
			String getSIMReturnCode = mySession.getVariableField(IProjectVariables.ENTER_SIMNUMBER, IProjectVariables.ENTER_SIMNUMBER_FIELD_RETURN_CODE).getStringValue();
			String getSIMReturnValue = mySession.getVariableField(IProjectVariables.ENTER_SIMNUMBER, IProjectVariables.ENTER_SIMNUMBER_FIELD_VALUE).getStringValue();
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "ENTER_SIMNUMBER_FIELD_RETURN_CODE : " +getSIMReturnCode);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "ENTER_SIMNUMBER_FIELD_VALUE : " +getSIMReturnValue);
			
			key= "PLAY_SIM";
			initialPrompt = ivrProperties.getIVRProp(key);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "initialPrompt Value : "+initialPrompt);
			dynamicList.add(getSIMReturnValue);
			
			/** Invoking the playPromt method **/
			initialPrompt = DynamicMenu.playPrompt(dynamicList, initialPrompt, AppConstant.NA, trace);
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "initialPrompt after hit Dynamic Value : "+initialPrompt);
			
			mySession.getVariableField(IProjectVariables.DMPROPERTY, IProjectVariables.DMPROPERTY_FIELD_INITIAL_PROMPT).setValue(initialPrompt);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Confirmation Initial Prompt :: "+initialPrompt);
			
			mySession.getVariableField(IProjectVariables.DMPROPERTY, IProjectVariables.DMPROPERTY_FIELD_RE_PROMPT_NO_INPUT).setValue(initialPrompt);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Confirmation Reprompt No Input :: "+initialPrompt);
			
			mySession.getVariableField(IProjectVariables.DMPROPERTY, IProjectVariables.DMPROPERTY_FIELD_RE_PROMPT_NO_MATCH).setValue(initialPrompt);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Confirmation Reprompt No Match Prompt :: "+initialPrompt);
		} catch(Exception e) {
			StackTrace.PrintException(e);
		}
	}
			
	
	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-APR-28  01:19:12 PM
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
	 * Last generated by Orchestration Designer at: 2017-APR-28  01:19:12 PM
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
	 * Last generated by Orchestration Designer at: 2017-APR-28  01:19:12 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "EnterSIMNumber:ReturnCode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:success", true).setDebugId(5208)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("PlaySIM_MN", "Success").setDebugId(5210));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "APP_VARIABLE:TRIES ::->", "APP_VARIABLES:TRIES").setDebugId(6421));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "APP_VARIABLES:TRIES", com.avaya.sce.runtime.Expression.INT_GREATER_THAN, "1", false).setDebugId(5693)).evaluate(mySession)) {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "MAXTRY COUNT ::->", "APP_VARIABLES:TRIES").setDebugId(6422));
				actions.add(new com.avaya.sce.runtime.Next("MaxRetryDisconnect", "MaxTryDisc").setDebugId(5694));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			}

			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Increment("APP_VARIABLES:TRIES").setDebugId(5692));
			actions.add(new com.avaya.sce.runtime.Next("EnterAgain", "Error").setDebugId(5206));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}