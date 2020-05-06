package com.servion.rcom.ppp.hostinterface.util;

import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

public class Utilities {
	
	private static final String CIPHER_DES = "DES";
	private static final String CIPHER_AES = "AES";
	
	private static Key key = null;

	public static String getXMLFromObject(Logger logger, Class beanClassName, Object object, String xmlHeader){
		
		StringWriter writer = new StringWriter();
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(beanClassName);
			Marshaller marshaller  = jaxbContext.createMarshaller();
			
			if(xmlHeader != null)
			{
				marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
				writer.append(xmlHeader);
			}
			
			marshaller.marshal(object, writer);
			
		} catch (JAXBException e) {
			
			logger.debug("JAXBException while converting to XML from Object" + e);
			logger.debug("JAXBException while converting to XML from Object | Error Message" + e.getMessage());
		}
		
		return writer.toString();
		
	}
	
	public static Object getObjectFromXML(Logger logger, Class beanClassName, String xml)
	{
		Object object = new Object();
		
		try {
			
			JAXBContext jaxbContext= JAXBContext.newInstance(beanClassName);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			StringReader reader = new StringReader(xml);
			
			object = unmarshaller.unmarshal(reader);
			
		} catch (JAXBException e) {
			logger.debug("JAXBException while converting to Object from XML" + e);
			logger.debug("JAXBException while converting to Object from XML | Error Message" + e.getMessage());
		}
		
		return beanClassName.cast(object);
	}
	
	
	public static String getTimeStamp(Logger logger, String format)
	{
		String timeStamp = null;
		try{
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		
		Calendar cal = Calendar.getInstance();
		Date todaysDate = cal.getTime();
		timeStamp = dateFormat.format(todaysDate);
		
		}catch(Exception e) {
			logger.error("Error occured in : ", e);
		}
		return timeStamp;
	}
	public static void printStackTrace(Logger logger, String sessionId, Exception e) {
		StringWriter sw = null;
		PrintWriter pw = null;
		try {
			sw = new StringWriter();
			pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			logger.error(sessionId+"Error occured in : ", e);
		}finally {
			sw.flush();
			pw.close();
			sw = null;
			pw = null;
		}
	}
	public static String generateUniqueID() throws Exception{
		Calendar c1 = Calendar.getInstance();
		SimpleDateFormat fromFormat = new SimpleDateFormat("HHmmssSSS");
        String vdatestr = fromFormat.format(c1.getTime());
        return vdatestr;
    } 
	
}

