package flow.subflow.AccountInformation;

import java.util.ArrayList;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.servion.postpaid.utils.Constants;
import com.servion.postpaid.utils.DynamicMenu;
import com.servion.postpaid.utils.PrintStackTrace;
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
 * Last generated by Orchestration Designer at: 2015-APR-15  08:35:24 PM
 */
public class Initialize_PA_0032 extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	@Override
	public void requestBegin(SCESession mySession) {
		super.requestBegin(mySession);
		
		String strInitialAudio = "";
		String strAmount = "", strDate = "", strMode = "";
		AppProperties audioPropertyInstance = null;
		DynamicMenu dynamicMenu = null;
		ArrayList<String> dynamicAudioList = null;
		ITraceInfo info = null;
		String dynaListSize = "";
		String strApplicationName = "";
		
		try {
			dynamicMenu = new DynamicMenu();
			dynamicAudioList = new ArrayList<String>();
			info = mySession.getTraceOutput();
			audioPropertyInstance = (AppProperties) mySession.getProperty(Constants.AudioPropertyInstance);
			strApplicationName = mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_APPLICATION_NAME).getStringValue();
			strInitialAudio = audioPropertyInstance.getIVRProp(strApplicationName+Constants.HYPEN+Constants.PA_0032);
			strAmount = mySession.getVariableField(IProjectVariables.CHECK_PAYMENT, IProjectVariables.CHECK_PAYMENT_FIELD_AMOUNT).getStringValue();
			strDate = mySession.getVariableField(IProjectVariables.CHECK_PAYMENT, IProjectVariables.CHECK_PAYMENT_FIELD_PAYMENT_RECEIVED_DATE).getStringValue();
			strMode = mySession.getVariableField(IProjectVariables.CHECK_PAYMENT, IProjectVariables.CHECK_PAYMENT_FIELD_PAYMENT_TYPE).getStringValue();
			strMode = strMode.replaceAll(" ", "");
			
			dynamicAudioList.add(strAmount+Constants.currency);
			dynamicAudioList.add(strDate);
			dynamicAudioList.add(audioPropertyInstance.getIVRProp(strMode));
			dynaListSize = String.valueOf(dynamicAudioList.size());
			strInitialAudio = dynamicMenu.playPrompt(dynamicAudioList, strInitialAudio, dynaListSize, info);
			
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Initial Audios for mode "+strMode+" is "+audioPropertyInstance.getIVRProp(strMode));
			
			mySession.getVariableField(IProjectVariables.DMPROPERTIES, IProjectVariables.DMPROPERTIES_FIELD_INITIAL_AUDIOS).setValue(strInitialAudio);
			
		} catch (Exception e) {
			PrintStackTrace.PrintException(e);
			info.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "Exception:"+e.getMessage());
		}
	}
	
	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-APR-15  08:35:24 PM
	 */
	public Initialize_PA_0032() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2015-NOV-08  05:50:23 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("AccountInformation-LastPayment_PA_0032", "Default");
		next.setDebugId(3634);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2015-NOV-08  05:50:23 PM
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
	 * Last generated by Orchestration Designer at: 2015-NOV-08  05:50:23 PM
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
}
