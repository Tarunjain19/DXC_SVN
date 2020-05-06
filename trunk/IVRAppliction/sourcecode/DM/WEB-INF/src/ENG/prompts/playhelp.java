/**
 * Last generated by Orchestration Designer at: 2013-OCT-11  03:06:52 PM
 */
package ENG.prompts;

import com.avaya.sce.runtime.SimpleVariable;
import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.IVariable;
import com.avaya.sce.runtimecommon.SCESession;
import com.dm.util.Constants;

import flow.IProjectVariables;

public class playhelp extends com.avaya.sce.runtime.Prompt {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Constructor for playhelp.
	 */
	public playhelp() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}


	/**
	 * This method is generated automatically and should not be manually edited
	 * To manually edit the prompt, override:
	 * void updatePrompt()
	 * Last generated by Orchestration Designer at: 2017-SEP-04  04:24:14 PM
	 */
	public void buildPrompt(){
		com.avaya.sce.runtime.Format format = null;
		com.avaya.sce.runtime.RenderHint hint = null;
		com.avaya.sce.runtime.MediaPage mediaPage = null;
		setBarginType(com.avaya.sce.runtimecommon.SCERT.BARGIN_SPEECH);
		setName("playhelp");
		setOrder(com.avaya.sce.runtime.Prompt.STANDARD);

		// Prompt level 1
		setTimeout(1,5000);
		setBargin(1,true);

	}
	
	@Override
	public void updatePrompt(SCESession mySession) {

		super.updatePrompt(mySession);
	
		com.avaya.sce.runtime.Format format = null;
		com.avaya.sce.runtime.RenderHint hint = null;
		setBarginType(com.avaya.sce.runtimecommon.SCERT.BARGIN_SPEECH);
		setName("Announce");
		// Prompt level 1
		setTimeout(1,8000);
		setBargin(1,true);

		format = new com.avaya.sce.runtime.Format();
		format.add(com.avaya.sce.runtime.Format.FORMAT,com.avaya.sce.runtime.Format.FMT_FILEURL);
		String audioLocation = mySession.getVariableField(IProjectVariables.INPUT_VARIABLES, IProjectVariables.INPUT_VARIABLES_FIELD_AUDIO_LOCATION).getStringValue();
		String audio = "";
		IVariable listAudio = mySession.getVariable(IProjectVariables.COLLECTIONINITIALPROMPT);
		listAudio.getCollection().reset();
		
		
		setOrder(com.avaya.sce.runtime.Prompt.STANDARD);
		for (int i=1 ; listAudio.getCollection().hasMore(); i++){	
			listAudio.getCollection().next();
			audio = listAudio.getSimpleVariable().getStringValue();
			String name = Constants.DMAUDIO + String.valueOf(i);
			String value = audioLocation + audio;
			mySession.putVariable(SimpleVariable.createSimpleVariable(name, value, null, mySession, false, false)); 
				
			if (mySession.isAppTraceEnabled() == true){mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Announce: " + value);}
		
			this.add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.VARIABLE_TEXT,name,format));
		}
	
	}
}
