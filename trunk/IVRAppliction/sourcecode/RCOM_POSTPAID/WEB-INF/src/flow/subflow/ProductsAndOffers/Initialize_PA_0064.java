package flow.subflow.ProductsAndOffers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.servion.postpaid.utils.Constants;
import com.servion.postpaid.utils.PrintStackTrace;
import com.servion.postpaid.utils.SetPushSMS;
import com.servion.rcom.hostinterface.view.PlanDetails;
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
 * Last generated by Orchestration Designer at: 2015-MAY-08  01:03:41 PM
 */
public class Initialize_PA_0064 extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS
	
	@Override
	public void requestBegin(SCESession mySession) {

		ITraceInfo info = mySession.getTraceOutput();

		String initialPrompt = null;
		String selectedOfferID = Constants.EMPTY_STRING;
		HashMap<String,String> offerDetailPhrases = null;
		AppProperties appProperties = null;
		PlanDetails planDetails = null;
		SetPushSMS setPushSMS = null;
		String strSMSFrame = "";
		ArrayList<String> arrSMSData = null;
		Hashtable<String, String> smsHashTable = null;
		
		//initial prompt processing...
		try
		{
			
			setPushSMS = new SetPushSMS();
			arrSMSData = new ArrayList<String>();
			
			appProperties = (AppProperties) mySession.getProperty(Constants.IvrPropertyInstance);
			
			selectedOfferID = mySession.getVariableField(IProjectVariables.VOICE_OFFER__MN___0_0_2_5,IProjectVariables.VOICE_OFFER__MN___0_0_2_5_FIELD_VALUE).getStringValue();
			
			info.writeln(ITraceInfo.TRACE_LEVEL_INFO, "selectedOfferID :: "+selectedOfferID);
			
			mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_PACK_CODE).setValue(selectedOfferID);
			offerDetailPhrases = (HashMap<String,String>) mySession.getProperty(Constants.OFFER_DETAILS_PHRASE);
			info.writeln(ITraceInfo.TRACE_LEVEL_INFO, "offer Detail Phrases :: "+offerDetailPhrases);
			
			if(offerDetailPhrases!=null){
				initialPrompt = offerDetailPhrases.get(selectedOfferID);
			}
			
			arrSMSData.add(selectedOfferID);
			strSMSFrame = appProperties.getIVRProp(Constants.VOICE_OFFER_Success);
			info.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Voice Offer Success SMS Frame :: "+strSMSFrame);
			smsHashTable = setPushSMS.generatePushSMSDataMap(strSMSFrame, arrSMSData);
			mySession.setProperty(Constants.SMSDataMap, smsHashTable);
			
			info.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Voice initial Prompt :: "+initialPrompt);
			
			mySession.getVariableField(IProjectVariables.DMPROPERTIES, IProjectVariables.DMPROPERTIES_FIELD_INITIAL_AUDIOS).setValue(initialPrompt);
			
			
		}
		catch(Exception e)
		{
			PrintStackTrace.PrintException(e);
			info.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "Exception in Voice initial prompt :: "+e);
		}
		finally
		{
				initialPrompt = null;
		}
		
	
	}

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-08  01:03:41 PM
	 */
	public Initialize_PA_0064() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-AUG-28  11:20:44 AM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("ProductsAndOffers-PlayOffer_PA_0064", "Continue");
		next.setDebugId(2367);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2017-AUG-28  11:20:44 AM
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
	 * Last generated by Orchestration Designer at: 2017-AUG-28  11:20:44 AM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(2);
		actions.add(new com.avaya.sce.runtime.varoperations.Assign("CallData:transferReasonCode", "TR_0072", true).setDebugId(2568));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
