package flow.subflow.PostpaidAccountInformation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.servion.rcom.ppp.hostinterface.view.ReqUnbilledInfo;
import com.servion.rcom.ppp.hostinterface.view.ResUnbilledInfo;
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
 * Last generated by Orchestration Designer at: 2015-APR-16  12:35:35 PM
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
		SetPushSMS setPushSMS = null;
		String strSMSFrame = "";
		ArrayList<String> arrSMSData = null;
		Hashtable<String, String> smsHashTable = null;
		AppProperties appProperties = null;
		
		try {
			
			setPushSMS = new SetPushSMS();
			arrSMSData = new ArrayList<String>();
			
			dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			ivrDataBean = (IVRDataBean) mySession.getProperty(AppConstant.IVRDATABEAN);
			reqUnbilledInfo = new ReqUnbilledInfo();
			if(mySession.getVariableField(IProjectVariables.IVR__CSP__DETAILS, IProjectVariables.IVR__CSP__DETAILS_FIELD_RETENTION_LIST).getStringValue().equalsIgnoreCase("RTN"))
			{
				reqUnbilledInfo.setMDN(mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_ANI).getStringValue());
			}
			else
			{
				reqUnbilledInfo.setMDN(mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_MOBILE_NO).getStringValue());
			}
			
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->MDN: "+reqUnbilledInfo.getMDN());
			ivrWebService = new IVRWebServiceImpl();
			resUnbilledInfo = ivrWebService.executeUnbilledInfo(ivrDataBean, reqUnbilledInfo);
			
			appProperties = AppProperties.GetInstance(AppConstant.IVR_CONFIG);
			
			mySession.getVariableField(IProjectVariables.UNBILLED_INFO, IProjectVariables.UNBILLED_INFO_FIELD_RESPONSE_CODE).setValue(resUnbilledInfo.getResponseCode());
			if((resUnbilledInfo.getResponseCode()).equals(AppConstant.zero)){
				strUnbilledDate = resUnbilledInfo.getSysDate();
				unbilledDate = dateFormat.parse(strUnbilledDate);
				dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				strUnbilledDate = dateFormat.format(unbilledDate);
				
				mySession.getVariableField(IProjectVariables.UNBILLED_INFO, IProjectVariables.UNBILLED_INFO_FIELD_UNBILLED_AMOUNT).setValue(resUnbilledInfo.getUnBilledAmount());
				mySession.getVariableField(IProjectVariables.UNBILLED_INFO, IProjectVariables.UNBILLED_INFO_FIELD_DATE).setValue(strUnbilledDate);
				
				arrSMSData.add(strUnbilledDate);
				arrSMSData.add(resUnbilledInfo.getUnBilledAmount());
				strSMSFrame = appProperties.getIVRProp(AppConstant.UNBILLED_Success);
				smsHashTable = setPushSMS.generatePushSMSDataMap(strSMSFrame, arrSMSData);
				
				info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "--->Unbilled Amount: "+resUnbilledInfo.getUnBilledAmount()+", Date: "+resUnbilledInfo.getSysDate());
			}else{
				
				strSMSFrame = appProperties.getIVRProp(AppConstant.UNBILLED_Failure);
				smsHashTable = setPushSMS.generatePushSMSDataMap(strSMSFrame, arrSMSData);
				
				mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(AppConstant.Yes);
			}
			

		} catch (Exception e) {
			strSMSFrame = appProperties.getIVRProp(AppConstant.UNBILLED_Failure);
			smsHashTable = setPushSMS.generatePushSMSDataMap(strSMSFrame, arrSMSData);
			StackTrace.PrintException(e);
			mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(AppConstant.Yes);
		}finally{
			mySession.setProperty(AppConstant.SMSDataMap, smsHashTable);
		}
	}

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-APR-16  12:35:35 PM
	 */
	public AccessHost_UnbilledInfo() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-JUL-05  10:39:10 AM
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
	 * Last generated by Orchestration Designer at: 2017-JUL-05  10:39:10 AM
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
	 * Last generated by Orchestration Designer at: 2017-JUL-05  10:39:10 AM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(3);
		actions.add(new com.avaya.sce.runtime.varoperations.Assign("CallData:globalMenuType", "Constants:FeatureLevel", false).setDebugId(4382));
		actions.add(new com.avaya.sce.runtime.varoperations.Assign("CallData:repeatTries", "0", true).setDebugId(5299));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "Flag:isLinkDown", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:yes", true).setDebugId(519)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferReason", "TR_0031", true).setDebugId(6361));
			actions.add(new com.avaya.sce.runtime.Next("PostpaidAccountInformation-Linkdown", "LinkDown").setDebugId(524));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("PostpaidAccountInformation-Initialize_PA_0014", "Continue").setDebugId(521));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}