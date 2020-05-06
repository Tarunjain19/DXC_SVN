package flow.subflow.Recharge_Account;

/**
 * This servlet is used to forward the request to the entry point of a
 * project callflow (subflow).
 * Last generated by Orchestration Designer at: 2015-MAY-29  11:55:55 AM
 */
public class Recharge_Account_Using_CashCard extends com.avaya.sce.runtime.Subflow {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-29  11:55:55 AM
	 */
	public Recharge_Account_Using_CashCard() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the name of the subflow that is being invoked.  This name is used for
	 * determining the URL mapping for the the entry point of the subflow..
	 *
	 * @return the name of the subflow
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:54 PM
	 */
	protected String getSubflowName() {
		return("Recharge_Account_Using_Cash_Card");
	}
	/**
	 * Returns the name of the mapping of sub flow exit points to the URL mappings
	 * of the servlets to return back to in the calling flow.
	 *
	 * @return map of sub flow exit points to servlets in the calling flow.
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:54 PM
	 */
	protected java.util.Map<String,String> getExitPoints() {
		java.util.Map<String, String> exitPoints;
		exitPoints = new java.util.HashMap<String, String>();
		exitPoints.put("Recharge_Account_Using_Cash_Card-collect_SCN", "Recharge_Account-Collect_SCN");
		exitPoints.put("Recharge_Account_Using_Cash_Card-recharge_account", "Recharge_Account-Switch_ONAnnc");
		exitPoints.put("Recharge_Account_Using_Cash_Card-tries_exceed", "Recharge_Account-tries_exceed");
		exitPoints.put("Recharge_Account_Using_Cash_Card-transfer", "Recharge_Account-transfer");
		exitPoints.put("Recharge_Account_Using_Cash_Card-mainmenu", "Recharge_Account-mainmenu");
		exitPoints.put("Recharge_Account_Using_Cash_Card-previous", "Recharge_Account-RechargeMN");
		exitPoints.put("Recharge_Account_Using_Cash_Card-link_down", "Recharge_Account-link_down");
		exitPoints.put("Recharge_Account_Using_Cash_Card-From_Balance_Check", "Recharge_Account-FromBalanceCheck");
		return exitPoints;
	}
}