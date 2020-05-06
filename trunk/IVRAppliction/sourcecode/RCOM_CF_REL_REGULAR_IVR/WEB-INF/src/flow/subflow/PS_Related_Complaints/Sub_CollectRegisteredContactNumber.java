package flow.subflow.PS_Related_Complaints;

/**
 * This servlet is used to forward the request to the entry point of a
 * project callflow (subflow).
 * Last generated by Orchestration Designer at: 2016-NOV-09  10:13:24 AM
 */
public class Sub_CollectRegisteredContactNumber extends com.avaya.sce.runtime.Subflow {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2016-NOV-09  10:13:24 AM
	 */
	public Sub_CollectRegisteredContactNumber() {
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
		return("Collect_Reg_Contact_Num");
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
		exitPoints.put("Collect_Reg_Contact_Num-LinkDown", "PS_Related_Complaints-LinkDown");
		exitPoints.put("Collect_Reg_Contact_Num-Success", "PS_Related_Complaints-registerComplaints");
		exitPoints.put("Collect_Reg_Contact_Num-Tagging", "PS_Related_Complaints-Tagging");
		exitPoints.put("Collect_Reg_Contact_Num-Transfer", "PS_Related_Complaints-Check_IVRType");
		return exitPoints;
	}
}