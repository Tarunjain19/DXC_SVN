package flow.subflow.PostpaidAccountInformation;

/**
 * This servlet is used to forward the request to the entry point of a
 * project callflow (subflow).
 * Last generated by Orchestration Designer at: 2015-JUL-09  11:45:18 AM
 */
public class SF_StoreAddress_1 extends com.avaya.sce.runtime.Subflow {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-JUL-09  11:45:18 AM
	 */
	public SF_StoreAddress_1() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the name of the subflow that is being invoked.  This name is used for
	 * determining the URL mapping for the the entry point of the subflow..
	 *
	 * @return the name of the subflow
	 * Last generated by Orchestration Designer at: 2017-JUL-05  10:39:11 AM
	 */
	protected String getSubflowName() {
		return("StoreAddress");
	}
	/**
	 * Returns the name of the mapping of sub flow exit points to the URL mappings
	 * of the servlets to return back to in the calling flow.
	 *
	 * @return map of sub flow exit points to servlets in the calling flow.
	 * Last generated by Orchestration Designer at: 2017-JUL-05  10:39:11 AM
	 */
	protected java.util.Map<String,String> getExitPoints() {
		java.util.Map<String, String> exitPoints;
		exitPoints = new java.util.HashMap<String, String>();
		exitPoints.put("StoreAddress-CheckServiceType", "PostpaidAccountInformation-Transfer");
		exitPoints.put("StoreAddress-Linkdown", "PostpaidAccountInformation-Linkdown");
		exitPoints.put("StoreAddress-PostpaidMainMenu", "PostpaidAccountInformation-PostpaidMainMenu");
		exitPoints.put("StoreAddress-PrepaidMainMenu", "PostpaidAccountInformation-PrepaidMainMenu");
		exitPoints.put("StoreAddress-PreviousMenu", "PostpaidAccountInformation-BillPaymentInfo_MN_0008");
		exitPoints.put("StoreAddress-ProspectMainMenu", "PostpaidAccountInformation-ProspectMainMenu");
		return exitPoints;
	}
}