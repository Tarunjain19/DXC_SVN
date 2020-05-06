package com.rel.pco.configure;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.servion.gcc.framework.common.CustomData;
import com.servion.gcc.framework.common.ElementConfigInfo;
import com.servion.gcc.framework.common.ElementInfoCallLevel;
import com.servion.gcc.framework.common.ElementInfoInterface;
import com.servion.gcc.framework.common.Logger;
import com.servion.gcc.framework.definer.elementconfigurator.ElementConfiguratorInterface;
import com.servion.gcc.framework.definer.util.DefinerManager;
import com.servion.gcc.framework.loader.bean.voice.Audioitem;

public class LanguageMenuSetter implements ElementConfiguratorInterface{

	private static final String DEFAULT_LANG="DEFAULT_LANG";
	private static final String APPLICABLE_LANG="APPLICABLE_LANG";
	private static final String LANGUAGEAUDIOS="LANGUAGEAUDIOS";
	private static final String PRESSAUDIOS="PRESSAUDIOS";
	private static final String INITIALAUDIO="INITIALAUDIO";

	private static final String S_STR_ELEMENTEXIT="S_STR_ELEMENTEXIT";


	public ElementInfoCallLevel doBefore(Logger logger, CustomData data,ElementConfigInfo beanElementConfigInfo) {
		String ClassName=this.getClass().getName();
		ElementInfoCallLevel beanElementInfoCallLevel=new ElementInfoCallLevel();
		try{
			data.addToLog(ClassName,"Entering into Language Menu Setter");
			Map<String, Object> mapConfigData=(Map<String, Object>)beanElementConfigInfo.getElementData();
			String[] strApplicableLanguages=((String) data.getSessionData(APPLICABLE_LANG)).split("\\,");


			data.addToLog(ClassName,"Languages :"+strApplicableLanguages);

			Map<String,Object> mapLangAudio=(Map<String, Object>) mapConfigData.get(LANGUAGEAUDIOS);
			Map<String,Object> mapPressAudios=(Map<String, Object>) mapConfigData.get(PRESSAUDIOS);
			Map<Integer,String> mapLangInfo=new HashMap<Integer,String>();



			String strInitialAudio = (String) mapConfigData.get(INITIALAUDIO);

			data.addToLog(ClassName,"Language Audios:"+mapLangAudio);


			List<String> listDTMFKeyPress=new ArrayList<>();
			List<Audioitem> listAudioItems=new ArrayList<Audioitem>();
			Map<String, List<String>> mapDtmfKeyPress=new HashMap<>();

			Audioitem beanInitialAudio;
			Audioitem beanLangAudio;
			Audioitem beanKeyAudio;
			String strLangAudio;
			String strKeyAudio;
			for(int i=0;i<strApplicableLanguages.length;i++)	{
				beanInitialAudio=new Audioitem();
				beanLangAudio=new Audioitem();
				beanKeyAudio=new Audioitem();
				strLangAudio=(String) mapLangAudio.get(strApplicableLanguages[i]);
				strKeyAudio=(String) mapPressAudios.get(String.valueOf(i+1));
				listDTMFKeyPress.add(String.valueOf(i+1));

				mapLangInfo.put(i+1,strApplicableLanguages[i]);

				beanInitialAudio.setValue(strInitialAudio);
				beanLangAudio.setValue(strLangAudio);
				beanKeyAudio.setValue(strKeyAudio);
				listAudioItems.add(beanInitialAudio);
				listAudioItems.add(beanLangAudio);
				listAudioItems.add(beanKeyAudio);
			}
			
			
				

			mapDtmfKeyPress.put("dtmf_keypress",listDTMFKeyPress);
			data.setSessionData("S_LIST_INITIAL_LANGAUDIOS",listAudioItems);
			data.setSessionData("S_MAP_LANGINFO",mapLangInfo);

			data.addToLog(ClassName,"DTMF Key Press:"+mapDtmfKeyPress);
			data.addToLog(ClassName, "Audio Items:"+listAudioItems);

			beanElementInfoCallLevel.setDtmf(mapDtmfKeyPress);
		}catch(Exception e){
			StringWriter str=new StringWriter();
			e.printStackTrace(new PrintWriter(str));
			data.addToLog(ClassName,"Exception :"+str.toString());
		}
		return beanElementInfoCallLevel;
	}

	public void doAfter(Logger logger, CustomData data,ElementConfigInfo beanElementConfigInfo) {
		try{
			String strElementExit=(String) data.getSessionData(S_STR_ELEMENTEXIT);
			Map<Integer,String> mapLangInfo=new HashMap<Integer,String>();
			Integer intvalue;

			try{
				intvalue=Integer.parseInt(strElementExit);
				mapLangInfo=(Map<Integer, String>) data.getSessionData("S_MAP_LANGINFO");
				String strSelectLang = mapLangInfo.get(intvalue);
				data.setSessionData("S_STR_SELECT_LANG",strSelectLang);
				data.addToLog(this.getClass().getName(),"Caller Selected Language :"+strSelectLang);
			}catch(Exception e){
				StringWriter str=new StringWriter();
				e.printStackTrace(new PrintWriter(str));
				data.addToLog("Exception:",str.toString());
			}
			
		}catch(Exception e){
			StringWriter str=new StringWriter();
			e.printStackTrace(new PrintWriter(str));
			data.addToLog("Exception:",str.toString());
		}
	}


	public void doFeature(ElementInfoInterface elementinfo,
			ElementConfigInfo beanElementConfigInfo, String strElementCategory,
			DefinerManager beanDefinerManager) {
	}

	public String doValidate(Logger logger, String strValue,
			String strLoggerKey, CustomData data) {
		return null;
	}



}
