package flow.subflow.Prepaid_Intelligent;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.hni.model.CRMPackInfo;
import com.rcom.hni.resource.IVRDBServiceInstance;
import com.servion.triplefive.utils.AppConstant;
import com.servion.triplefive.utils.Constants;
import com.servion.triplefive.utils.DynamicMenu;
import com.servion.triplefive.utils.PrintStackTrace;
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
 * Last generated by Orchestration Designer at: 2015-APR-06  10:51:57 PM
 */
public class Host_PackRenewal extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-APR-06  10:51:57 PM
	 */
	public Host_PackRenewal() {
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
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_INFO, "Pack Renewal Host Result :", "Prepaid_appVariables:HostResult").setDebugId(553));
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_INFO, "Pack Expiry flag :", "Prepaid_Flag:packExpired").setDebugId(554));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "Prepaid_appVariables:HostResult", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Prepaid_constant:success", true).setDebugId(555)).evaluate(mySession)) {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "Prepaid_Flag:packExpired", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Prepaid_constant:Key_true", true).setDebugId(556)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("Prepaid_Intelligent-AnnoExpireMessage", "AnnoExpiredMge").setDebugId(557));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("Prepaid_Intelligent-MainMenu", "MainMenu").setDebugId(559));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("Prepaid_Intelligent-MainMenu", "return").setDebugId(561));
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
		/**Declaration**/
		String hostOutput = AppConstant.ERROR,ani = AppConstant.EMPTY_STRING,expiredFlag = AppConstant.FALSE;
		String packName = AppConstant.EMPTY_STRING,packExpired = AppConstant.EMPTY_STRING,appName= AppConstant.EMPTY_STRING;
		String annoID = AppConstant.EMPTY_STRING,dialogName = AppConstant.EMPTY_STRING,initialPrompt = AppConstant.EMPTY_STRING;
		String key = AppConstant.EMPTY_STRING;
		Date datePackExpired = null,dateCurrentDate = null;
		Calendar calPackExpired = null,calCurrentDate = null;
		ITraceInfo trace = null;
		DynamicMenu objDynamicMenu= null;
		ArrayList<String> outputValues = null;
		IVRDataBean objIVRDataBean = null;
		SimpleDateFormat sdfObject = null,dd_sdfFormat = null;
		CRMPackInfo objCRMPackInfo = null;
		/**Assign**/
		trace = mySession.getTraceOutput();
		try {
			objDynamicMenu = new DynamicMenu();
			objIVRDataBean = (IVRDataBean)mySession.getProperty(AppConstant.IVRDATABEAN);
			ani = mySession.getVariableField(IProjectVariables.PREPAID__APP_VARIABLES,IProjectVariables.PREPAID__APP_VARIABLES_FIELD_ANI).getStringValue();
			appName = mySession.getVariableField(IProjectVariables.APP_NAME).getStringValue();
			sdfObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
			dd_sdfFormat = new SimpleDateFormat("yyyyMMdd");
			outputValues = new ArrayList<>();
			
			objCRMPackInfo = new CRMPackInfo();
			objCRMPackInfo.setMdn(ani);
			
			calPackExpired = Calendar.getInstance();
			calCurrentDate = Calendar.getInstance();
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Caller Ani :"+ani);
			
			
			objCRMPackInfo = IVRDBServiceInstance.getInstance().getCRMPackInfo(objIVRDataBean,objCRMPackInfo);
			
			if(objCRMPackInfo!=null){
				
			packExpired = objCRMPackInfo.getExpiryDate();
			packName =  objCRMPackInfo.getPackName();
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Pack Expired Date:"+packExpired);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Pack Name :"+packName);
				
			if(packExpired != null && packName !=null){		
				datePackExpired = sdfObject.parse(packExpired);
				calPackExpired.setTime(datePackExpired);
				
				if(calCurrentDate.before(calPackExpired)){
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Pack is not Expired Date");
					
					for(int i=1;i<=3;i++){
						calCurrentDate = Calendar.getInstance();
						calCurrentDate.add(Calendar.DATE,i);
						trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Current date added with :"+i+": days"+calCurrentDate);
						if(calCurrentDate.after(calPackExpired)){
							trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"expired Flag is set");
							expiredFlag = AppConstant.TRUE;
							break;
						}
					}
					if(AppConstant.TRUE.equalsIgnoreCase(expiredFlag)){
						key = appName+AppConstant.SEPERATOR_HYPEN+AppConstant.PA_0079;
						initialPrompt = AppProperties.GetInstance(Constants.AUDIO_CONFIG).getIVRProp(key);
						outputValues.add(packName+AppConstant.wave);
						String temp = dd_sdfFormat.format(datePackExpired);
						trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"DD expiry Format :"+temp);
						outputValues.add(temp);
						
						trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"initial Prompt From Property :"+initialPrompt);
						trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"key :"+ key);
						initialPrompt = objDynamicMenu.playPrompt(outputValues, initialPrompt, AppConstant.NA, trace);
						
						mySession.getVariableField(IProjectVariables.PREPAID__DM_INPUT_PARAMETER,IProjectVariables.PREPAID__DM_INPUT_PARAMETER_FIELD_ANNO_ID).setValue(AppConstant.PA_0078);
						mySession.getVariableField(IProjectVariables.PREPAID__DM_INPUT_PARAMETER,IProjectVariables.PREPAID__DM_INPUT_PARAMETER_FIELD_INITIAL_PROMPT).setValue(initialPrompt);
					}else{
						trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Pack is with in the Limit");
						expiredFlag = AppConstant.FALSE;
					}
				}else{
					expiredFlag = AppConstant.TRUE;
					key = appName+AppConstant.SEPERATOR_HYPEN+AppConstant.PA_0078;
	
					initialPrompt = AppProperties.GetInstance(Constants.AUDIO_CONFIG).getIVRProp(key);
					outputValues.add(packName+AppConstant.wave);
					
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"initial Prompt From Property :"+initialPrompt);
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"key :"+ key);
					initialPrompt = objDynamicMenu.playPrompt(outputValues, initialPrompt, AppConstant.NA, trace);
					
					mySession.getVariableField(IProjectVariables.PREPAID__DM_INPUT_PARAMETER,IProjectVariables.PREPAID__DM_INPUT_PARAMETER_FIELD_ANNO_ID).setValue(AppConstant.PA_0079);
					mySession.getVariableField(IProjectVariables.PREPAID__DM_INPUT_PARAMETER,IProjectVariables.PREPAID__DM_INPUT_PARAMETER_FIELD_INITIAL_PROMPT).setValue(initialPrompt);
				
				}
					hostOutput = AppConstant.Success;
					mySession.getVariableField(IProjectVariables.PREPAID__FLAG,IProjectVariables.PREPAID__FLAG_FIELD_PACK_EXPIRED).setValue(expiredFlag);
				}
			}
		} catch (Exception e) {
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "Error in Service Pack Renewal :" +e);
			PrintStackTrace.PrintException(e);
		}finally{
			datePackExpired = null;
			dateCurrentDate = null;
			calPackExpired = null;
			calCurrentDate = null;
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "SR Host Result :" +hostOutput);
			mySession.getVariableField(IProjectVariables.PREPAID__APP_VARIABLES,IProjectVariables.PREPAID__APP_VARIABLES_FIELD_HOST_RESULT).setValue(hostOutput);
		}
		
	}
}
