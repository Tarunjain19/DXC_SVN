package flow.subflow.DTH_Service_Partner;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.otherflows.model.RetailerValidation;
import com.rcom.otherflows.resource.IVRDBServiceInstance;
import com.rcom.rdtv.util.AppConstants;
import com.rcom.rdtv.util.StackTrace;
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
 * Last generated by Orchestration Designer at: 2015-MAY-27  04:49:37 PM
 */
public class MDN_Validation_For_Retail extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-27  04:49:37 PM
	 */
	public MDN_Validation_For_Retail() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:46:00 PM
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
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:46:00 PM
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
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:46:00 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "AppVariables:IsHostFailure", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "CONSTANTS:YES", true).setDebugId(288)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("AppVariables:TransferPoint", "TransferPoints:RD01_TR_0037", false).setDebugId(289));
			actions.add(new com.avaya.sce.runtime.Next("DTH_Service_Partner-link_down", "linkdown").setDebugId(290));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "AppVariables:IsValidMDN", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "CONSTANTS:YES", true).setDebugId(9)).evaluate(mySession)) {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("AppVariables:IsSCNInvokedFromServicePartner", "CONSTANTS:YES", false).setDebugId(287));
				actions.add(new com.avaya.sce.runtime.Next("DTH_Service_Partner-ValidMDN_Annc", "valid").setDebugId(10));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("DTH_Service_Partner-NonAuthorized_RetailerAnnc", "not-valid").setDebugId(12));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}

		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
	
	@Override
	public void requestBegin(SCESession mySession) {
		ITraceInfo trace = mySession.getTraceOutput();
		RetailerValidation retailerValidation = null;
		try
		{
			/** Formating the Request **/
			retailerValidation = new RetailerValidation();
			retailerValidation.setMdn(mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_ANI).getStringValue());
			retailerValidation.setCircle(mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_CIRCLE_ID).getStringValue());
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "MDN Valiation For Retailer And ISP Request :: "+retailerValidation.toString());
			
			/** Getting Response By Host Processing **/
			retailerValidation = IVRDBServiceInstance.getIVRDBInstance().getRetailerValidation((IVRDataBean) mySession.getProperty(AppConstants.IVRDATABEAN), retailerValidation);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "MDN Valiation For Retailer And ISP Response :: "+retailerValidation.toString());
			if(retailerValidation != null && retailerValidation.getErrorCode().equalsIgnoreCase(AppConstants.zero))
			{
				if(retailerValidation.getFlag().equalsIgnoreCase(AppConstants.TRUE))
					mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_VALID_MDN).setValue(AppConstants.Yes);
				else
					mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_VALID_MDN).setValue(AppConstants.No);
			}
			else
				mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_HOST_FAILURE).setValue(AppConstants.Yes);
			
		}catch(Exception e)
		{mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_HOST_FAILURE).setValue(AppConstants.Yes);
		StackTrace.PrintException(e);
		}
		finally
		{trace=null;retailerValidation=null;}
	}
}
