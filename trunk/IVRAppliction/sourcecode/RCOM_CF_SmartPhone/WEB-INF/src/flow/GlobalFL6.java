package flow;

/**
 * This servlet is used to forward the request to the entry point of a
 * project callflow (subflow).
 * Last generated by Orchestration Designer at: 2015-SEP-24  06:23:37 PM
 */
public class GlobalFL6 extends com.avaya.sce.runtime.Subflow {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-SEP-24  06:23:37 PM
	 */
	public GlobalFL6() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the name of the subflow that is being invoked.  This name is used for
	 * determining the URL mapping for the the entry point of the subflow..
	 *
	 * @return the name of the subflow
	 * Last generated by Orchestration Designer at: 2017-SEP-13  03:14:22 PM
	 */
	protected String getSubflowName() {
		return("GlobalPrompt");
	}
	/**
	 * Returns the name of the mapping of sub flow exit points to the URL mappings
	 * of the servlets to return back to in the calling flow.
	 *
	 * @return map of sub flow exit points to servlets in the calling flow.
	 * Last generated by Orchestration Designer at: 2017-SEP-13  03:14:22 PM
	 */
	protected java.util.Map<String,String> getExitPoints() {
		java.util.Map<String, String> exitPoints;
		exitPoints = new java.util.HashMap<String, String>();
		exitPoints.put("GlobalPrompt-agent", "TransferAgent");
		exitPoints.put("GlobalPrompt-MainMenu", "Postpaid_MainMenu");
		exitPoints.put("GlobalPrompt-PreviousMenu", "AccountInfoMenu");
		exitPoints.put("GlobalPrompt-Repeat", "LastPaymentInfo");
		return exitPoints;
	}
}
