package flow;

import java.net.InetAddress;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.avaya.sce.runtimecommon.VariableTypeException;
import com.rcom.prepaid.model.GPRSSRCInfo;
import com.rcom.prepaid.resource.IVRDBServiceInstance;
import com.servion.util.AppConstant;
import com.servion.util.IVRDataBean;
import com.servion.util.StackTrace;

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
 * Last generated by Orchestration Designer at: 2015-NOV-26  02:43:30 PM
 */
public class GPRS_GSM_CHECK extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-NOV-26  02:43:30 PM
	 */
	public GPRS_GSM_CHECK() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-AUG-29  03:09:21 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("Check_198_App", "NOT BAR");
		next.setDebugId(8591);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2017-AUG-29  03:09:21 PM
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
	 * Last generated by Orchestration Designer at: 2017-AUG-29  03:09:21 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(2);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "EPM_Alarm:Flag", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:TRUE", true).setDebugId(9921)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.tracking.ReportAlarmInfo(com.avaya.sce.runtimecommon.IReportInfo.ALARM_LEVEL_CRITICAL, "DB Down|Main Flow|GPRS_GSM_CHECK|", "EPM_Alarm:Description", true).setDebugId(9922));
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("EPM_Alarm:Flag", "constant:FALSE", false).setDebugId(9923));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		}


		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "Flag:GPRS_BAR", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "true", false).setDebugId(8595)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("CheckCallerType", "GPRS_GSM").setDebugId(8596));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		}

		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
	public void requestBegin(SCESession mySession) {
		
		/**Declaration **/
		
		ITraceInfo trace = mySession.getTraceOutput();
		IVRDataBean objIVRDataBean = null;
		String hostOutput = AppConstant.ERROR;
		String EPM_Alarm_Description = AppConstant.EMPTY_STRING,IP = AppConstant.EMPTY_STRING;
		
		try {
			
			IP = InetAddress.getLocalHost().getHostAddress();
			String ani = mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_ANI).getStringValue();
			
			String appName = mySession.getVariableField(IProjectVariables.APP_NAME).getStringValue();
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG," - App Name :" + appName);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG," - ani Name :" + ani);
			
			if(appName.contains("GSM")){
				
				objIVRDataBean = (IVRDataBean)mySession.getProperty(AppConstant.IVRDATABEAN);
				
				GPRSSRCInfo	objGPRSInfo=new GPRSSRCInfo();
				objGPRSInfo.setMdn(ani);
				objGPRSInfo.setP_LOB_ID("01");
				objGPRSInfo.setP_COUNTER_SEGMENT_IN("NORMAL");
				try
				{
				objGPRSInfo=IVRDBServiceInstance.getInstance().checkGPRSSRCFlag(objIVRDataBean, objGPRSInfo);
				}
				catch (Exception e){
					EPM_Alarm_Description =IP+"|"+e;
					mySession.getVariableField(IProjectVariables.EPM__ALARM,IProjectVariables.EPM__ALARM_FIELD_FLAG).setValue(AppConstant.TRUE);
					mySession.getVariableField(IProjectVariables.EPM__ALARM,IProjectVariables.EPM__ALARM_FIELD_DESCRIPTION).setValue(EPM_Alarm_Description);
				}
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG," GPRS Responce :" + objGPRSInfo);
				if(objGPRSInfo!=null)
				{
						String gprsStatus = objGPRSInfo.getP_BMBAR_STATUS();
						trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,
								" GPRS Status :" + gprsStatus);
						trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, " GPRS Status :"
								+ gprsStatus);
	
						if (gprsStatus.equalsIgnoreCase("DBAR")
								|| gprsStatus.equalsIgnoreCase("WBAR")
								|| gprsStatus.equalsIgnoreCase("MBAR")) {
	
							mySession.getVariableField(IProjectVariables.FLAG,
									IProjectVariables.FLAG_FIELD_GPRS__BAR)
									.setValue(AppConstant.TRUE);
	
						} else {
							mySession.getVariableField(IProjectVariables.FLAG,
									IProjectVariables.FLAG_FIELD_GPRS__BAR)
									.setValue(AppConstant.FALSE);
	
						}
						// mySession.getVariableField(IProjectVariables.FLAG,IProjectVariables.FLAG_FIELD_GPRS_FLAG).setValue(gprsStatus);
						hostOutput = AppConstant.Success;
					} 
				else {
						mySession.getVariableField(IProjectVariables.FLAG,
								IProjectVariables.FLAG_FIELD_GPRS__BAR).setValue(
								AppConstant.FALSE);
						trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,
								"objGPRSInfo Object is null");
						trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,
								" GPRS Status is null :");
						hostOutput = "Failure";
					}
				
				
			}
			else
			{
				mySession.getVariableField(IProjectVariables.FLAG,IProjectVariables.FLAG_FIELD_GPRS__BAR).setValue(AppConstant.FALSE);
				
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG," - GPRS_BAE : FALSE" );
				
			}
		
		}catch(VariableTypeException e) {
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "Error in 198 caller Check :" +e);
			StackTrace.PrintException(e);
		}
		catch (Exception e) {
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "Error in 198 caller Check :" +e);
			StackTrace.PrintException(e);
			
			EPM_Alarm_Description =IP+"|"+e;
			mySession.getVariableField(IProjectVariables.EPM__ALARM,IProjectVariables.EPM__ALARM_FIELD_FLAG).setValue(AppConstant.TRUE);
			mySession.getVariableField(IProjectVariables.EPM__ALARM,IProjectVariables.EPM__ALARM_FIELD_DESCRIPTION).setValue(EPM_Alarm_Description);
		}
		
	}
}