package flow;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.util.AppConstant;
import com.rcom.util.DynamicMenu;
import com.rcom.util.StackTrace;
import com.servion.rcom.smartphone.hostinterface.view.ReqLastPaymentDetails;
import com.servion.rcom.smartphone.hostinterface.view.ResLastPaymentDetails;
import com.servion.rcom.smartphone.hostinterface.wrapper.IVRWebService;
import com.servion.rcom.smartphone.hostinterface.wrapper.IVRWebServiceImpl;
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
		
		ReqLastPaymentDetails reqLastPaymentDetails = null;
		ResLastPaymentDetails resLastTransactions = null;
		
		IVRWebService ivrWebService = null;
		String strPaymentDate = "", strInitialAudio = "";
		Date paymentDate = null;
		String strSMSFrame = "";
		ArrayList<String> dynamicAudioList = null;
		Hashtable<String, String> smsHashTable = null;
		AppProperties appProperties = null;
		DateFormat dateFormat = null;
		
		
		
		try {
			
			appProperties = (AppProperties) mySession.getProperty(AppConstant.DYN_MENU);
			dynamicAudioList = new ArrayList<String>();

			strInitialAudio = AppProperties.GetInstance(AppConstant.DYN_MENU).getIVRProp(AppConstant.LASTPAYMENT);
			
			paymentDate = new Date();
			dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			ivrDataBean = (IVRDataBean) mySession.getProperty(AppConstant.IVRDATABEAN);
			reqLastPaymentDetails = new ReqLastPaymentDetails();
			reqLastPaymentDetails.setMDN(mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_ANI).getStringValue());
			
			ivrWebService = new IVRWebServiceImpl();
			resLastTransactions = ivrWebService.executeLastPaymentInfo(ivrDataBean, reqLastPaymentDetails);
			
			if((resLastTransactions.getResponseCode()).equals(AppConstant.zero)){
				
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Last payment amount:"+resLastTransactions.getLastPaymentAmount()+", Last payment date:"+resLastTransactions.getPaymentReceivedDate());
				
				strPaymentDate = resLastTransactions.getPaymentReceivedDate();
				
				
				
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Last payment amount:"+resLastTransactions.getLastPaymentAmount()+", Last payment date:"+strPaymentDate);
				
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Last payment amount:"+resLastTransactions.getLastPaymentAmount()+", Last payment date:"+resLastTransactions.getPaymentReceivedDate());
				mySession.getVariableField(IProjectVariables.LAST_PAYMENT, IProjectVariables.LAST_PAYMENT_FIELD_PAYMENT_AMOUNT).setValue(resLastTransactions.getLastPaymentAmount());
				mySession.getVariableField(IProjectVariables.LAST_PAYMENT, IProjectVariables.LAST_PAYMENT_FIELD_DATE).setValue(resLastTransactions.getPaymentReceivedDate());
				
				dynamicAudioList.add(resLastTransactions.getLastPaymentAmount()+AppConstant.currency);
				strInitialAudio = DynamicMenu.playPrompt(dynamicAudioList, strInitialAudio, dynamicAudioList.size()+"", info);
				
				mySession.getVariableField(IProjectVariables.DM__INPUT_PATH, IProjectVariables.DM__INPUT_PATH_FIELD_DM__INITIAL_PROMPT).setValue(strInitialAudio);
				mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_HOST_RESULT).setValue(AppConstant.Success);
				
				}else{
					mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_HOST_RESULT).setValue(AppConstant.FAILED);
				}
				
		} catch (Exception e) {
			StackTrace.PrintException(e);
			mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_HOST_RESULT).setValue(AppConstant.FAILED);
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
	 * Last generated by Orchestration Designer at: 2016-JAN-25  06:26:31 PM
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
	 * Last generated by Orchestration Designer at: 2016-JAN-25  06:26:31 PM
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
	 * Last generated by Orchestration Designer at: 2016-JAN-25  06:26:31 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "appVariables:HostResult", com.avaya.sce.runtime.Expression.STRING_NOT_EQUAL_IGNORE, "Constants:Success", true).setDebugId(8452)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "SPIVR_TR_0014", true).setDebugId(8861));
			actions.add(new com.avaya.sce.runtime.Next("LinkDown_PP", "LinkDown").setDebugId(8453));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("LastPaymentInfo", "Continue").setDebugId(8455));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
