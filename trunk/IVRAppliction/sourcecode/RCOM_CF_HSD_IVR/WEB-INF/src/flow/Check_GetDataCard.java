package flow;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.prepaid.model.ValidateDataCardNumberHSD;
import com.rcom.prepaid.resource.IVRDBServiceInstance;
import com.servion.hsd.utils.AppConstant;
import com.servion.hsd.utils.StackTrace;
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
 * Last generated by Orchestration Designer at: 2015-AUG-25  04:06:58 PM
 */
public class Check_GetDataCard extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-AUG-25  04:06:58 PM
	 */
	public Check_GetDataCard() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:38:57 PM
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
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:38:57 PM
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
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:38:57 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(2);
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "GetDataCard ReturnCode :: ", "GetDataCard:ReturnCode").setDebugId(9958));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "AppVariables:HostResult", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:error", true).setDebugId(9975)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("AppVariables:TransferPoint", "TransferPoints:HSDI_TR_0006", false).setDebugId(9977));
			actions.add(new com.avaya.sce.runtime.Next("LinkDownAnnc", "linkdown").setDebugId(9978));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "GetDataCard:ReturnCode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "CONSTANTS:SUCCESS", true).setDebugId(9960)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "GetDataCard Value :: ", "GetDataCard:Value").setDebugId(9959));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

				if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "AppVariables:HostResult", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:failure", true).setDebugId(10105)).evaluate(mySession)) {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.Next("Check_Tries", "Retry").setDebugId(10106));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;

				} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition4", "Flag:Is4gLTE", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:yes", true).setDebugId(10109)).evaluate(mySession)) {
					actions = new java.util.ArrayList(2);
					actions.add(new com.avaya.sce.runtime.varoperations.Assign("HotFlashInfo:annoID", "HotFlashIDs:HSDI_PA_0061", false).setDebugId(10111));
					actions.add(new com.avaya.sce.runtime.Next("Call_HF", "4GLTE").setDebugId(10112));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;

				} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition5", "Flag:IsPrepaid", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:yes", true).setDebugId(10076)).evaluate(mySession)) {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.Next("Prepaid", "prepaid").setDebugId(10077));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;

				} else {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.Next("Postpaid", "postpaid").setDebugId(9965));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;
				}


			} else {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("AppVariables:TransferPoint", "TransferPoints:HSDI_TR_0005", false).setDebugId(9971));
				actions.add(new com.avaya.sce.runtime.Next("ThankYouAnnc", "tries_exceed").setDebugId(9972));
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
		ITraceInfo trace = mySession.getTraceOutput();
		String returnCode = AppConstant.EMPTY_STRING,value= AppConstant.EMPTY_STRING,hostOutput = AppConstant.Failure;
		ValidateDataCardNumberHSD validateDataCardNumber = null;
		String dataCardNumber = AppConstant.EMPTY_STRING;
		

		try
		{
		returnCode = mySession.getVariableField(IProjectVariables.GET_DATA_CARD, IProjectVariables.GET_DATA_CARD_FIELD_RETURN_CODE).getStringValue();
		if(returnCode.equalsIgnoreCase(AppConstant.Success))
		{
			/** Request Forming **/
			validateDataCardNumber = new ValidateDataCardNumberHSD();
			dataCardNumber = mySession.getVariableField(IProjectVariables.GET_DATA_CARD, IProjectVariables.GET_DATA_CARD_FIELD_VALUE).getStringValue().trim();
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Data Card Number in Check_GetDataCard1 1::"+dataCardNumber);
			validateDataCardNumber.setDataCardNumber(dataCardNumber);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Data Card Number in Check_GetDataCard 3 ::"+dataCardNumber);
			validateDataCardNumber = IVRDBServiceInstance.getInstance().validateDataCardNumber((IVRDataBean) mySession.getProperty(AppConstant.IVRDATABEAN), validateDataCardNumber);
			
			if(validateDataCardNumber.getErrorCode().equalsIgnoreCase(AppConstant.zero) && validateDataCardNumber.getErrorDescription().equalsIgnoreCase(AppConstant.Success))
			{
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, " Service Type :: "+validateDataCardNumber.getPlanType()+" :: DB Status :: "+validateDataCardNumber.getStatusFalg());
				mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_PLAN_TYPE).setValue(validateDataCardNumber.getPlanType());
				if(validateDataCardNumber.getStatusFalg().contains(AppConstant.Success))
				{
					if(validateDataCardNumber.getPlanType().contains(AppConstant.FGLTE))
							{
								mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_4G_LTE).setValue(AppConstant.Yes);
								 if(validateDataCardNumber.getPlanType().contains(AppConstant.PRE))
								 {
									 mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_TRANSFER_POINT).setValue(mySession.getVariableField(IProjectVariables.TRANSFER_POINTS,IProjectVariables.TRANSFER_POINTS_FIELD_HSDI__TR___0_0_7_8).getStringValue());
									 trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, " Transfer Point-78");
								 }else
								 {
									 mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_TRANSFER_POINT).setValue(mySession.getVariableField(IProjectVariables.TRANSFER_POINTS,IProjectVariables.TRANSFER_POINTS_FIELD_HSDI__TR___0_0_7_9).getStringValue());
									 trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, " Transfer Point-79");
								 }
								 hostOutput = AppConstant.Success;
							}
					else if(validateDataCardNumber.getPlanType().contains(AppConstant.HSD)||validateDataCardNumber.getPlanType().contains(AppConstant.DATA)||
							validateDataCardNumber.getPlanType().contains(AppConstant.REVB))
							{
						 		if(validateDataCardNumber.getPlanType().contains(AppConstant.PRE))
						 			mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_PREPAID).setValue(AppConstant.Yes);
						 		else 
						 			mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_PREPAID).setValue(AppConstant.No);
						 		 hostOutput = AppConstant.Success;
							
							}
					
						
					
				
					mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_ANI).setValue(mySession.getVariableField(IProjectVariables.GET_DATA_CARD, IProjectVariables.GET_DATA_CARD_FIELD_VALUE).getStringValue());
					
				}
				
			}
		}
					
		}
		catch(Exception e)
		{
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "Error in IVR CSP DB Hit :" +e);
			StackTrace.PrintException(e);
			 hostOutput = AppConstant.ERROR;
		}
			
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Host Status :" +hostOutput);
		mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_HOST_RESULT).setValue(hostOutput);
		
	}
}
