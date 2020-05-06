package flow;

import java.lang.reflect.Method;
import java.util.HashMap;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.IVariable;
import com.avaya.sce.runtimecommon.SCESession;
import com.dm.util.Constants;


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
 * Last generated by Orchestration Designer at: 2015-JAN-14  11:34:47 AM
 */
public class SetReport extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-JAN-14  11:34:47 AM
	 */
	public SetReport() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	@Override
	public void requestBegin(SCESession mySession) {
		ITraceInfo info = mySession.getTraceOutput();
		String reportEnabled = Constants.EMPTY_STRING;
		String reportClassName = Constants.EMPTY_STRING;
		String reportMethodName = Constants.EMPTY_STRING;
		
		HashMap<Object, Object> reportParamMap = null;
		IVariable outputVar = mySession.getVariable(IProjectVariables.OUTPUT__PARAMETERS);
		String menuID = Constants.EMPTY_STRING;
		String announceID = Constants.EMPTY_STRING;
		String menuReturnCode = Constants.EMPTY_STRING;
		String menuValue = Constants.EMPTY_STRING;
		String menuUtterance = Constants.EMPTY_STRING;
		String menuStartTime = Constants.EMPTY_STRING;
		String menuEndTime = Constants.EMPTY_STRING;
		String inputType = Constants.EMPTY_STRING;
		String noInputRemaining = Constants.EMPTY_STRING;
		String noMatchRemaining = Constants.EMPTY_STRING;
		String confidence = Constants.EMPTY_STRING;
		String recordedUtterance = Constants.EMPTY_STRING;
		String nbestValues = Constants.EMPTY_STRING;
		String otherSlot = Constants.EMPTY_STRING;
		String specificSlot = Constants.EMPTY_STRING;
		String dialogName = Constants.EMPTY_STRING;
		String privateData = Constants.EMPTY_STRING;
		try {
		
			reportEnabled = mySession.getVariableField(IProjectVariables.INPUT_VARIABLES,IProjectVariables.INPUT_VARIABLES_FIELD_REPORT_XMLENABLE).getStringValue();
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Report Enabled ---> " + reportEnabled);
			if(Constants.TRUE.equalsIgnoreCase(reportEnabled)){
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Report details are set");
				reportParamMap = new HashMap<>();
				
				reportClassName = mySession.getVariableField(IProjectVariables.INPUT_VARIABLES,IProjectVariables.INPUT_VARIABLES_FIELD_REPORT__CLASS_NAME).getStringValue();
				reportMethodName = mySession.getVariableField(IProjectVariables.INPUT_VARIABLES,IProjectVariables.INPUT_VARIABLES_FIELD_REPORT__METHOD_NAME).getStringValue();
				
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Report Class Name invoked for Report XML ---> " + reportClassName);
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Report Method Name invoked for Report XML ---> " + reportMethodName);
				
				menuID = outputVar.getComplexVariable().getField(IProjectVariables.OUTPUT__PARAMETERS_FIELD_MENU_ID).getStringValue();
				announceID = outputVar.getComplexVariable().getField(IProjectVariables.OUTPUT__PARAMETERS_FIELD_ANNOUNCE_ID).getStringValue();
				menuReturnCode = outputVar.getComplexVariable().getField(IProjectVariables.OUTPUT__PARAMETERS_FIELD_RETURNCODE).getStringValue();
				menuValue = outputVar.getComplexVariable().getField(IProjectVariables.OUTPUT__PARAMETERS_FIELD_VALUE).getStringValue();
				menuUtterance = outputVar.getComplexVariable().getField(IProjectVariables.OUTPUT__PARAMETERS_FIELD_UTTERANCE).getStringValue();
				menuStartTime = outputVar.getComplexVariable().getField(IProjectVariables.OUTPUT__PARAMETERS_FIELD_MENU_START_TIME).getStringValue();
				menuEndTime = outputVar.getComplexVariable().getField(IProjectVariables.OUTPUT__PARAMETERS_FIELD_MENU_END_TIME).getStringValue();
				inputType = outputVar.getComplexVariable().getField(IProjectVariables.OUTPUT__PARAMETERS_FIELD_INPUT_TYPE).getStringValue();
				noInputRemaining = outputVar.getComplexVariable().getField(IProjectVariables.OUTPUT__PARAMETERS_FIELD_NO_INPUT_REMAINING).getStringValue();
				noMatchRemaining = outputVar.getComplexVariable().getField(IProjectVariables.OUTPUT__PARAMETERS_FIELD_NO_MATCHS_REMAINING).getStringValue();
				confidence =  outputVar.getComplexVariable().getField(IProjectVariables.OUTPUT__PARAMETERS_FIELD_CONFIDENCE).getStringValue();
				recordedUtterance =  outputVar.getComplexVariable().getField(IProjectVariables.OUTPUT__PARAMETERS_FIELD_RECORDED_UTTERANCE).getStringValue();
				nbestValues =  outputVar.getComplexVariable().getField(IProjectVariables.OUTPUT__PARAMETERS_FIELD_N_BEST_VALUES).getStringValue();
				otherSlot =  outputVar.getComplexVariable().getField(IProjectVariables.OUTPUT__PARAMETERS_FIELD_OTHER_SLOT).getStringValue();
				specificSlot =  outputVar.getComplexVariable().getField(IProjectVariables.OUTPUT__PARAMETERS_FIELD_SPECIFIC_SLOTS).getStringValue();
				dialogName =  mySession.getVariableField(IProjectVariables.INPUT_VARIABLES,IProjectVariables.INPUT_VARIABLES_FIELD_DIALOG_NAME).getStringValue();
				privateData = mySession.getVariableField(IProjectVariables.INPUT_VARIABLES,IProjectVariables.INPUT_VARIABLES_FIELD_PRIVATE_DATA).getStringValue();
				
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "----- Output Parameters ----- "); 
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Menu ID ---> " + menuID);
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Announce ID ---> " + announceID);
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Menu Return Code ---> " + menuReturnCode);
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "private Data ---> " + privateData);
				//info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Menu Utterance ---> " + menuUtterance);
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Menu StartTime ---> " + menuStartTime);
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Menu End Time ---> " + menuEndTime);
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Input Type ---> " + inputType);
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "No Input Remaining ---> " + noInputRemaining);
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "No Match Remaining ---> " + noMatchRemaining);
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Confidence ---> " + confidence);
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Recorded Utterance ---> " + recordedUtterance);
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "NBest Values ---> " + nbestValues);
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Other Slot ---> " + otherSlot);
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Specific Slot ---> " + specificSlot);
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Dialog Name ---> " + dialogName);
				
				reportParamMap.put(Constants.MENU_ID, menuID);
				reportParamMap.put(Constants.ANNOUNCE_ID, announceID);
				reportParamMap.put(Constants.RETURN_CODE, menuReturnCode);
				reportParamMap.put(Constants.MENU_VALUE, menuValue);
				reportParamMap.put(Constants.MENU_UTTERANCE, menuUtterance);
				reportParamMap.put(Constants.MENU_START_TIME, menuStartTime);
				reportParamMap.put(Constants.MENU_END_TIME, menuEndTime);
				reportParamMap.put(Constants.INPUT_TYPE, inputType);
				reportParamMap.put(Constants.NO_INPUT_REMAINING, noInputRemaining);
				reportParamMap.put(Constants.NO_MATCH_REMAINING, noMatchRemaining);
				reportParamMap.put(Constants.CONFIDENCE, confidence);
				reportParamMap.put(Constants.RECORDED_UTTERANCE, recordedUtterance);
				reportParamMap.put(Constants.NBEST_VALUE, nbestValues);
				reportParamMap.put(Constants.OTHER_SLOT, otherSlot);
				reportParamMap.put(Constants.SPECIFIC_SLOT, specificSlot);
				reportParamMap.put(Constants.DIALOG_NAME, dialogName);
				reportParamMap.put(Constants.SESSION, mySession);
				reportParamMap.put(Constants.privateData,privateData);
				
				Class c = Class.forName(reportClassName);
				Method m = c.getMethod(reportMethodName, HashMap.class);
				m.invoke(c.newInstance(), reportParamMap);
				
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Report details Invoked succesfully ");
				
			}else{
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Report details are not set ");
			}
		} catch (Exception e) {
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Report details are not set " + e);
			e.printStackTrace();

		}finally{
			if(reportParamMap!=null){
				reportParamMap.clear();
				reportParamMap = null;
			}
		}

	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-SEP-04  04:23:34 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("Exit", "Default");
		next.setDebugId(1990);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2017-SEP-04  04:23:34 PM
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
	 * Last generated by Orchestration Designer at: 2017-SEP-04  04:23:34 PM
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
