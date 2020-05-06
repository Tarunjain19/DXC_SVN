package flow;

import java.util.ArrayList;
import java.util.List;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.rdtv.util.AppConstants;
import com.rcom.rdtv.util.DynamicMenu;
import com.rcom.rdtv.util.SayItSmartTime;
import com.rcom.rdtv.util.StackTrace;
import com.servion.rdtv.hostinterface.TransAccountDetails;
import com.servion.rdtv.hostservice.ReqAccountDetails;
import com.servion.rdtv.hostservice.ResAccountDetails;
import com.servion.util.AppProperties;
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
 * Last generated by Orchestration Designer at: 2015-MAY-28  12:28:40 PM
 */
public class Check_BalanceRechargeMN extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-28  12:28:40 PM
	 */
	public Check_BalanceRechargeMN() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:41 PM
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
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:41 PM
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
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:41 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(3);
		actions.add(new com.avaya.sce.runtime.varoperations.Assign("Global_Counter:Max_NoMatch", "BalanceRecharge_MN:NomatchRemaining", false).setDebugId(9668));
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "BalanceRecharge_Menu ReturnCode :: ", "BalanceRecharge_MN:ReturnCode").setDebugId(1452));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "BalanceRecharge_MN:ReturnCode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "CONSTANTS:SUCCESS", true).setDebugId(1453)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "BalanceRecharge_Menu Value :: ", "BalanceRecharge_MN:Value").setDebugId(1454));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "BalanceRecharge_MN:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "dmGrammarValues:RechargeAccount", true).setDebugId(1455)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("RechargeAccount", "recharge-account").setDebugId(1456));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "BalanceRecharge_MN:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "dmGrammarValues:previous", true).setDebugId(6588)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("AccountMain_MN", "previous").setDebugId(6589));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition4", "BalanceRecharge_MN:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "dmGrammarValues:MainMenu", true).setDebugId(6590)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("check_AccessedMainMenu", "mainmenu").setDebugId(6591));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition5", "BalanceRecharge_MN:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "dmGrammarValues:agent", true).setDebugId(6594)).evaluate(mySession)) {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("AppVariables:TransferPoint", "TransferPoints:RD01_TR_0045", false).setDebugId(6923));
				actions.add(new com.avaya.sce.runtime.Next("Transfer_Annc", "representative").setDebugId(6595));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {

				if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition6", "AppVariables:IsHostFailure", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "CONSTANTS:YES", true).setDebugId(6867)).evaluate(mySession)) {
					actions = new java.util.ArrayList(2);
					actions.add(new com.avaya.sce.runtime.varoperations.Assign("AppVariables:TransferPoint", "TransferPoints:RD01_TR_0010", false).setDebugId(6868));
					actions.add(new com.avaya.sce.runtime.Next("LinkDownAnnc", "linkdown").setDebugId(6869));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;

				} else {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.Next("AccountBalance_Annc", "account-balance").setDebugId(1458));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;
				}

			}


		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("Tries_ExceedAnncom", "tries-exceed").setDebugId(1460));
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
		ITraceInfo trace = mySession.getTraceOutput();
		
		String accountBalance,appName,initialPrompt,key,smartCardNumber = null;
		List<String> dynamicList = new ArrayList<>();
		ReqAccountDetails reqAccountDetails = null;
		ResAccountDetails resAccountDetails = null;
		TransAccountDetails transAccountDetails = null;
		try
		{
		if(mySession.getVariableField(IProjectVariables.BALANCE_RECHARGE__MN, IProjectVariables.BALANCE_RECHARGE__MN_FIELD_RETURN_CODE).getStringValue().equalsIgnoreCase(AppConstants.Success))
		{
			if(mySession.getVariableField(IProjectVariables.BALANCE_RECHARGE__MN, IProjectVariables.BALANCE_RECHARGE__MN_FIELD_VALUE).getStringValue().equalsIgnoreCase(AppConstants.AccountBalance))
			{	/** WS-GetAccountDetails Request Formation **/
				smartCardNumber = mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_SCNUMBER).getStringValue();
				reqAccountDetails = new ReqAccountDetails();
				reqAccountDetails.setAccountId(smartCardNumber);
				reqAccountDetails.setStartDate(SayItSmartTime.accountDetailsDateFormat());
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "GetAccountDetails Host Request :: "+reqAccountDetails.toString());
				
				/** WS Host Interaction **/
				transAccountDetails = new TransAccountDetails();
				resAccountDetails = transAccountDetails.getHostInterface((IVRDataBean) mySession.getProperty(AppConstants.IVRDATABEAN), reqAccountDetails);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "GetAccountDetails Host Response :: "+resAccountDetails.toString());
				
				if(resAccountDetails.getResponseCode().equalsIgnoreCase(AppConstants.zero))
				{
				
				/** Forming the Dynamic Prompt **/
				appName = mySession.getVariableField(IProjectVariables.APP__NAME).getStringValue();
				accountBalance = resAccountDetails.getAccBalance();
				key = appName+AppConstants.SEPERATOR_HYPEN+AppConstants.RD01_PA_0024;
				initialPrompt = AppProperties.GetInstance(AppConstants.IVR_CONFIG_PROPERTIES).getIVRProp(key);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Dynamic Prompt Key "+AppConstants.RD01_PA_0024+" :: "+key);
				dynamicList.add(accountBalance+AppConstants.currency);
				
				/** Invoking the playPromt method **/
				initialPrompt = DynamicMenu.playPrompt(dynamicList, initialPrompt, AppConstants.NA, AppConstants.RD01_PA_0024, trace);
				mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER, IProjectVariables.DM_INPUT_PARAMETER_FIELD_INITIAL_PROMPT).setValue(initialPrompt);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Confirmation Initial Prompt "+AppConstants.RD01_PA_0024+" :: "+initialPrompt);
				}
				else
					mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_HOST_FAILURE).setValue(AppConstants.Yes);
			}
		}
			
		}catch(Exception e)
		{mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_HOST_FAILURE).setValue(AppConstants.Yes);
		StackTrace.PrintException(e);
		}
		finally
		{initialPrompt = null;accountBalance = null;appName=null;key=null;dynamicList=null;reqAccountDetails=null;resAccountDetails=null;transAccountDetails=null;}
	}
}
