package flow;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.hp.utilities.IVRConstants;
import com.hp.utilities.TVP_Properties;
//import com.rcom.otherflows.model.IVRCspInfo;
import com.rcom.otherflows.model.ValidateDataCardNumber;
import com.rcom.otherflows.resource.IVRDBServiceInstance;
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
 * Last generated by Orchestration Designer at: 2015-OCT-30  04:21:41 PM
 */
public class Dat_PhoneGenCheck extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-OCT-30  04:21:41 PM
	 */
	public Dat_PhoneGenCheck() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-JUL-12  01:45:34 PM
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
	 * Last generated by Orchestration Designer at: 2017-JUL-12  01:45:34 PM
	 */
	public java.util.Collection<VariableInfo> getLocalVariables(){
		java.util.Collection<VariableInfo> variables = new java.util.ArrayList<VariableInfo>();

		return variables;
	}
	
	@Override
	public void requestBegin(SCESession mySession) {
		// TODO Auto-generated method stub
		super.requestBegin(mySession);
		
		ITraceInfo itraceInfo  = null;
		TVP_Properties tvpProp = null;
		String  callerANI      = null;
		ValidateDataCardNumber validateDataCardNumber =new ValidateDataCardNumber();
		
		String dataType       = null;
		GetReportObject objGetReportObject = null;
		IVRREPORTDATA objIVRREPORTDATA= null;
		CALLINFO objCALLINFO = null;
		callerANI = mySession.getVariableField(IProjectVariables.CALL_INFO,IProjectVariables.CALL_INFO_FIELD_TVP_MDN).getStringValue();
		Boolean flag = false;
		try
		{
			
			itraceInfo=mySession.getTraceOutput();
			
			itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Caller ANI/Dongle Number : " + callerANI );
			IVRDataBean objIVRData =(IVRDataBean) mySession.getProperty(IVRConstants.IVRDATABEAN);
			
			validateDataCardNumber.setDataCardNumber(callerANI);
			
			
		
			
		/*	objGetReportObject = objIVRData.getGetReportObject(); 
			objIVRREPORTDATA = objGetReportObject.getIvrreportdata();
			objCALLINFO = objIVRREPORTDATA.getCALLINFO();*/
			
			
			//mySession.getVariableField(IProjectVariables.CALL_INFO, IProjectVariables.CALL_INFO_FIELD_SERVICE_TYPE).setValue(IVRConstants.NODATA);
			
			/**DB**/
			itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "ValidateDataCard toString "+validateDataCardNumber.toString());
			//itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "ObjectIVRData "+objIVRData.toString());
			
			
			validateDataCardNumber = IVRDBServiceInstance.getIVRDBInstance().validateDataCardNumber(objIVRData, validateDataCardNumber);
			
			
		
			
			if(validateDataCardNumber.getErrorCode().equalsIgnoreCase(IVRConstants.ZEROSTR)&&validateDataCardNumber.getErrorDescription().equalsIgnoreCase(IVRConstants.SUCCESS)){
				
				itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "ValidateDataCardNumber toString from DB "+validateDataCardNumber.toString());
				//itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "ObjectIVRData from DB "+objIVRData.toString());
					
					
					
					if(validateDataCardNumber.getPlanType()!=null || validateDataCardNumber.getPlanType().equalsIgnoreCase(IVRConstants.NODATA))
					{
						//mySession.getVariableField(IProjectVariables.TVP__VARS,IProjectVariables.TVP__VARS_FIELD_IS_EX_MDN).setValue(IVRConstants.TRUE);
						flag = true;
						dataType=validateDataCardNumber.getPlanType();
						itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"service_Type :"+dataType);
						
						/***DataCard/HSD service check***/
												
						if(dataType.contains(IVRConstants.DATA)||dataType.contains(IVRConstants.HSD)){
							itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"HSD or DataCard Caller.Number exists in Phongen DB");
							mySession.getVariableField(IProjectVariables.TVP__VARS,IProjectVariables.TVP__VARS_FIELD_IS_DATA_PRODUCT).setValue(IVRConstants.Y);
						}
						/***Prepaid/PostPaid service check***/
						else if(dataType.contains(IVRConstants.POST)){
							itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Post paid Caller");
								mySession.getVariableField(IProjectVariables.CALL_INFO, IProjectVariables.CALL_INFO_FIELD_SERVICE_TYPE).setValue(IVRConstants.POSTPAID);
						}
						else if(dataType.contains(IVRConstants.PRE)){
							itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Pre paid Caller");
							mySession.getVariableField(IProjectVariables.CALL_INFO, IProjectVariables.CALL_INFO_FIELD_SERVICE_TYPE).setValue(IVRConstants.PREPAID);
						}
						
						else{
							itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "# NO Plan/Service type found in phonegen: "  );
							flag =false;
			
						}
			}
			}
			mySession.getVariableField(IProjectVariables.TVP__VARS,IProjectVariables.TVP__VARS_FIELD_IS_EX_MDN).setValue(flag);	
			
		
			mySession.getVariableField(IProjectVariables.TVP__VARS, IProjectVariables.TVP__VARS_FIELD_JAVA__ERROR).setValue(false);
			itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "# DatPhonegenCheck.java Java_Error is set to: " + false );
			itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"# isExisting MDNS :"+	mySession.getVariableField(IProjectVariables.TVP__VARS,IProjectVariables.TVP__VARS_FIELD_IS_EX_MDN).getStringValue());
			
		
		}
			
			

		
				 catch (Exception e) {
					//Setting failure java execute signal to OD code
					mySession.getVariableField(IProjectVariables.TVP__VARS, IProjectVariables.TVP__VARS_FIELD_JAVA__ERROR).setValue(true);
					itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "# DatPhonegenCheck.java Java_Error is set to: " + true );
					itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "# ERROR: Exception - DatPhonegenCheck.java:- " + e);
					e.printStackTrace();
			}
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
	 * Last generated by Orchestration Designer at: 2017-JUL-12  01:45:34 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "TVP_VARs:Java_Error", com.avaya.sce.runtime.Expression.IS_TRUE).setDebugId(433)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("Call_TransferCall", "errorTrans").setDebugId(434));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "TVP_VARs:isExMDN", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "CONSTANTS:FALSE", true).setDebugId(541)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("Ann_inavlid", "NoDATA").setDebugId(446));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "TVP_VARs:isDataProduct", com.avaya.sce.runtime.Expression.STRING_EQUAL, "CONSTANTS:YES", true).setDebugId(589)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("Ann_Dongle", "DataProduct").setDebugId(590));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition4", "CallInfo:ServiceType", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "CONSTANTS:POSTPAID", true).setDebugId(591)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("Ann_Postpaid", "PostpaidMobile").setDebugId(592));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("Ann_Prepaid", "Prepaid").setDebugId(594));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}

		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}