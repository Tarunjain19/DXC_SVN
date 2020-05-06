package flow;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;

import com.rcom.secretariat.Constants;
import com.servion.util.AppProperties;


/**
 * A basic servlet which allows a user to define their code, generate
 * any output, and to select where to transition to next.
 * Last generated by Orchestration Designer at: 2015-MAR-19  12:35:11 PM
 */
public class LoadOnStartup extends com.avaya.sce.runtime.BasicServlet {
	
	public static Logger logger = Logger.getLogger(LoadOnStartup.class);

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	@Override
	public void init() throws ServletException {
		
		super.init();
		
		logger.debug("Load On Startup Entry");
		
		String path = this.getServletContext().getInitParameter(Constants.IVR_CONFIG_PATH);
		String IVRfileName = this.getServletContext().getInitParameter(Constants.IVR_CONFIG_FILE_NAME);
		String DBfileName = this.getServletContext().getInitParameter(Constants.DB_CONFIG_FILE_NAME);
		
		logger.debug("IVR Config path : " +path);
		logger.debug("IVR Config File Name : " +IVRfileName);
		logger.debug("DB Config File Name : " +DBfileName);
		
		System.out.println("IVR Config path : " +path);
		System.out.println("IVR Config File Name : " +IVRfileName);
		System.out.println("DB Config File Name : " +DBfileName);
		
		Constants.IVR_CONFIG = IVRfileName;
		
		AppProperties.setInstance(DBfileName, path);
		AppProperties.setInstance(IVRfileName, path);
		logger.debug("Load On Startup Exit");
	}
	
	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAR-19  12:35:11 PM
	 */
	public LoadOnStartup() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
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
	 * Last generated by Orchestration Designer at: 2015-MAR-19  12:35:11 PM
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
	 * Last generated by Orchestration Designer at: 2017-JUL-03  11:47:32 AM
	 */
	public java.util.Collection getBranches(com.avaya.sce.runtimecommon.SCESession mySession) {
		java.util.List list = null;
		com.avaya.sce.runtime.Goto aGoto = null;
		list = new java.util.ArrayList(1);

		aGoto = new com.avaya.sce.runtime.Goto("Capture_ANI_DNIS_BC", 0, true, "Default");
		list.add(aGoto);

		return list;
	}
}
