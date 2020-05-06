package com.servion.rcom.hostinterface.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Utilities {
	
	private static final String CIPHER_DES = "DES";

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
	
	public static String getDESEncryptedText(Logger logger, String plainText, String strKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException
	{
		
		Cipher cipher = Cipher.getInstance(CIPHER_DES);
		byte[] keyInBytes = strKey.getBytes();
		
		SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(CIPHER_DES);
		KeySpec keySpec = new DESKeySpec(keyInBytes);
		SecretKey secretKey = secretKeyFactory.generateSecret(keySpec);
		
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		
		String encryptedText = new BASE64Encoder().encode(cipher.doFinal(plainText.getBytes("UTF8")));
		
		return encryptedText;
		
	}
	
	public static String getDESDecryptedText(Logger logger, String encryptedText, String strKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, IOException
	{
		Cipher cipher = Cipher.getInstance(CIPHER_DES);
		byte[] keyInBytes = strKey.getBytes();
		
		SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(CIPHER_DES);
		KeySpec keySpec = new DESKeySpec(keyInBytes);
		SecretKey secretKey = secretKeyFactory.generateSecret(keySpec);
		
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		
		String decryptedText = new String(cipher.doFinal(new BASE64Decoder().decodeBuffer(encryptedText)), "UTF8");
		
		return decryptedText;
	}
	
	public static String getTimeStamp(Logger logger, String format)
	{
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		
		Calendar cal = Calendar.getInstance();
		Date todaysDate = cal.getTime();
		String timeStamp = dateFormat.format(todaysDate);
		
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

