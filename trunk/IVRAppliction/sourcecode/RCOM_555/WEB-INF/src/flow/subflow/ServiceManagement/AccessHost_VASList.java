package flow.subflow.ServiceManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.hni.model.IVRVasInfo;
import com.servion.rcom.hni.hostinterface.view.PackDetails;
import com.servion.rcom.hni.hostinterface.view.ReqNonActivePackDetails;
import com.servion.rcom.hni.hostinterface.view.ResNonActivePackDetails;
import com.servion.rcom.hni.hostinterface.wrapper.IVRWebService;
import com.servion.rcom.hni.hostinterface.wrapper.IVRWebServiceImpl;
import com.servion.triplefive.utils.AppDataMap;
import com.servion.triplefive.utils.Constants;
import com.servion.triplefive.utils.PrintStackTrace;
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
 * Last generated by Orchestration Designer at: 2015-MAY-05  04:50:08 PM
 */
public class AccessHost_VASList extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-05  04:50:08 PM
	 */
	public AccessHost_VASList() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	@Override
	public void requestBegin(SCESession mySession) {
		ITraceInfo info = mySession.getTraceOutput();
		String mdn = null,VASInfoKey = Constants.EMPTY_STRING;
		String hostResult = Constants.ERROR,appName = Constants.EMPTY_STRING;
		String language = Constants.EMPTY_STRING,offerKey= Constants.EMPTY_STRING;
		String strOfferCategoryPhrase = Constants.EMPTY_STRING,strOfferDetailPhrase= Constants.EMPTY_STRING,strOfferCode = Constants.EMPTY_STRING;
		
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
		String strCricleID = Constants.EMPTY_STRING;
		try
		{
			objIVRData = (IVRDataBean) mySession.getProperty(Constants.IVRDATABEAN);
			/**Request Processing......**/
			mdn = mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_MDN).getStringValue();
			appName = mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_APPLICATION_NAME).getStringValue();
			strCricleID = mySession.getVariableField(IProjectVariables.ROUTING_INFO,IProjectVariables.ROUTING_INFO_FIELD_CIRCLE).getStringValue();
			
			offerCodes = new ArrayList<>();
			offerPhrase = new ArrayList<>();
			offerDetailPhrase = new HashMap<String,String>();
			offerPhraseMap= new HashMap<String,String>();
			
			reqNonActivePackDetails = new ReqNonActivePackDetails();
			reqNonActivePackDetails.setMDN(mdn);
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Activate VAS Pack Host Request :: "+reqNonActivePackDetails.toString());
			
			/**Response Processing......**/
			webServiceManager = new IVRWebServiceImpl();
			resNonActivePackDetails = webServiceManager.executeNonActivePackDetails(objIVRData,reqNonActivePackDetails);
		
			if((resNonActivePackDetails!=null && Constants.zero.equals(resNonActivePackDetails.getResponseCode()))||(resNonActivePackDetails!=null && Constants.one.equals(resNonActivePackDetails.getResponseCode()))){
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Activate VAS Pack Host Response :: "+resNonActivePackDetails.toString());
				resPackDetails = resNonActivePackDetails.getPackDetailsList();
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Activate VAS Package Details :: "+resPackDetails);
				
				/***DB Hit to get the VAS details **/
				VASInfoKey = Constants.VAS_KEY+appName;
				mapIVRVasInfo = (Hashtable<String, List<IVRVasInfo>>) AppDataMap.getInstance(appName).getAppData(VASInfoKey);
				language = mySession.getCurrentLanguage();
				
				if((resPackDetails!=null)&&(resPackDetails.size()>=1)){
					for(int i= 0;i<resPackDetails.size();i++){
						objPackDetails = resPackDetails.get(i);
						offerCodes.add(objPackDetails.getCode());
					}
					
					offerKey = strCricleID+Constants.UNDERSCORE+language;
					info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Activate VAS Offer Key :: "+offerKey);
					listIVRVasInfo = mapIVRVasInfo.get(offerKey);
					
					info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "listIVRVasInfo Object :: "+listIVRVasInfo);
					
					if(listIVRVasInfo!= null){
					
						for (int j = 0; j < listIVRVasInfo.size(); j++) {
							
							objIVRVasInfo = listIVRVasInfo.get(j);
							info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "IVRVasInfo Object :: "+objIVRVasInfo);
							
							if(!(offerCodes.contains(objIVRVasInfo.getPackCode()))){
								
								strOfferCategoryPhrase= objIVRVasInfo.getOfferCategoryPhrase();
								strOfferDetailPhrase = objIVRVasInfo.getOfferDetailPhrase();
								strOfferCode = strOfferCode+objIVRVasInfo.getPackCode()+Constants.COMMA;
								
								info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Offer Category Phrase :: "+strOfferCategoryPhrase);
								info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Offer Detail Phrase :: "+strOfferDetailPhrase);
								info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Offer Code :: "+strOfferCode);
								
								offerPhrase.add(strOfferCategoryPhrase);
								offerDetailPhrase.put(objIVRVasInfo.getPackCode(),strOfferDetailPhrase);
								offerPhraseMap.put(objIVRVasInfo.getPackCode(),strOfferCategoryPhrase);	
								
							}
						}
					}
					
					/*for(int i = 0; i< offerCodes.size();i++){
						String offerID = Constants.EMPTY_STRING;
						offerID =offerCodes.get(i);
						offerKey = strCricleID+Constants.UNDERSCORE+language;
						info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Activate VAS Offer Key :: "+offerKey);
						listIVRVasInfo = mapIVRVasInfo.get(offerKey);
						
						info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "listIVRVasInfo Object :: "+listIVRVasInfo);
						
						if(listIVRVasInfo!= null){
							
							for (int j = 0; j < listIVRVasInfo.size(); j++) {
								
								objIVRVasInfo = listIVRVasInfo.get(j);
								info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "IVRVasInfo Object :: "+objIVRVasInfo);
								
								if(objIVRVasInfo.getPackCode()!= null){
									
									info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "MDN Offer Code, Circle Offer Code "+objIVRVasInfo.getPackCode()+","+offerID);
									if(!(objIVRVasInfo.getPackCode().equals(offerID))){
										
										if(!(strOfferCode.contains(objIVRVasInfo.getPackCode()))){
											strOfferCategoryPhrase= objIVRVasInfo.getOfferCategoryPhrase();
											strOfferDetailPhrase = objIVRVasInfo.getOfferDetailPhrase();
											strOfferCode = strOfferCode+objIVRVasInfo.getPackCode()+Constants.COMMA;
											
											info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Offer Category Phrase :: "+strOfferCategoryPhrase);
											info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Offer Detail Phrase :: "+strOfferDetailPhrase);
											info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Offer Code :: "+strOfferCode);
											
											offerPhrase.add(strOfferCategoryPhrase);
											offerDetailPhrase.put(objIVRVasInfo.getPackCode(),strOfferDetailPhrase);
											offerPhraseMap.put(objIVRVasInfo.getPackCode(),strOfferCategoryPhrase);	
										}
										
									}
									
								}
								
							}
								
						}
							
					}*/
					
					info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Activate VAS Package Offer Code :: "+offerCodes);  
					info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Offer category phrase :: "+offerPhrase);
					info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Offer detail phrase :: "+offerDetailPhrase);
					info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Offer code :: "+strOfferCode);
				}else{
					
					offerKey = strCricleID+Constants.UNDERSCORE+language;
					info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Activate VAS Offer Key :: "+offerKey);
					listIVRVasInfo = mapIVRVasInfo.get(offerKey);
					
					info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "listIVRVasInfo Object :: "+listIVRVasInfo);
					
					if(listIVRVasInfo!= null){
						
						for (int j = 0; j < listIVRVasInfo.size(); j++) {
							
							objIVRVasInfo = listIVRVasInfo.get(j);
							info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "IVRVasInfo Object :: "+objIVRVasInfo);
							
							if(objIVRVasInfo.getPackCode()!= null){
								
								strOfferCategoryPhrase= objIVRVasInfo.getOfferCategoryPhrase();
								strOfferDetailPhrase = objIVRVasInfo.getOfferDetailPhrase();
								strOfferCode = strOfferCode+objIVRVasInfo.getPackCode()+Constants.COMMA;
								
								info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Offer Category Phrase :: "+strOfferCategoryPhrase);
								info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Offer Detail Phrase :: "+strOfferDetailPhrase);
								info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Offer Code :: "+strOfferCode);
								
								offerPhrase.add(strOfferCategoryPhrase);
								offerDetailPhrase.put(objIVRVasInfo.getPackCode(),strOfferDetailPhrase);
								offerPhraseMap.put(objIVRVasInfo.getPackCode(),strOfferCategoryPhrase);
								
							}
							
						}
						
				}
					
					info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Activate VAS Package Offer Code :: "+offerCodes);  
					info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Offer category phrase :: "+offerPhrase);
					info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Offer detail phrase :: "+offerDetailPhrase);
					info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Offer code :: "+strOfferCode);
				
			}
			mySession.setProperty(Constants.OFFERCODES,strOfferCode);
			mySession.setProperty(Constants.OFFER_COUNT,offerPhrase.size());
			mySession.setProperty(Constants.OFFER_PHRASE,offerPhrase);
			mySession.setProperty(Constants.OFFER_PHRASE_MAP,offerPhraseMap);
			mySession.setProperty(Constants.OFFER_DETAILS_PHRASE,offerDetailPhrase);
			
			if(offerPhrase.size() <=0)
				mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.Yes);
			
			hostResult = Constants.Success;
			}else{
				mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.Yes);
			}
		}
		catch(Exception e)
		{
			PrintStackTrace.PrintException(e);
			info.writeln(ITraceInfo.TRACE_LEVEL_ERROR,"Exception in VAS Details Host : " + e);
			mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.Yes);
			
		}
		finally
		{
			reqNonActivePackDetails = null;
			resNonActivePackDetails = null;
			webServiceManager = null;
		}
		
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:43 PM
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
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:43 PM
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
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:43 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(2);
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "--->LinkDown Flag", "Flag:isLinkDown").setDebugId(5185));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "Flag:isLinkDown", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:yes", true).setDebugId(5176)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("CallData:transferReasonCode", "Constants:TR_0127", false).setDebugId(5179));
			actions.add(new com.avaya.sce.runtime.Next("ServiceManagement-LinkDown", "LinkDown").setDebugId(5178));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("ServiceManagement-Initialize_MN_0019", "Continue").setDebugId(883));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
