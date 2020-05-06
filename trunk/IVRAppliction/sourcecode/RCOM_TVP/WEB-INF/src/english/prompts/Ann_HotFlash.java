/**
 * Last generated by Orchestration Designer at: 2016-FEB-29  02:06:16 PM
 */
package english.prompts;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.hp.utilities.IVRConstants;

import flow.IProjectVariables;

public class Ann_HotFlash extends com.avaya.sce.runtime.Prompt {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Constructor for Ann_HotFlash.
	 */
	public Ann_HotFlash() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}


	/**
	 * This method is generated automatically and should not be manually edited
	 * To manually edit the prompt, override:
	 * void updatePrompt()
	 * Last generated by Orchestration Designer at: 2017-JUL-12  01:45:44 PM
	 */
	public void buildPrompt(){
		com.avaya.sce.runtime.Format format = null;
		com.avaya.sce.runtime.RenderHint hint = null;
		com.avaya.sce.runtime.MediaPage mediaPage = null;
		setBarginType(com.avaya.sce.runtimecommon.SCERT.BARGIN_SPEECH);
		setName("Ann_HotFlash");
		setOrder(com.avaya.sce.runtime.Prompt.STANDARD);

		// Prompt level 1
		setTimeout(1,8000);
		setBargin(1,true);

	}
	@Override
	public void updatePrompt(SCESession mySession) {
		//Auto-generated method stub
		super.updatePrompt(mySession);
		
		String phrasePath = IVRConstants.EMPTY_QUOTES;
		String language = IVRConstants.EMPTY_QUOTES;
		String waveFilePath = IVRConstants.EMPTY_QUOTES;
		String waveFileName= IVRConstants.EMPTY_QUOTES;
		ITraceInfo itraceInfo = null; 
		
		try{
			// Loading the trace object
			itraceInfo = mySession.getTraceOutput();
			itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "# Announcing HotFlash");	
			
			phrasePath = mySession.getVariableField(IProjectVariables.VAR__PHRASES, IProjectVariables.VAR__PHRASES_FIELD_STATIC__URL).getStringValue();
			waveFileName = mySession.getVariableField(IProjectVariables.HOT_FLASH_INFO, IProjectVariables.HOT_FLASH_INFO_FIELD_PHRASE_ID).getStringValue();
			language	= mySession.getVariableField(IProjectVariables.CALL_INFO,IProjectVariables.CALL_INFO_FIELD_CURRENT_LANGUAGE).getStringValue();
			if(waveFileName==null||waveFileName.isEmpty())
			 		waveFileName = IVRConstants.SILENCE_WAV;
			itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "# phrasePath:" + phrasePath);
			itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "# HotFlsh wave fileName- " +waveFileName);
			
			
				
				waveFilePath = phrasePath + language + IVRConstants.SLASH + IVRConstants.STATIC + IVRConstants.SLASH + waveFileName;
				itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "# Announcing HotFlash wave file path:" + waveFilePath);	
				mySession.getVariableField(IProjectVariables.HOT_FLASH_INFO, IProjectVariables.HOT_FLASH_INFO_FIELD_PHRASE_ID).setValue(waveFilePath);
				add(1, new com.avaya.sce.runtime.PhraseVariableElement("HotFlashInfo:phraseId", com.avaya.sce.runtime.PhraseVariableElement.Type.AUDIO_URL,false));
				
				}
			
		catch(Exception e){;
			
		}	
		}
	


}
