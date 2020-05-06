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
import com.rcom.mq.resource.MQInstance;
import com.rcom.util.AppConstant;
import com.rcom.util.StackTrace;
import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA;
import com.servion.prepaid.report.IVRREPORTDATA.ANNOUNCEDETAILS.ANNOUNCE;
import com.servion.prepaid.report.IVRREPORTDATA.CALLINFO;
import com.servion.prepaid.report.IVRREPORTDATA.MENUDETAILS.MENU;
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
 * Last generated by Orchestration Designer at: 2015-SEP-15  01:55:06 PM
 */
public class EndCallProcess_BC extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-SEP-15  01:55:06 PM
	 */
	public EndCallProcess_BC() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-SEP-13  03:14:21 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("End", "Default");
		next.setDebugId(32);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2017-SEP-13  03:14:21 PM
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
	 * Last generated by Orchestration Designer at: 2017-SEP-13  03:14:21 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(2);
		actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:isLoop", "yes", true).setDebugId(8863));
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
		String last5Menu = AppConstant.EMPTY_STRING;
		IVRDataBean ivrDataBean = (IVRDataBean) mySession.getProperty(AppConstant.IVRDATABEAN);
		ITraceInfo trace = null;
		Result reportData = null;
		String strDTMFPath =  AppConstant.EMPTY_STRING;
		String strMenuOption =  AppConstant.EMPTY_STRING , priority = AppConstant.EMPTY_STRING;
		String strMenuPath =  AppConstant.EMPTY_STRING , language = AppConstant.EMPTY_STRING; 
		String strAnnouncePath =  AppConstant.EMPTY_STRING,circleID = AppConstant.EMPTY_STRING;
		String priorityFlag = AppConstant.EMPTY_STRING;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		GetReportObject getReportObject = null;
		IVRREPORTDATA ivrreportdata = null;
		CALLINFO callInfo = null;
		
		try {
			getReportObject = ivrDataBean.getGetReportObject();
			ivrreportdata = getReportObject.getIvrreportdata();
			callInfo = ivrreportdata.getCALLINFO();
			trace = mySession.getTraceOutput();
			
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
			
			callInfo.setLANGCODE(mySession.getCurrentLanguage());
			callInfo.setENDDATETIME(dateFormat.format(new Date()));
			callInfo.setDTMFPATH(strDTMFPath);
			callInfo.setMENUPATH(strMenuPath);
			
			/***Circle ID ***/
			circleID = mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_CIRCLE_ID).getStringValue();
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Cricle ID :"+circleID);
			callInfo.setCIRCLEID(circleID);
			
			/***Language ***/
			language = mySession.getCurrentLanguage();
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Language :"+language);
			callInfo.setLANGCODE(language);
		
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
			StackTrace.PrintException(e);
			callInfo.setLANGCODE(mySession.getCurrentLanguage());
			callInfo.setENDDATETIME(dateFormat.format(new Date()));
			mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_EXCEPTION).setValue(AppConstant.Yes);
		}finally{
			ivrreportdata.setCALLINFO(callInfo);
		}
	}
}
