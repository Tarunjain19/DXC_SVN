package flow.subflow.ProductsAndOffers;

/**
 * This servlet is used to forward the request to the entry point of a
 * project callflow (subflow).
 * Last generated by Orchestration Designer at: 2015-MAY-08  04:29:01 PM
 */
public class NumberVerification extends com.avaya.sce.runtime.Subflow {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-08  04:29:01 PM
	 */
	public NumberVerification() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the name of the subflow that is being invoked.  This name is used for
	 * determining the URL mapping for the the entry point of the subflow..
	 *
	 * @return the name of the subflow
	 * Last generated by Orchestration Designer at: 2017-AUG-28  11:20:44 AM
	 */
	protected String getSubflowName() {
		return("NumberVerification");
	}
	/**
	 * Returns the name of the mapping of sub flow exit points to the URL mappings
	 * of the servlets to return back to in the calling flow.
	 *
	 * @return map of sub flow exit points to servlets in the calling flow.
	 * Last generated by Orchestration Designer at: 2017-AUG-28  11:20:44 AM
	 */
	protected java.util.Map<String,String> getExitPoints() {
		java.util.Map<String, String> exitPoints;
		exitPoints = new java.util.HashMap<String, String>();
		exitPoints.put("NumberVerification-Disconnect", "ProductsAndOffers-Disconnect");
		exitPoints.put("NumberVerification-LinkDown", "ProductsAndOffers-LinkDown");
		exitPoints.put("NumberVerification-MainMenu", "ProductsAndOffers-MainMenu");
		exitPoints.put("NumberVerification-Previous", "ProductsAndOffers-CheckOfferType");
		exitPoints.put("NumberVerification-Transfer", "ProductsAndOffers-Transfer");
		exitPoints.put("NumberVerification-ValidNumber", "ProductsAndOffers-ActivateOffer_MN_0028");
		return exitPoints;
	}
}
