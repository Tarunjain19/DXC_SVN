package flow.subflow.PS_Related_Complaints;

/**
 * This servlet is used to forward the request to the entry point of a
 * project callflow (subflow).
 * Last generated by Orchestration Designer at: 2015-APR-27  11:17:43 AM
 */
public class Collect_Account_Number extends com.avaya.sce.runtime.Subflow {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-APR-27  11:17:43 AM
	 */
	public Collect_Account_Number() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the name of the subflow that is being invoked.  This name is used for
	 * determining the URL mapping for the the entry point of the subflow..
	 *
	 * @return the name of the subflow
	 * Last generated by Orchestration Designer at: 2017-AUG-28  03:43:21 PM
	 */
	protected String getSubflowName() {
		return("Collect_Account_Number");
	}
	/**
	 * Returns the name of the mapping of sub flow exit points to the URL mappings
	 * of the servlets to return back to in the calling flow.
	 *
	 * @return map of sub flow exit points to servlets in the calling flow.
	 * Last generated by Orchestration Designer at: 2017-AUG-28  03:43:21 PM
	 */
	protected java.util.Map<String,String> getExitPoints() {
		java.util.Map<String, String> exitPoints;
		exitPoints = new java.util.HashMap<String, String>();
		exitPoints.put("Collect_Account_Number-LinkDown", "PS_Related_Complaints-LinkDown");
		exitPoints.put("Collect_Account_Number-Return", "PS_Related_Complaints-Disconnect");
		exitPoints.put("Collect_Account_Number-registerComplaints", "PS_Related_Complaints-registerComplaints");
		exitPoints.put("Collect_Account_Number-Transfer", "PS_Related_Complaints-Check_IVRType");
		exitPoints.put("Collect_Account_Number-Tagging", "PS_Related_Complaints-Tagging");
		exitPoints.put("Collect_Account_Number-Disconnect", "PS_Related_Complaints-Disconnect");
		return exitPoints;
	}
}
