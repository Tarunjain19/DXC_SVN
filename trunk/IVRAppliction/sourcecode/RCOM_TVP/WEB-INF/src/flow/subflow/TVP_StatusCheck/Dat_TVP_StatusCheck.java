package flow.subflow.TVP_StatusCheck;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.hp.utilities.IVRConstants;
import com.hp.utilities.TVP_Properties;
import com.hp.utilities.TVP_Utilities;

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
 * Last generated by Orchestration Designer at: 2015-OCT-27  11:30:54 AM
 */
public class Dat_TVP_StatusCheck extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-OCT-27  11:30:54 AM
	 */
	public Dat_TVP_StatusCheck() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-JUL-12  01:45:35 PM
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
	 * Last generated by Orchestration Designer at: 2017-JUL-12  01:45:35 PM
	 */
	public java.util.Collection<VariableInfo> getLocalVariables(){
		java.util.Collection<VariableInfo> variables = new java.util.ArrayList<VariableInfo>();

		return variables;
	}
	@Override
	public void requestBegin(SCESession mySession) {
		// TODO Auto-generated method stub
		super.requestBegin(mySession);
		TVP_Properties tvpProp = null;
		ITraceInfo itraceinfo  = null;
		TVP_Utilities tvpUti   = null;
		String tvp_Status 	   = IVRConstants.EMPTY_QUOTES;
		String product_Type	   = IVRConstants.EMPTY_QUOTES;
		itraceinfo             = mySession.getTraceOutput();
		try
		{
		
			tvpUti =new TVP_Utilities();
			
			tvpProp=TVP_Properties.getInstance(mySession.getVariableField(IProjectVariables.VAR__CONFIG, IProjectVariables.VAR__CONFIG_FIELD_CONFIG_FILE_PATH).getStringValue(),mySession);
			tvp_Status = mySession.getVariableField(IProjectVariables.TIBCO__VALIDATION__RES,IProjectVariables.TIBCO__VALIDATION__RES_FIELD_TVP_STATUS).getStringValue();
			product_Type = mySession.getVariableField(IProjectVariables.TIBCO__VALIDATION__RES,IProjectVariables.TIBCO__VALIDATION__RES_FIELD_PRODUCT_TYPE).getStringValue().toLowerCase();
			itraceinfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"# TVP Status ::"+ tvp_Status);
			itraceinfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"# Value key Status::"+ tvpProp.getProperty(mySession,tvp_Status));
			//mySession.getVariableField(IProjectVariables.VAR__CONFIG,IProjectVariables.VAR__CONFIG_FIELD_WORKING_HOURS).setValue(tvpProp.getProperty(mySession, IVRConstants.WORKING_HOURS));
			String workHours=tvpProp.getProperty(mySession, IVRConstants.WORKING_HOURS).trim();
		if(tvpProp.getProperty(mySession,tvp_Status).trim()!=null)
		{	
				if((tvpProp.getProperty(mySession,tvp_Status).trim()).equalsIgnoreCase(IVRConstants.DEDUPE_TIMECHECK))
				{
					mySession.getVariableField(IProjectVariables.TVP__VARS,IProjectVariables.TVP__VARS_FIELD_DEDUPE__TIMECHECK).setValue(true);
					itraceinfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"# Value key Status in dedupetimecheck::"+ tvpProp.getProperty(mySession,tvp_Status));
					
					if(tvpUti.isWorkingHours(mySession, workHours))
						mySession.getVariableField(IProjectVariables.TVP__VARS,IProjectVariables.TVP__VARS_FIELD_WORKING__TIME).setValue(true);
							   
				
				
				}
				
			else if ((tvpProp.getProperty(mySession, tvp_Status).trim()).equalsIgnoreCase(IVRConstants.DEDUPE_NEGATIVE))
				mySession.getVariableField(IProjectVariables.TVP__VARS,IProjectVariables.TVP__VARS_FIELD_DEDUPE__NEGATIVE).setValue(true);
			
			else if ((tvpProp.getProperty(mySession, tvp_Status).trim()).equalsIgnoreCase(IVRConstants.TV_POSITIVE))
				mySession.getVariableField(IProjectVariables.TVP__VARS,IProjectVariables.TVP__VARS_FIELD_TV__POSITIVE).setValue(true);
			else if ((tvpProp.getProperty(mySession, tvp_Status).trim()).equalsIgnoreCase(IVRConstants.TIBCO_ANNOUNCE_MNPPENDING))
				mySession.getVariableField(IProjectVariables.TVP__VARS,IProjectVariables.TVP__VARS_FIELD_TIBCO__ANNOUNCE__MNPPENDING).setValue(true);
			else if ((tvpProp.getProperty(mySession, tvp_Status).trim()).equalsIgnoreCase(IVRConstants.TIBCO_ANNOUNCE_PENDING))
				mySession.getVariableField(IProjectVariables.TVP__VARS,IProjectVariables.TVP__VARS_FIELD_TIBCO__ANNOUNCE__PENDING).setValue(true);
			else if ((tvpProp.getProperty(mySession, tvp_Status).trim()).equalsIgnoreCase(IVRConstants.TIBCO_ANNOUNCE_TVFAILED))
				mySession.getVariableField(IProjectVariables.TVP__VARS,IProjectVariables.TVP__VARS_FIELD_TIBCO__ANNOUNCE__TVFAILED).setValue(true);
			else if ((tvpProp.getProperty(mySession, tvp_Status).trim()).equalsIgnoreCase(IVRConstants.ANNOUNCE_TVFailed))
				mySession.getVariableField(IProjectVariables.TVP__VARS,IProjectVariables.TVP__VARS_FIELD_ANNOUNCE__TVFAILED).setValue(true);
			else if ((tvpProp.getProperty(mySession, tvp_Status).trim()).equalsIgnoreCase(IVRConstants.TIBCO_ANNOUNCE_TVPOSTED))
				mySession.getVariableField(IProjectVariables.TVP__VARS,IProjectVariables.TVP__VARS_FIELD_TIBCO__ANNOUNCE__TVPOSTED).setValue(true);
			
		/*	else if ((tvpProp.getProperty(mySession, tvp_Status)).equalsIgnoreCase(IVRConstants.TV_NEGATIVE))
				mySession.getVariableField(IProjectVariables.TVP__VARS,IProjectVariables.TVP__VARS_FIELD_TVP__PROCESS).setValue(true);*/
			else if ((tvpProp.getProperty(mySession, tvp_Status).trim()).equalsIgnoreCase(IVRConstants.TVP_PROCESS)){
				
				mySession.getVariableField(IProjectVariables.TVP__VARS,IProjectVariables.TVP__VARS_FIELD_TVP__PROCESS).setValue(true);
			/*E-KYC check */
				if(mySession.getVariableField(IProjectVariables.TIBCO__VALIDATION__RES,IProjectVariables.TIBCO__VALIDATION__RES_FIELD_E__KYC).getStringValue().
						equalsIgnoreCase(IVRConstants.Y)&&! mySession.getVariableField(IProjectVariables.CALL_INFO,IProjectVariables.CALL_INFO_FIELD_IS_DONGLE).equals(IVRConstants.TRUE)&&!product_Type.contains("data"))
						mySession.getVariableField(IProjectVariables.TVP__VARS,IProjectVariables.TVP__VARS_FIELD_IS_EKYC).setValue(IVRConstants.Y);
			}
			else
				mySession.getVariableField(IProjectVariables.TVP__VARS,IProjectVariables.TVP__VARS_FIELD_TV__TRANSFER).setValue(true);
				
		}
	
		else
		{
			
			mySession.getVariableField(IProjectVariables.TVP__VARS,IProjectVariables.TVP__VARS_FIELD_NO__DATA).setValue(true);
			itraceinfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"TVP Status NOT FOUND.Call will be transfferred");
		}
		mySession.getVariableField(IProjectVariables.TVP__VARS, IProjectVariables.TVP__VARS_FIELD_JAVA__ERROR).setValue(false);
		itraceinfo.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "# Dat_TVP_StatusCheck.java Java_Error is set to: false" );
		
	}
		catch(Exception e)
		
		{
			
			mySession.getVariableField(IProjectVariables.TVP__VARS, IProjectVariables.TVP__VARS_FIELD_JAVA__ERROR).setValue(true);
			itraceinfo.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "# Dat_TVP_StatusCheck.java Java_Error is set to:true " + e );
			itraceinfo.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "# ERROR: Exception - Dat_TVP_StatusCheck.java:- " + e);
		}
		
		
		
		
		

		
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
	 * Last generated by Orchestration Designer at: 2017-JUL-12  01:45:35 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		com.avaya.sce.runtime.BooleanOperation bo1 = new com.avaya.sce.runtime.BooleanOperation(com.avaya.sce.runtime.BooleanOperation.AND);
		com.avaya.sce.runtime.Expression be1 = new com.avaya.sce.runtime.Expression("expression1", "CallInfo:isDongle", com.avaya.sce.runtime.Expression.IS_TRUE);
		bo1.addExpression(be1);
		com.avaya.sce.runtime.Expression be2 = new com.avaya.sce.runtime.Expression("expression2", "TIBCO_Validation_Res:serviceType", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "CONSTANTS:POSTPAID", true);
		bo1.addExpression(be2);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "TVP_VARs:Java_Error", com.avaya.sce.runtime.Expression.IS_TRUE).setDebugId(187)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("TVP_StatusCheck-Ret_Xfer", "XferError").setDebugId(188));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		}


		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "TVP_VARs:NO_DATA", com.avaya.sce.runtime.Expression.IS_TRUE).setDebugId(191)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("TVP_VARs:NO_DATA", "false", true).setDebugId(193));
			actions.add(new com.avaya.sce.runtime.Next("TVP_StatusCheck-Ret_Xfer", "XferNodata").setDebugId(192));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		}


		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "TVP_VARs:isEKYC", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "CONSTANTS:YES", true).setDebugId(243)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("TVP_StatusCheck-Ret_TVP_Flag", "E_KYC").setDebugId(244));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		}

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition").setDebugId(216)).evaluate(mySession, bo1)) {
			actions = new java.util.ArrayList(1);
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition4", "TVP_VARs:TV_POSITIVE", com.avaya.sce.runtime.Expression.IS_TRUE).setDebugId(226)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("TVP_StatusCheck-Dat_checkCallTime", "TVPPositive-Post").setDebugId(173));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("TVP_StatusCheck-Ret_Xfer", "NoStatus-Postpaid").setDebugId(174));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


		} else {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition5", "TVP_VARs:DEDUPE_TIMECHECK", com.avaya.sce.runtime.Expression.IS_TRUE).setDebugId(14)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("TVP_StatusCheck-checkWorkTime", "checkTime").setDebugId(15));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition6", "TVP_VARs:DEDUPE_NEGATIVE", com.avaya.sce.runtime.Expression.IS_TRUE).setDebugId(16)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("TVP_StatusCheck-Ann_SubmitDoc", "tvp_d_neg").setDebugId(17));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition7", "TVP_VARs:TIBCO_ANNOUNCE_PENDING", com.avaya.sce.runtime.Expression.IS_TRUE).setDebugId(86)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("TVP_StatusCheck-Ann_TibcoPending", "Tibco_AnnPending").setDebugId(87));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition8", "TVP_VARs:TIBCO_ANNOUNCE_TVPOSTED", com.avaya.sce.runtime.Expression.IS_TRUE).setDebugId(88)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("TVP_StatusCheck-Ann_TibcoTVPosted", "Tibco_AnnTVPosted").setDebugId(89));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition9", "TVP_VARs:TIBCO_ANNOUNCE_TVFAILED", com.avaya.sce.runtime.Expression.IS_TRUE).setDebugId(90)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("TVP_StatusCheck-Ann_TibcoTVFailed", "Tibco_AnnTVFailed").setDebugId(91));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition10", "TVP_VARs:TIBCO_ANNOUNCE_MNPPENDING", com.avaya.sce.runtime.Expression.IS_TRUE).setDebugId(92)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("TVP_StatusCheck-Ann_TibcoMNPPending", "Tibco_AnnMNPPending").setDebugId(93));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition11", "TVP_VARs:ANNOUNCE_TVFailed", com.avaya.sce.runtime.Expression.IS_TRUE).setDebugId(96)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("TVP_StatusCheck-Ann_TVFailed", "Ann_TVFailed").setDebugId(97));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition12", "TVP_VARs:TV_POSITIVE", com.avaya.sce.runtime.Expression.IS_TRUE).setDebugId(129)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("TVP_StatusCheck-Dat_checkCallTime", "TVPPositive").setDebugId(130));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition13", "TVP_VARs:TVP_PROCESS", com.avaya.sce.runtime.Expression.IS_TRUE).setDebugId(121)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("TVP_StatusCheck-Ret_TVP_Flag", "tvp_Negative").setDebugId(25));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("TVP_StatusCheck-Ret_Xfer", "NoStatus").setDebugId(27));
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