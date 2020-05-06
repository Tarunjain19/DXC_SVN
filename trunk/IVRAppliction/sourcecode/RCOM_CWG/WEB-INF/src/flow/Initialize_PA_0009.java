package flow;

import java.util.ArrayList;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.servion.postpaid.utils.Constants;
import com.servion.postpaid.utils.DynamicMenu;
import com.servion.postpaid.utils.PrintStackTrace;
import com.servion.util.AppProperties;

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
 * Last generated by Orchestration Designer at: 2015-APR-13  04:11:29 PM
 */
public class Initialize_PA_0009 extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	@Override
	public void requestBegin(SCESession mySession) {
		super.requestBegin(mySession);
		
		/*Declaring variables*/
		ITraceInfo info = null;
		String strInitialAudio = null;
		AppProperties audioConfigInstance = null;
		String strCurrentLanguage = "";
		DynamicMenu dynamicMenu = null;
		ArrayList<String> dynamicValueList = null;
		String strApplicationName = "";
		try {
			
			/*Getting call data from session*/
			info = mySession.getTraceOutput();
			dynamicMenu = new DynamicMenu();
			dynamicValueList = new ArrayList<String>();
			strApplicationName = mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_APPLICATION_NAME).getStringValue();
			audioConfigInstance = (AppProperties) mySession.getProperty(Constants.AudioPropertyInstance);
			strCurrentLanguage = mySession.getCurrentLanguage();
			dynamicValueList.add(audioConfigInstance.getIVRProp(strCurrentLanguage));
			strInitialAudio = audioConfigInstance.getIVRProp(strApplicationName+Constants.HYPEN+Constants.PA_0009);
			strInitialAudio = dynamicMenu.playPrompt(dynamicValueList, strInitialAudio, ""+dynamicValueList.size(), info);
									
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->Intial Audios:"+strInitialAudio);
			mySession.getVariableField(IProjectVariables.DMPROPERTIES, IProjectVariables.DMPROPERTIES_FIELD_INITIAL_AUDIOS).setValue(strInitialAudio);
			
		} catch (Exception e) {
			PrintStackTrace.PrintException(e);
			info.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "Exception:"+e.getMessage());
		}
		
	}
	
	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-APR-13  04:11:29 PM
	 */
	public Initialize_PA_0009() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2015-NOV-08  05:50:17 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("PlaySelectedLanguage_PA_0009", "Default");
		next.setDebugId(496);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2015-NOV-08  05:50:17 PM
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
	 * Last generated by Orchestration Designer at: 2015-NOV-08  05:50:17 PM
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
