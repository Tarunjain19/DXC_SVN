package flow;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.broadband.Constants;
import com.rcom.broadband.StackTrace;
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
 * Last generated by Orchestration Designer at: 2015-MAY-24  03:36:50 PM
 */
public class SetPaymentFailureReason extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-24  03:36:50 PM
	 */
	public SetPaymentFailureReason() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	@Override
	public void requestBegin(SCESession mySession) {
	
		AppProperties ivrProperties = null;
		
		
		try
		{
		
			ITraceInfo trace = mySession.getTraceOutput();
			ivrProperties = AppProperties.GetInstance(Constants.IVR_CONFIG);
			
			String pmtRetCode = mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_PAYMENT_RETURNCODE).getStringValue();
			String initialPrompt = null;
			String announceID = null;
			
			if(pmtRetCode.equalsIgnoreCase(Constants.PAYMENT_RETURN_CODE_MINUS_ONE) || pmtRetCode.equalsIgnoreCase(Constants.PAYMENT_RETURN_CODE_ONE) || pmtRetCode.equalsIgnoreCase(Constants.PAYMENT_RETURN_CODE_399))
			{
				initialPrompt = ivrProperties.getIVRProp(Constants.PAYMENT_RETURN_CODE + Constants.UNDERSCORE + Constants.PAYMENT_RETURN_CODE_399);
				announceID = ivrProperties.getIVRProp(Constants.PAYMENT_RETURN_CODE + Constants.UNDERSCORE + Constants.ANNOUNCE_ID + Constants.PAYMENT_RETURN_CODE_399);
				
			}else if (pmtRetCode.equalsIgnoreCase(Constants.PAYMENT_RETURN_CODE_9) || pmtRetCode.equalsIgnoreCase(Constants.PAYMENT_RETURN_CODE_0001))
			{
				initialPrompt = ivrProperties.getIVRProp(Constants.PAYMENT_RETURN_CODE + Constants.UNDERSCORE + Constants.PAYMENT_RETURN_CODE_0001);
				announceID = ivrProperties.getIVRProp(Constants.PAYMENT_RETURN_CODE + Constants.UNDERSCORE + Constants.ANNOUNCE_ID + Constants.PAYMENT_RETURN_CODE_0001);
				
			}else if(pmtRetCode.equalsIgnoreCase(Constants.PAYMENT_RETURN_CODE_MINUS_TWO) || pmtRetCode.equalsIgnoreCase(Constants.PAYMENT_RETURN_CODE_0002)){
				
				initialPrompt = ivrProperties.getIVRProp(Constants.PAYMENT_RETURN_CODE + Constants.UNDERSCORE + Constants.PAYMENT_RETURN_CODE_0002);
				announceID = ivrProperties.getIVRProp(Constants.PAYMENT_RETURN_CODE + Constants.UNDERSCORE + Constants.ANNOUNCE_ID + Constants.PAYMENT_RETURN_CODE_0002);
				
			}else
			{
				initialPrompt = ivrProperties.getIVRProp(Constants.PAYMENT_RETURN_CODE_NA);
				announceID = ivrProperties.getIVRProp(Constants.PAYMENT_RETURN_CODE + Constants.UNDERSCORE + Constants.ANNOUNCE_ID + Constants.PAYMENT_RETURN_CODE_NA);
			}
			
			mySession.getVariableField(IProjectVariables.DM__INPUT, IProjectVariables.DM__INPUT_FIELD_DM__INITIAL_PROMPT).setValue(initialPrompt);
			mySession.getVariableField(IProjectVariables.DM__INPUT, IProjectVariables.DM__INPUT_FIELD_DM__ANNOUNCE_ID).setValue(announceID);
			
		}catch(Exception e)
		{
			StackTrace.PrintException(e);
		}
		
		
	}
	
	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2016-SEP-28  04:13:57 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("PaymentFailureReason_PP", "Success");
		next.setDebugId(4607);
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
		actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "TransferCodes:DAKC_TR_0022", false).setDebugId(8787));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}