package com.servion.util;

import com.avaya.sce.runtimecommon.ITraceInfo;


public class SayItSmart {
	
	public String playCurrency(ITraceInfo trace, String strData)
	{		
		
		String playcurrency = AppConstant.EMPTY_STRING;
		String majorCurrency = AppConstant.Major;
		String minorCurrency = AppConstant.Minor;
		String fillerWave = AppConstant.Filler;
		
		try{

			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Currency Given :"+strData);
			
			if(strData!=null && !AppConstant.EMPTY_STRING.equals(strData)){
				
				String[] arrayData = strData.split("\\.");
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Major :"+arrayData[0]);
				int major = Integer.parseInt(arrayData[0]);
				if(major!=0){
					playcurrency = AppConstant.SS+arrayData[0]+AppConstant.number;
					
					if(major==1){
						playcurrency = playcurrency+AppConstant._Star+majorCurrency;
					}else{
						playcurrency = playcurrency+AppConstant._Star+majorCurrency;
					}
				}
				if(arrayData.length>1){
					int minor = Integer.parseInt(arrayData[1]);
					if(arrayData[1].length()>2){
						String strminor=arrayData[1].substring(0,2);
						minor = Integer.parseInt(strminor);
					}
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Minor :"+minor);
					if(minor!=0 && major!=0){
						playcurrency =  playcurrency+AppConstant._Star+fillerWave+AppConstant._Star+AppConstant.SS+minor+AppConstant.number+AppConstant._Star+minorCurrency;
					}else if(minor!=0){
						playcurrency =AppConstant.SS+minor+AppConstant.number+AppConstant._Star+minorCurrency;
					}else if(major == 0 && minor == 0){
						playcurrency =AppConstant.SS+major+AppConstant.number+AppConstant._Star+majorCurrency;
					}else if(major == 0){
						playcurrency =AppConstant.SS+major+AppConstant.number+AppConstant._Star+majorCurrency;
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

