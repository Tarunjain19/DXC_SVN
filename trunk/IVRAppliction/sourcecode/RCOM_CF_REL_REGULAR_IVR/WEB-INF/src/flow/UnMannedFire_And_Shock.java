package flow;

/**
 * This servlet is used to forward the request to the entry point of a
 * project callflow (subflow).
 * Last generated by Orchestration Designer at: 2016-NOV-09  10:47:29 PM
 */
public class UnMannedFire_And_Shock extends com.avaya.sce.runtime.Subflow {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2016-NOV-09  10:47:29 PM
	 */
	public UnMannedFire_And_Shock() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the name of the subflow that is being invoked.  This name is used for
	 * determining the URL mapping for the the entry point of the subflow..
	 *
	 * @return the name of the subflow
	 * Last generated by Orchestration Designer at: 2017-AUG-28  03:43:16 PM
	 */
	protected String getSubflowName() {
		return("UnManned_Fire_And_Shock");
	}
	/**
	 * Returns the name of the mapping of sub flow exit points to the URL mappings
	 * of the servlets to return back to in the calling flow.
	 *
	 * @return map of sub flow exit points to servlets in the calling flow.
	 * Last generated by Orchestration Designer at: 2017-AUG-28  03:43:16 PM
	 */
	protected java.util.Map<String,String> getExitPoints() {
		java.util.Map<String, String> exitPoints;
		exitPoints = new java.util.HashMap<String, String>();
		exitPoints.put("UnManned_Fire_And_Shock-Disconnect", "DisconnectData");
		exitPoints.put("UnManned_Fire_And_Shock-LinkDown", "Linkdown_PP");
		exitPoints.put("UnManned_Fire_And_Shock-Tagging", "Tagging_BC");
		return exitPoints;
	}
}
