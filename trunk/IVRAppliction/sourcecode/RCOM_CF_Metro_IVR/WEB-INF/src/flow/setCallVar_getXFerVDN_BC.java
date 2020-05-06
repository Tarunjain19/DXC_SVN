package flow;

import java.util.List;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.metro.Constants;
import com.rcom.metro.StackTrace;
import com.rcom.metro.model.TransferVDNInfo;
import com.rcom.metro.resource.IVRDBServiceInstance;
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
 * Last generated by Orchestration Designer at: 2015-APR-02  05:31:27 PM
 */
public class setCallVar_getXFerVDN_BC extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-APR-02  05:31:27 PM
	 */
	public setCallVar_getXFerVDN_BC() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	@Override
	public void requestBegin(SCESession mySession) {
	
		
		TransferVDNInfo transferVDNInfo = null;
		IVRDataBean ivrDataBean = null;
		AppProperties ivrProperties = null;
		String last5Menu = Constants.EMPTY;
		ITraceInfo trace = null;
		String strUUI = "";
		String menuID = "";
		
		try{
		
			trace = mySession.getTraceOutput();
			ivrProperties = AppProperties.GetInstance(Constants.IVR_CONFIG);
			
			/** getting the IVRData bean from session**/
			ivrDataBean = (IVRDataBean) mySession.getProperty(Constants.IVR_DATA_BEAN);

			GetReportObject getReportObject = ivrDataBean.getGetReportObject();
			IVRREPORTDATA ivrreportdata = getReportObject.getIvrreportdata();
			CALLINFO callInfo = ivrreportdata.getCALLINFO();
			trace = mySession.getTraceOutput();

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
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "No Menu accessed");
			}
			
			String language = mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_LANGUAGE).getStringValue();
			String transerCode = mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_TRANSFER_POINT).getStringValue();
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "LANGUAGE : " +language);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "TRANSFER CODE : " +transerCode);
			
			strUUI = mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_UUI_DATA).getStringValue();
			strUUI = strUUI+language+"|"+last5Menu + transerCode;
			mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_UUI_DATA).setValue(strUUI);
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "UUI data:"+strUUI);
			mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_UUI_DATA).setValue(strUUI);
			
			transferVDNInfo = new TransferVDNInfo();
			transferVDNInfo.setAppName(mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_APP_NAME).getStringValue());
			transferVDNInfo.setCircle(mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_CIRCLE).getStringValue());
			transferVDNInfo.setCallType("4");
			transferVDNInfo.setCustomerSegment("3");
			transferVDNInfo.setLanguage(language);
			transferVDNInfo.setTransferReasonCode(transerCode);
			
			transferVDNInfo = IVRDBServiceInstance.getIVRDBInstance().getTransferVDN(ivrDataBean, transferVDNInfo);
			
			callInfo.setHOWCALLENDED("TRANSFER");
			if(transferVDNInfo.getTransferVDN1()!=null){
				callInfo.setAGENTEXTN(transferVDNInfo.getTransferVDN1());
				callInfo.setAGENTID(transferVDNInfo.getTransferVDN1());
				callInfo.setTRANSFERVDN(transferVDNInfo.getTransferVDN1());
			}else{
				callInfo.setAGENTEXTN(ivrProperties.getIVRProp(mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_LANGUAGE).getStringValue()+Constants.UNDERSCORE+Constants.DEFAULT_VDN));
				callInfo.setAGENTID(ivrProperties.getIVRProp(mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_LANGUAGE).getStringValue()+Constants.UNDERSCORE+Constants.DEFAULT_VDN));
			}
			if(transferVDNInfo.getSkillName()!=null)
				callInfo.setSKILLNAME(transferVDNInfo.getSkillName());
			
			callInfo.setUUIDATA(strUUI);
			callInfo.setTRANSCODE(transerCode);
			callInfo.setDISPOSITION("XA");
			callInfo.setCALLENDREASON("TRANSFER");
			
			ivrreportdata.setCALLINFO(callInfo);
			if(transferVDNInfo.getTransferVDN1()==null){
				 mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_TRANSFER_VDN).setValue(ivrProperties.getIVRProp(mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_LANGUAGE).getStringValue()+Constants.UNDERSCORE+Constants.DEFAULT_VDN));
			}else{
				mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_TRANSFER_VDN).setValue(transferVDNInfo.getTransferVDN1());
			}
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Transfer VDN from DB"+transferVDNInfo.toString());
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Transfer VDN  :: "+mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_TRANSFER_VDN).getStringValue());
		
		}catch(Exception e) {
			mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_TRANSFER_VDN).setValue(ivrProperties.getIVRProp(mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_LANGUAGE).getStringValue()+Constants.UNDERSCORE+Constants.DEFAULT_VDN));
			//mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_EXCEPTION).setValue(AppConstant.Yes);
			StackTrace.PrintException(e);
		}
	}
	
	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2016-JAN-28  05:42:46 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("CallTransfer", "Success");
		next.setDebugId(1658);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2016-JAN-28  05:42:46 PM
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
	 * Last generated by Orchestration Designer at: 2016-JAN-28  05:42:46 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(4);
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "UUI DATA :: ", "appVariables:uuiData").setDebugId(2163));
		actions.add(new com.avaya.sce.runtime.varoperations.PrepareAAI("Shared", "", "appVariables:uuiData", "appVariables:uuiData").setDebugId(2162));
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "UUI DATA :: ", "appVariables:uuiData").setDebugId(2164));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}