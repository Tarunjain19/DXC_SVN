package flow.subflow.Prepaid_Start;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.hni.model.RechargePlanInfo;
import com.servion.triplefive.utils.AppConstant;
import com.servion.triplefive.utils.AppDataMap;

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
 * Last generated by Orchestration Designer at: 2015-MAR-15  09:10:13 PM
 */
public class Get_IVR_RPV extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAR-15  09:10:13 PM
	 */
	public Get_IVR_RPV() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:54 PM
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
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:54 PM
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
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:54 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "Prepaid_appVariables:HostResult", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Prepaid_constant:success", true).setDebugId(11165)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("Prepaid_appVariables:RechargeCount", "0", true).setDebugId(11166));
			actions.add(new com.avaya.sce.runtime.Next("Prepaid_Start-Get_RechargeMenu", "success").setDebugId(11167));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("Prepaid_appVariables:transferCode", "TR_0067", true).setDebugId(11169));
			actions.add(new com.avaya.sce.runtime.Next("Prepaid_Start-LinkDown", "LinkDown").setDebugId(11170));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
/*	@Override
	public void requestBegin(SCESession mySession) {
		*//** Declaration **//*
		String circleID = AppConstant.EMPTY_STRING,RPVInfoKey = AppConstant.EMPTY_STRING;
		String hostResult = AppConstant.ERROR,appName = AppConstant.EMPTY_STRING;
		String language = AppConstant.EMPTY_STRING;
		Hashtable<String, List<RechargePlanInfo>> mapRechargePlanInfo = null;
		List<RechargePlanInfo> listRechargePlanInfo = null;
		RechargePlanInfo objRechargePlanInfo = null;
		String offerKey = AppConstant.EMPTY_STRING,strDenominationPhrase= AppConstant.EMPTY_STRING;
		String menuOption =AppConstant.EMPTY_STRING;
		ITraceInfo trace = null;
		int count = 0;
		HashMap<String,RechargePlanInfo> objMapRechargePlanInfo = null;
		ArrayList<String> arrDynamicValue = null;
		
		*//**Assign**//*
		appName = mySession.getVariableField(IProjectVariables.APP_NAME).getStringValue();
		circleID = mySession.getVariableField(IProjectVariables.PREPAID__APP_VARIABLES,IProjectVariables.PREPAID__APP_VARIABLES_FIELD_CIRCLE_ID).getStringValue();
		language = mySession.getCurrentLanguage();
		objMapRechargePlanInfo = new HashMap<>();
		trace = mySession.getTraceOutput();
		arrDynamicValue = new ArrayList<String>();
		
		try{
		RPVInfoKey = AppConstant.RECHARGEDETAIL_KEY+appName;
		mapRechargePlanInfo = (Hashtable<String, List<RechargePlanInfo>>)AppDataMap.getInstance(appName).getAppData(RPVInfoKey);
	
		for(int i = 1 ; i<=10 ; i++){
				
			offerKey = circleID+AppConstant.SEPERATOR_UNDERSCORE+language+AppConstant.SEPERATOR_UNDERSCORE+AppConstant.Option+i;
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "RSV Offer Key :: "+offerKey);
			listRechargePlanInfo = mapRechargePlanInfo.get(offerKey);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "listRechargePlanInfo Object :: "+listRechargePlanInfo);
			
			if(listRechargePlanInfo!= null){
				objRechargePlanInfo = listRechargePlanInfo.get(0);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "RechargePlanInfo Object :: "+objRechargePlanInfo);
				
				if(objRechargePlanInfo!= null){
					strDenominationPhrase= objRechargePlanInfo.getDenominationPhrase();
					menuOption = menuOption+strDenominationPhrase+AppConstant.SEPERATOR_COMMA;
					
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "menuOption :: "+menuOption);
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "strDenominationPhrase "+strDenominationPhrase);
					
					objMapRechargePlanInfo.put(strDenominationPhrase, objRechargePlanInfo);
					arrDynamicValue.add(strDenominationPhrase);
					count++;
				}
				hostResult = AppConstant.Success;
				}
			else{
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,  "Total Demoniation Available :: " +i);
				break;
			}
			}
			mySession.setProperty(AppConstant.DENOMINATION_MAP,objMapRechargePlanInfo);
			mySession.setProperty(AppConstant.DENOMINATION_PHRASE_LIST,arrDynamicValue);
			mySession.setProperty(AppConstant.DENOMINATION_MENU_OPTION,menuOption);
			mySession.setProperty(AppConstant.DENOMINATION_COUNT,count);
				
		}
		catch(Exception e)
		{
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR,"Exception in RSV Details Host : " + e);
			
		}
		finally
		{
			mySession.getVariableField(IProjectVariables.PREPAID__APP_VARIABLES, IProjectVariables.PREPAID__APP_VARIABLES_FIELD_HOST_RESULT).setValue(hostResult);
		}
	
	}*/
	
	@Override
	public void requestBegin(SCESession mySession) {
		/** Declaration **/
		String circleID = AppConstant.EMPTY_STRING,RPVInfoKey = AppConstant.EMPTY_STRING;
		String hostResult = AppConstant.ERROR,appName = AppConstant.EMPTY_STRING;
		String language = AppConstant.EMPTY_STRING;
		Hashtable<String, List<RechargePlanInfo>> mapRechargePlanInfo = null;
		List<RechargePlanInfo> listRechargePlanInfo = null;
		RechargePlanInfo objRechargePlanInfo = null;
		String offerKey = AppConstant.EMPTY_STRING,strDenominationPhrase= AppConstant.EMPTY_STRING;
		String menuOption =AppConstant.EMPTY_STRING;
		ITraceInfo trace = null;
		int count = 0;
		HashMap<String,RechargePlanInfo> objMapRechargePlanInfo = null;
		ArrayList<String> arrDynamicValue = null;
		
		/**Assign**/
		appName = mySession.getVariableField(IProjectVariables.APP_NAME).getStringValue();
		circleID = mySession.getVariableField(IProjectVariables.PREPAID__APP_VARIABLES,IProjectVariables.PREPAID__APP_VARIABLES_FIELD_CIRCLE_ID).getStringValue();
		language = mySession.getCurrentLanguage();
		objMapRechargePlanInfo = new HashMap<>();
		trace = mySession.getTraceOutput();
		arrDynamicValue = new ArrayList<String>();
		
		try{
		RPVInfoKey = AppConstant.RECHARGEDETAIL_KEY+appName;
		mapRechargePlanInfo = (Hashtable<String, List<RechargePlanInfo>>)AppDataMap.getInstance(appName).getAppData(RPVInfoKey);
	
		for(int i = 1 ; i<=10 ; i++){
				
			offerKey = circleID+AppConstant.SEPERATOR_UNDERSCORE+language+AppConstant.SEPERATOR_UNDERSCORE+AppConstant.Option+i;
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "RSV Offer Key :: "+offerKey);
			listRechargePlanInfo = mapRechargePlanInfo.get(offerKey);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "listRechargePlanInfo Object :: "+listRechargePlanInfo);
			
			if(listRechargePlanInfo!= null){
				objRechargePlanInfo = listRechargePlanInfo.get(0);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "RechargePlanInfo Object :: "+objRechargePlanInfo);
				
				if(objRechargePlanInfo!= null){
					strDenominationPhrase= objRechargePlanInfo.getDenominationPhrase();
					menuOption = menuOption+strDenominationPhrase+AppConstant.SEPERATOR_COMMA;
					
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "menuOption :: "+menuOption);
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "strDenominationPhrase "+strDenominationPhrase);
					
					objMapRechargePlanInfo.put(strDenominationPhrase, objRechargePlanInfo);
					arrDynamicValue.add(strDenominationPhrase);
					count++;
				}
				hostResult = AppConstant.Success;
				}
			else{
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,  "Total Demoniation Available :: " +i);
				break;
			}
			}
			mySession.setProperty(AppConstant.DENOMINATION_MAP,objMapRechargePlanInfo);
			mySession.setProperty(AppConstant.DENOMINATION_PHRASE_LIST,arrDynamicValue);
			mySession.setProperty(AppConstant.DENOMINATION_MENU_OPTION,menuOption);
			mySession.setProperty(AppConstant.DENOMINATION_COUNT,count);
				
		}
		catch(Exception e)
		{
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR,"Exception in RSV Details Host : " + e);
			
		}
		finally
		{
			mySession.getVariableField(IProjectVariables.PREPAID__APP_VARIABLES, IProjectVariables.PREPAID__APP_VARIABLES_FIELD_HOST_RESULT).setValue(hostResult);
		}
	
	}
}
