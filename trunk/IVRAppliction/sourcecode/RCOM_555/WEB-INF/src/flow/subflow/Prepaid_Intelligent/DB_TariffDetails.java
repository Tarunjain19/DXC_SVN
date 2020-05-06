package flow.subflow.Prepaid_Intelligent;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.hni.model.TariffChangeDetail;
import com.rcom.hni.resource.IVRDBServiceInstance;
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
 * Last generated by Orchestration Designer at: 2015-MAR-13  01:15:36 AM
 */
public class DB_TariffDetails extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAR-13  01:15:36 AM
	 */
	public DB_TariffDetails() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:56 PM
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
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:56 PM
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
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:56 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(3);
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_INFO, "TariffDetails Host Result :", "Prepaid_appVariables:HostResult").setDebugId(341));
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_INFO, "tariff Available flag :", "Prepaid_Flag:tariffAvailable").setDebugId(540));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "Prepaid_appVariables:HostResult", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Prepaid_constant:success", true).setDebugId(337)).evaluate(mySession)) {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "Prepaid_Flag:tariffAvailable", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Prepaid_constant:Key_true", true).setDebugId(537)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("Prepaid_Intelligent-AnnoTariffDetailWave", "AnnoTariff").setDebugId(338));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("Prepaid_Intelligent-Host_PackRenewal", "PackRenewal").setDebugId(539));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("Prepaid_Intelligent-MainMenu", "return").setDebugId(340));
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

		
		/**Declaration **/
		String hostOutput = AppConstant.ERROR,circleID = AppConstant.EMPTY_STRING;
		String lang = AppConstant.EMPTY_STRING;
		String ani =  AppConstant.EMPTY_STRING, tariffWave = AppConstant.EMPTY_STRING;
		TariffChangeDetail objTariffChangeDetail = null;
		IVRDataBean objIVRDataBean = null;
		ITraceInfo trace = mySession.getTraceOutput();
		
		try {
			
			/**Assigning**/
			ani = mySession.getVariableField(IProjectVariables.PREPAID__APP_VARIABLES,IProjectVariables.PREPAID__APP_VARIABLES_FIELD_ANI).getStringValue();
			circleID = mySession.getVariableField(IProjectVariables.PREPAID__APP_VARIABLES,IProjectVariables.PREPAID__APP_VARIABLES_FIELD_CIRCLE_ID).getStringValue();
			lang = mySession.getCurrentLanguage();
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"ANI :"+ani);
			objTariffChangeDetail = new TariffChangeDetail();
			objIVRDataBean = (IVRDataBean)mySession.getProperty(AppConstant.IVRDATABEAN);
			
			objTariffChangeDetail.setMdn(ani);
			objTariffChangeDetail.setCircleId(circleID);
			objTariffChangeDetail.setLanguageid(lang);
			
			/**DB Hit**/

			objTariffChangeDetail = IVRDBServiceInstance.getInstance().getTariffChangeDetail(objIVRDataBean,objTariffChangeDetail);
			if(objTariffChangeDetail!=null){
				tariffWave=objTariffChangeDetail.getTariffDetailPhrase();
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"tariff Wave Phrase ID:"+tariffWave);
				
				if(tariffWave!=null && !AppConstant.EMPTY_STRING.equals(tariffWave) && !AppConstant.NA.equals(tariffWave)){
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"tariff Info Available");
					mySession.getVariableField(IProjectVariables.PREPAID__FLAG,IProjectVariables.PREPAID__FLAG_FIELD_TARIFF_AVAILABLE).setValue(AppConstant.TRUE);
					mySession.getVariableField(IProjectVariables.PREPAID__DM_INPUT_PARAMETER,IProjectVariables.PREPAID__DM_INPUT_PARAMETER_FIELD_INITIAL_PROMPT).setValue(tariffWave);
				}
				hostOutput = AppConstant.Success;
			}
			else{
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"TariffChangeDetail Object is null");
			}
		} catch (Exception e) {
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "Error in Tariff Change Detail :" +e);
			PrintStackTrace.PrintException(e);
		}finally{
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Host Status :" +hostOutput);
			mySession.getVariableField(IProjectVariables.PREPAID__APP_VARIABLES,IProjectVariables.PREPAID__APP_VARIABLES_FIELD_HOST_RESULT).setValue(hostOutput);	
		}
		
	
		
	}
}