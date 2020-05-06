package com.servion.rdtv.hostservice;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.DecimalFormat;

import org.apache.log4j.Logger;



public class Utilities {
	
	
	/*public static String getTimeStamp(Logger logger, String format)
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
	}*/
	public static XMLGregorianCalendar getTimeStamp()
	{
		GregorianCalendar gcal = new GregorianCalendar();
	      XMLGregorianCalendar xgcal = null;
		try {
			xgcal = DatatypeFactory.newInstance()
			        .newXMLGregorianCalendar(gcal);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
	     return xgcal;

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
	
	public static String getXMLFromObject(Logger logger, @SuppressWarnings("rawtypes") Class beanClassName, Object object, String xmlHeader){
		
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
	
	public static String adjustDecimal (Logger logger,String strDecimal2)

    {
           try
           {
          if(strDecimal2.contains("."))
                        {
	        	  			double d=Double.parseDouble(strDecimal2);
	       
	                        System.out.println("Original Decimal value is "+d);
	                        DecimalFormat df = new DecimalFormat("0.00");
	                        strDecimal2 = df.format(d);

                        }
           }
           catch(Exception e)
           {
                  logger.error("Error occured in : ", e);
           }
           return strDecimal2;
    }
	
}

