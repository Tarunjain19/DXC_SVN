package flow;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Result;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.hp.utilities.IVRConstants;
import com.hp.utilities.TVP_Utilities;
import com.rcom.mq.resource.MQInstance;
import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA;
import com.servion.prepaid.report.IVRREPORTDATA.ANNOUNCEDETAILS.ANNOUNCE;
import com.servion.prepaid.report.IVRREPORTDATA.CALLINFO;
import com.servion.prepaid.report.IVRREPORTDATA.MENUDETAILS.MENU;
import com.servion.util.AppConstant;
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
 * Last generated by Orchestration Designer at: 2015-MAY-07  04:28:13 PM
 */
public class Dat_EndCallProcess extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	@Override
	public void requestBegin(SCESession mySession) {
		
		super.requestBegin(mySession);
		String last5Menu = IVRConstants.NODATA;
		IVRDataBean ivrDataBean = (IVRDataBean) mySession.getProperty(IVRConstants.IVRDATABEAN);
		ITraceInfo trace = null;
		Result reportData = null;
		String strDTMFPath =  IVRConstants.EMPTY_QUOTES;
		String strMenuOption =  IVRConstants.EMPTY_QUOTES , priority = IVRConstants.EMPTY_QUOTES;
		String strMenuPath =  IVRConstants.EMPTY_QUOTES , language = IVRConstants.EMPTY_QUOTES; 
		String strAnnouncePath =  IVRConstants.EMPTY_QUOTES,circleID = IVRConstants.EMPTY_QUOTES;
		String priorityFlag = IVRConstants.EMPTY_QUOTES;
	//	String language = IVRConstants.EMPTY_QUOTES;
		//SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		GetReportObject getReportObject = null;
		IVRREPORTDATA ivrreportdata = null;
		CALLINFO callInfo = null;
		TVP_Utilities TVP_Util =null;
		try {
			getReportObject = ivrDataBean.getGetReportObject();
			ivrreportdata = getReportObject.getIvrreportdata();
			callInfo = ivrreportdata.getCALLINFO();
			trace = mySession.getTraceOutput();
			TVP_Util=new TVP_Utilities();
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Menu:"+ivrreportdata.getMENUDETAILS().getMENU());
	
			List<MENU> menuList = ivrreportdata.getMENUDETAILS().getMENU();
			
			if(menuList  !=null){
				for (int i = menuList.size(); (i>= menuList.size()-5) && (i!=0); i-- ){
					strMenuOption = menuList.get((i-1)).getMENUOPTION();
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "menu ID :"+strDTMFPath);
					strDTMFPath = strDTMFPath+"|"+strMenuOption;
					strMenuPath = strMenuPath+"|"+menuList.get((i-1)).getMENUID();
					
				}
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Last 5 menu accessed :"+last5Menu);
			}else{
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "No Menu accessed");
			}
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Menu:"+ivrreportdata.getMENUDETAILS().getMENU());
			
			List<ANNOUNCE> announceList = ivrreportdata.getANNOUNCEDETAILS().getANNOUNCE();
			
			if(announceList  !=null){
				for (int i = 0; i< announceList.size(); i++ ){
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "announce ID :"+strDTMFPath);
					strAnnouncePath = strAnnouncePath+"|"+announceList.get(i).getANNOUNCEID();
				}
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Announcement accessed :"+strAnnouncePath);
			}else{
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "No Announce");
			}
			
			callInfo.setENDDATETIME(TVP_Util.getDateTime());
			callInfo.setDTMFPATH(strDTMFPath);
			callInfo.setMENUPATH(strMenuPath);
			
			
			/***Circle ID ***/
			circleID = mySession.getVariableField(IProjectVariables.CALL_INFO,IProjectVariables.CALL_INFO_FIELD_CIRCLE).getStringValue();
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Cricle ID :"+circleID);
			callInfo.setCIRCLEID(circleID);
			
			/***Language ***/
		
			language = mySession.getVariableField(IProjectVariables.CALL_INFO,IProjectVariables.CALL_INFO_FIELD_CURRENT_LANGUAGE).getStringValue();
			callInfo.setLANGCODE(language);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Language :"+language);

			
			
			
			if(menuList !=null && menuList.size()!=0){
				callInfo.setLASTMENUACCESSED(menuList.get(menuList.size()-1).getMENUID());
				callInfo.setLASTNODEACCESSED(menuList.get(menuList.size()-1).getMENUID());
			}
			callInfo.setCALLERPATH(strAnnouncePath);
			
			
			JAXBContext context = JAXBContext.newInstance(IVRREPORTDATA.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.setProperty(Marshaller.JAXB_ENCODING, "utf-16");
			StringWriter stringWriter = new StringWriter(); 
			m.marshal(ivrDataBean.getGetReportObject().getIvrreportdata(), stringWriter);
			
		  MQInstance.sendRequestToMQ(stringWriter.toString(), mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_UCID).getStringValue());
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Report XML:"+stringWriter.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
			callInfo.setLANGCODE(mySession.getCurrentLanguage());
			callInfo.setENDDATETIME(TVP_Util.getDateTime());
			mySession.getVariableField(IProjectVariables.TVP__VARS, IProjectVariables.TVP__VARS_FIELD_EXCEPTION).setValue(IVRConstants.TRUE);
		}finally{
			ivrreportdata.setCALLINFO(callInfo);
		}
	}
	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-07  04:28:13 PM
	 */
	public Dat_EndCallProcess() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2015-NOV-09  04:07:17 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("End", "Default");
		next.setDebugId(301);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2015-NOV-09  04:07:17 PM
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
	 * Last generated by Orchestration Designer at: 2015-NOV-09  04:07:17 PM
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
}
