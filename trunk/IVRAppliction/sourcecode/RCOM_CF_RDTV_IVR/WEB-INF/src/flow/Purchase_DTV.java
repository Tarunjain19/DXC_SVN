package flow;

/**
 * This servlet is used to forward the request to the entry point of a
 * project callflow (subflow).
 * Last generated by Orchestration Designer at: 2015-MAY-29  11:11:53 AM
 */
public class Purchase_DTV extends com.avaya.sce.runtime.Subflow {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-29  11:11:53 AM
	 */
	public Purchase_DTV() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the name of the subflow that is being invoked.  This name is used for
	 * determining the URL mapping for the the entry point of the subflow..
	 *
	 * @return the name of the subflow
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:37 PM
	 */
	protected String getSubflowName() {
		return("Purchase_DTV_and_Validate_Coupon");
	}
	/**
	 * Returns the name of the mapping of sub flow exit points to the URL mappings
	 * of the servlets to return back to in the calling flow.
	 *
	 * @return map of sub flow exit points to servlets in the calling flow.
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:37 PM
	 */
	protected java.util.Map<String,String> getExitPoints() {
		java.util.Map<String, String> exitPoints;
		exitPoints = new java.util.HashMap<String, String>();
		exitPoints.put("Purchase_DTV_and_Validate_Coupon-transfer", "Transfer_Annc");
		exitPoints.put("Purchase_DTV_and_Validate_Coupon-tries_exceed", "Thank_YouAnnc");
		exitPoints.put("Purchase_DTV_and_Validate_Coupon-link_down", "LinkDownAnnc");
		return exitPoints;
	}
}