package com.rcom.red.util;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;

import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA.HOSTDETAILS.HOST;

public class Utils {

	/**
	 * 
	 * @param logger
	 * @param strProcedure
	 * @param startTime
	 * @param endtime
	 */
	public void getConnectionTime(Logger logger,String sessionId, String strProcedure, long startTime, long endtime){
		if(logger.isDebugEnabled()){logger.debug(sessionId+"Time for executing "+strProcedure+" is "+(endtime-startTime)+" ms");}
		//System.out.println((endtime-startTime));
	}

	/**
	 * 
	 * @param logger
	 * @param e
	 */
	public void printStackTrace(Logger logger, String sessionId, Exception e) {
		StringWriter sw = null;
		PrintWriter pw = null;
		try {
			sw = new StringWriter();
			pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			//e.printStackTrace();
			logger.error(sessionId+"Error occured in : ", e);
		}finally {
			sw.flush();
			pw.close();
			sw = null;
			pw = null;
		}
	}

	public void generateReport(GetReportObject reportObject, String hostId, String hostMethod, String startTime, String input, String output, String response, String status, String endtime){
		
		if(reportObject!= null){
			HOST host = reportObject.createReportHostObject();
			
			host.setHOSTTYPE("DB");
			host.setHOSTID(hostId);
			host.setHOSTMETHOD(hostMethod);
			host.setHOSTSTDATETIME(startTime);
			host.setHOSTINPARAMS(input);
			host.setHOSTOUTPARAMS(output);
			host.setHOSTRESPONSE(response);
			host.setHOSTSTATUS(status);
			host.setHOSTENDDATETIME(endtime);
			
			reportObject.insertHostDetail(reportObject.getIvrreportdata(), host);
		}
		
	}

}
