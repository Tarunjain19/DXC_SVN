package flow.subflow.RechargeAcUsingCashCard;

/**
 * This servlet is the exit point of a subflow.  The base class handles
 * the logic for forwarding to the next servlet.
 * Last generated by Orchestration Designer at: 2015-JUN-01  03:39:40 PM
 */
public class GlobalPromptFeature extends com.avaya.sce.runtime.SubflowReturn {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-JUN-01  03:39:40 PM
	 */
	public GlobalPromptFeature() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the name of the subflow that is being invoked.  This name is used for
	 * determining the URL mapping for the the entry point of the subflow..
	 *
	 * @return the name of the subflow
	 * Last generated by Orchestration Designer at: 2015-JUN-04  08:58:19 PM
	 */
	protected String getSubflowName() {
		return("GlobalPromptFL");
	}
	/**
	 * Returns the name of the mapping of sub flow exit points to the URL mappings
	 * of the servlets to return back to in the calling flow.
	 *
	 * @return map of sub flow exit points to servlets in the calling flow.
	 * Last generated by Orchestration Designer at: 2015-JUN-04  08:58:19 PM
	 */
	protected java.util.Map<String,String> getExitPoints() {
		java.util.Map<String, String> exitPoints;
		exitPoints = new java.util.HashMap<String, String>();
		exitPoints.put("GlobalPromptFL-Agent", "RechargeAcUsingCashCard-Agent");
		exitPoints.put("GlobalPromptFL-CallEnd", "RechargeAcUsingCashCard-CallEnd");
		exitPoints.put("GlobalPromptFL-MainMenu", "RechargeAcUsingCashCard-MainMenu");
		exitPoints.put("GlobalPromptFL-MultiMainMenu", "RechargeAcUsingCashCard-MultiMainMenu");
		exitPoints.put("GlobalPromptFL-PreviousMenu", "RechargeAcUsingCashCard-GetCashCardNo_MN");
		exitPoints.put("GlobalPromptFL-Repeat", "RechargeAcUsingCashCard-BalanceAnnc");
		return exitPoints;
	}
}
