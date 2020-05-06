package flow;

import java.util.List;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.otherflows.model.TransferVDNInfo;
import com.rcom.otherflows.resource.IVRDBServiceInstance;
import com.rcom.rdtv.util.AppConstants;
import com.rcom.rdtv.util.StackTrace;
import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA;
import com.servion.prepaid.report.IVRREPORTDATA.CALLINFO;
import com.servion.prepaid.report.IVRREPORTDATA.MENUDETAILS.MENU;
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
 * Last generated by Orchestration Designer at: 2015-MAY-29  12:27:08 PM
 */
public class DataTransfer extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-29  12:27:08 PM
	 */
	public DataTransfer() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:37 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("CallTransfer", "Default");
		next.setDebugId(5655);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:37 PM
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
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:37 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(4);
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_INFO, "IVR UUI Data ::", "AppVariables:UUI_DATA").setDebugId(8380));
		actions.add(new com.avaya.sce.runtime.varoperations.PrepareAAI("Shared", "", "AppVariables:UUI_DATA", "AppVariables:UUI_DATA").setDebugId(7676));
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_INFO, "Prepared UUI Data ::", "AppVariables:UUI_DATA").setDebugId(7678));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
	
	@Override
	public void requestBegin(SCESession mySession) {
		
		ITraceInfo trace = mySession.getTraceOutput();
		TransferVDNInfo transferVDNInfo = null;
		IVRDataBean ivrDataBean = null;
		String strUUI=null, menuID = null,ANI=null,DNIS = null,language=null,transerCode=null,last5Menu = AppConstants.EMPTY_STRING,RepeatCallerFlag=null;
		
		try
		{
			 /*laterIVR call variables:  1. ANI 2. DNIS 3. Language (E=English) 4. Last 5 menu accessed 5. Transfer reason code*/
			ANI= mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_ANI).getStringValue();
			DNIS = mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_DNIS).getStringValue();
			language = mySession.getCurrentLanguage();
			transerCode = mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_TRANSFER_POINT).getStringValue();
			
			RepeatCallerFlag=mySession.getVariableField(IProjectVariables.BARRING_VARIABLES, IProjectVariables.BARRING_VARIABLES_FIELD_REPEAT_CALLER_STATUS).getStringValue();
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "TRANSFER CODE in START : " +transerCode);
			
		   String Stb_Type=mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_STB_TYPE).getStringValue();
		
		   trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "STB_TYPE is : " +Stb_Type);
		   
		   if(Stb_Type.equalsIgnoreCase("HD-DVR") && RepeatCallerFlag.equalsIgnoreCase("0"))
				   {
			         transerCode="RD01_TR_0057";
				   }
			
		   //Check if the customer belongs to Loyality Customer segment.
		   
		   String isLoyalityCustomer = mySession.getVariableField(IProjectVariables.LOYALITY__FLAG).getStringValue();
			
			if(isLoyalityCustomer.equalsIgnoreCase(AppConstants.TRUE))				
				{
					transerCode = AppConstants.LYT + transerCode;
				}
			
			else if(AppConstants.SUSPENDED.equalsIgnoreCase(mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_ACCESSED_MAIN_MENU).getStringValue()))
				{
					transerCode = AppConstants.SUS+transerCode;
				}
			else
				{
					transerCode = AppConstants.ACT+transerCode;
				}
				   
			
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Call Variables : ");
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "ANI : " +ANI);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "DNIS : " +DNIS);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "LANGUAGE : " +language);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "TRANSFER CODE : " +transerCode);
			
			ivrDataBean = (IVRDataBean) mySession.getProperty(AppConstants.IVRDATABEAN);
			GetReportObject getReportObject = ivrDataBean.getGetReportObject();
			IVRREPORTDATA ivrreportdata = getReportObject.getIvrreportdata();
			CALLINFO callInfo = ivrreportdata.getCALLINFO();
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Menu:"+ivrreportdata.getMENUDETAILS().getMENU());
			List<MENU> menuList = ivrreportdata.getMENUDETAILS().getMENU();
			
			if(menuList  !=null){
				
				for (int i = menuList.size(); (i> (menuList.size()-5)) && (i!=0); i-- ){
					menuID = menuList.get((i-1)).getMENUID();
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "menu ID :"+menuID);
					last5Menu = last5Menu + menuID+"|";
				}
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Last 5 menu accessed :"+last5Menu);
			}else{
				last5Menu = last5Menu+"|";
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "No Menu accessed");
			}
			
			strUUI = ANI+"|"+DNIS+"|"+language+"|"+last5Menu+"|"+transerCode;
			mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_UUI__DATA).setValue(strUUI);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "UUI data:"+strUUI);	
			
			/** DB Interaction-TransferVDN Request Formation **/
			transferVDNInfo = new TransferVDNInfo();
			transferVDNInfo.setAppName(mySession.getVariableField(IProjectVariables.APP__NAME).getStringValue());
			transferVDNInfo.setCallType(AppConstants.four);
			transferVDNInfo.setCircle(mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_CIRCLE_ID).getStringValue());
			/** ATOM Transfer VDN**/
			if(mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_ATOMTRANSFER).getBooleanValue()==true)
			{
				transferVDNInfo.setCustomerSegment(AppConstants.three);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "** ATOM Call Transfer  **");
			}
			else
				transferVDNInfo.setCustomerSegment(AppConstants.three);
			transferVDNInfo.setLanguage(language);
			transferVDNInfo.setTransferReasonCode(transerCode);			
			
			/** Transfer-VDN Response Collection **/
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Interaction-TransferVDN DB Reuest :: "+transferVDNInfo.toString());
			transferVDNInfo = IVRDBServiceInstance.getIVRDBInstance().getTransferVDN((IVRDataBean) mySession.getProperty(AppConstants.IVRDATABEAN), transferVDNInfo);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Interaction-TransferVDN DB Response :: "+transferVDNInfo.toString());
			mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_TRANSFER_VDN).setValue(transferVDNInfo.getTransferVDN1());
			
			if(transferVDNInfo.getTransferVDN1()!=null){
				callInfo.setAGENTEXTN(transferVDNInfo.getTransferVDN1());
				if(mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_ATOMTRANSFER).getBooleanValue()==true)
					callInfo.setAGENTID("ATOM");
				else
					callInfo.setAGENTID(transferVDNInfo.getTransferVDN1());
			}			
			else{
				
				// If the transfer VDN is null then for Loyalty Customer we should fetch the VDN from the property file. Format : KL_LOYALTY_VDN, DL_LOYALTY_VDN etc
				String loyaltyFlag = mySession.getVariableField(IProjectVariables.LOYALITY__FLAG).getStringValue();
				String circleID = mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_CIRCLE_ID).getStringValue();
				if(circleID == null || circleID.isEmpty()) circleID = AppConstants.NA;
				
				if(loyaltyFlag.equalsIgnoreCase(AppConstants.TRUE)){
					
					String transferVDN = AppProperties.GetInstance(AppConstants.IVR_CONFIG_PROPERTIES).getIVRProp(circleID + AppConstants.SEPERATOR_UNDERSCORE + AppConstants.LOYALTY_VDN);
					mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_TRANSFER_VDN).setValue(transferVDN);
					callInfo.setAGENTID(transferVDN);
					
				}else{
					
					String transferVDN = AppProperties.GetInstance(AppConstants.IVR_CONFIG_PROPERTIES).getIVRProp(language+AppConstants.SEPERATOR_UNDERSCORE+AppConstants.DEFAULT_VDN);
					mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_TRANSFER_VDN).setValue(transferVDN);
					callInfo.setAGENTID(transferVDN);
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "** DEFAULT VDN Transfer **");
				}
				
			}
			if(transferVDNInfo.getSkillName()!=null)
				callInfo.setSKILLNAME(transferVDNInfo.getSkillName());
			
			callInfo.setUUIDATA(strUUI);
			callInfo.setTRANSCODE(mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_TRANSFER_POINT).getStringValue());
			callInfo.setDISPOSITION("XA");
			callInfo.setCALLENDREASON("TRANSFER");
			callInfo.setHOWCALLENDED("TRANSFER");
			callInfo.setTRANSFERVDN(mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_TRANSFER_VDN).getStringValue());
			ivrreportdata.setCALLINFO(callInfo);
		}
		catch(Exception e)
		{mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_HOST_FAILURE).setValue(AppConstants.Yes);
		StackTrace.PrintException(e);}
		finally
		{transferVDNInfo=null;trace=null;strUUI=null;menuID = null;ANI=null;DNIS = null;language=null;transerCode=null;last5Menu=null;ivrDataBean=null;}
	}
}
