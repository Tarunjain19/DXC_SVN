package flow.subflow.CollectSmartCard;

import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.otherflows.resource.IVRDBServiceInstance;
import com.rcom.rdtv.Constants;
import com.rcom.rdtv.StackTrace;
import com.rcom.rdtv.rcomdth02.model.ValidateSCNStatus;
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
 * Last generated by Orchestration Designer at: 2015-MAY-29  01:17:38 PM
 */
public class ValidateSCN extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	@Override
	public void requestBegin(SCESession mySession) {
		super.requestBegin(mySession);
		
		String strSCNNo = "";
		ValidateSCNStatus validateSCNStatus = null;
		IVRDataBean ivrDataBean = null;
		
		try{
			
			ivrDataBean = (IVRDataBean) mySession.getProperty(Constants.IVRDATABEAN);
			
			strSCNNo = mySession.getVariableField(IProjectVariables.GET_SMART_CARD_NUMBER__MN, IProjectVariables.GET_SMART_CARD_NUMBER__MN_FIELD_VALUE).getStringValue();
			validateSCNStatus = new ValidateSCNStatus();
			validateSCNStatus.setScnNo(strSCNNo);
			
			validateSCNStatus = IVRDBServiceInstance.getRcomdth02DataService().getSubscriberValidations(ivrDataBean, validateSCNStatus);
			
			if((validateSCNStatus.getStatus().equalsIgnoreCase(Constants.SUCCESS))){
				mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_VALID_SCN).setValue(Constants.Yes);
			}else{
				mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_VALID_SCN).setValue(Constants.No);
			}
			
		}catch (Exception e) {
			StackTrace.PrintException(e);
			mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_EXCEPTION).setValue(Constants.Yes);
		}
	}
	
	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-29  01:17:38 PM
	 */
	public ValidateSCN() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2016-MAY-12  05:47:13 PM
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
	 * Last generated by Orchestration Designer at: 2016-MAY-12  05:47:13 PM
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
	 * Last generated by Orchestration Designer at: 2016-MAY-12  05:47:13 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "appVariables:isException", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:yes", true).setDebugId(737)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferPoint", "TransferPoints:RD02_TR_0015", false).setDebugId(739));
			actions.add(new com.avaya.sce.runtime.Next("CollectSmartCard-LinkDown", "LinkDown").setDebugId(454));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "appVariables:isValidSCN", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:yes", true).setDebugId(749)).evaluate(mySession)) {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("SCN_Number:Number", "GetSmartCardNumber_MN:Value", false).setDebugId(1174));
				actions.add(new com.avaya.sce.runtime.Next("CollectSmartCard-ValidSCN", "Valid").setDebugId(742));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.varoperations.Increment("appVariables:SCNCount").setDebugId(751));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

				if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "appVariables:SCNCount", com.avaya.sce.runtime.Expression.INT_LESS_THAN, "Constants:three", true).setDebugId(752)).evaluate(mySession)) {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.Next("CollectSmartCard-Invalid_SCN_PP", "ReEnter").setDebugId(743));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;

				} else {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.Next("CollectSmartCard-ExceedTries_PP", "CountExceeded").setDebugId(754));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;
				}

			}

		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
	
	//commented by 
	/*@Override
	public void requestBegin(SCESession mySession) {
		ITraceInfo trace = mySession.getTraceOutput();
		ValidateSCNStatus validateSCNStatus = null;
		IVRDataService ivrDataService = null;
		try
		{
			*//** Request by SCN Number**//*
			validateSCNStatus = new ValidateSCNStatus();
			validateSCNStatus.setScnNo(mySession.getVariableField(IProjectVariables.SCN__NUMBER, IProjectVariables.SCN__NUMBER_FIELD_NUMBER).getStringValue());
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Validate SCN Number Request :: "+validateSCNStatus.toString());
			
			*//** Response **//*
			ivrDataService = new IVRDataServiceImpl();
			validateSCNStatus = ivrDataService.getSubscriberValidations((IVRDataBean) mySession.getProperty(Constants.IVRDATABEAN), validateSCNStatus);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Validate SCN Number Response :: "+validateSCNStatus.toString());
			
			if(validateSCNStatus !=null && validateSCNStatus.getStatus().equalsIgnoreCase(Constants.SUCCESS) && !validateSCNStatus.getErrorCode().equalsIgnoreCase(Constants.Zero))
			{
					mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_VALID_SCN).setValue(Constants.Yes);
					mySession.getVariableField(IProjectVariables.VALIDATE_SCN, IProjectVariables.VALIDATE_SCN_FIELD_FLAG).setValue(validateSCNStatus.getScnStatus());
					
			}
			else
				mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_EXCEPTION).setValue(Constants.Yes);

	}catch(Exception e)
	{mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_EXCEPTION).setValue(Constants.Yes);
	StackTrace.PrintException(e);
	}
	finally
	{trace=null;validateSCNStatus=null;ivrDataService=null;}
	}*/
}