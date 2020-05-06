package flow.subflow.CreditCardPayment;

import java.util.ArrayList;
import java.util.Hashtable;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.servion.postpaid.utils.Constants;
import com.servion.postpaid.utils.DynamicMenu;
import com.servion.postpaid.utils.PrintStackTrace;
import com.servion.postpaid.utils.SetPushSMS;
import com.servion.rcom.hostinterface.view.CreditCardDetails;
import com.servion.rcom.hostinterface.view.ReqPaymentUsingCreditcard;
import com.servion.rcom.hostinterface.view.ResPaymentUsingCreditcard;
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
 * Last generated by Orchestration Designer at: 2015-APR-16  09:43:55 PM
 */
public class AccessPACE_ValidateCardDetails extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	@Override
	public void requestBegin(SCESession mySession) {

		
		ITraceInfo trace = mySession.getTraceOutput();
		
		String strInitialAudios = "";
		String strAmountEntered = "";
		String strTransactionId = "";
		AppProperties appProperties = null;
		AppProperties ivrProperties = null;
		String strApplicationName = "";
		String hostResponse= Constants.ERROR,responseCode = "";
		String mdn = "", strMDNToRecharge = "";
	    String messageText = "";
	    DynamicMenu dynamicMenu = null;
	    ArrayList<String> dynamicValueList = null;
		
		//Host Interaction Objects.....
	    ReqPaymentUsingCreditcard reqPaymentUsingCreditcard = null;
	    ResPaymentUsingCreditcard resPaymentUsingCreditcard = null;
		IVRWebService ivrWebService = null;
		IVRDataBean objIVRDataBean = null;
		String rcType = Constants.EMPTY_STRING;
		String amount = Constants.EMPTY_STRING;
		String cardNumber = Constants.EMPTY_STRING;
		CreditCardDetails objCreditCardDetails = null;
		
		String strSMSFrame = "";
		ArrayList<String> arrSMSData = null;
		Hashtable<String, String> smsHashTable = null;
		SetPushSMS setPushSMS = null;
		
		try
		{
			setPushSMS = new SetPushSMS();
			arrSMSData = new ArrayList<String>();
			
			dynamicMenu = new DynamicMenu();
			dynamicValueList = new ArrayList<String>();
			
			//Request Processing ......
			appProperties = (AppProperties) mySession.getProperty(Constants.AudioPropertyInstance);
			ivrProperties = (AppProperties) mySession.getProperty(Constants.IvrPropertyInstance);
			
			strApplicationName = mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_APPLICATION_NAME).getStringValue();
			mdn =  mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_MDN).getStringValue();
			objIVRDataBean = (IVRDataBean)mySession.getProperty(Constants.IVRDATABEAN);
			rcType = mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_REQUEST_TYPE).getStringValue();
					//"TOPUP";
			amount = mySession.getVariableField(IProjectVariables.COLLECT_AMOUNT__MN___0_0_3_7,IProjectVariables.COLLECT_AMOUNT__MN___0_0_3_7_FIELD_VALUE).getStringValue();
			cardNumber = mySession.getVariableField(IProjectVariables.COLLECT_CARD_NO__MN___0_0_3_3,IProjectVariables.COLLECT_CARD_NO__MN___0_0_3_3_FIELD_VALUE).getStringValue();
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Payment Using credit Card RC Type :: "+rcType);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Payment Using credit Card Amount:: "+amount);
			
			strMDNToRecharge = mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_NUMBER_VERIFICATION_MDN).getStringValue();
			if(!strMDNToRecharge.equals("0")){
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "MDN Changed to "+strMDNToRecharge);
			}else{
				strMDNToRecharge = mdn;
			}
				
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "MDN to be recharged with "+strMDNToRecharge);
			
			objCreditCardDetails = new CreditCardDetails();
			objCreditCardDetails.setCardNumber(cardNumber);
			objCreditCardDetails.setCardExpiryDate(mySession.getVariableField(IProjectVariables.EXPIRY_DATE__MN___0_0_3_4,IProjectVariables.EXPIRY_DATE__MN___0_0_3_4_FIELD_VALUE).getStringValue());
			objCreditCardDetails.setCardCVV(mySession.getVariableField(IProjectVariables.COLLECT_CVV__MN___0_0_3_5,IProjectVariables.COLLECT_CVV__MN___0_0_3_5_FIELD_VALUE).getStringValue());
			
			if(cardNumber!=null && cardNumber.startsWith(Constants.five)){
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Starts with 5");
				objCreditCardDetails.setCardType(Constants.M);
			}else if (cardNumber!=null && cardNumber.startsWith(Constants.four)){
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Starts with 4");
				objCreditCardDetails.setCardType(Constants.V);
			}
			
			reqPaymentUsingCreditcard = new ReqPaymentUsingCreditcard();
			reqPaymentUsingCreditcard.setMDN(mdn);
			reqPaymentUsingCreditcard.setMDNToBeRecharged(strMDNToRecharge);
			reqPaymentUsingCreditcard.setRcType(rcType);
			reqPaymentUsingCreditcard.setOTP(mySession.getVariableField(IProjectVariables.COLLECT_OTP__MN___0_0_3_6,IProjectVariables.COLLECT_OTP__MN___0_0_3_6_FIELD_VALUE).getStringValue());
			reqPaymentUsingCreditcard.setAmount(amount);
			reqPaymentUsingCreditcard.setCreditCardDetails(objCreditCardDetails);
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Payment Using credit Card Host request :: "+reqPaymentUsingCreditcard.toString());
			
			//Response Processing ......
			ivrWebService = new IVRWebServiceImpl();
			resPaymentUsingCreditcard = ivrWebService.executePaymentUsingCreditcard(objIVRDataBean,reqPaymentUsingCreditcard);
						
			//moving to complex variable
			if(resPaymentUsingCreditcard!= null){
				
				responseCode = resPaymentUsingCreditcard.getResponseCode();
				mySession.getVariableField(IProjectVariables.VALIDATE_CREDIT_CARD, IProjectVariables.VALIDATE_CREDIT_CARD_FIELD_ERROR_CODE).setValue(responseCode);
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, " Response Code :: "+responseCode);

				if((Constants.zero).equals(responseCode)){
					strInitialAudios = appProperties.getIVRProp(strApplicationName+Constants.HYPEN+Constants.PA_0081);
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, " message Text :: "+resPaymentUsingCreditcard.getPaymentId());
					dynamicValueList.add(resPaymentUsingCreditcard.getPaymentId());
					strInitialAudios = dynamicMenu.playPrompt(dynamicValueList, strInitialAudios, ""+dynamicValueList.size(), trace);
					mySession.getVariableField(IProjectVariables.DMPROPERTIES, IProjectVariables.DMPROPERTIES_FIELD_INITIAL_AUDIOS).setValue(strInitialAudios);
					
					arrSMSData.add(amount);
					strSMSFrame = ivrProperties.getIVRProp(Constants.CARD_PAYMENT_Success);
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "SMS Frame:"+strSMSFrame);
					smsHashTable = setPushSMS.generatePushSMSDataMap(strSMSFrame, arrSMSData);
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "SMS Frame:"+smsHashTable);
					
				}/*else if((Constants.one).equals(responseCode)) {
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Response Code is not zero");
					mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.Yes);
				}*/else{
					
					mySession.getVariableField(IProjectVariables.VALIDATE_CREDIT_CARD, IProjectVariables.VALIDATE_CREDIT_CARD_FIELD_ERROR_CODE).setValue(responseCode);
				}
			}else{
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Payment Using credit card Response Object null");
				mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.Yes);
			}
			
		}
		catch(Exception e){
			strSMSFrame = appProperties.getIVRProp(Constants.CARD_PAYMENT_Failure);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "SMS Frame:"+strSMSFrame);
			smsHashTable = setPushSMS.generatePushSMSDataMap(strSMSFrame, arrSMSData);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "SMS Frame:"+smsHashTable);
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "Exception In Payment Using CoreBalance :"+e);
			mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.Yes);
			PrintStackTrace.PrintException(e);
		}finally{
			mySession.setProperty(Constants.SMSDataMap, smsHashTable);
		}
	
	}
	
	/*@Override
	public void requestBegin(SCESession mySession) {
		super.requestBegin(mySession);
		
		Declaring variables
		String strInitialAudios = "";
		String strAmountEntered = "";
		String strTransactionId = "";
		AppProperties appProperties = null;
		String strApplicationName = "";
		
		Assigning values
		appProperties = (AppProperties) mySession.getProperty(Constants.AudioPropertyInstance);
		strAmountEntered = mySession.getVariableField(IProjectVariables.COLLECT_AMOUNT__MN___0_0_3_7, IProjectVariables.COLLECT_AMOUNT__MN___0_0_3_7_FIELD_VALUE).getStringValue();
		strApplicationName = mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_APPLICATION_NAME).getStringValue();
		
		Initializing audio
		strInitialAudios = appProperties.getIVRProp(strApplicationName+Constants.HYPEN+Constants.MN_0038);
		strInitialAudios = strInitialAudios.replaceAll(Constants.TrnsactionID, strTransactionId);
		
		
	}*/
	
	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-APR-16  09:43:55 PM
	 */
	public AccessPACE_ValidateCardDetails() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2015-NOV-08  05:50:22 PM
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
	 * Last generated by Orchestration Designer at: 2015-NOV-08  05:50:22 PM
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
	 * Last generated by Orchestration Designer at: 2015-NOV-08  05:50:22 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "Flag:isLinkDown", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:yes", true).setDebugId(1818)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("CallData:transferReasonCode", "TR_0075", true).setDebugId(2459));
			actions.add(new com.avaya.sce.runtime.Next("CreditCardPayment-PushSMSPayemntFailed", "LinkDown").setDebugId(1817));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "ValidateCreditCard:errorCode", com.avaya.sce.runtime.Expression.STRING_NOT_EQUAL_IGNORE, "0", false).setDebugId(1956)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("CreditCardPayment-CheckResponse", "PlayErrorResponse").setDebugId(1820));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("CreditCardPayment-PushSMSPayemntSuccess", "PaymentSuccess").setDebugId(1958));
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
