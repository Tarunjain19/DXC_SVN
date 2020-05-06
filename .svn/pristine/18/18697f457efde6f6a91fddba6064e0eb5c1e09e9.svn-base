package com.servion.rcom.hostinterface;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.dnd.util.AppConstant;

public class Main {

	public static void main(String[] args) {

		
		/*LoadProperty loadProperty = new LoadProperty("D:/v2.1/apache-tomcat-7.0.26/webapps/RCOM/DND/DND_IVR_CONFIG.properties");
		
		String toContinuePromptID = "42055.wav";
		StringBuilder initialPrompt = new StringBuilder(100);
		
		
		
		String languagesFromDB = "ENG,TAM,MAR,HIN";
		//String languagesFromDB = "ENG";
		
		
		String[] languages = new String[languagesFromDB.split(",").length];
		languages = languagesFromDB.split(",");
		
		int langIndex = 1;
		for(String lang : languages)
		{
			initialPrompt.append(lang).append("_").append(toContinuePromptID);
			initialPrompt.append("*");
			initialPrompt.append(LoadProperty.getivrconfigProp("LANGUAGE_" + lang + "_PROMPT_ID"));
			initialPrompt.append("*");
			initialPrompt.append(LoadProperty.getivrconfigProp(lang + "_PRESS_" +langIndex));
			if(languages.length!=langIndex)
			initialPrompt.append("*");
			langIndex++;
		}
		
		System.out.println(initialPrompt.toString());*/
		
		try{
		String dndDeActivationDate = "10/05/2015 21:00:00";
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(AppConstant.DATE_TIME_FORMAT);
		Calendar calendar = Calendar.getInstance();
		
		Date deactivateionDate = dateFormat.parse(dndDeActivationDate);
		Date currentDate = calendar.getTime();
		
		System.out.println(deactivateionDate);
		System.out.println(currentDate);
		
		long diff = currentDate.getTime()-deactivateionDate.getTime();
		System.out.println(currentDate.getTime());
		System.out.println(deactivateionDate.getTime());
		System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
		
		System.out.println(currentDate.compareTo(deactivateionDate));
		
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	}
}
