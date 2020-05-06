package flow.subflow.PostpaidAccountInformation;

import java.util.ArrayList;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.servion.util.AppConstant;
import com.servion.util.AppProperties;
import com.servion.util.DynamicMenu;
import com.servion.util.StackTrace;

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
public class Initialize_PA_0026 extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	@Override
	public void requestBegin(SCESession mySession) {
		super.requestBegin(mySession);
		
		/*Declaring variables*/
		ITraceInfo info = null;
		String strInitialAudio = "";
		String strMode = "", strBillGenDate = "", strBillDeliveryDate = "", strBillDeliveryStatus = "";
		ArrayList<String> dynamicValueList = null;
		String strApplicationName = "";
		String key = "";
		try {
			/*Getting call data from session*/
			info = mySession.getTraceOutput();
			dynamicValueList = new ArrayList<String>();
			AppProperties audioPropertyInstance = null;
			audioPropertyInstance = AppProperties.GetInstance(AppConstant.DYN_MENU);
			strApplicationName = mySession.getVariableField(IProjectVariables.APP_NAME).getStringValue();
			strMode = mySession.getVariableField(IProjectVariables.BILL_DELIVERY_STATUS, IProjectVariables.BILL_DELIVERY_STATUS_FIELD_MODE).getStringValue();
			strBillGenDate = mySession.getVariableField(IProjectVariables.BILL_DELIVERY_STATUS, IProjectVariables.BILL_DELIVERY_STATUS_FIELD_BILL_GENERATION_DATE).getStringValue();
			strBillDeliveryDate = mySession.getVariableField(IProjectVariables.BILL_DELIVERY_STATUS, IProjectVariables.BILL_DELIVERY_STATUS_FIELD_BILL_DELIVERY_DATE).getStringValue();
			strBillDeliveryStatus = mySession.getVariableField(IProjectVariables.BILL_DELIVERY_STATUS, IProjectVariables.BILL_DELIVERY_STATUS_FIELD_BILL_DELIVERY_STATUS).getStringValue();
			
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->Delivery Date:"+strBillGenDate+",Delivery Status:"+strBillDeliveryStatus);
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->Bill Gen Date:"+strBillDeliveryDate+",Mode:"+strMode);
			
			dynamicValueList.add(strBillGenDate);
			
			key = strApplicationName +AppConstant.SEPERATOR_HYPEN+ AppConstant.PA_0028;
			info.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Key :: "+key);
			
			strInitialAudio = audioPropertyInstance.getIVRProp(key);
			strInitialAudio = DynamicMenu.playPrompt(dynamicValueList, strInitialAudio, null, AppConstant.PA_0028, info);
			
			mySession.getVariableField(IProjectVariables.DMPROPERTIES, IProjectVariables.DMPROPERTIES_FIELD_INITIAL_AUDIOS).setValue(strInitialAudio);
			
		} catch (Exception e) {
			StackTrace.PrintException(e);
			info.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "Exception:"+e.getMessage());
		}
	}
	
	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-APR-15  08:35:24 PM
	 */
	public Initialize_PA_0026() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-JUL-05  10:39:11 AM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("PostpaidAccountInformation-BillgenDate_PA_0026", "Default");
		next.setDebugId(2397);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2017-JUL-05  10:39:11 AM
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
	 * Last generated by Orchestration Designer at: 2017-JUL-05  10:39:11 AM
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