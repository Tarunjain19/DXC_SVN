package flow;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.postpaid.model.UpdateLanguage;
import com.rcom.postpaid.resource.IVRDBServiceInstance;
import com.servion.postpaid.utils.AppDataMap;
import com.servion.postpaid.utils.Constants;
import com.servion.postpaid.utils.PrintStackTrace;
import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA;
import com.servion.prepaid.report.IVRREPORTDATA.CALLINFO;
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
 * Last generated by Orchestration Designer at: 2015-APR-13  05:01:31 PM
 */
public class UpdateLanguageInCSP extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	@Override
	public void requestBegin(SCESession mySession) {
		super.requestBegin(mySession);
		
		/*Declaring the variables*/
		UpdateLanguage updateLanguage = null;
		IVRDataBean ivrDataBean = null;
		ITraceInfo info = null;
		String strCurrentLanguage = "";
		CALLINFO callInfo = null;
		IVRREPORTDATA ivrreportdata = null;
		GetReportObject getReportObject = null;
		
		/*Assigning values to variables*/
		info = mySession.getTraceOutput();
		strCurrentLanguage = mySession.getCurrentLanguage();
		info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "---> LanguageCode:"+AppDataMap.getInstance(Constants.POSTPAID).getAppData(strCurrentLanguage));
		updateLanguage = new UpdateLanguage();
		updateLanguage.setMdn(mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_MDN).getStringValue());
		updateLanguage.setLanguageCode((String) AppDataMap.getInstance(Constants.POSTPAID).getAppData(strCurrentLanguage));
		
		/*Getting call data from sesion*/
		ivrDataBean = (IVRDataBean) mySession.getProperty(Constants.IVRDATABEAN);
		getReportObject = ivrDataBean.getGetReportObject();
		ivrreportdata = getReportObject.getIvrreportdata();
		callInfo = ivrreportdata.getCALLINFO();
		
		try {
			
			/*Invoking the DB dip*/
			updateLanguage = IVRDBServiceInstance.getInstance().updatePreferredLanguage(ivrDataBean, updateLanguage);
			
			if(updateLanguage.getFlag()!=null){
				
				if(updateLanguage.getFlag().equalsIgnoreCase(Constants.Success)){
					mySession.getVariableField(IProjectVariables.CUSTOMER_PROFILE, IProjectVariables.CUSTOMER_PROFILE_FIELD_PREF_LANGUAGE_FLAG).setValue(updateLanguage.getFlag());
					callInfo.setLANGUAGETO(strCurrentLanguage);
				}else{
					mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.Yes);
				}
				
			}else
			{
				mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.Yes);
			}
			
		} catch (Exception e) {
			mySession.getVariableField(IProjectVariables.FLAG, IProjectVariables.FLAG_FIELD_IS_LINK_DOWN).setValue(Constants.Yes);
			PrintStackTrace.PrintException(e);
			info.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "Exception:"+e.getMessage());
		}
		
		
	}
	
	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-APR-13  05:01:31 PM
	 */
	public UpdateLanguageInCSP() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2015-NOV-08  05:50:17 PM
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
	 * Last generated by Orchestration Designer at: 2015-NOV-08  05:50:17 PM
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
	 * Last generated by Orchestration Designer at: 2015-NOV-08  05:50:17 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "Flag:isLinkDown", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:yes", true).setDebugId(5640)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("Flag:isLinkDown", "Constants:no", false).setDebugId(5646));
			actions.add(new com.avaya.sce.runtime.Next("LanguageNotUpdate_PA_0010", "LanguageNotSet").setDebugId(5642));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("Initialize_PA_0009", "LanguageUpdated").setDebugId(489));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
