package flow;

import java.util.ArrayList;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.prepaid.model.IVRHsdCspInfo;
import com.rcom.prepaid.resource.IVRDBServiceInstance;
import com.servion.hsd.utils.AppConstant;
import com.servion.hsd.utils.DynamicMenu;
import com.servion.hsd.utils.StackTrace;
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
 * Last generated by Orchestration Designer at: 2015-MAR-11  11:51:39 PM
 */
public class IVR_CSP_CustomerVal extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAR-11  11:51:39 PM
	 */
	public IVR_CSP_CustomerVal() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:38:56 PM
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
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:38:56 PM
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
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:38:56 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "AppVariables:HostResult", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:success", true).setDebugId(9128)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("LanguageMenu", "next").setDebugId(9129));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("AppVariables:TransferPoint", "TransferPoints:HSDI_TR_0003", false).setDebugId(9131));
			actions.add(new com.avaya.sce.runtime.Next("LinkDownAnnc", "LinkDown").setDebugId(9132));
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
		
		/** Declaration **/
		String  callerANI = AppConstant.EMPTY_STRING,preferedLang = AppConstant.EMPTY_STRING,propetyKey= AppConstant.EMPTY_STRING;
		String  barringCode = AppConstant.EMPTY_STRING,key = AppConstant.EMPTY_STRING,appName= AppConstant.EMPTY_STRING,propertiesLocation = AppConstant.EMPTY_STRING;
		String  callerType = AppConstant.EMPTY_STRING,dataType = AppConstant.EMPTY_STRING,serviceType = AppConstant.EMPTY_STRING,hsdValue = AppConstant.EMPTY_STRING,dataCardValue = AppConstant.EMPTY_STRING;
		String hostOutput = AppConstant.ERROR;
		IVRDataBean objIVRData = null;
		IVRHsdCspInfo ivrHsdCspInfo = null;
		ITraceInfo trace =null;
		GetReportObject objGetReportObject = null;
		IVRREPORTDATA objIVRREPORTDATA= null;
		CALLINFO objCALLINFO = null;
		
		/**Assign**/
		trace = mySession.getTraceOutput();
		callerANI = mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_ANI).getStringValue();
		objIVRData = (IVRDataBean) mySession.getProperty(AppConstant.IVRDATABEAN);
		appName = mySession.getVariableField(IProjectVariables.APP__NAME).getStringValue();
		ivrHsdCspInfo = new IVRHsdCspInfo();
		ivrHsdCspInfo.setMdn(callerANI);
		
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"caller ANI :"+callerANI);
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"IVRData Bean Object :"+objIVRData);
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"appName :"+appName);
		
		try{
		
		objGetReportObject = objIVRData.getGetReportObject(); 
		objIVRREPORTDATA = objGetReportObject.getIvrreportdata();
		objCALLINFO = objIVRREPORTDATA.getCALLINFO();
			
		/**DB**/
		ivrHsdCspInfo=IVRDBServiceInstance.getInstance().getIVRHsdCSPInfo(objIVRData, ivrHsdCspInfo);
		trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "IVR Customer Profile Response :: "+ivrHsdCspInfo.toString());
				
		serviceType = ivrHsdCspInfo.getServiceType();
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Service Type from DB :  :" +serviceType);
		
		/** If MDN is not in IVRCustomerProfile, proceeding to link down **/
		if(serviceType != null)
		{		
		if(serviceType.contains(AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp(AppConstant.PREPAID_SERVICE_TYPE)))
		{
			mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_PREPAID).setValue(AppConstant.Yes);
			if(ivrHsdCspInfo.getHniPrepaidValue()!=null && ivrHsdCspInfo.getHniPrepaidValue().contains(AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp(AppConstant.HNI_TYPE)))
					mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_HNICALLER).setValue(AppConstant.Yes);	
		}
		else
		{
			mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_PREPAID).setValue(AppConstant.No);
			if(ivrHsdCspInfo.getHniPostpaidValue()!=null && ivrHsdCspInfo.getHniPostpaidValue().contains(AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp(AppConstant.HNI_TYPE)))
				mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_HNICALLER).setValue(AppConstant.Yes);
		}
				
		/** Data Available Check **/
		hsdValue = ivrHsdCspInfo.getHsdValue();
		dataCardValue = ivrHsdCspInfo.getDataCardValue();
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"DataCard Available :: HSD Value : "+hsdValue+" ,DataCardValue : "+dataCardValue);
		if(hsdValue != null && dataCardValue != null)
		{
			if(!hsdValue.equalsIgnoreCase(AppConstant.NA) && !dataCardValue.equalsIgnoreCase(AppConstant.NA))
				mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_DATA_AVAILABLE).setValue(AppConstant.TRUE);
			else
				mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_DATA_AVAILABLE).setValue(AppConstant.FALSE);
		}
		else
			mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_DATA_AVAILABLE).setValue(AppConstant.FALSE);
		}
		
		else
		{
			/** Proceding to Get DataCardNumber **/
			mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_DATA_AVAILABLE).setValue(AppConstant.FALSE);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "** MDN is not available in IVR Customer Profile ** ");
		}
		/**caller Type ***/
		callerType = mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_HNICALLER).getStringValue();
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"caller Type :"+callerType);
		
		if(callerType!=null && !AppConstant.EMPTY_STRING.equals(callerType) &&!AppConstant.NA.equals(callerType) && callerType.equalsIgnoreCase(AppConstant.Yes)){
			mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER , IProjectVariables.DM_INPUT_PARAMETER_FIELD_GLOBAL_PROPERTY_FILE_NAME).setValue(mySession.getVariableField(IProjectVariables.PROPERTY_FILE_NAME, IProjectVariables.PROPERTY_FILE_NAME_FIELD_GLOBAL__HNI).getStringValue());
		}
		else
		{
			mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER , IProjectVariables.DM_INPUT_PARAMETER_FIELD_GLOBAL_PROPERTY_FILE_NAME).setValue(mySession.getVariableField(IProjectVariables.PROPERTY_FILE_NAME, IProjectVariables.PROPERTY_FILE_NAME_FIELD_GLOBAL__NORMAL).getStringValue());
		}
		hostOutput = AppConstant.Success;
		
		
		
		/***Preferred Language**/
		LanguageSelectionMenu(mySession);
		
		}catch (Exception e) {
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "Error in IVR CSP DB Hit :" +e);
			StackTrace.PrintException(e);
		}
		
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Host Status :" +hostOutput);
		mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_HOST_RESULT).setValue(hostOutput);
	}
	
	public void LanguageSelectionMenu (SCESession mySession){
		
		/** Declaration **/
		String initialPrompt = AppConstant.EMPTY_STRING,grammarValue = AppConstant.EMPTY_STRING,circleLangCode = AppConstant.EMPTY_STRING;
		String dynamicWaves =  AppConstant.EMPTY_STRING,appName = AppConstant.EMPTY_STRING,key = AppConstant.EMPTY_STRING,circleLanguage = AppConstant.EMPTY_STRING,langKey = AppConstant.EMPTY_STRING;
		String[] arrayLangCode = null;
		ArrayList<String> arrLanguage=null;
		ITraceInfo trace =null;
		
		/**Assign**/
		trace = mySession.getTraceOutput();
		appName = mySession.getVariableField(IProjectVariables.APP__NAME).getStringValue();
		key = appName+AppConstant.SEPERATOR_HYPEN+AppConstant.HSDI_MN_0001;
		
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"application Name :"+appName);
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Language initial Prompt Key :"+key);
		
		dynamicWaves = AppProperties.GetInstance(AppConstant.DYN_MENU).getIVRProp(key);
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Language initial Prompt :"+dynamicWaves);
		arrLanguage = new ArrayList<>();
		/** Form Dynamic Initial Prompt**/
		circleLangCode = mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_LANGUAGE_LIST).getStringValue();
		
		if(circleLangCode!=null){
			arrayLangCode = circleLangCode.split(AppConstant.SEPERATOR_COMMA);
			
			for(int i = 0;i<arrayLangCode.length;i++){
				/*key = AppConstant.Language_Code+arrayLangCode[i];
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Language_Code Key:"+key);*/
				circleLanguage=arrayLangCode[i];
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Circle Language : "+i+" :"+circleLanguage);
				langKey = AppConstant.LANG_+i;
				dynamicWaves = dynamicWaves.replaceAll(langKey,circleLanguage);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Dynamic Wave :" +dynamicWaves);
				arrLanguage.add(circleLanguage+AppConstant.wave);
			}
			
			/** Form Initial Prompt**/
			String count = String.valueOf(arrLanguage.size());
			DynamicMenu objDynamicMenu = new DynamicMenu();
			initialPrompt=objDynamicMenu.playPrompt(arrLanguage, dynamicWaves, count, trace);
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Initial Prompt ::"+initialPrompt);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Menu Option : "+circleLangCode);
			
			mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER,IProjectVariables.DM_INPUT_PARAMETER_FIELD_INITIAL_PROMPT).setValue(initialPrompt);
			mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER,IProjectVariables.DM_INPUT_PARAMETER_FIELD_MORE_OPTION_COUNT).setValue(count);
			mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER,IProjectVariables.DM_INPUT_PARAMETER_FIELD_MENU_OPTION).setValue(circleLangCode);
			
		}
		
	}
}
