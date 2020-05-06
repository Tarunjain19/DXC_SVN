package flow;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.otherflows.model.ValidateMDNDealer;
import com.rcom.otherflows.resource.IVRDBServiceInstance;
import com.rcom.util.AppConstant;
import com.rcom.util.StackTrace;
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
 * Last generated by Orchestration Designer at: 2015-SEP-24  01:55:40 PM
 */
public class MDNCheck extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-SEP-24  01:55:40 PM
	 */
	public MDNCheck() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-MAR-24  10:30:19 AM
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
	 * Last generated by Orchestration Designer at: 2017-MAR-24  10:30:19 AM
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
	 * Last generated by Orchestration Designer at: 2017-MAR-24  10:30:19 AM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(2);
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "MDN Check ::", "appVariables:MDNHardcode").setDebugId(4686));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "appVariables:HostResult", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:Success", true).setDebugId(5666)).evaluate(mySession)) {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "appVariables:MDNHardcode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:Yes", true).setDebugId(3380)).evaluate(mySession)) {

				if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "appVariables:dataType", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "EREC", false).setDebugId(5670)).evaluate(mySession)) {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.Next("CheckTransaction", "Yes").setDebugId(5673));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;

				} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition4", "appVariables:dataType", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "EGOLDINCIRCLE", false).setDebugId(5671)).evaluate(mySession)) {
					actions = new java.util.ArrayList(2);
					actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "RCD_TR_0001", true).setDebugId(5675));
					actions.add(new com.avaya.sce.runtime.Next("TransferAgent", "Transfer").setDebugId(5674));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;

				} else {
					actions = new java.util.ArrayList(2);
					actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "RCD_TR_0002", true).setDebugId(5676));
					actions.add(new com.avaya.sce.runtime.Next("TransferAgent", "Transfer").setDebugId(3382));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;
				}


			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("NotAuthorized_PP", "No").setDebugId(3378));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


		} else {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "RCD_TR_0031", true).setDebugId(5669));
			actions.add(new com.avaya.sce.runtime.Next("LinkDown_PP", "LinkDown").setDebugId(5668));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
	
	@Override
	public void requestBegin(SCESession mySession) {

		/**Declaration **/
		String appName = AppConstant.EMPTY_STRING,hostOutput = AppConstant.ERROR,key=AppConstant.EMPTY_STRING;
		String mdn = AppConstant.EMPTY_STRING,strDataType = AppConstant.EMPTY_STRING, strFlag =AppConstant.EMPTY_STRING;
		String circleID = AppConstant.EMPTY_STRING;
		ValidateMDNDealer validateMDN = null;
		IVRDataBean objIVRDataBean = null;

		ITraceInfo trace = mySession.getTraceOutput();
		
		try {
			
			/**Assigning**/
			mdn = mySession.getVariableField(IProjectVariables.SESSION,IProjectVariables.SESSION_FIELD_ANI).getStringValue();
			appName = mySession.getVariableField(IProjectVariables.APPNAME).getStringValue();
			circleID = mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_CIRCLE_ID).getStringValue();
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"MDN :"+mdn +" - App Name :" + appName);
			
			validateMDN = new ValidateMDNDealer();
			validateMDN.setMdn(mdn);
			objIVRDataBean = (IVRDataBean)mySession.getProperty(AppConstant.IVRDATABEAN);
			
			
			/**DB Hit**/
			validateMDN = IVRDBServiceInstance.getIVRDBInstance().getMDNHardCodingInfo(objIVRDataBean,validateMDN);
			if(validateMDN!=null){
				strDataType = validateMDN.getDataType();
				strFlag = validateMDN.getFlag();
				
				/** Assign Language List Code **/
				mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_DATA_TYPE).setValue(strDataType);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Data Type :"+strDataType);
				
				/**Assign Circle ID **/
				mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_FLAG).setValue(strFlag);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"FLAG :"+strFlag);
				
				
				if(strFlag!=null && !AppConstant.EMPTY_STRING.equals(strFlag) && AppConstant.Success.equalsIgnoreCase(strFlag)){
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"MDN is available");
					mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_MDNHARDCODE).setValue(AppConstant.Yes);
					
					if("EGOLD".equalsIgnoreCase(strDataType)){
						String CircleList = AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp(AppConstant.CIRCLE_LIST);
						trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Circle List :"+CircleList);
						
						if(CircleList.contains(circleID)){
							trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"EGOLD IN CIRCLE");
							mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_DATA_TYPE).setValue(AppConstant.EGOLDINCIRCLE);
						}else{
							trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Normal EGOLD Customer ");
						}
						
					}else{
						trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Data Type :"+strDataType);
					}
					
				}
				hostOutput = AppConstant.Success;
			}
			else{
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"validateMDN Object is null");
			}
			
		} catch (Exception e) {
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "Error in Validate MDN :" +e);
			StackTrace.PrintException(e);
		}
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Host Status :" +hostOutput);
		mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_HOST_RESULT).setValue(hostOutput);
	
	}
}