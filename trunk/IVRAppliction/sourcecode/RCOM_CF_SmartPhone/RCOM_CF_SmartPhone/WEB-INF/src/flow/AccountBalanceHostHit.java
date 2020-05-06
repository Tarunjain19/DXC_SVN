package flow;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.IVariable;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.util.AppConstant;
import com.rcom.util.StackTrace;
import com.servion.rcom.smartphone.hostinterface.view.ReqAccountBalance;
import com.servion.rcom.smartphone.hostinterface.view.ResAccountBalance;
import com.servion.rcom.smartphone.hostinterface.wrapper.IVRWebService;
import com.servion.rcom.smartphone.hostinterface.wrapper.IVRWebServiceImpl;
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
 * Last generated by Orchestration Designer at: 2015-NOV-06  12:08:58 PM
 */
public class AccountBalanceHostHit extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-NOV-06  12:08:58 PM
	 */
	public AccountBalanceHostHit() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2016-JAN-25  06:26:29 PM
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
	 * Last generated by Orchestration Designer at: 2016-JAN-25  06:26:29 PM
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
	 * Last generated by Orchestration Designer at: 2016-JAN-25  06:26:29 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "appVariables:HostResult", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:Success", true).setDebugId(7325)).evaluate(mySession)) {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "mainAccountBalanceAndValidity:BAL", com.avaya.sce.runtime.Expression.INT_EQUAL, "0", false).setDebugId(7754)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("Set_AccountBal", "ZeroBal").setDebugId(7755));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			}

			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("Set_AccountSuccessBal", "success").setDebugId(7326));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("AccountBalFailure", "LinkDown").setDebugId(7329));
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
		String sessionId = null,hostResponse= AppConstant.ERROR;
		String mdn = null;
		IVariable mainAccountBalance = null;
		DateFormat formatter = null;
	    Date convertedExpiryDate = null;
	    Date convertedSystemDate = null;
	    
		//Host Interaction Objects.....
		ReqAccountBalance reqAccountBalance = null;
		ResAccountBalance resAccountBalance = null;
		IVRWebService ivrWebService = null;
		IVRDataBean objIVRDataBean = null;
		String ddExpiryDate = AppConstant.EMPTY_STRING;
		try
		{
			//Request Processing ......
			mdn =  mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_ANI).getStringValue();
			objIVRDataBean = (IVRDataBean)mySession.getProperty(AppConstant.IVRDATABEAN);
			reqAccountBalance = new ReqAccountBalance();
			reqAccountBalance.setMDN(mdn);

			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Main Account Balance Host request :: "+reqAccountBalance.toString());
			
			//Response Processing ......
			ivrWebService = new IVRWebServiceImpl();
			resAccountBalance = ivrWebService.executeAccountBalance(objIVRDataBean,reqAccountBalance);
		
						
			//moving to complex variable
			if(resAccountBalance!= null){
				
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, " Account Balance :: "+resAccountBalance.getAccBalance());
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, " Expiry Date :: "+resAccountBalance.getAccBalanceExpiryDate());
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, " Response Code :: "+resAccountBalance.getResponseCode());
				
				mainAccountBalance = mySession.getVariable(IProjectVariables.MAIN_ACCOUNT_BALANCE_AND_VALIDITY);
				if(AppConstant.zero.equalsIgnoreCase(resAccountBalance.getResponseCode())){
					
					mainAccountBalance.getComplexVariable().getField(IProjectVariables.MAIN_ACCOUNT_BALANCE_AND_VALIDITY_FIELD_BAL).setValue(resAccountBalance.getAccBalance());
					
					//31/12/2016
					//Expired Date Check Processing....
					formatter = new SimpleDateFormat("dd-MM-yyyy");
			        convertedExpiryDate = formatter.parse(resAccountBalance.getAccBalanceExpiryDate());
			        convertedSystemDate = Calendar.getInstance().getTime();
			        mySession.getVariableField(IProjectVariables.MAIN_ACCOUNT_BALANCE_AND_VALIDITY,IProjectVariables.MAIN_ACCOUNT_BALANCE_AND_VALIDITY_FIELD_SMS_DATE).setValue(resAccountBalance.getAccBalanceExpiryDate());
			        formatter = new SimpleDateFormat(AppConstant.DATE_FORMAT_YYYYMMDD);
			        ddExpiryDate = formatter.format(convertedExpiryDate);
			        trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "dd Expiry Date :"+ddExpiryDate);
			        mainAccountBalance.getComplexVariable().getField(IProjectVariables.MAIN_ACCOUNT_BALANCE_AND_VALIDITY_FIELD_DATE).setValue(ddExpiryDate);
			        
			        trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, " Today's Date :: "+convertedSystemDate.toString());
			        
			        
			        
			        hostResponse = AppConstant.Success;
			        
				}else{
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Response Code is not zero");
				}
			}else{
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Account Balance Response Object null");
			}
			
		}
		catch(Exception e)
		{
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "Exception In Account Balance :"+e);
			StackTrace.PrintException(e);
			
		}
		finally
		{
				sessionId = null;mdn = null;mainAccountBalance = null;
				convertedExpiryDate = null;convertedSystemDate = null;reqAccountBalance = null;
				resAccountBalance = null;ivrWebService = null;
				mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_HOST_RESULT).setValue(hostResponse);	
		}
	
		
	}

	
}
