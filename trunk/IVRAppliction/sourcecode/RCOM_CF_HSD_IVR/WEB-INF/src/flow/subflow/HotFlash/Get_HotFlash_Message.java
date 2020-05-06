package flow.subflow.HotFlash;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.prepaid.model.HotFlashInfo;
import com.servion.hsd.utils.AppConstant;
import com.servion.hsd.utils.AppDataMap;
import com.servion.hsd.utils.StackTrace;



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
 * Last generated by Orchestration Designer at: 2015-MAR-12  10:47:09 PM
 */
public class Get_HotFlash_Message extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAR-12  10:47:09 PM
	 */
	public Get_HotFlash_Message() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:39:08 PM
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
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:39:08 PM
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
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:39:08 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(2);
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_INFO, "Hot Flash Enable Disable Flag :", "HotFlashInfo:Flag").setDebugId(145));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "HotFlashInfo:Flag", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:Key_true", true).setDebugId(142)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("HotFlash-Start_HotFlash").setDebugId(7));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("HotFlash-Return", "Return").setDebugId(144));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
	@Override
	public void requestBegin(SCESession mySession) {
		/**Declaration**/
		String phraseID = AppConstant.EMPTY_STRING,appName =  AppConstant.EMPTY_STRING,circleID = AppConstant.EMPTY_STRING,hotFlashFlag = AppConstant.FALSE;
		String startDate = AppConstant.EMPTY_STRING, endDate = AppConstant.EMPTY_STRING,language = AppConstant.EMPTY_STRING;
		String hotFlashKey = AppConstant.EMPTY_STRING,phraseKey=AppConstant.EMPTY_STRING,nodeID =  AppConstant.EMPTY_STRING;
		String flagPlayHotFlash = AppConstant.FALSE;
		Hashtable<String, HotFlashInfo> objMapHotFlashInfo = null;
		HotFlashInfo objHotFlashInfo = null;
		SimpleDateFormat sdFormat = null;
		Date dstartDate = null, dendDate = null , currDate = null;
		ITraceInfo trace = null;
		
		/**Assign**/
		try{
			
			trace = mySession.getTraceOutput();
			appName = mySession.getVariableField(IProjectVariables.APP__NAME).getStringValue();
			nodeID = mySession.getVariableField(IProjectVariables.HOT_FLASH_INFO,IProjectVariables.HOT_FLASH_INFO_FIELD_ANNO_ID).getStringValue();
			circleID = mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_CIRCLE_ID).getStringValue();
			language = mySession.getCurrentLanguage();
	
			hotFlashKey = AppConstant.HOTFLASH_KEY+appName;
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Application Name Inside Hot Flash :" +appName);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Applevel hot Flash Key :" +hotFlashKey);
			objMapHotFlashInfo = (Hashtable<String, HotFlashInfo>) AppDataMap.getInstance(appName).getAppData(hotFlashKey);
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"object Map Hot Flash Info :" +objMapHotFlashInfo);
			
			/**Take Node Level Phrase **/
			
			if(objMapHotFlashInfo!=null){
				
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"object Map Hot Flash Info :" +objMapHotFlashInfo.toString());
				
				phraseKey =nodeID+AppConstant.SEPERATOR_UNDERSCORE+circleID+AppConstant.SEPERATOR_UNDERSCORE+language;
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"phrase Key For Hot flash message :" +phraseKey);
				objHotFlashInfo = objMapHotFlashInfo.get(phraseKey);
				
				if(objHotFlashInfo!=null){
					startDate = objHotFlashInfo.getStartDate();
					endDate =objHotFlashInfo.getEndDate();
					hotFlashFlag = objHotFlashInfo.getEnabledFlag();
					phraseID =objHotFlashInfo.getPhraseId();
					
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Hot Flash start Date:" +startDate);
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Hot Flash end Date:" +endDate);
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Hot Flash Flag:" +hotFlashFlag);
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Hot Flash phrase ID:" +phraseID);
					
					if(AppConstant.Y.equalsIgnoreCase(hotFlashFlag)){
						/*sdFormat = new SimpleDateFormat(AppConstant.DATE_FORMAT_DDMMYYYY);
						dstartDate = sdFormat.parse(startDate);
						dendDate = sdFormat.parse(endDate);
						
						*//**Remove Time**//*
						currDate = Calendar.getInstance().getTime();
						String strCurrDate = sdFormat.format(currDate);
						currDate = sdFormat.parse(strCurrDate);*/
						
						//if((currDate.compareTo(dstartDate)==0)||(currDate.compareTo(dendDate)==0)||(currDate.after(dstartDate) && dendDate.after(currDate))){
						trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Hot Flash is Valid:Flag is set to true");
						mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER,IProjectVariables.DM_INPUT_PARAMETER_FIELD_INITIAL_PROMPT).setValue(phraseID);
						flagPlayHotFlash = AppConstant.TRUE;
						//}
					}
				}
				
			}
		}catch(Exception e){
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "Error in Hot Flash :" +e);
			StackTrace.PrintException(e);
		}
		mySession.getVariableField(IProjectVariables.HOT_FLASH_INFO,IProjectVariables.HOT_FLASH_INFO_FIELD_FLAG).setValue(flagPlayHotFlash);
	}
}

