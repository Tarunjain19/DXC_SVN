package flow.subflow.ServiceManagement;

/**
 * This servlet is used to forward the request to the entry point of a
 * project callflow (subflow).
 * Last generated by Orchestration Designer at: 2015-MAY-05  12:42:20 PM
 */
public class HotFlash_SM extends com.avaya.sce.runtime.Subflow {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-05  12:42:20 PM
	 */
	public HotFlash_SM() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the name of the subflow that is being invoked.  This name is used for
	 * determining the URL mapping for the the entry point of the subflow..
	 *
	 * @return the name of the subflow
	 * Last generated by Orchestration Designer at: 2015-NOV-08  05:50:17 PM
	 */
	protected String getSubflowName() {
		return("HotFlash");
	}
	/**
	 * Returns the name of the mapping of sub flow exit points to the URL mappings
	 * of the servlets to return back to in the calling flow.
	 *
	 * @return map of sub flow exit points to servlets in the calling flow.
	 * Last generated by Orchestration Designer at: 2015-NOV-08  05:50:17 PM
	 */
	protected java.util.Map<String,String> getExitPoints() {
		java.util.Map<String, String> exitPoints;
		exitPoints = new java.util.HashMap<String, String>();
		exitPoints.put("HotFlash-HotFlashReturn", "ServiceManagement-ServMgmt_MN_0013");
		return exitPoints;
	}
}