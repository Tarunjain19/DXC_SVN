/**
 * Last generated by Orchestration Designer at: 2015-OCT-23  06:20:34 PM
 */
package english.prompts;

public class Ann_enterDOI extends com.avaya.sce.runtime.Prompt {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Constructor for Ann_enterDOI.
	 */
	public Ann_enterDOI() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}


	/**
	 * This method is generated automatically and should not be manually edited
	 * To manually edit the prompt, override:
	 * void updatePrompt()
	 * Last generated by Orchestration Designer at: 2017-JUL-12  01:45:43 PM
	 */
	public void buildPrompt(){
		com.avaya.sce.runtime.Format format = null;
		com.avaya.sce.runtime.RenderHint hint = null;
		com.avaya.sce.runtime.MediaPage mediaPage = null;
		setBarginType(com.avaya.sce.runtimecommon.SCERT.BARGIN_SPEECH);
		setName("Ann_enterDOI");
		setOrder(com.avaya.sce.runtime.Prompt.STANDARD);

		// Prompt level 1
		setTimeout(1,8000);
		setBargin(1,true);

		add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.PHRASESET,"RCOM_TVP_PhraseSet:45008",false));

	}
}
