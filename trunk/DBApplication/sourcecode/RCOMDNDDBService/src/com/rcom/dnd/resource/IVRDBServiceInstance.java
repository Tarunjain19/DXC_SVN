package com.rcom.dnd.resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rcom.dnd.dbservice.IVRDataService;

public class IVRDBServiceInstance {
	
	@SuppressWarnings("unused")
	private static IVRDBServiceInstance ivrdbServiceInstance = new IVRDBServiceInstance();

	
	private static IVRDataService ivrdbService;
	
	private IVRDBServiceInstance(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("dnd-application-context.xml");
		ivrdbService = (IVRDataService) ctx.getBean("dndDataServices");
		//webWorldPhonegenService = (WebWorldPhonegenService) ctx.getBean("phonegenService");
		
	}
	
	/**
	 * 
	 * @return IVRDBService to the presentation layer
	 */
	public static IVRDataService getIVRDBInstance()
	{
		return ivrdbService;
	}

}
