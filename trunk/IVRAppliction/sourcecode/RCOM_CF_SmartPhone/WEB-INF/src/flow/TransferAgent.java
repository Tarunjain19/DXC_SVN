package flow;

import java.util.List;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.smartphone.model.TransferVDNInfo;
import com.rcom.smartphone.resource.IVRDBServiceInstance;
import com.rcom.util.AppConstant;
import com.rcom.util.StackTrace;
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
 * Last generated by Orchestration Designer at: 2015-SEP-24  08:03:16 PM
 */
public class TransferAgent extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-SEP-24  08:03:16 PM
	 */
	public TransferAgent() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-SEP-13  03:14:23 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("Transfer_Msg", "Default");
		next.setDebugId(651);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2017-SEP-13  03:14:23 PM
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
	 * Last generated by Orchestration Designer at: 2017-SEP-13  03:14:23 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
	@Override
	public void requestBegin(SCESession mySession) {
		super.requestBegin(mySession);
		/**Declaring the variables**/
		TransferVDNInfo transferVDNInfo = null;
		IVRDataBean ivrDataBean = null;
		ITraceInfo info = null;
		String last5Menu =AppConstant.EMPTY_STRING;
		ITraceInfo trace = null;
		String strUUI = AppConstant.EMPTY_STRING;
		String menuID = AppConstant.EMPTY_STRING;
		String ani = AppConstant.EMPTY_STRING,currentLanguage = AppConstant.EMPTY_STRING;
		String dnis = AppConstant.EMPTY_STRING,transferCode = AppConstant.EMPTY_STRING;
		AppProperties ivrProperties = null;
		String defaultVDN=AppConstant.EMPTY_STRING,key= AppConstant.EMPTY_STRING,transferVDN = AppConstant.EMPTY_STRING;
		
		try{
			
			/**Assigning the trace object**/
			info = mySession.getTraceOutput();
			
			/** getting the IVRData bean from session**/
			ivrDataBean = (IVRDataBean) mySession.getProperty(AppConstant.IVRDATABEAN);

			GetReportObject getReportObject = ivrDataBean.getGetReportObject();
			IVRREPORTDATA ivrreportdata = getReportObject.getIvrreportdata();
			CALLINFO callInfo = ivrreportdata.getCALLINFO();
			trace = mySession.getTraceOutput();
			ivrProperties = AppProperties.GetInstance(AppConstant.IVR_CONFIG);
			ani = mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_ANI).getStringValue();
			dnis = mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_DNIS).getStringValue();
			currentLanguage = mySession.getCurrentLanguage();
			 transferCode = mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_TRANSFER_CODE).getStringValue();
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Dnis :"+dnis);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Ani :" +ani);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "currentLanguage :" +currentLanguage);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Menu:"+ivrreportdata.getMENUDETAILS().getMENU());
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Transfer Code :" +transferCode);
			
			List<MENU> menuList = ivrreportdata.getMENUDETAILS().getMENU();
			
			if(menuList  !=null){
				
				for (int i = menuList.size(); (i> (menuList.size()-5)) && (i!=0); i-- ){
					menuID = menuList.get((i-1)).getMENUID();
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "menu ID :"+menuID);
					last5Menu = last5Menu + menuID+"|";
				}
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Last 5 menu accessed :"+last5Menu);
			}else{
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "No Menu accessed");
			}
			
			
			strUUI = ani+AppConstant.PIPE+dnis+AppConstant.PIPE+currentLanguage+AppConstant.PIPE+last5Menu +AppConstant.PIPE+transferCode;
			mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_UUI_DATA).setValue(strUUI);
			
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "UUI data:"+strUUI);
			mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_UUI_DATA).setValue(strUUI);
			
			transferVDNInfo = new TransferVDNInfo();
			transferVDNInfo.setAppName(mySession.getVariableField(IProjectVariables.APPNAME).getStringValue());
			transferVDNInfo.setCircle(mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_CIRCLE_ID).getStringValue());
			transferVDNInfo.setCallType("4");
			transferVDNInfo.setCustomerSegment("3");
			transferVDNInfo.setLanguage(currentLanguage);
			transferVDNInfo.setTransferReasonCode(transferCode);
			
			transferVDNInfo = IVRDBServiceInstance.getIVRDBInstance().getTransferVDN(ivrDataBean, transferVDNInfo);
			callInfo.setHOWCALLENDED(AppConstant.TRANSFER);
			
			transferVDN = transferVDNInfo.getTransferVDN1(); 
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Transfer VDN from DB : "+transferVDN);
			
			if(transferVDN != null && !AppConstant.EMPTY_STRING.equals(transferVDN)){
				callInfo.setAGENTEXTN(transferVDN);
				callInfo.setAGENTID(transferVDN);
				callInfo.setTRANSFERVDN(transferVDN);
				mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_TRANSFER_VDN).setValue(transferVDN);
			}else{
				mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_TRANSFER_VDN).setValue(AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp("DEFAULT_VDN"));
			}
			
			if(transferVDNInfo.getSkillName()!=null)
				callInfo.setSKILLNAME(transferVDNInfo.getSkillName());
			
			callInfo.setUUIDATA(strUUI);
			callInfo.setTRANSCODE(transferCode);
			callInfo.setDISPOSITION(AppConstant.XA);
			callInfo.setCALLENDREASON(AppConstant.TRANSFER);
			
			ivrreportdata.setCALLINFO(callInfo);
		
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Transfer VDN from DB"+transferVDNInfo.toString());
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Transfer VDN  :: "+mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_TRANSFER_VDN).getStringValue());
			
		}catch(Exception e){
			StackTrace.PrintException(e);
		}finally{
			if(transferVDN == null || AppConstant.EMPTY_STRING.equals(transferVDN)){
				key = AppConstant.DEFAULT_TRANSFER_VDN_+currentLanguage;
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Default Transfer VDN :"+key);
				defaultVDN = AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp(key);
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Default Transfer VDN :"+defaultVDN);
				mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_TRANSFER_VDN).setValue(defaultVDN);
			}
		}
	}
}