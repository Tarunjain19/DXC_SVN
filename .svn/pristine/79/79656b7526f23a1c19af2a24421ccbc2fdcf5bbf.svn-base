package com.rcom.postpaid.resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rcom.postpaid.dbservice.IVRDataService;

public class IVRDBServiceInstance {
	
	@SuppressWarnings("unused")
	private static IVRDBServiceInstance ivrdbServiceInstance = new IVRDBServiceInstance();

	
	private static IVRDataService ivrdbService;
	
	private IVRDBServiceInstance(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("postpaid-application-context.xml");
		ivrdbService = (IVRDataService) ctx.getBean("postpaidDataServices");
		
		
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
