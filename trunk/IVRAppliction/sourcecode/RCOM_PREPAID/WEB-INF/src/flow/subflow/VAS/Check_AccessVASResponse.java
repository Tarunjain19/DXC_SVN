package flow.subflow.VAS;

import java.net.InetAddress;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.servion.rcom.hostinterface.view.ReqActivateVAS;
import com.servion.rcom.hostinterface.view.ResActivateVAS;
import com.servion.rcom.hostinterface.wrapper.IVRWebService;
import com.servion.rcom.hostinterface.wrapper.IVRWebServiceImpl;
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
 * Last generated by Orchestration Designer at: 2015-APR-08  10:29:05 PM
 */
public class Check_AccessVASResponse extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-APR-08  10:29:05 PM
	 */
	public Check_AccessVASResponse() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-AUG-29  03:09:23 PM
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
	 * Last generated by Orchestration Designer at: 2017-AUG-29  03:09:23 PM
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
	 * Last generated by Orchestration Designer at: 2017-AUG-29  03:09:23 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(2);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "EPM_Alarm:Flag", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:TRUE", true).setDebugId(5726)).evaluate(mySession)) {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "WS_Alarm_Flag", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:ON", true).setDebugId(5730)).evaluate(mySession)) {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.tracking.ReportAlarmInfo(com.avaya.sce.runtimecommon.IReportInfo.ALARM_LEVEL_MAJOR, "WS Down|VAS Flow|Chk Access VAS|", "EPM_Alarm:Description", true).setDebugId(5727));
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("EPM_Alarm:Flag", "constant:FALSE", false).setDebugId(5728));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			}

		}


		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "appVariables:HostResult", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:success", true).setDebugId(5331)).evaluate(mySession)) {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition4", "appVariables:ActivateVASResponse", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "0", false).setDebugId(5343)).evaluate(mySession)) {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "TR_0086", true).setDebugId(5624));
				actions.add(new com.avaya.sce.runtime.Next("VAS-Set_PA_0033", "Yes").setDebugId(5342));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition5", "appVariables:ActivateVASResponse", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "1", false).setDebugId(5596)).evaluate(mySession)) {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "TR_0060", true).setDebugId(5622));
				actions.add(new com.avaya.sce.runtime.Next("VAS-LinkDown", "NetworkFailure").setDebugId(5597));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "TR_0087", true).setDebugId(5625));
				actions.add(new com.avaya.sce.runtime.Next("VAS-PA_0083", "No").setDebugId(5332));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


		} else {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "TR_0060", true).setDebugId(5623));
			actions.add(new com.avaya.sce.runtime.Next("VAS-LinkDown", "NetworkFailure").setDebugId(5522));
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
	
		ITraceInfo trace = mySession.getTraceOutput();
		String hostResult = AppConstant.ERROR;
		String mdn = null,packCode = AppConstant.EMPTY_STRING;
		String EPM_Alarm_Description = AppConstant.EMPTY_STRING,IP = AppConstant.EMPTY_STRING;
	
		
		ReqActivateVAS reqActivateVAS = null;
		ResActivateVAS resActivateVAS = null;
		IVRWebService webServiceManager = null;
		IVRDataBean objIVRData = null;
		try
		{
			IP = InetAddress.getLocalHost().getHostAddress();
			objIVRData = (IVRDataBean) mySession.getProperty(AppConstant.IVRDATABEAN);
			
			//Request Processing......
			mdn = mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_ANI).getStringValue();
			packCode = mySession.getVariableField(IProjectVariables.MN___0_0_1_0,IProjectVariables.MN___0_0_1_0_FIELD_VALUE).getStringValue();
			
			reqActivateVAS = new ReqActivateVAS();
			reqActivateVAS.setMDN(mdn);
			reqActivateVAS.setPackCode(packCode);
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Activate VAS Host request :: "+reqActivateVAS.toString());
			
			//Response Processing......
			webServiceManager = new IVRWebServiceImpl();
			try
			{
			resActivateVAS = webServiceManager.executeActivateVAS(objIVRData,reqActivateVAS);
			}
			catch (Exception e){
				EPM_Alarm_Description =IP+"|"+e;
				mySession.getVariableField(IProjectVariables.EPM__ALARM,IProjectVariables.EPM__ALARM_FIELD_FLAG).setValue(AppConstant.TRUE);
				mySession.getVariableField(IProjectVariables.EPM__ALARM,IProjectVariables.EPM__ALARM_FIELD_DESCRIPTION).setValue(EPM_Alarm_Description);
			}
			
			if(resActivateVAS!=null){
				mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_ACTIVATE_VASRESPONSE).setValue(resActivateVAS.getResponseCode());
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Activate VAS Host response :: "+resActivateVAS.getResponseCode());
				hostResult = AppConstant.Success;
			}
		}
		catch(Exception e)
		{
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Error in Activate VAS Host Hit:: "+e);
			StackTrace.PrintException(e);
		}
		finally
		{
			reqActivateVAS = null;
			resActivateVAS = null;
			webServiceManager = null;
			mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_HOST_RESULT).setValue(hostResult);
		}
		
		
	}
}
