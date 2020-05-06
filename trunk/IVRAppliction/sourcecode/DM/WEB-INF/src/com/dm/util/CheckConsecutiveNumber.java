package com.dm.util;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;

public class CheckConsecutiveNumber {

	public static boolean checkConsecutive(String inputNo,SCESession mySession) {
		ITraceInfo trace = mySession.getTraceOutput();
        try{
        	if(inputNo == null){
        	if(mySession.isAppTraceEnabled()){trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, " Value Entered is null ");}
        	}else{
               inputNo = inputNo.toLowerCase();
               if (inputNo.length() == 1)
                     return true;

               for (int i = 1; i < inputNo.length(); i++) {
                     String first = inputNo.substring(i, i+1);
                     String beforeFirst = inputNo.substring(i-1, i);

                     if (beforeFirst.compareTo(first) > 0) {
                            return false;
                     }
               }
        	}
        }catch(Exception e){
        	if(mySession.isAppTraceEnabled()){trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR,"EXCEPTION at: Util.checkConsecutive()" + e);}
        }
        
        return true;
 }
}
