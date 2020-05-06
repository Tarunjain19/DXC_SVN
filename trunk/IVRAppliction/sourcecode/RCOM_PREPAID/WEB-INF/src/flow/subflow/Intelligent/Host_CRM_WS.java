package flow.subflow.Intelligent;

import java.net.InetAddress;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.prepaid.model.CRMCountInfo;
import com.rcom.prepaid.resource.IVRDBServiceInstance;
import com.servion.util.AppConstant;
import com.servion.util.IVRDataBean;
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
	 * Last generated by Orchestration Designer at: 2017-AUG-29  03:09:24 PM
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
	 * Last generated by Orchestration Designer at: 2017-AUG-29  03:09:24 PM
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
	 * Last generated by Orchestration Designer at: 2017-AUG-29  03:09:24 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(2);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "EPM_Alarm:Flag", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:TRUE", true).setDebugId(601)).evaluate(mySession)) {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "WS_Alarm_Flag", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:ON", true).setDebugId(613)).evaluate(mySession)) {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.tracking.ReportAlarmInfo(com.avaya.sce.runtimecommon.IReportInfo.ALARM_LEVEL_MAJOR, "WS Down|Intelligent Flow|Host CRM_WS|", "EPM_Alarm:Description", true).setDebugId(602));
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("EPM_Alarm:Flag", "constant:FALSE", false).setDebugId(603));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			}

		}

		actions = new java.util.ArrayList(2);
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_INFO, "CRM Host Response :", "appVariables:HostResult").setDebugId(507));
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_INFO, "CRM History Next Node :", "Flag:CRMHistoryFlag").setDebugId(508));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "appVariables:HostResult", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:success", true).setDebugId(506)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("Intelligent-Check_ILInteractionHistory", "IL").setDebugId(639));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("Intelligent-MainMenu", "HostError").setDebugId(504));
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
		String EPM_Alarm_Description = AppConstant.EMPTY_STRING,IP = AppConstant.EMPTY_STRING;
		CRMCountInfo objCRMCountInfo = null;
		IVRDataBean objIVRDataBean = null;
		ITraceInfo trace = mySession.getTraceOutput();
		
		try {
			
			IP = InetAddress.getLocalHost().getHostAddress();
			/**Assigning**/
			ani = mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_ANI).getStringValue();
			appName = mySession.getVariableField(IProjectVariables.APP_NAME).getStringValue();
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"ANI :"+ani +"App Name :" + appName);
			objCRMCountInfo = new CRMCountInfo();
			objIVRDataBean = (IVRDataBean)mySession.getProperty(AppConstant.IVRDATABEAN);
			objCRMCountInfo.setMdn(ani);
			/**DB Hit**/

			try
			{
			objCRMCountInfo = IVRDBServiceInstance.getInstance().getCRMCountInfo(objIVRDataBean,objCRMCountInfo);
			}
			catch (Exception e){
				EPM_Alarm_Description =IP+"|"+e;
				mySession.getVariableField(IProjectVariables.EPM__ALARM,IProjectVariables.EPM__ALARM_FIELD_FLAG).setValue(AppConstant.TRUE);
				mySession.getVariableField(IProjectVariables.EPM__ALARM,IProjectVariables.EPM__ALARM_FIELD_DESCRIPTION).setValue(EPM_Alarm_Description);
			}
			if(objCRMCountInfo!=null){
				strCategory1Count=objCRMCountInfo.getCategory1Count();
				strCategory2Count=objCRMCountInfo.getCategory2Count();
				strCategory3Count=objCRMCountInfo.getCategory3Count();
				strCategory4Count=objCRMCountInfo.getCategory4Count();
				
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Category 1 Count :(account related inquiry + Balance+ information):"+strCategory1Count);
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Category 2 Count :(account related	inquiry + Balance+ Guided to self service)"+strCategory2Count);
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Category 3 Count :(GPRS condition related inquiry + Balance + guided to self-service)"+strCategory3Count);
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Category 4 Count :(account related	inquiry + 3G_Balance +	information)"+strCategory4Count);
				
				mySession.getVariableField(IProjectVariables.ILINTERACTION_HISTORY_COUNT,IProjectVariables.ILINTERACTION_HISTORY_COUNT_FIELD_CATEGORY_1).setValue(strCategory1Count);
				mySession.getVariableField(IProjectVariables.ILINTERACTION_HISTORY_COUNT,IProjectVariables.ILINTERACTION_HISTORY_COUNT_FIELD_CATEGORY_2).setValue(strCategory2Count);
				mySession.getVariableField(IProjectVariables.ILINTERACTION_HISTORY_COUNT,IProjectVariables.ILINTERACTION_HISTORY_COUNT_FIELD_CATEGORY_3).setValue(strCategory3Count);
				mySession.getVariableField(IProjectVariables.ILINTERACTION_HISTORY_COUNT,IProjectVariables.ILINTERACTION_HISTORY_COUNT_FIELD_CATEGORY_4).setValue(strCategory4Count);
				
				
				
				hostOutput = AppConstant.Success;
				
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
