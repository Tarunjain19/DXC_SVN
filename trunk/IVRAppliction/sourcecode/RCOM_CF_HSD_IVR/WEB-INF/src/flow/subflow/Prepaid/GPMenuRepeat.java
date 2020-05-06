package flow.subflow.Prepaid;

/**
 * This servlet is used to forward the request to the entry point of a
 * project callflow (subflow).
 * Last generated by Orchestration Designer at: 2015-JUL-20  06:50:11 PM
 */
public class GPMenuRepeat extends com.avaya.sce.runtime.Subflow {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-JUL-20  06:50:11 PM
	 */
	public GPMenuRepeat() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the name of the subflow that is being invoked.  This name is used for
	 * determining the URL mapping for the the entry point of the subflow..
	 *
	 * @return the name of the subflow
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:39:00 PM
	 */
	protected String getSubflowName() {
		return("GlobalPrompt");
	}
	/**
	 * Returns the name of the mapping of sub flow exit points to the URL mappings
	 * of the servlets to return back to in the calling flow.
	 *
	 * @return map of sub flow exit points to servlets in the calling flow.
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:39:00 PM
	 */
	protected java.util.Map<String,String> getExitPoints() {
		java.util.Map<String, String> exitPoints;
		exitPoints = new java.util.HashMap<String, String>();
		exitPoints.put("GlobalPrompt-agent", "Prepaid-checkMainMenuCount");
		exitPoints.put("GlobalPrompt-MainMenu", "Prepaid-checkMainMenuCount");
		exitPoints.put("GlobalPrompt-PreviousMenu", "Prepaid-AccountInformMenu");
		exitPoints.put("GlobalPrompt-Repeat", "Prepaid-DataBalance_SuccessAnnc");
		return exitPoints;
	}
}
