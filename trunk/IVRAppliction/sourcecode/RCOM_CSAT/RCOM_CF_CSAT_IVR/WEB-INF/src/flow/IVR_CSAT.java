package flow;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.Data.utils.AppConstant;
import com.rcom.Data.utils.Constants;
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
 * Last generated by Orchestration Designer at: 2016-MAR-10  03:17:24 PM
 */
public class IVR_CSAT extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2016-MAR-10  03:17:24 PM
	 */
	public IVR_CSAT() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2016-APR-11  05:10:39 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("Play_CSAT", "Default");
		next.setDebugId(3706);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2016-APR-11  05:10:39 PM
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
	 * Last generated by Orchestration Designer at: 2016-APR-11  05:10:39 PM
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
		
		ITraceInfo trace =null;
		
		trace = mySession.getTraceOutput();
		
		
		try{
			
		String DNIS_KEY=mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_DNIS).getStringValue();	
		
		 trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"DNIS_KEY is :"+DNIS_KEY);
		
	    String Key_Value=AppProperties.GetInstance(AppConstant.IVR_CSAT_CONFIG).getIVRProp(DNIS_KEY);
		
	    trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Key_Value is :"+Key_Value);
	
		String ar1[]=Key_Value.split("\\|");
		
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"ar1 Length is :"+ar1.length);
		
		if(ar1.length>0)
		{
		 
			mySession.getVariableField(IProjectVariables.FLAG,IProjectVariables.FLAG_FIELD_ARRAY_COUNT).setValue(ar1.length);
			mySession.getVariableField(IProjectVariables.FLAG,IProjectVariables.FLAG_FIELD_ARRAY_VALUE).setValue(Key_Value);
			
			
			
			for(int i=0;i<ar1.length;i++)
			{
				
				System.out.println("Arrey is "+ar1[i]);
				
				String Ar2[]=ar1[i].split("\\*");
				System.out.println("Ar2 is "+Ar2.length);
				
				for(int j=0;j<Ar2.length;j++)
				{
					System.out.println("Q is "+Ar2[j]);
					
				}
				
				
			}
		}
		
		
		
	}
	
	catch (Exception e) {
		//strDefaultLanguage = Constants.ENG;
		StackTrace.PrintException(e);
		mySession.getVariableField(IProjectVariables.FLAG,IProjectVariables.FLAG_FIELD_ARRAY_COUNT).setValue(0);
		mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_IS_LINK_DOWN).setValue(Constants.Yes);
	}
	}
	
}
