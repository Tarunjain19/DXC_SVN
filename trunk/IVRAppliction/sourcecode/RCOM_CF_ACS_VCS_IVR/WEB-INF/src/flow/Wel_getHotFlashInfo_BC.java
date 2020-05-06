package flow;

import java.util.Hashtable;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.acsvcs.Constants;
import com.rcom.acsvcs.StackTrace;
import com.rcom.otherflows.model.HotFlashInfo;
import com.rcom.otherflows.resource.IVRDBServiceInstance;
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
 * Last generated by Orchestration Designer at: 2015-MAR-16  07:47:36 PM
 */
public class Wel_getHotFlashInfo_BC extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAR-16  07:47:36 PM
	 */
	public Wel_getHotFlashInfo_BC() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	@Override
	public void requestBegin(SCESession mySession) {
	
		ITraceInfo trace = mySession.getTraceOutput();
		try {
		
		/*
		 * DB Hit to get Hot Flash Info
		 */
		
		StringBuilder sBuilder = new StringBuilder();
		HotFlashInfo reqHotFlashInfo = new HotFlashInfo();
		reqHotFlashInfo.setAppName(AppProperties.GetInstance(Constants.IVR_CONFIG_PROPERTIES).getIVRProp(Constants.APP_NAME));
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Calling DB Service to get HotFlashInfo");
		Hashtable<String, HotFlashInfo> htHotFlashInfo = IVRDBServiceInstance.getIVRDBInstance().getHotFlashInfo((IVRDataBean)mySession.getProperty(Constants.IVR_DATA_BEAN), reqHotFlashInfo);
		
		
		if(htHotFlashInfo != null)
		{
			mySession.setProperty(Constants.HOT_FLASH_INFO, htHotFlashInfo);
		}
		else
		{
			mySession.setProperty(Constants.HOT_FLASH_INFO, new Hashtable<String, HotFlashInfo>());
		}
		
		sBuilder.setLength(0);
		sBuilder.append(Constants.HOT_FLASH_ID_AVS_PA_0004);
		sBuilder.append(Constants.UNDERSCORE);
		sBuilder.append(mySession.getVariableField(IProjectVariables.CIRCLE).getStringValue());
		sBuilder.append(Constants.UNDERSCORE);
		sBuilder.append(AppProperties.GetInstance(Constants.IVR_CONFIG_PROPERTIES).getIVRProp(Constants.LANGUAGE_ENGLISH));
		
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Key to get Hotflash Info : " +sBuilder);
		
		HotFlashInfo hotFlashInfo = htHotFlashInfo.get(sBuilder.toString());
		
		boolean hotFlashEnabled = false;
		String hotFlashInitialPrompt = null;
		
		if(hotFlashInfo != null)
		{
			String enabledFlag = hotFlashInfo.getEnabledFlag();
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Hot Flash Enabled Flag : " +enabledFlag);
			
			if(enabledFlag.equalsIgnoreCase(Constants.ENABLED))
			{
				
				
					String phraseID = hotFlashInfo.getPhraseId();
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Hot Flash Phrase ID : " +phraseID);
					if(phraseID!= null && !phraseID.equalsIgnoreCase(Constants.EMPTY))
					{
						hotFlashEnabled = true;
						hotFlashInitialPrompt = phraseID;
					}
							
				
			}
		}
		
		mySession.getVariableField(IProjectVariables.HOT_FLASH_INFO, IProjectVariables.HOT_FLASH_INFO_FIELD_IS_HOT_FLASH_ENABLED).setValue(hotFlashEnabled);
		mySession.getVariableField(IProjectVariables.HOT_FLASH_INFO, IProjectVariables.HOT_FLASH_INFO_FIELD_HOT_FLASH_INITIAL_PROMPT).setValue(hotFlashInitialPrompt);
		mySession.getVariableField(IProjectVariables.HOT_FLASH_INFO, IProjectVariables.HOT_FLASH_INFO_FIELD_ANNO_ID).setValue(Constants.HOT_FLASH_ID_AVS_PA_0004);
		} catch (Exception e) {
			mySession.getVariableField(IProjectVariables.HOT_FLASH_INFO, IProjectVariables.HOT_FLASH_INFO_FIELD_IS_HOT_FLASH_ENABLED).setValue(false);
			StackTrace.PrintException(e);
			
		}
	}
	
	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-JUN-19  10:56:27 AM
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
	 * Last generated by Orchestration Designer at: 2017-JUN-19  10:56:27 AM
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
	 * Last generated by Orchestration Designer at: 2017-JUN-19  10:56:27 AM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(4);
		actions.add(new com.avaya.sce.runtime.varoperations.Assign("HotFlashInfo:CallingNodeId", "NodeNames:WelcomeAnn_PP", false).setDebugId(295));
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "Setting HotFlash Information", "").setDebugId(479));
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "HotFlashInfo:isHotFlashEnabled", "HotFlashInfo:isHotFlashEnabled").setDebugId(691));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "HotFlashInfo:isHotFlashEnabled", com.avaya.sce.runtime.Expression.IS_TRUE).setDebugId(696)).evaluate(mySession)) {
			actions = new java.util.ArrayList(4);
			actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "HotFlashInfo:annoID - ", "HotFlashInfo:annoID").setDebugId(480));
			actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "HotFlashInfo:CallingNodeId - ", "HotFlashInfo:CallingNodeId").setDebugId(481));
			actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "HotFlashInfo:HotFlashInitialPrompt", "HotFlashInfo:HotFlashInitialPrompt").setDebugId(690));
			actions.add(new com.avaya.sce.runtime.Next("HotFlash_PP", "HotFlashApplicable").setDebugId(142));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("AudioOrVideo_MN", "HotFlashNotApplicable").setDebugId(698));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
