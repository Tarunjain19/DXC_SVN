package flow.subflow.Account_Information;

/**
 * This servlet is used to forward the request to the entry point of a
 * project callflow (subflow).
 * Last generated by Orchestration Designer at: 2015-JUN-28  04:46:30 PM
 */
public class GPMR extends com.avaya.sce.runtime.Subflow {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-JUN-28  04:46:30 PM
	 */
	public GPMR() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the name of the subflow that is being invoked.  This name is used for
	 * determining the URL mapping for the the entry point of the subflow..
	 *
	 * @return the name of the subflow
	 * Last generated by Orchestration Designer at: 2017-JUL-05  10:39:17 AM
	 */
	protected String getSubflowName() {
		return("GlobalPrompt");
	}
	/**
	 * Returns the name of the mapping of sub flow exit points to the URL mappings
	 * of the servlets to return back to in the calling flow.
	 *
	 * @return map of sub flow exit points to servlets in the calling flow.
	 * Last generated by Orchestration Designer at: 2017-JUL-05  10:39:17 AM
	 */
	protected java.util.Map<String,String> getExitPoints() {
		java.util.Map<String, String> exitPoints;
		exitPoints = new java.util.HashMap<String, String>();
		exitPoints.put("GlobalPrompt-agent", "Account_Information-AgentTransfer");
		exitPoints.put("GlobalPrompt-PostpaidMainMenu", "Account_Information-PostpaidMainMenu");
		exitPoints.put("GlobalPrompt-PrepaidMainMenu", "Account_Information-PrepaidMainMenu");
		exitPoints.put("GlobalPrompt-PreviousMenu", "Account_Information-TGSM_MN_0005");
		exitPoints.put("GlobalPrompt-ProspectMainMenu", "Account_Information-ProspectMainMenu");
		exitPoints.put("GlobalPrompt-Repeat", "Account_Information-ZeroBalSMSAnn");
		return exitPoints;
	}
}
