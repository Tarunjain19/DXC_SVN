package MAR.grammars;

/**
 * This class is generated automatically.
 * Only exit this class for Dynamic External grammars and override the method String getURL().
 * Last generated by Orchestration Designer at: 2013-FEB-06  11:19:15 PM
 */
public class gram_validatecollection extends com.avaya.sce.runtime.Grammar {

    //{{START:CLASS:FIELDS
    //}}END:CLASS:FIELDS

    /**
    * Constructor for gram_validatecollection.
    */
    public gram_validatecollection() {
		//{{START:CLASS:CONSTRUCTOR
        super();
        setRootLanguage("en-us");
        setMode("voice");
        setBuiltin(false);
        setFileName("");
        setMediaType("application/srgs+xml");
        setExternal(true);
        setDoNotEncodeQueryString(false);
        addColName("RESULT");
        addColName("CONFIRMATION_MODE");
        addColName("OTHER_SLOT");
		//}}END:CLASS:CONSTRUCTOR
    }

}

