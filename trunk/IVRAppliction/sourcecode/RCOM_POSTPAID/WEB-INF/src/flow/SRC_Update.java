package flow;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.postpaid.model.SRCInfo;
import com.rcom.postpaid.resource.IVRDBServiceInstance;
import com.servion.util.IVRDataBean;
import com.servion.postpaid.utils.PrintStackTrace;
import com.servion.postpaid.utils.Constants;

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
 * Last generated by Orchestration Designer at: 2016-MAR-04  05:56:50 PM
 */
public class SRC_Update extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2016-MAR-04  05:56:50 PM
	 */
	public SRC_Update() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}
	
	@Override
	public void requestBegin(SCESession mySession) {

		/**Declaration **/
		String ani = Constants.EMPTY_STRING,srcStatus = Constants.EMPTY_STRING;
		String appName = Constants.EMPTY_STRING,hostOutput = Constants.ERROR;
		SRCInfo objSRCInfo = null;
		IVRDataBean objIVRDataBean = null;

		ITraceInfo trace = mySession.getTraceOutput();
		
		try {
			
			/**Assigning**/
			ani = mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_ANI).getStringValue();
			appName = mySession.getVariableField(IProjectVariables.APP_NAME).getStringValue();
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"ANI :"+ani +" - App Name :" + appName);
			objSRCInfo = new SRCInfo();
			objIVRDataBean = (IVRDataBean)mySession.getProperty(Constants.IVRDATABEAN);
			
			
			/**DB Hit**/
			objSRCInfo.setMdn(ani);
			objSRCInfo = IVRDBServiceInstance.getInstance().updateSRC(objIVRDataBean,objSRCInfo);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"SRC Update SP :" + objSRCInfo);
			
			if(objSRCInfo!=null){
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"SRC Update SP :" + objSRCInfo.getFlag());
			}else{
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"objSRCInfo Object is null");
			}
			
		} catch (Exception e) {
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "Error in SRC Update :" +e);
			mySession.getVariableField(IProjectVariables.FLAG,IProjectVariables.FLAG_FIELD_IS_DBDOWN).setValue(Constants.Yes);
			PrintStackTrace.PrintException(e);
		}
		
	
	}
	
	

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-AUG-28  03:36:20 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("SetTransferData", "Default");
		next.setDebugId(6446);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2017-AUG-28  03:36:20 PM
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
	 * Last generated by Orchestration Designer at: 2017-AUG-28  03:36:20 PM
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
}
