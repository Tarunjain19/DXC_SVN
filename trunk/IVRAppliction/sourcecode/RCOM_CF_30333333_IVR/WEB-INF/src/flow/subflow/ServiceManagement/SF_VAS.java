package flow.subflow.ServiceManagement;

/**
 * This servlet is used to forward the request to the entry point of a
 * project callflow (subflow).
 * Last generated by Orchestration Designer at: 2015-JUL-09  11:56:22 PM
 */
public class SF_VAS extends com.avaya.sce.runtime.Subflow {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-JUL-09  11:56:22 PM
	 */
	public SF_VAS() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the name of the subflow that is being invoked.  This name is used for
	 * determining the URL mapping for the the entry point of the subflow..
	 *
	 * @return the name of the subflow
	 * Last generated by Orchestration Designer at: 2017-JUL-05  10:39:09 AM
	 */
	protected String getSubflowName() {
		return("VAS");
	}
	/**
	 * Returns the name of the mapping of sub flow exit points to the URL mappings
	 * of the servlets to return back to in the calling flow.
	 *
	 * @return map of sub flow exit points to servlets in the calling flow.
	 * Last generated by Orchestration Designer at: 2017-JUL-05  10:39:09 AM
	 */
	protected java.util.Map<String,String> getExitPoints() {
		java.util.Map<String, String> exitPoints;
		exitPoints = new java.util.HashMap<String, String>();
		exitPoints.put("VAS-Agent", "ServiceManagement-Transfer");
		exitPoints.put("VAS-PostpaidMainMenu", "ServiceManagement-PostpaidMainMenu");
		exitPoints.put("VAS-PrepaidMainMenu", "ServiceManagement-PrepaidMainMenu");
		exitPoints.put("VAS-PreviousMenu", "ServiceManagement-ServMgmt_MN_0013");
		exitPoints.put("VAS-ProspectMainMenu", "ServiceManagement-ProspectMainMenu");
		exitPoints.put("VAS-VAS_Linkdown", "ServiceManagement-Linkdown");
		return exitPoints;
	}
}