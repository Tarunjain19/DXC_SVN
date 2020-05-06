package com.rcom.rdtv.util;

import com.avaya.sce.runtimecommon.ITraceInfo;


public class SayItSmart {
	
	public String playCurrency(ITraceInfo trace, String strData)
	{		
		
		String playcurrency = AppConstants.EMPTY_STRING;
		String majorCurrency = AppConstants.Major;
		String minorCurrency = AppConstants.Minor;
		String fillerWave = AppConstants.Filler;
		
		try{

			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Currency Given :"+strData);
			
			if(strData!=null && !AppConstants.EMPTY_STRING.equals(strData)){
				
				String[] arrayData = strData.split("\\.");
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Major :"+arrayData[0]);
				int major = Integer.parseInt(arrayData[0]);
				if(major!=0){
					playcurrency = AppConstants.SS+arrayData[0]+AppConstants.number;
					
					if(major==1){
						playcurrency = playcurrency+AppConstants._Star+majorCurrency;
					}else{
						playcurrency = playcurrency+AppConstants._Star+majorCurrency;
					}
				}
				if(arrayData.length>1){
					int minor = Integer.parseInt(arrayData[1]);
					if(minor!=0 && major!=0){
						playcurrency =  playcurrency+AppConstants._Star+fillerWave+AppConstants._Star+AppConstants.SS+minor+AppConstants.number+AppConstants._Star+minorCurrency;
					}else if(minor!=0){
						playcurrency =AppConstants.SS+minor+AppConstants.number+AppConstants._Star+minorCurrency;
					}else if(major == 0 && minor == 0){
						playcurrency =AppConstants.SS+major+AppConstants.number+AppConstants._Star+majorCurrency;
					}
				}
			}else{
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Currency is given Empty");
			}
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Currency Returned :"+playcurrency);
		}catch(Exception e){
			StackTrace.PrintException(e);
		}
		return playcurrency;
	}
}
