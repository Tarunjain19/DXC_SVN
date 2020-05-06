package flow;

import org.apache.log4j.Logger;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.otherflows.model.IVRRoutingInfo;
import com.rcom.otherflows.resource.IVRDBServiceInstance;
import com.rcom.rdtv.Constants;
import com.rcom.rdtv.StackTrace;
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
 * Last generated by Orchestration Designer at: 2015-MAY-21  08:18:36 PM
 */
public class CheckSelection extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-21  08:18:36 PM
	 */
	public CheckSelection() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2016-MAY-12  05:47:07 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("ThankYouAnnc", "TriesExceeded");
		next.setDebugId(338);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2016-MAY-12  05:47:07 PM
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
	 * Last generated by Orchestration Designer at: 2016-MAY-12  05:47:07 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "LanguageSelection_MN:ReturnCode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:Success", true).setDebugId(618)).evaluate(mySession)) {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "LanguageSelection_MN:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Grammars:Marathi", true).setDebugId(619)).evaluate(mySession)) {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "Selected Language", "LanguageSelection_MN:Value").setDebugId(622));
				actions.add(new com.avaya.sce.runtime.Next("AccessRCOMDTH", "Marathi").setDebugId(631));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "LanguageSelection_MN:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Grammars:Hindi", true).setDebugId(623)).evaluate(mySession)) {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "Selected Language", "LanguageSelection_MN:Value").setDebugId(627));
				actions.add(new com.avaya.sce.runtime.Next("AccessRCOMDTH", "Hindi").setDebugId(632));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "Selected Language", "LanguageSelection_MN:Value").setDebugId(630));
				actions.add(new com.avaya.sce.runtime.Next("AccessRCOMDTH", "English").setDebugId(633));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferPoint", "RD02_TR_0003", true).setDebugId(3514));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		}

		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
	
	@Override
	public void requestBegin(SCESession mySession) {

		AppProperties ivrProperties = null;
		
		try{
		
			Logger logger = Logger.getLogger(this.getClass());
			ITraceInfo trace = mySession.getTraceOutput();
			
			String sessionId = mySession.getSessionId();
			String ANI = mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_ANI).getStringValue();
			String DNIS = mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_DNIS).getStringValue();
			String returnCode = mySession.getVariableField(IProjectVariables.LANGUAGE_SELECTION__MN, IProjectVariables.LANGUAGE_SELECTION__MN_FIELD_RETURN_CODE).getStringValue();
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "SESSION ID : " +sessionId);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "ANI : " +ANI);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "DNIS : " +DNIS);
			
			ivrProperties = AppProperties.GetInstance(Constants.IVR_CONFIG_FILE_NAME);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "CONFIG FILE NAME :: "+Constants.IVR_CONFIG_FILE_NAME);
		
			//Setting IVRDataBean in session for DB Transactions - Start
			IVRDataBean ivrDataBean = new IVRDataBean();
			ivrDataBean.setSessionID(sessionId);
			ivrDataBean.setLogger(logger);
			
			IVRRoutingInfo reqIvrRoutingInfo = new IVRRoutingInfo();
			reqIvrRoutingInfo.setDnis(DNIS);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Calling DB service IVRRoutingInfo to get circle.");
			IVRRoutingInfo resIvrRoutingInfo = IVRDBServiceInstance.getIVRDBInstance().getIVRRoutingInfo(ivrDataBean, reqIvrRoutingInfo);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "IVR Routing Info" +resIvrRoutingInfo.toString());
			String circle = resIvrRoutingInfo.getCircle();
			String defaultLang = resIvrRoutingInfo.getDefaultLanguage();
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Circle : " +circle);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "DefaultLanguage : " +defaultLang);
			
			if(returnCode.equalsIgnoreCase(Constants.SUCCESS))
			{
				defaultLang = mySession.getVariableField(IProjectVariables.LANGUAGE_SELECTION__MN, IProjectVariables.LANGUAGE_SELECTION__MN_FIELD_VALUE).getStringValue();
			if(defaultLang !=null && !defaultLang.equalsIgnoreCase(Constants.EMPTY_STRING))
			{
				String DM_Properties_Location =  ivrProperties.getIVRProp(Constants.DM_PROPERTIES_LOCATION+defaultLang);
				mySession.setCurrentLanguage(defaultLang);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "DM_Properties_Location : " +DM_Properties_Location);
				mySession.getVariableField(IProjectVariables.DM__INPUT, IProjectVariables.DM__INPUT_FIELD_DM__PROPERTIES_LOCATION).setValue(DM_Properties_Location);
			}
			else 
			{
				String DM_Properties_Location_default =  ivrProperties.getIVRProp(Constants.DM_PROPERTIES_LOCATION+ivrProperties.getIVRProp(Constants.DEFAULT_LANGUAGE));
				mySession.setCurrentLanguage(ivrProperties.getIVRProp(Constants.DEFAULT_LANGUAGE));
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "DM_Properties_Location_Hindi : " +DM_Properties_Location_default);
				mySession.getVariableField(IProjectVariables.DM__INPUT, IProjectVariables.DM__INPUT_FIELD_DM__PROPERTIES_LOCATION).setValue(DM_Properties_Location_default);
			}
			}
			else
			{
				String DM_Properties_Location_default =  ivrProperties.getIVRProp(Constants.DM_PROPERTIES_LOCATION+defaultLang);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "DM_Properties_Location_Default : " +DM_Properties_Location_default);
				mySession.setCurrentLanguage(defaultLang);
				mySession.getVariableField(IProjectVariables.DM__INPUT, IProjectVariables.DM__INPUT_FIELD_DM__PROPERTIES_LOCATION).setValue(DM_Properties_Location_default);
			}
		}
		catch(Exception e) {
			mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_EXCEPTION).setValue(Constants.Yes);
			StackTrace.PrintException(e);
		}
		
	}
}