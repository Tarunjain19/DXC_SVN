package flow;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.bb.model.BANDetails;
import com.rcom.bb.model.ValidatePrepaidBBInfo;
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
 * Last generated by Orchestration Designer at: 2015-JUN-18  12:14:32 PM
 */
public class DB_AccessDSS_PrepaidInfo extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-JUN-18  12:14:32 PM
	 */
	public DB_AccessDSS_PrepaidInfo() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	
	@Override
	public void requestBegin(SCESession mySession) {
	
		String DB_Result = Constants.FAILURE;
		String prepaidInput = null;
		String verifiedFlag = null;
		IVRDataBean ivrDataBean = null;
		
		String BAN = null;
		
		try
		{
			
			ITraceInfo trace = mySession.getTraceOutput();
			/** getting the IVRData bean from session**/
			ivrDataBean = (IVRDataBean) mySession.getProperty(Constants.IVR_DATA_BEAN);
			
			prepaidInput = mySession.getVariableField(IProjectVariables.GET_PREPAID_INFO__PC, IProjectVariables.GET_PREPAID_INFO__PC_FIELD_VALUE).getStringValue();
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Prepaid Info Entered by caller : " +prepaidInput);
			
			ValidatePrepaidBBInfo validatePrepaidBBInfo = new ValidatePrepaidBBInfo();
			validatePrepaidBBInfo.setUserValue(prepaidInput);
			
			validatePrepaidBBInfo = IVRDBServiceInstance.getInstance().validatePrepaidBBInfo(ivrDataBean, validatePrepaidBBInfo);
			
			verifiedFlag = validatePrepaidBBInfo.getFlag();
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "verifiedFlag : " +verifiedFlag);
			
			if(verifiedFlag != null && !Constants.EMPTY.equalsIgnoreCase(verifiedFlag))
			{
				
				if(verifiedFlag.equalsIgnoreCase(Constants.VERIFIED))
				{
					DB_Result = Constants.SUCCESS; 
					mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_PREPAID_INFO_VERIFIED).setValue(true);
					
					
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "verifiedFlag : " +verifiedFlag);
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Hence trying to get BAN.");
					
					BANDetails banDetails = new BANDetails();
					
					banDetails.setCli(prepaidInput);
					
					banDetails = IVRDBServiceInstance.getInstance().getBanDetails(ivrDataBean, banDetails);
					BAN = banDetails.getBan();
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "BAN : " +BAN);
					if(BAN != null && !Constants.EMPTY.equalsIgnoreCase(BAN))
					{
						DB_Result = Constants.SUCCESS;
						
						mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_POTSBIA__INPUT).setValue(prepaidInput);
						mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_BAN).setValue(BAN);
						mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_CBB__INPUT).setValue(BAN);
						
					}
					else
					{
						mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_PREPAID_INFO_VERIFIED).setValue(false);
						DB_Result = Constants.FAILURE;
					}
					
				}
				else
				{
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "verifiedFlag : " +verifiedFlag);
					mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_PREPAID_INFO_VERIFIED).setValue(false);
					
					DB_Result = Constants.SUCCESS;
				}	
			}
			else
			{
				DB_Result = Constants.FAILURE;
			}
			
			
			mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_DB__RESULT).setValue(DB_Result);
			
		} catch (Exception e)
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

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "appVariables:DB_Result", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constants:success", true).setDebugId(9728)).evaluate(mySession)) {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "appVariables:IsPrepaidInfoVerified", com.avaya.sce.runtime.Expression.IS_TRUE).setDebugId(9730)).evaluate(mySession)) {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:fromPrepaidMenu", "true", true).setDebugId(12111));
				actions.add(new com.avaya.sce.runtime.Next("chkCirclePre", "(Correct)").setDebugId(9731));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {

				if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "appVariables:tries", com.avaya.sce.runtime.Expression.STRING_EQUAL, "constants:Three", true).setDebugId(9733)).evaluate(mySession)) {
					actions = new java.util.ArrayList(2);
					actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:fromPrepaidMenu", "true", true).setDebugId(12112));
					actions.add(new com.avaya.sce.runtime.Next("chkCirclePre", "(Repeat Tries Exceeded)").setDebugId(9734));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;

				} else {
					actions = new java.util.ArrayList(2);
					actions.add(new com.avaya.sce.runtime.varoperations.Increment("appVariables:tries").setDebugId(9736));
					actions.add(new com.avaya.sce.runtime.Next("PrepaidInfo_InvalidEntry_PP", "(Incorrect)").setDebugId(9737));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;
				}

			}


		} else {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "TransferCodes:DAKC_TR_0077", false).setDebugId(9880));
			actions.add(new com.avaya.sce.runtime.Next("Check_SRC", "(Failure)").setDebugId(9719));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}