package flow;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.Data.utils.StackTrace;

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
 * Last generated by Orchestration Designer at: 2016-APR-08  04:59:55 PM
 */
public class Check_Time extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2016-APR-08  04:59:55 PM
	 */
	public Check_Time() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-APR-28  01:19:14 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("Welcome_4GSIM_PA_0001", "Default");
		next.setDebugId(4347);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2017-APR-28  01:19:14 PM
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
	 * Last generated by Orchestration Designer at: 2017-APR-28  01:19:14 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
	
	@Override
	public void requestBegin(SCESession mySession) {
		super.requestBegin(mySession);
		ITraceInfo info = mySession.getTraceOutput();

		try {
			
			int hour=10;
			
			Calendar C = new GregorianCalendar();
			hour = C.get(Calendar.HOUR_OF_DAY);
			info.writeln(ITraceInfo.TRACE_LEVEL_INFO,"hour is :"+hour);
			if(hour<12)
			{
				info.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Morning Prompts :");	
			   mySession.getVariableField(IProjectVariables.DMPROPERTY, IProjectVariables.DMPROPERTY_FIELD_INITIAL_PROMPT).setValue("45000.wav");
			
			}
			else if (hour>12 && hour<16)
			{
				info.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Afternoon Prompts :");	
			    mySession.getVariableField(IProjectVariables.DMPROPERTY, IProjectVariables.DMPROPERTY_FIELD_INITIAL_PROMPT).setValue("45000.wav");
				
			}
			else
			{
				info.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Eve Prompts :");	
			    mySession.getVariableField(IProjectVariables.DMPROPERTY, IProjectVariables.DMPROPERTY_FIELD_INITIAL_PROMPT).setValue("45000.wav");
				
			}
		}
		catch (Exception e) {
			StackTrace.PrintException(e);
		}
		
		}
}