package flow.subflow.ServiceManagement;

/**
 * This servlet is used to forward the request to the entry point of a
 * project callflow (subflow).
 * Last generated by Orchestration Designer at: 2015-MAY-25  09:16:12 PM
 */
public class NumberVerification extends com.avaya.sce.runtime.Subflow {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-25  09:16:12 PM
	 */
	public NumberVerification() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the name of the subflow that is being invoked.  This name is used for
	 * determining the URL mapping for the the entry point of the subflow..
	 *
	 * @return the name of the subflow
	 * Last generated by Orchestration Designer at: 2015-NOV-08  05:50:18 PM
	 */
	protected String getSubflowName() {
		return("NumberVerification");
	}
	/**
	 * Returns the name of the mapping of sub flow exit points to the URL mappings
	 * of the servlets to return back to in the calling flow.
	 *
	 * @return map of sub flow exit points to servlets in the calling flow.
	 * Last generated by Orchestration Designer at: 2015-NOV-08  05:50:18 PM
	 */
	protected java.util.Map<String,String> getExitPoints() {
		java.util.Map<String, String> exitPoints;
		exitPoints = new java.util.HashMap<String, String>();
		exitPoints.put("NumberVerification-Disconnect", "ServiceManagement-Disconnect");
		exitPoints.put("NumberVerification-LinkDown", "ServiceManagement-LinkDown");
		exitPoints.put("NumberVerification-MainMenu", "ServiceManagement-MainMenu");
		exitPoints.put("NumberVerification-Previous", "ServiceManagement-MakePayment_MN_0032");
		exitPoints.put("NumberVerification-Transfer", "ServiceManagement-Transfer");
		exitPoints.put("NumberVerification-ValidNumber", "ServiceManagement-CreditCardEntry");
		return exitPoints;
	}
}
