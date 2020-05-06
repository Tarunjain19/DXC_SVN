package english.grammars;

/**
 * This class is generated automatically.
 * Only exit this class for Dynamic External grammars and override the method String getURL().
 * Last generated by Orchestration Designer at: 2015-OCT-23  06:03:08 PM
 */
public class POA_4digit extends com.avaya.sce.runtime.Grammar {

    //{{START:CLASS:FIELDS
    //}}END:CLASS:FIELDS

    /**
    * Constructor for POA_4digit.
    */
    public POA_4digit() {
		//{{START:CLASS:CONSTRUCTOR
        super();
        setRootLanguage("en-us");
        setMode("dtmf");
        setBuiltin(true);
        setBuiltinMode("dtmf");
        setType("digits");
        setOptions("length=4");
		//}}END:CLASS:CONSTRUCTOR
    }

}

