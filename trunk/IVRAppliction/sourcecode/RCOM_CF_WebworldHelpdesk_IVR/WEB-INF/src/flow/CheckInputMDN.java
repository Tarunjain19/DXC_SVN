package flow;



import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.webworld.util.AppConstant;
import com.webworld.util.AppProperties;
import com.webworld.util.StackTrace;



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
 * Last generated by Orchestration Designer at: 2015-APR-03  06:17:40 PM
 */
public class CheckInputMDN extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-APR-03  06:17:40 PM
	 */
	public CheckInputMDN() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-JUN-16  11:10:54 AM
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
	 * Last generated by Orchestration Designer at: 2017-JUN-16  11:10:54 AM
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
	 * Last generated by Orchestration Designer at: 2017-JUN-16  11:10:54 AM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(2);
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "WHIVR_MN_0004 Menu Return Code : : ", "RSNStatus_CollectMDN:ReturnCode").setDebugId(1093));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "RSNStatus_CollectMDN:ReturnCode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:success", true).setDebugId(1094)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "WHIVR_MN_0004 Menu Value  : : ", "RSNStatus_CollectMDN:Value").setDebugId(1095));
			actions.add(new com.avaya.sce.runtime.Next("WHIVR_MN_0005_Menu", "valid").setDebugId(2107));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:reasonCode", "constant:WHIVR_TR_0008", false).setDebugId(2130));
			actions.add(new com.avaya.sce.runtime.Next("Transfer_Agent", "invalid").setDebugId(2109));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
	
	
	@SuppressWarnings("static-access")
	@Override
	public void requestBegin(SCESession mySession) {
		ITraceInfo trace = mySession.getTraceOutput();
		String key = null,mdn = null,appName = null,initialPrompt = null;
		String []dynamicList = new String[1];
		
		if(mySession.getVariableField(IProjectVariables.RSNSTATUS__COLLECT_MDN, IProjectVariables.RSNSTATUS__COLLECT_MDN_FIELD_RETURN_CODE).getStringValue().equalsIgnoreCase(AppConstant.Success)){
			try
			{	/** Forming the Dynamic Prompt **/
				appName = mySession.getVariableField(IProjectVariables.APP__NAME).getStringValue();
				mdn = mySession.getVariableField(IProjectVariables.RSNSTATUS__COLLECT_MDN,IProjectVariables.RSNSTATUS__COLLECT_MDN_FIELD_VALUE).getStringValue();
				key = AppConstant.WHIVR_MN_0005;
				initialPrompt = AppProperties.getInstance().getivrconfigProp(key);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Dynamic Prompt Key "+AppConstant.WHIVR_MN_0005+" :: "+key);
				dynamicList[AppConstant.Zero] = mdn;
				
				/** Invoking the playPrompt method **/
				
				initialPrompt = initialPrompt.replaceAll(AppConstant.MDN, mdn);
				mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER, IProjectVariables.DM_INPUT_PARAMETER_FIELD_INITIAL_PROMPT).setValue(initialPrompt);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Confirmation Initial Prompt "+AppConstant.WHIVR_MN_0005+" :: "+initialPrompt);
				
			}catch(Exception e)
			{mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_EXCEPTION).setValue(AppConstant.Yes);
			StackTrace.PrintException(e);}
			finally
			{initialPrompt = null;mdn = null;appName=null;key=null;dynamicList=null;}
		}
		
	}

}
