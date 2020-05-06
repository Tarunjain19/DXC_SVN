package flow.subflow.ServiceManagement;

import java.util.ArrayList;
import java.util.Hashtable;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.servion.rcom.hni.hostinterface.view.ReqIldActivation;
import com.servion.rcom.hni.hostinterface.view.ResIldActivation;
import com.servion.rcom.hni.hostinterface.wrapper.IVRWebService;
import com.servion.rcom.hni.hostinterface.wrapper.IVRWebServiceImpl;
import com.servion.triplefive.utils.Constants;
import com.servion.triplefive.utils.DynamicMenu;
import com.servion.triplefive.utils.PrintStackTrace;
import com.servion.triplefive.utils.SetPushSMS;
import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;

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
 * Last generated by Orchestration Designer at: 2015-MAY-06  07:11:56 PM
 */
public class AccessHost_ActivateILD extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS
	
	@Override
	public void requestBegin(SCESession mySession) {
	
		ITraceInfo info = null;
		String mdn = null,packCode = "", strApplicationName = "";
	
		ReqIldActivation reqil = null;
		ResIldActivation resIldActivation = null;
		IVRWebService webServiceManager = null;
		
		IVRDataBean objIVRData = null;
		AppProperties audioConfigInstance = null;
		String strInitialAudio = "";
		ArrayList<String> dynamicWave = null;
		DynamicMenu dynamicMenu = null;
		
		SetPushSMS setPushSMS = null;
		String strSMSFrame = "";
		ArrayList<String> arrSMSData = null;
		Hashtable<String, String> smsHashTable = null;
		AppProperties appProperties = null;
		
		try
		{
			info = mySession.getTraceOutput();
			setPushSMS = new SetPushSMS();
			arrSMSData = new ArrayList<String>();
			appProperties = (AppProperties) mySession.getProperty(Constants.IvrPropertyInstance);
			objIVRData = (IVRDataBean) mySession.getProperty(Constants.IVRDATABEAN);
			strApplicationName = mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_APPLICATION_NAME).getStringValue();
			
			//Request Processing......
			mdn = mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_MDN).getStringValue();
			packCode = mySession.getVariableField(IProjectVariables.PACK_NAME__MN___0_0_1_9,IProjectVariables.PACK_NAME__MN___0_0_1_9_FIELD_VALUE).getStringValue();
			
			reqil = new ReqIldActivation();
			reqil.setMDN(mdn);
			
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Activate VAS Host request :: "+reqil.toString());
			
			//Response Processing......
			webServiceManager = new IVRWebServiceImpl();
			resIldActivation = webServiceManager.executeIldActivation(objIVRData, reqil);
			
			if(resIldActivation!=null){
				if((resIldActivation.getResponseCode()).equals(Constants.zero)){
					
					
					
					dynamicMenu = new DynamicMenu();
					dynamicWave = new ArrayList<String>();
					
					dynamicWave.add(packCode);
					audioConfigInstance = (AppProperties) mySession.getProperty(Constants.AudioPropertyInstance);
					
					strInitialAudio = audioConfigInstance.getIVRProp(strApplicationName+Constants.HYPEN+Constants.PA_0046);
					strInitialAudio = dynamicMenu.playPrompt(dynamicWave, strInitialAudio, ""+dynamicWave.size(), info);
					
					info.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Initial Prompt :: "+strInitialAudio);
					mySession.getVariableField(IProjectVariables.DMPROPERTIES, IProjectVariables.DMPROPERTIES_FIELD_INITIAL_AUDIOS).setValue(strInitialAudio);
					mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_MSG_TEXT).setValue(resIldActivation.getMessageText());
					
					strSMSFrame = appProperties.getIVRProp(Constants.ILDACTIVATION_Success);
					smsHashTable = setPushSMS.generatePushSMSDataMap(strSMSFrame, arrSMSData);
					mySession.setProperty(Constants.SMSDataMap, smsHashTable);
					mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.No);
					
				}else if((resIldActivation.getResponseCode()).equals(Constants.one)){
					
					strSMSFrame = appProperties.getIVRProp(Constants.ILDACTIVATION_Failure);
					smsHashTable = setPushSMS.generatePushSMSDataMap(strSMSFrame, arrSMSData);
					mySession.setProperty(Constants.SMSDataMap, smsHashTable);
					mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.Yes);
				}else{
					mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_HOST_FAILURE).setValue(Constants.Yes);
				}
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Activate VAS Host response :: "+resIldActivation.getResponseCode());
			}
		}
		catch(Exception e)
		{
			strSMSFrame = appProperties.getIVRProp(Constants.ILDACTIVATION_Failure);
			smsHashTable = setPushSMS.generatePushSMSDataMap(strSMSFrame, arrSMSData);
			mySession.setProperty(Constants.SMSDataMap, smsHashTable);
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Error in Activate VAS Host Hit:: "+e);
			PrintStackTrace.PrintException(e);
			mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.Yes);
		}
		finally
		{
			reqil = null;
			resIldActivation = null;
			webServiceManager = null;
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Link down flag:"+mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).getStringValue());
		}
		
		
	}

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-06  07:11:56 PM
	 */
	public AccessHost_ActivateILD() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:42 PM
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
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:42 PM
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
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:42 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "Flag:isLinkDown", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:yes", true).setDebugId(2757)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("CallData:transferReasonCode", "TR_0060", true).setDebugId(5903));
			actions.add(new com.avaya.sce.runtime.Next("ServiceManagement-PushSMS_ILDActivationCopy", "LinkDown").setDebugId(2758));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "Flag:isHostFailure", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:yes", true).setDebugId(6436)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("CallData:transferReasonCode", "TR_0015", true).setDebugId(6437));
			actions.add(new com.avaya.sce.runtime.Next("ServiceManagement-Transfer", "Transfer").setDebugId(6438));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("CallData:transferReasonCode", "TR_0061", true).setDebugId(5904));
			actions.add(new com.avaya.sce.runtime.Next("ServiceManagement-PushSMS_ILDActivation", "Continue").setDebugId(2760));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
