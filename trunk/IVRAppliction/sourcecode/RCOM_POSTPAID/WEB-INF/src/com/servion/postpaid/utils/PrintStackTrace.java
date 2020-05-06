package com.servion.postpaid.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;

public class PrintStackTrace {
	private static Logger logger = Logger.getLogger(com.servion.postpaid.utils.PrintStackTrace.class);
		
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
		
		public static void PrintStartUpException(Logger logger, Exception e) {
			
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
}
