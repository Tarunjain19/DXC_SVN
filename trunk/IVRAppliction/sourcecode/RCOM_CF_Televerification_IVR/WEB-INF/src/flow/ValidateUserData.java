package flow;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.otherflows.model.ValidateDataCardNumber;
import com.rcom.otherflows.model.ValidateHandsetNumber;
import com.rcom.otherflows.resource.IVRDBServiceInstance;
import com.rcom.televerification.loadproperty.LoadProperty;
import com.rcom.televerification.utils.Constants;
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
 * Last generated by Orchestration Designer at: 2015-APR-02  02:57:49 PM
 */
public class ValidateUserData extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	@Override
	public void requestBegin(SCESession mySession) {
		super.requestBegin(mySession);
		
		ITraceInfo info = null;
		String strDataCardFlag = "";
		IVRDataBean ivrDataBean = null;
		ValidateDataCardNumber validateDataCardNumber = null;
		ValidateHandsetNumber validateHandsetNumber = null;
		String strInitialAudios = "";
		String strLanguages = "";
		String strDefaultLanguage = "";
		String strApplicationName = "";
		String strValidNumberFlag = "";
		
		/*Setting logger and session id */
		info = mySession.getTraceOutput();
		ivrDataBean = (IVRDataBean) mySession.getProperty(Constants.IVRDataBean);
		strDataCardFlag = mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_IS_DATA_CARD).getStringValue();
		strApplicationName = LoadProperty.getivrconfigProp(Constants.ApplicationName);
		if(strDataCardFlag.equalsIgnoreCase("Y")){
			
			/*Setting input parameter*/
			validateDataCardNumber = new ValidateDataCardNumber();
			validateDataCardNumber.setAppName(strApplicationName);
			validateDataCardNumber.setDataCardNumber(mySession.getVariableField(IProjectVariables.COLLECT_DATA_CARD__TELV__MN___0_0_0_2, IProjectVariables.COLLECT_DATA_CARD__TELV__MN___0_0_0_2_FIELD_VALUE).getStringValue());
			validateDataCardNumber.setDataType(LoadProperty.getivrconfigProp(Constants.DataType));
			
			info.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Application Name :"+strApplicationName);
			info.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Application Name :"+mySession.getVariableField(IProjectVariables.COLLECT_DATA_CARD__TELV__MN___0_0_0_2, IProjectVariables.COLLECT_DATA_CARD__TELV__MN___0_0_0_2_FIELD_VALUE).getStringValue());
			info.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Application Name :"+LoadProperty.getivrconfigProp(Constants.DataType));
			
			
			
			mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_VERIFY_MDN).setValue(mySession.getVariableField(IProjectVariables.COLLECT_DATA_CARD__TELV__MN___0_0_0_2, IProjectVariables.COLLECT_DATA_CARD__TELV__MN___0_0_0_2_FIELD_VALUE).getStringValue());
			/*Invoking DB*/
			validateDataCardNumber = IVRDBServiceInstance.getIVRDBInstance().checkDataCardNumberHardCoding(ivrDataBean, validateDataCardNumber);
			if(validateDataCardNumber.getFlag().equalsIgnoreCase(Constants.Success))
				strValidNumberFlag = "Y";
			else
				strValidNumberFlag = "N";
		}else{
			
			/*Setting input parameter*/
			validateHandsetNumber  = new ValidateHandsetNumber();
			validateHandsetNumber.setAppName(strApplicationName);
			validateHandsetNumber.setHandsetNumber(mySession.getVariableField(IProjectVariables.COLLECT_MOBILE_NUMBER__TELV__MN___0_0_0_4, IProjectVariables.COLLECT_MOBILE_NUMBER__TELV__MN___0_0_0_4_FIELD_VALUE).getStringValue());
			validateHandsetNumber.setDataType(LoadProperty.getivrconfigProp(Constants.DataType));
			
			mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_VERIFY_MDN).setValue(mySession.getVariableField(IProjectVariables.COLLECT_MOBILE_NUMBER__TELV__MN___0_0_0_4, IProjectVariables.COLLECT_MOBILE_NUMBER__TELV__MN___0_0_0_4_FIELD_VALUE).getStringValue());
			/*Invoking DB*/
			validateHandsetNumber = IVRDBServiceInstance.getIVRDBInstance().checkHandSetNumberHardCoding(ivrDataBean, validateHandsetNumber);
			if(validateHandsetNumber.getFlag().equalsIgnoreCase(Constants.Success))
				strValidNumberFlag = "Y";
			else
				strValidNumberFlag = "N";
		}
		
		info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "ValidNumbr Flag:"+strValidNumberFlag);
		info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Verify MDN -Caller Input:"+mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_VERIFY_MDN).getStringValue());
		mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_IS_VALID_NUMBER).setValue(strValidNumberFlag);
		
	}
	
	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-APR-02  02:57:49 PM
	 */
	public ValidateUserData() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2015-DEC-28  01:09:53 PM
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
	 * Last generated by Orchestration Designer at: 2015-DEC-28  01:09:53 PM
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
	 * Last generated by Orchestration Designer at: 2015-DEC-28  01:09:53 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "CallData:isLinkDown", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Y", false).setDebugId(1161)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("CallData:transferReasonCode", "TELV_TR_0002", true).setDebugId(1736));
			actions.add(new com.avaya.sce.runtime.Next("SetLinkDown", "LinkDown").setDebugId(1165));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "CallData:isValidNumber", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Y", false).setDebugId(1163)).evaluate(mySession)) {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("CallData:transferReasonCode", "TELV_TR_0001", true).setDebugId(1737));
				actions.add(new com.avaya.sce.runtime.Next("SetTransferData", "ValidNumber").setDebugId(1166));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("InitializeInvalidNumber", "InvalidNumber").setDebugId(1152));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}

		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
