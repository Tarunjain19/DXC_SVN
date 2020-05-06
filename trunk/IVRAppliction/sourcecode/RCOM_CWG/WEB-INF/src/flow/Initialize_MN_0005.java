package flow;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.servion.postpaid.utils.Constants;
import com.servion.postpaid.utils.PrintStackTrace;
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
 * Last generated by Orchestration Designer at: 2015-APR-13  04:11:29 PM
 */
public class Initialize_MN_0005 extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	@Override
	public void requestBegin(SCESession mySession) {
		super.requestBegin(mySession);
		
		ITraceInfo info = mySession.getTraceOutput();
		String strInitialAudio = null;
		AppProperties audioConfigInstance = null;
		String strCurrentLanguage = "", strHNIFlag = "", strApplicationName = "", strProperty = "";
		
		IVRDataBean ivrDataBean = null;
		
		
		try {
			ivrDataBean = (IVRDataBean) mySession.getProperty(Constants.IVRDATABEAN);
			GetReportObject getReportObject = ivrDataBean.getGetReportObject();
			IVRREPORTDATA ivrreportdata = getReportObject.getIvrreportdata();
			CALLINFO callInfo = ivrreportdata.getCALLINFO();
			callInfo.setLANGUAGEFROM(mySession.getCurrentLanguage());
			ivrreportdata.setCALLINFO(callInfo);
			
			strApplicationName = mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_APPLICATION_NAME).getStringValue();
			strHNIFlag = mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_HNICALLER).getStringValue();
			info = mySession.getTraceOutput();
			audioConfigInstance = (AppProperties) mySession.getProperty(Constants.AudioPropertyInstance);
			
			if(strHNIFlag.equalsIgnoreCase(Constants.Yes)){
				strProperty = "MainMenu_MN_0005_HNI.properties";
			}else{
				strProperty = "MainMenu_MN_0005.properties";
			}
			
			mySession.getVariableField(IProjectVariables.DMPROPERTIES, IProjectVariables.DMPROPERTIES_FIELD_MAIN_MENU__MN___0_0_0_5).setValue(strProperty);
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Main Menu Property:"+strProperty);
			
		} catch (Exception e) {
			PrintStackTrace.PrintException(e);
			info.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "Exception:"+e.getMessage());
		}
		
	}
	
	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-APR-13  04:11:29 PM
	 */
	public Initialize_MN_0005() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2015-NOV-08  05:50:16 PM
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
	 * Last generated by Orchestration Designer at: 2015-NOV-08  05:50:16 PM
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
	 * Last generated by Orchestration Designer at: 2015-NOV-08  05:50:16 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(4);
		actions.add(new com.avaya.sce.runtime.varoperations.Increment("CallData:mainMenuCount").setDebugId(1129));
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "---> Main Menu Count :", "CallData:mainMenuCount").setDebugId(1127));
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "---> Allowed Main Menu Count :", "CallData:allowedMainMenuCount").setDebugId(1128));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "CallData:mainMenuCount", com.avaya.sce.runtime.Expression.INT_LESS_THAN_EQUAL, "CallData:allowedMainMenuCount", true).setDebugId(966)).evaluate(mySession)) {
			actions = new java.util.ArrayList(16);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("Flag:isFromIntelligentLayer", "Constants:no", false).setDebugId(1623));
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("Flag:isCallDateValid", "Constants:no", false).setDebugId(1624));
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("Flag:isCallerDunned", "Constants:no", false).setDebugId(1625));
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("Flag:isDNCDeregistrationDone", "Constants:no", false).setDebugId(1626));
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("Flag:isDNCRegistrationDone", "Constants:no", false).setDebugId(1627));
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("Flag:isFromEventBased", "Constants:no", false).setDebugId(1628));
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("Flag:isFromILDActivation", "Constants:no", false).setDebugId(1629));
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("Flag:isFromInteractionHistory", "Constants:no", false).setDebugId(1630));
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("Flag:isLinkDown", "Constants:no", false).setDebugId(1631));
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("Flag:isPTPSRPResent", "Constants:no", false).setDebugId(1632));
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("Flag:isSLADateValid", "Constants:no", false).setDebugId(1633));
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("Flag:isTotalExposureValid", "Constants:no", false).setDebugId(1634));
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("Flag:isValidNumber", "Constants:no", false).setDebugId(1635));
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("Flag:isVASSuccessful", "Constants:no", false).setDebugId(1636));
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("Flag:isVoiceOffer", "Constants:no", false).setDebugId(1637));
			actions.add(new com.avaya.sce.runtime.Next("MainMenu_MN_0005", "MainMenu").setDebugId(819));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("CallData:transferReasonCode", "Constants:TR_0006", false).setDebugId(1176));
			actions.add(new com.avaya.sce.runtime.Next("SetTransferData", "Transfer").setDebugId(968));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
