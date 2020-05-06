package flow;

import java.util.ArrayList;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.Data.utils.Constants;
import com.rcom.Data.utils.DynamicMenu;
import com.rcom.Data.utils.StackTrace;
import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA;
import com.servion.prepaid.report.IVRREPORTDATA.CALLINFO;
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
 * Last generated by Orchestration Designer at: 2016-NOV-29  11:35:30 AM
 */
public class SetDeactConfMN extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2016-NOV-29  11:35:30 AM
	 */
	public SetDeactConfMN() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2016-DEC-07  03:15:31 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("DeactivationConf_MN", "Default");
		next.setDebugId(4397);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2016-DEC-07  03:15:31 PM
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
	 * Last generated by Orchestration Designer at: 2016-DEC-07  03:15:31 PM
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
		/** Declaration **/
		String  propetyKey= Constants.BLANK;
		String  key = Constants.BLANK,propertiesLocation = Constants.BLANK;
		String initialPrompt = Constants.BLANK,grammarValue = Constants.BLANK,circleLangCode = Constants.BLANK;
		String dynamicWaves =  Constants.BLANK,circleLanguage = Constants.BLANK,appName = Constants.BLANK;
		String selectedPack = Constants.BLANK;
		String[] arrayLangCode = null;
		ArrayList<String> arrPack =null;
		ITraceInfo trace =null;
	
		/**Assign**/
		trace = mySession.getTraceOutput();
				
		try{
		
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Language Selection Menu Inital Prompt Start");
	
		appName  = mySession.getVariableField(IProjectVariables.APP__VARIABLES,IProjectVariables.APP__VARIABLES_FIELD_APP_NAME).getStringValue();
		selectedPack = mySession.getVariableField(IProjectVariables.APP__VARIABLES,IProjectVariables.APP__VARIABLES_FIELD_PACK_SELECTED).getStringValue();
		key = appName+Constants.HYPEN+Constants.MN_003;
		
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"application Name :"+appName);
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Language initial Prompt Key :"+key);
		
		dynamicWaves = AppProperties.GetInstance(Constants.DYN_MENU).getIVRProp(key);
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Language initial Prompt :"+dynamicWaves);
		arrPack = new ArrayList<>();
		/** Form Dynamic Initial Prompt**/
			selectedPack = selectedPack+Constants.wave;
			arrPack.add(selectedPack);
		
			/** Form Initial Prompt**/
			String count = Constants.one;
			DynamicMenu objDynamicMenu = new DynamicMenu();
			initialPrompt=DynamicMenu.playPrompt(arrPack, dynamicWaves,count, trace);
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Initial Prompt ::"+initialPrompt);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Menu Option Count: "+count);
			
			mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER,IProjectVariables.DM_INPUT_PARAMETER_FIELD_INITIAL_PROMPT).setValue(initialPrompt);
			//mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER,IProjectVariables.DM_INPUT_PARAMETER_FIELD_MORE_OPTION_COUNT).setValue(count);
			//mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER,IProjectVariables.DM_INPUT_PARAMETER_FIELD_MENU_OPTION).setValue(circleLangCode);
			
		}catch (Exception e) {
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "Error :" +e);
			StackTrace.PrintException(e);
		}
		
	}
	}
	