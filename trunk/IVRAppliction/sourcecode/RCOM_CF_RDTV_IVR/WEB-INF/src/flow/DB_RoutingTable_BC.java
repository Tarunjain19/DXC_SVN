package flow;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.otherflows.model.IVRRoutingInfo;
import com.rcom.otherflows.resource.IVRDBServiceInstance;
import com.rcom.rdtv.util.AppConstants;
import com.rcom.rdtv.util.StackTrace;
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
 * Last generated by Orchestration Designer at: 2015-MAY-26  11:42:10 AM
 */
public class DB_RoutingTable_BC extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-26  11:42:10 AM
	 */
	public DB_RoutingTable_BC() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:39 PM
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
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:39 PM
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
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:39 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "AppVariables:IsHostFailure", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "CONSTANTS:YES", true).setDebugId(6837)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("AppVariables:TransferPoint", "TransferPoints:RD01_TR_0002", false).setDebugId(6838));
			actions.add(new com.avaya.sce.runtime.Next("LinkDownAnnc", "linkdown").setDebugId(6839));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("HotFlashInfo:announceID", "HotFlashIDs:PA_0001", false).setDebugId(6941));
			actions.add(new com.avaya.sce.runtime.Next("start_HotFlash", "Default").setDebugId(168));
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
		ITraceInfo trace = mySession.getTraceOutput();
		
		/**Declaration **/
		String dnis = AppConstants.EMPTY_STRING,defaultLanguage = AppConstants.EMPTY_STRING,Language = AppConstants.EMPTY_STRING;
		String circleID = AppConstants.EMPTY_STRING,trunkID = AppConstants.EMPTY_STRING,propertiesLocation = AppConstants.EMPTY_STRING,propertyKey = AppConstants.EMPTY_STRING;
		String appName = AppConstants.EMPTY_STRING,key=AppConstants.EMPTY_STRING;
		IVRRoutingInfo objIVRRoutingInfo = null;
		IVRDataBean objIVRDataBean = null;
		
		
		try {
			
			/**Assigning**/
			dnis = mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_DNIS).getStringValue();
			appName = mySession.getVariableField(IProjectVariables.APP__NAME).getStringValue();
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"DNIS :"+dnis +" - App Name :" + appName);
			objIVRRoutingInfo = new IVRRoutingInfo();
			objIVRDataBean = (IVRDataBean)mySession.getProperty(AppConstants.IVRDATABEAN);
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG," IVR-DATA-BEAN :: "+objIVRDataBean.toString());
			
			/**DB Hit**/
			objIVRRoutingInfo.setDnis(dnis);
			objIVRRoutingInfo = IVRDBServiceInstance.getIVRDBInstance().getIVRRoutingInfo(objIVRDataBean,objIVRRoutingInfo);
			if(objIVRRoutingInfo!=null){
				circleID=objIVRRoutingInfo.getCircle();
				trunkID= objIVRRoutingInfo.getTrunkGroup();
				Language = objIVRRoutingInfo.getLanguage();
				defaultLanguage = objIVRRoutingInfo.getDefaultLanguage();
				
				/** Checking the Default Language and Language List **/
				if(defaultLanguage == null)
				{
					defaultLanguage = AppProperties.GetInstance(AppConstants.IVR_CONFIG_PROPERTIES).getIVRProp(AppConstants.Default_Language);
				}
				if(Language == null)
				{
					Language = AppProperties.GetInstance(AppConstants.IVR_CONFIG_PROPERTIES).getIVRProp(AppConstants.Default_Language);
				}
				
				/** Assign Language List Code **/
				mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_LANGUAGE_LIST).setValue(Language);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Language List :"+Language);
				/**Assign Circle ID **/
				mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_CIRCLE_ID).setValue(circleID);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"circle ID :"+circleID +"trunkID :" + trunkID );
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Default Language :"+defaultLanguage);
				
				if(defaultLanguage!=null && !AppConstants.EMPTY_STRING.equals(defaultLanguage))
					mySession.setCurrentLanguage(defaultLanguage);
				
				propertyKey = AppConstants.PROPERTY+appName+AppConstants.SEPERATOR_UNDERSCORE+defaultLanguage;
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"propety Key :"+propertyKey);
				propertiesLocation = AppProperties.GetInstance(AppConstants.IVR_CONFIG_PROPERTIES).getIVRProp(propertyKey);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"properties Location :"+propertiesLocation);
				
				if(propertiesLocation!=null && !AppConstants.N.equalsIgnoreCase(propertiesLocation))
					mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER,IProjectVariables.DM_INPUT_PARAMETER_FIELD_PROPERTY_FILE_LOCATION).setValue(propertiesLocation);
				else{
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"properties Location is Null");
					propertiesLocation = AppConstants.PROPERTY+appName+AppConstants.SEPERATOR_UNDERSCORE+AppProperties.GetInstance(AppConstants.IVR_CONFIG_PROPERTIES).getIVRProp(AppConstants.Default_Language);
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"default properties Location :"+propertiesLocation);
					mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER,IProjectVariables.DM_INPUT_PARAMETER_FIELD_PROPERTY_FILE_LOCATION).setValue(propertiesLocation);
				}
				}else
				{
					mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_HOST_FAILURE).setValue(AppConstants.Yes);
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"IVRRoutingInfo Object is null");
				}
			}
			catch (Exception e) {
				mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_HOST_FAILURE).setValue(AppConstants.Yes);
				trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "Error in DNIS ROUTING :" +e);
				StackTrace.PrintException(e);
			}
	}
}