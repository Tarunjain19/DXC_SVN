package flow;


import java.util.Hashtable;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.util.AppConstants;
import com.rcom.util.StackTrace;


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
 * Last generated by Orchestration Designer at: 2015-JUN-25  03:03:44 PM
 */
public class PlayOfferInitial extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-JUN-25  03:03:44 PM
	 */
	public PlayOfferInitial() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2016-OCT-12  02:20:52 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("OfferMsg_PP", "Default");
		next.setDebugId(4877);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2016-OCT-12  02:20:52 PM
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
	 * Last generated by Orchestration Designer at: 2016-OCT-12  02:20:52 PM
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
ITraceInfo trace = mySession.getTraceOutput();
		
		try
		{
			
			String selectedOffer = mySession.getVariableField(IProjectVariables.OFFER__MN, IProjectVariables.OFFER__MN_FIELD_VALUE).getStringValue();
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Selected Offer : "+ selectedOffer);
			
			Hashtable<String, String> htOfferDetails = (Hashtable<String, String>) mySession.getProperty(AppConstants.PREPAID_POSTPAID_SERVICE_OFFERS);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "PREPAID_POSTPAID_SERVICE_OFFERS" + htOfferDetails);
			
			String detailPhrase = htOfferDetails.get(selectedOffer);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Selected Offer Detail Phrase : " + detailPhrase);
			
			mySession.getVariableField(IProjectVariables.DM__INPUT_PATH, IProjectVariables.DM__INPUT_PATH_FIELD_DM__INITIAL_PROMPT).setValue(detailPhrase);
			
			
		}catch(Exception e)
		{
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Exception while selected service offers");
			StackTrace.PrintException(e);
		}
	
}
}
