package flow;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.rbs.Constants;
import com.rcom.rbs.LoadProperties;
import com.rcom.rbs.Utilities;

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
 * Last generated by Orchestration Designer at: 2015-MAR-18  03:56:58 PM
 */
public class WithinBusinessHours_BC extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAR-18  03:56:58 PM
	 */
	public WithinBusinessHours_BC() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	//{SUN-1, MON-2, ...}
	//hourOfDay - 24h Format
	@Override
	public void requestBegin(SCESession mySession) {
		
		ITraceInfo trace = mySession.getTraceOutput();
		
		//AppProperties ivrProperties = AppProperties.GetInstance(Constants.PROPERTY_FILE_LOCATION);
		
		String startTime = LoadProperties.getivrconfigProp(Constants.START_TIME);
		String endTime = LoadProperties.getivrconfigProp(Constants.END_TIME);
		String workingDays = LoadProperties.getivrconfigProp(Constants.WORKING_DAYS);
		String[] workingDaysOfWeek = workingDays.split(Constants.PIPE_SEPERATOR);
		
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Working days : " +workingDays);
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Working hours : " +startTime + "-" + endTime);
		
		boolean isBusinessHour = Utilities.isBusinessHour(null, workingDaysOfWeek, startTime, endTime);
		
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Is Business Hour : " +isBusinessHour);
		
		if(isBusinessHour)
		{
			mySession.getVariableField(IProjectVariables.CONSTANTS, IProjectVariables.CONSTANTS_FIELD_IS_CALLED_WITHIN_BUSINESS_HOURS).setValue(true);
		}
		else
		{
			mySession.getVariableField(IProjectVariables.CONSTANTS, IProjectVariables.CONSTANTS_FIELD_IS_CALLED_WITHIN_BUSINESS_HOURS).setValue(false);
		}
		
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Within Business Hour : " +mySession.getVariableField(IProjectVariables.CONSTANTS, IProjectVariables.CONSTANTS_FIELD_IS_CALLED_WITHIN_BUSINESS_HOURS).getBooleanValue());
		
	}
	
	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2020-FEB-26  04:34:25 PM
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
	 * Last generated by Orchestration Designer at: 2020-FEB-26  04:34:25 PM
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
	 * Last generated by Orchestration Designer at: 2020-FEB-26  04:34:25 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "Constants:IsCalledWithinBusinessHours", com.avaya.sce.runtime.Expression.IS_TRUE).setDebugId(13)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("BusinessHour_PP", "Yes").setDebugId(14));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("NonBusinessHour_PP", "No").setDebugId(11));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
