package flow.subflow.Prepaid_VAS;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.servion.rcom.hni.hostinterface.view.ReqGPRSSettingsDownload;
import com.servion.rcom.hni.hostinterface.view.ResGPRSSettingsDownload;
import com.servion.rcom.hni.hostinterface.wrapper.IVRWebService;
import com.servion.rcom.hni.hostinterface.wrapper.IVRWebServiceImpl;
import com.servion.triplefive.utils.AppConstant;
import com.servion.triplefive.utils.PrintStackTrace;
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
 * Last generated by Orchestration Designer at: 2015-APR-08  10:30:29 PM
 */
public class executeGPRSSettingsDownload extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-APR-08  10:30:29 PM
	 */
	public executeGPRSSettingsDownload() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:50 PM
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
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:50 PM
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
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:50 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "Prepaid_appVariables:HostResult", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Prepaid_constant:success", true).setDebugId(4978)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("Prepaid_VAS-PA_0034", "Success").setDebugId(4897));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("Prepaid_appVariables:transferCode", "TR_0063", true).setDebugId(5627));
			actions.add(new com.avaya.sce.runtime.Next("Prepaid_VAS-LinkDown", "exception").setDebugId(4980));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
	@Override
	public void requestBegin(SCESession mySession) {
	
		ITraceInfo trace = mySession.getTraceOutput();
		String hostResult = AppConstant.ERROR;
		String mdn = null;
	
		
		ReqGPRSSettingsDownload reqGPRSSettingsDownload = null;
		ResGPRSSettingsDownload resGPRSSettingsDownload = null;
		IVRWebService webServiceManager = null;
		IVRDataBean objIVRData = null;
		try
		{
			objIVRData = (IVRDataBean) mySession.getProperty(AppConstant.IVRDATABEAN);
			//Request Processing......
			mdn = mySession.getVariableField(IProjectVariables.PREPAID__APP_VARIABLES, IProjectVariables.PREPAID__APP_VARIABLES_FIELD_ANI).getStringValue();
			reqGPRSSettingsDownload = new ReqGPRSSettingsDownload();
			reqGPRSSettingsDownload.setMDN(mdn);
			
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "GPRS Setting Host request :: "+reqGPRSSettingsDownload.toString());
			
			//Response Processing......
			webServiceManager = new IVRWebServiceImpl();
			resGPRSSettingsDownload = webServiceManager.executeGPRSSettingsDownload(objIVRData,reqGPRSSettingsDownload);
			
			if(resGPRSSettingsDownload!=null && AppConstant.zero.equals(resGPRSSettingsDownload.getResponseCode())){
				mySession.getVariableField(IProjectVariables.PREPAID__GET_GPRSSETTINGS, IProjectVariables.PREPAID__GET_GPRSSETTINGS_FIELD_RESPONSE_CODE).setValue(resGPRSSettingsDownload.getResponseCode());
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "GPRS Setting Host response :: "+resGPRSSettingsDownload.getResponseCode());
				hostResult = AppConstant.Success;
			}
		}
		catch(Exception e)
		{
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Error in GPRS Setting Host Hit:: "+e);
			PrintStackTrace.PrintException(e);
		}
		finally
		{
			reqGPRSSettingsDownload = null;
			resGPRSSettingsDownload = null;
			webServiceManager = null;
			mySession.getVariableField(IProjectVariables.PREPAID__APP_VARIABLES,IProjectVariables.PREPAID__APP_VARIABLES_FIELD_HOST_RESULT).setValue(hostResult);
		}
		
		
	}
}