package com.servion.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.ppp.model.IVRVasInfo;
import com.servion.rcom.ppp.hostinterface.view.PackDetails;
import com.servion.rcom.ppp.hostinterface.view.ReqNonActivePackDetails;
import com.servion.rcom.ppp.hostinterface.view.ResNonActivePackDetails;
import com.servion.rcom.ppp.hostinterface.wrapper.IVRWebService;
import com.servion.rcom.ppp.hostinterface.wrapper.IVRWebServiceImpl;
import com.servion.util.AppConstant;
import com.servion.util.AppDataMap;
import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;
import com.servion.util.StackTrace;

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
 * Last generated by Orchestration Designer at: 2015-MAR-11  01:04:26 PM
 */
public class ActivateVAS extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAR-11  01:04:26 PM
	 */
	public ActivateVAS() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2015-JUL-09  09:39:31 PM
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
	 * Last generated by Orchestration Designer at: 2015-JUL-09  09:39:31 PM
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
	 * Last generated by Orchestration Designer at: 2015-JUL-09  09:39:31 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "appVariables:HostResult", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:success", true).setDebugId(5285)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("InternetAndVAS-Set_MN_0010", "Success").setDebugId(4099));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferReason", "TR_0022", true).setDebugId(5616));
			actions.add(new com.avaya.sce.runtime.Next("InternetAndVAS-LinkDown", "Exception").setDebugId(5287));
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
		String mdn = null,VASInfoKey = AppConstant.EMPTY_STRING;
		String hostResult = AppConstant.ERROR,appName = AppConstant.EMPTY_STRING;
		String language = AppConstant.EMPTY_STRING,offerKey= AppConstant.EMPTY_STRING;
		String strOfferCategoryPhrase = AppConstant.EMPTY_STRING,strOfferDetailPhrase= AppConstant.EMPTY_STRING,strOfferCode = AppConstant.EMPTY_STRING;
		
		ReqNonActivePackDetails reqNonActivePackDetails = null;
		ResNonActivePackDetails resNonActivePackDetails = null;
		IVRWebService webServiceManager = null;
		IVRDataBean objIVRData = null;
		
		ArrayList<PackDetails> resPackDetails = null;
		ArrayList<String> offerCodes = null,offerPhrase = null;
		HashMap<String,String>	offerDetailPhrase = null;
		PackDetails objPackDetails =null; 
		Hashtable<String, List<IVRVasInfo>> mapIVRVasInfo = null;
		HashMap<String, String> offerPhraseMap =null;
		List<IVRVasInfo> listIVRVasInfo = null;
		IVRVasInfo objIVRVasInfo = null;
		String strCricleID = AppConstant.EMPTY_STRING;
		try
		{
			objIVRData = (IVRDataBean) mySession.getProperty(AppConstant.IVRDATABEAN);
			/**Request Processing......**/
			if(mySession.getVariableField(IProjectVariables.IVR__CSP__DETAILS, IProjectVariables.IVR__CSP__DETAILS_FIELD_RETENTION_LIST).getStringValue().equalsIgnoreCase("RTN"))
			{
				mdn = mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_ANI).getStringValue();
			}
			else
			{
				mdn = mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_MOBILE_NO).getStringValue();
			}
			if(mySession.getVariableField(IProjectVariables.IVR__CSP__DETAILS, IProjectVariables.IVR__CSP__DETAILS_FIELD_IS_PREPAID).getBooleanValue()==true)
			{
				appName = AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp(AppConstant.PREPAID_APPLICATION_NAME);
			}
			else
			{
				appName = AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp(AppConstant.POSTPAID_APPLICATION_NAME);
			}
			strCricleID = mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_CIRCLE_ID).getStringValue();
			
			offerCodes = new ArrayList<>();
			offerPhrase = new ArrayList<>();
			offerDetailPhrase = new HashMap<String,String>();
			offerPhraseMap= new HashMap<String,String>();
			
			reqNonActivePackDetails = new ReqNonActivePackDetails();
			reqNonActivePackDetails.setMDN(mdn);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Activate VAS Pack Host Request :: "+reqNonActivePackDetails.toString());
			
			/**Response Processing......**/
			webServiceManager = new IVRWebServiceImpl();
			resNonActivePackDetails = webServiceManager.executeNonActivePackDetails(objIVRData,reqNonActivePackDetails);
		
			if(resNonActivePackDetails!=null && AppConstant.zero.equals(resNonActivePackDetails.getResponseCode())){
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Activate VAS Pack Host Response :: "+resNonActivePackDetails.toString());
				resPackDetails = resNonActivePackDetails.getPackDetailsList();
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Activate VAS Package Details :: "+resPackDetails);
				if(resPackDetails!=null){
					for(int i= 0;i<resPackDetails.size();i++){
						objPackDetails = resPackDetails.get(i);
						offerCodes.add(objPackDetails.getCode());
					}
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Activate VAS Package Offer Code :: "+offerCodes);  
				}
				
			
			/***DB Hit to get the VAS details **/
			
			VASInfoKey = AppConstant.VAS_KEY+appName;
			mapIVRVasInfo = (Hashtable<String, List<IVRVasInfo>>) AppDataMap.getInstance(appName).getAppData(VASInfoKey);
			language = mySession.getCurrentLanguage();
			
			
				String offerID = AppConstant.EMPTY_STRING;
				String skip= AppConstant.EMPTY_STRING;
				offerKey = strCricleID+AppConstant.SEPERATOR_UNDERSCORE+language;
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Activate VAS Offer Key :: "+offerKey);
				listIVRVasInfo = mapIVRVasInfo.get(offerKey);
				
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "listIVRVasInfo Object :: "+listIVRVasInfo);
				
				if(listIVRVasInfo!= null){
					for(int j=0;j<listIVRVasInfo.size();j++){
						objIVRVasInfo = listIVRVasInfo.get(j);
						trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "IVRVasInfo Object :: "+objIVRVasInfo);
						
						if(objIVRVasInfo!= null){
							offerID = objIVRVasInfo.getPackCode();
							trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Offer ID in DB :: "+offerID);
							for(int i = 0; i< offerCodes.size();i++){
								if(offerID!=null && offerID.equalsIgnoreCase(offerCodes.get(i))){
									skip = AppConstant.N;
								}
							}
							if(!AppConstant.Y.equalsIgnoreCase(skip)){
								strOfferCategoryPhrase= objIVRVasInfo.getOfferCategoryPhrase();
								strOfferDetailPhrase = objIVRVasInfo.getOfferDetailPhrase();
								
								strOfferCode = strOfferCode+offerID+AppConstant.SEPERATOR_COMMA;
								
								trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Offer Category Phrase :: "+strOfferCategoryPhrase);
								trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Offer Detail Phrase :: "+strOfferDetailPhrase);
								trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Offer Code :: "+strOfferCode);
								
								offerPhrase.add(strOfferCategoryPhrase);
								offerDetailPhrase.put(offerID,strOfferDetailPhrase);
								offerPhraseMap.put(offerID,strOfferCategoryPhrase);
							}
							skip = AppConstant.N;
						}
					}
					
				}
			
			
			mySession.setProperty(AppConstant.OFFERCODES,strOfferCode);
			mySession.setProperty(AppConstant.OFFER_COUNT,offerPhrase.size());
			mySession.setProperty(AppConstant.OFFER_PHRASE,offerPhrase);
			mySession.setProperty(AppConstant.OFFER_PHRASE_MAP,offerPhraseMap);
			mySession.setProperty(AppConstant.OFFER_DETAILS_PHRASE,offerDetailPhrase);
			
			hostResult = AppConstant.Success;
			}
		}
		catch(Exception e)
		{
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR,"Exception in VAS Details Host : " + e);
			StackTrace.PrintException(e);
			
		}
		finally
		{
			reqNonActivePackDetails = null;
			resNonActivePackDetails = null;
			webServiceManager = null;
			mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_HOST_RESULT).setValue(hostResult);
		}
		
	}
}

	