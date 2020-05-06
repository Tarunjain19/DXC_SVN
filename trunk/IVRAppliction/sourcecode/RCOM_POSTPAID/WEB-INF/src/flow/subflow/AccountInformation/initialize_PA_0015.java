package flow.subflow.AccountInformation;

import java.util.ArrayList;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.servion.postpaid.utils.Constants;
import com.servion.postpaid.utils.DynamicMenu;
import com.servion.postpaid.utils.PrintStackTrace;
import com.servion.util.AppProperties;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import flow.IProjectVariables;

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
 * Last generated by Orchestration Designer at: 2016-SEP-20  01:06:04 PM
 */
public class initialize_PA_0015 extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2016-SEP-20  01:06:04 PM
	 */
	public initialize_PA_0015() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-AUG-28  11:20:49 AM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("AccountInformation-FreeUnitInfo_PA_0016", "Default");
		next.setDebugId(6154);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2017-AUG-28  11:20:49 AM
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
	 * Last generated by Orchestration Designer at: 2017-AUG-28  11:20:49 AM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
	
	
	@Override
	public void requestBegin(SCESession mySession) {
		super.requestBegin(mySession);
		
		/*Declaring variables*/
		ITraceInfo info = null;
		String strInitialAudios = "silence.wav";
		String strUsedAmount = "", strUnusedAmount = "",strCategory ="",strAllocatedData ="",strBucket="",strBucketCategory="";
		String key = Constants.EMPTY_STRING,dynamicPrompt = Constants.EMPTY_STRING;
		AppProperties audioProperties ,ivrProperties= null;
		//AppProperties ivrConfigInstance = null;
		DynamicMenu dynamicMenu = null;
		ArrayList<String> dynamicValueList = null;
		String strApplicationName = "";
		//TrimDecimal triDec= new TrimDecimal();
		int size;
		String bucketStart="",bucketEnd="";
		
		try {
			
			
			/*Assigning values*/
			info = mySession.getTraceOutput();
			dynamicValueList = new ArrayList<String>();
			dynamicMenu = new DynamicMenu();
			strApplicationName = mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_APPLICATION_NAME).getStringValue();
			info.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Application Name :: "+strApplicationName);
			audioProperties = (AppProperties) mySession.getProperty(Constants.AudioPropertyInstance);
			dynamicValueList=new ArrayList<String>();
			info.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Current language ********"+mySession.getCurrentLanguage());
			size = Integer.parseInt(mySession.getVariableField(IProjectVariables.FREE_UNIT_INFO,IProjectVariables.FREE_UNIT_INFO_FIELD_BUCKET_SIZE).getStringValue());
			bucketStart = mySession.getVariableField(IProjectVariables.FREE_UNIT_INFO,IProjectVariables.FREE_UNIT_INFO_FIELD_INI_BUCKET).getStringValue();
			bucketEnd = mySession.getVariableField(IProjectVariables.FREE_UNIT_INFO,IProjectVariables.FREE_UNIT_INFO_FIELD_END_BUCKET).getStringValue();
			int intbucketStart = Integer.parseInt(bucketStart);
			int intbucketEnd  = Integer.parseInt(bucketEnd);
			for(int i=intbucketStart;i<intbucketEnd;i++)
			{
				if(mySession.getVariableField(IProjectVariables.FREE_UNIT_INFO,Constants.category+(i+1)).getStringValue()!=null&&!(Constants.EMPTY_STRING.equals(mySession.getVariableField(IProjectVariables.FREE_UNIT_INFO,Constants.category+(i+1)))))
			{
				strCategory 	 = mySession.getVariableField(IProjectVariables.FREE_UNIT_INFO,Constants.category+(i+1)).getStringValue().trim();
				info.writeln(ITraceInfo.TRACE_LEVEL_INFO, "strCategory:: "+strCategory);
				strBucketCategory= strCategory.replace(Constants.SPACE, Constants.UNDERSCORE);
				info.writeln(ITraceInfo.TRACE_LEVEL_INFO, "strBucketCategory:: "+strBucketCategory);
				strAllocatedData =  mySession.getVariableField(IProjectVariables.FREE_UNIT_INFO,Constants.AllocatedData+(i+1)).getStringValue();
				strUsedAmount	 =	mySession.getVariableField(IProjectVariables.FREE_UNIT_INFO,Constants.UsedData+(i+1)).getStringValue();	
				strUnusedAmount	 =	mySession.getVariableField(IProjectVariables.FREE_UNIT_INFO,Constants.UnusedData+(i+1)).getStringValue();
			
					if(strAllocatedData!=null &&!strAllocatedData.equals(Constants.EMPTY_STRING)&& strUsedAmount!=null &&!strUsedAmount.equals(Constants.EMPTY_STRING)
						&&strUsedAmount!=null &&!strUsedAmount.equals(Constants.EMPTY_STRING))
							{
								strInitialAudios = audioProperties.getIVRProp(strBucketCategory).trim();
								info.writeln(ITraceInfo.TRACE_LEVEL_INFO, "strInitialAudios:: "+strInitialAudios);
								if(strInitialAudios.equalsIgnoreCase(Constants.N)){
										if(strBucketCategory.contains(Constants.Netconnect))
											strInitialAudios = audioProperties.getIVRProp(Constants.Netconnect_Usage_MB).trim();
										else if(strBucketCategory.contains(Constants.Voice))
											strInitialAudios = audioProperties.getIVRProp(Constants.Voice_Usage).trim();
										else if (strBucketCategory.contains(Constants.SMS))
											strInitialAudios = audioProperties.getIVRProp(Constants.Local_and_STD_SMS).trim();
								}
								if(strInitialAudios!="N")
									{
										info.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Prompt"+(i+1)+"::"+strInitialAudios);
										dynamicValueList.add(strAllocatedData);
										dynamicValueList.add(strUsedAmount);
										dynamicValueList.add(strUnusedAmount);
									}
						
						
							}
				}
	
				
				 info.writeln(ITraceInfo.TRACE_LEVEL_INFO, "strInitialAudios Final **:"+strInitialAudios);
			/*Initializing audio*/
			
			strInitialAudios = dynamicMenu.playPrompt(dynamicValueList, strInitialAudios, Constants.NA, info);
			
			/*Setting to session*/
		
			mySession.getVariableField(IProjectVariables.DMPROPERTIES, IProjectVariables.DMPROPERTIES_FIELD_INITIAL_AUDIOS).setValue(strInitialAudios);
		
			info.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Current language after setting default Code"+mySession.getCurrentLanguage());
			
			
			
				}
			
		}
			catch (Exception e) {
			PrintStackTrace.PrintException(e);
			info.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "Exception:"+e.getMessage());
		}
		}
}