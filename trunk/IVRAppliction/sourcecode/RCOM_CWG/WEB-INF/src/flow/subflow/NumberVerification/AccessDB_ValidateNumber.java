package flow.subflow.NumberVerification;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.postpaid.model.ValidateMobileNumber;
import com.rcom.postpaid.resource.IVRDBServiceInstance;
import com.servion.postpaid.utils.Constants;
import com.servion.postpaid.utils.PrintStackTrace;
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
 * Last generated by Orchestration Designer at: 2015-MAY-08  04:13:44 PM
 */
public class AccessDB_ValidateNumber extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS
	
	@Override
	public void requestBegin(SCESession mySession) {
		super.requestBegin(mySession);
		
		ITraceInfo info = mySession.getTraceOutput();
		
		IVRDataBean ivrDataBean = null;
		ValidateMobileNumber validateMobileNumber = null;
		String strMDN = "", strValidationFlag = "", strServiceType = "", strOtherNumber = "";
		
		
		try {
			
			ivrDataBean = (IVRDataBean) mySession.getProperty(Constants.IVRDATABEAN);
			/*strOtherNumber = mySession.getVariableField(IProjectVariables.OTHER_NUMBER__MN___0_0_3_0, IProjectVariables.OTHER_NUMBER__MN___0_0_3_0_FIELD_VALUE).getStringValue();
			if(strOtherNumber!=null)
				strMDN = strOtherNumber;
			else*/
			strMDN = mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_NUMBER_VERIFICATION_MDN).getStringValue();
			
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "MDN for validation :"+strMDN);
			validateMobileNumber = new ValidateMobileNumber();
			validateMobileNumber.setMdn(strMDN);
			validateMobileNumber = IVRDBServiceInstance.getInstance().validateMDN(ivrDataBean, validateMobileNumber);
			
			if(validateMobileNumber.getValidationFlag()!=null){
				strValidationFlag = validateMobileNumber.getValidationFlag();
				
				if(strValidationFlag.equalsIgnoreCase(Constants.Success)){
					if(validateMobileNumber.getServiceType()!=null){
						
						strServiceType = validateMobileNumber.getServiceType();
						info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "---> Number Type:"+strServiceType);
						if(((strServiceType).contains(Constants.POSTPAID))||((strServiceType).contains(Constants.small_POSTPAID))||((strServiceType).contains("POST"))||((strServiceType).contains("post")))
							mySession.getVariableField(IProjectVariables.VALIDATE_OTHER_NUMBER, IProjectVariables.VALIDATE_OTHER_NUMBER_FIELD_NUMBER_TYPE).setValue(Constants.POSTPAID);
						
						if(((validateMobileNumber.getServiceType()).contains(Constants.PREPAID))||((validateMobileNumber.getServiceType()).contains(Constants.small_PREPAID)))
							mySession.getVariableField(IProjectVariables.VALIDATE_OTHER_NUMBER, IProjectVariables.VALIDATE_OTHER_NUMBER_FIELD_NUMBER_TYPE).setValue(Constants.PREPAID);
						
					}
					
				}else{
					mySession.getVariableField(IProjectVariables.VALIDATE_OTHER_NUMBER, IProjectVariables.VALIDATE_OTHER_NUMBER_FIELD_NUMBER_TYPE).setValue("invalid");
				}
			}
			
		} catch (Exception e) {
			PrintStackTrace.PrintException(e);
			mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.Yes);
		}
		
	}

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-08  04:13:44 PM
	 */
	public AccessDB_ValidateNumber() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2015-NOV-08  05:50:20 PM
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
	 * Last generated by Orchestration Designer at: 2015-NOV-08  05:50:20 PM
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
	 * Last generated by Orchestration Designer at: 2015-NOV-08  05:50:20 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(2);
		actions.add(new com.avaya.sce.runtime.varoperations.Increment("CallData:numberVerificationCount").setDebugId(838));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "Flag:isLinkDown", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:yes", true).setDebugId(688)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("CallData:transferReasonCode", "Constants:TR_0130", false).setDebugId(1058));
			actions.add(new com.avaya.sce.runtime.Next("NumberVerification-ChkIntelligentLayer", "LinkDown").setDebugId(686));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("NumberVerification-CheckPrepaidPostPaidFlag", "Continue").setDebugId(692));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
