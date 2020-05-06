package flow;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.otherflows.model.CancelPackInfo;
import com.rcom.otherflows.resource.IVRDBServiceInstance;
import com.rcom.rdtv.rcomdth02.model.Get3GPacks;
import com.rcom.rdtv.util.AppConstants;
import com.rcom.rdtv.util.DynamicMenu;
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
 * Last generated by Orchestration Designer at: 2015-MAY-29  12:40:07 PM
 */
public class Fetch_Subscibed_Packs extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-29  12:40:07 PM
	 */
	public Fetch_Subscibed_Packs() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:38 PM
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
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:38 PM
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
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:38 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "AppVariables:IsHostFailure", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "CONSTANTS:YES", true).setDebugId(7803)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("AppVariables:TransferPoint", "TransferPoints:RD01_TR_0019", false).setDebugId(7804));
			actions.add(new com.avaya.sce.runtime.Next("LinkDownAnnc", "link-down").setDebugId(7805));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "AppVariables:IsPackAvailable", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "CONSTANTS:YES", true).setDebugId(7807)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("SubsribedPack_Annc", "pack-available").setDebugId(7808));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("AppVariables:TransferPoint", "TransferPoints:RD01_TR_0020", false).setDebugId(7810));
				actions.add(new com.avaya.sce.runtime.Next("Transfer_Annc", "non-available").setDebugId(7811));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}

		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
	
	@Override
	public void requestBegin(SCESession mySession) {
		ITraceInfo trace = null;
		String key=null,appName = null,circleID = null,langId = null,menuOption = AppConstants.EMPTY_STRING,initialPrompt = null,menuID = null,dynamicWaves = null,offerDetail[]=null,offerDetails=null;
		/*Hashtable<String, Hashtable<String, Hashtable<String, CancelPackInfo>>> packInfoMessage = null;
		Hashtable<String, Hashtable<String, CancelPackInfo>> circlePackInfo = null;
		Hashtable<String, CancelPackInfo> langPackInfo = null;*/
		ArrayList<String> arrPacks=null;CancelPackInfo cancelPackInfo;
		Set<String> cancelPackKeySet = null,packIds = null;Get3GPacks get3gPacks = null;
		try
		{
			/** Formatting 3G Packs Request **/
			trace = mySession.getTraceOutput();
			get3gPacks = new Get3GPacks();
			get3gPacks.setSmartCardNumber(mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_SCNUMBER).getStringValue());
			get3gPacks.setReqSource(AppConstants.SOURCE_INFORMATION);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, " Get3GPacks Host Request :: "+get3gPacks.toString());
			
			/** 3G Packs Host Interaction **/
			get3gPacks = IVRDBServiceInstance.getRcomdth02DataService().validateGet3GPacks((IVRDataBean) mySession.getProperty(AppConstants.IVRDATABEAN), get3gPacks);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, " Get3GPacks Host Response :: "+get3gPacks.toString());
			
			if(get3gPacks.getOutStatus().contains(AppConstants.Success)&&get3gPacks.getOutMsg().contains(AppConstants.Success))
			{
				appName = mySession.getVariableField(IProjectVariables.APP__NAME).getStringValue();
				circleID = mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_CIRCLE_ID).getStringValue();
				langId = mySession.getCurrentLanguage();
				
				packIds = new TreeSet<>();
				offerDetails = get3gPacks.getOfferDetail();
				offerDetail = offerDetails.split(AppConstants.SEPERATOR_PIPE);
				for(int i=0;i<offerDetail.length;i++)
				{
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "OfferDetail :: "+i+" :"+offerDetail[i]);
					packIds.add(offerDetail[i].split(AppConstants.SEPERATOR_COMMA)[AppConstants.Zero]);
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Adding Pack Id :: "+offerDetail[i].split(AppConstants.SEPERATOR_COMMA)[AppConstants.Zero]);
					
				}
								
				/*key = AppConstants.CANCELPACKS_KEY+appName;
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, " CancelPackInfoKey :: "+key);
				packInfoMessage = (Hashtable<String, Hashtable<String, Hashtable<String, CancelPackInfo>>>) AppDataMap.getInstance(appName).getAppData(key);
				
				if(packInfoMessage != null)
				{
					circlePackInfo = packInfoMessage.get(circleID);
					langPackInfo = circlePackInfo.get(langId);
					cancelPackKeySet = langPackInfo.keySet();*/
					
				if(packIds.size()>AppConstants.Zero)
				{
					arrPacks = new ArrayList<>();
					
					for (String packId  : packIds) {
							cancelPackInfo = new CancelPackInfo();
							cancelPackInfo.setOfferCode(packId);
							cancelPackInfo = IVRDBServiceInstance.getIVRDBInstance().queryCancelPackInfo((IVRDataBean) mySession.getProperty(AppConstants.IVRDATABEAN), cancelPackInfo);
							if(cancelPackInfo.getStatusFlag().equalsIgnoreCase(AppConstants.Success) && cancelPackInfo.getErrorCode().equalsIgnoreCase(AppConstants.zero))
							{arrPacks.add(cancelPackInfo.getPhraseId());
							menuOption = menuOption+packId+AppConstants.SEPERATOR_COMMA;}
							else
							{trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "** Pack Info was Not Available in the Admin ** for "+packId);}
							cancelPackInfo = null;
					}
					
					if(arrPacks.size()>AppConstants.Zero)
					{
					mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_PACK_AVAILABLE).setValue(AppConstants.Yes);
					String count = String.valueOf(arrPacks.size());
					dynamicWaves = AppProperties.GetInstance(AppConstants.IVR_CONFIG_PROPERTIES).getIVRProp(appName+AppConstants.SEPERATOR_HYPEN+AppConstants.RD01_PA_0043);
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, " DynamicWaves from Property for "+AppConstants.RD01_PA_0043+" :: "+dynamicWaves);
					initialPrompt = DynamicMenu.playPrompt(arrPacks, dynamicWaves, count, AppConstants.RD01_PA_0043, trace);
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Initial Prompt ::"+initialPrompt);
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Menu Option : "+menuOption);
					
					mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER,IProjectVariables.DM_INPUT_PARAMETER_FIELD_INITIAL_PROMPT).setValue(initialPrompt);
					}
					else
					{
						trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "** Pack ID is not in DB **");
						mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_PACK_AVAILABLE).setValue(AppConstants.No);
					}
				}
				else
					mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_PACK_AVAILABLE).setValue(AppConstants.No);
			}else if(get3gPacks.getOutStatus().contains(AppConstants.Failure)&&get3gPacks.getOutErrorCode().equalsIgnoreCase(AppConstants.one))
				mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_PACK_AVAILABLE).setValue(AppConstants.No);
			else
				mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_HOST_FAILURE).setValue(AppConstants.Yes);
			
		}catch(Exception e)
		{mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_HOST_FAILURE).setValue(AppConstants.Yes);
		StackTrace.PrintException(e);
		}
		finally
		{trace=null;/*packInfoMessage=null;circlePackInfo=null;langPackInfo=null*/cancelPackInfo=null;;arrPacks=null;cancelPackKeySet=null;key=null;offerDetails=null;appName = null;circleID = null;langId = null;menuOption = null;initialPrompt = null;menuID = null;dynamicWaves = null;}
		}
}
