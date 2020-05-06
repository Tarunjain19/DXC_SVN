package flow.subflow.Intelligent;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.servion.rcom.hostinterface.view.ReqServiceRequestDetails;
import com.servion.rcom.hostinterface.view.ResServiceRequestDetails;
import com.servion.rcom.hostinterface.wrapper.IVRWebService;
import com.servion.rcom.hostinterface.wrapper.IVRWebServiceImpl;
import com.servion.util.AppConstant;
import com.servion.util.AppProperties;
import com.servion.util.DynamicMenu;
import com.servion.util.IVRDataBean;
import com.servion.util.StackTrace;

import flow.IProjectVariables;

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
 * Last generated by Orchestration Designer at: 2015-MAR-13  01:00:09 AM
 */
public class Access_SR_Host extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAR-13  01:00:09 AM
	 */
	public Access_SR_Host() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-AUG-29  03:09:24 PM
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
	 * Last generated by Orchestration Designer at: 2017-AUG-29  03:09:24 PM
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
	 * Last generated by Orchestration Designer at: 2017-AUG-29  03:09:24 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(2);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "EPM_Alarm:Flag", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:TRUE", true).setDebugId(596)).evaluate(mySession)) {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "WS_Alarm_Flag", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:ON", true).setDebugId(612)).evaluate(mySession)) {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.tracking.ReportAlarmInfo(com.avaya.sce.runtimecommon.IReportInfo.ALARM_LEVEL_MAJOR, "WS Down|Intelligent Flow|Access SR|", "EPM_Alarm:Description", true).setDebugId(597));
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("EPM_Alarm:Flag", "constant:FALSE", false).setDebugId(598));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			}

		}

		actions = new java.util.ArrayList(3);
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_INFO, "Host Result :", "appVariables:HostResult").setDebugId(34));
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_INFO, "SR available Flag :", "Flag:SRavailable").setDebugId(35));
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_INFO, "Resolution Flag :", "Flag:resolutionDateCrossed").setDebugId(36));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "appVariables:HostResult", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:success", true).setDebugId(489)).evaluate(mySession)) {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition4", "Flag:SRavailable", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:Key_true", true).setDebugId(484)).evaluate(mySession)) {

				if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition5", "Flag:resolutionDateCrossed", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:Key_true", true).setDebugId(488)).evaluate(mySession)) {
					actions = new java.util.ArrayList(2);
					actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "TR_0109", true).setDebugId(584));
					actions.add(new com.avaya.sce.runtime.Next("Intelligent-Transfer", "Transfer").setDebugId(485));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;

				} else {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.Next("Intelligent-PlaySRMessage", "playMessage").setDebugId(493));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;
				}


			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("Intelligent-Host_CRM_WS", "CRM_Interaction").setDebugId(487));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("Intelligent-MainMenu", "Linkdown").setDebugId(491));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
	@SuppressWarnings("deprecation")
	@Override
	public void requestBegin(SCESession mySession) {
		/**Declaration**/
		String hostOutput = AppConstant.ERROR,ani = AppConstant.EMPTY_STRING;
		String dateTimeCreation = AppConstant.EMPTY_STRING,strSRType = AppConstant.EMPTY_STRING,slaDate = AppConstant.EMPTY_STRING;
		String responseCode = AppConstant.EMPTY_STRING;
		String EPM_Alarm_Description = AppConstant.EMPTY_STRING,IP = AppConstant.EMPTY_STRING;
		boolean isServiceAvailable = false;
		Calendar currDate = null,calSLADate = null;
		Date dslaDate = null;
		ITraceInfo trace = null;
		ArrayList<String> outputValues = null;
		IVRWebService ivrWebService = null;
		IVRDataBean objIVRDataBean = null;
		ReqServiceRequestDetails objReqServiceRequestDetails = null;
		ResServiceRequestDetails objResServiceRequestDetails = null; 
		SimpleDateFormat sdfObject = null,sdfDDDate=null;
		String ddSLADate = AppConstant.EMPTY_STRING;
		
		/**Assign**/
		trace = mySession.getTraceOutput();
		try {
			IP = InetAddress.getLocalHost().getHostAddress();
			ivrWebService = new IVRWebServiceImpl();
			objIVRDataBean = (IVRDataBean)mySession.getProperty(AppConstant.IVRDATABEAN);
			ani = mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_ANI).getStringValue();
			objReqServiceRequestDetails = new ReqServiceRequestDetails();
			
			sdfObject = new SimpleDateFormat(AppConstant.DATE_FORMAT_REPORT);
			sdfDDDate = new SimpleDateFormat(AppConstant.DATE_FORMAT_YYYYMMDD);
			
			outputValues = new ArrayList<>();
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Caller Ani :"+ani);

			objReqServiceRequestDetails.setMDN(ani);
			try
			{
			objResServiceRequestDetails = ivrWebService.executeServiceRequestDetails(objIVRDataBean,objReqServiceRequestDetails);
			}
			catch (Exception e){
				EPM_Alarm_Description =IP+"|"+e;
				mySession.getVariableField(IProjectVariables.EPM__ALARM,IProjectVariables.EPM__ALARM_FIELD_FLAG).setValue(AppConstant.TRUE);
				mySession.getVariableField(IProjectVariables.EPM__ALARM,IProjectVariables.EPM__ALARM_FIELD_DESCRIPTION).setValue(EPM_Alarm_Description);
			}
			
			if(objResServiceRequestDetails!=null){
				
				
				responseCode = objResServiceRequestDetails.getResponseCode();
				
				if(responseCode!=null && AppConstant.zero.equalsIgnoreCase(responseCode)){
					hostOutput = AppConstant.Success;
					isServiceAvailable = objResServiceRequestDetails.isServiceRequestAvailable();
					strSRType = objResServiceRequestDetails.getServiceRequestType();
					dateTimeCreation = objResServiceRequestDetails.getServiceRequestCreationDate();
					slaDate = objResServiceRequestDetails.getServiceRequestSLADate();
					
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"date Time Creation :"+dateTimeCreation);
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"SR Type :"+strSRType);
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"SLA Date :"+slaDate);
					
					if(isServiceAvailable){
						trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Service Available :"+isServiceAvailable);
						if((dateTimeCreation != null && (!dateTimeCreation.isEmpty())) && (strSRType != null && (!strSRType.isEmpty())) && (slaDate != null && (!slaDate.isEmpty()))){
							
							mySession.getVariableField(IProjectVariables.FLAG,IProjectVariables.FLAG_FIELD_SRAVAILABLE).setValue(AppConstant.TRUE);
							trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"SR is available");
							
							trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"SR");
							currDate = Calendar.getInstance();
							calSLADate =  Calendar.getInstance();
							
							trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"sla Date Parsing");
							dslaDate= sdfObject.parse(slaDate);
							trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"sla Date Parsing Done");
							
							calSLADate.setTime(dslaDate);
							trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"sr Create Date :"+calSLADate.getTime());
							trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Current date :"+currDate.getTime());
							
							//calSRCreateDate.add(Calendar.DATE,Integer.parseInt(strTAT));
							//trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"sr Create Date after TAT addition :"+calSRCreateDate.getTime());
							
							if(currDate.after(calSLADate)){
								trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Resolution Date Crossed");
								mySession.getVariableField(IProjectVariables.FLAG,IProjectVariables.FLAG_FIELD_RESOLUTION_DATE_CROSSED).setValue(AppConstant.TRUE);
							}else{
								trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"with in Resolution date");
								
						        outputValues.add(strSRType.trim()+AppConstant.wave);
						        
						        ddSLADate = sdfDDDate.format(dslaDate);
								trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"SLA date in DD format :"+ddSLADate);
								outputValues.add(ddSLADate);
								
								outputValues.add(String.valueOf(dslaDate.getHours()));
					        	outputValues.add(AppConstant.Hours);
					        	
								/** Form Initial Prompt**/
								initialPrompt(mySession,outputValues);
							}
						}else{
							trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"One of the key factor is null");
						}
					}else{
						trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Service Is not available");
					}
				}else{
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Service Host Response in null ");
				}
			}
			
		} catch (Exception e) {
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "Error in Service Request Host Access :" +e);
			StackTrace.PrintException(e);
		}finally{
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "SR Host Result :" +hostOutput);
			mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_HOST_RESULT).setValue(hostOutput);
		}
		
	}
	public void initialPrompt(SCESession mySession,ArrayList<String> outputValues){
		
		/** Declaration **/
		String initialPrompt = AppConstant.EMPTY_STRING,appName = AppConstant.EMPTY_STRING;
		String dynamicWaves =  AppConstant.EMPTY_STRING,key = AppConstant.EMPTY_STRING;
		ITraceInfo trace =null;
		
		/**Assign**/
		trace = mySession.getTraceOutput();
		appName = mySession.getVariableField(IProjectVariables.APP_NAME).getStringValue();
		key = appName+AppConstant.SEPERATOR_HYPEN+AppConstant.PA_0076;
		
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"application Name :"+appName);
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"SLA initial Prompt Key :"+key);
		
		dynamicWaves = AppProperties.GetInstance(AppConstant.DYN_MENU).getIVRProp(key);
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"SLA initial Prompt :"+dynamicWaves);
		
		/** Form Dynamic Initial Prompt**/
		
		if(outputValues!=null){
			
			/** Form Initial Prompt**/
			DynamicMenu objDynamicMenu = new DynamicMenu();
			initialPrompt=objDynamicMenu.playPrompt(outputValues, dynamicWaves, AppConstant.NA, trace);
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Initial Prompt ::"+initialPrompt);
			mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER,IProjectVariables.DM_INPUT_PARAMETER_FIELD_INITIAL_PROMPT).setValue(initialPrompt);
			
		}else {
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"SLA Not Available");
		}
		
	}
	
}