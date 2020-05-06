/**
 * Last generated by Orchestration Designer at: 2013-OCT-11  08:47:46 PM
 */
package english.prompts;

import com.avaya.sce.runtime.Format;
import com.avaya.sce.runtime.SimpleVariable;
import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.IVariable;
import com.avaya.sce.runtimecommon.SCESession;
import com.dm.util.Constants;

import flow.IProjectVariables;

public class PlayConfirmation extends com.avaya.sce.runtime.Prompt {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Constructor for PlayConfirmation.
	 */
	public PlayConfirmation() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}


	/**
	 * This method is generated automatically and should not be manually edited
	 * To manually edit the prompt, override:
	 * void updatePrompt()
	 * Last generated by Orchestration Designer at: 2017-SEP-04  04:23:52 PM
	 */
	public void buildPrompt(){
		com.avaya.sce.runtime.Format format = null;
		com.avaya.sce.runtime.RenderHint hint = null;
		com.avaya.sce.runtime.MediaPage mediaPage = null;
		setBarginType(com.avaya.sce.runtimecommon.SCERT.BARGIN_SPEECH);
		setName("PlayConfirmation");
		setOrder(com.avaya.sce.runtime.Prompt.STANDARD);

		// Prompt level 1
		setTimeout(1,5000);
		setBargin(1,true);

	}
	
	@Override
	public void updatePrompt(SCESession mySession) {
		super.updatePrompt(mySession);
		IVariable inputVar = mySession.getVariable(IProjectVariables.INPUT_VARIABLES);
		int timeOut = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_TIMEOUT).getIntValue();
		
		com.avaya.sce.runtime.Format format = null;
		com.avaya.sce.runtime.RenderHint hint = null;
		setBarginType(com.avaya.sce.runtimecommon.SCERT.BARGIN_SPEECH);
		setName("Announce");
		// Prompt level 1
		setTimeout(1,timeOut);
		boolean bargeIn = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_BARGE_IN).getBooleanValue();
		if(mySession.isDDTraceEnabled()){
			mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "BargeIn property: " + bargeIn);
		}
		setBargin(1, bargeIn);

		
		
		format = new com.avaya.sce.runtime.Format();
		format.add(com.avaya.sce.runtime.Format.FORMAT,com.avaya.sce.runtime.Format.FMT_FILEURL);
		String audioLocation = mySession.getVariableField(IProjectVariables.INPUT_VARIABLES, IProjectVariables.INPUT_VARIABLES_FIELD_AUDIO_LOCATION).getStringValue();
		String collectValue = mySession.getVariableField(IProjectVariables.PROMPT_AND_COLLECT, IProjectVariables.PROMPT_AND_COLLECT_FIELD_RESULT).getStringValue();
		String collectUtterance = mySession.getVariableField(IProjectVariables.PROMPT_AND_COLLECT, IProjectVariables.PROMPT_AND_COLLECT_FIELD_UTTERANCE).getStringValue();
		String isPrivate=mySession.getVariableField(IProjectVariables.INPUT_VARIABLES, IProjectVariables.INPUT_VARIABLES_FIELD_PRIVATE_DATA).getStringValue();
		
		IVariable listAudio = mySession.getVariable(IProjectVariables.COLLECTIONCONFIRMATION);
		
		if (mySession.isAppTraceEnabled()){mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "CONFIRMATION COLLECTION: " + listAudio.getSimpleVariable().getStringValue());}
		
		String confirmSpecificPrompt = mySession.getVariableField(IProjectVariables.INPUT_VARIABLES, IProjectVariables.INPUT_VARIABLES_FIELD_CONFIRMATION_SPECIFIC_PROMPT).getStringValue();
		
		String audio = "";
		int count = 0;
		String announce [] = null;
		boolean firstAnnounce = false;
		long seconds = 0;
		
		listAudio.getCollection().reset();
		
		
		listAudio.getCollection().next();
		setOrder(com.avaya.sce.runtime.Prompt.STANDARD);

		//CHECKING A PARTICULAR VALUE
		for (int i=1 ; listAudio.getCollection().hasMore(); i++) {
			listAudio.getCollection().next();
			audio = listAudio.getSimpleVariable().getStringValue();
			if (mySession.isAppTraceEnabled()){mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Audio values : " + audio);}
			seconds = (System.currentTimeMillis() / i) % 2;
			if ((audio).toUpperCase().indexOf(collectValue.toUpperCase() + Constants.ASTERISK)!= -1){
				if (!firstAnnounce || seconds == 0){
					firstAnnounce = true;
					count = 0;
					char[] arrayChar = audio.toCharArray();
					for(int aux=0; aux<arrayChar.length; aux++){
						if( arrayChar[aux] == '*'){
							count++;
						}
					}
					announce = new String[count];
					int posStart = 0;
					int posEnd = 0;
					for (int aux2 = 0; aux2<count; aux2++){
						posStart = audio.indexOf(Constants.ASTERISK, posStart) + 1;
						posEnd = audio.indexOf(Constants.ASTERISK,posStart);
						if (mySession.isAppTraceEnabled()){mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "posEnd: " + posEnd);}
						if (posEnd != -1){
							announce[aux2] = audio.substring(posStart, posEnd);
						}else{
							announce[aux2] = audio.substring(posStart);
						}
					}
				}
			}
		}
		
		//CHECKING FOR DEFAULT, IN CASE IT IS A REPROMPT
		listAudio.getCollection().reset();
		for (int i=1 ; listAudio.getCollection().hasMore(); i++){
			listAudio.getCollection().next();
			audio = listAudio.getSimpleVariable().getStringValue();
			if (mySession.isAppTraceEnabled()){mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Audio values : " + audio);}
			seconds = (System.currentTimeMillis() / i) % 2;
			if ((audio).toUpperCase().indexOf(Constants.DEFAULT + Constants.ASTERISK)!= -1) {
				if (!firstAnnounce || seconds == 0){
					firstAnnounce = true;
					count = 0;
					char[] arrayChar = audio.toCharArray();
					for(int aux=0; aux<arrayChar.length; aux++){
						if( arrayChar[aux] == '*'){
							count++;
						}
					}
					announce = new String[count];
					int posStart = 0;
					int posEnd = 0;
					for (int aux2 = 0; aux2<count; aux2++){
						posStart = audio.indexOf(Constants.ASTERISK, posStart) + 1;
						posEnd = audio.indexOf(Constants.ASTERISK,posStart);
						if (mySession.isAppTraceEnabled()){mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "posEnd: " + posEnd);}
						if (posEnd != -1){
							announce[aux2] = audio.substring(posStart, posEnd);
						}else{
							announce[aux2] = audio.substring(posStart);
						}
					}
				}
			}
		}
		
		//CHECKING FOR SPECIFIC
		if (announce == null) {
			if (confirmSpecificPrompt != null){
				audio = confirmSpecificPrompt;
				count = 1;
				char[] arrayChar = audio.toCharArray();
				for(int aux=0; aux<arrayChar.length; aux++){
					if( arrayChar[aux] == '*'){
						count++;
					}
				}
				announce = new String[count];
				int posStart = 0;
				int posEnd = 0;
				for (int aux2 = 0; aux2<count; aux2++){
					posEnd = audio.indexOf(Constants.ASTERISK,posStart);
					if (mySession.isAppTraceEnabled() == true){mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "audio: " + audio);}
					if (mySession.isAppTraceEnabled() == true){mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "posStart: " + posStart);}
					if (mySession.isAppTraceEnabled() == true){mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "posEnd: " + posEnd);}
					if (posEnd != -1){
						announce[aux2] = audio.substring(posStart, posEnd);
					}else{
						announce[aux2] = audio.substring(posStart);
					}
					posStart = audio.indexOf(Constants.ASTERISK, posStart) + 1;
				}
			}
		}
			
			
		count = 0;
		for(String t :  announce){
			count++;
			int ttsNumberCounter = 0;
			int ttsDigitsCounter = 0;
			int ttsDateCounter = 0;
			int ttsCurrencyCounter = 0;
			int ttsAddressCounter = 0;
			int ttsNameCounter = 0;
			int ttsTelephoneCounter = 0;
			int ssNumberCounter = 0;
			int ssDigitsCounter = 0;
			int ssDateCounter = 0;
			int ssTimeCounter = 0;
			int ssCurrencyCounter = 0;
			
			
			String name = Constants.DMAUDIO + String.valueOf(count);
		
			if (t.indexOf(Constants.TTS_COLON)!= -1){
				
				boolean ssFmt = false;
				String textTTS=null;
				format = new com.avaya.sce.runtime.Format();
				//Says the Format of the TTS to be Played
				if (t.endsWith(Constants.NUMBER)){
					ttsNumberCounter++;	
					String fmtVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_TTS_NUMBER_FORMAT).getStringValue();
					String fmtValuesVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_TTS_NUMBER_FORMAT_VALUES).getStringValue();
					if(fmtVar != null && fmtValuesVar != null)
					{								
						ssFmt = ssFormat(mySession, fmtVar, fmtValuesVar, format,ttsNumberCounter);
						if(!ssFmt)
						{
							format.add(Constants.INTERPRET_AS,Constants.NUMBER);
							format.add(Constants.FORMAT,Constants.DIGITS);
						}
					}
					else
					{
						format.add(Constants.INTERPRET_AS,Constants.NUMBER);
						format.add(Constants.FORMAT,Constants.DIGITS);
					}
				}else if(t.endsWith(Constants.DIGITS)){
					ttsDigitsCounter++;	
					String fmtVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_TTS_DIGITS_FORMAT).getStringValue();
					String fmtValuesVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_TTS_DIGITS_FORMAT_VALUES).getStringValue();
					if(fmtVar != null && fmtValuesVar != null)
					{								
						ssFmt = ssFormat(mySession, fmtVar, fmtValuesVar, format,ttsDigitsCounter);
						if(!ssFmt)
						{
							format.add(Constants.INTERPRET_AS,Constants.DIGITS);
						}
					}
					else
					{
						format.add(Constants.INTERPRET_AS,Constants.DIGITS);
					}
					
				}else if(t.endsWith(Constants.DATE)){
					ttsDateCounter++;	
					String fmtVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_TTS_DATE_FORMAT).getStringValue();
					String fmtValuesVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_TTS_DATE_FORMAT_VALUES).getStringValue();
					if(fmtVar != null && fmtValuesVar != null)
					{								
						ssFmt = ssFormat(mySession, fmtVar, fmtValuesVar, format,ttsDateCounter);
						if(!ssFmt)
						{
							format.add(Constants.INTERPRET_AS,Constants.DATE);
							format.add(Constants.FORMAT,Constants.DMY);
						}
					}
					else
					{
						format.add(Constants.INTERPRET_AS,Constants.DATE);
						format.add(Constants.FORMAT,Constants.DMY);
					}
				}else if(t.endsWith(Constants.CURRENCY)){
					ttsCurrencyCounter++;
					String fmtVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_TTS_DIGITS_FORMAT).getStringValue();
					String fmtValuesVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_TTS_DIGITS_FORMAT_VALUES).getStringValue();
					if(fmtVar != null && fmtValuesVar != null)
					{								
						ssFmt = ssFormat(mySession, fmtVar, fmtValuesVar, format, ttsCurrencyCounter);
						if(!ssFmt)
						{
							format.add(Constants.INTERPRET_AS,Constants.CURRENCY);
						}
					}
					else
					{
						format.add(Constants.INTERPRET_AS,Constants.CURRENCY);
					}
				}else if (t.endsWith(Constants.ADDRESS)){
					ttsAddressCounter++;
					String fmtVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_TTS_ADDRESS_FORMAT).getStringValue();
					String fmtValuesVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_TTS_ADDRESS_FORMAT_VALUES).getStringValue();
					if(fmtVar != null && fmtValuesVar != null)
					{								
						ssFmt = ssFormat(mySession, fmtVar, fmtValuesVar, format,ttsAddressCounter);
						if(!ssFmt)
						{
							format.add(Constants.INTERPRET_AS,Constants.ADDRESS);
						}
					}
					else
					{
						format.add(Constants.INTERPRET_AS,Constants.ADDRESS);
					}
				}else if (t.endsWith(Constants.NAME)){
					ttsNameCounter++;
					String fmtVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_TTS_NAME_FORMAT).getStringValue();
					String fmtValuesVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_TTS_NAME_FORMAT_VALUES).getStringValue();
					if(fmtVar != null && fmtValuesVar != null)
					{								
						ssFmt = ssFormat(mySession, fmtVar, fmtValuesVar, format, ttsNameCounter);
						if(!ssFmt)
						{
							format.add(Constants.INTERPRET_AS,Constants.NAME);
						}
					}
					else
					{
						format.add(Constants.INTERPRET_AS,Constants.NAME);
					}
				}else if (t.endsWith(Constants.TELEPHONE)){
					ttsTelephoneCounter++;
					String fmtVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_TTS_TELEPHONE_FORMAT).getStringValue();
					String fmtValuesVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_TTS_TELEPHONE_FORMAT_VALUES).getStringValue();
					if(fmtVar != null && fmtValuesVar != null)
					{								
						ssFmt = ssFormat(mySession, fmtVar, fmtValuesVar, format, ttsTelephoneCounter);
						if(!ssFmt)
						{
							format.add(Constants.INTERPRET_AS,Constants.TELEPHONE);
						}
					}
					else
					{
						format.add(Constants.INTERPRET_AS,Constants.TELEPHONE);
					}
				}

				//Get TTS Value
				int posStartTTS = t.indexOf(Constants.COLON) + 1;
				int posEndTTS = t.indexOf(Constants.COLON,posStartTTS);
				textTTS=t.substring(posStartTTS, posEndTTS);
				if (textTTS.equalsIgnoreCase(Constants.INPUT_VALUE)){
					textTTS = collectValue;
				}
				if (textTTS.equalsIgnoreCase(Constants.INPUT_UTTERANCE)){
					textTTS = collectUtterance;
				}
				if(isPrivate.equalsIgnoreCase(Constants.FALSE)){
					if (mySession.isAppTraceEnabled()){mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "TEXT TTS: " + textTTS);}	
				}
				//SET TTS
				this.add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.XML_TAG_BEGIN,Constants.say_as, format));
				this.add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.TEXT,textTTS, null));
				this.add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.XML_TAG_END,Constants.say_as));
			}
			else if (t.indexOf(Constants.SS_COLON)!= -1){
				String textSS=null;
				format = new com.avaya.sce.runtime.Format();
				boolean ssFmt = false;
				int posStart = t.indexOf(Constants.COLON)+1;
				int posEnd = t.indexOf(Constants.COLON,posStart);
				textSS=t.substring(posStart, posEnd);
				if (textSS.equalsIgnoreCase(Constants.INPUT_VALUE)){
					textSS = collectValue;
				}
				if (textSS.equalsIgnoreCase(Constants.INPUT_UTTERANCE)){
					textSS = collectUtterance;
				}
				
				//TYPE SELECTION
				if (t.endsWith(Constants.NUMBER)){
					ssNumberCounter++;
					String fmtVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_NUMBER_FORMAT).getStringValue();
					String fmtValuesVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_NUMBER_FORMAT_VALUES).getStringValue();
					if(fmtVar != null && fmtValuesVar != null)
					{								
						ssFmt = ssFormat(mySession, fmtVar, fmtValuesVar, format, ssNumberCounter);
						if(!ssFmt)
						{
							format.add(Constants.NUMBER,Constants.NUMBER);
							format.add(Constants.Number_Type,Constants.Integer);
							format.add(Constants.Inflection,Constants.Nn);									
						}
					}
					else
					{
						if(mySession.isAppTraceEnabled()){mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Number Type = null ,Default Values ");}
						format.add(Constants.FORMAT,Constants.NUMBER);
						format.add(Constants.Number_Type,Constants.Integer);
						format.add(Constants.Inflection,Constants.Nn);
					}
				}else if(t.endsWith(Constants.DIGITS)){
					ssDigitsCounter++;
					String fmtVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_DIGITS_FORMAT).getStringValue();
					String fmtValuesVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_DIGITS_FORMAT_VALUES).getStringValue();
					if(fmtVar != null && fmtValuesVar != null)
					{
						ssFmt = ssFormat(mySession, fmtVar, fmtValuesVar, format, ssDigitsCounter);
						if(!ssFmt)
						{
							format.add(Constants.FORMAT,Constants.DIGITS);
							format.add(Constants.Inflection,Constants.Crmm);
						}

					}
					else
					{
						if(mySession.isAppTraceEnabled()){mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Number Type = null ,Default Values ");}
						format.add(Constants.FORMAT,Constants.DIGITS);
						format.add(Constants.Inflection,Constants.Crmm);
					}

				}else if(t.endsWith(Constants.DATE)){
					ssDateCounter++;
					String fmtVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_DATE_FORMAT).getStringValue();
					String fmtValuesVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_DATE_FORMAT_VALUES).getStringValue();
					if(fmtVar != null && fmtValuesVar != null)
					{
						ssFmt = ssFormat(mySession, fmtVar, fmtValuesVar, format, ssDateCounter);
						if(!ssFmt)
						{
							format.add(Constants.FORMAT,Constants.DATE);
							format.add(Constants.Month_Type,Constants.spokenmonth);
							format.add(Constants.Date_Format,Constants.DMSPDYY);
						}
					}
					else
					{
						format.add(Constants.FORMAT,Constants.DATE);
						format.add(Constants.Month_Type,Constants.spokenmonth);
						format.add(Constants.Date_Format,Constants.DMSPDYY);
					}
					
				}else if(t.endsWith(Constants.TIME)){	
					ssTimeCounter++;
					String fmtVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_TIME_FORMAT).getStringValue();
					String fmtValuesVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_TIME_FORMAT_VALUES).getStringValue();
					if(fmtVar != null && fmtValuesVar != null)
					{
						ssFmt = ssFormat(mySession, fmtVar, fmtValuesVar, format, ssTimeCounter);
						if(!ssFmt)
						{
							format.add(Constants.FORMAT,Constants.TIME);
							format.add(Constants.Time_Format,Constants.THMAM);
						}
					}
					else
					{
						format.add(Constants.FORMAT,Constants.TIME);
						format.add(Constants.Time_Format,Constants.THMAM);
					}
				}else if(t.endsWith(Constants.CURRENCY)){
					ssCurrencyCounter++;
					String fmtVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_CURRENCY_FORMAT).getStringValue();
					String fmtValuesVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_CURRENCY_FORMAT_VALUES).getStringValue();
					if(fmtVar != null && fmtValuesVar != null)
					{
						if(textSS.contains(Constants.DOT)){
							String[] centsAmt=textSS.split(Constants.DOT);
							int cents=Integer.valueOf(centsAmt[1]);
							if(cents==0){
								fmtValuesVar=Constants.WHOLE_DOLLARS;
								ssFmt = ssFormat(mySession, fmtVar, fmtValuesVar, format, ssCurrencyCounter);
							}
							else{
								ssFmt = ssFormat(mySession, fmtVar, fmtValuesVar, format, ssCurrencyCounter);
							}
						}else{
							fmtValuesVar=Constants.WHOLE_DOLLARS;
							ssFmt = ssFormat(mySession, fmtVar, fmtValuesVar, format, ssCurrencyCounter);
						}
						
						if(!ssFmt)
						{
							format.add(Constants.FORMAT,Constants.CURRENCY);
							format.add(Constants.Currency_Format,Constants.N$2);
						}

					}
					else
					{
						format.add(Constants.FORMAT,Constants.CURRENCY);
						format.add(Constants.Currency_Format,Constants.N$2);
					}
				}
				
				
				mySession.putVariable(SimpleVariable.createSimpleVariable(name, textSS, null, mySession, false, false));
				if(isPrivate.equalsIgnoreCase(Constants.FALSE)){
					if (mySession.isAppTraceEnabled()){mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "TEXT SS: " + textSS);}		
				}
				add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.VARIABLE_AUDIO,name, format));
			}
			else{
				format = new com.avaya.sce.runtime.Format();
				format.add(com.avaya.sce.runtime.Format.FORMAT,com.avaya.sce.runtime.Format.FMT_FILEURL);
				String value = audioLocation + t;
				mySession.putVariable(SimpleVariable.createSimpleVariable(name, value, null, mySession, false, false));
				if (mySession.isAppTraceEnabled()){mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Announce: " + value);}
				this.add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.VARIABLE_TEXT,name,format));
			}
		}		
	}
	public boolean ssFormat(SCESession mySession,String fmtVar,String fmtValuesVar,Format format,int ttscounter){
		boolean ssFormat = false;
		if(mySession.isAppTraceEnabled()){mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Format Key Defined in Properties : "+fmtVar+" && Format Values Defined in Properties :"+fmtValuesVar);}
		String[] fmtKey = fmtVar.split(Constants.COMMA); 
		if(fmtValuesVar.contains(Constants.COLON)){
			String[] ttsFmtValues = fmtValuesVar.split(Constants.COLON);
			String[] fmtValues = ttsFmtValues[ttscounter-1].split(Constants.COMMA);
			if(fmtKey.length == fmtValues.length){
				ssFormat = true;
				if(mySession.isAppTraceEnabled()){mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Key Length = "+fmtKey.length);}
				for(int fmt =0;fmt< fmtKey.length;fmt++){
					if(mySession.isAppTraceEnabled()){mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"i = "+fmt);}
					format.add(fmtKey[fmt],fmtValues[fmt]);
					if(mySession.isAppTraceEnabled()){mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Format Key Defined in Properties : "+fmtKey[fmt]+"&& Format Values Defined in Properties :"+fmtValues[fmt]);}
				}
			}

		}else{
			String[] fmtValues = fmtValuesVar.split(Constants.COMMA);
			if(fmtKey.length == fmtValues.length){
				ssFormat = true;
				if(mySession.isAppTraceEnabled()){mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Key Length = "+fmtKey.length);}
				for(int fmt =0;fmt< fmtKey.length;fmt++){
					if(mySession.isAppTraceEnabled()){mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"i = "+fmt);}
					format.add(fmtKey[fmt],fmtValues[fmt]);
					if(mySession.isAppTraceEnabled()){mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Format Key Defined in Properties : "+fmtKey[fmt]+"&& Format Values Defined in Properties :"+fmtValues[fmt]);}
				}
			}
		}

		if(mySession.isAppTraceEnabled()){mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Format Added :"+ssFormat);}
		return ssFormat;
	}

}
