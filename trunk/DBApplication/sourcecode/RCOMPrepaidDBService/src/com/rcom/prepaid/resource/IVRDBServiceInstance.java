package com.rcom.prepaid.resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rcom.prepaid.dbservice.IVRDataService;

public class IVRDBServiceInstance {
	
	@SuppressWarnings("unused")
	private static IVRDBServiceInstance ivrdbServiceInstance = new IVRDBServiceInstance();

	
	private static IVRDataService ivrdbService;
	
	private IVRDBServiceInstance(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		ivrdbService = (IVRDataService) ctx.getBean("dataServices");
		
	}
	
	/**
	 * 
	 * @return IVRDBService to the presentation layer
	 */
	public static IVRDataService getInstance()
	{
		return ivrdbService;
	}

}
