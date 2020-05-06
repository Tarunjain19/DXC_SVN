package flow;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.otherflows.model.BBMoviesInfo;
import com.rcom.otherflows.model.PackInfoVAS;
import com.rcom.rdtv.util.AppConstants;
import com.rcom.rdtv.util.AppDataMap;
import com.rcom.rdtv.util.DynamicMenu;
import com.rcom.rdtv.util.StackTrace;
import com.servion.util.AppProperties;

/**
 * The Data class handles many types of server-side operations including data
 * collection (from a data sources such as a database, or web service), variable
 * assignments and operations (like copying variable values, performing mathematic
 * operations, and collection iteration), conditional evaluation to control callflow
 * execution based on variable values, and logging/tracing statements.
 * 
 * Items created in the getDataActions() method are executed/evaluated in order
 * and if a condional branch condition evaluates to "true" then the branch is
 * activated and the execution of data actions is halted.  If no "true" conditions
 * are encountered, then all data actions will be executed/evaluated and the 
 * application will proceed to the "Default" servlet.
 * Last generated by Orchestration Designer at: 2015-MAY-29  04:42:43 PM
 */
public class Check_PacksinfoMN extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-29  04:42:43 PM
	 */
	public Check_PacksinfoMN() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:38 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = null;
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:38 PM
	 */
	public java.util.Collection<VariableInfo> getLocalVariables(){
		java.util.Collection<VariableInfo> variables = new java.util.ArrayList<VariableInfo>();

		return variables;
	}
	/**
	 * Creates and conditionally executes operations that have been configured
	 * in the Callflow.  This method will build a collection of operations and
	 * have the framework execute the operations by calling evaluateActions().
	 * If the evaluation causes the framework to forward to a different servlet
	 * then execution stops.
	 * Returning true from this method means that the framework has forwarded the
	 * request to a different servlet.  Returning false means that the default
	 * Next will be invoked.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:38 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(3);
		actions.add(new com.avaya.sce.runtime.varoperations.Assign("Global_Counter:Max_NoMatch", "Packsinfo_MN:NomatchRemaining", false).setDebugId(9664));
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "Packsinfo_MN ReturnCode :: ", "Packsinfo_MN:ReturnCode").setDebugId(6250));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "Packsinfo_MN:ReturnCode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "CONSTANTS:SUCCESS", true).setDebugId(6251)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "Packsinfo_MN Value :: ", "Packsinfo_MN:Value").setDebugId(6252));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "Packsinfo_MN:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "dmGrammarValues:agent", true).setDebugId(7746)).evaluate(mySession)) {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("AppVariables:TransferPoint", "TransferPoints:RD01_TR_0045", false).setDebugId(7744));
				actions.add(new com.avaya.sce.runtime.Next("Transfer_Annc", "agent").setDebugId(7745));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "Packsinfo_MN:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "dmGrammarValues:previous", true).setDebugId(7739)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("MoviesVAS_MN", "previous").setDebugId(7740));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition4", "Packsinfo_MN:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "dmGrammarValues:MainMenu", true).setDebugId(7741)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("check_AccessedMainMenu", "mainmenu").setDebugId(7742));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("PackChannel_MN", "success").setDebugId(7748));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("Tries_ExceedAnncom", "tries-exceed").setDebugId(6255));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
	
	
	@Override
	public void requestBegin(SCESession mySession) {
		ITraceInfo trace = mySession.getTraceOutput();
		String appName = null,circleID = null,langId = null,key = null,initialPrompt = null;
		Hashtable<String, Hashtable<String, Hashtable<String, PackInfoVAS>>> packInfoMessage = null;
		Hashtable<String, Hashtable<String, PackInfoVAS>> circlePackInfo = null;
		Hashtable<String, PackInfoVAS> langPackInfo = null;
		ArrayList<String> arrChannelMessage=null;
		PackInfoVAS packInfoVAS = null;
		
		/*Blockbuster Movies*/
		Hashtable<String, Hashtable<String, Hashtable<String, BBMoviesInfo>>>  circleIDBBMoviesList= null;
		Hashtable<String, Hashtable<String, BBMoviesInfo>> langCodeBBMobiesList = null;
		Hashtable<String, BBMoviesInfo> moviesIdList = null;
		BBMoviesInfo bbMoviesInfo = null;List<String> dynamicList = null;
		
		try
		{
			if(mySession.getVariableField(IProjectVariables.PACKSINFO__MN, IProjectVariables.PACKSINFO__MN_FIELD_RETURN_CODE).getStringValue().equalsIgnoreCase(AppConstants.Success))
			{
				appName = mySession.getVariableField(IProjectVariables.APP__NAME).getStringValue();
				circleID = mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_CIRCLE_ID).getStringValue();
				langId = mySession.getCurrentLanguage();
				
				/** Formating the Request To Get Data from DB **/
				if(mySession.getVariableField(IProjectVariables.MOVIES_VAS__MN, IProjectVariables.MOVIES_VAS__MN_FIELD_VALUE).getStringValue().equalsIgnoreCase(AppConstants.Movies))
				{
					/** Getting from Session **/
					key = AppConstants.BBMOVIES_KEY+appName;
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "BlockBuster Movies Key :: "+key);
					circleIDBBMoviesList = (Hashtable<String, Hashtable<String, Hashtable<String, BBMoviesInfo>>>) AppDataMap.getInstance(appName).getAppData(key);
					if(circleIDBBMoviesList !=null)
					{
						
						langCodeBBMobiesList = circleIDBBMoviesList.get(circleID);
						moviesIdList = langCodeBBMobiesList.get(langId);
						bbMoviesInfo = moviesIdList.get(mySession.getVariableField(IProjectVariables.PACKSINFO__MN, IProjectVariables.PACKSINFO__MN_FIELD_VALUE).getStringValue());
						dynamicList = new ArrayList<>();
						trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, " BBMovies Info from DB :" +bbMoviesInfo.toString());
						dynamicList.add(bbMoviesInfo.getDetailPhrase());
						mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_OFFER_CODE).setValue(bbMoviesInfo.getOfferCode());
						mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_PACKNAME).setValue(bbMoviesInfo.getMoviePhrase());
						mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_DENOMINATION).setValue(bbMoviesInfo.getDenomination());
						
						/** Forming the Dynamic Prompt **/
						key = appName+AppConstants.SEPERATOR_HYPEN+AppConstants.RD01_MN_0040;
						initialPrompt = AppProperties.GetInstance(AppConstants.IVR_CONFIG_PROPERTIES).getIVRProp(key);
						trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Dynamic Prompt Key "+AppConstants.RD01_MN_0040+" :: "+key);
						
						/** Invoking the playPromt method **/
						initialPrompt = DynamicMenu.playPrompt(dynamicList, initialPrompt, AppConstants.NA, AppConstants.RD01_MN_0040, trace);
						mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER, IProjectVariables.DM_INPUT_PARAMETER_FIELD_INITIAL_PROMPT).setValue(initialPrompt);
						
						
					}
	
				}
				else
				{
					key = AppConstants.PACKINFOVAS_KEY+appName;
					
					packInfoMessage = (Hashtable<String, Hashtable<String, Hashtable<String, PackInfoVAS>>>) AppDataMap.getInstance(appName).getAppData(key);
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Corresponding Info Message :: "+packInfoMessage.toString());
					if(packInfoMessage != null)
					{
						circlePackInfo = packInfoMessage.get(circleID);
						langPackInfo = circlePackInfo.get(langId);
						packInfoVAS = langPackInfo.get(mySession.getVariableField(IProjectVariables.PACKSINFO__MN, IProjectVariables.PACKSINFO__MN_FIELD_VALUE).getStringValue());
						if(packInfoVAS != null)
						{
							arrChannelMessage = new ArrayList<>();
							trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, " PlayOut Channel Message Phrase :: "+packInfoVAS.toString());
							arrChannelMessage.add(packInfoVAS.getDetailPhrase());
							mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_DENOMINATION).setValue(packInfoVAS.getMrp());
							mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_PACKNAME).setValue(packInfoVAS.getInfoPhrase());
							mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_OFFER_CODE).setValue(packInfoVAS.getOfferCode());
							
							/** Dynamic Prompt Formation **/
							initialPrompt = AppProperties.GetInstance(AppConstants.IVR_CONFIG_PROPERTIES).getIVRProp(appName+AppConstants.SEPERATOR_HYPEN+AppConstants.RD01_MN_0040);
							initialPrompt = DynamicMenu.playPrompt(arrChannelMessage, initialPrompt, AppConstants.NA, AppConstants.RD01_MN_0040, trace);							
						}
					}
					
				}
				
			mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER,IProjectVariables.DM_INPUT_PARAMETER_FIELD_INITIAL_PROMPT).setValue(initialPrompt);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Confirmation Initial Prompt "+AppConstants.RD01_MN_0040+" :: "+initialPrompt);
			
			}
		}catch(Exception e)
		{mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_HOST_FAILURE).setValue(AppConstants.Yes);
		StackTrace.PrintException(e);
		}
		finally
		{trace=null;packInfoMessage=null;circlePackInfo=null;langPackInfo=null;arrChannelMessage=null;packInfoVAS = null;appName = null;circleID = null;langId = null;key = null;initialPrompt = null;}
	}
}