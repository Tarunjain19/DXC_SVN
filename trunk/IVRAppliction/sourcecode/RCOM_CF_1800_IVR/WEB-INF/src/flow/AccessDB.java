package flow;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.ppp.model.NumberPortabilityInfo;
import com.rcom.ppp.resource.IVRDBServiceInstance;
import com.rcom.util.AppConstants;
import com.rcom.util.StackTrace;
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
 * Last generated by Orchestration Designer at: 2015-JUN-27  06:17:15 PM
 */
public class AccessDB extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-JUN-27  06:17:15 PM
	 */
	public AccessDB() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-JAN-24  02:14:45 PM
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
	 * Last generated by Orchestration Designer at: 2017-JAN-24  02:14:45 PM
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
	 * Last generated by Orchestration Designer at: 2017-JAN-24  02:14:45 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(2);
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "Host Result ::", "appVariables:HostResult").setDebugId(5138));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "appVariables:HostResult", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:Success", true).setDebugId(5135)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("ThankU_PP", "Success").setDebugId(5137));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "TransferCodes:TR_0027", false).setDebugId(5142));
			actions.add(new com.avaya.sce.runtime.Next("LinkDown_PP", "LinkDown").setDebugId(5009));
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
		String hostResult = AppConstants.ERROR;
		IVRDataBean objIVRDataBean = null;
		AppProperties ivrProperties = null;
		String aNI = AppConstants.EMPTY_STRING;
		String applicationName = AppConstants.EMPTY_STRING;
		String category = AppConstants.EMPTY_STRING;
		String mobileNum = AppConstants.EMPTY_STRING;
		String sTDCode = AppConstants.EMPTY_STRING;
		
		try{
			
			objIVRDataBean = (IVRDataBean)mySession.getProperty(AppConstants.IVRDATABEAN);
			
			
			aNI = mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_ANI).getStringValue();
			applicationName = mySession.getVariableField(IProjectVariables.APP_NAME).getStringValue();
			mobileNum = mySession.getVariableField(IProjectVariables.NUMBER_PORTABILITY__MN, IProjectVariables.NUMBER_PORTABILITY__MN_FIELD_VALUE).getStringValue();
			sTDCode = mySession.getVariableField(IProjectVariables.STDCODE__MN, IProjectVariables.STDCODE__MN_FIELD_VALUE).getStringValue();
			
			if(mySession.getVariableField(IProjectVariables.SERVICES__MN, IProjectVariables.SERVICES__MN_FIELD_VALUE).getStringValue().equalsIgnoreCase(mySession.getVariableField(IProjectVariables.GRAMMARS, IProjectVariables.GRAMMARS_FIELD_PREPAID_SERVICES).getStringValue()))
			{
				category = AppConstants.PORTABILITY_PREPAID;
			}
			else
			{
				category = AppConstants.PORTABILITY_POSTPAID;
			}
									
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Mobile Number Portability Request : ");
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "aNI : " +aNI);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "applicationName : " +applicationName);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "mobileNum : " +mobileNum);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "sTDCode : " +sTDCode);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "category : " +category);
			
			NumberPortabilityInfo numberPortabilityInfo = new NumberPortabilityInfo();
			
			numberPortabilityInfo.setANI(aNI);
			numberPortabilityInfo.setApplicationName(applicationName);
			numberPortabilityInfo.setCategory(category);
			numberPortabilityInfo.setMobileNum(mobileNum);
			numberPortabilityInfo.setSTDCode(sTDCode);
			
			numberPortabilityInfo = IVRDBServiceInstance.getInstance().updateNumberPortabilityInfo(objIVRDataBean, numberPortabilityInfo);
			
			String flag = numberPortabilityInfo.getFlag();
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Flag returned from DB :  :" +flag);
			
			if(flag != null && flag.contains(AppConstants.Success))
			{
				hostResult = AppConstants.Success;
				
			}
			
		}catch(Exception e)
		{
			StackTrace.PrintException(e);
			
		}
		
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Host Status :" +hostResult);
		mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_HOST_RESULT).setValue(hostResult);
		
	}
}