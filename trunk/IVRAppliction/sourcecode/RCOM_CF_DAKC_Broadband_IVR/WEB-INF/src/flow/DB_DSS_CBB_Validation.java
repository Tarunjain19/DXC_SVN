package flow;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.bb.model.CBBInfo;
import com.rcom.bb.resource.IVRDBServiceInstance;
import com.rcom.broadband.Constants;
import com.rcom.broadband.StackTrace;
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
 * Last generated by Orchestration Designer at: 2015-MAY-24  04:58:39 PM
 */
public class DB_DSS_CBB_Validation extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-24  04:58:39 PM
	 */
	public DB_DSS_CBB_Validation() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	@Override
	public void requestBegin(SCESession mySession) {
	
		String DB_Result = Constants.FAILURE;
		String CBB_Input = null;
		String responseCode = null;
		String cbbFlag = null;
		IVRDataBean ivrDataBean = null;
		
		
		try
		{
		
			ITraceInfo trace = mySession.getTraceOutput();
			CBB_Input = mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_CBB__INPUT).getStringValue();
			
			/** getting the IVRData bean from session**/
			ivrDataBean = (IVRDataBean) mySession.getProperty(Constants.IVR_DATA_BEAN);
			
			
			CBBInfo cbbInfo = new CBBInfo();
			cbbInfo.setBan(CBB_Input);
			
			
			cbbInfo = IVRDBServiceInstance.getInstance().getCBBInfo(ivrDataBean, cbbInfo);
			
			if(cbbInfo.getFlag() != null && !Constants.EMPTY.equalsIgnoreCase(cbbInfo.getFlag()))
			{
				
				DB_Result = Constants.SUCCESS;
				cbbFlag = cbbInfo.getFlag();
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "CBB Flag : " +cbbFlag);
				
				
				if(cbbFlag.equalsIgnoreCase(Constants.CBB))
				{
					mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_CBB__STATUS).setValue(mySession.getVariableField(IProjectVariables.CONSTANTS, IProjectVariables.CONSTANTS_FIELD_CBB__STATUS__SUCCESS).getStringValue());
				}
				else
				{
					mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_CBB__STATUS).setValue(mySession.getVariableField(IProjectVariables.CONSTANTS, IProjectVariables.CONSTANTS_FIELD_CBB__STATUS__FAILURE).getStringValue());
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

		actions = new java.util.ArrayList(2);
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "CBB Status :", "appVariables:CBB_Status").setDebugId(12061));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "appVariables:DB_Result", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constants:success", true).setDebugId(5890)).evaluate(mySession)) {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "appVariables:CBB_Status", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constants:CBB_Status_Success", true).setDebugId(5893)).evaluate(mySession)) {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "TransferCodes:DAKC_TR_0005", false).setDebugId(5899));
				actions.add(new com.avaya.sce.runtime.Next("Check_SRC", "(CBB Success)").setDebugId(5894));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "TransferCodes:DAKC_TR_0006", false).setDebugId(5900));
				actions.add(new com.avaya.sce.runtime.Next("Check_SRC", "(CBB Failure)").setDebugId(5896));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


		} else {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "TransferCodes:DAKC_TR_0059", false).setDebugId(5892));
			actions.add(new com.avaya.sce.runtime.Next("Linkdown_PP", "(Host timeout)").setDebugId(5883));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
