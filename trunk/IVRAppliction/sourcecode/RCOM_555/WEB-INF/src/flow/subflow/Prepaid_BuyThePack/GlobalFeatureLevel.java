package flow.subflow.Prepaid_BuyThePack;

/**
 * This servlet is used to forward the request to the entry point of a
 * project callflow (subflow).
 * Last generated by Orchestration Designer at: 2015-MAR-15  05:11:43 PM
 */
public class GlobalFeatureLevel extends com.avaya.sce.runtime.Subflow {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAR-15  05:11:43 PM
	 */
	public GlobalFeatureLevel() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the name of the subflow that is being invoked.  This name is used for
	 * determining the URL mapping for the the entry point of the subflow..
	 *
	 * @return the name of the subflow
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:57 PM
	 */
	protected String getSubflowName() {
		return("Prepaid_GlobalPrompt");
	}
	/**
	 * Returns the name of the mapping of sub flow exit points to the URL mappings
	 * of the servlets to return back to in the calling flow.
	 *
	 * @return map of sub flow exit points to servlets in the calling flow.
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:57 PM
	 */
	protected java.util.Map<String,String> getExitPoints() {
		java.util.Map<String, String> exitPoints;
		exitPoints = new java.util.HashMap<String, String>();
		exitPoints.put("Prepaid_GlobalPrompt-agent", "Prepaid_BuyThePack-agent");
		exitPoints.put("Prepaid_GlobalPrompt-MainMenu", "Prepaid_BuyThePack-Mainmenu");
		exitPoints.put("Prepaid_GlobalPrompt-PreviousMenu", "Prepaid_BuyThePack-CheckRCV");
		exitPoints.put("Prepaid_GlobalPrompt-Repeat", "Prepaid_BuyThePack-PayCoreBalSuccess");
		return exitPoints;
	}
}
