package flow;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.rdtv.util.AppConstants;
import com.rcom.rdtv.util.SayItSmartTime;
import com.rcom.rdtv.util.StackTrace;
import com.servion.rdtv.hostinterface.TransAccountDetails;
import com.servion.rdtv.hostservice.ReqAccountDetails;
import com.servion.rdtv.hostservice.ResAccountDetails;
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
 * Last generated by Orchestration Designer at: 2015-SEP-08  03:47:17 PM
 */
public class WS_BalanceCheck extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-SEP-08  03:47:17 PM
	 */
	public WS_BalanceCheck() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}
	
	@Override
	public void requestBegin(SCESession mySession) {
		ITraceInfo trace = mySession.getTraceOutput();
		String accountBalance = null;
		String smartCardNumber = null;
		String mrp = null;
		ReqAccountDetails reqAccountDetails = null;
		ResAccountDetails resAccountDetails = null;
		TransAccountDetails transAccountDetails = null;
		try
		{
		
		/** WS-GetAccountDetails Request Formation **/
		smartCardNumber = mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_SCNUMBER).getStringValue();
		reqAccountDetails = new ReqAccountDetails();
		reqAccountDetails.setAccountId(smartCardNumber);
		reqAccountDetails.setStartDate(SayItSmartTime.accountDetailsDateFormat());
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "GetAccountDetails Host Request :: "+reqAccountDetails.toString());
		
		/** WS Host Interaction **/
		transAccountDetails = new TransAccountDetails();
		resAccountDetails = transAccountDetails.getHostInterface((IVRDataBean) mySession.getProperty(AppConstants.IVRDATABEAN), reqAccountDetails);
		
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "GetAccountDetails Host Response :: "+resAccountDetails.toString());
		if(resAccountDetails.getResponseCode().equalsIgnoreCase(AppConstants.zero) && resAccountDetails.getAccBalance() != null)
		{
			mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_HOST_FAILURE).setValue(AppConstants.No);
			accountBalance = resAccountDetails.getAccBalance();	
			mrp = mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_DENOMINATION).getStringValue();
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Account Balance :: "+resAccountDetails.toString());
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "MRP :: "+mrp);
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Double.valueOf(accountBalance) >= Double.valueOf(mrp) :: "+(Double.valueOf(accountBalance) >= Double.valueOf(mrp)));
			
			if(Double.valueOf(accountBalance) >= Double.valueOf(mrp))
			{
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Double value ::true ");
				mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_BALANCE_AVAILABLE_TO_BUY).setValue(true);
			}
			else
			{
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Double value ::falae ");
				mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_BALANCE_AVAILABLE_TO_BUY).setValue(false);
			}
			
			
		}
		else
			mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_HOST_FAILURE).setValue(AppConstants.Yes);
		
	}catch(Exception e)
	{mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_HOST_FAILURE).setValue(AppConstants.Yes);
	StackTrace.PrintException(e);
	}
	finally
	{accountBalance = null;reqAccountDetails=null;resAccountDetails=null;transAccountDetails=null;smartCardNumber=null;}
	}
	

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:42 PM
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
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:42 PM
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
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:42 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "AppVariables:IsHostFailure", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "CONSTANTS:YES", true).setDebugId(8152)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("AppVariables:TransferPoint", "TransferPoints:RD01_TR_0055", false).setDebugId(8153));
			actions.add(new com.avaya.sce.runtime.Next("LinkDownAnnc", "(Linkdown)").setDebugId(8154));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "AppVariables:IsBalanceAvailableToBuy", com.avaya.sce.runtime.Expression.IS_TRUE).setDebugId(8156)).evaluate(mySession)) {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("AppVariables:IsBalanceAvailableToBuy", "false", true).setDebugId(8359));
				actions.add(new com.avaya.sce.runtime.Next("DB_LogPurchaseRequest", "(Balance Available)").setDebugId(8157));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {

				if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "Seasonalpack_ToRecharge_Flag", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "CONSTANTS:TRUE", true).setDebugId(9651)).evaluate(mySession)) {
					actions = new java.util.ArrayList(3);
					actions.add(new com.avaya.sce.runtime.varoperations.Assign("Seasonalpack_ToRecharge_Flag", "CONSTANTS:FALSE", false).setDebugId(9654));
					actions.add(new com.avaya.sce.runtime.varoperations.Assign("AppVariables:FromBalanceCheckFlow", "true", true).setDebugId(9653));
					actions.add(new com.avaya.sce.runtime.Next("SeasonalPack_RechargeOption", "SeasonalPack_ToRecharge").setDebugId(9652));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;

				}

				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("AppVariables:FromBalanceCheckFlow", "true", true).setDebugId(8371));
				actions.add(new com.avaya.sce.runtime.Next("SF_RechargeAccount", "(Balance Not Available)").setDebugId(8159));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}

		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
