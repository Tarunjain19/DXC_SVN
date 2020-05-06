package flow;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;


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
 * Last generated by Orchestration Designer at: 2015-MAY-29  04:36:28 PM
 */
public class Check_MoviesVASMN extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-29  04:36:28 PM
	 */
	public Check_MoviesVASMN() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:41 PM
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
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:41 PM
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
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:41 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(3);
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "MoviesVAS_MN ReturnCode  :: ", "MoviesVAS_MN:ReturnCode").setDebugId(6098));
		actions.add(new com.avaya.sce.runtime.varoperations.Assign("Global_Counter:Max_NoMatch", "MoviesVAS_MN:NomatchRemaining", false).setDebugId(9662));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "AppVariables:IsHostFailure", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "CONSTANTS:YES", true).setDebugId(7129)).evaluate(mySession)) {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "MoviesVAS_MN:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "dmGrammarValues:Movies", true).setDebugId(7130)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("AppVariables:TransferPoint", "TransferPoints:RD01_TR_0049", false).setDebugId(7135));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("AppVariables:TransferPoint", "TransferPoints:RD01_TR_0048", false).setDebugId(7136));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("LinkDownAnnc", "linkdown").setDebugId(7137));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "MoviesVAS_MN:ReturnCode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "CONSTANTS:SUCCESS", true).setDebugId(6099)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "MoviesVAS_MN Value :: ", "MoviesVAS_MN:Value").setDebugId(6100));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

				if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition4", "MoviesVAS_MN:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "dmGrammarValues:Movies", true).setDebugId(6101)).evaluate(mySession)) {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.Next("Packsinfo_MN", "movies").setDebugId(6102));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;

				} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition5", "MoviesVAS_MN:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "dmGrammarValues:VAS", true).setDebugId(7612)).evaluate(mySession)) {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.Next("Packsinfo_MN", "vas").setDebugId(7613));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;

				} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition6", "MoviesVAS_MN:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "dmGrammarValues:previous", true).setDebugId(7605)).evaluate(mySession)) {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.Next("checkMoviesVASPrevious", "previous").setDebugId(7606));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;

				} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition7", "MoviesVAS_MN:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "dmGrammarValues:MainMenu", true).setDebugId(7607)).evaluate(mySession)) {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.Next("check_AccessedMainMenu", "mainmenu").setDebugId(7608));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;

				} else {
					actions = new java.util.ArrayList(2);
					actions.add(new com.avaya.sce.runtime.varoperations.Assign("AppVariables:TransferPoint", "TransferPoints:RD01_TR_0045", false).setDebugId(7610));
					actions.add(new com.avaya.sce.runtime.Next("Transfer_Annc", "agent").setDebugId(7611));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;
				}


			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("Tries_ExceedAnncom", "tries_exceed").setDebugId(6106));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}

		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
	
	@Override
	public void requestBegin(SCESession mySession) {
		
		ITraceInfo trace = mySession.getTraceOutput();
		String key=null,appName = null,circleID = null,langId = null,menuOption = AppConstants.EMPTY_STRING,initialPrompt = null,menuID = null,dynamicWaves = null;
		Hashtable<String, Hashtable<String, Hashtable<String, PackInfoVAS>>> packInfoMessage = null;
		Hashtable<String, Hashtable<String, PackInfoVAS>> circlePackInfo = null;
		Hashtable<String, PackInfoVAS> langPackInfo = null;
		ArrayList<String> arrPacks=null;
		Set<String> packInfoKey = null;
		
		/*Block buster movies*/
		Hashtable<String, Hashtable<String, Hashtable<String, BBMoviesInfo>>>  circleIDBBMoviesList= null;
		Hashtable<String, Hashtable<String, BBMoviesInfo>> langCodeBBMobiesList = null;
		Hashtable<String, BBMoviesInfo> moviesIdList = null;
		BBMoviesInfo bbMoviesInfo = null;Set<String> moviesId = null;
		int listSize = 0,checkSize=0;
		List<String> dynamicList = null;
		String moreOptiondynamicValues = AppConstants.EMPTY_STRING;
		try
		{
			if(mySession.getVariableField(IProjectVariables.MOVIES_VAS__MN, IProjectVariables.MOVIES_VAS__MN_FIELD_RETURN_CODE).getStringValue().equalsIgnoreCase(AppConstants.Success))
			{
				
				if(mySession.getVariableField(IProjectVariables.MOVIES_VAS__MN, IProjectVariables.MOVIES_VAS__MN_FIELD_VALUE).getStringValue().equalsIgnoreCase(AppConstants.Movies)
						|| mySession.getVariableField(IProjectVariables.MOVIES_VAS__MN, IProjectVariables.MOVIES_VAS__MN_FIELD_VALUE).getStringValue().equalsIgnoreCase(AppConstants.VAS))
				{
				appName = mySession.getVariableField(IProjectVariables.APP__NAME).getStringValue();
				circleID = mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_CIRCLE_ID).getStringValue();
				langId = mySession.getCurrentLanguage();
				
				/** Formating the Request To Get Data from DB **/
				if(mySession.getVariableField(IProjectVariables.MOVIES_VAS__MN, IProjectVariables.MOVIES_VAS__MN_FIELD_VALUE).getStringValue().equalsIgnoreCase(AppConstants.Movies))
				{
					
					
					/** Getting from Session **/
					menuID = AppConstants.RD01_MN_0039;
					key = AppConstants.BBMOVIES_KEY+appName;
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "BlockBuster Movies Key :: "+key);
					circleIDBBMoviesList = (Hashtable<String, Hashtable<String, Hashtable<String, BBMoviesInfo>>>) AppDataMap.getInstance(appName).getAppData(key);
							
					if(circleIDBBMoviesList !=null)
					{
						
						langCodeBBMobiesList = circleIDBBMoviesList.get(circleID);
						moviesIdList = langCodeBBMobiesList.get(langId);
						moviesId = moviesIdList.keySet();
						listSize = moviesId.size();
						trace.writeln(ITraceInfo.TRACE_LEVEL_INFO," BBMovies Check :" +langId);
						trace.writeln(ITraceInfo.TRACE_LEVEL_INFO," BBMovies Info from DB :" +moviesIdList.toString());
						
						dynamicList = new ArrayList<String>();
						for (String movieId : moviesId) 
						{
							dynamicList.add(moviesIdList.get(movieId).getMoviePhrase());
							checkSize++;
							trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Check Size Value :: "+checkSize);
							moreOptiondynamicValues = moreOptiondynamicValues+movieId;
							if(checkSize%5==0)
							{
								//moreOptiondynamicValues =moreOptiondynamicValues+AppConstants.PIPE_SEPERATOR;
								moreOptiondynamicValues =moreOptiondynamicValues+AppConstants.SEPERATOR_COMMA;	
								trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Pipe Adding :: ");
							}
							else
							{
								moreOptiondynamicValues =moreOptiondynamicValues+AppConstants.SEPERATOR_COMMA;		
								trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Comma Adding ");
							}
						}
						trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, " moreOptiondynamicValues :: "+moreOptiondynamicValues);
					/** Forming the Dynamic Prompt **/
					key = appName+AppConstants.SEPERATOR_HYPEN+menuID;
					initialPrompt = AppProperties.GetInstance(AppConstants.IVR_CONFIG_PROPERTIES).getIVRProp(key);
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Dynamic Prompt Key "+menuID+" :: "+key);
					
					/** Invoking the playPromt method **/
					String count = String.valueOf(dynamicList.size());
					initialPrompt = DynamicMenu.playPrompt(dynamicList, initialPrompt, String.valueOf(checkSize), menuID, trace);
					mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER, IProjectVariables.DM_INPUT_PARAMETER_FIELD_MENU_ID).setValue(menuID);
					mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER, IProjectVariables.DM_INPUT_PARAMETER_FIELD_INITIAL_PROMPT).setValue(initialPrompt);
					mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER,IProjectVariables.DM_INPUT_PARAMETER_FIELD_MORE_OPTION_COUNT).setValue(count);
					mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER, IProjectVariables.DM_INPUT_PARAMETER_FIELD_MENU_OPTION).setValue(moreOptiondynamicValues);
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Confirmation Initial Prompt "+menuID+" :: "+initialPrompt);
						
					}
					else
					{
						mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_HOST_FAILURE).setValue(AppConstants.Yes);
					}
					
					
				}
				else
				{
					key = AppConstants.PACKINFOVAS_KEY+appName;
					menuID = AppConstants.RD01_MN_0041;
					
					
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, " PackInfoKey :: "+key);
					packInfoMessage = (Hashtable<String, Hashtable<String, Hashtable<String, PackInfoVAS>>>) AppDataMap.getInstance(appName).getAppData(key);
					if(packInfoMessage != null)
					{
						circlePackInfo = packInfoMessage.get(circleID);
						langPackInfo = circlePackInfo.get(langId);
						packInfoKey = langPackInfo.keySet();
						
						arrPacks = new ArrayList<>();
						for (String packInfo : packInfoKey) {
							trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, " PackInfo From DB :: "+packInfo+" :: "+langPackInfo.get(packInfo).toString());
							arrPacks.add(langPackInfo.get(packInfo).getInfoPhrase());
							menuOption = menuOption+packInfo+AppConstants.SEPERATOR_COMMA;
							}
						
						/** Form Initial Prompt**/
						String count = String.valueOf(arrPacks.size());
						dynamicWaves = AppProperties.GetInstance(AppConstants.IVR_CONFIG_PROPERTIES).getIVRProp(appName+AppConstants.SEPERATOR_HYPEN+menuID);
						trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, " DynamicWaves from Property for "+menuID+" :: "+dynamicWaves);
						initialPrompt = DynamicMenu.playPrompt(arrPacks, dynamicWaves, count, menuID, trace);
						trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Initial Prompt ::"+initialPrompt);
						trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Menu Option : "+menuOption);
						
						mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER, IProjectVariables.DM_INPUT_PARAMETER_FIELD_MENU_ID).setValue(menuID);
						mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER,IProjectVariables.DM_INPUT_PARAMETER_FIELD_INITIAL_PROMPT).setValue(initialPrompt);
						mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER,IProjectVariables.DM_INPUT_PARAMETER_FIELD_MORE_OPTION_COUNT).setValue(count);
						mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER,IProjectVariables.DM_INPUT_PARAMETER_FIELD_MENU_OPTION).setValue(menuOption);
					}
					else
					{
						mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_HOST_FAILURE).setValue(AppConstants.Yes);
					}
				}
				
				
			}
					
		}		
		}catch(Exception e)
		{mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_HOST_FAILURE).setValue(AppConstants.Yes);
		StackTrace.PrintException(e);
		}
		finally
		{trace=null;packInfoMessage=null;circlePackInfo=null;langPackInfo=null;arrPacks=null;packInfoKey=null;key=null;appName = null;circleID = null;langId = null;menuOption = null;initialPrompt = null;menuID = null;dynamicWaves = null;}
		}
		
}
