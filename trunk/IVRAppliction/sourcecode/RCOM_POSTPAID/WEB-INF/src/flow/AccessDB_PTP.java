package flow;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.postpaid.model.PromiseToPayInfo;
import com.rcom.postpaid.resource.IVRDBServiceInstance;
import com.servion.postpaid.utils.Constants;
import com.servion.postpaid.utils.PrintStackTrace;
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
 * Last generated by Orchestration Designer at: 2015-MAY-24  04:20:18 PM
 */
public class AccessDB_PTP extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS
	
	@Override
	public void requestBegin(SCESession mySession) {
		super.requestBegin(mySession);
		
		ITraceInfo info = mySession.getTraceOutput();
		
		IVRDataBean ivrDataBean = null;
		PromiseToPayInfo promiseToPayInfo = null;
		String strRequestDate = "", strMDN = "", strCallDate = "";
		Date dateRequestDate = null, callDate = null;
		DateFormat dateFormat = null;
		Calendar c1 = null;
		String IP ="",EPM_Alarm_Description = "";
		
		try {
			c1 = Calendar.getInstance();
			callDate = new Date();
			dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			IP = mySession.getVariableField(IProjectVariables.EPM__ALARM,IProjectVariables.EPM__ALARM_FIELD_TOMCAT__SERVER_IP).getStringValue();
			
			strCallDate = dateFormat.format(callDate);
			ivrDataBean = (IVRDataBean) mySession.getProperty(Constants.IVRDATABEAN);
			strMDN = mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_MDN).getStringValue();
			
			promiseToPayInfo = new PromiseToPayInfo();
			promiseToPayInfo.setMdn(strMDN);
			try{
			promiseToPayInfo = IVRDBServiceInstance.getInstance().getPromiseToPayInfo(ivrDataBean, promiseToPayInfo);
			}
			catch(Exception e)
			{
				EPM_Alarm_Description =IP+"|"+e;
				mySession.getVariableField(IProjectVariables.EPM__ALARM,IProjectVariables.EPM__ALARM_FIELD_FLAG).setValue("TRUE");
				mySession.getVariableField(IProjectVariables.EPM__ALARM,IProjectVariables.EPM__ALARM_FIELD_DESCRIPTION).setValue(EPM_Alarm_Description);
			}
			
			if(promiseToPayInfo != null){
				strRequestDate = promiseToPayInfo.getPtpRequestDate();
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "---> Request date:"+strRequestDate);
				if(strRequestDate != null){
					
					dateRequestDate = dateFormat.parse(strRequestDate);
					callDate = dateFormat.parse(strCallDate);
					
					info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "---> Request date:"+dateRequestDate);
					c1.setTime(callDate);
					c1.add(Calendar.DATE, -30);
					callDate = c1.getTime();
					info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->Call date comparision:"+dateRequestDate.compareTo(callDate));
					
					if((dateRequestDate.compareTo(callDate)>=0)&&(dateRequestDate.compareTo(new Date())<=0)){
						mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_PTPSRPRESENT).setValue(Constants.Yes);
					}else{
						mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_PTPSRPRESENT).setValue(Constants.No);
					}
				}else{
					mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_PTPSRPRESENT).setValue(Constants.No);
				}
			}else{
				mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_PTPSRPRESENT).setValue(Constants.No);
			}
		} catch (Exception e) {
			PrintStackTrace.PrintException(e);
			mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.Yes);
		} 		
	}

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-24  04:20:18 PM
	 */
	public AccessDB_PTP() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-AUG-28  03:36:20 PM
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
	 * Last generated by Orchestration Designer at: 2017-AUG-28  03:36:20 PM
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
	 * Last generated by Orchestration Designer at: 2017-AUG-28  03:36:20 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(2);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "EPM_Alarm:Flag", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:True", true).setDebugId(6864)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.tracking.ReportAlarmInfo(com.avaya.sce.runtimecommon.IReportInfo.ALARM_LEVEL_CRITICAL, "DB Down|Main Flow|AccessDB_PTP|", "EPM_Alarm:Description", true).setDebugId(6865));
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("EPM_Alarm:Flag", "Constants:False", false).setDebugId(6866));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		}


		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "Flag:isLinkDown", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:yes", true).setDebugId(1263)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("Initialize_MN_0005", "LinkDown").setDebugId(1265));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "Flag:isPTPSRPResent", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:yes", true).setDebugId(1259)).evaluate(mySession)) {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("CallData:transferReasonCode", "Constants:TR_0003", false).setDebugId(1927));
				actions.add(new com.avaya.sce.runtime.Next("checkHNICaller", "PTPPresent").setDebugId(1260));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("MakePayment_MN_0001", "PTPNotPresent").setDebugId(1262));
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