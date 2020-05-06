package flow;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.ppp.model.IVRRoutingInfo;
import com.rcom.ppp.resource.IVRDBServiceInstance;
import com.servion.util.AppConstant;
import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;
import com.servion.util.StackTrace;

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
 * Last generated by Orchestration Designer at: 2015-MAR-11  11:36:23 PM
 */
public class IVR_DNIS_Routing extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAR-11  11:36:23 PM
	 */
	public IVR_DNIS_Routing() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-JUL-05  10:39:04 AM
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
	 * Last generated by Orchestration Designer at: 2017-JUL-05  10:39:04 AM
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
	 * Last generated by Orchestration Designer at: 2017-JUL-05  10:39:04 AM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "appVariables:HostResult", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:success", true).setDebugId(7445)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:HostResult", "constant:error", false).setDebugId(14831));
			actions.add(new com.avaya.sce.runtime.Next("WelcomeMessage", "(Success)").setDebugId(7449));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferReason", "TR_0001", true).setDebugId(14919));
			actions.add(new com.avaya.sce.runtime.Next("LinkDown", "(LinkDown)").setDebugId(7452));
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
	
		/**Declaration **/
		String dnis = AppConstant.EMPTY_STRING,defaultLanguage = AppConstant.EMPTY_STRING,Language = AppConstant.EMPTY_STRING;
		String circleID = AppConstant.EMPTY_STRING,trunkID = AppConstant.EMPTY_STRING,propertiesLocation = AppConstant.EMPTY_STRING,propetyKey = AppConstant.EMPTY_STRING;
		String appName = AppConstant.EMPTY_STRING,hostOutput = AppConstant.ERROR,key=AppConstant.EMPTY_STRING;
		IVRRoutingInfo objIVRRoutingInfo = null;
		IVRDataBean objIVRDataBean = null;

		ITraceInfo trace = mySession.getTraceOutput();
		
		try {
			
			/**Assigning**/
			dnis = mySession.getVariableField(IProjectVariables.SESSION,IProjectVariables.SESSION_FIELD_DNIS).getStringValue();
			appName = mySession.getVariableField(IProjectVariables.APP_NAME).getStringValue();
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"DNIS :"+dnis +" - App Name :" + appName);
			objIVRRoutingInfo = new IVRRoutingInfo();
			objIVRDataBean = (IVRDataBean)mySession.getProperty(AppConstant.IVRDATABEAN);
			
			
			/**DB Hit**/
			objIVRRoutingInfo.setDnis(dnis);
			objIVRRoutingInfo = IVRDBServiceInstance.getInstance().getIVRRoutingInfo(objIVRDataBean,objIVRRoutingInfo);
			if(objIVRRoutingInfo!=null){
				circleID=objIVRRoutingInfo.getCircle();
				trunkID= objIVRRoutingInfo.getTrunkGroup();
				Language = objIVRRoutingInfo.getLanguage();
				defaultLanguage = objIVRRoutingInfo.getDefaultLanguage();
				
				/** Assign Language List Code **/
				mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_LANGUAGE_LIST).setValue(Language);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Language List :"+Language);
				
				/**Assign Circle ID **/
				mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_CIRCLE_ID).setValue(circleID);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"circle ID :"+circleID +"trunkID :" + trunkID );
				
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"trunk ID :"+trunkID);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Default Language :"+defaultLanguage);
				
				/*key = AppConstant.Language_Code+defaultLanguageCode;
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Language_Code Key:"+key);
				defaultLanguage=(String) AppDataMap.getInstance(appName).getAppData(key);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Default Language :"+defaultLanguage);*/
				
				if(defaultLanguage!=null && !AppConstant.EMPTY_STRING.equals(defaultLanguage))
					mySession.setCurrentLanguage(defaultLanguage);
				
				propetyKey = AppConstant.PROPERTY+appName+AppConstant.SEPERATOR_UNDERSCORE+defaultLanguage;
				
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"propety Key :"+propetyKey);
				propertiesLocation = AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp(propetyKey);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"properties Location :"+propertiesLocation);
				
				if(propertiesLocation!=null && !AppConstant.N.equalsIgnoreCase(propertiesLocation))
					mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER,IProjectVariables.DM_INPUT_PARAMETER_FIELD_PROPERTY_FILE_LOCATION).setValue(propertiesLocation);
				else{
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"properties Location is Null");
					propertiesLocation = AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp(AppConstant.DEFAULT_PROPERTY_LOCATION);
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"default properties Location :"+propertiesLocation);
					mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER,IProjectVariables.DM_INPUT_PARAMETER_FIELD_PROPERTY_FILE_LOCATION).setValue(propertiesLocation);
				}
				
				hostOutput = AppConstant.Success;
			}
			else{
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"IVRRoutingInfo Object is null");
			}
			
		} catch (Exception e) {
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "Error in DNIS ROUTING :" +e);
			StackTrace.PrintException(e);
		}
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Host Status :" +hostOutput);
		mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_HOST_RESULT).setValue(hostOutput);
	}
	
}