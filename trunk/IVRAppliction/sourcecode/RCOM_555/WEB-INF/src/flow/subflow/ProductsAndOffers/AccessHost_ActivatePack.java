package flow.subflow.ProductsAndOffers;

import java.util.ArrayList;
import java.util.Hashtable;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.servion.rcom.hni.hostinterface.view.ReqPaymentUsingCoreBalance;
import com.servion.rcom.hni.hostinterface.view.ResPaymentUsingCoreBalance;
import com.servion.rcom.hni.hostinterface.wrapper.IVRWebService;
import com.servion.rcom.hni.hostinterface.wrapper.IVRWebServiceImpl;
import com.servion.triplefive.utils.Constants;
import com.servion.triplefive.utils.PrintStackTrace;
import com.servion.triplefive.utils.SetPushSMS;
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
 * Last generated by Orchestration Designer at: 2015-MAY-14  03:42:00 PM
 */
public class AccessHost_ActivatePack extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS
	
	@Override
	public void requestBegin(SCESession mySession) {
		
		ITraceInfo trace = mySession.getTraceOutput();
		String hostResponse= Constants.ERROR,responseCode = Constants.EMPTY_STRING;
		String mdn ="", strOtherMDN = "";
	    String messageText = Constants.EMPTY_STRING;
		String packName = Constants.EMPTY_STRING;
		
		AppProperties appProperties = null;
		SetPushSMS setPushSMS = null;
		String strSMSFrame = "";
		ArrayList<String> arrSMSData = null;
		Hashtable<String, String> smsHashTable = null;
		
		//Host Interaction Objects.....
	    ReqPaymentUsingCoreBalance reqPaymentUsingCoreBalance = null;
	    ResPaymentUsingCoreBalance resPaymentUsingCoreBalance = null;
		IVRWebService ivrWebService = null;
		IVRDataBean objIVRDataBean = null;
		try
		{
			setPushSMS = new SetPushSMS();
			arrSMSData = new ArrayList<String>();
			appProperties = (AppProperties) mySession.getProperty(Constants.IvrPropertyInstance);
			
			//Request Processing ......
			mdn =  mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_MDN).getStringValue();
			packName = mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_PACK_CODE).getStringValue();
			
			strOtherMDN = mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_NUMBER_VERIFICATION_MDN).getStringValue();
			if(!strOtherMDN.equals("0"))
				mdn = strOtherMDN;
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "--->pack Name :: "+packName);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "--->mdn :: "+mdn );
			
			objIVRDataBean = (IVRDataBean)mySession.getProperty(Constants.IVRDATABEAN);
			reqPaymentUsingCoreBalance = new ReqPaymentUsingCoreBalance();
			reqPaymentUsingCoreBalance.setMDN(mdn);
			reqPaymentUsingCoreBalance.setPackName(packName);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Payment Using CoreBalance request :: "+reqPaymentUsingCoreBalance.toString());
			
			//Response Processing ......
			ivrWebService = new IVRWebServiceImpl();
			resPaymentUsingCoreBalance = ivrWebService.executePaymentUsingCoreBalance(objIVRDataBean,reqPaymentUsingCoreBalance);
		
						
			//moving to complex variable
			if(resPaymentUsingCoreBalance!= null){
				
				responseCode = resPaymentUsingCoreBalance.getResponseCode();
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, " Response Code :: "+responseCode);

				if((Constants.zero).equals(responseCode)){
					
					arrSMSData.add(packName);
					strSMSFrame = appProperties.getIVRProp(Constants.BUY_PACK_Success);
					smsHashTable = setPushSMS.generatePushSMSDataMap(strSMSFrame, arrSMSData);
					
					messageText = resPaymentUsingCoreBalance.getMessageText();
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, " message Text :: "+messageText);
					
				}else{
					strSMSFrame = appProperties.getIVRProp(Constants.BUY_PACK_Failure);
					smsHashTable = setPushSMS.generatePushSMSDataMap(strSMSFrame, arrSMSData);
					mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.Yes);	
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Response Code is not zero");
				}
			}else{
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Payment Using CoreBalance Response Object null");
			}
			
		}
		catch(Exception e)
		{
			strSMSFrame = appProperties.getIVRProp(Constants.BUY_PACK_Failure);
			smsHashTable = setPushSMS.generatePushSMSDataMap(strSMSFrame, arrSMSData);
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "Exception In Payment Using CoreBalance :"+e);
			PrintStackTrace.PrintException(e);
			mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.Yes);	
			
		}finally{
			mySession.setProperty(Constants.SMSDataMap, smsHashTable);
			mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_NUMBER_VERIFICATION_MDN).setValue("0");
		}
		
	}
	
	

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-14  03:42:00 PM
	 */
	public AccessHost_ActivatePack() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:46 PM
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
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:46 PM
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
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:46 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(2);
		actions.add(new com.avaya.sce.runtime.varoperations.Assign("CallData:globalMenuType", "Constants:FeatureLevel", false).setDebugId(2561));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "Flag:isLinkDown", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:yes", true).setDebugId(2021)).evaluate(mySession)) {
			actions = new java.util.ArrayList(3);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("CallData:transferReasonCode", "TR_0072", true).setDebugId(2548));
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("Flag:isLinkDown", "Constants:no", false).setDebugId(2562));
			actions.add(new com.avaya.sce.runtime.Next("ProductsAndOffers-PushSMS_ActivateOfferFailed", "LinkDown").setDebugId(2022));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("ProductsAndOffers-PushSMS_ActivateOfferSuccessful", "Continue").setDebugId(2024));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
