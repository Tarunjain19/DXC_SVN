package flow.subflow.Prepaid;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.servion.hsd.utils.AppConstant;
import com.servion.hsd.utils.DynamicMenu;
import com.servion.hsd.utils.StackTrace;
import com.servion.rcom.hostinterface.view.ReqServiceRequestDetails;
import com.servion.rcom.hostinterface.view.ResServiceRequestDetails;
import com.servion.rcom.hostinterface.wrapper.IVRWebService;
import com.servion.rcom.hostinterface.wrapper.IVRWebServiceImpl;

import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;


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
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:39:03 PM
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
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:39:03 PM
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
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:39:03 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(4);
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_INFO, "Host Result :", "AppVariables:HostResult").setDebugId(768));
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_INFO, "SR available Flag :", "Flag:SRavailable").setDebugId(769));
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_INFO, "Resolution Flag :", "Flag:resolutionDateCrossed").setDebugId(770));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "AppVariables:HostResult", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:success", true).setDebugId(771)).evaluate(mySession)) {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "Flag:SRavailable", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:Key_true", true).setDebugId(772)).evaluate(mySession)) {

				if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "Flag:resolutionDateCrossed", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:Key_true", true).setDebugId(773)).evaluate(mySession)) {
					actions = new java.util.ArrayList(2);
					actions.add(new com.avaya.sce.runtime.varoperations.Assign("AppVariables:TransferPoint", "TransferPoints:HSDI_TR_0007", false).setDebugId(997));
					actions.add(new com.avaya.sce.runtime.Next("Prepaid-Transfer", "Transfer").setDebugId(774));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;

				} else {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.Next("Prepaid-PlaySRMessage", "playMessage").setDebugId(776));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;
				}


			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("Prepaid-Host_CRM_WS", "CRM_Interaction").setDebugId(778));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("Prepaid-checkMainMenuCount", "Linkdown").setDebugId(780));
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
		String hostOutput = AppConstant.ERROR,ani = AppConstant.EMPTY_STRING;
		String dateTimeCreation = AppConstant.EMPTY_STRING,strSRType = AppConstant.EMPTY_STRING,slaDate = AppConstant.EMPTY_STRING;
		String responseCode = AppConstant.EMPTY_STRING;
		boolean isServiceAvailable = false;
		Calendar currDate = null,calSLADate = null;
		Date dslaDate = null;
		ITraceInfo trace = null;
		ArrayList<String> outputValues = null;
		IVRWebService ivrWebService = null;
		IVRDataBean objIVRDataBean = null;
		ReqServiceRequestDetails objReqServiceRequestDetails = null;
		ResServiceRequestDetails objResServiceRequestDetails = null; 
		SimpleDateFormat sdfObject = null,sdfDDDate=null,sdfDDTime=null;
		
		/**Assign**/
		trace = mySession.getTraceOutput();
		try {
			ivrWebService = new IVRWebServiceImpl();
			objIVRDataBean = (IVRDataBean)mySession.getProperty(AppConstant.IVRDATABEAN);
			ani = mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_ANI).getStringValue();
			objReqServiceRequestDetails = new ReqServiceRequestDetails();
			sdfObject = new SimpleDateFormat(AppConstant.DATE_FORMAT_REPORT);
			
			outputValues = new ArrayList<>();
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Caller Ani :"+ani);

			objReqServiceRequestDetails.setMDN(ani);
			objResServiceRequestDetails = ivrWebService.executeServiceRequestDetails(objIVRDataBean,objReqServiceRequestDetails);
			
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
						if(dateTimeCreation != null && strSRType != null && slaDate != null){
							
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
								
								
								long diff = calSLADate.getTime().getTime() - Calendar.getInstance().getTime().getTime();
						        long diffMinutes = diff / (60 * 1000) % 60;
						        long diffHours = diff / (60 * 60 * 1000);
						        int diffInDays = (int) ((calSLADate.getTime().getTime() - Calendar.getInstance().getTime().getTime()) / (1000 * 60 * 60 * 24));
						        int count = 3;
								
						        trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Differance in Minutes  :"+diffMinutes);
								trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Differance in Hours :"+diffHours);
								trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Differance in Days :"+diffInDays);
								
						        outputValues.add(strSRType.trim()+AppConstant.wave);
						        
						        if(diffInDays>1){
						        	trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"More than one day");
						        	outputValues.add(String.valueOf(diffInDays));
						        	outputValues.add(AppConstant.Days);
						        }else if (diffInDays==1){
						        	trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"one day");
						        	outputValues.add(String.valueOf(diffInDays));
						        	outputValues.add(AppConstant.Day);
						        }else{
						        	trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"No Day Difference");
						        	count--;
						        }
						        
						        diffHours = diffHours%24;
						        trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Differance in Hours after removing date:"+diffHours);
						        
						        if(diffHours>1){
						        	trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"More than one Hours");
						        	outputValues.add(String.valueOf(diffHours));
						        	outputValues.add(AppConstant.Hours);
						        }else if (diffHours==1){
						        	trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"one Hour");
						        	outputValues.add(String.valueOf(diffHours));
						        	outputValues.add(AppConstant.Hour);
						        }else{
						        	trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"No Hour Difference");
						        	count--;
						        }
								
						        if(diffMinutes>1){
						        	trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"More than one Minite");
						        	outputValues.add(String.valueOf(diffMinutes));
						        	outputValues.add(AppConstant.Minutes);
						        }else if (diffMinutes==1){
						        	trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"one Minite");
						        	outputValues.add(String.valueOf(diffMinutes));
						        	outputValues.add(AppConstant.Minute);
						        }else{
						        	trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"No Minines Difference");
						        	count--;
						        }
						        
								/** Form Initial Prompt**/
								initialPrompt(mySession,outputValues,count);
							}
						}else{
							trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"One of the key factor is null");
						}
					}else{
						trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Service Is not available");
					}
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
	public void initialPrompt(SCESession mySession,ArrayList<String> outputValues,int count){
		
		/** Declaration **/
		String initialPrompt = AppConstant.EMPTY_STRING,appName = AppConstant.EMPTY_STRING;
		String dynamicWaves =  AppConstant.EMPTY_STRING,key = AppConstant.EMPTY_STRING;
		ITraceInfo trace =null;
		
		/**Assign**/
		trace = mySession.getTraceOutput();
		appName = mySession.getVariableField(IProjectVariables.APP__NAME).getStringValue();
		key = appName+AppConstant.SEPERATOR_HYPEN+AppConstant.HSDI_PA_0006;
		
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"application Name :"+appName);
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"SLA initial Prompt Key :"+key);
		
		dynamicWaves = AppProperties.GetInstance(AppConstant.DYN_MENU).getIVRProp(key);
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"SLA initial Prompt :"+dynamicWaves);
		
		/** Form Dynamic Initial Prompt**/
		
		if(outputValues!=null){
			
			/** Form Initial Prompt**/
			DynamicMenu objDynamicMenu = new DynamicMenu();
			initialPrompt=objDynamicMenu.playPrompt(outputValues, dynamicWaves, String.valueOf(count), trace);
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Initial Prompt ::"+initialPrompt);
			mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER,IProjectVariables.DM_INPUT_PARAMETER_FIELD_INITIAL_PROMPT).setValue(initialPrompt);
			
		}else {
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"SLA Not Available");
		}
		
	}
	
	public static void main(String[] args) throws ParseException {
		Calendar currDate = Calendar.getInstance();
		Calendar calSLADate =  Calendar.getInstance();
		Date dslaDate = null;
		SimpleDateFormat	sdfObject = new SimpleDateFormat(AppConstant.DATE_FORMAT_DDMMYYYYHHmmSS);
		
		dslaDate= sdfObject.parse("25-04-2015 11:30:00");
		calSLADate.setTime(dslaDate);
		
		long diff = calSLADate.getTime().getTime() - Calendar.getInstance().getTime().getTime();
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000);
        int diffInDays = (int) ((calSLADate.getTime().getTime() - Calendar.getInstance().getTime().getTime()) / (1000 * 60 * 60 * 24));
		
       System.out.println("Differance in Minutes  :"+diffMinutes);
       System.out.println("Differance in Hours :"+diffHours%24);
       System.out.println("Differance in Days :"+diffInDays);
       
       String text = " hi";
       System.out.println("ii"+text.trim());
        
	}
}