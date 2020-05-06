package flow.subflow.ServiceManagement;

/**
 * This servlet is used to forward the request to the entry point of a
 * project callflow (subflow).
 * Last generated by Orchestration Designer at: 2015-JUN-09  08:01:08 AM
 */
public class GlobalMenu_GPRS extends com.avaya.sce.runtime.Subflow {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-JUN-09  08:01:08 AM
	 */
	public GlobalMenu_GPRS() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the name of the subflow that is being invoked.  This name is used for
	 * determining the URL mapping for the the entry point of the subflow..
	 *
	 * @return the name of the subflow
	 * Last generated by Orchestration Designer at: 2017-JUL-05  10:39:10 AM
	 */
	protected String getSubflowName() {
		return("GlobalPrompt");
	}
	/**
	 * Returns the name of the mapping of sub flow exit points to the URL mappings
	 * of the servlets to return back to in the calling flow.
	 *
	 * @return map of sub flow exit points to servlets in the calling flow.
	 * Last generated by Orchestration Designer at: 2017-JUL-05  10:39:10 AM
	 */
	protected java.util.Map<String,String> getExitPoints() {
		java.util.Map<String, String> exitPoints;
		exitPoints = new java.util.HashMap<String, String>();
		exitPoints.put("GlobalPrompt-agent", "ServiceManagement-Transfer");
		exitPoints.put("GlobalPrompt-PostpaidMainMenu", "ServiceManagement-PostpaidMainMenu");
		exitPoints.put("GlobalPrompt-PrepaidMainMenu", "ServiceManagement-PrepaidMainMenu");
		exitPoints.put("GlobalPrompt-PreviousMenu", "ServiceManagement-GPRS_MN_0015");
		exitPoints.put("GlobalPrompt-ProspectMainMenu", "ServiceManagement-ProspectMainMenu");
		exitPoints.put("GlobalPrompt-Repeat", "ServiceManagement-PushSMS_PA_0035");
		return exitPoints;
	}
}
