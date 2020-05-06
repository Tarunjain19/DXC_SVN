package flow;

import java.util.ArrayList;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.broadband.Constants;
import com.rcom.broadband.StackTrace;
import com.servion.rcom.broadband.hostinterface.view.CreditCardDetails;
import com.servion.rcom.broadband.hostinterface.view.ReqPaymentUsingCreditcard;
import com.servion.rcom.broadband.hostinterface.view.ResPaymentUsingCreditcard;
import com.servion.rcom.broadband.hostinterface.wrapper.IVRWebService;
import com.servion.rcom.broadband.hostinterface.wrapper.IVRWebServiceImpl;
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
 * Last generated by Orchestration Designer at: 2015-MAY-24  03:35:10 PM
 */
public class WS_ProcessPayment extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-24  03:35:10 PM
	 */
	public WS_ProcessPayment() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	@Override
	public void requestBegin(SCESession mySession) {
	
		String WS_Result = Constants.FAILURE;
		AppProperties ivrProperties = null;
		IVRWebService ivrWebService = null;
		ReqPaymentUsingCreditcard reqPaymentUsingCreditcard =  null;
		ResPaymentUsingCreditcard resPaymentUsingCreditcard = null;
		CreditCardDetails creditCardDetails = null;
		
		/** Card Details **/		
		String cardCVV = null;
		String cardExpiryDate = null;
		String cardNumber = null;
		String cardType = null;
		
		/** Details necessary for payment **/
		String mdn = null;
		String lastBillAmount = null;
		String OTP = null;
		String rcType = null;
		String subscriberID = null;
		
		String responseCode = null;
		String transactionID = null;
		
		String appName = null;
		String key = null;
		String initialPrompt = null;
		ArrayList<String> dynamicList = new ArrayList<String>();
		
		try
		{
		
			ITraceInfo trace = mySession.getTraceOutput();
			ivrProperties = AppProperties.GetInstance(Constants.IVR_CONFIG);
			mdn = mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_ANI).getStringValue();
			appName = ivrProperties.getIVRProp(Constants.APP_NAME);
			subscriberID = mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_SUBSCRIBER_ID).getStringValue();
			
			cardCVV = mySession.getVariableField(IProjectVariables.GET_CVV__PC, IProjectVariables.GET_CVV__PC_FIELD_VALUE).getStringValue();
			cardExpiryDate = mySession.getVariableField(IProjectVariables.GET_EXPIRY_DATE__PC, IProjectVariables.GET_EXPIRY_DATE__PC_FIELD_VALUE).getStringValue();
			
			cardNumber = mySession.getVariableField(IProjectVariables.GET_CREDIT_CARD_NO__PC, IProjectVariables.GET_CREDIT_CARD_NO__PC_FIELD_VALUE).getStringValue();
			
			if(cardNumber.startsWith(Constants.VISA_CARD_STARTS_WITH))
			{
				cardType = ivrProperties.getIVRProp(Constants.CARD_TYPE_VISA);
			}
			else if (cardNumber.startsWith(Constants.MASTER_CARD_STARTS_WITH))
			{
				cardType = ivrProperties.getIVRProp(Constants.CARD_TYPE_MASTER);
			}
			else
			{
				cardType = ivrProperties.getIVRProp(Constants.CARD_TYPE_AMEX);
			}
			
			lastBillAmount = mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_LAST_BILL_AMOUNT).getStringValue();
			OTP = mySession.getVariableField(IProjectVariables.GET_OTP__PC, IProjectVariables.GET_OTP__PC_FIELD_VALUE).getStringValue();
			rcType = ivrProperties.getIVRProp(Constants.BILL_PAYMENT_RC_TYPE); 
			
			ivrWebService = new IVRWebServiceImpl();
			reqPaymentUsingCreditcard = new ReqPaymentUsingCreditcard();
			creditCardDetails = new CreditCardDetails();
			
			creditCardDetails.setCardCVV(cardCVV);
			creditCardDetails.setCardExpiryDate(cardExpiryDate);
			creditCardDetails.setCardNumber(cardNumber);
			creditCardDetails.setCardType(cardType);
			
			reqPaymentUsingCreditcard.setMDN(mdn);
			reqPaymentUsingCreditcard.setMDNToBeRecharged(subscriberID);
			reqPaymentUsingCreditcard.setRcType(rcType);
			reqPaymentUsingCreditcard.setOTP(OTP);
			reqPaymentUsingCreditcard.setAmount(lastBillAmount);
			reqPaymentUsingCreditcard.setCreditCardDetails(creditCardDetails);
			
			resPaymentUsingCreditcard = ivrWebService.executePaymentUsingCreditcard((IVRDataBean)mySession.getProperty(Constants.IVR_DATA_BEAN), reqPaymentUsingCreditcard);
			
			responseCode = resPaymentUsingCreditcard.getResponseCode();
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Execute Bill Payment by Credit Card Response Code : " +responseCode);
			
			
			
			if(responseCode.equalsIgnoreCase(Constants.WS_RESPONSE_SUCCESS))
			{
				WS_Result = Constants.SUCCESS;
				
				mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_PAYMENT_RETURNCODE).setValue(mySession.getVariableField(IProjectVariables.CONSTANTS, IProjectVariables.CONSTANTS_FIELD_PAYMENT_CODE__SUCCESS).getStringValue());
				
				transactionID = resPaymentUsingCreditcard.getPaymentId();
				
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "transactionID : " +transactionID);
				
				/*key = appName+Constants.HYPEN_SEPERATOR+Constants.DAKC_PA_0029;
				initialPrompt = ivrProperties.getIVRProp(key);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Dynamic Prompt Key : "+key);
				dynamicList.add(transactionID);
				
				*//** Invoking the playPromt method **//*
				initialPrompt = DynamicMenu.playPrompt(dynamicList, initialPrompt, Constants.NA, Constants.DAKC_PA_0029, trace);
				
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Initial Prompt returned from Dynamic formation : " +initialPrompt);
				
				mySession.getVariableField(IProjectVariables.DM__INPUT, IProjectVariables.DM__INPUT_FIELD_DM__INITIAL_PROMPT).setValue(initialPrompt);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Initial Prompt :: "+initialPrompt);*/
				
				
				
			}
			else if(responseCode.equalsIgnoreCase(Constants.WS_RESPONSE_HOST_TIMEOUT_PAYMENT))
			{
				WS_Result = Constants.FAILURE;
			}
			else
			{
				WS_Result = Constants.SUCCESS;
				
				mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_PAYMENT_RETURNCODE).setValue(responseCode);
				
			}
			
			mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_WS__RESULT).setValue(WS_Result);
			
		}catch(Exception e)
		{
			StackTrace.PrintException(e);
			mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_WS__RESULT).setValue(Constants.FAILURE);
		}
		
		
	}
	
	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2016-SEP-28  04:13:56 PM
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
	 * Last generated by Orchestration Designer at: 2016-SEP-28  04:13:56 PM
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
	 * Last generated by Orchestration Designer at: 2016-SEP-28  04:13:56 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "appVariables:WS_Result", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constants:success", true).setDebugId(4418)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:tries", "constants:One", false).setDebugId(4574));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "appVariables:paymentReturncode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constants:PaymentCode_Success", true).setDebugId(4421)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("AnnounceTransactionID_PP", "(Payment Success)").setDebugId(4422));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("SetPaymentFailureReason", "(Payment Failure)").setDebugId(4430));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


		} else {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "TransferCodes:DAKC_TR_0065", false).setDebugId(4420));
			actions.add(new com.avaya.sce.runtime.Next("Linkdown_PP", "(Timeout)").setDebugId(4416));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
