package flow.subflow.EndCallProcess;

/**
 * This servlet is used to forward the request to the entry point of a
 * project callflow (subflow).
 * Last generated by Orchestration Designer at: 2016-JAN-06  04:07:58 PM
 */
public class Call_FlagUpdate extends com.avaya.sce.runtime.Subflow {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2016-JAN-06  04:07:58 PM
	 */
	public Call_FlagUpdate() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the name of the subflow that is being invoked.  This name is used for
	 * determining the URL mapping for the the entry point of the subflow..
	 *
	 * @return the name of the subflow
	 * Last generated by Orchestration Designer at: 2017-JUL-12  01:45:42 PM
	 */
	protected String getSubflowName() {
		return("TVP_DataConscentFlagUpdation");
	}
	/**
	 * Returns the name of the mapping of sub flow exit points to the URL mappings
	 * of the servlets to return back to in the calling flow.
	 *
	 * @return map of sub flow exit points to servlets in the calling flow.
	 * Last generated by Orchestration Designer at: 2017-JUL-12  01:45:42 PM
	 */
	protected java.util.Map<String,String> getExitPoints() {
		java.util.Map<String, String> exitPoints;
		exitPoints = new java.util.HashMap<String, String>();
		exitPoints.put("TVP_DataConscentFlagUpdation-end", "EndCallProcess-Dat_EndCallProcess");
		return exitPoints;
	}
}
