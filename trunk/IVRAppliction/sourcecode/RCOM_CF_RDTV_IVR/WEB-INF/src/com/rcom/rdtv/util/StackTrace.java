package com.rcom.rdtv.util;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;

public class StackTrace {
	private static Logger logger = Logger.getLogger(StackTrace.class);
		
		public static void PrintException(Exception e) {
			
			StringWriter sw = null;
			PrintWriter pw = null;
			
			try {
				sw = new StringWriter();
				pw = new PrintWriter(sw);
				e.printStackTrace(pw);
				logger.error("Error occured in : ", e);
			} finally {
				sw.flush();
				pw.close();
				sw = null;
				pw = null;
			}
		}
		
		/*public static void main(String[] args) {
			AppProperties.setInstance(AppConstants.IVR_HOST_PROPERTIES, "D:\\New Volume (E)\\C\\ProjectList\\RCOM\\AAOD_7_0\\AAOD7.0\\apache-tomcat-7.0.26\\webapps\\RCOM\\REL\\");			
			String DNIS = null;
			String sessionId = null;
			
			
			DNIS = "52588";
			sessionId ="12345";
			
			//Setting IVRDataBean in session for DB Transactions - Start
			IVRDataBean ivrDataBean = new IVRDataBean();
			ivrDataBean.setSessionID(sessionId);
			ivrDataBean.setLogger(logger);
			
			String DBResponse = AppConstants.FAILURE;
			
			try{
			
				IVRRoutingInfo reqIvrRoutingInfo = new IVRRoutingInfo();
				reqIvrRoutingInfo.setDnis(DNIS);
				IVRRoutingInfo resIvrRoutingInfo = IVRDBServiceInstance.getIVRDBInstance().getIVRRoutingInfo(ivrDataBean, reqIvrRoutingInfo);
				System.out.println(resIvrRoutingInfo);
				String circle = resIvrRoutingInfo.getCircle();
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}*/
}
