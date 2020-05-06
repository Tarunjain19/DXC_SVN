package com.rcom.util;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;

public class StackTrace {
	private static Logger logger = Logger.getLogger(AppConstants.LOGGER_NAME_CALLLEVEL);
		
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
		
		public static void GlobalPrintException(Exception e) {
			
			StringWriter sw = null;
			PrintWriter pw = null;
			Logger logger = Logger.getLogger(AppConstants.LOGGER_NAME_LOADLEVEL);
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
