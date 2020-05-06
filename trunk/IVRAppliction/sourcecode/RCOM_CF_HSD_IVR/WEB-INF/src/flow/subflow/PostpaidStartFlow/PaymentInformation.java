package flow.subflow.PostpaidStartFlow;

/**
 * This servlet is used to forward the request to the entry point of a
 * project callflow (subflow).
 * Last generated by Orchestration Designer at: 2015-JUN-08  07:14:51 PM
 */
public class PaymentInformation extends com.avaya.sce.runtime.Subflow {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-JUN-08  07:14:51 PM
	 */
	public PaymentInformation() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the name of the subflow that is being invoked.  This name is used for
	 * determining the URL mapping for the the entry point of the subflow..
	 *
	 * @return the name of the subflow
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:39:07 PM
	 */
	protected String getSubflowName() {
		return("AccountInformation");
	}
	/**
	 * Returns the name of the mapping of sub flow exit points to the URL mappings
	 * of the servlets to return back to in the calling flow.
	 *
	 * @return map of sub flow exit points to servlets in the calling flow.
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:39:07 PM
	 */
	protected java.util.Map<String,String> getExitPoints() {
		java.util.Map<String, String> exitPoints;
		exitPoints = new java.util.HashMap<String, String>();
		exitPoints.put("AccountInformation-Disconnect", "PostpaidStartFlow-PostpaidDisconnect");
		exitPoints.put("AccountInformation-LinkDown", "PostpaidStartFlow-PostpaidLinkdown");
		exitPoints.put("AccountInformation-MainMenu", "PostpaidStartFlow-Initialize_MN_0005");
		exitPoints.put("AccountInformation-PreviousMenu", "PostpaidStartFlow-MakePayment_MN_0001");
		exitPoints.put("AccountInformation-Transfer", "PostpaidStartFlow-PostpaidTransfer");
		return exitPoints;
	}
}