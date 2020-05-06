package flow;

/**
 * This servlet is used to forward the request to the entry point of a
 * project callflow (subflow).
 * Last generated by Orchestration Designer at: 2015-MAY-29  02:32:11 PM
 */
public class Top_Up_Packs extends com.avaya.sce.runtime.Subflow {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-29  02:32:11 PM
	 */
	public Top_Up_Packs() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the name of the subflow that is being invoked.  This name is used for
	 * determining the URL mapping for the the entry point of the subflow..
	 *
	 * @return the name of the subflow
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:38 PM
	 */
	protected String getSubflowName() {
		return("Top_Up_Packs");
	}
	/**
	 * Returns the name of the mapping of sub flow exit points to the URL mappings
	 * of the servlets to return back to in the calling flow.
	 *
	 * @return map of sub flow exit points to servlets in the calling flow.
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:38 PM
	 */
	protected java.util.Map<String,String> getExitPoints() {
		java.util.Map<String, String> exitPoints;
		exitPoints = new java.util.HashMap<String, String>();
		exitPoints.put("Top_Up_Packs-triesexceed", "Tries_ExceedAnncom");
		exitPoints.put("Top_Up_Packs-transfer", "Transfer_Annc");
		exitPoints.put("Top_Up_Packs-mainmenu", "check_AccessedMainMenu");
		exitPoints.put("Top_Up_Packs-link_down", "LinkDownAnnc");
		exitPoints.put("Top_Up_Packs-previous", "checkTopUpPrevious");
		exitPoints.put("Top_Up_Packs-atom_transfer", "DataTransfer");
		exitPoints.put("Top_Up_Packs-collectSCN", "Collect_SmartCardNumber");
		return exitPoints;
	}
}
