package flow;



import javax.servlet.ServletException;

import org.apache.log4j.Logger;


import com.rcom.Data.utils.Constants;

import com.servion.util.AppProperties;

/**
 * A basic servlet which allows a user to define their code, generate
 * any output, and to select where to transition to next.
 * Last generated by Orchestration Designer at: 2015-APR-02  12:33:21 PM
 */
public class LoadOnStartUp extends com.avaya.sce.runtime.BasicServlet {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-APR-02  12:33:21 PM
	 */
	public LoadOnStartUp() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	@Override
	public void init() throws ServletException {
		super.init();
		
		
		
		String ivrConfigFileName = "";
		String propertiesFilePath = "";
		String dynamicConfigFileName = "";
		
		
		String hostConfig =""; 
		Logger logger = null;
		
		
		/** Declaration **/
		System.out.println("Enter Load on start up");
		propertiesFilePath = getServletContext().getInitParameter(Constants.PROPERTY_FILE_PATH);
		ivrConfigFileName  = getServletContext().getInitParameter(Constants.VAS_CONFIG);
		dynamicConfigFileName = getServletContext().getInitParameter(Constants.DYN_MENU);
		
		System.out.println("ConfigFilePath:"+propertiesFilePath);
		System.out.println("ivrConfigFileName:"+ivrConfigFileName);
		System.out.println("dynamicConfigFileName:"+dynamicConfigFileName);
		
		
		
		
		
		
		logger = Logger.getLogger(Constants.LOGGER_NAME);
		
		/**Load Property File **/
		 AppProperties.setInstance(ivrConfigFileName,propertiesFilePath);
		 AppProperties.setInstance(dynamicConfigFileName,propertiesFilePath);
		// AppProperties.setInstance("VAS_CONFIG", "C:\\RCOM\\OtherFlows\\RCOM_CF_VAS\\");
		
		System.out.println("IVR_CONFIG is "+ivrConfigFileName);
		System.out.println("Dynamic Config :"+dynamicConfigFileName);
		String pNames = AppProperties.GetInstance(Constants.VAS_CONFIG).getIVRProp("ApplicationName").trim(); 
		String dmValue = AppProperties.GetInstance(Constants.DYN_MENU).getIVRProp("RCOM_CF_VAS_IVR-MN_001").trim(); 
			System.out.println("dmValue:"+dmValue);	
	}
	
	/**
	 * This method allows for custom integration with other Java components.
	 * You may use Java for sophisticated logic or to integrate with custom
	 * connectors (i.e. JMS, custom web services, sockets, XML, JAXB, etc.)
	 *
	 * Any custom code added here should work as efficiently as possible to prevent delays.
	 * It's important to design your callflow so that the voice browser (Voice Portal/IR)
	 * is not waiting too long for a response as this can lead to a poor caller experience.
	 * Additionally, if the response to the client voice browser exceeds the configured
	 * timeout, the platform may throw an "error.badfetch". 
	 *
	 * Using this method, you have access to all session variables through the 
	 * SCESession object.
	 *
	 * The code generator will *** NOT *** overwrite this method in the future.
	 * Last generated by Orchestration Designer at: 2015-APR-02  12:33:21 PM
	 */
	public void servletImplementation(com.avaya.sce.runtimecommon.SCESession mySession) {

		// TODO: Add your code here!

	}
	/**
	 * Builds the list of branches that are defined for this servlet object.
	 * This list is built automatically by defining Goto nodes in the call flow editor.
	 * It is the programmer's responsibilty to provide at least one enabled Goto.<BR>
	 *
	 * The user should override updateBranches() to determine which Goto that the
	 * framework will activate.  If there is not at least one enabled Goto item, 
	 * the framework will throw a runtime exception.<BR>
	 *
	 * This method is generated automatically and changes to it may
	 * be overwritten next time code is generated.  To modify the list
	 * of branches for the flow item, override:
	 *     <code>updateBranches(Collection branches, SCESession mySession)</code>
	 *
	 * @return a Collection of <code>com.avaya.sce.runtime.Goto</code>
	 * objects that will be evaluated at runtime.  If there are no gotos
	 * defined in the Servlet node, then this returns null.
	 * Last generated by Orchestration Designer at: 2016-DEC-07  03:15:31 PM
	 */
	public java.util.Collection getBranches(com.avaya.sce.runtimecommon.SCESession mySession) {
		java.util.List list = null;
		com.avaya.sce.runtime.Goto aGoto = null;
		list = new java.util.ArrayList(1);

		aGoto = new com.avaya.sce.runtime.Goto("InitializeVariables", 0, true, "Default");
		list.add(aGoto);

		return list;
	}
}
