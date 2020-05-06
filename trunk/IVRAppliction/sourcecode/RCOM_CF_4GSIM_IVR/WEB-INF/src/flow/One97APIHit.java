package flow;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.Data.utils.Constants;
import com.rcom.Data.utils.StackTrace;
import com.servion.rcom.CDMA.hostinterface.view.ReqCdmaLtaAct;
import com.servion.rcom.CDMA.hostinterface.view.ResCdmaLta;
import com.servion.rcom.CDMA.hostinterface.wrapper.IVRWebService;
import com.servion.rcom.CDMA.hostinterface.wrapper.IVRWebServiceImpl;
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
 * Last generated by Orchestration Designer at: 2016-APR-12  12:58:57 PM
 */
public class One97APIHit extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2016-APR-12  12:58:57 PM
	 */
	public One97APIHit() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	@Override
	public void requestBegin(SCESession mySession) {
		super.requestBegin(mySession);
		
		ITraceInfo trace = mySession.getTraceOutput();
		String sessionId = null,hostResponse= Constants.ERROR;
		String mdn = null;
		String action = null;
		String SIM_Number = null;
		String circle_id = null;
		
		//Host Interaction Objects.....
		ReqCdmaLtaAct reqCDMA = null;
		ResCdmaLta resCDMA = null;
		IVRWebService ivrWebService = null;
		IVRDataBean objIVRDataBean = null;
		
		try
		{
			//Request Processing ......
			mdn =  mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_ANI).getStringValue();
			sessionId = mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_SESSIONID).getStringValue();
			SIM_Number = mySession.getVariableField(IProjectVariables.ENTER_SIMNUMBER, IProjectVariables.ENTER_SIMNUMBER_FIELD_VALUE).getStringValue();
			
			mySession.getVariableField(IProjectVariables.APP__VARIABLES, IProjectVariables.APP__VARIABLES_FIELD_SIM__NUMBER).setValue(SIM_Number);
			circle_id = mySession.getVariableField(IProjectVariables.CIRCLE__ID).getStringValue();
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "mdn is :: "+mdn);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "SIM_Number is :: "+SIM_Number);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "circle_id is :: "+circle_id);
			//trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "OpType is :: "+action);
			
			objIVRDataBean = (IVRDataBean)mySession.getProperty(Constants.IVRDataBean);
			reqCDMA = new ReqCdmaLtaAct();
			reqCDMA.setRequestId(sessionId);
			reqCDMA.setRequestSource("IVR");
			reqCDMA.setRequestType("4GMIG");
			reqCDMA.setService_ID(mdn);
			reqCDMA.setValue(SIM_Number);

			
			/*reqCDMA.setMDN(mdn);
			reqCDMA.setREQUESTTYPE("DATA");
			reqCDMA.setREQopType(action);
			reqCDMA.setSOURCE("IVR");
			reqCDMA.setRequestId(sessionId);
			reqCDMA.setLangId("0");*/

			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Main Host request :: "+reqCDMA.toString());
			
			//Response Processing ......
			ivrWebService = new IVRWebServiceImpl();
			resCDMA = ivrWebService.executeCDMALTARequest(objIVRDataBean, reqCDMA);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "resCDMA host request :: "+resCDMA.toString());
			//moving to complex variable
			if(resCDMA != null){
				
				String res=resCDMA.getResponseCode();
				
				System.out.println("res is: "+res);
				
				if(res.equalsIgnoreCase("0")) {
					 mySession.getVariableField(IProjectVariables.APP__VARIABLES, IProjectVariables.APP__VARIABLES_FIELD_WEB_RESPONCE).setValue("SUCCESS");
					String Error_Code=resCDMA.getERROR_CODE();
					
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Error_Code is:: "+Error_Code);
					mySession.getVariableField(IProjectVariables.APP__VARIABLES, IProjectVariables.APP__VARIABLES_FIELD_ERROR__RESPONSE).setValue(Error_Code);
					
					if(Error_Code.equalsIgnoreCase("0")) {
						 mySession.getVariableField(IProjectVariables.APP__VARIABLES, IProjectVariables.APP__VARIABLES_FIELD_ERROR__CODE).setValue("SUCCESS");
					} else if(Error_Code.equalsIgnoreCase("1")){
						mySession.getVariableField(IProjectVariables.APP__VARIABLES, IProjectVariables.APP__VARIABLES_FIELD_ERROR__CODE).setValue("INVALID_SIM");
					} else if(Error_Code.equalsIgnoreCase("2")){
						mySession.getVariableField(IProjectVariables.APP__VARIABLES, IProjectVariables.APP__VARIABLES_FIELD_ERROR__CODE).setValue("ALREADY_MAPPED");
					} else if(Error_Code.equalsIgnoreCase("3")){
						mySession.getVariableField(IProjectVariables.APP__VARIABLES, IProjectVariables.APP__VARIABLES_FIELD_ERROR__CODE).setValue("RECH_NOT_DONE");
						if (circle_id.equalsIgnoreCase("AP")){
							mySession.getVariableField(IProjectVariables.DMPROPERTY, IProjectVariables.DMPROPERTY_FIELD_INITIAL_PROMPT).setValue("129930.wav");
						} else if(circle_id.equalsIgnoreCase("MH")){
							mySession.getVariableField(IProjectVariables.DMPROPERTY, IProjectVariables.DMPROPERTY_FIELD_INITIAL_PROMPT).setValue("129931.wav");
						} else if(circle_id.equalsIgnoreCase("UPE")){
							mySession.getVariableField(IProjectVariables.DMPROPERTY, IProjectVariables.DMPROPERTY_FIELD_INITIAL_PROMPT).setValue("129932.wav");
						} else if(circle_id.equalsIgnoreCase("UPW")){
							mySession.getVariableField(IProjectVariables.DMPROPERTY, IProjectVariables.DMPROPERTY_FIELD_INITIAL_PROMPT).setValue("129933.wav");
						} else if(circle_id.equalsIgnoreCase("MP")){
							mySession.getVariableField(IProjectVariables.DMPROPERTY, IProjectVariables.DMPROPERTY_FIELD_INITIAL_PROMPT).setValue("129934.wav");
						} else if(circle_id.equalsIgnoreCase("MU")){
							mySession.getVariableField(IProjectVariables.DMPROPERTY, IProjectVariables.DMPROPERTY_FIELD_INITIAL_PROMPT).setValue("129935.wav");
						} else if(circle_id.equalsIgnoreCase("GJ")){
							mySession.getVariableField(IProjectVariables.DMPROPERTY, IProjectVariables.DMPROPERTY_FIELD_INITIAL_PROMPT).setValue("129936.wav");
						} else if(circle_id.equalsIgnoreCase("DL")){
							mySession.getVariableField(IProjectVariables.DMPROPERTY, IProjectVariables.DMPROPERTY_FIELD_INITIAL_PROMPT).setValue("129937.wav");
						} else if(circle_id.equalsIgnoreCase("KO")){
							mySession.getVariableField(IProjectVariables.DMPROPERTY, IProjectVariables.DMPROPERTY_FIELD_INITIAL_PROMPT).setValue("129938.wav");
						} else {
							mySession.getVariableField(IProjectVariables.DMPROPERTY, IProjectVariables.DMPROPERTY_FIELD_INITIAL_PROMPT).setValue("129932.wav");
						}
						trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "ERROR_CODE 3 Prompt Name :: "+
								mySession.getVariableField(IProjectVariables.DMPROPERTY, IProjectVariables.DMPROPERTY_FIELD_INITIAL_PROMPT).getStringValue());
					} else if(Error_Code.equalsIgnoreCase("4")){
						mySession.getVariableField(IProjectVariables.APP__VARIABLES, IProjectVariables.APP__VARIABLES_FIELD_ERROR__CODE).setValue("SIM_MISMATCH");
					} else if(Error_Code.equalsIgnoreCase("5")){
						mySession.getVariableField(IProjectVariables.APP__VARIABLES, IProjectVariables.APP__VARIABLES_FIELD_ERROR__CODE).setValue("MAX_TRY");
					} else if(Error_Code.equalsIgnoreCase("6")){
						mySession.getVariableField(IProjectVariables.APP__VARIABLES, IProjectVariables.APP__VARIABLES_FIELD_ERROR__CODE).setValue("SYS_ERROR");
					} else if(Error_Code.equalsIgnoreCase("7")){
						mySession.getVariableField(IProjectVariables.APP__VARIABLES, IProjectVariables.APP__VARIABLES_FIELD_ERROR__CODE).setValue("MDN_NOT_VALID");
					} else if(Error_Code.equalsIgnoreCase("8")){
						mySession.getVariableField(IProjectVariables.APP__VARIABLES, IProjectVariables.APP__VARIABLES_FIELD_ERROR__CODE).setValue("DUPLICATE_REQ");
					} else if(Error_Code.equalsIgnoreCase("9")){
						mySession.getVariableField(IProjectVariables.APP__VARIABLES, IProjectVariables.APP__VARIABLES_FIELD_ERROR__CODE).setValue("ALREADY_EXIST");
					} else {
						 mySession.getVariableField(IProjectVariables.APP__VARIABLES, IProjectVariables.APP__VARIABLES_FIELD_ERROR__CODE).setValue("FAILURE");
					}
				} else {
					 mySession.getVariableField(IProjectVariables.APP__VARIABLES, IProjectVariables.APP__VARIABLES_FIELD_WEB_RESPONCE).setValue("FAILURE");
				}
			} 
		}
		catch(Exception e)
		{
			mySession.getVariableField(IProjectVariables.APP__VARIABLES, IProjectVariables.APP__VARIABLES_FIELD_WEB_RESPONCE).setValue("FAILURE");
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "Exception In Account Balance :"+e);
			StackTrace.PrintException(e);
			
		}
	}
	

	
	
	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-APR-28  01:19:12 PM
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
	 * Last generated by Orchestration Designer at: 2017-APR-28  01:19:12 PM
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
	 * Last generated by Orchestration Designer at: 2017-APR-28  01:19:12 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "APP_VARIABLES:WebResponce", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:success", true).setDebugId(5658)).evaluate(mySession)) {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "APP_VARIABLES:ERROR_CODE", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "SUCCESS", false).setDebugId(5660)).evaluate(mySession)) {
				actions = new java.util.ArrayList(3);
				actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "SUCCESS Prompt :- 129918.wav", "").setDebugId(6444));
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("DMProperty:initialPrompt", "129918.wav", true).setDebugId(6425));
				actions.add(new com.avaya.sce.runtime.Next("PlaySuccess", "SUCCESS").setDebugId(5670));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "APP_VARIABLES:ERROR_CODE", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "ALREADY_EXIST", false).setDebugId(5668)).evaluate(mySession)) {
				actions = new java.util.ArrayList(3);
				actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "ALREADY_EXIST Prompt :- 129912.wav", "").setDebugId(6445));
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("DMProperty:initialPrompt", "129912.wav", true).setDebugId(6426));
				actions.add(new com.avaya.sce.runtime.Next("PlaySuccess", "ALREADY_EXIST").setDebugId(5678));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition4", "APP_VARIABLES:ERROR_CODE", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "INVALID_SIM", false).setDebugId(5661)).evaluate(mySession)) {
				actions = new java.util.ArrayList(3);
				actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "INVALID_SIM Prompt :- 129909.wav", "").setDebugId(6446));
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("DMProperty:initialPrompt", "129909.wav", true).setDebugId(6427));
				actions.add(new com.avaya.sce.runtime.Next("PlayFailure", "INVALID_SIM").setDebugId(5671));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition5", "APP_VARIABLES:ERROR_CODE", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "ALREADY_MAPPED", false).setDebugId(5662)).evaluate(mySession)) {
				actions = new java.util.ArrayList(3);
				actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "ALREADY_MAPPED Prompt :- 129923.wav", "").setDebugId(6447));
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("DMProperty:initialPrompt", "129923.wav", true).setDebugId(6428));
				actions.add(new com.avaya.sce.runtime.Next("PlayFailure", "ALREADY_MAPPED").setDebugId(5672));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition6", "APP_VARIABLES:ERROR_CODE", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "RECH_NOT_DONE", false).setDebugId(5663)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("PlayFailure", "RECH_NOT_DONE").setDebugId(5673));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition7", "APP_VARIABLES:ERROR_CODE", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "SIM_MISMATCH", false).setDebugId(6751)).evaluate(mySession)) {
				actions = new java.util.ArrayList(3);
				actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "SIM_MISMATCH Prompt :- 129919.wav", "").setDebugId(6752));
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("DMProperty:initialPrompt", "129919.wav", true).setDebugId(6753));
				actions.add(new com.avaya.sce.runtime.Next("PlayFailure", "SIM_MISMATCH").setDebugId(6754));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition8", "APP_VARIABLES:ERROR_CODE", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "MAX_TRY", false).setDebugId(5665)).evaluate(mySession)) {
				actions = new java.util.ArrayList(3);
				actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "MAX_TRY Prompt :- 45037.wav", "").setDebugId(6449));
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("DMProperty:initialPrompt", "45037.wav", true).setDebugId(6431));
				actions.add(new com.avaya.sce.runtime.Next("PlayFailure", "MAX_TRY").setDebugId(5675));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition9", "APP_VARIABLES:ERROR_CODE", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "SYS_ERROR", false).setDebugId(5666)).evaluate(mySession)) {
				actions = new java.util.ArrayList(3);
				actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "SYS_ERROR Prompt :- 129919.wav", "").setDebugId(6450));
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("DMProperty:initialPrompt", "129919.wav", true).setDebugId(6432));
				actions.add(new com.avaya.sce.runtime.Next("PlayFailure", "SYS_ERROR").setDebugId(5676));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition10", "APP_VARIABLES:ERROR_CODE", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "MDN_NOT_VALID", false).setDebugId(5667)).evaluate(mySession)) {
				actions = new java.util.ArrayList(3);
				actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "MDN_NOT_VALID Prompt :- 129919.wav", "").setDebugId(6451));
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("DMProperty:initialPrompt", "129919.wav", true).setDebugId(6433));
				actions.add(new com.avaya.sce.runtime.Next("PlayFailure", "MDN_NOT_VALID").setDebugId(5677));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition11", "APP_VARIABLES:ERROR_CODE", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "DUPLICATE_REQ", false).setDebugId(6453)).evaluate(mySession)) {
				actions = new java.util.ArrayList(3);
				actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "DUPLICATE_REQ Prompt :- 129926.wav", "").setDebugId(6454));
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("DMProperty:initialPrompt", "129926.wav", true).setDebugId(6455));
				actions.add(new com.avaya.sce.runtime.Next("PlayFailure", "DUPLICATE_REQ").setDebugId(6456));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition12", "APP_VARIABLES:ERROR_CODE", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "FAILURE", false).setDebugId(5669)).evaluate(mySession)) {
				actions = new java.util.ArrayList(3);
				actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "FAILURE Prompt :- 129919.wav", "").setDebugId(6452));
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("DMProperty:initialPrompt", "129919.wav", true).setDebugId(6434));
				actions.add(new com.avaya.sce.runtime.Next("PlayFailure", "FAILURE").setDebugId(5679));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			}

		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("SetLinkDown", "Default").setDebugId(5214));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
