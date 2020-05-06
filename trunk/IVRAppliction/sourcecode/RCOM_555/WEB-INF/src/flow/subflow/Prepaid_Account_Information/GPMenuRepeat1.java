package flow.subflow.Prepaid_Account_Information;

/**
 * This servlet is used to forward the request to the entry point of a
 * project callflow (subflow).
 * Last generated by Orchestration Designer at: 2015-MAR-12  06:45:45 PM
 */
public class GPMenuRepeat1 extends com.avaya.sce.runtime.Subflow {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAR-12  06:45:45 PM
	 */
	public GPMenuRepeat1() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the name of the subflow that is being invoked.  This name is used for
	 * determining the URL mapping for the the entry point of the subflow..
	 *
	 * @return the name of the subflow
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:59 PM
	 */
	protected String getSubflowName() {
		return("Prepaid_GlobalPrompt");
	}
	/**
	 * Returns the name of the mapping of sub flow exit points to the URL mappings
	 * of the servlets to return back to in the calling flow.
	 *
	 * @return map of sub flow exit points to servlets in the calling flow.
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:59 PM
	 */
	protected java.util.Map<String,String> getExitPoints() {
		java.util.Map<String, String> exitPoints;
		exitPoints = new java.util.HashMap<String, String>();
		exitPoints.put("Prepaid_GlobalPrompt-agent", "Prepaid_Account_Information-AgentTransfer");
		exitPoints.put("Prepaid_GlobalPrompt-MainMenu", "Prepaid_Account_Information-MainMenu");
		exitPoints.put("Prepaid_GlobalPrompt-PreviousMenu", "Prepaid_Account_Information-TGSM_MN_0005");
		exitPoints.put("Prepaid_GlobalPrompt-Repeat", "Prepaid_Account_Information-Set_TGSM_PA_0021");
		return exitPoints;
	}
}
