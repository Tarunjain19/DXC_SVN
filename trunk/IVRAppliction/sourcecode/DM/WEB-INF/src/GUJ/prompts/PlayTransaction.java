/**
 * Last generated by Orchestration Designer at: 2014-MAY-30  06:12:40 PM
 */
package GUJ.prompts;


public class PlayTransaction extends com.avaya.sce.runtime.Prompt {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Constructor for PlayTransaction.
	 */
	public PlayTransaction() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}


	/**
	 * This method is generated automatically and should not be manually edited
	 * To manually edit the prompt, override:
	 * void updatePrompt()
	 * Last generated by Orchestration Designer at: 2017-SEP-04  04:24:12 PM
	 */
	public void buildPrompt(){
		com.avaya.sce.runtime.Format format = null;
		com.avaya.sce.runtime.RenderHint hint = null;
		com.avaya.sce.runtime.MediaPage mediaPage = null;
		setBarginType(com.avaya.sce.runtimecommon.SCERT.BARGIN_SPEECH);
		setName("PlayTransaction");
		setOrder(com.avaya.sce.runtime.Prompt.STANDARD);

		// Prompt level 1
		setTimeout(1,5000);
		setBargin(1,true);

		add(1, new com.avaya.sce.runtime.PhraseVariableElement("inputVariables:initialPrompt", com.avaya.sce.runtime.PhraseVariableElement.Type.AUDIO_URL,false));

	}
	
}
