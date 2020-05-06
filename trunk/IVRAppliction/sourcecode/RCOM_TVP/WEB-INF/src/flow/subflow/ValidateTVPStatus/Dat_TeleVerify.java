package flow.subflow.ValidateTVPStatus;

//import java.text.SimpleDateFormat;

//import org.apache.log4j.Logger;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.hp.utilities.IVRConstants;
import com.hp.utilities.TVP_Properties;
import com.hp.utilities.TVP_Utilities;

import com.servion.rcom.hostinterface.util.Utilities;
import com.servion.rcom.hostinterface.view.ReqTeleVerify;
import com.servion.rcom.hostinterface.view.ResTeleVerify;
import com.servion.rcom.hostinterface.wrapper.IVRWebService;
import com.servion.rcom.hostinterface.wrapper.IVRWebServiceImpl;
import com.servion.util.AppProperties;
//import com.servion.util.AppConstant;
//import com.servion.util.AppProperties;
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
 * Last generated by Orchestration Designer at: 2015-OCT-24  02:00:33 PM
 */
public class Dat_TeleVerify extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	
	@Override
	public void requestBegin(SCESession mySession) {
		ITraceInfo itraceInfo = null;
		TVP_Properties tvpProp = null;
		String thanksMsg = null;
		String strDate = null;
		
		String strountStatusMessage = null;

		 try
		 {
			IVRDataBean ivrDataBean = null;
		    ReqTeleVerify req = null;
		    ResTeleVerify resTeleVerify = null;
		    
		    IVRWebService ivrWebService = new IVRWebServiceImpl(); 
		  //  Logger logger;
		    itraceInfo = mySession.getTraceOutput();
		    tvpProp = TVP_Properties.getInstance((mySession.getVariableField(IProjectVariables.VAR__CONFIG,IProjectVariables.VAR__CONFIG_FIELD_CONFIG_FILE_PATH).getStringValue()),mySession);	
		    Utilities uti=new Utilities();
		    TVP_Utilities tvpUti=new TVP_Utilities();
		    
		    String format = tvpProp.getProperty(mySession, IVRConstants.DATE_FORMAT);
		    itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "# Date Format:" + format);

			//Request Processing ......
			
			ivrDataBean = (IVRDataBean) mySession.getProperty(IVRConstants.IVRDATABEAN);
			req = new ReqTeleVerify();
			
			String requestID=Utilities.generateUniqueID();
		    String mdn=mySession.getVariableField(IProjectVariables.CALL_INFO, IProjectVariables.CALL_INFO_FIELD_TVP_MDN).getStringValue();
		    String languageID=mySession.getVariableField(IProjectVariables.CALL_INFO,IProjectVariables.CALL_INFO_FIELD_CURRENT_LANGUAGE).getStringValue();
		    String requestType=tvpProp.getProperty(mySession, IVRConstants.CHECK_TVP);//"TVP_STATUS";
		    System.out.println(requestType);
		    String source=tvpProp.getProperty(mySession, IVRConstants.SOURCE);
		    String date=tvpUti.getCurrentDate(format);
		    req.setRequestId(requestID);
		    req.setLangId(languageID);
		    req.setMDN(mdn);
		    req.setREQUESTTYPE(requestType);
		    req.setSOURCE(source);
		    req.setREQUESTDATE(date);
		    itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "#Product Type :"+mySession.getVariableField(IProjectVariables.CALL_INFO,IProjectVariables.CALL_INFO_FIELD_PRODUCT_TYPE).getStringValue());
		    itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Request for TVP status LANGUAGE ID:"+req.getLangId() );
		    itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Request for TVP status MDN :"+req.getMDN() );
		    itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Request for TVP status REQUEST DATE :"+req.getREQUESTDATE() );
		    itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Request for TVP status REQUEST ID :"+req.getRequestId() );
		    itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Request for TVP status REQUEST TYPE :"+req.getREQUESTTYPE() );
		    itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Request for TVP status SOURCE :"+req.getSOURCE() );
		/*For testing */    
			System.out.println("ANI2::"+AppProperties.GetInstance("webservice").getIVRProp("ANI").trim());
		    resTeleVerify = ivrWebService.executeTeleVerifyRequest(ivrDataBean, req);
		    
	  
	        
	         
	
	        if(resTeleVerify!=null)
	        {
	        	
	        	itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "#resTeleVerify ResponseCode :"+resTeleVerify.getResponseCode());  
	        	itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "#resTeleVerify ErrorCode :"+resTeleVerify.getERROR_CODE());
	        	itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "#resTeleVerify ErrorMessage :"+resTeleVerify.getERROR_MSG());
	        	      		
        		
        		
	        	if(resTeleVerify.getResponseCode().equalsIgnoreCase(IVRConstants.ZEROSTR)){
	        	
	        		
	        		itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "# Connected to TIBCO " );
	        		itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "#resTeleVerify Customer Category :"+resTeleVerify.getCUSTOMER_CATEGORY() );
	        		itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "#resTeleVerify Customer Type :"+resTeleVerify.getCUSTOMER_TYPE() );
	        		itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "#resTeleVerify Data Conscent :"+resTeleVerify.getDATA_CONSENT() );
	        		itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "#resTeleVerify DOB :"+resTeleVerify.getDOB() );
	        		itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "#resTeleVerify Out_Msg :"+resTeleVerify.getOUT_MSG() );
	        		itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "#resTeleVerify Out_Status :"+resTeleVerify.getOUT_STATUS() );
	        		itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "#resTeleVerify Out_Status_Code :"+resTeleVerify.getOUT_STATUS_CODE() );
	        		itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "#resTeleVerify POA ID Details: :"+resTeleVerify.getPOA_ID_DETAILS());
	        		itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "#resTeleVerify POA Issue Date :"+resTeleVerify.getPOA_ISSUE_DATE());
	        		itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "#resTeleVerify POA Type :"+resTeleVerify.getPOA_TYPE() );
	        		itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "#resTeleVerify Product Type :"+resTeleVerify.getPRODUCT_TYPE());
	        		itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "#resTeleVerify Response Code :"+resTeleVerify.getResponseCode());
	        		itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "#resTeleVerify Service Type :"+resTeleVerify.getSERVICE_TYPE());
	        		itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "#resTeleVerify Technology Type :"+resTeleVerify.getTECHNOLOGY_TYPE());
	        		itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "#resTeleVerify TVP_STATUS :"+resTeleVerify.getTVP_STATUS());
	        		itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "#resTeleVerify E_KYC:"+resTeleVerify.getE_KYC());
	        		itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "#resTeleVerify Update Date :"+resTeleVerify.getUPDATE_DATE());
	        		
	        		/***tEST dATA***/
	        		
	        		
	        		if(resTeleVerify.getERROR_CODE().equalsIgnoreCase(IVRConstants.ZEROSTR) && resTeleVerify.getOUT_STATUS_CODE().equalsIgnoreCase(IVRConstants.ZEROSTR))
	        		{
	        		
						    //Assigning values to tibco response OD Variable
						    
								mySession.getVariableField(IProjectVariables.TIBCO__VALIDATION__RES,IProjectVariables.TIBCO__VALIDATION__RES_FIELD_CUSTOMER_CATEGORY).setValue(resTeleVerify.getCUSTOMER_CATEGORY());
								mySession.getVariableField(IProjectVariables.TIBCO__VALIDATION__RES,IProjectVariables.TIBCO__VALIDATION__RES_FIELD_CUSTOMER_TYPE).setValue(resTeleVerify.getCUSTOMER_TYPE());
								mySession.getVariableField(IProjectVariables.TIBCO__VALIDATION__RES,IProjectVariables.TIBCO__VALIDATION__RES_FIELD_DATA_CONSCENT).setValue(resTeleVerify.getDATA_CONSENT());
								mySession.getVariableField(IProjectVariables.TIBCO__VALIDATION__RES,IProjectVariables.TIBCO__VALIDATION__RES_FIELD_DOB).setValue(resTeleVerify.getDOB());
								mySession.getVariableField(IProjectVariables.TIBCO__VALIDATION__RES,IProjectVariables.TIBCO__VALIDATION__RES_FIELD_OUT_MSG).setValue(resTeleVerify.getOUT_MSG());
								mySession.getVariableField(IProjectVariables.TIBCO__VALIDATION__RES,IProjectVariables.TIBCO__VALIDATION__RES_FIELD_OUT_STATUS).setValue(resTeleVerify.getOUT_STATUS());
								mySession.getVariableField(IProjectVariables.TIBCO__VALIDATION__RES,IProjectVariables.TIBCO__VALIDATION__RES_FIELD_OUT_STATUS_CODE).setValue(resTeleVerify.getOUT_STATUS_CODE());
								mySession.getVariableField(IProjectVariables.TIBCO__VALIDATION__RES,IProjectVariables.TIBCO__VALIDATION__RES_FIELD_POAID_DETAILS).setValue(resTeleVerify.getPOA_ID_DETAILS());
								mySession.getVariableField(IProjectVariables.TIBCO__VALIDATION__RES,IProjectVariables.TIBCO__VALIDATION__RES_FIELD_POAISSUE_DATE).setValue(resTeleVerify.getPOA_ISSUE_DATE());
								mySession.getVariableField(IProjectVariables.TIBCO__VALIDATION__RES,IProjectVariables.TIBCO__VALIDATION__RES_FIELD_POATYPE).setValue(resTeleVerify.getPOA_TYPE());
								mySession.getVariableField(IProjectVariables.TIBCO__VALIDATION__RES,IProjectVariables.TIBCO__VALIDATION__RES_FIELD_PRODUCT_TYPE).setValue(resTeleVerify.getPRODUCT_TYPE());
								mySession.getVariableField(IProjectVariables.TIBCO__VALIDATION__RES,IProjectVariables.TIBCO__VALIDATION__RES_FIELD_RESPONSE_CODE).setValue(resTeleVerify.getResponseCode());
								mySession.getVariableField(IProjectVariables.TIBCO__VALIDATION__RES,IProjectVariables.TIBCO__VALIDATION__RES_FIELD_SERVICE_TYPE).setValue(resTeleVerify.getSERVICE_TYPE());
								mySession.getVariableField(IProjectVariables.TIBCO__VALIDATION__RES,IProjectVariables.TIBCO__VALIDATION__RES_FIELD_TECHNOLOGY_TYPE).setValue(resTeleVerify.getTECHNOLOGY_TYPE());
								mySession.getVariableField(IProjectVariables.TIBCO__VALIDATION__RES,IProjectVariables.TIBCO__VALIDATION__RES_FIELD_TVP_STATUS).setValue(resTeleVerify.getTVP_STATUS());
								mySession.getVariableField(IProjectVariables.TIBCO__VALIDATION__RES,IProjectVariables.TIBCO__VALIDATION__RES_FIELD_UPDATE_DATE).setValue(resTeleVerify.getUPDATE_DATE());
								mySession.getVariableField(IProjectVariables.TIBCO__VALIDATION__RES,IProjectVariables.TIBCO__VALIDATION__RES_FIELD_PRODUCT_TYPE).setValue(resTeleVerify.getPRODUCT_TYPE());
								mySession.getVariableField(IProjectVariables.TIBCO__VALIDATION__RES,IProjectVariables.TIBCO__VALIDATION__RES_FIELD_E__KYC).setValue(resTeleVerify.getE_KYC());
								
								mySession.getVariableField(IProjectVariables.TVP__VARS, IProjectVariables.TVP__VARS_FIELD_NO__DATA).setValue(false);
						       
						       	//For reporting
						       	mySession.getVariableField(IProjectVariables.TVP__VARS,IProjectVariables.TVP__VARS_FIELD_TIBCO__DOI).setValue(resTeleVerify.getPOA_ISSUE_DATE());
				       	}
	        		else  if(resTeleVerify.getOUT_STATUS_CODE().equalsIgnoreCase(IVRConstants.ONESTR))
	        		{
	        			if(resTeleVerify.getOUT_MSG().contains("NO_DATA"))
	        			{
	        				mySession.getVariableField(IProjectVariables.TVP__VARS, IProjectVariables.TVP__VARS_FIELD_NO__DATA).setValue(true);
	        			}
	        			else
	        				mySession.getVariableField(IProjectVariables.TVP__VARS, IProjectVariables.TVP__VARS_FIELD_EXCEPTION).setValue(true);
	        		}
	        	}
	        		
	        	 else if(resTeleVerify.getERROR_CODE().equalsIgnoreCase(IVRConstants.ONESTR)&&resTeleVerify.getERROR_MSG().contains("NO_DATA"))
        			 
	     				mySession.getVariableField(IProjectVariables.TVP__VARS, IProjectVariables.TVP__VARS_FIELD_NO__DATA).setValue(true);
	        	 else
     				mySession.getVariableField(IProjectVariables.TVP__VARS, IProjectVariables.TVP__VARS_FIELD_EXCEPTION).setValue(true);
     	
	        	
	        		
			
	       
	        

			//Setting success java execute signal to OD code
	    	mySession.getVariableField(IProjectVariables.TVP__VARS, IProjectVariables.TVP__VARS_FIELD_JAVA__ERROR).setValue(false);
			itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "# Dat_Televerify.java Java_Error is set to: " + false );
	
	        }
		 }
	    catch(Exception e)
	    {
	    	//Setting failure java execute signal to OD code
			mySession.getVariableField(IProjectVariables.TVP__VARS, IProjectVariables.TVP__VARS_FIELD_JAVA__ERROR).setValue(true);
			itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "# Dat_Televerify.java Java_Error is set to: " + e );
			itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "# ERROR: Exception - Dat_Televerify.java:- " + e);
			System.out.println("Exception"+e);
			
		    }
	}

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-OCT-24  02:00:33 PM
	 */
	public Dat_TeleVerify() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-JUL-12  01:45:35 PM
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
	 * Last generated by Orchestration Designer at: 2017-JUL-12  01:45:35 PM
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
	 * Last generated by Orchestration Designer at: 2017-JUL-12  01:45:35 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(2);
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "Entering Tibco Code", "").setDebugId(34));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "TVP_VARs:Java_Error", com.avaya.sce.runtime.Expression.IS_TRUE).setDebugId(11)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("ValidateTVPStatus-Dat_HotLineCheck", "errorTrans").setDebugId(12));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		}


		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "TVP_VARs:Exception", com.avaya.sce.runtime.Expression.IS_TRUE).setDebugId(63)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "Error in TIBO connectivity.Out error code is not zero", "").setDebugId(65));
			actions.add(new com.avaya.sce.runtime.Next("ValidateTVPStatus-Dat_HotLineCheck", "exception").setDebugId(64));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "TVP_VARs:NO_DATA", com.avaya.sce.runtime.Expression.IS_TRUE).setDebugId(16)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("ValidateTVPStatus-PhoneGen_check", "check_Phonegen").setDebugId(17));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("ValidateTVPStatus-Dat_1800MobileCheck", "checkTechnology").setDebugId(20));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
