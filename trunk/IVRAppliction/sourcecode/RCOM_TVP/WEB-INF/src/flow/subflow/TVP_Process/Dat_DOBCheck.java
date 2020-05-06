package flow.subflow.TVP_Process;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.hp.utilities.IVRConstants;

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
 * Last generated by Orchestration Designer at: 2016-SEP-17  03:30:13 PM
 */
public class Dat_DOBCheck extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2016-SEP-17  03:30:13 PM
	 */
	public Dat_DOBCheck() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-JUL-12  01:45:39 PM
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
	 * Last generated by Orchestration Designer at: 2017-JUL-12  01:45:39 PM
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
	 * Last generated by Orchestration Designer at: 2017-JUL-12  01:45:39 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(3);
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "DOB inTVPCheck", "TIBCO_Validation_Res:DOB").setDebugId(459));
		actions.add(new com.avaya.sce.runtime.varoperations.Assign("TVP_VARs:isDOBEntry", "CONSTANTS:TRUE", false).setDebugId(506));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "TVP_VARs:Java_Error", com.avaya.sce.runtime.Expression.IS_TRUE).setDebugId(460)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("TVP_Process-Ret_Xfer", "errorTrans").setDebugId(461));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		}


		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "TVP_VARs:isDOBMatch", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "CONSTANTS:TRUE", true).setDebugId(462)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("TVP_Process-TVP_FlagUpdate", "Matched").setDebugId(463));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("TVP_Process-Ann_DOBIncorrect", "Retry").setDebugId(487));
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
		// TODO Auto-generated method stub
		super.requestBegin(mySession);
		
		ITraceInfo itraceInfo = mySession.getTraceOutput();
		String YDOB =IVRConstants.EMPTY_QUOTES,collectDOB =IVRConstants.EMPTY_QUOTES,isDOBMatch = IVRConstants.EMPTY_QUOTES,collectPOA = IVRConstants.EMPTY_QUOTES;
		String[] arrDOB =null;

		 //Changing formate of POA date to DDMMYYY
	
		try
		{
			
				String strDate = mySession.getVariableField(IProjectVariables.TIBCO__VALIDATION__RES,IProjectVariables.TIBCO__VALIDATION__RES_FIELD_DOB).getStringValue();
				isDOBMatch     = IVRConstants.falseStr;
				if(strDate!=null&&strDate.length()>0)
				{
					itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"DOB:- "+strDate);
					arrDOB 		= strDate.split("\\/");
					
					YDOB  		= arrDOB[arrDOB.length-1];
					itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Year of DOB:-------"+YDOB);
					collectDOB  = mySession.getVariableField(IProjectVariables.PRMT__ENTER_DOB,IProjectVariables.PRMT__ENTER_DOB_FIELD_VALUE).getStringValue();
					collectPOA	= mySession.getVariableField(IProjectVariables.CALL_INFO,IProjectVariables.CALL_INFO_FIELD_COLLECT_POA).getStringValue();
					itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"DOB Year entered :"+collectDOB);
					itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"DOB Collect String :"+collectPOA);
					mySession.getVariableField(IProjectVariables.CALL_INFO,IProjectVariables.CALL_INFO_FIELD_COLLECT_POA).setValue(collectPOA+"|"+collectDOB);
					itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"YDOB:"+YDOB);
					itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Customer entered YOB:"+collectDOB);
					if(YDOB.equalsIgnoreCase(collectDOB))
						{
						itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"DOBMatch");
						isDOBMatch = IVRConstants.trueStr;
						}
				}							
				mySession.getVariableField(IProjectVariables.TVP__VARS,IProjectVariables.TVP__VARS_FIELD_JAVA__ERROR).setValue(false);
				itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"isDOBMatch:"+isDOBMatch);
				itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"JAVA_ERROR is set to:"+false);
						
					
		}catch(Exception e)
		
		{
			//Setting failure java execute signal to OD code
			mySession.getVariableField(IProjectVariables.TVP__VARS, IProjectVariables.TVP__VARS_FIELD_JAVA__ERROR).setValue(true);
			itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "# Dat_POADateMatch.java Java_Error is set to: " + e );
			itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "# ERROR: Exception - Dat_Televerify.java:- " + e);
			System.out.println("Exception"+e);
		}
	  finally
	  {
		  mySession.getVariableField(IProjectVariables.TVP__VARS, IProjectVariables.TVP__VARS_FIELD_IS_DOBMATCH).setValue(isDOBMatch);
	  }
	}
}


