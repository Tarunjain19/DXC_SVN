package flow.subflow.AccountInformation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.servion.postpaid.utils.Constants;
import com.servion.postpaid.utils.PrintStackTrace;
import com.servion.postpaid.utils.SetPushSMS;
import com.servion.rcom.hostinterface.view.ReqBillDeliveryStatus;
import com.servion.rcom.hostinterface.view.ResBillDeliveryStatus;
import com.servion.rcom.hostinterface.wrapper.IVRWebService;
import com.servion.rcom.hostinterface.wrapper.IVRWebServiceImpl;
import com.servion.util.AppProperties;
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
 * Last generated by Orchestration Designer at: 2015-APR-16  04:33:59 PM
 */
public class AccessHost_DeliveryStatus extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS
	
	@Override
	public void requestBegin(SCESession mySession) {
		super.requestBegin(mySession);
		
		ITraceInfo info = mySession.getTraceOutput();
		
		IVRDataBean ivrDataBean = null;
		ReqBillDeliveryStatus reqBillDeliveryStatus = null;
		ResBillDeliveryStatus resBillDeliveryStatus = null;
		IVRWebService ivrWebService = null;
		String strBillGenDate = "", strBillDeliveryDate = "", strCallDate = "", strMode = "";
		Date dateBillGenDate = null, dateBillDeliveryDate = null;
		double dateDiff = 0;
		SetPushSMS setPushSMS = null;
		String strSMSFrame = "", strDeveliveryStatusDateFormat = "";
		ArrayList<String> arrSMSData = null;
		Hashtable<String, String> smsHashTable = null;
		AppProperties appProperties = null;
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		Date callDate = new Date();
		Calendar cal = Calendar.getInstance();
		String IP ="",EPM_Alarm_Description = "";
		
		try {
			
			setPushSMS = new SetPushSMS();
			arrSMSData = new ArrayList<String>();
			appProperties = (AppProperties) mySession.getProperty(Constants.IvrPropertyInstance);
			IP = mySession.getVariableField(IProjectVariables.EPM__ALARM,IProjectVariables.EPM__ALARM_FIELD_TOMCAT__SERVER_IP).getStringValue();
			/*strDeveliveryStatusDateFormat = appProperties.getIVRProp(Constants.DeveliveryStatusDateFormat);
			if(!(strDeveliveryStatusDateFormat.equalsIgnoreCase("N"))||(strDeveliveryStatusDateFormat != null)){
				dateFormat = new SimpleDateFormat(strDeveliveryStatusDateFormat);
			}*/
			strCallDate = dateFormat.format(callDate); 
					
			ivrDataBean = (IVRDataBean) mySession.getProperty(Constants.IVRDATABEAN);
			reqBillDeliveryStatus = new ReqBillDeliveryStatus();
			reqBillDeliveryStatus.setMDN(mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_MDN).getStringValue());
			
			ivrWebService = new IVRWebServiceImpl();
			try{
			resBillDeliveryStatus = ivrWebService.executeBillDeliveryStatus(ivrDataBean, reqBillDeliveryStatus);
			}
			catch(Exception e)
			{
				EPM_Alarm_Description =IP+"|"+e;
				mySession.getVariableField(IProjectVariables.EPM__ALARM,IProjectVariables.EPM__ALARM_FIELD_FLAG).setValue("TRUE");
				mySession.getVariableField(IProjectVariables.EPM__ALARM,IProjectVariables.EPM__ALARM_FIELD_DESCRIPTION).setValue(EPM_Alarm_Description);
			}
			mySession.getVariableField(IProjectVariables.BILL_DELIVERY_STATUS, IProjectVariables.BILL_DELIVERY_STATUS_FIELD_RESPONSE_CODE).setValue(resBillDeliveryStatus.getResponseCode());
			if((resBillDeliveryStatus.getResponseCode()).equals(Constants.zero)){
				
				strBillGenDate = resBillDeliveryStatus.getBillGenDate();
				dateBillGenDate = dateFormat.parse(strBillGenDate);
				
				strBillDeliveryDate = resBillDeliveryStatus.getBillDeliveryDate();
				if(strBillDeliveryDate != null)
					if(strBillDeliveryDate.length()>4)
						dateBillDeliveryDate = dateFormat.parse(strBillDeliveryDate);
				
				dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				strBillGenDate = dateFormat.format(dateBillGenDate);
				
				try {
					if(strBillDeliveryDate != null)
						strBillDeliveryDate = dateFormat.format(dateBillDeliveryDate);
				} catch (Exception e) {
					strBillDeliveryDate = "00-00-0000";
				}
				
				strMode = resBillDeliveryStatus.getMode();
				mySession.getVariableField(IProjectVariables.BILL_DELIVERY_STATUS, IProjectVariables.BILL_DELIVERY_STATUS_FIELD_BILL_DELIVERY_DATE).setValue(strBillDeliveryDate);
				mySession.getVariableField(IProjectVariables.BILL_DELIVERY_STATUS, IProjectVariables.BILL_DELIVERY_STATUS_FIELD_BILL_DELIVERY_STATUS).setValue(resBillDeliveryStatus.getBillDeliveryStatus());
				mySession.getVariableField(IProjectVariables.BILL_DELIVERY_STATUS, IProjectVariables.BILL_DELIVERY_STATUS_FIELD_BILL_GENERATION_DATE).setValue(strBillGenDate);
				mySession.getVariableField(IProjectVariables.BILL_DELIVERY_STATUS, IProjectVariables.BILL_DELIVERY_STATUS_FIELD_MODE).setValue(strMode);
				
				dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->Delivery Date:"+dateBillDeliveryDate+",Delivery Status:"+resBillDeliveryStatus.getBillDeliveryStatus());
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->Bill Gen Date:"+dateBillGenDate+",Mode:"+resBillDeliveryStatus.getMode());
				
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->bill gen date:"+dateBillGenDate.getTime());
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->call date:"+callDate.getTime());
				dateDiff = callDate.getTime() - dateBillGenDate.getTime();
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->Bill Date Diff:"+dateDiff);
				dateDiff = (dateDiff / (24 * 60 * 60 * 1000))*24;
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->Bill Date Diff:"+dateDiff);
				mySession.getVariableField(IProjectVariables.BILL_DELIVERY_STATUS, IProjectVariables.BILL_DELIVERY_STATUS_FIELD_BILL_GEN_DATE_DIFF).setValue(dateDiff);
				
				
				strSMSFrame = appProperties.getIVRProp(Constants.DELIVERY_STATUS_MODE_Success);
				smsHashTable = setPushSMS.generatePushSMSDataMap(strSMSFrame, arrSMSData);
				
				if(strMode != null){
					if((strMode.equalsIgnoreCase(Constants.POST))||(strMode.equalsIgnoreCase(Constants.COURIER))){
						cal.setTime(dateBillGenDate);
						cal.add(Calendar.DATE, 12);
						dateBillGenDate = cal.getTime();
					}else{
						cal.setTime(dateBillGenDate);
						cal.add(Calendar.DATE, 4);
						dateBillGenDate = cal.getTime();
					}
					info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "ETA:"+dateBillGenDate);
					info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "ETA:"+dateBillGenDate.compareTo(callDate));
					if(dateBillGenDate.compareTo(callDate)<0){
						mySession.getVariableField(IProjectVariables.BILL_DELIVERY_STATUS, IProjectVariables.BILL_DELIVERY_STATUS_FIELD_ETA_FLAG).setValue(Constants.Yes);
					}else{
						mySession.getVariableField(IProjectVariables.BILL_DELIVERY_STATUS, IProjectVariables.BILL_DELIVERY_STATUS_FIELD_ETA_FLAG).setValue(Constants.No);
					}
				}else{
					mySession.getVariableField(IProjectVariables.BILL_DELIVERY_STATUS, IProjectVariables.BILL_DELIVERY_STATUS_FIELD_ETA_FLAG).setValue(Constants.No);
				}
				
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Bill Date Diff:"+dateDiff);
			}else{
				
				strSMSFrame = appProperties.getIVRProp(Constants.DELIVERY_STATUS_MODE_Failure);
				smsHashTable = setPushSMS.generatePushSMSDataMap(strSMSFrame, arrSMSData);
				mySession.setProperty(Constants.SMSDataMap, smsHashTable);
				mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.Yes);
			}
			

		} catch (Exception e) {
			strSMSFrame = appProperties.getIVRProp(Constants.DELIVERY_STATUS_MODE_Failure);
			smsHashTable = setPushSMS.generatePushSMSDataMap(strSMSFrame, arrSMSData);
			PrintStackTrace.PrintException(e);
			mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.Yes);
			mySession.setProperty(Constants.SMSDataMap, smsHashTable);
		}finally{
			//mySession.setProperty(Constants.SMSDataMap, smsHashTable);
		}
	}

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-APR-16  04:33:59 PM
	 */
	public AccessHost_DeliveryStatus() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-AUG-28  11:20:51 AM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("AccountInformation-CheckBillDeliveryStatus", "Default");
		next.setDebugId(2252);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2017-AUG-28  11:20:51 AM
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
	 * Last generated by Orchestration Designer at: 2017-AUG-28  11:20:51 AM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(3);
		actions.add(new com.avaya.sce.runtime.varoperations.Assign("CallData:repeatTries", "0", true).setDebugId(5305));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "EPM_Alarm:Flag", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:True", true).setDebugId(6186)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.tracking.ReportAlarmInfo(com.avaya.sce.runtimecommon.IReportInfo.ALARM_LEVEL_CRITICAL, "WS Down|Account Information flow|AccessHost_DeliveryStatus|", "EPM_Alarm:Description", true).setDebugId(6187));
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("EPM_Alarm:Flag", "Constants:False", false).setDebugId(6188));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		}


		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "Flag:isLinkDown", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:yes", true).setDebugId(4976)).evaluate(mySession)) {
			actions = new java.util.ArrayList(3);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("CallData:transferReasonCode", "TR_0025", true).setDebugId(5133));
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("Flag:isLinkDown", "Constants:no", false).setDebugId(5856));
			actions.add(new com.avaya.sce.runtime.Next("AccountInformation-PushSMSDeliveryStatusLinkDown", "LinkDown").setDebugId(4977));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		}

		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
