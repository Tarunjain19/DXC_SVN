package flow;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.servion.postpaid.utils.Constants;
import com.servion.postpaid.utils.PrintStackTrace;
import com.servion.rcom.hostinterface.view.ReqStorePTP;
import com.servion.rcom.hostinterface.view.ResStorePTP;
import com.servion.rcom.hostinterface.wrapper.IVRWebService;
import com.servion.rcom.hostinterface.wrapper.IVRWebServiceImpl;
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
 * Last generated by Orchestration Designer at: 2015-MAY-29  04:43:47 PM
 */
public class AccessHost_PTP extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS
	
	@Override
	public void requestBegin(SCESession mySession) {
		super.requestBegin(mySession);
		
		ITraceInfo info = mySession.getTraceOutput();
		
		IVRDataBean ivrDataBean = null;
		ReqStorePTP reqStorePTP = null;
		ResStorePTP resStorePTP = null;
		IVRWebService ivrWebService = null;
		String strPTPAmount = "", strMode = "";
		
		
		try {
			
			strPTPAmount = mySession.getVariableField(IProjectVariables.PROMISE_TO_PAY__MN___0_0_4_0, IProjectVariables.PROMISE_TO_PAY__MN___0_0_4_0_FIELD_VALUE).getStringValue();
			strMode = mySession.getVariableField(IProjectVariables.MODE_TO_PAY__MN___0_0_4_2, IProjectVariables.MODE_TO_PAY__MN___0_0_4_2_FIELD_VALUE).getStringValue();
			ivrDataBean = (IVRDataBean) mySession.getProperty(Constants.IVRDATABEAN);
			reqStorePTP = new ReqStorePTP();
			reqStorePTP.setMDN(mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_MDN).getStringValue());
			reqStorePTP.setPtpAmount(strPTPAmount);
			
			reqStorePTP.setPtpByCash(false);
			reqStorePTP.setPtpByCheque(false);
			reqStorePTP.setPtpByCreditCard(false);
			reqStorePTP.setPtpByDebitCard(false);
			
			if(strMode.equalsIgnoreCase("Cash"))
				reqStorePTP.setPtpByCash(true);
			else if(strMode.equalsIgnoreCase("Cheque"))
				reqStorePTP.setPtpByCheque(true);
			else if(strMode.equalsIgnoreCase("CreditCard"))
				reqStorePTP.setPtpByCreditCard(true);
			else
				reqStorePTP.setPtpByDebitCard(true);
			
			ivrWebService = new IVRWebServiceImpl();
			resStorePTP = ivrWebService.executeStorePTP(ivrDataBean, reqStorePTP);
			
			if(resStorePTP != null){
				if(resStorePTP.getResponseCode().equals(Constants.zero)){
					mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_PTP_FLAG).setValue(Constants.Success);
				}else if(resStorePTP.getResponseCode().equals(Constants.one)){
					mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.Yes);
				}else{
					mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_PTP_FLAG).setValue(Constants.Failure);
				}
				
			}else{
				mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.Yes);
			}
		} catch (Exception e) {
			PrintStackTrace.PrintException(e);
			mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.Yes);
		}
		
		
	}

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-29  04:43:47 PM
	 */
	public AccessHost_PTP() {
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

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "Flag:isLinkDown", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:yes", true).setDebugId(2384)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("CallData:transferReasonCode", "TR_0021", true).setDebugId(3530));
			actions.add(new com.avaya.sce.runtime.Next("Initialize_MN_0005", "Linkdown").setDebugId(2383));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "Flag:ptpFlag", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:success", true).setDebugId(3537)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("Initialize_MN_0005", "Continue").setDebugId(2386));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("PTPLinkDown_PA_0087", "Failed").setDebugId(3539));
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