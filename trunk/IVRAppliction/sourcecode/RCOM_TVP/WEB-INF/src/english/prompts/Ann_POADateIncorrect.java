/**
 * Last generated by Orchestration Designer at: 2015-OCT-27  07:56:03 PM
 */
package english.prompts;

import com.avaya.sce.runtimecommon.SCESession;

import flow.IProjectVariables;

public class Ann_POADateIncorrect extends com.avaya.sce.runtime.Prompt {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Constructor for Ann_POADateIncorrect.
	 */
	public Ann_POADateIncorrect() {
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
		setName("Ann_POADateIncorrect");
		setOrder(com.avaya.sce.runtime.Prompt.STANDARD);

		// Prompt level 1
		setTimeout(1,8000);
		setBargin(1,true);

		add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.PHRASESET,"RCOM_TVP_PhraseSet:45006",false));

	}
	@Override
	public void updatePrompt(SCESession mySession){
	// TODO Auto-generated method stub
		String strPath=mySession.getVariableField(IProjectVariables.CALL_INFO,IProjectVariables.CALL_INFO_FIELD_CALLER_PATH).getStringValue();
		strPath=strPath+"TELV_PA0024"+"|";
		mySession.getVariableField(IProjectVariables.CALL_INFO,IProjectVariables.CALL_INFO_FIELD_CALLER_PATH).setValue(strPath);
		System.out.println(strPath);
	}
}