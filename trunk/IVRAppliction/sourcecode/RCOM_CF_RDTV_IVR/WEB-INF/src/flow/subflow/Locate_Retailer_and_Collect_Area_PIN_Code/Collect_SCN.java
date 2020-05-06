package flow.subflow.Locate_Retailer_and_Collect_Area_PIN_Code;

/**
 * This servlet is used to forward the request to the entry point of a
 * project callflow (subflow).
 * Last generated by Orchestration Designer at: 2015-JUL-07  05:55:21 PM
 */
public class Collect_SCN extends com.avaya.sce.runtime.Subflow {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-JUL-07  05:55:21 PM
	 */
	public Collect_SCN() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the name of the subflow that is being invoked.  This name is used for
	 * determining the URL mapping for the the entry point of the subflow..
	 *
	 * @return the name of the subflow
	 * Last generated by Orchestration Designer at: 2016-OCT-12  06:43:54 PM
	 */
	protected String getSubflowName() {
		return("Collect_SmartCardNumber");
	}
	/**
	 * Returns the name of the mapping of sub flow exit points to the URL mappings
	 * of the servlets to return back to in the calling flow.
	 *
	 * @return map of sub flow exit points to servlets in the calling flow.
	 * Last generated by Orchestration Designer at: 2016-OCT-12  06:43:54 PM
	 */
	protected java.util.Map<String,String> getExitPoints() {
		java.util.Map<String, String> exitPoints;
		exitPoints = new java.util.HashMap<String, String>();
		exitPoints.put("Collect_SmartCardNumber-link_down", "Locate_Retailer_and_Collect_Area_PIN_Code-linkdown");
		exitPoints.put("Collect_SmartCardNumber-SCN_AccountStatus", "Locate_Retailer_and_Collect_Area_PIN_Code-check_Terminated");
		exitPoints.put("Collect_SmartCardNumber-tries_exceed", "Locate_Retailer_and_Collect_Area_PIN_Code-tries_exceed");
		exitPoints.put("Collect_SmartCardNumber-Loyality_Transfer", "null");
		exitPoints.put("Collect_SmartCardNumber-Loyality_Transfer", "null");
		exitPoints.put("Collect_SmartCardNumber-Loyality_Transfer", "null");
		exitPoints.put("Collect_SmartCardNumber-Loyality_Transfer", "null");
		exitPoints.put("Collect_SmartCardNumber-Loyality_Transfer", "null");
		exitPoints.put("Collect_SmartCardNumber-Loyality_Transfer", "null");
		return exitPoints;
	}
}