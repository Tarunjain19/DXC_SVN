package GUJ;

/**
 * This class is automatically generated by Orchestration Designer allowing the
 * runtime framework to resolve language elements at runtime.
 * Last generated by Orchestration Designer at: 2017-APR-28  11:20:47 AM
 */
public class ASR_TTS_Language implements com.avaya.sce.runtime.ILanguage {

	/**
	 * Default constructor
	 */
	public ASR_TTS_Language() {
	}

	/**
	 * Returns the language code that the ASR should use (ie. "en-us")
	 */
	public String getASRLanguage() {
		return("en-us");
	}

	/**
	 * Returns the language code that the TTS should use (ie. "en-us")
	 */
	public String getTTSLanguage() {
		return("en-us");
	}

	/**
	 * Returns the language code to use for the localization bundles (text-to-clips), ie. "en-us"
	 */
	public String getLocalizationLanguage() {
		return("as-in");
	}
}
