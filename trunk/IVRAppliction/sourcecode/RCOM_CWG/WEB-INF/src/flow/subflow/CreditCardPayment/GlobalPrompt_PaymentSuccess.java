package flow.subflow.CreditCardPayment;

/**
 * This servlet is used to forward the request to the entry point of a
 * project callflow (subflow).
 * Last generated by Orchestration Designer at: 2015-MAY-14  04:40:36 PM
 */
public class GlobalPrompt_PaymentSuccess extends com.avaya.sce.runtime.Subflow {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-14  04:40:36 PM
	 */
	public GlobalPrompt_PaymentSuccess() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the name of the subflow that is being invoked.  This name is used for
	 * determining the URL mapping for the the entry point of the subflow..
	 *
	 * @return the name of the subflow
	 * Last generated by Orchestration Designer at: 2015-NOV-08  05:50:21 PM
	 */
	protected String getSubflowName() {
		return("GlobalMenu");
	}
	/**
	 * Returns the name of the mapping of sub flow exit points to the URL mappings
	 * of the servlets to return back to in the calling flow.
	 *
	 * @return map of sub flow exit points to servlets in the calling flow.
	 * Last generated by Orchestration Designer at: 2015-NOV-08  05:50:21 PM
	 */
	protected java.util.Map<String,String> getExitPoints() {
		java.util.Map<String, String> exitPoints;
		exitPoints = new java.util.HashMap<String, String>();
		exitPoints.put("GlobalMenu-MainMenu", "CreditCardPayment-MainMenu");
		exitPoints.put("GlobalMenu-Previous", "CreditCardPayment-OTP_MN_0039");
		exitPoints.put("GlobalMenu-Repeat", "CreditCardPayment-PaymentSuccess_PA_0081");
		exitPoints.put("GlobalMenu-Transfer", "CreditCardPayment-Transfer");
		return exitPoints;
	}
}
