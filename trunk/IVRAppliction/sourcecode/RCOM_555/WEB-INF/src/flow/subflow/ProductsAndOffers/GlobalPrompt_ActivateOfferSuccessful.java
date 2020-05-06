package flow.subflow.ProductsAndOffers;

/**
 * This servlet is used to forward the request to the entry point of a
 * project callflow (subflow).
 * Last generated by Orchestration Designer at: 2015-MAY-05  06:43:34 PM
 */
public class GlobalPrompt_ActivateOfferSuccessful extends com.avaya.sce.runtime.Subflow {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-05  06:43:34 PM
	 */
	public GlobalPrompt_ActivateOfferSuccessful() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the name of the subflow that is being invoked.  This name is used for
	 * determining the URL mapping for the the entry point of the subflow..
	 *
	 * @return the name of the subflow
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:47 PM
	 */
	protected String getSubflowName() {
		return("GlobalMenu");
	}
	/**
	 * Returns the name of the mapping of sub flow exit points to the URL mappings
	 * of the servlets to return back to in the calling flow.
	 *
	 * @return map of sub flow exit points to servlets in the calling flow.
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:47 PM
	 */
	protected java.util.Map<String,String> getExitPoints() {
		java.util.Map<String, String> exitPoints;
		exitPoints = new java.util.HashMap<String, String>();
		exitPoints.put("GlobalMenu-MainMenu", "ProductsAndOffers-MainMenu");
		exitPoints.put("GlobalMenu-Previous", "ProductsAndOffers-ActivateOffer_MN_0028");
		exitPoints.put("GlobalMenu-Repeat", "ProductsAndOffers-ActivateOfferSuccessful_PA_0069");
		exitPoints.put("GlobalMenu-Transfer", "ProductsAndOffers-Transfer");
		return exitPoints;
	}
}
