package flow;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.broadband.Constants;
import com.rcom.broadband.LuhnAlgoImpl;


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
 * Last generated by Orchestration Designer at: 2015-MAY-23  06:19:01 PM
 */
public class ValidateCardNo extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-23  06:19:01 PM
	 */
	public ValidateCardNo() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	
	@Override
	public void requestBegin(SCESession mySession) {
		// TODO Auto-generated method stub
		super.requestBegin(mySession);
		
		String returnValue = Constants.EMPTY,returnCode = Constants.EMPTY;
		long creditcardNumber;
		ITraceInfo trace = mySession.getTraceOutput();
		Boolean isValidCard;
		
		returnValue = mySession.getVariableField(IProjectVariables.GET_CREDIT_CARD_NO__PC,IProjectVariables.GET_CREDIT_CARD_NO__PC_FIELD_VALUE).getStringValue();
		returnCode = mySession.getVariableField(IProjectVariables.GET_CREDIT_CARD_NO__PC,IProjectVariables.GET_CREDIT_CARD_NO__PC_FIELD_RETURN_CODE).getStringValue();
		//trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Return Code :"+returnCode);
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"/**Validating Credit Card**/");

		if(Constants.SUCCESS.equalsIgnoreCase(returnCode)){
			LuhnAlgoImpl objLuhnAlgoImpl = new LuhnAlgoImpl();
			creditcardNumber = Long.parseLong(returnValue);
			isValidCard=objLuhnAlgoImpl.isValid(creditcardNumber);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Credit card status :"+isValidCard);
				
			if(isValidCard){
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Valide credit Card");
			}else{
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"In Valid credit Card");
				mySession.getVariableField(IProjectVariables.GET_CREDIT_CARD_NO__PC,IProjectVariables.GET_CREDIT_CARD_NO__PC_FIELD_RETURN_CODE).setValue("NOMATCH");
			}
		}
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2016-SEP-28  04:13:57 PM
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
	 * Last generated by Orchestration Designer at: 2016-SEP-28  04:13:57 PM
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
	 * Last generated by Orchestration Designer at: 2016-SEP-28  04:13:57 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "GetCreditCardNo_PC:ReturnCode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constants:success", true).setDebugId(3824)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:monthCount", "0", true).setDebugId(11722));
			actions.add(new com.avaya.sce.runtime.Next("GetExpiryDate_PC", "(Valid digits)").setDebugId(3827));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.varoperations.Increment("appVariables:cardCount").setDebugId(11744));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "appVariables:cardCount", com.avaya.sce.runtime.Expression.INT_LESS_THAN, "3", false).setDebugId(11745)).evaluate(mySession)) {

				if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "GetCreditCardNo_PC:ReturnCode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "NOMATCH", false).setDebugId(11746)).evaluate(mySession)) {

					if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition4", "appVariables:cardCount", com.avaya.sce.runtime.Expression.INT_EQUAL, "1", false).setDebugId(11747)).evaluate(mySession)) {
						actions = new java.util.ArrayList(1);
						actions.add(new com.avaya.sce.runtime.varoperations.Assign("DM_input:DM_propertyFileName", "DM_propertyFileName:STD_InvalidTry1_PP", false).setDebugId(11748));
						if(evaluateActions(actions, mySession)) {
							return true;
						}
						actions = null;

					} else {
						actions = new java.util.ArrayList(1);
						actions.add(new com.avaya.sce.runtime.varoperations.Assign("DM_input:DM_propertyFileName", "DM_propertyFileName:STD_InvalidTry2_PP", false).setDebugId(11750));
						if(evaluateActions(actions, mySession)) {
							return true;
						}
						actions = null;
					}


				} else {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.varoperations.Assign("DM_input:DM_propertyFileName", "DM_propertyFileName:STD_NoInput_PP", false).setDebugId(11752));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;
				}


				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("InvalidCard_PP", "(Invalid Card No)").setDebugId(11753));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(3);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("DM_input:DM_propertyFileName", "DM_propertyFileName:STD_ExceededTries_PP", false).setDebugId(11755));
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "TransferCodes:DAKC_TR_0041", false).setDebugId(3826));
				actions.add(new com.avaya.sce.runtime.Next("TriesExceeded_PP", "(Exceeded Tries)").setDebugId(11756));
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
