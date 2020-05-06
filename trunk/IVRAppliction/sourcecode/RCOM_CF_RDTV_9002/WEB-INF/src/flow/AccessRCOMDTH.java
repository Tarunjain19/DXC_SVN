package flow;

import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.otherflows.resource.IVRDBServiceInstance;
import com.rcom.rdtv.Constants;
import com.rcom.rdtv.StackTrace;
import com.rcom.rdtv.rcomdth02.model.FetchSCNInfo;
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
 * Last generated by Orchestration Designer at: 2015-JUN-10  03:24:29 PM
 */
public class AccessRCOMDTH extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS
	
	@Override
	public void requestBegin(SCESession mySession) {
		super.requestBegin(mySession);
		
		String strANI = "";
		FetchSCNInfo fetchSCNInfo = null;
		IVRDataBean ivrDataBean = null;
		AppProperties ivrProperties = null;
		
		try{
			
			ivrDataBean = (IVRDataBean) mySession.getProperty(Constants.IVRDATABEAN);
			ivrProperties = AppProperties.GetInstance(Constants.IVR_CONFIG_FILE_NAME);
			
			strANI = mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_ANI).getStringValue();
			
			if(!(ivrProperties.getIVRProp(strANI).equalsIgnoreCase("N")))
				strANI = ivrProperties.getIVRProp(strANI);
			
			fetchSCNInfo = new FetchSCNInfo();
			fetchSCNInfo.setCliNo(strANI);
			
			fetchSCNInfo = IVRDBServiceInstance.getRcomdth02DataService().validateRegisterNo(ivrDataBean, fetchSCNInfo);
			mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_ACCOUNT_STATUS).setValue(Constants.SUCCESS);
			
			if(fetchSCNInfo.getErrorCode() != null){
				if((fetchSCNInfo.getStatus().equalsIgnoreCase(Constants.SUCCESS))||(fetchSCNInfo.getStatus().contains("Success"))){
					mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_RTN).setValue(Constants.Yes);
					mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_MULTIPLE_STB).setValue(Constants.No);
					mySession.getVariableField(IProjectVariables.SCN__NUMBER,IProjectVariables.SCN__NUMBER_FIELD_NUMBER).setValue(fetchSCNInfo.getScnNo());
					mySession.getVariableField(IProjectVariables.GET_SMART_CARD_NUMBER__MN, IProjectVariables.GET_SMART_CARD_NUMBER__MN_FIELD_VALUE).setValue(fetchSCNInfo.getScnNo());
				}else{
					mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_RTN).setValue(Constants.No);
				}
			}else{
				mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_RTN).setValue(Constants.No);
			}
			
		}catch (Exception e) {
			StackTrace.PrintException(e);
			mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_EXCEPTION).setValue(Constants.Yes);
		}
		
	}

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-JUN-10  03:24:29 PM
	 */
	public AccessRCOMDTH() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2016-MAY-12  05:47:07 PM
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
	 * Last generated by Orchestration Designer at: 2016-MAY-12  05:47:07 PM
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
	 * Last generated by Orchestration Designer at: 2016-MAY-12  05:47:07 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "appVariables:accountStatus", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:Success", true).setDebugId(3455)).evaluate(mySession)) {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "appVariables:isRTN", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:yes", true).setDebugId(3457)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("Set_RD02_MN_0003_MN", "AccessSTB").setDebugId(3462));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("MainMenu_MN", "MainMenu").setDebugId(3459));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


		} else {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferPoint", "TransferPoints:RD02_TR_0013", false).setDebugId(3464));
			actions.add(new com.avaya.sce.runtime.Next("LinkDown_PP", "LinkDown").setDebugId(3465));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
	/*@Override
	public void requestBegin(SCESession mySession) {
		ITraceInfo trace = mySession.getTraceOutput();
		String cliNo = mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_ANI).getStringValue();
		FetchSCNInfo fetchSCNInfo = null;
		IVRDataService ivrDataService = null;
		
		try{
			*//** Request Processing **//*
			fetchSCNInfo = new FetchSCNInfo();
			fetchSCNInfo.setCliNo(cliNo);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "CLI Request :: "+fetchSCNInfo.toString());
			
			*//** Response Processing **//*
			ivrDataService = new IVRDataServiceImpl();
			fetchSCNInfo = ivrDataService.getRegisteredNumberValidation((IVRDataBean) mySession.getProperty(Constants.IVRDATABEAN), fetchSCNInfo);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Response :: "+fetchSCNInfo.toString());
			
			if(fetchSCNInfo != null && Constants.SUCCESS.equalsIgnoreCase(fetchSCNInfo.getStatus()))
			{
				if(Constants.Zero.equalsIgnoreCase(fetchSCNInfo.getErrorCode()))
				{
					if(fetchSCNInfo.getScnNo()!=null && fetchSCNInfo.getScnNo().length()==Constants.Twelve){
						mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_RTN).setValue(Constants.Yes);
						mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_ACCOUNT_STATUS).setValue(fetchSCNInfo.getScnStatus());}
					else{
						mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_EXCEPTION).setValue(Constants.Yes);
					}
				}
				else
				{
					mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_EXCEPTION).setValue(Constants.Yes);
				}
			}
			
			else
				mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_EXCEPTION).setValue(Constants.Yes);
			
		}catch(Exception e)
		{mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_EXCEPTION).setValue(Constants.Yes);
		StackTrace.PrintException(e);
		}
		finally
		{trace=null;fetchSCNInfo=null;ivrDataService=null;}
	
	}*/
}


