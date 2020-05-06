package flow.subflow.PostpaidAccountInformation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.servion.rcom.ppp.hostinterface.view.ReqLastThreeTransactions;
import com.servion.rcom.ppp.hostinterface.view.ResLastThreeTransactions;
import com.servion.rcom.ppp.hostinterface.view.TransactionDetails;
import com.servion.rcom.ppp.hostinterface.wrapper.IVRWebService;
import com.servion.rcom.ppp.hostinterface.wrapper.IVRWebServiceImpl;
import com.servion.util.AppConstant;
import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;
import com.servion.util.SetPushSMS;
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
 * Last generated by Orchestration Designer at: 2015-MAY-04  07:43:15 PM
 */
public class AccessHost_CheckPayment extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS
	
	@Override
	public void requestBegin(SCESession mySession) {
		super.requestBegin(mySession);
		
		ITraceInfo info = mySession.getTraceOutput();
		
		IVRDataBean ivrDataBean = null;
		ReqLastThreeTransactions reqLastThreeTransactions = null;
		ResLastThreeTransactions resLastThreeTransactions = null;
		IVRWebService ivrWebService = null;
		ArrayList<TransactionDetails> arrayTransactionDetails = null;
		String strPaymentDate = "", strFlag = "";
		Date callDate = null, paymentDate = null;
		SetPushSMS setPushSMS = null;
		String strSMSFrame = "";
		ArrayList<String> arrSMSData = null;
		Hashtable<String, String> smsHashTable = null;
		AppProperties appProperties = null;
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = null;
		Hashtable<String, Hashtable<String, String>> smsHashTableDataIndexMap = null;
		
		try {
			
			setPushSMS = new SetPushSMS();
			arrSMSData = new ArrayList<String>();
			smsHashTableDataIndexMap = new Hashtable<String, Hashtable<String,String>>();
			appProperties = AppProperties.GetInstance(AppConstant.IVR_CONFIG);
			
			callDate = new Date();
			dateFormat = new SimpleDateFormat("dd/MM/yy");
			callDate = dateFormat.parse(dateFormat.format(callDate));
			ivrDataBean = (IVRDataBean) mySession.getProperty(AppConstant.IVRDATABEAN);
			reqLastThreeTransactions = new ReqLastThreeTransactions();
			if(mySession.getVariableField(IProjectVariables.IVR__CSP__DETAILS, IProjectVariables.IVR__CSP__DETAILS_FIELD_RETENTION_LIST).getStringValue().equalsIgnoreCase("RTN"))
			{
				reqLastThreeTransactions.setMDN(mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_ANI).getStringValue());
			}
			else
			{
				reqLastThreeTransactions.setMDN(mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_MOBILE_NO).getStringValue());
			}
			
			ivrWebService = new IVRWebServiceImpl();
			resLastThreeTransactions = ivrWebService.executeLastThreeTransactions(ivrDataBean, reqLastThreeTransactions);
			
			if((resLastThreeTransactions.getResponseCode()).equals(AppConstant.zero)){
				
				arrayTransactionDetails = resLastThreeTransactions.getTransactionDetailsList();
				mySession.getVariableField(IProjectVariables.CHECK_PAYMENT, IProjectVariables.CHECK_PAYMENT_FIELD_AMOUNT).setValue(arrayTransactionDetails.get(0).getAmount());
				mySession.getVariableField(IProjectVariables.CHECK_PAYMENT, IProjectVariables.CHECK_PAYMENT_FIELD_PAYMENT_TYPE).setValue(arrayTransactionDetails.get(0).getPmtType());
				
				strSMSFrame = appProperties.getIVRProp(AppConstant.CHECK_PAYMENT_Success);
				for (int i = 0; i < resLastThreeTransactions.getTransactionDetailsList().size(); i++) {
					arrSMSData = new ArrayList<String>();
					arrSMSData.add(resLastThreeTransactions.getTransactionDetailsList().get(i).getAmount());
					arrSMSData.add(resLastThreeTransactions.getTransactionDetailsList().get(i).getPmtReceivedDate());
					arrSMSData.add(resLastThreeTransactions.getTransactionDetailsList().get(i).getPmtReceivedDate());
					smsHashTable = setPushSMS.generatePushSMSDataMap(strSMSFrame, arrSMSData);
					smsHashTableDataIndexMap.put(""+i, smsHashTable);
				}
				mySession.setProperty(AppConstant.SMSDataIndexMap, smsHashTableDataIndexMap);
				
				info.writeln(ITraceInfo.TRACE_LEVEL_INFO, "SMS HASH TABLE DATA : " +smsHashTableDataIndexMap);
				paymentDate = dateFormat.parse(arrayTransactionDetails.get(0).getPmtReceivedDate());
				cal.setTime(paymentDate);
				cal.add(Calendar.DATE, 6);
				paymentDate = cal.getTime();
				
				if(callDate.getTime()<=paymentDate.getTime()){
					strFlag = AppConstant.Yes;
					/*strSMSFrame = appProperties.getIVRProp(Constants.CHECK_PAYMENT_Success);
					smsHashTable = setPushSMS.generatePushSMSDataMap(strSMSFrame, arrSMSData);*/
					
					mySession.getVariableField(IProjectVariables.CHECK_PAYMENT, IProjectVariables.CHECK_PAYMENT_FIELD_IS_DATE_VALID).setValue(AppConstant.Yes);
				}else{
					strFlag = AppConstant.No;
					
					/*strSMSFrame = appProperties.getIVRProp(Constants.check);
					smsHashTable = setPushSMS.generatePushSMSDataMap(strSMSFrame, arrSMSData);*/
					
					mySession.getVariableField(IProjectVariables.CHECK_PAYMENT, IProjectVariables.CHECK_PAYMENT_FIELD_IS_DATE_VALID).setValue(AppConstant.No);
				}
				
				strPaymentDate = arrayTransactionDetails.get(0).getPmtReceivedDate();
				paymentDate = dateFormat.parse(strPaymentDate);
				dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				strPaymentDate = dateFormat.format(paymentDate);
				
				mySession.getVariableField(IProjectVariables.CHECK_PAYMENT, IProjectVariables.CHECK_PAYMENT_FIELD_PAYMENT_RECEIVED_DATE).setValue(strPaymentDate);
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->CheckPayment Amount :"+arrayTransactionDetails.get(0).getAmount()+", received date: "+arrayTransactionDetails.get(0).getPmtReceivedDate());
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->payment type :"+arrayTransactionDetails.get(0).getPmtType()+", is call date < = payment date+6 days :"+strFlag);
				
			}else{
				mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(AppConstant.Yes);
			}
			

			
		} catch (Exception e) {
			StackTrace.PrintException(e);
			mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(AppConstant.Yes);
		}
	}


	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-04  07:43:15 PM
	 */
	public AccessHost_CheckPayment() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-JUL-05  10:39:11 AM
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
	 * Last generated by Orchestration Designer at: 2017-JUL-05  10:39:11 AM
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
	 * Last generated by Orchestration Designer at: 2017-JUL-05  10:39:11 AM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(3);
		actions.add(new com.avaya.sce.runtime.varoperations.Assign("CallData:globalMenuType", "Constants:FeatureLevel", false).setDebugId(4488));
		actions.add(new com.avaya.sce.runtime.varoperations.Assign("CallData:repeatTries", "0", true).setDebugId(5308));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "Flag:isLinkDown", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:yes", true).setDebugId(3350)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferReason", "TR_0042", true).setDebugId(6370));
			actions.add(new com.avaya.sce.runtime.Next("PostpaidAccountInformation-Linkdown", "LinkDown").setDebugId(3351));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("PostpaidAccountInformation-CheckEventBasedIL_CheckPayment", "Continue").setDebugId(3353));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
