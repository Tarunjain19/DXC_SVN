package flow.subflow.AccountInformation;

/**
 * This servlet is used to forward the request to the entry point of a
 * project callflow (subflow).
 * Last generated by Orchestration Designer at: 2015-MAY-04  07:11:11 PM
 */
public class globalMenuStoreAddressLinkDown extends com.avaya.sce.runtime.Subflow {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-04  07:11:11 PM
	 */
	public globalMenuStoreAddressLinkDown() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the name of the subflow that is being invoked.  This name is used for
	 * determining the URL mapping for the the entry point of the subflow..
	 *
	 * @return the name of the subflow
	 * Last generated by Orchestration Designer at: 2017-AUG-28  11:20:52 AM
	 */
	protected String getSubflowName() {
		return("GlobalMenu");
	}
	/**
	 * Returns the name of the mapping of sub flow exit points to the URL mappings
	 * of the servlets to return back to in the calling flow.
	 *
	 * @return map of sub flow exit points to servlets in the calling flow.
	 * Last generated by Orchestration Designer at: 2017-AUG-28  11:20:52 AM
	 */
	protected java.util.Map<String,String> getExitPoints() {
		java.util.Map<String, String> exitPoints;
		exitPoints = new java.util.HashMap<String, String>();
		exitPoints.put("GlobalMenu-MainMenu", "AccountInformation-MainMenu");
		exitPoints.put("GlobalMenu-Previous", "AccountInformation-PaymentInfo_MN_0011");
		exitPoints.put("GlobalMenu-Repeat", "AccountInformation-StoreAddressLinkDown_PA_0068");
		exitPoints.put("GlobalMenu-Transfer", "AccountInformation-Transfer");
		return exitPoints;
	}
}
