package flow.subflow.Prepaid;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.prepaid.model.CRMCountInfo;
import com.rcom.prepaid.resource.IVRDBServiceInstance;
import com.servion.hsd.utils.AppConstant;
import com.servion.hsd.utils.StackTrace;
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
 * Last generated by Orchestration Designer at: 2015-APR-06  04:36:55 PM
 */
public class Host_CRM_WS extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-APR-06  04:36:55 PM
	 */
	public Host_CRM_WS() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:39:00 PM
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
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:39:00 PM
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
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:39:00 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(3);
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_INFO, "CRM Host Response :", "AppVariables:HostResult").setDebugId(599));
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_INFO, "CRM History Next Node :", "Flag:CRMHistoryFlag").setDebugId(600));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "AppVariables:HostResult", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:success", true).setDebugId(601)).evaluate(mySession)) {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "Flag:CRMHistoryFlag", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:Data_Balance", true).setDebugId(602)).evaluate(mySession)) {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("Flag:CalledFromIntelligent", "constant:Key_true", false).setDebugId(11262));
				actions.add(new com.avaya.sce.runtime.Next("Prepaid-executeDataBalance", "Data_Balance").setDebugId(603));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("Prepaid-checkMainMenuCount", "MainMenu").setDebugId(607));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("Prepaid-checkMainMenuCount", "HostError").setDebugId(609));
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
		String ani =  AppConstant.EMPTY_STRING,nextNode = AppConstant.EMPTY_STRING;
		String strCategory1Count =  AppConstant.EMPTY_STRING,strCategory2Count =  AppConstant.EMPTY_STRING;
		String strCategory3Count =  AppConstant.EMPTY_STRING,strCategory4Count =  AppConstant.EMPTY_STRING;
		CRMCountInfo objCRMCountInfo = null;
		IVRDataBean objIVRDataBean = null;
		ITraceInfo trace = mySession.getTraceOutput();
		
		try {
			
			/**Assigning**/
			ani = mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_ANI).getStringValue();
			appName = mySession.getVariableField(IProjectVariables.APP__NAME).getStringValue();
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"ANI :"+ani +"App Name :" + appName);
			objCRMCountInfo = new CRMCountInfo();
			objIVRDataBean = (IVRDataBean)mySession.getProperty(AppConstant.IVRDATABEAN);
			objCRMCountInfo.setMdn(ani);
			/**DB Hit**/

			objCRMCountInfo = IVRDBServiceInstance.getInstance().getCRMCountInfo(objIVRDataBean,objCRMCountInfo);
			if(objCRMCountInfo!=null){
				strCategory1Count=objCRMCountInfo.getCategory1Count();
				strCategory2Count=objCRMCountInfo.getCategory2Count();
				strCategory3Count=objCRMCountInfo.getCategory3Count();
				strCategory4Count=objCRMCountInfo.getCategory4Count();
				
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Category 1 Count :(account related inquiry + Balance+ information):"+strCategory1Count);
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Category 2 Count :(account related	inquiry + Balance+ Guided to self service)"+strCategory2Count);
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Category 3 Count :(GPRS condition related inquiry + Balance + guided to self-service)"+strCategory3Count);
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Category 4 Count :(account related	inquiry + 3G_Balance +	information)"+strCategory4Count);
				
				if(strCategory1Count!=null && strCategory2Count!=null && strCategory3Count!=null && strCategory4Count!=null){
					int intCategory1Count = Integer.parseInt(strCategory1Count);
					int intCategory2Count = Integer.parseInt(strCategory2Count);
					int intCategory3Count = Integer.parseInt(strCategory3Count);
					int intCategory4Count = Integer.parseInt(strCategory4Count);
					
				/*	if(intCategory1Count>2){
						nextNode = AppConstant.Main_Account_Bal;
						trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Category1Count > 2");
					}else if(intCategory2Count>2){
						nextNode = AppConstant.Main_Account_Bal;
						trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Category2Count > 2");
					} else*/ if(intCategory3Count>2){
						nextNode = AppConstant.Data_Balance;
						trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Category3Count > 2");
					} else if(intCategory4Count>2){
						nextNode = AppConstant.Data_Balance;
						trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Category4Count > 2");
					} else {
						nextNode = AppConstant.Prepaid_MainMenu;
						trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Category complete Else");
					}
				}else {
					nextNode = AppConstant.MDN_LookUp;
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Count Should never be null");
				}
				
				hostOutput = AppConstant.Success;
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Next Node ID :"+nextNode);
				mySession.getVariableField(IProjectVariables.FLAG,IProjectVariables.FLAG_FIELD_CRMHISTORY_FLAG).setValue(nextNode);
			}
			else{
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"CRMCountInfo Object is null");
			}
		} catch (Exception e) {
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "Error in CRM Count Info :" +e);
			StackTrace.PrintException(e);
		}finally{
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Host Status :" +hostOutput);
			mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_HOST_RESULT).setValue(hostOutput);	
		}
		
	}
}