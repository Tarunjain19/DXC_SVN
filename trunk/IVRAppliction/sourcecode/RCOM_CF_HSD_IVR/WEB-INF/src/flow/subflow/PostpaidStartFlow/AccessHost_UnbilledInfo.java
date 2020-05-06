package flow.subflow.PostpaidStartFlow;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.servion.hsd.utils.Constants;
import com.servion.hsd.utils.PrintStackTrace;
import com.servion.rcom.hostinterface.view.ReqUnbilledInfo;
import com.servion.rcom.hostinterface.view.ResUnbilledInfo;
import com.servion.rcom.hostinterface.wrapper.IVRWebService;
import com.servion.rcom.hostinterface.wrapper.IVRWebServiceImpl;
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
 * Last generated by Orchestration Designer at: 2015-MAY-24  04:10:54 PM
 */
public class AccessHost_UnbilledInfo extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS
	
	@Override
	public void requestBegin(SCESession mySession) {
		super.requestBegin(mySession);
		
		ITraceInfo info = mySession.getTraceOutput();
		
		IVRDataBean ivrDataBean = null;
		ReqUnbilledInfo reqUnbilledInfo = null;
		ResUnbilledInfo resUnbilledInfo = null;
		IVRWebService ivrWebService = null;
		String strUnbilledDate = "";
		Date unbilledDate = null;
		DateFormat dateFormat = null;
		
		try {
			dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			ivrDataBean = (IVRDataBean) mySession.getProperty(Constants.IVRDATABEAN);
			reqUnbilledInfo = new ReqUnbilledInfo();
			reqUnbilledInfo.setMDN(mySession.getVariableField(IProjectVariables.GET_DATA_CARD, IProjectVariables.GET_DATA_CARD_FIELD_VALUE).getStringValue());
			
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->MDN: "+reqUnbilledInfo.getMDN());
			ivrWebService = new IVRWebServiceImpl();
			resUnbilledInfo = ivrWebService.executeUnbilledInfo(ivrDataBean, reqUnbilledInfo);
			
			mySession.getVariableField(IProjectVariables.POSTPAID__UNBILLED_INFO, IProjectVariables.POSTPAID__UNBILLED_INFO_FIELD_RESPONSE_CODE).setValue(resUnbilledInfo.getResponseCode());
			if((resUnbilledInfo.getResponseCode()).equals(Constants.zero)){
				strUnbilledDate = resUnbilledInfo.getSysDate();
				unbilledDate = dateFormat.parse(strUnbilledDate);
				dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				strUnbilledDate = dateFormat.format(unbilledDate);
				mySession.getVariableField(IProjectVariables.POSTPAID__UNBILLED_INFO, IProjectVariables.POSTPAID__UNBILLED_INFO_FIELD_UNBILLED_AMOUNT).setValue(resUnbilledInfo.getUnBilledAmount());
				mySession.getVariableField(IProjectVariables.POSTPAID__UNBILLED_INFO, IProjectVariables.POSTPAID__UNBILLED_INFO_FIELD_DATE).setValue(strUnbilledDate);
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->Unbilled Amount: "+resUnbilledInfo.getUnBilledAmount()+", Date: "+resUnbilledInfo.getSysDate());
			}else{
				mySession.getVariableField(IProjectVariables.POSTPAID__FLAG, IProjectVariables.POSTPAID__FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.Yes);
			}
		} catch (Exception e) {
			PrintStackTrace.PrintException(e);
			mySession.getVariableField(IProjectVariables.POSTPAID__FLAG, IProjectVariables.POSTPAID__FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.Yes);
		}
	}


	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-24  04:10:54 PM
	 */
	public AccessHost_UnbilledInfo() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:39:05 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("PostpaidStartFlow-AccessHost_CreditLimit", "Coninue");
		next.setDebugId(6793);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:39:05 PM
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
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:39:05 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "Postpaid_Flag:isLinkDown", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Postpaid_Constants:yes", true).setDebugId(6791)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("PostpaidStartFlow-Initialize_MN_0005", "LinkDown").setDebugId(6792));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		}

		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
