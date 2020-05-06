package english.phrasesets;

import com.avaya.sce.runtime.Phrase;
import com.avaya.sce.runtimecommon.ITraceInfo;
import com.rcom.utilities.IVRConstants;

import flow.IProjectVariables;

/**
 * This phraseset class will be automatically populated with data from the 
 * phraseset project file.  Manual edits should only be outside of the tag 
 * areas or overridden methods. 
 * Class created on: 
 * Last generated by Orchestration Designer at: 2016-MAR-23  03:01:25 PM
 */
public class RCOM_MissCallPhrases extends com.avaya.sce.runtime.Phraseset { 

	//{{START:CLASS:FIELDS
	private static final com.avaya.sce.runtime.Phraseset.PhraseMap PHRASE_MAP;
	//}}END:CLASS:FIELDS

	/**
	 * Static initializer
	 */
	static {
		//{{START:PHRASESET:STATIC

		// Create the phrase map, then populate with phrases
		PHRASE_MAP = new com.avaya.sce.runtime.Phraseset.PhraseMap(2);
		com.avaya.sce.runtime.Phrase phrase;

		// phrase: 5000
		com.avaya.sce.runtime.Phraseset.addExternalPhrase(PHRASE_MAP, "english.phraseset.RCOM_MissCallPhrases.urlbase", "5000", "5000.wav", "Thank you for calling Reliance"); 

		//}}END:PHRASESET:STATIC
	}
	@Override
	public Phrase hookGetPhrase(String phraseName, Phrase phrase)
    {
           
           final Phrase orgPhrase = phrase;

           Phrase newPhrase = new Phrase()
           {
                  ITraceInfo itraceInfo;
                  public String getURL()
                  {
                	  itraceInfo=mySession.getTraceOutput();
                        final String audioURL = this.getMySession().getVariableField(IProjectVariables.VAR__PHRASES, IProjectVariables.VAR__PHRASES_FIELD_STATIC__URL).getStringValue();
                        itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_ERROR,"Static Url"+audioURL);
                        String lang_Code = this.getMySession().getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_CURRENT_LANG).getStringValue();
                      itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_ERROR,"lang_Code :"+lang_Code);
                      itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Static URL :: " +audioURL);
                        //itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,  "Static URL :: " +audioURL);
                       // itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"#Returning RCOM_GPON_PhraseSet:"+ audioURL + lang_Code + IVRConstants.SLASH + IVRConstants.STATIC + IVRConstants.SLASH + orgPhrase.getFileName());
                        return  audioURL + lang_Code + IVRConstants.SLASH + IVRConstants.STATIC + IVRConstants.SLASH + orgPhrase.getFileName();
                  }
           };
           return newPhrase;
    }

	/**
	 * Returns the Phrase with the given name.  To override the
	 * behavior and dynamically return a different Phrase object,
	 * override the method "hookGetPhrase(...)".
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2016-MAR-26  03:00:35 PM
	 * @see com.avaya.sce.runtime.Phraseset#getPhrase(String) 
	 */ 
	public com.avaya.sce.runtime.Phrase getPhrase(String phraseName) {
		return(getPhrase(RCOM_MissCallPhrases.PHRASE_MAP, phraseName));
	}
}
