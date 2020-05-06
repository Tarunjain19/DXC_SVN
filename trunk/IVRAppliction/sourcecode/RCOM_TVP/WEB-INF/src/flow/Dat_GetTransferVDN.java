package flow;

import java.util.List;

import com.avaya.sce.runtime.Data.VariableInfo;
import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.hp.utilities.IVRConstants;
import com.hp.utilities.TVP_Properties;
import com.hp.utilities.TVP_Utilities;

import com.rcom.otherflows.model.TransferVDNInfo;
import com.rcom.otherflows.resource.IVRDBServiceInstance;

import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA;
import com.servion.prepaid.report.IVRREPORTDATA.CALLINFO;
import com.servion.prepaid.report.IVRREPORTDATA.MENUDETAILS.MENU;
import com.servion.util.AppConstant;
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
 * Last generated by Orchestration Designer at: 2015-MAR-18  02:37:05 PM
 */
public class Dat_GetTransferVDN extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAR-18  02:37:05 PM
	 */
	public Dat_GetTransferVDN() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2015-NOV-09  04:01:34 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("blindTransfer", "success");
		next.setDebugId(289);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2015-NOV-03  02:03:09 PM
	 */
	
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
	 * Last generated by Orchestration Designer at: 2015-NOV-03  02:03:09 PM
	 */
	public void requestBegin(SCESession mySession) {
		super.requestBegin(mySession);
		
		///String strDataCardFlag = null;
		String strReasonCode = null;
		String strTransferVDN = null;
		String strInitialAudios = null;
		TransferVDNInfo transferVDNInfo = null;
		IVRDataBean ivrDataBean = null;
		GetReportObject getReportObject = null;
		IVRREPORTDATA ivrreportdata = null;
		String propLocation =null;
		TVP_Properties tvpProp=null;
		CALLINFO callInfo = null;
		ITraceInfo info = null;
		String last5Menu ="";
		ITraceInfo trace = null;
		String strUUI = "";
		String menuID = "";
		String strANI = "";
		String strDNIS = "";
		String verifyMDN = "";
		String language="";
		String transferAnnwav="";
		String strCircle="";
		String strLanguage="";
		/**Assigning the trace object**/
		info = mySession.getTraceOutput();
		
		/** getting the IVRData bean from session**/
		ivrDataBean =  (IVRDataBean) mySession.getProperty(IVRConstants.IVRDATABEAN);
		/** getting the config path from session**/
		propLocation=mySession.getVariableField(IProjectVariables.VAR__CONFIG,IProjectVariables.VAR__CONFIG_FIELD_CONFIG_FILE_PATH).getStringValue();
		tvpProp=TVP_Properties.getInstance(propLocation, mySession);
		/**Deciding the transfer flow**/
		strReasonCode = mySession.getVariableField(IProjectVariables.CALL_INFO, IProjectVariables.CALL_INFO_FIELD_TRANSFER_REASON_CODE).getStringValue();
				
		getReportObject = ivrDataBean.getGetReportObject();
		ivrreportdata = getReportObject.getIvrreportdata();
		callInfo = ivrreportdata.getCALLINFO();
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
		
		strANI = mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_ANI).getStringValue();
		strDNIS = mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_DNIS).getStringValue();
		verifyMDN =mySession.getVariableField(IProjectVariables.CALL_INFO, IProjectVariables.CALL_INFO_FIELD_TVP_MDN).getStringValue();
		language=mySession.getVariableField(IProjectVariables.CALL_INFO, IProjectVariables.CALL_INFO_FIELD_CURRENT_LANGUAGE).getStringValue();
		strUUI = strANI+"|"+strDNIS+"|"+language+"|"+verifyMDN+"|"+last5Menu+"|"+strReasonCode;
		mySession.getVariableField(IProjectVariables.CALL_INFO, IProjectVariables.CALL_INFO_FIELD_UUIDATA).setValue(strUUI);
		
		info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "UUI data:"+strUUI);
		
		transferVDNInfo = new TransferVDNInfo();
		transferVDNInfo.setAppName(tvpProp.getProperty(mySession, IVRConstants.APPLICATION_NAME));
		transferVDNInfo.setCircle(mySession.getVariableField(IProjectVariables.CALL_INFO, IProjectVariables.CALL_INFO_FIELD_CIRCLE).getStringValue());
		transferVDNInfo.setCallType("4");
		transferVDNInfo.setCustomerSegment("3");
		transferVDNInfo.setLanguage(language);
		transferVDNInfo.setTransferReasonCode(strReasonCode);
		/*Testing */
		//transferVDNInfo = IVRDBServiceInstance.getIVRDBInstance().getTransferVDN(ivrDataBean, transferVDNInfo);
		
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
		callInfo.setTRANSCODE(strReasonCode);
		callInfo.setDISPOSITION("XA");
		callInfo.setCALLENDREASON("TRANSFER");
		
		ivrreportdata.setCALLINFO(callInfo);
		if(transferVDNInfo.getTransferVDN1()==null){
			 strCircle=mySession.getVariableField(IProjectVariables.CALL_INFO, IProjectVariables.CALL_INFO_FIELD_CIRCLE).getStringValue();
			 strLanguage=mySession.getVariableField(IProjectVariables.CALL_INFO, IProjectVariables.CALL_INFO_FIELD_CURRENT_LANGUAGE).getStringValue();
			System.out.println(strCircle);
			System.out.println(strLanguage);
			String strTransferVDNKey=strCircle+strLanguage+IVRConstants.TRANSFER_VDN;
			strTransferVDN = tvpProp.getProperty(mySession,strTransferVDNKey);
			//info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Transfer VDNKEY"+strTransferVDNKey);
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Transfer VDN"+strTransferVDN);
			if(strTransferVDN==null)
			{
				strTransferVDN=tvpProp.getProperty(mySession,IVRConstants.DEFAULT_TRANSFERVDN);
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Transfer VDN2"+strTransferVDN);
			}
				
			mySession.getVariableField(IProjectVariables.CALL_INFO, IProjectVariables.CALL_INFO_FIELD_TRANSFER_VDN).setValue(strTransferVDN);
			callInfo.setAGENTEXTN(strTransferVDN);
			callInfo.setAGENTID(strTransferVDN);
			callInfo.setTRANSFERVDN(strTransferVDN);
		}
		else{
			mySession.getVariableField(IProjectVariables.CALL_INFO, IProjectVariables.CALL_INFO_FIELD_TRANSFER_VDN).setValue(transferVDNInfo.getTransferVDN1());
			
		}
		
		info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Transfer VDN from DB"+transferVDNInfo.toString());
		String transferAnnKey=mySession.getVariableField(IProjectVariables.CALL_INFO,IProjectVariables.CALL_INFO_FIELD_PRODUCT_TYPE).getStringValue()+IVRConstants.UNDER_SCORE+IVRConstants.TRANSFER;
		transferAnnwav=tvpProp.getProperty(mySession, transferAnnKey);
				
		if( transferAnnwav!=null)
			mySession.getVariableField(IProjectVariables.CALL_INFO, IProjectVariables.CALL_INFO_FIELD_ANN__TRANSFER).setValue(transferAnnwav);
		else
		{
			mySession.getVariableField(IProjectVariables.CALL_INFO, IProjectVariables.CALL_INFO_FIELD_ANN__TRANSFER).setValue(tvpProp.getProperty(mySession,IVRConstants.DEFAULT+IVRConstants.TRANSFER));
			System.out.println(mySession.getVariableField(IProjectVariables.CALL_INFO, IProjectVariables.CALL_INFO_FIELD_ANN__TRANSFER).getStringValue());
		}
			
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2015-OCT-19  11:41:48 AM
	 */
	
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
	 * Last generated by Orchestration Designer at: 2015-NOV-09  04:01:34 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(2);
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "Transfer VDN :: ", "").setDebugId(288));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2015-NOV-09  04:01:34 PM
	 */
	public java.util.Collection<VariableInfo> getLocalVariables(){
		java.util.Collection<VariableInfo> variables = new java.util.ArrayList<VariableInfo>();

		return variables;
	}
}