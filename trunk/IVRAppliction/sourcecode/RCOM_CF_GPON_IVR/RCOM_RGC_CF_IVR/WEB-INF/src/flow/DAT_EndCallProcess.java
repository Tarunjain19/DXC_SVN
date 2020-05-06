package flow;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Result;

import com.avaya.sce.runtime.tracking.TraceInfo;
import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.mq.resource.MQInstance;
import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA;
import com.servion.prepaid.report.IVRREPORTDATA.CALLINFO;
import com.hpe.util.AppConstant;
import com.servion.util.IVRDataBean;
import com.hpe.util.StackTrace;

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
 * Last generated by Orchestration Designer at: 2016-JUN-06  12:48:37 PM
 */
public class DAT_EndCallProcess extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2016-JUN-06  12:48:37 PM
	 */
	public DAT_EndCallProcess() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
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
			
			callInfo.setLANGCODE(mySession.getCurrentLanguage());
			callInfo.setENDDATETIME(dateFormat.format(new Date()));
			
			/***Circle ID ***/
			circleID = mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_CIRCLE_ID).getStringValue();
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Cricle ID :"+circleID);
			callInfo.setCIRCLEID(circleID);
			
			/***Language ***/
			language = mySession.getCurrentLanguage();
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Language :"+language);
			callInfo.setLANGCODE(language);
	
			
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
			mySession.getVariableField(IProjectVariables.FLAG__APPLICATION__ERROR).setValue(AppConstant.TRUE);
			TraceInfo.trace(ITraceInfo.TRACE_LEVEL_ERROR,"Error in SetReportDisconnect node" +e, mySession);
		}finally{
			ivrreportdata.setCALLINFO(callInfo);
		}
	}
	
	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2016-JUN-23  05:13:22 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = null;
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2016-JUN-23  05:13:22 PM
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
	 * Last generated by Orchestration Designer at: 2016-JUN-23  05:13:22 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "Flag_Application_Error", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:TRUE", true).setDebugId(16498)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("End", "Disconnect").setDebugId(16499));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("End", "Default").setDebugId(16501));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
