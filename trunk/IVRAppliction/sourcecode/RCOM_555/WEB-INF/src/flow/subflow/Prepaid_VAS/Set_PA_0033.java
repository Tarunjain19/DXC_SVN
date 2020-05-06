package flow.subflow.Prepaid_VAS;

import java.util.ArrayList;
import java.util.HashMap;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
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
 * Last generated by Orchestration Designer at: 2015-MAR-11  01:04:26 PM
 */
public class Set_PA_0033 extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAR-11  01:04:26 PM
	 */
	public Set_PA_0033() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:50 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("Prepaid_VAS-PA_0033", "Default");
		next.setDebugId(5542);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:50 PM
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
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:50 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
	@Override
	public void requestBegin(SCESession mySession) {

		ITraceInfo trace = mySession.getTraceOutput();
		String key = AppConstant.EMPTY_STRING,appName = AppConstant.EMPTY_STRING;
		String selectedOfferID =AppConstant.EMPTY_STRING;
		HashMap<String,String> offerPhraseMap = null;
		ArrayList<String> dynamicWave = null;
		String initialPrompt = null;
		String offerID =AppConstant.EMPTY_STRING;
		
		//initial prompt processing...
		try
		{
			appName = mySession.getVariableField(IProjectVariables.APP_NAME).getStringValue();
			selectedOfferID = mySession.getVariableField(IProjectVariables.MN___0_0_1_0,IProjectVariables.MN___0_0_1_0_FIELD_VALUE).getStringValue();
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Application Name :: "+appName);
			
			key = appName +AppConstant.SEPERATOR_HYPEN+ AppConstant.PA_0033;
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Key :: "+key);
			initialPrompt = AppProperties.GetInstance(Constants.AUDIO_CONFIG).getIVRProp(key);
			dynamicWave = new ArrayList<String>();
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "VAS Activated Success initial Prompt Before Dynamic Insertion:: "+initialPrompt);
			offerPhraseMap = (HashMap<String, String>) mySession.getProperty(AppConstant.OFFER_PHRASE_MAP);
			offerID = offerPhraseMap.get(selectedOfferID);
			
			dynamicWave.add(offerID);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Pack Wave :"+offerID);
			
			DynamicMenu objDynamicMenu = new DynamicMenu();
			initialPrompt=objDynamicMenu.playPrompt(dynamicWave, initialPrompt, AppConstant.NA, trace);
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "VAS Activated Success initial Prompt :: "+initialPrompt);
			
			mySession.getVariableField(IProjectVariables.PREPAID__DM_INPUT_PARAMETER, IProjectVariables.PREPAID__DM_INPUT_PARAMETER_FIELD_INITIAL_PROMPT).setValue(initialPrompt);
			
			
		}
		catch(Exception e)
		{
			PrintStackTrace.PrintException(e);
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "Exception in VAS Activated Success initial prompt :: "+e);
		}
		finally
		{
				initialPrompt = null;
		}
		
	
	}
}
