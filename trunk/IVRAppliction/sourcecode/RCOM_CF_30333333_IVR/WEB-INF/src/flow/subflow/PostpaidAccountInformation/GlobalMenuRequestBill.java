package flow.subflow.PostpaidAccountInformation;

/**
 * This servlet is used to forward the request to the entry point of a
 * project callflow (subflow).
 * Last generated by Orchestration Designer at: 2015-APR-15  08:54:55 PM
 */
public class GlobalMenuRequestBill extends com.avaya.sce.runtime.Subflow {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-APR-15  08:54:55 PM
	 */
	public GlobalMenuRequestBill() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the name of the subflow that is being invoked.  This name is used for
	 * determining the URL mapping for the the entry point of the subflow..
	 *
	 * @return the name of the subflow
	 * Last generated by Orchestration Designer at: 2017-JUL-05  10:39:10 AM
	 */
	protected String getSubflowName() {
		return("GlobalPrompt");
	}
	/**
	 * Returns the name of the mapping of sub flow exit points to the URL mappings
	 * of the servlets to return back to in the calling flow.
	 *
	 * @return map of sub flow exit points to servlets in the calling flow.
	 * Last generated by Orchestration Designer at: 2017-JUL-05  10:39:10 AM
	 */
	protected java.util.Map<String,String> getExitPoints() {
		java.util.Map<String, String> exitPoints;
		exitPoints = new java.util.HashMap<String, String>();
		exitPoints.put("GlobalPrompt-agent", "PostpaidAccountInformation-Transfer");
		exitPoints.put("GlobalPrompt-PostpaidMainMenu", "PostpaidAccountInformation-PostpaidMainMenu");
		exitPoints.put("GlobalPrompt-PrepaidMainMenu", "PostpaidAccountInformation-PrepaidMainMenu");
		exitPoints.put("GlobalPrompt-PreviousMenu", "PostpaidAccountInformation-CheckBill_MN_0009");
		exitPoints.put("GlobalPrompt-ProspectMainMenu", "PostpaidAccountInformation-ProspectMainMenu");
		exitPoints.put("GlobalPrompt-Repeat", "PostpaidAccountInformation-Initialize_PA_0028");
		return exitPoints;
	}
}
