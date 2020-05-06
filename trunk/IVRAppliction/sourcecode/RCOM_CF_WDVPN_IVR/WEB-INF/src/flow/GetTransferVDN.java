package flow;

import java.util.List;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.otherflows.model.TransferVDNInfo;
import com.rcom.otherflows.resource.IVRDBServiceInstance;
import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA;
import com.servion.prepaid.report.IVRREPORTDATA.CALLINFO;
import com.servion.prepaid.report.IVRREPORTDATA.MENUDETAILS.MENU;
import com.servion.util.IVRDataBean;
import com.wdvpn.util.AppConstant;
import com.wdvpn.util.LoadProperty;
import com.wdvpn.util.StackTrace;

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
 * Last generated by Orchestration Designer at: 2015-APR-02  12:37:22 PM
 */
public class GetTransferVDN extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-APR-02  12:37:22 PM
	 */
	public GetTransferVDN() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-JUN-16  12:43:48 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("Transfer", "Default");
		next.setDebugId(291);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2017-JUN-16  12:43:48 PM
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
	 * Last generated by Orchestration Designer at: 2017-JUN-16  12:43:48 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "appVariables:networkError", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:yes", true).setDebugId(776)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("EndCallProcess", "network_error").setDebugId(777));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		}

		actions = new java.util.ArrayList(4);
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "UUI DATA :: ", "appVariables:uuiData").setDebugId(962));
		actions.add(new com.avaya.sce.runtime.varoperations.PrepareAAI("Shared", "", "appVariables:uuiData", "appVariables:uuiData").setDebugId(961));
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "UUU DATA :: ", "appVariables:uuiData").setDebugId(963));
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "Transfer Code :: ", "appVariables:TransferCode").setDebugId(292));
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
		String last5Menu = AppConstant.EMPTY_STRING;
		String strUUI = "";
		String menuID = "";
		String strAni = "";
		String strDNIS = "";
		String transferCode = "";
		try{
			
			/**Assigning the trace object**/
			info = mySession.getTraceOutput();
			
			/** getting the IVRData bean from session**/
			ivrDataBean = (IVRDataBean) mySession.getProperty(AppConstant.IVRDATABEAN);

			GetReportObject getReportObject = ivrDataBean.getGetReportObject();
			IVRREPORTDATA ivrreportdata = getReportObject.getIvrreportdata();
			CALLINFO callInfo = ivrreportdata.getCALLINFO();
			info = mySession.getTraceOutput();

			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Menu:"+ivrreportdata.getMENUDETAILS().getMENU());
			List<MENU> menuList = ivrreportdata.getMENUDETAILS().getMENU();
			
			if(menuList  !=null){
				
				for (int i = menuList.size(); (i> (menuList.size()-5)) && (i!=0); i-- ){
					menuID = menuList.get((i-1)).getMENUID();
					info.writeln(ITraceInfo.TRACE_LEVEL_INFO, "menu ID :"+menuID);
					last5Menu = last5Menu + menuID+"|";
				}
				info.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Last 5 menu accessed :"+last5Menu);
			}else{
				info.writeln(ITraceInfo.TRACE_LEVEL_INFO, "No Menu accessed");
			}
			strAni = mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_ANI).getStringValue();
			strDNIS = mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_DNIS).getStringValue();
			transferCode = mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_REASON_CODE).getStringValue();
			strUUI = strAni+"|"+strDNIS+"|"+mySession.getCurrentLanguage()+"|"+last5Menu+"|"+transferCode;
			mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_UUI_DATA).setValue(strUUI);
			
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "UUI data:"+strUUI);
			mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_UUI_DATA).setValue(strUUI);
			
			transferVDNInfo = new TransferVDNInfo();
			transferVDNInfo.setAppName(mySession.getVariableField(IProjectVariables.APP__NAME).getStringValue());
			transferVDNInfo.setCircle(mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_CIRCLE).getStringValue());
			transferVDNInfo.setCallType("4");
			transferVDNInfo.setCustomerSegment("3");
			transferVDNInfo.setLanguage(mySession.getCurrentLanguage());
			transferVDNInfo.setTransferReasonCode(mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_REASON_CODE).getStringValue());
			
			transferVDNInfo = IVRDBServiceInstance.getIVRDBInstance().getTransferVDN(ivrDataBean, transferVDNInfo);
			
			callInfo.setHOWCALLENDED("TRANSFER");
			if(transferVDNInfo.getTransferVDN1()!=null){
				callInfo.setAGENTEXTN(transferVDNInfo.getTransferVDN1());
				callInfo.setAGENTID(transferVDNInfo.getTransferVDN1());
				callInfo.setTRANSFERVDN(transferVDNInfo.getTransferVDN1());
			}else{
				
			}
			if(transferVDNInfo.getSkillName()!=null)
				callInfo.setSKILLNAME(transferVDNInfo.getSkillName());
			callInfo.setUUIDATA(strUUI);
			callInfo.setTRANSCODE(mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_REASON_CODE).getStringValue());
			callInfo.setDISPOSITION("XA");
			callInfo.setCALLENDREASON("TRANSFER");
			
			ivrreportdata.setCALLINFO(callInfo);
			if(transferVDNInfo.getTransferVDN1()==null){
				 mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_TRANSFER_VDN).setValue(LoadProperty.getivrconfigProp(mySession.getCurrentLanguage()+AppConstant.UNDERSCORE+AppConstant.DEFAULT_VDN));
				 callInfo.setTRANSFERVDN(LoadProperty.getivrconfigProp(mySession.getCurrentLanguage()+AppConstant.UNDERSCORE+AppConstant.DEFAULT_VDN));
			}else{
				mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_TRANSFER_VDN).setValue(transferVDNInfo.getTransferVDN1());
			}
			
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Transfer VDN from DB"+transferVDNInfo.toString());
			
		}catch(Exception e){
			mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_TRANSFER_VDN).setValue(LoadProperty.getivrconfigProp(mySession.getCurrentLanguage()+AppConstant.UNDERSCORE+AppConstant.DEFAULT_VDN));
			//mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_EXCEPTION).setValue(AppConstant.Yes);
			StackTrace.PrintException(e);
		}
	}
}