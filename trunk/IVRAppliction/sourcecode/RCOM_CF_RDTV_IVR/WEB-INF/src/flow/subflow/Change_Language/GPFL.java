package flow.subflow.Change_Language;

/**
 * This servlet is used to forward the request to the entry point of a
 * project callflow (subflow).
 * Last generated by Orchestration Designer at: 2015-JUN-16  09:15:28 PM
 */
public class GPFL extends com.avaya.sce.runtime.Subflow {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-JUN-16  09:15:28 PM
	 */
	public GPFL() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the name of the subflow that is being invoked.  This name is used for
	 * determining the URL mapping for the the entry point of the subflow..
	 *
	 * @return the name of the subflow
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:46:03 PM
	 */
	protected String getSubflowName() {
		return("GlobalFeaturePrompt");
	}
	/**
	 * Returns the name of the mapping of sub flow exit points to the URL mappings
	 * of the servlets to return back to in the calling flow.
	 *
	 * @return map of sub flow exit points to servlets in the calling flow.
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:46:03 PM
	 */
	protected java.util.Map<String,String> getExitPoints() {
		java.util.Map<String, String> exitPoints;
		exitPoints = new java.util.HashMap<String, String>();
		exitPoints.put("GlobalFeaturePrompt-agent", "Change_Language-agent");
		exitPoints.put("GlobalFeaturePrompt-MainMenu", "Change_Language-main_menu");
		exitPoints.put("GlobalFeaturePrompt-PreviousMenu", "Change_Language-previous");
		exitPoints.put("GlobalFeaturePrompt-Repeat", "Change_Language-ChangeLang_SuccessAnnc");
		exitPoints.put("GlobalFeaturePrompt-thank_you", "Change_Language-thank_you");
		return exitPoints;
	}
}
