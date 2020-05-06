package flow;

import java.net.InetAddress;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.avaya.sce.runtimecommon.VariableTypeException;
import com.servion.rcom.hostinterface.view.ReqTopUpAmountValidation;
import com.servion.rcom.hostinterface.view.ResTopUpAmountValidation;
import com.servion.rcom.hostinterface.wrapper.IVRWebService;
import com.servion.rcom.hostinterface.wrapper.IVRWebServiceImpl;
import com.servion.util.AppConstant;
import com.servion.util.IVRDataBean;
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
 * Last generated by Orchestration Designer at: 2015-MAR-15  10:24:17 PM
 */
public class CheckTopupAmount extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAR-15  10:24:17 PM
	 */
	public CheckTopupAmount() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2016-JUL-27  06:35:02 PM
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
	 * Last generated by Orchestration Designer at: 2016-JUL-27  06:35:02 PM
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
	 * Last generated by Orchestration Designer at: 2016-JUL-27  06:35:02 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(2);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "EPM_Alarm:Flag", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:TRUE", true).setDebugId(9901)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.tracking.ReportAlarmInfo(com.avaya.sce.runtimecommon.IReportInfo.ALARM_LEVEL_MAJOR, "WS Down|Main Flow|Chk Topup Amount|", "EPM_Alarm:Description", true).setDebugId(9902));
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("EPM_Alarm:Flag", "constant:FALSE", false).setDebugId(9903));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		}


		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "Collect_TopUpAmount:ReturnCode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:success", true).setDebugId(3149)).evaluate(mySession)) {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "appVariables:HostResult", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:success", true).setDebugId(2868)).evaluate(mySession)) {

				if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition4", "Flag:TopupAmountValid", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:Key_true", true).setDebugId(3164)).evaluate(mySession)) {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.Next("Get_ConfirmationTopupInfo", "correct").setDebugId(3165));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;

				} else {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.Next("Get_TopUpInfo", "TopUpContin").setDebugId(3167));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;
				}


			} else {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "TR_0066", true).setDebugId(7464));
				actions.add(new com.avaya.sce.runtime.Next("LinkDown", "LinkDown").setDebugId(2871));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


		} else {
			actions = new java.util.ArrayList(3);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("Flag:NIFlag", "Collect_TopUpAmount:ReturnCode", false).setDebugId(9075));
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "TR_0030", true).setDebugId(7463));
			actions.add(new com.avaya.sce.runtime.Next("checkNIexceeds", "ExceededTries").setDebugId(3163));
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
		/**Declaration**/
		String returnCode = AppConstant.EMPTY_STRING,returnValue = AppConstant.EMPTY_STRING;
		String ani = AppConstant.EMPTY_STRING,hostResponse = AppConstant.ERROR;
		String EPM_Alarm_Description = AppConstant.EMPTY_STRING,IP = AppConstant.EMPTY_STRING;
		ITraceInfo trace = null;
		IVRWebService webServiceManager = null;
		IVRDataBean objIVRData = null;
		ReqTopUpAmountValidation objReqTopUpAmountValidation = null;
		ResTopUpAmountValidation objResTopUpAmountValidation = null;
		
		trace = mySession.getTraceOutput();
		try {
			
			/**Assign**/
			//IP = InetAddress.getLocalHost().getHostAddress();
			objReqTopUpAmountValidation = new ReqTopUpAmountValidation();
			returnCode = mySession.getVariableField(IProjectVariables.COLLECT__TOP_UP_AMOUNT,IProjectVariables.COLLECT__TOP_UP_AMOUNT_FIELD_RETURN_CODE).getStringValue();
			returnValue = mySession.getVariableField(IProjectVariables.COLLECT__TOP_UP_AMOUNT,IProjectVariables.COLLECT__TOP_UP_AMOUNT_FIELD_VALUE).getStringValue(); 
			ani = mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_ANI).getStringValue();
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Top Up Return Code :"+returnCode);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Top Up Return Value :"+returnValue);
			
			if(AppConstant.Success.equalsIgnoreCase(returnCode)){
				
				objIVRData = (IVRDataBean) mySession.getProperty(AppConstant.IVRDATABEAN);
				objReqTopUpAmountValidation.setMDN(ani);
				objReqTopUpAmountValidation.setMDNToBeRecharged(ani);
				objReqTopUpAmountValidation.setAmount(returnValue);
				
				webServiceManager = new IVRWebServiceImpl();
				objResTopUpAmountValidation = webServiceManager.executeTopUpAmountValidation(objIVRData,objReqTopUpAmountValidation);
				
				if(objResTopUpAmountValidation!=null && !AppConstant.one.equals(objResTopUpAmountValidation.getResponseCode())){
					String reponseCode =objResTopUpAmountValidation.getResponseCode();
					String talkTime =  objResTopUpAmountValidation.getCurrentTopupAmountTalktime();
					String minAmount = objResTopUpAmountValidation.getMinVal();
					String minTalkTime = objResTopUpAmountValidation.getMinValTalktime();
					String maxAmount = objResTopUpAmountValidation.getMaxVal();
					String maxTalkTime = objResTopUpAmountValidation.getMaxValTalktime();
					
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Top Up Response Code :"+reponseCode);
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Top Up talk Time :"+talkTime);
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Top Up min Amount :"+minAmount);
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Top Up min Talk Time :"+minTalkTime);
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Top Up max Amount :"+maxAmount);
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Top Up max Talk Time :"+maxTalkTime);
					
					mySession.getVariableField(IProjectVariables.TOP_UP_DETAIL,IProjectVariables.TOP_UP_DETAIL_FIELD_AMOUNT).setValue(returnValue);
					mySession.getVariableField(IProjectVariables.TOP_UP_DETAIL,IProjectVariables.TOP_UP_DETAIL_FIELD_TALK_TIME).setValue(talkTime);
					mySession.getVariableField(IProjectVariables.TOP_UP_DETAIL,IProjectVariables.TOP_UP_DETAIL_FIELD_MIN_AMOUNT).setValue(minAmount);
					mySession.getVariableField(IProjectVariables.TOP_UP_DETAIL,IProjectVariables.TOP_UP_DETAIL_FIELD_MIN_TALK_TIME).setValue(minTalkTime);
					mySession.getVariableField(IProjectVariables.TOP_UP_DETAIL,IProjectVariables.TOP_UP_DETAIL_FIELD_MAX_AMOUNT).setValue(maxAmount);
					mySession.getVariableField(IProjectVariables.TOP_UP_DETAIL,IProjectVariables.TOP_UP_DETAIL_FIELD_MAX_TALK_TIME).setValue(maxTalkTime);
					
					hostResponse = AppConstant.Success;
					
					if(AppConstant.zero.equalsIgnoreCase(reponseCode)){
						trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Valid Amount in TopUp");
						mySession.getVariableField(IProjectVariables.FLAG,IProjectVariables.FLAG_FIELD_TOPUP_AMOUNT_VALID).setValue(AppConstant.TRUE);
					}else if("-1".equalsIgnoreCase(reponseCode)){
						trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"In Valid Amount in TopUp");
						mySession.getVariableField(IProjectVariables.FLAG,IProjectVariables.FLAG_FIELD_TOPUP_AMOUNT_VALID).setValue(AppConstant.FALSE);
					}else{
						hostResponse = AppConstant.ERROR;	
					}
					
					
					
				}else{
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"TopUp Host Failure");
				}
				
			}
		} catch (VariableTypeException e) {
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "Error in Top Up Host Call :"+e);
			StackTrace.PrintException(e);
			EPM_Alarm_Description =IP+"|"+e;
			
			mySession.getVariableField(IProjectVariables.EPM__ALARM,IProjectVariables.EPM__ALARM_FIELD_FLAG).setValue(AppConstant.TRUE);
			mySession.getVariableField(IProjectVariables.EPM__ALARM,IProjectVariables.EPM__ALARM_FIELD_DESCRIPTION).setValue(EPM_Alarm_Description);
		}finally{
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Top Up Host Call :"+hostResponse);
			mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_HOST_RESULT).setValue(hostResponse);
		}
		
	}
}
