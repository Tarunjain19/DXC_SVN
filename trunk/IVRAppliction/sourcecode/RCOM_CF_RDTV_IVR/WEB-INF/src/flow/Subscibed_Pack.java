package flow;

/**
 * This servlet is used to forward the request to the entry point of a
 * project callflow (subflow).
 * Last generated by Orchestration Designer at: 2015-MAY-29  02:24:08 PM
 */
public class Subscibed_Pack extends com.avaya.sce.runtime.Subflow {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-29  02:24:08 PM
	 */
	public Subscibed_Pack() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the name of the subflow that is being invoked.  This name is used for
	 * determining the URL mapping for the the entry point of the subflow..
	 *
	 * @return the name of the subflow
	 * Last generated by Orchestration Designer at: 2015-SEP-02  02:56:05 PM
	 */
	protected String getSubflowName() {
		return("Subscribed_Pack");
	}
	/**
	 * Returns the name of the mapping of sub flow exit points to the URL mappings
	 * of the servlets to return back to in the calling flow.
	 *
	 * @return map of sub flow exit points to servlets in the calling flow.
	 * Last generated by Orchestration Designer at: 2015-SEP-02  02:56:05 PM
	 */
	protected java.util.Map<String,String> getExitPoints() {
		java.util.Map<String, String> exitPoints;
		exitPoints = new java.util.HashMap<String, String>();
		exitPoints.put("Subscribed_Pack-latest_movies_services", "null");
		exitPoints.put("Subscribed_Pack-LinkDown", "null");
		exitPoints.put("Subscribed_Pack-mainmenu", "null");
		exitPoints.put("Subscribed_Pack-previous", "null");
		exitPoints.put("Subscribed_Pack-transfer", "null");
		exitPoints.put("Subscribed_Pack-tries_exceed", "null");
		exitPoints.put("Subscribed_Pack-recharge_account", "RechargeAccount");
		return exitPoints;
	}
}