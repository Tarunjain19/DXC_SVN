package flow.subflow.Prepaid_Start;

import java.util.ArrayList;
import java.util.HashMap;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.hni.model.SpecialTariffInfo;
import com.servion.triplefive.utils.AppConstant;
import com.servion.triplefive.utils.Constants;
import com.servion.triplefive.utils.DynamicMenu;
import com.servion.triplefive.utils.PrintStackTrace;
import com.servion.util.AppProperties;

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
 * Last generated by Orchestration Designer at: 2015-MAR-16  02:48:57 PM
 */
public class Get_PackDetails extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAR-16  02:48:57 PM
	 */
	public Get_PackDetails() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:55 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("Prepaid_Start-PackDetailsMenu");
		next.setDebugId(11626);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:55 PM
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
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:55 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "Prepaid_dmInputParameter:initialPrompt", com.avaya.sce.runtime.Expression.IS_EMPTY).setDebugId(11623)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("Prepaid_appVariables:transferCode", "TR_0037", true).setDebugId(11624));
			actions.add(new com.avaya.sce.runtime.Next("Prepaid_Start-LinkDown", "linkDown").setDebugId(11625));
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



		ITraceInfo trace = mySession.getTraceOutput();
		String key = AppConstant.EMPTY_STRING,appName = AppConstant.EMPTY_STRING;

		ArrayList<String> offerPhrase = null;
		String initialPrompt = null;
		String offerID =AppConstant.EMPTY_STRING , menuoption = AppConstant.EMPTY_STRING;
		String offerCount = AppConstant.EMPTY_STRING,menuID = AppConstant.EMPTY_STRING;
		String selectedPackOption = AppConstant.EMPTY_STRING;
		HashMap<String,SpecialTariffInfo> objMapSpecialTariffInfo = null;
		HashMap<String,String> denominationDetailPhrase = null;
		HashMap<String,String> packMRP = null,packSTVcode = null;;
		SpecialTariffInfo objSpecialTariffInfo = null;
		//initial prompt processing...
		
		try
		{
			appName = mySession.getVariableField(IProjectVariables.APP_NAME).getStringValue();
			selectedPackOption = mySession.getVariableField(IProjectVariables.STVMENU,IProjectVariables.STVMENU_FIELD_VALUE).getStringValue();
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Application Name :: "+appName);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Pack Selected :: "+selectedPackOption);
			offerPhrase = new ArrayList<String>();
			denominationDetailPhrase = new HashMap<>();
			packMRP = new HashMap<>();
			packSTVcode = new HashMap<>();
			
			if((AppConstant.Option+AppConstant.one).equalsIgnoreCase(selectedPackOption)){
				key = appName +AppConstant.SEPERATOR_HYPEN+ AppConstant.MN_0022;
				menuID = AppConstant.MN_0022;
			}else if((AppConstant.Option+AppConstant.two).equalsIgnoreCase(selectedPackOption)){
				key = appName +AppConstant.SEPERATOR_HYPEN+ AppConstant.MN_0039;
				menuID = AppConstant.MN_0039;
			}else{
				key = appName +AppConstant.SEPERATOR_HYPEN+ AppConstant.MN_0040;
				menuID = AppConstant.MN_0040;
			}
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Key :: "+key);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Menu Id :: "+menuID);
			
			initialPrompt = AppProperties.GetInstance(Constants.AUDIO_CONFIG).getIVRProp(key);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "STV Pack initial Prompt Before Dynamic Insertion:: "+initialPrompt);
			
			objMapSpecialTariffInfo = (HashMap<String,SpecialTariffInfo>) mySession.getProperty(AppConstant.STV_MAP);
			if(objMapSpecialTariffInfo!=null){
				for (int i = 0 ; i<10;i++){
					String denominationKey = selectedPackOption+AppConstant.Option+i;
					objSpecialTariffInfo = objMapSpecialTariffInfo.get(denominationKey);
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "denomination Key:: "+denominationKey);
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "obj SpecialTariff Info :: "+objSpecialTariffInfo);
					if(objSpecialTariffInfo!=null){
						String strDenominationPhrase = objSpecialTariffInfo.getDenominationPhrase();
						String strAnnouncementPhrase = objSpecialTariffInfo.getAnnouncementPhrase();
						String strMRP =  objSpecialTariffInfo.getMrpPhrase();
						String stvCode =  objSpecialTariffInfo.getStvCode();
						
						trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Denomination Phrase :: "+strDenominationPhrase);
						trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Announcement Phrase :: "+strAnnouncementPhrase);
						trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "STV Code :: "+stvCode);
						trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "STV MRP :: "+strMRP);
						
						offerPhrase.add(strDenominationPhrase);
						menuoption = menuoption+strDenominationPhrase+AppConstant.SEPERATOR_COMMA;
						denominationDetailPhrase.put(strDenominationPhrase, strAnnouncementPhrase);
						packMRP.put(strDenominationPhrase, strMRP);
						packSTVcode.put(strDenominationPhrase, stvCode);
						
					}else{
						trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Denomination menu Options :: "+i);
						break;
					}
					
				}
			}else{
				
			}
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "STV Pack offerPhrase ::"+offerPhrase);
			
			DynamicMenu objDynamicMenu = new DynamicMenu();
			initialPrompt=objDynamicMenu.playPrompt(offerPhrase, initialPrompt, ""+offerPhrase.size(), trace);
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "STV Pack Offer initial Prompt :: "+initialPrompt);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "STV Pack Offer Selection Grammar :: "+offerID);
			
			mySession.setProperty(AppConstant.STV_DENOMINATION_DETAILS_MAP, denominationDetailPhrase);
			mySession.setProperty(AppConstant.STV_MRP_MAP, packMRP);
			mySession.setProperty(AppConstant.STV_OFFER_ID, packSTVcode);
			
			mySession.getVariableField(IProjectVariables.PREPAID__DM_INPUT_PARAMETER,IProjectVariables.PREPAID__DM_INPUT_PARAMETER_FIELD_MENU_ID).setValue("PRE_"+menuID);
			mySession.getVariableField(IProjectVariables.PREPAID__DM_INPUT_PARAMETER, IProjectVariables.PREPAID__DM_INPUT_PARAMETER_FIELD_INITIAL_PROMPT).setValue(initialPrompt);
			mySession.getVariableField(IProjectVariables.PREPAID__DM_INPUT_PARAMETER, IProjectVariables.PREPAID__DM_INPUT_PARAMETER_FIELD_MENU_OPTION).setValue(menuoption);
			mySession.getVariableField(IProjectVariables.PREPAID__DM_INPUT_PARAMETER, IProjectVariables.PREPAID__DM_INPUT_PARAMETER_FIELD_MORE_OPTION_COUNT).setValue(offerPhrase.size());
			
			
		}
		catch(Exception e)
		{
			PrintStackTrace.PrintException(e);
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "Exception in STV Pack initial prompt :: "+e);
		}
		finally
		{
				initialPrompt = null;
		}
		
	}
*/
	
	@Override
	public void requestBegin(SCESession mySession) {



		ITraceInfo trace = mySession.getTraceOutput();
		String key = AppConstant.EMPTY_STRING,appName = AppConstant.EMPTY_STRING;

		ArrayList<String> offerPhrase = null;
		String initialPrompt = null;
		String offerID =AppConstant.EMPTY_STRING , menuoption = AppConstant.EMPTY_STRING;
		String offerCount = AppConstant.EMPTY_STRING,menuID = AppConstant.EMPTY_STRING;
		String selectedPackOption = AppConstant.EMPTY_STRING;
		HashMap<String,SpecialTariffInfo> objMapSpecialTariffInfo = null;
		HashMap<String,String> denominationDetailPhrase = null;
		HashMap<String,String> packMRP = null,packSTVcode = null;
		SpecialTariffInfo objSpecialTariffInfo = null;
		//initial prompt processing...
		
		try
		{
			appName = mySession.getVariableField(IProjectVariables.APP_NAME).getStringValue();
			selectedPackOption = mySession.getVariableField(IProjectVariables.STVMENU,IProjectVariables.STVMENU_FIELD_VALUE).getStringValue();
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Application Name :: "+appName);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Pack Selected :: "+selectedPackOption);
			offerPhrase = new ArrayList<String>();
			denominationDetailPhrase = new HashMap<>();
			packMRP = new HashMap<>();
			packSTVcode = new HashMap<>();
			
			if((AppConstant.Option+AppConstant.one).equalsIgnoreCase(selectedPackOption)){
				key = appName +AppConstant.SEPERATOR_HYPEN+ AppConstant.MN_0022;
				menuID = AppConstant.MN_0022;
			}else if((AppConstant.Option+AppConstant.two).equalsIgnoreCase(selectedPackOption)){
				key = appName +AppConstant.SEPERATOR_HYPEN+ AppConstant.MN_0039;
				menuID = AppConstant.MN_0039;
			}else{
				key = appName +AppConstant.SEPERATOR_HYPEN+ AppConstant.MN_0040;
				menuID = AppConstant.MN_0040;
			}
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Key :: "+key);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Menu Id :: "+menuID);
			
			initialPrompt = AppProperties.GetInstance(Constants.AUDIO_CONFIG).getIVRProp(key);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "STV Pack initial Prompt Before Dynamic Insertion:: "+initialPrompt);
			
			objMapSpecialTariffInfo = (HashMap<String,SpecialTariffInfo>) mySession.getProperty(AppConstant.STV_MAP);
			if(objMapSpecialTariffInfo!=null){
				for (int i = 0 ; i<10;i++){
					String denominationKey = selectedPackOption+AppConstant.Option+i;
					objSpecialTariffInfo = objMapSpecialTariffInfo.get(denominationKey);
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "denomination Key:: "+denominationKey);
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "obj SpecialTariff Info :: "+objSpecialTariffInfo);
					if(objSpecialTariffInfo!=null){
						String strDenominationPhrase = objSpecialTariffInfo.getDenominationPhrase();
						String strAnnouncementPhrase = objSpecialTariffInfo.getAnnouncementPhrase();
						String strMRP =  objSpecialTariffInfo.getMrpPhrase();
						String stvCode =  objSpecialTariffInfo.getStvCode();
						
						trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Denomination Phrase :: "+strDenominationPhrase);
						trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Announcement Phrase :: "+strAnnouncementPhrase);
						trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "STV Code :: "+stvCode);
						trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "STV MRP :: "+strMRP);
						
						offerPhrase.add(strDenominationPhrase);
						menuoption = menuoption+strDenominationPhrase+AppConstant.SEPERATOR_COMMA;
						denominationDetailPhrase.put(strDenominationPhrase, strAnnouncementPhrase);
						packMRP.put(strDenominationPhrase, strMRP);
						packSTVcode.put(strDenominationPhrase, stvCode);
						
					}else{
						trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Denomination menu Options :: "+i);
						break;
					}
					
				}
			}else{
				
			}
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "STV Pack offerPhrase ::"+offerPhrase);
			
			DynamicMenu objDynamicMenu = new DynamicMenu();
			initialPrompt=objDynamicMenu.playPrompt(offerPhrase, initialPrompt, ""+offerPhrase.size(), trace);
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "STV Pack Offer initial Prompt :: "+initialPrompt);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "STV Pack Offer Selection Grammar :: "+offerID);
			
			mySession.setProperty(AppConstant.STV_DENOMINATION_DETAILS_MAP, denominationDetailPhrase);
			mySession.setProperty(AppConstant.STV_MRP_MAP, packMRP);
			mySession.setProperty(AppConstant.STV_OFFER_ID, packSTVcode);
			
			mySession.getVariableField(IProjectVariables.PREPAID__DM_INPUT_PARAMETER,IProjectVariables.PREPAID__DM_INPUT_PARAMETER_FIELD_MENU_ID).setValue("PRE_"+menuID);
			mySession.getVariableField(IProjectVariables.PREPAID__DM_INPUT_PARAMETER, IProjectVariables.PREPAID__DM_INPUT_PARAMETER_FIELD_INITIAL_PROMPT).setValue(initialPrompt);
			mySession.getVariableField(IProjectVariables.PREPAID__DM_INPUT_PARAMETER, IProjectVariables.PREPAID__DM_INPUT_PARAMETER_FIELD_MENU_OPTION).setValue(menuoption);
			mySession.getVariableField(IProjectVariables.PREPAID__DM_INPUT_PARAMETER, IProjectVariables.PREPAID__DM_INPUT_PARAMETER_FIELD_MORE_OPTION_COUNT).setValue(offerPhrase.size());
			
			
		}
		catch(Exception e)
		{
			PrintStackTrace.PrintException(e);
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "Exception in STV Pack initial prompt :: "+e);
		}
		finally
		{
				initialPrompt = null;
		}
		
	}

}
