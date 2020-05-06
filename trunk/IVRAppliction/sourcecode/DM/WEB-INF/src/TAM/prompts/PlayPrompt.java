/**
 * Last generated by Orchestration Designer at: 2013-FEB-06  11:14:09 PM
 */
package TAM.prompts;

import com.avaya.sce.runtime.Format;
import com.avaya.sce.runtime.SimpleVariable;

import com.avaya.sce.runtimecommon.IRuntimeSession;
import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.IVariable;
import com.avaya.sce.runtimecommon.SCESession;
import com.dm.util.Constants;



import flow.IProjectVariables;

public class PlayPrompt extends com.avaya.sce.runtime.Prompt {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Constructor for PlayPrompt.
	 */
	public PlayPrompt() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}


	/**
	 * This method is generated automatically and should not be manually edited
	 * To manually edit the prompt, override:
	 * void updatePrompt()
	 * Last generated by Orchestration Designer at: 2017-SEP-04  04:23:58 PM
	 */
	public void buildPrompt(){
		com.avaya.sce.runtime.Format format = null;
		com.avaya.sce.runtime.RenderHint hint = null;
		com.avaya.sce.runtime.MediaPage mediaPage = null;
		setBarginType(com.avaya.sce.runtimecommon.SCERT.BARGIN_SPEECH);
		setName("PlayPrompt");
		setOrder(com.avaya.sce.runtime.Prompt.STANDARD);

		// Prompt level 1
		setTimeout(1,5000);
		setBargin(1,true);

	}

	@Override
	public void updatePrompt(SCESession mySession) {
		super.updatePrompt(mySession);
		IRuntimeSession runtimeSession = mySession;

		IVariable inputVar = mySession.getVariable(IProjectVariables.INPUT_VARIABLES);

		com.avaya.sce.runtime.Format format = null;
		com.avaya.sce.runtime.RenderHint hint = null;
		//setBarginType(com.avaya.sce.runtimecommon.SCERT.BARGIN_SPEECH);
		int timeOut = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_TIMEOUT).getIntValue();

		setName("PlayPrompt");
		// Prompt level 1
		setTimeout(1,timeOut);

		boolean bargeIn = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_BARGE_IN).getBooleanValue();
		String bargeInType=inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_BARGE_IN_TYPE).getStringValue();
		if(mySession.isDDTraceEnabled()){
			mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "BargeIn property: " + bargeIn);
			mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "BargeIn Type: " + bargeInType);
		}
		setBargin(1, bargeIn);
		if(Constants.hotword.equalsIgnoreCase(bargeInType)){
			setBarginType(com.avaya.sce.runtimecommon.SCERT.BARGIN_HOTWORD);
		}else{
			setBarginType(com.avaya.sce.runtimecommon.SCERT.BARGIN_SPEECH);
		}
	
		String initialPrompt = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_INITIAL_PROMPT).getStringValue();
		if(!Constants.NONE.equalsIgnoreCase(initialPrompt)){
			mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Initial Prompt 1: " + bargeIn);
			format = new com.avaya.sce.runtime.Format();
			format.add(com.avaya.sce.runtime.Format.FORMAT,com.avaya.sce.runtime.Format.FMT_FILEURL);
			String promptLocation = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_AUDIO_LOCATION).getStringValue();
			String promptFile = "";
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
			IVariable initialPromptCollection =null;
			
			String moreOptionFlag=mySession.getVariableField(IProjectVariables.INPUT_VARIABLES,IProjectVariables.INPUT_VARIABLES_FIELD_MORE_OPTION_FLAG).getStringValue();
			if(moreOptionFlag.equalsIgnoreCase(Constants.TRUE)){
				initialPromptCollection = mySession.getVariable(IProjectVariables.COLLECTIONINITIALREPROMPT);
			}else{
				initialPromptCollection = mySession.getVariable(IProjectVariables.COLLECTIONINITIALPROMPT);
				
			}

			initialPromptCollection.getCollection().reset();
			setOrder(com.avaya.sce.runtime.Prompt.STANDARD);

			if(initialPromptCollection != null){
				mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Initial Prompt 2:" + initialPromptCollection.getCollection().hasMore());
				for(int i = 1;initialPromptCollection.getCollection().hasMore();i++){
					mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Initial Prompt 3: " + bargeIn);
					initialPromptCollection.getCollection().next();
					String name = Constants.PROMPT + String.valueOf(i);
					promptFile = initialPromptCollection.getSimpleVariable().getStringValue();
					if (mySession.isAppTraceEnabled() == true){mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Variable in Collection: " + promptFile);}
					if (promptFile.indexOf(Constants.TTS_COLON)!= -1){
						boolean ssFmt = false;
						String textTTS=null;
						format = new com.avaya.sce.runtime.Format();
						//Says the Format of the TTS to be Played
						if (promptFile.endsWith(Constants.NUMBER)){
							ttsNumberCounter++;
							String fmtVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_TTS_NUMBER_FORMAT).getStringValue();
							String fmtValuesVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_TTS_NUMBER_FORMAT_VALUES).getStringValue();
							if(fmtVar != null && fmtValuesVar != null)
							{								
								ssFmt = ssFormat(mySession, fmtVar, fmtValuesVar, format, ttsNumberCounter);
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
						}else if(promptFile.endsWith(Constants.DIGITS)){
							ttsDigitsCounter++;
							String fmtVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_TTS_DIGITS_FORMAT).getStringValue();
							String fmtValuesVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_TTS_DIGITS_FORMAT_VALUES).getStringValue();
							if(fmtVar != null && fmtValuesVar != null)
							{								
								ssFmt = ssFormat(mySession, fmtVar, fmtValuesVar, format, ttsDigitsCounter);
								if(!ssFmt)
								{
									format.add(Constants.INTERPRET_AS,Constants.DIGITS);
								}
							}
							else
							{
								format.add(Constants.INTERPRET_AS,Constants.DIGITS);
							}

						}else if(promptFile.endsWith(Constants.DATE)){
							ttsDateCounter++;
							String fmtVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_TTS_DATE_FORMAT).getStringValue();
							String fmtValuesVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_TTS_DATE_FORMAT_VALUES).getStringValue();
							if(fmtVar != null && fmtValuesVar != null)
							{								
								ssFmt = ssFormat(mySession, fmtVar, fmtValuesVar, format, ttsDateCounter);
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
						}else if(promptFile.endsWith(Constants.CURRENCY)){
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
						}else if (promptFile.endsWith(Constants.ADDRESS)){
							ttsAddressCounter++;
							String fmtVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_TTS_ADDRESS_FORMAT).getStringValue();
							String fmtValuesVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_TTS_ADDRESS_FORMAT_VALUES).getStringValue();
							if(fmtVar != null && fmtValuesVar != null)
							{								
								ssFmt = ssFormat(mySession, fmtVar, fmtValuesVar, format, ttsAddressCounter);
								if(!ssFmt)
								{
									format.add(Constants.INTERPRET_AS,Constants.ADDRESS);
								}
							}
							else
							{
								format.add(Constants.INTERPRET_AS,Constants.ADDRESS);
							}
						}else if (promptFile.endsWith(Constants.NAME)){
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
						}else if (promptFile.endsWith(Constants.TELEPHONE)){
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
						int posStart = promptFile.indexOf(Constants.COLON) + 1;
						int posEnd = promptFile.indexOf(Constants.COLON,posStart);
						textTTS=promptFile.substring(posStart, posEnd);
						if (mySession.isAppTraceEnabled() == true){mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"TEXT TTS: " + textTTS);}
						//SET TTS
						this.add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.XML_TAG_BEGIN,"say-as", format));
						this.add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.TEXT,textTTS, null));
						this.add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.XML_TAG_END,"say-as"));
					}
					else if (promptFile.indexOf(Constants.SS_COLON)!= -1){
						String textSS=null;
						boolean ssFmt = false;
						format = new com.avaya.sce.runtime.Format();
						int posStart = promptFile.indexOf(Constants.COLON)+1;
						int posEnd = promptFile.indexOf(Constants.COLON,posStart);
						textSS=promptFile.substring(posStart, posEnd);

						//TYPE SELECTION
						if (promptFile.endsWith(Constants.NUMBER)){
							ssNumberCounter++;	
							String fmtVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_NUMBER_FORMAT).getStringValue();
							String fmtValuesVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_NUMBER_FORMAT_VALUES).getStringValue();
							if(fmtVar != null && fmtValuesVar != null)
							{								
								ssFmt = ssFormat(mySession, fmtVar, fmtValuesVar, format, ssNumberCounter);
								if(!ssFmt)
								{
									format.add(Constants.FORMAT,Constants.NUMBER);
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
						}else if(promptFile.endsWith(Constants.DIGITS)){
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

						}else if(promptFile.endsWith(Constants.DATE)){
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

						}else if(promptFile.endsWith(Constants.TIME)){	
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
						}else if(promptFile.endsWith(Constants.CURRENCY)){
							ssCurrencyCounter++;
							String fmtVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_CURRENCY_FORMAT).getStringValue();
							String fmtValuesVar = inputVar.getComplexVariable().getField(IProjectVariables.INPUT_VARIABLES_FIELD_CURRENCY_FORMAT_VALUES).getStringValue();
							if(fmtVar != null && fmtValuesVar != null)
							{
								if(textSS.contains(Constants.DOT)){
									String[] centsAmt=textSS.split(Constants.SplitDOT);
									int cents=0;
									if(centsAmt.length>1)
										cents=Integer.valueOf(centsAmt[1]);
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
						if (mySession.isAppTraceEnabled() == true){mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "TEXT SS: " + textSS);}
						add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.VARIABLE_AUDIO,name, format));			
					}
					else{
						format = new com.avaya.sce.runtime.Format();
						format.add(com.avaya.sce.runtime.Format.FORMAT,com.avaya.sce.runtime.Format.FMT_FILEURL);
						String value = promptLocation + promptFile;
						if(initialPrompt.contains(Constants.HTTP)){
							value=initialPrompt;
						}
						mySession.putVariable(SimpleVariable.createSimpleVariable(name, value, null, mySession, false, false)); 
						if (mySession.isAppTraceEnabled() == true){mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Announce: " + value);}
						this.add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.VARIABLE_TEXT,name,format));
					}

				}
			}

		}else{

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
