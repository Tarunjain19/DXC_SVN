package flow;

/**
 * This servlet is used to forward the request to the entry point of a
 * project callflow (subflow).
 * Last generated by Orchestration Designer at: 2015-MAY-29  02:51:50 PM
 */
public class Cancel_A_PAck2 extends com.avaya.sce.runtime.Subflow {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-29  02:51:50 PM
	 */
	public Cancel_A_PAck2() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the name of the subflow that is being invoked.  This name is used for
	 * determining the URL mapping for the the entry point of the subflow..
	 *
	 * @return the name of the subflow
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:41 PM
	 */
	protected String getSubflowName() {
		return("Cancel_A_Pack");
	}
	/**
	 * Returns the name of the mapping of sub flow exit points to the URL mappings
	 * of the servlets to return back to in the calling flow.
	 *
	 * @return map of sub flow exit points to servlets in the calling flow.
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:41 PM
	 */
	protected java.util.Map<String,String> getExitPoints() {
		java.util.Map<String, String> exitPoints;
		exitPoints = new java.util.HashMap<String, String>();
		exitPoints.put("Cancel_A_Pack-collect_SCN", "Collect_SmartCardNumber");
		exitPoints.put("Cancel_A_Pack-main_menu", "check_AccessedMainMenu");
		exitPoints.put("Cancel_A_Pack-previous", "SubscribedPack_MN");
		exitPoints.put("Cancel_A_Pack-transfer", "Transfer_Annc");
		exitPoints.put("Cancel_A_Pack-tries_exceed", "Tries_ExceedAnncom");
		exitPoints.put("Cancel_A_Pack-link_down", "LinkDownAnnc");
		return exitPoints;
	}
}
