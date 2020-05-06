package flow.subflow.BuyThePack;

import java.util.ArrayList;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.servion.util.AppConstant;
import com.servion.util.AppProperties;
import com.servion.util.DynamicMenu;

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
public class Initialize_MN_0038 extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	@Override
	public void requestBegin(SCESession mySession) {
		super.requestBegin(mySession);
		
		ITraceInfo info = mySession.getTraceOutput();
		
		/*Declaring variables*/
		String strInitialAudios = "";
		String strAmountEntered = "";
		AppProperties appProperties = null;
		String strApplicationName = "";
		ArrayList<String> dynamicArrayList = null;
		
		dynamicArrayList = new ArrayList<String>();
		
		/*Assigning values*/
		appProperties = AppProperties.GetInstance(AppConstant.DYN_MENU);
		strAmountEntered = mySession.getVariableField(IProjectVariables.COLLECT_AMOUNT__MN___0_0_3_7COPY, IProjectVariables.COLLECT_AMOUNT__MN___0_0_3_7COPY_FIELD_VALUE).getStringValue();
		strApplicationName = mySession.getVariableField(IProjectVariables.APP_NAME).getStringValue();
		
		/*Initializing audio*/
		strInitialAudios = appProperties.getIVRProp(strApplicationName+AppConstant.SEPERATOR_HYPEN+AppConstant.MN_0055);
		dynamicArrayList.add(strAmountEntered+AppConstant.currency);
		strInitialAudios = DynamicMenu.playPrompt(dynamicArrayList, strInitialAudios, null, AppConstant.MN_0055, info);
		
		/*Setting to session*/
		mySession.getVariableField(IProjectVariables.DMPROPERTIES, IProjectVariables.DMPROPERTIES_FIELD_INITIAL_AUDIOS).setValue(strInitialAudios);
		
		
	}
	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-APR-15  08:35:24 PM
	 */
	public Initialize_MN_0038() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-JUL-05  10:39:16 AM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("BuyThePack-ConfirmAmount_MN_0038Copy", "Default");
		next.setDebugId(3253);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2017-JUL-05  10:39:16 AM
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
	 * Last generated by Orchestration Designer at: 2017-JUL-05  10:39:16 AM
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
