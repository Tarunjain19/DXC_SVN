package flow;

import java.util.Hashtable;
import java.util.Set;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;

import com.rcom.hni.model.ServiceUpdateInfo;
import com.servion.triplefive.utils.Constants;
import com.servion.triplefive.utils.DBLoadOnStartUp;
import com.servion.triplefive.utils.GlobalPrintStackTrace;
import com.servion.triplefive.utils.LoadAppData;
import com.servion.triplefive.utils.PeriodicChecker;
import com.servion.util.AppProperties;

/**
 * A basic servlet which allows a user to define their code, generate
 * any output, and to select where to transition to next.
 * Last generated by Orchestration Designer at: 2015-APR-13  12:34:34 PM
 */
public class LoadOnStartUp extends com.avaya.sce.runtime.BasicServlet {

	private static Logger logger = Logger.getLogger(Constants.LOGGER_NAME_LOADLEVEL);
	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-APR-13  12:34:34 PM
	 */
	public LoadOnStartUp() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	public void init() throws ServletException 
	{
		try{
			String ivrConfigFileName = Constants.EMPTY_STRING;
			String propertiesFilePath = Constants.EMPTY_STRING;
			String audioConfigFileName = Constants.EMPTY_STRING;
			String appNames = Constants.EMPTY_STRING;
			String appName_555Postpaid = Constants.EMPTY_STRING;
			String appName_555Prepaid = Constants.EMPTY_STRING;
			String hostConfig = Constants.EMPTY_STRING;
			
			Hashtable<String,Hashtable<String,ServiceUpdateInfo>> objAppServiceUpdateInfo= null;
			Hashtable<String,ServiceUpdateInfo> objProductServiceUpdateInfo=null;
			ServiceUpdateInfo objServiceUpdateInfo =null;
			Set<String> keys = null;
			
			/** Declaration **/
			System.out.println("Enter Load on start up");
			propertiesFilePath = this.getServletContext().getInitParameter(Constants.PROPERTY_FILE_PATH);
			ivrConfigFileName  = this.getServletContext().getInitParameter(Constants.IVR_CONFIG);
			audioConfigFileName  = this.getServletContext().getInitParameter(Constants.AUDIO_CONFIG);
			hostConfig = this.getServletContext().getInitParameter(Constants.HOST_CONFIG);
			
			Constants.IVR_CONFIG = ivrConfigFileName;
			Constants.AUDIO_CONFIG = audioConfigFileName;
			Constants.HOST_CONFIG = hostConfig;
			
			System.out.println("PropertiesFilePath:"+propertiesFilePath);
			System.out.println("IVRConfig:"+ivrConfigFileName);
			System.out.println("Audioconfig:"+audioConfigFileName);
			System.out.println("HostConfig:"+hostConfig);
			
			/**Load Property File **/
			AppProperties.setInstance(ivrConfigFileName,propertiesFilePath);
			AppProperties.setInstance(audioConfigFileName,propertiesFilePath);
			AppProperties.setInstance(hostConfig,propertiesFilePath);

			/**Load Language Code**/
			LoadAppData.LanguageCode(logger);
			
			/**DB Initial Loading**/
			
			appNames = AppProperties.GetInstance(Constants.IVR_CONFIG).getIVRProp(Constants.APPLICATION_NAMES);
			appName_555Postpaid = AppProperties.GetInstance(Constants.IVR_CONFIG).getIVRProp(Constants.POSTPAID_APPLICATION_NAME);
			appName_555Prepaid = AppProperties.GetInstance(Constants.IVR_CONFIG).getIVRProp(Constants.PREPAID_APPLICATION_NAME);
			
			logger.info("appName_555Postpaid" + appName_555Postpaid);
			logger.info("appName_555Prepaid" + appName_555Prepaid);
			
			DBLoadOnStartUp objDBLoadOnStartUp = DBLoadOnStartUp.getInstance();
			objDBLoadOnStartUp.loadHotFlashMessage(appName_555Postpaid + Constants.COMMA + appName_555Prepaid);
			objDBLoadOnStartUp.loadVoiceOffer(appName_555Postpaid + Constants.COMMA + appName_555Prepaid);
			objDBLoadOnStartUp.loadDataOffer(appName_555Postpaid + Constants.COMMA + appName_555Prepaid);
			objDBLoadOnStartUp.loadVASDetails(appName_555Postpaid + Constants.COMMA + appName_555Prepaid);
			objDBLoadOnStartUp.loadRechargeDetails(appName_555Prepaid);
			objDBLoadOnStartUp.loadSTVDetails(appName_555Prepaid);
			objDBLoadOnStartUp.loadIntelligentLayer(appName_555Postpaid + Constants.COMMA + appName_555Prepaid);
			objDBLoadOnStartUp.loadPushSMSDetails(appName_555Postpaid + Constants.COMMA + appName_555Prepaid);
			
			Thread myThread = new PeriodicChecker();
			myThread.start();
			logger.info("Load on startup End");
		}catch (Exception e) {
			GlobalPrintStackTrace.PrintStartUpException(logger, e);
		}
		
		       
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
	 * Last generated by Orchestration Designer at: 2015-APR-13  12:34:34 PM
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
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:39 PM
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