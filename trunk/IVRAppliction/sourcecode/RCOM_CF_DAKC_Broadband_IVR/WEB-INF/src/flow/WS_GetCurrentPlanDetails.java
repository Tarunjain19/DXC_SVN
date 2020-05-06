package flow;

import java.util.ArrayList;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.bb.model.CurrentPlanInfo;
import com.rcom.bb.resource.IVRDBServiceInstance;
import com.rcom.broadband.Constants;
import com.rcom.broadband.DynamicMenu;
import com.rcom.broadband.StackTrace;
import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;

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
 * Last generated by Orchestration Designer at: 2015-MAY-24  04:33:25 PM
 */
public class WS_GetCurrentPlanDetails extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-24  04:33:25 PM
	 */
	public WS_GetCurrentPlanDetails() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	@Override
	public void requestBegin(SCESession mySession) {
	
		String DB_Result = Constants.FAILURE;
		AppProperties ivrProperties = null;
		String BAN = null;
		String responseCode = null;
		String currentPlan = null;
		IVRDataBean ivrDataBean = null;
		
		String appName = null;
		String key = null;
		String initialPrompt = null;
		ArrayList<String> dynamicList = new ArrayList<String>();
		
		try
		{
		
			ITraceInfo trace = mySession.getTraceOutput();
			ivrProperties = AppProperties.GetInstance(Constants.IVR_CONFIG);
			BAN = mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_BAN).getStringValue();
			appName = ivrProperties.getIVRProp(Constants.APP_NAME);
			
			/** getting the IVRData bean from session**/
			ivrDataBean = (IVRDataBean) mySession.getProperty(Constants.IVR_DATA_BEAN);
			
			
			CurrentPlanInfo currentPlanInfo = new CurrentPlanInfo();
			currentPlanInfo.setBAN(BAN);
			
			currentPlanInfo = IVRDBServiceInstance.getInstance().getCurrentPlanInfo(ivrDataBean, currentPlanInfo);
			
			if(currentPlanInfo.getRatePlan() != null)
			{
				
				DB_Result = Constants.SUCCESS;
				currentPlan = currentPlanInfo.getRatePlan();
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Rate Plan : " +currentPlan);
				
				if(null != currentPlan && !Constants.EMPTY.equalsIgnoreCase(currentPlan))
				{
				
					mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_RATE_PLAN_AVAILABLE).setValue(true);
					key = appName+Constants.HYPEN_SEPERATOR+Constants.DAKC_PA_0014;
					initialPrompt = ivrProperties.getIVRProp(key);
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Dynamic Prompt Key : "+key);
					dynamicList.add(currentPlan);
					
					/** Invoking the playPromt method **/
					initialPrompt = DynamicMenu.playPrompt(dynamicList, initialPrompt, Constants.NA, Constants.DAKC_PA_0014, trace);
					
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Initial Prompt returned from Dynamic formation : " +initialPrompt);
					
					mySession.getVariableField(IProjectVariables.DM__INPUT, IProjectVariables.DM__INPUT_FIELD_DM__INITIAL_PROMPT).setValue(initialPrompt);
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Initial Prompt :: "+initialPrompt);
				}
				else
				{
					mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_RATE_PLAN_AVAILABLE).setValue(false);
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Rate Plan not available. ");
				}
				
			}
			else
			{
				DB_Result = Constants.FAILURE;
			}
			
			mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_DB__RESULT).setValue(DB_Result);
			
		}catch(Exception e)
		{
			StackTrace.PrintException(e);
			mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_DB__RESULT).setValue(Constants.FAILURE);
		}
	}
	
	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2016-SEP-28  04:13:57 PM
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
	 * Last generated by Orchestration Designer at: 2016-SEP-28  04:13:57 PM
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
	 * Last generated by Orchestration Designer at: 2016-SEP-28  04:13:57 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "appVariables:DB_Result", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constants:success", true).setDebugId(5561)).evaluate(mySession)) {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "appVariables:IsRatePlanAvailable", com.avaya.sce.runtime.Expression.IS_TRUE).setDebugId(5564)).evaluate(mySession)) {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "TransferCodes:DAKC_TR_0017", false).setDebugId(8788));
				actions.add(new com.avaya.sce.runtime.Next("CurrentPlan_PP", "(Plan available)").setDebugId(5568));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "TransferCodes:DAKC_TR_0004", false).setDebugId(5567));
				actions.add(new com.avaya.sce.runtime.Next("Check_SRC", "(Plan not available)").setDebugId(5566));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


		} else {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "TransferCodes:DAKC_TR_0058", false).setDebugId(5563));
			actions.add(new com.avaya.sce.runtime.Next("Linkdown_PP", "(Failure)").setDebugId(2916));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}