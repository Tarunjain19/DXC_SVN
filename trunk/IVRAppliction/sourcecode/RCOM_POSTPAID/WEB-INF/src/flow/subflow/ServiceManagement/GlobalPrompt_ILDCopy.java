package flow.subflow.ServiceManagement;

/**
 * This servlet is used to forward the request to the entry point of a
 * project callflow (subflow).
 * Last generated by Orchestration Designer at: 2015-MAY-05  06:43:34 PM
 */
public class GlobalPrompt_ILDCopy extends com.avaya.sce.runtime.Subflow {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-05  06:43:34 PM
	 */
	public GlobalPrompt_ILDCopy() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the name of the subflow that is being invoked.  This name is used for
	 * determining the URL mapping for the the entry point of the subflow..
	 *
	 * @return the name of the subflow
	 * Last generated by Orchestration Designer at: 2017-AUG-28  11:20:41 AM
	 */
	protected String getSubflowName() {
		return("GlobalMenu");
	}
	/**
	 * Returns the name of the mapping of sub flow exit points to the URL mappings
	 * of the servlets to return back to in the calling flow.
	 *
	 * @return map of sub flow exit points to servlets in the calling flow.
	 * Last generated by Orchestration Designer at: 2017-AUG-28  11:20:41 AM
	 */
	protected java.util.Map<String,String> getExitPoints() {
		java.util.Map<String, String> exitPoints;
		exitPoints = new java.util.HashMap<String, String>();
		exitPoints.put("GlobalMenu-MainMenu", "ServiceManagement-MainMenu");
		exitPoints.put("GlobalMenu-Previous", "ServiceManagement-DND_MN_0014");
		exitPoints.put("GlobalMenu-Repeat", "ServiceManagement-PushSMS_PA_0050");
		exitPoints.put("GlobalMenu-Transfer", "ServiceManagement-Transfer");
		return exitPoints;
	}
}
