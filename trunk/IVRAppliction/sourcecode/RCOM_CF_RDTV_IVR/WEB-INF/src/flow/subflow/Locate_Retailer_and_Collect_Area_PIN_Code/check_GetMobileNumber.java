package flow.subflow.Locate_Retailer_and_Collect_Area_PIN_Code;

import java.util.ArrayList;
import java.util.List;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.rdtv.util.AppConstants;
import com.rcom.rdtv.util.DynamicMenu;
import com.rcom.rdtv.util.StackTrace;
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
 * Last generated by Orchestration Designer at: 2015-MAY-26  05:56:47 PM
 */
public class check_GetMobileNumber extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-26  05:56:47 PM
	 */
	public check_GetMobileNumber() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:56 PM
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
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:56 PM
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
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:56 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(3);
		actions.add(new com.avaya.sce.runtime.varoperations.Assign("Global_Counter:Max_NoMatch", "GetMobileNumber:NomatchRemaining", false).setDebugId(1431));
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "Get_MobileNumber ReturnCode :: ", "Get_MobileNumber:ReturnCode").setDebugId(285));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "Get_MobileNumber:ReturnCode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "CONSTANTS:SUCCESS", true).setDebugId(286)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "Get_MobileNumber Value :: ", "Get_MobileNumber:Value").setDebugId(896));
			actions.add(new com.avaya.sce.runtime.Next("Locate_Retailer_and_Collect_Area_PIN_Code-Confirm_MobileNumber", "success").setDebugId(895));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("Locate_Retailer_and_Collect_Area_PIN_Code-tries_exceed", "tries-exceed").setDebugId(898));
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
		ITraceInfo trace = mySession.getTraceOutput();
		
		String mobileNumber,appName,initialPrompt,key = null;
		List<String> dynamicList = new ArrayList<>();
		try
		{
			if(AppConstants.Success.equalsIgnoreCase(mySession.getVariableField(IProjectVariables.GET__MOBILE_NUMBER, IProjectVariables.GET__MOBILE_NUMBER_FIELD_RETURN_CODE).getStringValue()))
			{
				/** Forming the Dynamic Prompt **/
				appName = mySession.getVariableField(IProjectVariables.APP__NAME).getStringValue();
				mobileNumber = mySession.getVariableField(IProjectVariables.GET__MOBILE_NUMBER, IProjectVariables.GET__MOBILE_NUMBER_FIELD_VALUE).getStringValue();
				key = appName+AppConstants.SEPERATOR_HYPEN+AppConstants.RD01_MN_0028;
				initialPrompt = AppProperties.GetInstance(AppConstants.IVR_CONFIG_PROPERTIES).getIVRProp(key);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Dynamic Prompt Key "+AppConstants.RD01_MN_0028+" :: "+key);
				dynamicList.add(mobileNumber);
				
				/** Invoking the playPromt method **/
				initialPrompt = DynamicMenu.playPrompt(dynamicList, initialPrompt, AppConstants.NA, AppConstants.RD01_MN_0028, trace);
				mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER, IProjectVariables.DM_INPUT_PARAMETER_FIELD_INITIAL_PROMPT).setValue(initialPrompt);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Confirmation Initial Prompt "+AppConstants.RD01_MN_0028+" :: "+initialPrompt);
			}		
		}catch(Exception e)
		{
		StackTrace.PrintException(e);
		}
		finally
		{initialPrompt = null;mobileNumber = null;appName=null;key=null;dynamicList=null;}
	}
}
