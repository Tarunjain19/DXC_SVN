package flow.subflow.AccountInformation;

import java.util.ArrayList;
import java.util.Hashtable;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.servion.rcom.hni.hostinterface.view.FreeUnitDetails;
import com.servion.rcom.hni.hostinterface.view.ReqFreeUnitInfo;
import com.servion.rcom.hni.hostinterface.view.ResFreeUnitInfo;
import com.servion.rcom.hni.hostinterface.wrapper.IVRWebService;
import com.servion.rcom.hni.hostinterface.wrapper.IVRWebServiceImpl;
import com.servion.triplefive.utils.Constants;
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
 * Last generated by Orchestration Designer at: 2015-APR-16  12:35:35 PM
 */
public class AccessHost_FreeUnitInfo extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS
	
	@Override
	public void requestBegin(SCESession mySession) {
		super.requestBegin(mySession);
		
		ITraceInfo info = mySession.getTraceOutput();
		
		IVRDataBean ivrDataBean = null;
		ReqFreeUnitInfo reqFreeUnitInfo = null;
		ResFreeUnitInfo resFreeUnitInfo = null;
		IVRWebService ivrWebService = null;
		ArrayList<FreeUnitDetails> arrayFreeUnitDetails = null;
		FreeUnitDetails freeUnitDetails = null;
		SetPushSMS setPushSMS = null;
		String strSMSFrame = "";
		ArrayList<String> arrSMSData = null;
		Hashtable<String, String> smsHashTable = null;
		AppProperties appProperties = null;
		Hashtable<String, Hashtable<String, String>> smsHashTableDataIndexMap = null;
		
		try {
			
			setPushSMS = new SetPushSMS();
			smsHashTableDataIndexMap = new Hashtable<String, Hashtable<String,String>>();
			
			ivrDataBean = (IVRDataBean) mySession.getProperty(Constants.IVRDATABEAN);
			reqFreeUnitInfo = new ReqFreeUnitInfo();
			reqFreeUnitInfo.setMDN(mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_MDN).getStringValue());
			appProperties = (AppProperties) mySession.getProperty(Constants.IvrPropertyInstance);

			ivrWebService = new IVRWebServiceImpl();
			resFreeUnitInfo = ivrWebService.executeFreeUnitInfo(ivrDataBean, reqFreeUnitInfo);
			
			mySession.getVariableField(IProjectVariables.FREE_UNIT_INFO, IProjectVariables.UNBILLED_INFO_FIELD_RESPONSE_CODE).setValue(resFreeUnitInfo.getResponseCode());
			if((resFreeUnitInfo.getResponseCode()).equals(Constants.zero)){
				arrayFreeUnitDetails = resFreeUnitInfo.getFreeUnitDetailsList();
				strSMSFrame = appProperties.getIVRProp(Constants.FREE_UNIT_Success);
				for (int i = 0; i < arrayFreeUnitDetails.size(); i++) {
					arrSMSData = new ArrayList<String>();
					arrSMSData.add(resFreeUnitInfo.getFreeUnitDetailsList().get(i).getFRU_Category());
					arrSMSData.add(resFreeUnitInfo.getFreeUnitDetailsList().get(i).getFRU_AllocatedUnits());
					arrSMSData.add(resFreeUnitInfo.getFreeUnitDetailsList().get(i).getFRU_ConsumedUnits());
					arrSMSData.add(resFreeUnitInfo.getFreeUnitDetailsList().get(i).getFRU_RemainingUnits());
					arrSMSData.add(resFreeUnitInfo.getFreeUnitDetailsList().get(i).getFRU_PeriodEndDate());
					smsHashTable = setPushSMS.generatePushSMSDataMap(strSMSFrame, arrSMSData);
					smsHashTableDataIndexMap.put(""+i, smsHashTable);
				}
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Free Unit details SMS Data Index Map: "+smsHashTableDataIndexMap.toString());
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Free Unit details: "+arrayFreeUnitDetails.toString());
				mySession.setProperty(Constants.SMSDataIndexMap, smsHashTableDataIndexMap);
				
			}else{
				
				strSMSFrame = appProperties.getIVRProp(Constants.FREE_UNIT_Failure);
				smsHashTable = setPushSMS.generatePushSMSDataMap(strSMSFrame, arrSMSData);
				mySession.setProperty(Constants.SMSDataMap, smsHashTable);
				
				mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.Yes);
			}
			
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Free Unit SMS Map: "+smsHashTable.toString());
			

		} catch (Exception e) {
			strSMSFrame = appProperties.getIVRProp(Constants.FREE_UNIT_Failure);
			smsHashTable = setPushSMS.generatePushSMSDataMap(strSMSFrame, arrSMSData);
			mySession.setProperty(Constants.SMSDataMap, smsHashTable);
			PrintStackTrace.PrintException(e);
			mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.Yes);
		}
	}

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-APR-16  12:35:35 PM
	 */
	public AccessHost_FreeUnitInfo() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:08:04 PM
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
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:08:04 PM
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
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:08:04 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(3);
		actions.add(new com.avaya.sce.runtime.varoperations.Assign("CallData:globalMenuType", "Constants:FeatureLevel", false).setDebugId(4384));
		actions.add(new com.avaya.sce.runtime.varoperations.Assign("CallData:repeatTries", "0", true).setDebugId(5300));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "Flag:isLinkDown", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:yes", true).setDebugId(844)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("CallData:transferReasonCode", "Constants:TR_0040", false).setDebugId(4747));
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("Flag:isLinkDown", "Constants:no", false).setDebugId(5853));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "Flag:isFromInteractionHistory", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:yes", true).setDebugId(845)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("AccountInformation-MainMenu", "LinkDown_MainMenu").setDebugId(846));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("AccountInformation-PushSMSFreeUnitInfoLinkDown", "LinkDown_PushSMS").setDebugId(848));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


		} else {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("CallData:transferReasonCode", "Constants:TR_0041", false).setDebugId(4748));
			actions.add(new com.avaya.sce.runtime.Next("AccountInformation-FreeUnitInfo_PA_0016", "Continue").setDebugId(850));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
