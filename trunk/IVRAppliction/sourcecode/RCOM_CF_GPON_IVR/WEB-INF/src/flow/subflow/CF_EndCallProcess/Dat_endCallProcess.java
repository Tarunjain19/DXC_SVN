package flow.subflow.CF_EndCallProcess;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Result;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.utilities.IVRConstants;

import com.rcom.utilities.IVR_Utilities;
import com.rcom.mq.resource.MQInstance;
import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA;
import com.servion.prepaid.report.IVRREPORTDATA.CALLINFO;
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
 * Last generated by Orchestration Designer at: 2016-JAN-20  04:34:11 PM
 */
public class Dat_endCallProcess extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2016-JAN-20  04:34:11 PM
	 */
	public Dat_endCallProcess() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-JUL-27  12:38:48 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("CF_EndCallProcess-returnSuc", "Default");
		next.setDebugId(28);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2017-JUL-27  12:38:48 PM
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
	 * Last generated by Orchestration Designer at: 2016-JAN-20  04:34:11 PM
	 */
	@Override
	public void requestBegin(SCESession mySession) {
		
		super.requestBegin(mySession);
		String last5Menu = IVRConstants.NA;
		IVRDataBean ivrDataBean = (IVRDataBean) mySession.getProperty(IVRConstants.IVRDATABEAN);
		ITraceInfo trace = null;
		Result reportData = null;
		String strDTMFPath =  IVRConstants.EMPTY_QUOTES;
		String strMenuOption =  IVRConstants.EMPTY_QUOTES , priority = IVRConstants.EMPTY_QUOTES;
		String strMenuPath =  IVRConstants.EMPTY_QUOTES , language = IVRConstants.EMPTY_QUOTES; 
		String strAnnouncePath =  IVRConstants.EMPTY_QUOTES,circleID = IVRConstants.EMPTY_QUOTES;
		String strUUIData =  IVRConstants.EMPTY_QUOTES;
		String priorityFlag = IVRConstants.EMPTY_QUOTES;
	//	String language = IVRConstants.EMPTY_QUOTES;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		GetReportObject getReportObject = null;
		IVRREPORTDATA ivrreportdata = null;
		CALLINFO callInfo = null;
		IVR_Utilities ivrUti =null;
		try {
			getReportObject = ivrDataBean.getGetReportObject();
			ivrreportdata = getReportObject.getIvrreportdata();
			callInfo = ivrreportdata.getCALLINFO();
			trace = mySession.getTraceOutput();
			ivrUti=new IVR_Utilities();
			strMenuPath=mySession.getVariableField(IProjectVariables.CALL_DATA,IProjectVariables.CALL_DATA_FIELD_MENU_PATH).getStringValue();
			strAnnouncePath=mySession.getVariableField(IProjectVariables.CALL_DATA,IProjectVariables.CALL_DATA_FIELD_CALLER_PATH).getStringValue();
			strMenuOption=mySession.getVariableField(IProjectVariables.CALL_DATA,IProjectVariables.CALL_DATA_FIELD_DTMF_PATH).getStringValue();
			
			callInfo.setENDDATETIME(dateFormat.format(new Date()));
			callInfo.setDTMFPATH(strMenuOption);
			callInfo.setMENUPATH(strMenuPath);
			callInfo.setCALLERPATH(strAnnouncePath);
		
			
			
			
			/***Circle ID ***/
			circleID = mySession.getVariableField(IProjectVariables.CALL_DATA,IProjectVariables.CALL_DATA_FIELD_CIRCLE).getStringValue();
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Cricle ID :"+circleID);
			callInfo.setCIRCLEID(circleID);
			
			/***Language ***/
			
			language = mySession.getVariableField(IProjectVariables.CALL_DATA,IProjectVariables.CALL_DATA_FIELD_CURRENT_LANG).getStringValue();
			callInfo.setLANGCODE(language);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Language :"+language);

			
			String[] menuList = strMenuPath.split("\\|");
			
			if(menuList !=null && menuList.length!=0){
				int len=menuList.length;
				callInfo.setLASTMENUACCESSED(menuList[len-1]);
				callInfo.setLASTNODEACCESSED(menuList[len-1]);
			}
			
			
			
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
			callInfo.setENDDATETIME(dateFormat.format(new Date()));
			mySession.getVariableField(IProjectVariables.VAR__GPON, IProjectVariables.VAR__GPON_FIELD_JAVA__ERROR).setValue(IVRConstants.TRUE);
		}finally{
			ivrreportdata.setCALLINFO(callInfo);
		}
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
	 * Last generated by Orchestration Designer at: 2017-JUL-27  12:38:48 PM
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
