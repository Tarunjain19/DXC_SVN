package flow.subflow.BuyThePack;

/**
 * This servlet is used to forward the request to the entry point of a
 * project callflow (subflow).
 * Last generated by Orchestration Designer at: 2015-MAR-15  05:11:43 PM
 */
public class GlobalFeatureLevelProcessPayFail extends com.avaya.sce.runtime.Subflow {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAR-15  05:11:43 PM
	 */
	public GlobalFeatureLevelProcessPayFail() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the name of the subflow that is being invoked.  This name is used for
	 * determining the URL mapping for the the entry point of the subflow..
	 *
	 * @return the name of the subflow
	 * Last generated by Orchestration Designer at: 2017-AUG-29  03:09:24 PM
	 */
	protected String getSubflowName() {
		return("GlobalPrompt");
	}
	/**
	 * Returns the name of the mapping of sub flow exit points to the URL mappings
	 * of the servlets to return back to in the calling flow.
	 *
	 * @return map of sub flow exit points to servlets in the calling flow.
	 * Last generated by Orchestration Designer at: 2017-AUG-29  03:09:24 PM
	 */
	protected java.util.Map<String,String> getExitPoints() {
		java.util.Map<String, String> exitPoints;
		exitPoints = new java.util.HashMap<String, String>();
		exitPoints.put("GlobalPrompt-agent", "BuyThePack-agent");
		exitPoints.put("GlobalPrompt-MainMenu", "BuyThePack-Mainmenu");
		exitPoints.put("GlobalPrompt-PreviousMenu", "BuyThePack-OTPGenerateMenu");
		exitPoints.put("GlobalPrompt-Repeat", "BuyThePack-PaymentError");
		return exitPoints;
	}
}