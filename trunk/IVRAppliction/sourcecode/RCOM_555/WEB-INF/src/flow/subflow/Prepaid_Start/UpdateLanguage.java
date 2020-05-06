package flow.subflow.Prepaid_Start;

import java.util.ArrayList;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.hni.resource.IVRDBServiceInstance;
import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA;
import com.servion.prepaid.report.IVRREPORTDATA.CALLINFO;
import com.servion.triplefive.utils.AppConstant;
import com.servion.triplefive.utils.AppDataMap;
import com.servion.triplefive.utils.Constants;
import com.servion.triplefive.utils.DynamicMenu;
import com.servion.triplefive.utils.PrintStackTrace;
import com.servion.util.AppProperties;
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
 * Last generated by Orchestration Designer at: 2015-MAR-17  01:38:44 PM
 */
public class UpdateLanguage extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAR-17  01:38:44 PM
	 */
	public UpdateLanguage() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:52 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("Prepaid_Start-Route");
		next.setDebugId(9436);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:52 PM
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
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:52 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(2);
		actions.add(new com.avaya.sce.runtime.varoperations.Assign("Prepaid_dmInputParameter:propertyFileName", "Prepaid_propertyFileName:GPMenuRepeat", false).setDebugId(9435));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
	
	@Override
	public void requestBegin(SCESession mySession) {

		
		/** Declaration **/
		String selectedLanguageCode = AppConstant.EMPTY_STRING,appName = AppConstant.EMPTY_STRING,hostOutput = AppConstant.ERROR;
		String selectedLanguage =AppConstant.EMPTY_STRING;
		String callerANI = AppConstant.EMPTY_STRING,flag = AppConstant.EMPTY_STRING;
		ITraceInfo trace = null;
		IVRDataBean objIVRData = null;
		
		com.rcom.hni.model.UpdateLanguage objUpdateLanguage = null;
		GetReportObject objGetReportObject = null;
		IVRREPORTDATA objIVRREPORTDATA= null;
		CALLINFO objCALLINFO = null;
		
		/**Assign**/
		selectedLanguage = mySession.getVariableField(IProjectVariables.CHANGE_LANGUAGE_MENU,IProjectVariables.CHANGE_LANGUAGE_MENU_FIELD_VALUE).getStringValue();
		objIVRData = (IVRDataBean) mySession.getProperty(AppConstant.IVRDATABEAN);
		
		appName = mySession.getVariableField(IProjectVariables.APP_NAME).getStringValue();
		callerANI = mySession.getVariableField(IProjectVariables.PREPAID__APP_VARIABLES,IProjectVariables.PREPAID__APP_VARIABLES_FIELD_ANI).getStringValue();
		trace = mySession.getTraceOutput();
		objUpdateLanguage = new com.rcom.hni.model.UpdateLanguage();
		
		trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Selected Language Code :"+ selectedLanguageCode);
		trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Caller Ani :"+ callerANI);
		trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Currect Language :"+mySession.getCurrentLanguage());
		try{
			/*** Report ***/
			objGetReportObject = objIVRData.getGetReportObject(); 
			objIVRREPORTDATA = objGetReportObject.getIvrreportdata();
			objCALLINFO = objIVRREPORTDATA.getCALLINFO();
			objCALLINFO.setLANGUAGETO(mySession.getCurrentLanguage());
			
			
			/**DB**/
			selectedLanguageCode=(String)AppDataMap.getInstance(Constants.TRIPLEFIVE).getAppData(selectedLanguage);
			
			objUpdateLanguage.setLanguageCode(selectedLanguageCode);
			objUpdateLanguage.setMdn(callerANI);
			objUpdateLanguage= IVRDBServiceInstance.getInstance().updatePreferredLanguage(objIVRData, objUpdateLanguage);
			
			if(objUpdateLanguage!=null){
				/**Response **/
				flag = objUpdateLanguage.getFlag();
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Update Preffered Language :"+ flag);		
				
				if(AppConstant.Success.equalsIgnoreCase(flag)){
					hostOutput = AppConstant.Success;
					LanguageSuccessPrompt(mySession);
				}
				
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Host Output :"+ hostOutput);
			
			}
			}catch (Exception e) {
				trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "Error in Update Language :" +e);
				PrintStackTrace.PrintException(e);
			}
		mySession.getVariableField(IProjectVariables.PREPAID__APP_VARIABLES,IProjectVariables.PREPAID__APP_VARIABLES_FIELD_HOST_RESULT).setValue(hostOutput);
	
	}
	
	public void LanguageSuccessPrompt(SCESession mySession){
		String initialPrompt = AppConstant.EMPTY_STRING,key = AppConstant.EMPTY_STRING,selectedLanguageCode= AppConstant.EMPTY_STRING;
		String dynamicWaves =  AppConstant.EMPTY_STRING,appName = AppConstant.EMPTY_STRING,selectedLanguage = AppConstant.EMPTY_STRING;
		ArrayList<String> arrLanguage = null;
		ITraceInfo trace =null;
		
		trace = mySession.getTraceOutput();
		appName = mySession.getVariableField(IProjectVariables.APP_NAME).getStringValue();
		key = appName+AppConstant.SEPERATOR_HYPEN+AppConstant.PA_0060;
		
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"application Name :"+appName);
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG," Language set Success initial Prompt Key :"+key);
		
		dynamicWaves = AppProperties.GetInstance(Constants.AUDIO_CONFIG).getIVRProp(key);
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Language set Success initial Prompt :"+dynamicWaves);
		arrLanguage = new ArrayList<String>();
		
		/** Form Dynamic Initial Prompt**/
		selectedLanguage = mySession.getVariableField(IProjectVariables.CHANGE_LANGUAGE_MENU,IProjectVariables.CHANGE_LANGUAGE_MENU_FIELD_VALUE).getStringValue();
		
		/*key = AppConstant.Language_Code+selectedLanguageCode;
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Language_Code Key:"+key);
		selectedLanguage=(String) AppDataMap.getInstance(appName).getAppData(key);
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Selected Language :"+selectedLanguage);*/
		
		if(selectedLanguage!=null && !AppConstant.EMPTY_STRING.equalsIgnoreCase(selectedLanguage)){
			arrLanguage.add(AppProperties.GetInstance(Constants.AUDIO_CONFIG).getIVRProp(selectedLanguage));
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Dynamic wave File :"+arrLanguage.get(0));
		}
			
			
		/** Form Initial Prompt**/
		DynamicMenu objDynamicMenu = new DynamicMenu();
		initialPrompt=objDynamicMenu.playPrompt(arrLanguage, dynamicWaves, AppConstant.NA, trace);
		
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Initial Prompt ::"+initialPrompt);
		mySession.getVariableField(IProjectVariables.PREPAID__DM_INPUT_PARAMETER,IProjectVariables.PREPAID__DM_INPUT_PARAMETER_FIELD_INITIAL_PROMPT).setValue(initialPrompt);
		
		}
}