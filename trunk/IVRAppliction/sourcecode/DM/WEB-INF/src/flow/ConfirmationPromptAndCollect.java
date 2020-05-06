package flow;


import java.util.Collection;

import com.avaya.sce.runtime.Field;
import com.avaya.sce.runtime.Grammar;
import com.avaya.sce.runtime.Property;
import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.IVariable;
import com.avaya.sce.runtimecommon.SCESession;
import com.dm.util.Constants;



/**
 * Class that represents a form.  A form can contain prompts, fields  and links
 * as well as handlers for various events that may occur while the form is executing
 * Last generated by Orchestration Designer at: 2013-OCT-11  12:12:41 PM
 */
public class ConfirmationPromptAndCollect extends com.avaya.sce.runtime.Form {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2013-OCT-11  12:12:41 PM
	 */
	public ConfirmationPromptAndCollect() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		setNeedsDefaultDisconnectHandler(false);
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * This method is generated automatically and should not be manually edited.
	 * To manually edit the links for the node, override:
	 *     void updateLinks(Collection links, SCESession mySession)
	 * Last generated by Orchestration Designer at: 2017-SEP-04  04:23:31 PM
	 * @return a collection of links
	 */
	public java.util.Collection getLinks(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Link link;
		java.util.List list;
		java.util.Collection grammarInfo = null;
		java.util.Collection<com.avaya.sce.runtime.CaptureExpression> captureExpr = null;
		// This item does not have any defined links
		list = new java.util.ArrayList();
		String ___tempGrammarName = null;

		return(list);
	}
	/**
	 * This method is generated automatically and should not be manually edited.
	 * To manually edit the properties for the node, override:
	 *     void updateProperties(Collection properties, SCESession mySession)
	 * Last generated by Orchestration Designer at: 2017-SEP-04  04:23:31 PM
	 * @return a collection of properties
	 */
	public java.util.Collection getProperties(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Property property;
		java.util.List list;
		// This item does not have any defined properties
		list = new java.util.ArrayList();

		return(list);
	}
	/**
	 * This method is generated automatically and should not be manually edited.
	 * To manually edit the event handlers for the node, override:
	 *    void updateEvents(Collection events, SCESession mySession)
	 * Last generated by Orchestration Designer at: 2017-SEP-04  04:23:31 PM
	 * @return a collection of Events
	 */
	public java.util.Collection getEvents(com.avaya.sce.runtimecommon.SCESession mySession) {
		java.util.List list;
		com.avaya.sce.runtime.Event event;
		list = new java.util.ArrayList();
		java.util.List eventPromptNames = null;
		String ___tempPromptName = null;
		return(list);
	}
	/**
	 * Builds the list of fields for the form.  This list is built
	 * by the code generator based on items in the call flow editor.
	 * This method should not be manually edited as changes may be
	 * overwritten by the code generator.  <br>
	 * To update the fields for the form, override
	 *     public void updateFields(Collection fields, com.avaya.sce.runtimecommon.SCESession mySession)
	 * Last generated by Orchestration Designer at: 2017-SEP-04  04:23:31 PM
	 */
	public java.util.Collection getFields(com.avaya.sce.runtimecommon.SCESession mySession) {
		java.util.List list = null;
		java.util.List promptNames = null;
		java.util.List eventPromptNames = null;
		java.util.List grammarInfo = null;
		java.util.List events = null;
		java.util.List properties = null;
		com.avaya.sce.runtime.Field field = null;
		com.avaya.sce.runtime.Event event = null;
		com.avaya.sce.runtime.Property property = null;

		list = new java.util.ArrayList(1);
		String ___tempPromptName = null;
		// build the list of prompt names
		promptNames = new java.util.ArrayList(1);
		
		promptNames.add(new com.avaya.sce.runtime.PromptRefInfo("PlayConfirmation", ""));

		// build the list of grammar information objects for the field
		String ___tempGrammarName = null;
		grammarInfo = new java.util.ArrayList(1);
		grammarInfo.add(new com.avaya.sce.runtime.GrammarInfo("gram_validatecollection", "1.0"));


		// build events for the field: "ConfirmationPromptAndCollect"
		events = new java.util.ArrayList(2);

		// Item has no prompts associated
		eventPromptNames = new java.util.ArrayList();

		event = new com.avaya.sce.runtime.Event(com.avaya.sce.runtimecommon.SCERT.EVENT_NOINPUT, (com.avaya.sce.runtime.PromptRefInfo[])eventPromptNames.toArray(new com.avaya.sce.runtime.PromptRefInfo[0]), new com.avaya.sce.runtime.Goto("ConfirmationNoInput", 0, true, ""));
		events.add(event);

		// Item has no prompts associated
		eventPromptNames = new java.util.ArrayList();

		event = new com.avaya.sce.runtime.Event(com.avaya.sce.runtimecommon.SCERT.EVENT_NOMATCH, (com.avaya.sce.runtime.PromptRefInfo[])eventPromptNames.toArray(new com.avaya.sce.runtime.PromptRefInfo[0]), new com.avaya.sce.runtime.Goto("ConfirmationNoMatch", 0, true, ""));
		events.add(event);
		properties = new java.util.ArrayList();

		int nbest = 1;
		field = new com.avaya.sce.runtime.Field("ConfirmationPromptAndCollect", false, true, grammarInfo, promptNames, events, properties, nbest, false, false, com.avaya.sce.runtimecommon.SCERT.RECTARG_BODYTEXT_GEN);
		list.add(field);

		return(list);
	}
	/**
	 * Builds the list of prompts that are used by this flow item<br>
	 * This method is generated automatically and changes to it may
	 * be overwritten next time code is generated.  To modify the list
	 * of prompts for the flow item, override:
	 *     updatePrompts(Collection prompts, SCESession mySession)
	 * @return list of prompts for the menu
	 * Last generated by Orchestration Designer at: 2017-SEP-04  04:23:31 PM
	 */
	public java.util.Collection getPrompts(com.avaya.sce.runtimecommon.SCESession mySession) {
		java.util.List list = null;
		String ___tempPromptName = null;
		// Item has no prompts associated
		list = new java.util.ArrayList();

		return(list);
	}
	/**
	 * Returns the submit item that identifies the next form to transition to.
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2017-SEP-04  04:23:31 PM
	 */
	public com.avaya.sce.runtime.Submit getSubmit(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Submit submit = null;
		submit = new com.avaya.sce.runtime.Submit("AssignConfirmationValues");
		return submit;
	}
	/**
	 * Returns the record item for the form.
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2017-SEP-04  04:23:31 PM
	 */
	public com.avaya.sce.runtime.Record getRecord(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Record record = null;
		java.util.Collection events = null;
		java.util.Collection promptNames = null;
		java.util.Collection eventPromptNames = null;
		java.util.Collection grammarInfo = null;
		com.avaya.sce.runtime.Event event = null;
		return record;
	}
	/**
	 * Returns the transfer item for the form.
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2017-SEP-04  04:23:31 PM
	 */
	public com.avaya.sce.runtime.Transfer getTransfer(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Transfer transfer = null;
		return transfer;
	}
	/**
	 * Returns a Throw object that will throw an event at runtime if set.
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2017-SEP-04  04:23:31 PM
	 */
	public com.avaya.sce.runtime.Throw getThrow(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Throw event = null;
		return event;
	}
	/**
	 * Builds the list of tracking items that are generated by this flow item<br>
	 * This method is generated automatically and changes to it may
	 * be overwritten next time code is generated.
	 * @return list of tracking items for the item
	 * Last generated by Orchestration Designer at: 2017-SEP-04  04:23:31 PM
	 */
	public java.util.Collection getTrackingActions(com.avaya.sce.runtimecommon.SCESession mySession) {
		java.util.List list = null;

		// Item has no tracking items.
		list = new java.util.ArrayList();
		return(list);
	}
	/**
	 * Returns a collection of platform objects, or extensions to VXML.
	 * These objects result in the generation of the VXML object tag that
	 * the VXML platform attempts to use to load the runtime library that implements
	 * the extension.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2017-SEP-04  04:23:31 PM
	 */
	public java.util.Collection getPlatformObjects(com.avaya.sce.runtimecommon.SCESession mySession) {
		java.util.Collection objectList = null;
		java.util.Collection promptNames = null;
		com.avaya.sce.runtime.PlatformObject platformObject = null;

		// Form has no extension objects defined
		objectList = new java.util.ArrayList();
		return(objectList);
	}

	public void updateFieldGrammars(Field field, Collection grammars, SCESession mySession) { 
		ITraceInfo trace = mySession.getTraceOutput();
		grammars.clear(); 
		Grammar g;
		IVariable inputVar = mySession.getVariable(IProjectVariables.INPUT_VARIABLES);

		String grammarLocation = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_GRAMMAR_LOCATION).getStringValue();
		String language = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_LANGUAGE).getStringValue();
		String voiceType = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_MEDIA_TYPE_VOICE).getStringValue();
		String dtmfType = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_MEDIA_TYPE_DTMF).getStringValue();
		if(mySession.isAppTraceEnabled()){
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Voice Media Type :"+voiceType);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"DTMF Media Type :"+dtmfType);
		}
		boolean dtmfGrammarsUseSlots = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_DTMF_GRAMMARS_USE_SLOTS).getBooleanValue(); 
		String grammarName = null;
		String grammarWeight=null;

		IVariable grammarCollection = mySession.getVariable(IProjectVariables.CONCATENATED_CONFIRMATION_VOICE_GRAMMAR);
		grammarCollection.getCollection().reset();

		String grammarUrl = null;
		if(mySession.isAppTraceEnabled()){trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"grammarCollection Size :"+grammarCollection.getCollection().size());}
		if (grammarCollection.getCollection().size()>0){
			if(mySession.isAppTraceEnabled()){trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Entered  IF");}
			for (int i = 1 ; grammarCollection.getCollection().hasMore(); i++){	
				grammarCollection.getCollection().next();
				if(mySession.isAppTraceEnabled()){trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"grammarCollection Value :"+grammarCollection.getSimpleVariable().getStringValue());}
				if (!Constants.NONE.equalsIgnoreCase(grammarCollection.getSimpleVariable().getStringValue())){
					if(mySession.isAppTraceEnabled()){trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Entered Else :"+grammarCollection.getSimpleVariable().getStringValue());}
					grammarName = grammarCollection.getSimpleVariable().getStringValue();
					if (grammarName.indexOf(Constants.COLON) > 0){
						try {
							grammarWeight = grammarName.substring(grammarName.indexOf(Constants.COLON) + 1);
							grammarName = grammarName.substring(0, grammarName.indexOf(Constants.COLON));
						}catch (Exception e){
							grammarWeight = "1";
						}
					}else{
						grammarWeight = "1";
					}
					grammarUrl = grammarLocation + grammarName;
					if (mySession.isAppTraceEnabled()){mySession.getTraceOutput().writeln(2,"Grammar: " + grammarUrl);}
					g = new MyGrammar();
					g.setFileName(grammarUrl);
					g.setExternal(true);
					g.setMediaType(voiceType);				
					g.setRootLanguage(language);
					g.setMode("voice");
					g.setWeight(grammarWeight);
					if(mySession.isAppTraceEnabled()){trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"getWeight :"+g.getWeight());}
					if(mySession.isAppTraceEnabled()){trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"getMediaType :"+g.getMediaType());}
					g.addColName("RESULT");
					g.addColName("CONFIRMATION_MODE");
					g.addColName("OTHER_SLOT");
					grammars.add(g);
				}
			}
		}


		grammarCollection = mySession.getVariable(IProjectVariables.CONCATENATED_CONFIRMATION_DTMFGRAMMAR);
		grammarCollection.getCollection().reset();
		if(mySession.isAppTraceEnabled()){trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"DTMF grammarCollection Size :"+grammarCollection.getCollection().size());}
		if (grammarCollection.getCollection().size()>0){
			for (int j = 1 ; grammarCollection.getCollection().hasMore(); j++){	
				grammarCollection.getCollection().next();
				if(mySession.isAppTraceEnabled()){trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"DTMF grammarCollection Value :"+grammarCollection.getSimpleVariable().getStringValue());}
				if (!Constants.NONE.equalsIgnoreCase(grammarCollection.getSimpleVariable().getStringValue())){
					if(mySession.isAppTraceEnabled()){trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"DTMF grammarCollection Value ! none :"+grammarCollection.getSimpleVariable().getStringValue());}
					if (grammarCollection.getSimpleVariable().getStringValue().contains("builtin")){
						grammarUrl = grammarCollection.getSimpleVariable().getStringValue();
						if (mySession.isAppTraceEnabled() == true){mySession.getTraceOutput().writeln(2,"Grammar: " + grammarUrl);}
						g = new MyGrammar();
						g.setFileName(grammarUrl);
						g.setExternal(true);
						g.setRootLanguage(language);
						g.setMode("dtmf");
					}else{
						if(mySession.isAppTraceEnabled()){trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Entered Else :"+grammarCollection.getSimpleVariable().getStringValue());}
						grammarName = grammarCollection.getSimpleVariable().getStringValue();
						if (grammarName.indexOf(Constants.COLON) > 0){
							try {
								grammarWeight = grammarName.substring(grammarName.indexOf(Constants.COLON) + 1);
								grammarName = grammarName.substring(0, grammarName.indexOf(Constants.COLON));
							}catch (Exception e){
								grammarWeight = "1";
							}
						}else{
							grammarWeight = "1";
						}
						grammarUrl = grammarLocation + grammarName;
						if (mySession.isAppTraceEnabled() == true){
							mySession.getTraceOutput().writeln(2,"Grammar: " + grammarUrl);
						}
						g = new MyGrammar();
						g.setFileName(grammarUrl);
						g.setExternal(true);
						g.setMediaType(dtmfType);
						g.setRootLanguage(language);
						g.setMode("dtmf");
						g.setWeight(grammarWeight);
						if(mySession.isAppTraceEnabled()){trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"getWeight :"+g.getWeight());}
						if(mySession.isAppTraceEnabled()){trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"getMediaType :"+g.getMediaType());}
						if(mySession.isAppTraceEnabled()){trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"dtmfGrammarsUseSlots:"+dtmfGrammarsUseSlots);}
						if (dtmfGrammarsUseSlots){
							g.addColName("RESULT");
							g.addColName("CONFIRMATION_MODE");
							g.addColName("OTHER_SLOT");
						}
						if(mySession.isAppTraceEnabled()){trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"dtmfGrammarsUseSlots:"+dtmfGrammarsUseSlots);}

					}
					grammars.add(g);
				}
			}
		}
		
		super.updateFieldGrammars(field, grammars, mySession);
	}

	public class MyGrammar extends Grammar{

		public String getURL(){
			return this.getFileName();
		}
	}

	/*@Override
	public void requestBegin(SCESession mySession) {
		IVariable variable = null;
		String[] variableFields = null;

		String slots = "RESULT,CONFIRMATION_MODE,OTHER_SLOTS";		
		try{
			Class<?> c = Class.forName("java.lang.String");
			String vals = IProjectVariables.PROMPT_AND_COLLECT_FIELD_CONFIDENCE+","+IProjectVariables.PROMPT_AND_COLLECT_FIELD_INPUTMODE+","
			+IProjectVariables.PROMPT_AND_COLLECT_FIELD_INTERPRETATION+","+IProjectVariables.PROMPT_AND_COLLECT_FIELD_NOINPUTCOUNT+","
			+IProjectVariables.PROMPT_AND_COLLECT_FIELD_NOMATCHCOUNT+","+IProjectVariables.PROMPT_AND_COLLECT_FIELD_UTTERANCE+","+
			IProjectVariables.PROMPT_AND_COLLECT_FIELD_VALUE+","+"RESULT,CONFIRMATION_MODE,OTHER_SLOTS";
			String[] arrVals = vals.split(",");
			int n = arrVals.length;
			Object o = Array.newInstance(c, n);
			for(int i = 0; i < n; i++){
				String v = arrVals[i];
				Constructor ctor = c.getConstructor(String.class);
				Object val = ctor.newInstance(v);
				Array.set(o, i, val);
			}
			variableFields = (String[]) o;
			System.out.println(Arrays.toString(variableFields));

		}catch (Exception e) {
			e.printStackTrace();
		}

		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.PROMPT_AND_COLLECT, variableFields, null, mySession, false, false );
		mySession.putVariable(variable);
	}*/
	@Override
	public void updateProperties(Collection arg0, SCESession mySession) {
		IVariable inputVar = mySession.getVariable(IProjectVariables.INPUT_VARIABLES);

		String sLowConfidenceValue = inputVar.getComplexVariable().getField( IProjectVariables.INPUT_VARIABLES_FIELD_LOW_CONFIDENCE_LEVEL).getStringValue();
		String sInterdigitTimeout = inputVar.getComplexVariable().getField( IProjectVariables.INPUT_VARIABLES_FIELD_INTERDIGIT_TIMEOUT).getStringValue();
		String sTerminatingTimeout = inputVar.getComplexVariable().getField( IProjectVariables.INPUT_VARIABLES_FIELD_TERMINATING_TIMEOUT).getStringValue();
		String sCompleteTimeout = inputVar.getComplexVariable().getField( IProjectVariables.INPUT_VARIABLES_FIELD_COMPLETE_TIMEOUT).getStringValue();
		String sIncompleteTimeout = inputVar.getComplexVariable().getField( IProjectVariables.INPUT_VARIABLES_FIELD_INCOMPLETE_TIMEOUT).getStringValue();
		String sTerminatingChar = inputVar.getComplexVariable().getField( IProjectVariables.INPUT_VARIABLES_FIELD_TERMINATING_CHAR).getStringValue();
		String sPrivate = inputVar.getComplexVariable().getField( IProjectVariables.INPUT_VARIABLES_FIELD_PRIVATE_DATA).getStringValue();

		if (Constants.NONE.equalsIgnoreCase(sLowConfidenceValue)){
			sLowConfidenceValue = "0.2";
		}

		if (Constants.NONE.equalsIgnoreCase(sInterdigitTimeout)){
			sInterdigitTimeout = "3000";
		}

		if (Constants.NONE.equalsIgnoreCase(sTerminatingTimeout)){
			sTerminatingTimeout = "0";
		}

		if (Constants.NONE.equalsIgnoreCase(sCompleteTimeout)){
			sCompleteTimeout = "0";
		}

		if (Constants.NONE.equalsIgnoreCase(sIncompleteTimeout)){
			sIncompleteTimeout = "1500";
		}

		for (Object obj : arg0) {
			if (obj instanceof Property) {
				Property property = (Property)obj;

				if (property.getName().equalsIgnoreCase(Constants.CONFIDENCELEVEL)) {		
					property.setValue(sLowConfidenceValue);
					if (mySession.isAppTraceEnabled()){
						mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG, " Prompt Confidence Level: " + sLowConfidenceValue);
					}
				}   

				if (property.getName().equalsIgnoreCase(Constants.COMPLETETIMEOUT)) {
					property.setValue(sCompleteTimeout);
					if (mySession.isAppTraceEnabled()){
						mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Prompt Complete Timeout: " + sCompleteTimeout);
					}
				}

				if (property.getName().equalsIgnoreCase(Constants.INCOMPLETETIMEOUT)) {
					property.setValue(sIncompleteTimeout);
					if (mySession.isAppTraceEnabled()){
						mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG, " Prompt Incomplete Timeout: " + sIncompleteTimeout);
					}
				}            	

				if (property.getName().equalsIgnoreCase(Constants.INTERDIGITTIMEOUT)) {
					property.setValue(sInterdigitTimeout);
					if (mySession.isAppTraceEnabled()){
						mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG, " Prompt Interdigit Timeout: " + sInterdigitTimeout);
					}
				}

				if (property.getName().equalsIgnoreCase(Constants.TERMCHAR)) {
					property.setValue(sTerminatingChar);
					if (mySession.isAppTraceEnabled()){
						mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG, " Prompt Terminating Character: " + sTerminatingChar);
					}
				}

				if (property.getName().equalsIgnoreCase(Constants.TERMTIMEOUT)) {
					property.setValue(sTerminatingTimeout);
					if (mySession.isAppTraceEnabled()){
						mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG, " Prompt Terminating Timeout: " + sTerminatingTimeout);
					}
				}

				if (property.getName().equalsIgnoreCase(Constants.PRIVATE)) {
					property.setValue(sPrivate);
					if (mySession.isAppTraceEnabled()){
						mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG, " Prompt Private: " + sPrivate);
					}
				}

			}
		}

	}

	@Override
	public void updateFields(Collection fields, SCESession mySession) {
		IVariable inputVar = mySession.getVariable(IProjectVariables.INPUT_VARIABLES);
		boolean recordUtterance = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_RECORD_UTTERANCE).getBooleanValue();
		Field field = (Field)fields.iterator().next(); 
		field.setRecordUtterance(recordUtterance);
	}
}
