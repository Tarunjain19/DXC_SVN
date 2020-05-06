/**
 * Last generated by Orchestration Designer at: 2013-NOV-08  01:20:48 PM
 */
package HIN.prompts;

import com.avaya.sce.runtime.Format;
import com.avaya.sce.runtime.SimpleVariable;
import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.IVariable;
import com.avaya.sce.runtimecommon.SCESession;
import com.dm.util.Constants;

import flow.IProjectVariables;

public class PlayNINMPrompt extends com.avaya.sce.runtime.Prompt {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Constructor for PlayNoInputPrompt.
	 */
	public PlayNINMPrompt() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}


	/**
	 * This method is generated automatically and should not be manually edited
	 * To manually edit the prompt, override:
	 * void updatePrompt()
	 * Last generated by Orchestration Designer at: 2017-SEP-04  04:24:10 PM
	 */
	public void buildPrompt(){
		com.avaya.sce.runtime.Format format = null;
		com.avaya.sce.runtime.RenderHint hint = null;
		com.avaya.sce.runtime.MediaPage mediaPage = null;
		setBarginType(com.avaya.sce.runtimecommon.SCERT.BARGIN_SPEECH);
		setName("PlayNINMPrompt");
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
		setName("announceRetry");
		// Prompt level 1
		setTimeout(1,8000);
		setBargin(1,true);

		format = new com.avaya.sce.runtime.Format();
		format.add(com.avaya.sce.runtime.Format.FORMAT,com.avaya.sce.runtime.Format.FMT_FILEURL);
		IVariable inputVar = mySession.getVariable(IProjectVariables.INPUT_VARIABLES);
		String audioLocation = mySession.getVariableField(IProjectVariables.INPUT_VARIABLES, IProjectVariables.INPUT_VARIABLES_FIELD_AUDIO_LOCATION).getStringValue();
		String audio = "",niFlag = "",nmFlag = "";
		String privateData= mySession.getVariableField(IProjectVariables.INPUT_VARIABLES, IProjectVariables.INPUT_VARIABLES_FIELD_PRIVATE_DATA).getStringValue();
		IVariable listAudio = mySession.getVariable(IProjectVariables.COLLECTIONINITIALPROMPT);
		IVariable flagVar = mySession.getVariable(IProjectVariables.FLAGS);
		listAudio.getCollection().reset();

		niFlag = flagVar.getComplexVariable().getField(IProjectVariables.FLAGS_FIELD_NI).getStringValue();
		nmFlag = flagVar.getComplexVariable().getField(IProjectVariables.FLAGS_FIELD_NM).getStringValue();
		if (mySession.isAppTraceEnabled()){mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"NoInput Flag : "+niFlag );}
		if (mySession.isAppTraceEnabled()){mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"NoMatch Flag : "+nmFlag );}
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
		boolean random = false;
		if(Constants.TRUE.equalsIgnoreCase(niFlag)){
			random = mySession.getVariableField(IProjectVariables.INPUT_VARIABLES, IProjectVariables.INPUT_VARIABLES_FIELD_NO_INPUT_RANDOM).getBooleanValue();
		}else if(Constants.TRUE.equalsIgnoreCase(nmFlag)){
			random = mySession.getVariableField(IProjectVariables.INPUT_VARIABLES, IProjectVariables.INPUT_VARIABLES_FIELD_NO_MATCH_RANDOM).getBooleanValue();
		}else{
			random = false;
		}
		if (mySession.isAppTraceEnabled()){mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Random Activate: "+random);}

		if (random){
			setOrder(com.avaya.sce.runtime.Prompt.RANDOM);
			for (int i=1 ; listAudio.getCollection().hasMore(); i++){
				listAudio.getCollection().next();
				audio = listAudio.getSimpleVariable().getStringValue();
				String name = Constants.DMAUDIO + String.valueOf(i);
				String value = audioLocation + audio;
				mySession.putVariable(SimpleVariable.createSimpleVariable(name, value, null, mySession, false, false)); 

				if (mySession.isAppTraceEnabled() == true){mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Announce: " + value);}

				this.add(i, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.VARIABLE_TEXT,name,format));
			}
		}else{
			setOrder(com.avaya.sce.runtime.Prompt.STANDARD);
			for (int i=1 ; listAudio.getCollection().hasMore(); i++){
				listAudio.getCollection().next();
				audio = listAudio.getSimpleVariable().getStringValue();
				String name = Constants.DMAUDIO + String.valueOf(i);
				if (audio.indexOf(Constants.TTS_COLON)!= -1){
				
					boolean ssFmt = false;
					String textTTS=null;
					format = new com.avaya.sce.runtime.Format();
					//Says the Format of the TTS to be Played
					if (audio.endsWith(Constants.NUMBER)){
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
					}else if(audio.endsWith(Constants.DIGITS)){
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

					}else if(audio.endsWith(Constants.DATE)){
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
					}else if(audio.endsWith(Constants.CURRENCY)){
						ttsCurrencyCounter++;
						String fmtVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_TTS_DIGITS_FORMAT).getStringValue();
						String fmtValuesVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_TTS_DIGITS_FORMAT_VALUES).getStringValue();
						if(fmtVar != null && fmtValuesVar != null)
						{								
							ssFmt = ssFormat(mySession, fmtVar, fmtValuesVar, format,ttsCurrencyCounter);
							if(!ssFmt)
							{
								format.add(Constants.INTERPRET_AS,Constants.CURRENCY);
							}
						}
						else
						{
							format.add(Constants.INTERPRET_AS,Constants.CURRENCY);
						}
					}else if (audio.endsWith(Constants.ADDRESS)){
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
					}else if (audio.endsWith(Constants.NAME)){
						ttsNameCounter++;
						String fmtVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_TTS_NAME_FORMAT).getStringValue();
						String fmtValuesVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_TTS_NAME_FORMAT_VALUES).getStringValue();
						if(fmtVar != null && fmtValuesVar != null)
						{								
							ssFmt = ssFormat(mySession, fmtVar, fmtValuesVar, format,ttsNameCounter);
							if(!ssFmt)
							{
								format.add(Constants.INTERPRET_AS,Constants.NAME);
							}
						}
						else
						{
							format.add(Constants.INTERPRET_AS,Constants.NAME);
						}
					}else if (audio.endsWith(Constants.TELEPHONE)){
						ttsTelephoneCounter++;
						String fmtVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_TTS_TELEPHONE_FORMAT).getStringValue();
						String fmtValuesVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_TTS_TELEPHONE_FORMAT_VALUES).getStringValue();
						if(fmtVar != null && fmtValuesVar != null)
						{								
							ssFmt = ssFormat(mySession, fmtVar, fmtValuesVar, format,ttsTelephoneCounter);
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
					int posStartTTS = audio.indexOf(Constants.COLON) + 1;
					int posEndTTS = audio.indexOf(Constants.COLON,posStartTTS);
					textTTS=audio.substring(posStartTTS, posEndTTS);
					if (textTTS.equalsIgnoreCase(Constants.INPUT_VALUE)){
						textTTS = mySession.getVariableField(IProjectVariables.PROMPT_AND_COLLECT, IProjectVariables.PROMPT_AND_COLLECT_FIELD_VALUE).getStringValue();						
					}
					if (textTTS.equalsIgnoreCase(Constants.INPUT_UTTERANCE)){
						textTTS = mySession.getVariableField(IProjectVariables.PROMPT_AND_COLLECT, IProjectVariables.PROMPT_AND_COLLECT_FIELD_UTTERANCE).getStringValue();						
					}
					if(privateData.equalsIgnoreCase(Constants.FALSE)){
						if (mySession.isAppTraceEnabled() == true){mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "TEXT TTS: " + textTTS);}		
					}
					//SET TTS
					this.add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.XML_TAG_BEGIN,Constants.say_as, format));
					this.add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.TEXT,textTTS, null));
					this.add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.XML_TAG_END,Constants.say_as));
				}
				else if (audio.indexOf(Constants.SS_COLON)!= -1){
					String textSS=null;
					format = new com.avaya.sce.runtime.Format();
					boolean ssFmt = false;
					int posStartSS = audio.indexOf(Constants.COLON)+1;
					int posEndSS = audio.indexOf(Constants.COLON,posStartSS);
					textSS = audio.substring(posStartSS, posEndSS);
					if (textSS.equalsIgnoreCase(Constants.INPUT_VALUE)){
						textSS = mySession.getVariableField(IProjectVariables.PROMPT_AND_COLLECT, IProjectVariables.PROMPT_AND_COLLECT_FIELD_VALUE).getStringValue();						
					}
					if (textSS.equalsIgnoreCase(Constants.INPUT_UTTERANCE)){
						textSS = mySession.getVariableField(IProjectVariables.PROMPT_AND_COLLECT, IProjectVariables.PROMPT_AND_COLLECT_FIELD_UTTERANCE).getStringValue();						
					}
			
					//TYPE SELECTION
					if (audio.endsWith(Constants.NUMBER)){
						ssNumberCounter++;
						String fmtVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_NUMBER_FORMAT).getStringValue();
						String fmtValuesVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_NUMBER_FORMAT_VALUES).getStringValue();
						if(fmtVar != null && fmtValuesVar != null)
						{								
							ssFmt = ssFormat(mySession, fmtVar, fmtValuesVar, format,ssNumberCounter);
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
					}else if(audio.endsWith(Constants.DIGITS)){
						ssDigitsCounter++;
						String fmtVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_DIGITS_FORMAT).getStringValue();
						String fmtValuesVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_DIGITS_FORMAT_VALUES).getStringValue();
						if(fmtVar != null && fmtValuesVar != null)
						{
							ssFmt = ssFormat(mySession, fmtVar, fmtValuesVar, format,ssDigitsCounter);
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

					}else if(audio.endsWith(Constants.DATE)){
						ssDateCounter++;
						String fmtVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_DATE_FORMAT).getStringValue();
						String fmtValuesVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_DATE_FORMAT_VALUES).getStringValue();
						if(fmtVar != null && fmtValuesVar != null)
						{
							ssFmt = ssFormat(mySession, fmtVar, fmtValuesVar, format,ssDateCounter);
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

					}else if(audio.endsWith(Constants.TIME)){	
						ssTimeCounter++;
						String fmtVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_TIME_FORMAT).getStringValue();
						String fmtValuesVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_TIME_FORMAT_VALUES).getStringValue();
						if(fmtVar != null && fmtValuesVar != null)
						{
							ssFmt = ssFormat(mySession, fmtVar, fmtValuesVar, format,ssTimeCounter);
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
					}else if(audio.endsWith(Constants.CURRENCY)){
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
									ssFmt = ssFormat(mySession, fmtVar, fmtValuesVar, format,ssCurrencyCounter);
								}
								else{
									ssFmt = ssFormat(mySession, fmtVar, fmtValuesVar, format,ssCurrencyCounter);
								}
							}else{
								fmtValuesVar=Constants.WHOLE_DOLLARS;
								ssFmt = ssFormat(mySession, fmtVar, fmtValuesVar, format,ssCurrencyCounter);
							}
							ssFmt = ssFormat(mySession, fmtVar, fmtValuesVar, format,ssCurrencyCounter);
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
					if(privateData.equalsIgnoreCase(Constants.FALSE)){
						if (mySession.isAppTraceEnabled() == true){mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "TEXT SS: " + textSS);}			
					}
					add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.VARIABLE_AUDIO,name, format));
				}
				else{
					format = new com.avaya.sce.runtime.Format();
					format.add(com.avaya.sce.runtime.Format.FORMAT,com.avaya.sce.runtime.Format.FMT_FILEURL);
					String value = audioLocation + audio;
					mySession.putVariable(SimpleVariable.createSimpleVariable(name, value, null, mySession, false, false));
					if (mySession.isAppTraceEnabled() == true){mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Announce: " + value);}
					this.add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.VARIABLE_TEXT,name,format));
				}
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


