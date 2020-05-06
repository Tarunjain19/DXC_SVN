package flow.subflow.Register_MN;

/**
 * This servlet is used to forward the request to the entry point of a
 * project callflow (subflow).
 * Last generated by Orchestration Designer at: 2015-MAY-28  03:52:23 PM
 */
public class RegistredMN_GPFL extends com.avaya.sce.runtime.Subflow {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-28  03:52:23 PM
	 */
	public RegistredMN_GPFL() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the name of the subflow that is being invoked.  This name is used for
	 * determining the URL mapping for the the entry point of the subflow..
	 *
	 * @return the name of the subflow
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:48 PM
	 */
	protected String getSubflowName() {
		return("GlobalFeaturePrompt");
	}
	/**
	 * Returns the name of the mapping of sub flow exit points to the URL mappings
	 * of the servlets to return back to in the calling flow.
	 *
	 * @return map of sub flow exit points to servlets in the calling flow.
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:48 PM
	 */
	protected java.util.Map<String,String> getExitPoints() {
		java.util.Map<String, String> exitPoints;
		exitPoints = new java.util.HashMap<String, String>();
		exitPoints.put("GlobalFeaturePrompt-agent", "Register_MN-transfer");
		exitPoints.put("GlobalFeaturePrompt-MainMenu", "Register_MN-mainmenu");
		exitPoints.put("GlobalFeaturePrompt-PreviousMenu", "Register_MN-previous");
		exitPoints.put("GlobalFeaturePrompt-Repeat", "Register_MN-MNRegistered_Annc");
		exitPoints.put("GlobalFeaturePrompt-thank_you", "Register_MN-thank_you");
		return exitPoints;
	}
}