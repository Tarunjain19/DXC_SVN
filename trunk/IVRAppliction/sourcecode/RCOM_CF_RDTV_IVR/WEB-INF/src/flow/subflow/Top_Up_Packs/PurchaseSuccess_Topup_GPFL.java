package flow.subflow.Top_Up_Packs;

/**
 * This servlet is used to forward the request to the entry point of a
 * project callflow (subflow).
 * Last generated by Orchestration Designer at: 2015-SEP-08  04:00:27 PM
 */
public class PurchaseSuccess_Topup_GPFL extends com.avaya.sce.runtime.Subflow {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-SEP-08  04:00:27 PM
	 */
	public PurchaseSuccess_Topup_GPFL() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the name of the subflow that is being invoked.  This name is used for
	 * determining the URL mapping for the the entry point of the subflow..
	 *
	 * @return the name of the subflow
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:43 PM
	 */
	protected String getSubflowName() {
		return("GlobalFeaturePrompt");
	}
	/**
	 * Returns the name of the mapping of sub flow exit points to the URL mappings
	 * of the servlets to return back to in the calling flow.
	 *
	 * @return map of sub flow exit points to servlets in the calling flow.
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:43 PM
	 */
	protected java.util.Map<String,String> getExitPoints() {
		java.util.Map<String, String> exitPoints;
		exitPoints = new java.util.HashMap<String, String>();
		exitPoints.put("GlobalFeaturePrompt-agent", "Top_Up_Packs-transfer");
		exitPoints.put("GlobalFeaturePrompt-MainMenu", "Top_Up_Packs-mainmenu");
		exitPoints.put("GlobalFeaturePrompt-PreviousMenu", "Top_Up_Packs-SetTopUpMain");
		exitPoints.put("GlobalFeaturePrompt-Repeat", "Top_Up_Packs-ReqSuccessful_Top_PP");
		exitPoints.put("GlobalFeaturePrompt-thank_you", "Top_Up_Packs-Tries_ExceedAnnmt");
		return exitPoints;
	}
}