package flow;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.Data.utils.AppConstant;
import com.rcom.Data.utils.Constants;
import com.rcom.Data.utils.StackTrace;
import com.servion.util.AppProperties;

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
 * Last generated by Orchestration Designer at: 2015-DEC-02  02:09:43 PM
 */
public class UUIDataParse extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-DEC-02  02:09:43 PM
	 */
	public UUIDataParse() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2016-MAY-11  07:12:38 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("InitializeVariables", "Default");
		next.setDebugId(3223);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2016-MAY-11  07:12:38 PM
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
	 * Last generated by Orchestration Designer at: 2016-MAY-11  07:12:38 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
	@Override
	public void requestBegin(SCESession mySession) {
		
		String rUUIData=AppConstant.EMPTY_STRING,convertedUUIData;
		String prefix,postfix;
		String ani,dnis=AppConstant.EMPTY_STRING;
		ITraceInfo trace = null;
		String[] arrrUUIData;
		String[] arrUUIDATA;
		String appName= AppConstant.EMPTY_STRING;
		String UUILang= AppConstant.EMPTY_STRING;
		String UUIMDN= AppConstant.EMPTY_STRING;
		
		
		try {
			trace = mySession.getTraceOutput();
			rUUIData = mySession.getVariableField(IProjectVariables.SESSION,IProjectVariables.SESSION_FIELD_UUI).getStringValue();
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Session UUI :"+rUUIData);
			prefix = AppConstant.startPart;
			postfix = AppConstant.endPart;
			
	
			
			if(rUUIData != null && !AppConstant.EMPTY_STRING.equalsIgnoreCase(rUUIData)){
				
				if(rUUIData.contains("PD,04;C8"))
				{					 

					arrrUUIData = rUUIData.split(prefix);
					
					if(arrrUUIData.length>1){
						rUUIData = arrrUUIData[1];
						rUUIData = rUUIData.split(postfix)[0];
					    trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Session UUI after spliting:"+rUUIData);
						
						StringBuilder output = new StringBuilder();
					    for (int i = 0; i < rUUIData.length(); i+=2) {
					        String str = rUUIData.substring(i, i+2);
					        output.append((char)Integer.parseInt(str, 16));
					    }
					    trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Converted data :"+output);
					    convertedUUIData = output.toString();
					    
					    arrUUIDATA = convertedUUIData.split("\\|");
					    
					    if(arrUUIDATA.length>1){
					    	trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"UUI ani :" + arrUUIDATA[0]);
					    	trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"UUI DNIS :" + arrUUIDATA[1]);
					    	trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"UUI UUILang :" + arrUUIDATA[2]);
					    	trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"UUI UUIMDN :" + arrUUIDATA[3]);
					    	
					    	ani = arrUUIDATA[0];
					    	dnis = arrUUIDATA[1];
					    	UUILang = arrUUIDATA[2];
					    	UUIMDN = arrUUIDATA[3];
					    	
					    	mySession.getVariableField(IProjectVariables.SESSION,IProjectVariables.SESSION_FIELD_ANI).setValue(ani);
					    	mySession.getVariableField(IProjectVariables.APP__VARIABLES, IProjectVariables.APP__VARIABLES_FIELD_UUIDNIS).setValue(dnis);
					    	mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_DEFAULT_LANGUAGE).setValue(UUILang);
					    	mySession.getVariableField(IProjectVariables.APP__VARIABLES, IProjectVariables.APP__VARIABLES_FIELD_ALT_MDN).setValue(UUIMDN);
					    	//mySession.getVariableField(IProjectVariables.APP_NAME).setValue(appName);
					    }
					}else{
						arrrUUIData = rUUIData.split(";");
						rUUIData = arrrUUIData[0];
					    trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Session UUI after spliting:"+rUUIData);
						
						StringBuilder output = new StringBuilder();
					    for (int i = 0; i < rUUIData.length(); i+=2) {
					        String str = rUUIData.substring(i, i+2);
					        output.append((char)Integer.parseInt(str, 16));
					    }
					    trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Converted data :"+output);
					    convertedUUIData = output.toString();
					    
					    arrUUIDATA = convertedUUIData.split("\\|");
					    
					    if(arrUUIDATA.length>1){
					    	trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"UUI ani :" + arrUUIDATA[0]);
					    	trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"UUI DNIS :" + arrUUIDATA[1]);
					    	trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"UUI UUILang :" + arrUUIDATA[2]);
					    	trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"UUI UUIMDN :" + arrUUIDATA[3]);
					    	
					    	ani = arrUUIDATA[0];
					    	dnis = arrUUIDATA[1];
					    	UUILang = arrUUIDATA[2];
					    	UUIMDN = arrUUIDATA[3];
					    	
					    	mySession.getVariableField(IProjectVariables.SESSION,IProjectVariables.SESSION_FIELD_ANI).setValue(ani);
					    	mySession.getVariableField(IProjectVariables.APP__VARIABLES, IProjectVariables.APP__VARIABLES_FIELD_UUIDNIS).setValue(dnis);
					    	mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_DEFAULT_LANGUAGE).setValue(UUILang);
					    	mySession.getVariableField(IProjectVariables.APP__VARIABLES, IProjectVariables.APP__VARIABLES_FIELD_ALT_MDN).setValue(UUIMDN);
					    	mySession.setLanguageLocale(UUILang);
					    	//mySession.getVariableField(IProjectVariables.a).setValue(appName);
					    }
					}
				}
				else
				{
					 trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Session UUI data is not properly sent: " + rUUIData);
					 mySession.getVariableField(IProjectVariables.FLAG,IProjectVariables.FLAG_FIELD_UDATA_FAIL).setValue(AppConstant.TRUE);
					 mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_DEFAULT_LANGUAGE).setValue(Constants.ENG);
				}
				
				// Check DNIS comming from UUI or not
				
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"It is only for UUI Call");
				
				String Uui_Dnis=mySession.getVariableField(IProjectVariables.SESSION,IProjectVariables.SESSION_FIELD_DNIS).getStringValue();
			    String	POSDNIS = AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp(AppConstant.CONNECTBACK_DATA_POS_VDN);
			   
			    String	PREDNIS = AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp(AppConstant.CONNECTBACK_DATA_PRE_VDN);
			   
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Connect Back POSDNIS"+POSDNIS);
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Connect Back PREDNIS"+PREDNIS);
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Connect Back Uuui_Dnis"+Uui_Dnis);
				
				if(POSDNIS != null && POSDNIS.contains(Uui_Dnis)){
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Transfer POSDNIS Back Call");
					mySession.getVariableField(IProjectVariables.FLAG,IProjectVariables.FLAG_FIELD_TRANSFER_CALL_BACK__POS).setValue(AppConstant.TRUE);
				}
				
				if(PREDNIS != null && PREDNIS.contains(Uui_Dnis)){
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Transfer Back Call");
					mySession.getVariableField(IProjectVariables.FLAG,IProjectVariables.FLAG_FIELD_TRANSFER_CALL_BACK__PRE).setValue(AppConstant.TRUE);
				}else{
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"First Time Caller");
					
				}
				

			}else {
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"This is a regular call from regular customer.");
			}
		} catch(Exception e){
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR,"ERROR in UUI Data :"+e);
			StackTrace.PrintException(e);
		}
	}
}