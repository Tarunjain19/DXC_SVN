package flow;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.smartphone.model.IVRRoutingInfo;
import com.rcom.smartphone.model.ValidateDealerMDN;
import com.rcom.smartphone.resource.IVRDBServiceInstance;
import com.rcom.util.AppConstant;
import com.rcom.util.StackTrace;
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
 * Last generated by Orchestration Designer at: 2015-SEP-21  01:12:09 PM
 */
public class DNISRoutingHit extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-SEP-21  01:12:09 PM
	 */
	public DNISRoutingHit() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2016-JAN-25  06:26:27 PM
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
	 * Last generated by Orchestration Designer at: 2016-JAN-25  06:26:27 PM
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
	 * Last generated by Orchestration Designer at: 2016-JAN-25  06:26:27 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(2);
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "Host Result ::", "appVariables:HostResult").setDebugId(487));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "appVariables:HostResult", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:Success", true).setDebugId(488)).evaluate(mySession)) {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "Flag:AppleMobileFlag", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:Success", true).setDebugId(5874)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("WelcomeApple_PP", "appleWelcome").setDebugId(490));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("Welcome_PP", "Normal").setDebugId(5876));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


		} else {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "SPIVR_TR_0010", true).setDebugId(492));
			actions.add(new com.avaya.sce.runtime.Next("LinkDown_PP", "LinkDown").setDebugId(491));
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
		String appName = AppConstant.EMPTY_STRING,hostOutput = AppConstant.ERROR,key=AppConstant.EMPTY_STRING,ani = AppConstant.EMPTY_STRING;
		String flag = AppConstant.EMPTY_STRING,serviceType = AppConstant.EMPTY_STRING,strExitState = AppConstant.EMPTY_STRING;
		IVRRoutingInfo objIVRRoutingInfo = null;
		IVRDataBean objIVRDataBean = null;
		ValidateDealerMDN objValidateDealerMDN= null ;
		ITraceInfo trace = mySession.getTraceOutput();
		
		try {
			
			/**Assigning**/
			dnis = mySession.getVariableField(IProjectVariables.SESSION,IProjectVariables.SESSION_FIELD_DNIS).getStringValue();
			appName = mySession.getVariableField(IProjectVariables.APPNAME).getStringValue();
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"DNIS :"+dnis +" - App Name :" + appName);
			objIVRRoutingInfo = new IVRRoutingInfo();
			objIVRDataBean = (IVRDataBean)mySession.getProperty(AppConstant.IVRDATABEAN);
			
			
			/**DB Hit**/
			objIVRRoutingInfo.setDnis(dnis);
			System.out.println("Object IVR Routing Info ::"+objIVRRoutingInfo);
			objIVRRoutingInfo = IVRDBServiceInstance.getIVRDBInstance().getIVRRoutingInfo(objIVRDataBean,objIVRRoutingInfo);
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
				
			
				if(defaultLanguage!=null && !AppConstant.EMPTY_STRING.equals(defaultLanguage))
					mySession.setCurrentLanguage(defaultLanguage);
				
				propetyKey = AppConstant.PROPERTY+appName+AppConstant.SEPERATOR_UNDERSCORE+defaultLanguage;
				
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"propety Key :"+propetyKey);
				propertiesLocation = AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp(propetyKey);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"properties Location :"+propertiesLocation);
				
				
				if(propertiesLocation!=null && !AppConstant.N.equalsIgnoreCase(propertiesLocation))
					mySession.getVariableField(IProjectVariables.DM__INPUT_PATH,IProjectVariables.DM__INPUT_PATH_FIELD_DM__PROPERTIES_LOCATION).setValue(propertiesLocation);
				else{
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"properties Location is Null");
					propertiesLocation = AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp(AppConstant.DEFAULT_PROPERTY_LOCATION);
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"default properties Location :"+propertiesLocation);
					mySession.getVariableField(IProjectVariables.DM__INPUT_PATH,IProjectVariables.DM__INPUT_PATH_FIELD_DM__PROPERTIES_LOCATION).setValue(propertiesLocation);
				}
				
				
			}
			else{
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"IVRRoutingInfo Object is null");
			}
			
			/*** MDN Verification ***/
			
			ani = mySession.getVariableField(IProjectVariables.SESSION,IProjectVariables.SESSION_FIELD_ANI).getStringValue();
			
			objValidateDealerMDN = new ValidateDealerMDN();
			objValidateDealerMDN.setMdn(ani);
			objValidateDealerMDN =IVRDBServiceInstance.getIVRDBInstance().getSmartPhoneFlagForApple(objIVRDataBean, objValidateDealerMDN);
			flag = objValidateDealerMDN.getStatus();
			serviceType =  objValidateDealerMDN.getBarringList();
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Smart Phone Status Flag :"+ flag);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Smart Phone Service Type :"+serviceType);
			
			if(serviceType != null && serviceType.contains(AppConstant.ABUSIVE)){
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "ABUSIVE Caller");
				mySession.getVariableField(IProjectVariables.FLAG,IProjectVariables.FLAG_FIELD_ABUSIVE_TYPE).setValue(AppConstant.Yes);
			}else{
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Not an ABUSIVE Caller");
				mySession.getVariableField(IProjectVariables.FLAG,IProjectVariables.FLAG_FIELD_ABUSIVE_TYPE).setValue(AppConstant.No);
			}
			
			mySession.getVariableField(IProjectVariables.FLAG,IProjectVariables.FLAG_FIELD_APPLE_MOBILE_FLAG).setValue(flag);
			
			hostOutput = AppConstant.Success;
			
		} catch (Exception e) {
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "Error in DNIS ROUTING :" +e);
			StackTrace.PrintException(e);
		}
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Host Status :" +hostOutput);
		mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_HOST_RESULT).setValue(hostOutput);
	}
}
