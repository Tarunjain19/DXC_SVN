package flow;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.servion.util.AppConstant;
import com.servion.util.LoadProperty;
import com.servion.util.StackTrace;

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
 * Last generated by Orchestration Designer at: 2015-SEP-21  11:40:50 AM
 */
public class Date_Check extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-SEP-21  11:40:50 AM
	 */
	public Date_Check() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-SEP-06  02:38:39 PM
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
	 * Last generated by Orchestration Designer at: 2017-SEP-06  02:38:39 PM
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
	 * Last generated by Orchestration Designer at: 2017-SEP-06  02:38:39 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "COMP_DATE", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Today", false).setDebugId(825)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("BCHD_PA_0001_Welcome_Annce", "today").setDebugId(826));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "COMP_DATE", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "between", false).setDebugId(827)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("BCHD_PA_0001_Welcome_Annce", "between").setDebugId(828));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "COMP_DATE", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "before", false).setDebugId(829)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("BCHD_PA_0006_Welcome_383_Annce", "before").setDebugId(830));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition4", "COMP_DATE", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "after", false).setDebugId(831)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("BCHD_PA_0006_Welcome_383_Annce", "after").setDebugId(832));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("BCHD_PA_0006_Welcome_383_Annce", "nomatch").setDebugId(834));
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
		super.requestBegin(mySession);
		ITraceInfo trace = mySession.getTraceOutput();
		
		try{
			
			String start_date= LoadProperty.getivrconfigProp(AppConstant.START_DATE);
			String end_date=LoadProperty.getivrconfigProp(AppConstant.END_DATE);
			if(start_date==null)
			{
				// if date is not define in property file then default date is set which is confirmed by customer
				start_date="20151001";
			}
			if(end_date==null)
			{
				// if date is not define in property file then default date is set which is confirmed by customer
				end_date="20151130";
			}
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Start_date:: "+start_date);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "End _date:: "+end_date);

			Date date = Calendar.getInstance().getTime();
			
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			
			String cd=sdf.format(date);
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "End _time:: "+end_date);
			
			
			Date st=sdf.parse(start_date);
			Date ed =sdf.parse(end_date);
			Date td=sdf.parse(cd);
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "After format Start Date:: "+sdf.format(st));
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "After format End Date:: "+sdf.format(ed));
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "After format Today Date:: "+sdf.format(td));
			
			
			int i=td.compareTo(st);
			int j=td.compareTo(ed);
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Value Of I(ST):: "+i);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Value Of J(ED):: "+j);
			
		  // mySession.getVariable(IProjectVariables.COMP__START).getSimpleVariable().setValue(i);
		  // mySession.getVariable(IProjectVariables.COMP__END).getSimpleVariable().setValue(j);
			
			
			
			if((i==0)||(j==0))
			{
				 mySession.getVariable(IProjectVariables.COMP__DATE).getSimpleVariable().setValue("Today");
			}
			else if((i>0)&&(j<0))
			{
				//System.out.println(" today date is between  dates");
				 mySession.getVariable(IProjectVariables.COMP__DATE).getSimpleVariable().setValue("between");
			}
			else if((i<0) && (j<0))
			{
				//System.out.println(" today date is before both date");
				 mySession.getVariable(IProjectVariables.COMP__DATE).getSimpleVariable().setValue("before");
			}
			else if((i>0) && (j>0))
			{
				//System.out.println(" today date is after both date");
				 mySession.getVariable(IProjectVariables.COMP__DATE).getSimpleVariable().setValue("after");
			}
			
		}
		catch(Exception e){
			
			StackTrace.PrintException(e);
		}
	}

}