package flow;



import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.util.AppConstant;
import com.servion.util.AppProperties;
import com.rcom.util.Utilities;

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
 * Last generated by Orchestration Designer at: 2015-SEP-29  05:40:31 PM
 */
public class CheckCategory extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-SEP-29  05:40:31 PM
	 */
	public CheckCategory() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-MAR-24  10:30:22 AM
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
	 * Last generated by Orchestration Designer at: 2017-MAR-24  10:30:22 AM
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
	 * Last generated by Orchestration Designer at: 2017-MAR-24  10:30:22 AM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(2);
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "Category :: ", "appVariables:category").setDebugId(5659));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "appVariables:category", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:S", true).setDebugId(5496)).evaluate(mySession)) {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "Constants:isCalledWithInBussinessHours", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:Key_true", true).setDebugId(5503)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("Transfer_Msg", "AgentTransfer").setDebugId(5500));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("TransferAgent_PP", "S_TransferAgent_PP").setDebugId(5505));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


		} else {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "Constants:isCalledWithInBussinessHours", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:Key_true", true).setDebugId(5512)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("Transfer_Msg", "AgentTransfer").setDebugId(5515));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("E_D_TransferAgent_PP", "E_D_TransferAgent_PP").setDebugId(5514));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}

		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
	
	@Override
	public void requestBegin(SCESession mySession) {
		/*ITraceInfo trace = mySession.getTraceOutput();
		
		AppProperties ivrProperties = AppProperties.GetInstance(AppConstant.PROPERTY_FILE_PATH);
		
		String startTime = ivrProperties.getIVRProp(AppConstant.START_TIME);
		String endTime = ivrProperties.getIVRProp(AppConstant.END_TIME);
		String workingDays = ivrProperties.getIVRProp(AppConstant.WORKING_DAYS);
		String[] workingDaysOfWeek = workingDays.split(AppConstant.PIPE_SEPERATOR);
		
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Working days : " +workingDays);
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Working hours : " +startTime + "-" + endTime);
		
		boolean isBusinessHour = Utilities.isBusinessHour(null, workingDaysOfWeek, startTime, endTime);
		
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Is Business Hour : " +isBusinessHour);
		
		if(isBusinessHour)
		{
			mySession.getVariableField(IProjectVariables.CONSTANTS, IProjectVariables.CONSTANTS_FIELD_IS_CALLED_WITH_IN_BUSSINESS_HOURS).setValue(true);
		}
		else
		{
			mySession.getVariableField(IProjectVariables.CONSTANTS, IProjectVariables.CONSTANTS_FIELD_IS_CALLED_WITH_IN_BUSSINESS_HOURS).setValue(false);
		}
		
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Within Business Hour : " +mySession.getVariableField(IProjectVariables.CONSTANTS, IProjectVariables.CONSTANTS_FIELD_IS_CALLED_WITH_IN_BUSSINESS_HOURS).getBooleanValue());
		*/
		
		
		ITraceInfo trace = mySession.getTraceOutput();
	
		String category = mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_CATEGORY).getStringValue();
		
		AppProperties ivrProperties = AppProperties.GetInstance(AppConstant.IVR_CONFIG);
		
		String holidayValue =  ivrProperties.getIVRProp(AppConstant.HOLIDAY);
		String[] holidays = holidayValue.split(AppConstant.PIPE);
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Holidays : " +holidayValue);
		
		
		String dmPropertyFileName = null;
		if(category.equalsIgnoreCase(AppConstant.CONST_S))
		{
			String workingDaysValue = ivrProperties.getIVRProp(AppConstant.CATEGORY_S_WORKING_DAYS);
			String[] workingDays = workingDaysValue.split(AppConstant.SEPERATOR_PIPE);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Category S Working Days : " +workingDaysValue);
			
			String startTime = ivrProperties.getIVRProp(AppConstant.S_START_TIME);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Category S Start Time : " +startTime);
			
			String endTime = ivrProperties.getIVRProp(AppConstant.S_END_TIME);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Category S End Time : " +endTime);
			
			boolean isBusinessHour = Utilities.isBusinessHour(holidays,workingDays, startTime, endTime);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Category S Is In Business Hour : " +isBusinessHour);
			
			mySession.getVariableField(IProjectVariables.CONSTANTS, IProjectVariables.CONSTANTS_FIELD_IS_CALLED_WITH_IN_BUSSINESS_HOURS).setValue(isBusinessHour);
			
		}
		else
		{
			String workingDaysValue = ivrProperties.getIVRProp(AppConstant.CATEGORY_E_D_WORKING_DAYS);
			String[] workingDays = workingDaysValue.split(AppConstant.SEPERATOR_PIPE);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Category E and D Working Days : " +workingDaysValue);
			
			String startTime = ivrProperties.getIVRProp(AppConstant.E_D_START_TIME);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Category E and D Start Time : " +startTime);
			
			String endTime = ivrProperties.getIVRProp(AppConstant.E_D_END_TIME);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Category E and D End Time : " +endTime);
			
			boolean isBusinessHour = Utilities.isBusinessHour(holidays, workingDays, startTime, endTime);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Category E and D Is In Business Hour : " +isBusinessHour);
			
			mySession.getVariableField(IProjectVariables.CONSTANTS, IProjectVariables.CONSTANTS_FIELD_IS_CALLED_WITH_IN_BUSSINESS_HOURS).setValue(isBusinessHour);
		}
		

	}
}
