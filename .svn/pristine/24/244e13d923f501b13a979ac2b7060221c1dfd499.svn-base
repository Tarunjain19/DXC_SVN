package com.rel.pco.business;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

import com.avaya.sce.runtimecommon.SCESession;
import com.servion.gcc.framework.common.AppDataSetter;
import com.servion.gcc.framework.common.CustomData;
import com.servion.gcc.framework.common.Logger;
import com.servion.gcc.framework.interfaces.APIInterface;
import com.servion.gcc.framework.util.ApplicationConstantInterface;

import flow.IProjectVariables;

public class LanguageUpdate implements APIInterface{

	private static final String S_STR_SELECT_LANG="S_STR_SELECT_LANG";
	
	public String doExecute(Logger logger, CustomData cData,
			Map<String, Object> mapDecisionData, SCESession mysession) {
		String strExitState=ApplicationConstantInterface.ERROR;
		try{
			String strSelectLang=(String) cData.getSessionData(S_STR_SELECT_LANG);
			String strAudioPath=(String)AppDataSetter.getInstance(mysession.getAppName()).getAppData(ApplicationConstantInterface.AUDIOPATH);
			if(strSelectLang!=null){
				cData.addToLog(this.getClass().getName(),"Selected Language:"+strSelectLang);
				String strCustomAudioPath=strAudioPath+ApplicationConstantInterface.SLASH+strSelectLang+"custom"+ApplicationConstantInterface.SLASH;
				String strStandardAudioPath=strAudioPath+ApplicationConstantInterface.SLASH+strSelectLang+"standard"+ApplicationConstantInterface.SLASH;
				mysession.getVariableField(IProjectVariables.INPUT_PARAMETERS,IProjectVariables.INPUT_PARAMETERS_FIELD_CUSTOM_AUDIO_LOCATION).setValue(strCustomAudioPath);
				mysession.getVariableField(IProjectVariables.INPUT_PARAMETERS,IProjectVariables.INPUT_PARAMETERS_FIELD_STANDARD_AUDIO_LOCATION).setValue(strStandardAudioPath);

				cData.setSessionData(ApplicationConstantInterface.S_STR_ACTIVE_LANG,strSelectLang);
				strExitState=ApplicationConstantInterface.SUCCESS;
			}
		}
		catch(Exception e){
			StringWriter str=new StringWriter();
			e.printStackTrace(new PrintWriter(str));
			cData.addToLog("Exception:",str.toString());
		}
		return strExitState;
	}
}
