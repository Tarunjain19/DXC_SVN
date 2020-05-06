package flow;

import java.util.List;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.hni.model.TransferVDNInfo;
import com.rcom.hni.resource.IVRDBServiceInstance;
import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA;
import com.servion.prepaid.report.IVRREPORTDATA.CALLINFO;
import com.servion.prepaid.report.IVRREPORTDATA.MENUDETAILS.MENU;
import com.servion.triplefive.utils.Constants;
import com.servion.triplefive.utils.PrintStackTrace;
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
 * Last generated by Orchestration Designer at: 2015-APR-15  01:06:19 PM
 */
public class SetTransferData extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS
	
	@Override
	public void requestBegin(SCESession mySession) {
		super.requestBegin(mySession);
		
		ITraceInfo info = mySession.getTraceOutput();
		
		IVRDataBean ivrDataBean = null;
		TransferVDNInfo transferVDNInfo = null;
		String strApplicationName="", strCircle = "", strLanguage="", strReasonCode = "";
		String menuID = "", last5Menu = "", strUUI = "", strANI = "", strDNIS = "", strTransferVDN = "", strVIPCaller = "", strDefaultKey = "";
		AppProperties appProperties = null;
		
		appProperties = (AppProperties) mySession.getProperty(Constants.IvrPropertyInstance);
		ivrDataBean = (IVRDataBean) mySession.getProperty(Constants.IVRDATABEAN);
		GetReportObject getReportObject = ivrDataBean.getGetReportObject();
		IVRREPORTDATA ivrreportdata = getReportObject.getIvrreportdata();
		CALLINFO callInfo = ivrreportdata.getCALLINFO();
		mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.No);
		
		try {
			
			callInfo.setDISPOSITION("XA");
			callInfo.setHOWCALLENDED("TRANSFER");
			callInfo.setCALLENDREASON("TRANSFER");
			ivrreportdata.setCALLINFO(callInfo);
			
			strANI = mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_ANI).getStringValue();
			strDNIS = mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_DNIS).getStringValue();
			strVIPCaller = mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_HNICALLER).getStringValue();
			strReasonCode = mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_TRANSFER_REASON_CODE).getStringValue();
			strReasonCode = "POS_" + strReasonCode;
			strApplicationName = mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_APPLICATION_NAME).getStringValue();
			strCircle = mySession.getVariableField(IProjectVariables.ROUTING_INFO, IProjectVariables.ROUTING_INFO_FIELD_CIRCLE).getStringValue();
			strLanguage = mySession.getCurrentLanguage();
			
			callInfo.setTRANSCODE(strReasonCode);
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
				last5Menu = last5Menu+"|";
				info.writeln(ITraceInfo.TRACE_LEVEL_INFO, "No Menu accessed");
			}
			
			/** UUI DATA formation **/
			
			strUUI = strANI+"|"+strDNIS+"|"+last5Menu+strReasonCode;
			mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_UUI_DATA).setValue(strUUI);
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "UUI data:"+strUUI);			
			callInfo.setUUIDATA(strUUI);
		} catch (Exception e) {
			PrintStackTrace.PrintException(e);
		}
		
		try {
			
			/** DB Interaction-TransferVDN Request Formation **/
			transferVDNInfo = new TransferVDNInfo();
			transferVDNInfo.setAppName(strApplicationName);
			if(strApplicationName.contains(Constants.RTL)){
				transferVDNInfo.setCallType(Constants.seven);
				callInfo.setCALLERTYPE("RTL");
			}else if(strApplicationName.contains(Constants.CDMA)){
				callInfo.setCALLERTYPE("CDMA");
				transferVDNInfo.setCallType(Constants.five);
			}else{
				callInfo.setCALLERTYPE("GSM");
				transferVDNInfo.setCallType(Constants.six);
			}
			
			transferVDNInfo.setLanguage(mySession.getCurrentLanguage());
			if(strVIPCaller.equalsIgnoreCase(Constants.Yes)){
				transferVDNInfo.setCustomerSegment(Constants.one);
				callInfo.setCATEGORY("VIP");
			}
			else{
				transferVDNInfo.setCustomerSegment(Constants.two);
			}
			transferVDNInfo.setCircle(strCircle);
			transferVDNInfo.setTransferReasonCode(strReasonCode);
			transferVDNInfo = IVRDBServiceInstance.getInstance().getTransferVDN(ivrDataBean, transferVDNInfo);
			
			if(transferVDNInfo.getTransferVDN1()!=null){
				mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_TRANSFER_VDN).setValue(transferVDNInfo.getTransferVDN1());
				callInfo.setTRANSFERVDN(transferVDNInfo.getTransferVDN1());
				if(transferVDNInfo.getSkillName()!=null)
					callInfo.setSKILLNAME(transferVDNInfo.getSkillName());
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Transfer VDN from DB:"+transferVDNInfo.getTransferVDN1());
			}else{
				strDefaultKey = strApplicationName+Constants.HYPEN+strCircle+Constants.HYPEN+mySession.getCurrentLanguage()+Constants.HYPEN+Constants.DEFAULT_VDN;
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Default VDN Key:"+strDefaultKey);
				strTransferVDN = appProperties.getIVRProp(strDefaultKey);
				if(strTransferVDN!=null){
					if(!(strTransferVDN.equalsIgnoreCase("N"))){
						callInfo.setTRANSFERVDN(strTransferVDN);
						mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_TRANSFER_VDN).setValue(strTransferVDN);
					}
					else
						mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.Yes);
				}else
					mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.Yes);
				
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Trnsfer VDN from Property:"+strTransferVDN);
			}
			
		} catch (Exception e) {
			PrintStackTrace.PrintException(e);
			strDefaultKey = strApplicationName+Constants.HYPEN+strCircle+Constants.HYPEN+mySession.getCurrentLanguage()+Constants.HYPEN+Constants.DEFAULT_VDN;
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Default VDN Key:"+strDefaultKey);
			strTransferVDN = appProperties.getIVRProp(strDefaultKey);
			if(!(strTransferVDN.equalsIgnoreCase("N"))){
				callInfo.setTRANSFERVDN(strTransferVDN);
				mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_TRANSFER_VDN).setValue(strTransferVDN);
			}
			else
				mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.Yes);
		}
		
		
	}

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-APR-15  01:06:19 PM
	 */
	public SetTransferData() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:41 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("Transfer_PA_0093", "Default");
		next.setDebugId(972);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:41 PM
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
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:41 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(2);
		actions.add(new com.avaya.sce.runtime.varoperations.PrepareAAI("Shared", "", "CallData:uuiData", "CallData:uuiData").setDebugId(5648));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "Flag:isLinkDown", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:yes", true).setDebugId(3099)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("Transfer_PA_0092", "LinkDown").setDebugId(3100));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		}

		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}