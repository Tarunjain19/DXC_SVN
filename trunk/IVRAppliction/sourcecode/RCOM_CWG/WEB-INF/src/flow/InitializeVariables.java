package flow;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.postpaid.model.IVRRoutingInfo;
import com.servion.postpaid.utils.Constants;
import com.servion.postpaid.utils.PrintStackTrace;
import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA;
import com.servion.prepaid.report.IVRREPORTDATA.CALLINFO;
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
 * Last generated by Orchestration Designer at: 2015-APR-13  12:53:06 PM
 */
public class InitializeVariables extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	@Override
	public void requestBegin(SCESession mySession) {
		super.requestBegin(mySession);
		
		ITraceInfo info = mySession.getTraceOutput();
		
		/*Declaring variables*/
		IVRDataBean ivrDataBean = null;
		Logger logger = null;
		AppProperties audioPropertyInstance = null;
		AppProperties ivrConfigInstance = null;
		String strDNIS = "", strANI = "", strApplicationName = "";
		String strPropKey = "";
		IVRRoutingInfo ivrRoutingInfo = null;
		GetReportObject getReportObject = null;
		IVRREPORTDATA ivrreportdata = null;
		String strFreeUnitCount = "2", strUnbilledCount = "2", strBillInfoCount = "2", strDeliveryStatusCount = "2", strPaymentInfoCount = "2";
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		InetAddress ip = null;
		CALLINFO callInfo  = null;
		
		try{
			
			
			/*Assigning the values*/
			logger = Logger.getLogger(Constants.DB_LOGGER_NAME);
			audioPropertyInstance = AppProperties.GetInstance(Constants.AUDIO_CONFIG);
			ivrConfigInstance = AppProperties.GetInstance(Constants.IVR_CONFIG);
			
			/*initializing IVR data bean*/
			ivrDataBean = new IVRDataBean();
			ivrDataBean.setSessionID(mySession.getSessionId());
			ivrDataBean.setLogger(logger);
			
			getReportObject = new GetReportObject();
			ivrreportdata = getReportObject.createIVRReportObject();
			getReportObject.setIvrreportdata(ivrreportdata);
			ivrDataBean.setGetReportObject(getReportObject);
			
			/*Setting report*/
			ip= InetAddress.getLocalHost();
			callInfo  = ivrreportdata.getCALLINFO();
			callInfo.setUNIQUECALLID(mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_UCID).getStringValue());
			callInfo.setSESSIONID(mySession.getSessionId());
			callInfo.setVXMLIP(String.valueOf(ip));
			callInfo.setSTARTDATETIME(dateFormat.format(new Date()));
			callInfo.setAPPNAME(mySession.getVariable(IProjectVariables.APP_NAME).getSimpleVariable().getStringValue());
			callInfo.setCALLERTYPE(Constants.NA);
			callInfo.setCATEGORY("NORMAL");
			callInfo.setCIRCLEID(Constants.NA);
			callInfo.setCLI(mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_ANI).getStringValue());
			callInfo.setDNIS(mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_DNIS).getStringValue());
			callInfo.setDNISTYPE(Constants.NA);
			callInfo.setHUB(ivrConfigInstance.getIVRProp(Constants.HUB));
			callInfo.setAGENTID(Constants.NA);
			callInfo.setAGENTEXTN(Constants.NA);
			callInfo.setTRANSCODE(Constants.NA);
			callInfo.setTRANSFERVDN(Constants.NA);
			callInfo.setUUIDATA(Constants.NA);
			callInfo.setABANDONEDFLAG(Constants.NA);
			callInfo.setTRANSTOIVR(Constants.NA);
			callInfo.setSKILLNAME(Constants.NA);
			callInfo.setLANGCODE(Constants.NA);
			callInfo.setENDDATETIME(Constants.NA);
			callInfo.setDTMFPATH(Constants.NA);
			callInfo.setMENUPATH(Constants.NA);
			callInfo.setCALLERPATH(Constants.NA);
			callInfo.setLASTMENUACCESSED("NA");
			callInfo.setDISPOSITION("CD");
			callInfo.setCALLENDREASON("CALLER_DISCONNECT");
			callInfo.setHOWCALLENDED("DISCONNECT");
			callInfo.setERRREASON(Constants.NA);
			callInfo.setLASTNODEACCESSED(Constants.NA);
			callInfo.setLANGUAGEFROM(Constants.NA);
			callInfo.setLANGUAGETO(Constants.NA);
			callInfo.setTAGGING(Constants.NA);
			ivrreportdata.setCALLINFO(callInfo);
			
			ivrDataBean.setGetReportObject(getReportObject);
			strApplicationName = mySession.getVariableField(IProjectVariables.APP_NAME).getStringValue();
			strPropKey = strApplicationName+Constants.HYPEN+mySession.getCurrentLanguage()+Constants.UNDERSCORE+Constants.PROPERTY_FILE_PATH;
			
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->Property file path: "+AppProperties.GetInstance(Constants.IVR_CONFIG).getIVRProp(strPropKey));
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->Key: "+strPropKey);
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->Property file path: "+ivrConfigInstance.getIVRProp(strPropKey));
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->Allowed Main Menu count: "+ivrConfigInstance.getIVRProp(Constants.AllowedMainMenuCount));
			
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "---> ApplicationName:"+strApplicationName);
			mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_APPLICATION_NAME).setValue(strApplicationName);
			mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_ALLOWED_MAIN_MENU_COUNT).setValue(ivrConfigInstance.getIVRProp(Constants.AllowedMainMenuCount));
			mySession.getVariableField(IProjectVariables.DMPROPERTIES, IProjectVariables.DMPROPERTIES_FIELD_CONFIG_FILE_PATH).setValue(ivrConfigInstance.getIVRProp(strPropKey));
			strANI = mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_ANI).getStringValue();
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "---> Caller ANI:"+strANI);
			if(ivrConfigInstance.getIVRProp(strANI)!="N")
				strANI = ivrConfigInstance.getIVRProp(strANI);
			
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "---> Masked ANI:"+strANI);
			mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_MDN).setValue(strANI);
			
			if(!(ivrConfigInstance.getIVRProp(Constants.FreeUnitCount).equalsIgnoreCase("N")))
				strFreeUnitCount = ivrConfigInstance.getIVRProp(Constants.FreeUnitCount);
			if(!(ivrConfigInstance.getIVRProp(Constants.FreeUnitCount).equalsIgnoreCase("N")))
				strUnbilledCount = ivrConfigInstance.getIVRProp(Constants.UnbilledCount);
			if(!(ivrConfigInstance.getIVRProp(Constants.FreeUnitCount).equalsIgnoreCase("N")))
				strBillInfoCount = ivrConfigInstance.getIVRProp(Constants.BillInfoCount);
			if(!(ivrConfigInstance.getIVRProp(Constants.FreeUnitCount).equalsIgnoreCase("N")))
				strDeliveryStatusCount = ivrConfigInstance.getIVRProp(Constants.DeliveryStatusCount);
			if(!(ivrConfigInstance.getIVRProp(Constants.FreeUnitCount).equalsIgnoreCase("N")))
				strPaymentInfoCount = ivrConfigInstance.getIVRProp(Constants.PaymentInfoCount);
			
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Free unit info:"+strFreeUnitCount+", Unbilled Count:"+strUnbilledCount);
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Bill info:"+strBillInfoCount+", delivery status count:"+strDeliveryStatusCount+", PAyment info count:"+strPaymentInfoCount);
			mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_TOTAL_FREE_UNIT_COUNT).setValue(strFreeUnitCount);
			mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_TOTAL_UNBILLED_COUNT).setValue(strUnbilledCount);
			mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_TOTAL_BILL_INFO_COUNT).setValue(strBillInfoCount);
			mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_TOTAL_PAYMENT_INFO).setValue(strPaymentInfoCount);
			mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_TOTAL_BILL_DELIVERY_COUNT).setValue(strDeliveryStatusCount);
			strDNIS = mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_DNIS).getStringValue();
			if(strDNIS.equals(ivrConfigInstance.getIVRProp(Constants.CallBackDNIS))){
				mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_CALL_BACK).setValue(Constants.Yes);
			}
			
			if((strDNIS==null) || (strANI == null)){
				mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.Yes);
			}
			
			mySession.setProperty(Constants.BEANREPORTDATA, getReportObject);
			
			/*Setting call data to session*/
			mySession.setProperty(Constants.IVRDATABEAN, ivrDataBean);
			mySession.setProperty(Constants.LOGGER, logger);
			mySession.setProperty(Constants.AudioPropertyInstance, audioPropertyInstance);
			mySession.setProperty(Constants.IvrPropertyInstance, ivrConfigInstance);
		}catch (Exception e) {
			PrintStackTrace.PrintException(e);
		}finally{
			mySession.setProperty(Constants.BEANREPORTDATA, getReportObject);
		}
		
	}
	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-APR-13  12:53:06 PM
	 */
	public InitializeVariables() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2015-NOV-08  05:50:16 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("FetchDNISRoutingInfo", "Default");
		next.setDebugId(18);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2015-NOV-08  05:50:16 PM
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
	 * Last generated by Orchestration Designer at: 2015-NOV-08  05:50:16 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(2);
		actions.add(new com.avaya.sce.runtime.varoperations.Assign("CallData:transferReasonCode", "TR_0001", true).setDebugId(7338));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "Flag:isLinkDown", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:yes", true).setDebugId(5501)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("SetTechnicalDifficulties", "NO_DNIS_ANI").setDebugId(5502));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		}

		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
