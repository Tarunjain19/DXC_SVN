package flow.subflow.UnManned_Fire_And_Shock;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.energy.AppConstants;
import com.rcom.energy.DynamicMenu;
import com.rcom.energy.StackTrace;
import com.servion.rcom.hostinterface.util.HostConstants.ComplaintStatus;
import com.servion.rcom.hostinterface.view.ReqRegisterFireAndShockComplaint;
import com.servion.rcom.hostinterface.view.ResRegisterFireAndShockComplaint;
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
 * Last generated by Orchestration Designer at: 2016-NOV-09  12:39:51 PM
 */
public class WS_FireAndShock_Complaints extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2016-NOV-09  12:39:51 PM
	 */
	public WS_FireAndShock_Complaints() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}
	@Override
	public void requestBegin(SCESession mySession) {
		ITraceInfo trace = mySession.getTraceOutput();
		IVRWebService ivrWebService = null;
		ReqRegisterFireAndShockComplaint reqRegisterFireAndShockComplaint = null;
		ResRegisterFireAndShockComplaint resRegisterFireAndShockComplaint = null;
		String appName,key,initialPrompt,menuID,propertyFileName = null;
		String[] dynamicValue = null;
		try
		{
			if(AppConstants.Yes.equalsIgnoreCase(mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_FOR_FIRE_SHOCK_COMPLAINTS).getStringValue()))
			{
				/** Request Formation To Register Complaint **/
				reqRegisterFireAndShockComplaint = new ReqRegisterFireAndShockComplaint();
				reqRegisterFireAndShockComplaint.setAccountNo(mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_ACCOUNT_NO).getStringValue());
				reqRegisterFireAndShockComplaint.setMDN(mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_ANI).getStringValue());
				reqRegisterFireAndShockComplaint.setComplaintByAccNo(mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_COMPLAINT_BY_ACC_NO).getBooleanValue());
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "To Register Complaints Request :: "+reqRegisterFireAndShockComplaint.toString());
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Is Complaint By AccountNumber :: "+reqRegisterFireAndShockComplaint.isComplaintByAccNo());
				
				/** Getting Response for Register Complaints **/
				ivrWebService = new IVRWebServiceImpl();
				resRegisterFireAndShockComplaint = ivrWebService.registerFireAndShockComplaint((IVRDataBean)mySession.getProperty(AppConstants.IVR_DATA_BEAN), reqRegisterFireAndShockComplaint);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "To Register Complaints Response :: ResponceCode : "+resRegisterFireAndShockComplaint.getResponseCode()+" ,ComplaintNo : "+resRegisterFireAndShockComplaint.getComplaintNumber()+" ,isComplaintRegistered : "+resRegisterFireAndShockComplaint.isComplaintRegistered());
				
				if(resRegisterFireAndShockComplaint.getResponseCode().equalsIgnoreCase(AppConstants.WS_RESPONSE_SUCCESS))
				{
				/** Storing the data in Complex Variable **/
				mySession.getVariableField(IProjectVariables.TO_REGISTER_COMPLAINTS, IProjectVariables.TO_REGISTER_COMPLAINTS_FIELD_RESPONSE_CODE).setValue(resRegisterFireAndShockComplaint.getResponseCode());
				mySession.getVariableField(IProjectVariables.TO_REGISTER_COMPLAINTS, IProjectVariables.TO_REGISTER_COMPLAINTS_FIELD_COMPLAINT_NO).setValue(resRegisterFireAndShockComplaint.getComplaintNumber());
				mySession.getVariableField(IProjectVariables.TO_REGISTER_COMPLAINTS, IProjectVariables.TO_REGISTER_COMPLAINTS_FIELD_IS_COMPLAINT_REGISTERED).setValue(resRegisterFireAndShockComplaint.isComplaintRegistered());
				
				
				/** Formation Of DynamicAccouncement **/
				if(AppConstants.string_Zero.equalsIgnoreCase(resRegisterFireAndShockComplaint.getResponseCode()))
				{	
					appName = mySession.getVariable(IProjectVariables.APP__NAME).getSimpleVariable().getStringValue();
					if(resRegisterFireAndShockComplaint.isComplaintRegistered())
					{	
						dynamicValue = new String[AppConstants.One];
						menuID = AppConstants.PA_0009;propertyFileName = AppConstants.ComplaintSuccessAnnc_PA;
						key = appName+AppConstants.HYPEN_SEPERATOR+AppConstants.PA_0009;
						dynamicValue[AppConstants.Zero] = resRegisterFireAndShockComplaint.getComplaintNumber();
						/** For CR Commented  **/
						//dynamicValue[AppConstants.One] = mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_ANI).getStringValue();
					}
					else
					{
						dynamicValue = new String[AppConstants.One];
						menuID = AppConstants.PA_0010;propertyFileName = AppConstants.ComplaintUnsuccessAnnc_PA;
						key = appName+AppConstants.HYPEN_SEPERATOR+AppConstants.PA_0010;
						/** For CR Commented  **/
						//dynamicValue[AppConstants.Zero] = mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_ANI).getStringValue();
					}
					initialPrompt = AppProperties.GetInstance(AppConstants.IVR_CONFIG_PROPERTIES).getIVRProp(key);
					
					/** Invocation Of DynamicMenu Forming method **/
					initialPrompt = DynamicMenu.playPrompt(dynamicValue, initialPrompt, AppConstants.NA, menuID, trace);
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Injecting Initial Prompt for "+menuID+" :: "+initialPrompt);
					mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER, IProjectVariables.DM_INPUT_PARAMETER_FIELD_PROPERTY_FILE_NAME).setValue(propertyFileName);
					mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER, IProjectVariables.DM_INPUT_PARAMETER_FIELD_INITIAL_PROMPT).setValue(initialPrompt);
				}
				else
					mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_NETWORK_ERROR).setValue(AppConstants.Yes);
				}
				else
					mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_NETWORK_ERROR).setValue(AppConstants.Yes);
			}
			
			
		}catch(Exception e)
		{mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_NETWORK_ERROR).setValue(AppConstants.Yes);
		StackTrace.PrintException(e);}
		finally
		{trace = null;reqRegisterFireAndShockComplaint=null;ivrWebService=null;resRegisterFireAndShockComplaint=null;initialPrompt=null;menuID=null;appName=null;key=null;dynamicValue=null;propertyFileName=null;}
	}

		
	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-AUG-28  03:43:19 PM
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
	 * Last generated by Orchestration Designer at: 2017-AUG-28  03:43:19 PM
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
	 * Last generated by Orchestration Designer at: 2017-AUG-28  03:43:19 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "AppVariables:forFireShockComplaints", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:yes", true).setDebugId(1499)).evaluate(mySession)) {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "toRegisterComplaints:isComplaintRegistered", com.avaya.sce.runtime.Expression.IS_TRUE).setDebugId(1821)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("UnManned_Fire_And_Shock-Ann_ComplaintRegistered", "Successful").setDebugId(1768));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("UnManned_Fire_And_Shock-Ann_UnsuccessfulComplaint", "Unsuccessful").setDebugId(1822));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("UnManned_Fire_And_Shock-Disconnect", "Disconnect").setDebugId(1771));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
