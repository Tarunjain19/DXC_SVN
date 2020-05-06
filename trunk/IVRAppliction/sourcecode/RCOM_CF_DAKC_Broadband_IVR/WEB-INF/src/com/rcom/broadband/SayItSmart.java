package com.rcom.broadband;

import com.avaya.sce.runtimecommon.ITraceInfo;


public class SayItSmart {
	
	public String playCurrency(ITraceInfo trace, String strData)
	{		
		
		String playcurrency = Constants.EMPTY;
		String majorCurrency = Constants.Major;
		String minorCurrency = Constants.Minor;
		String fillerWave = Constants.Filler;
		
		try{

			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Currency Given :"+strData);
			
			if(strData!=null && !Constants.EMPTY.equals(strData)){
				
				String[] arrayData = strData.split("\\.");
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Major :"+arrayData[0]);
				int major = Integer.parseInt(arrayData[0]);
				if(major!=0){
					playcurrency = Constants.SS+arrayData[0]+Constants.number;
					
					if(major==1){
						playcurrency = playcurrency+Constants.STAR+majorCurrency;
					}else{
						playcurrency = playcurrency+Constants.STAR+majorCurrency;
					}
				}
				if(arrayData.length>1){
					int minor = Integer.parseInt(arrayData[1]);
					if(minor!=0 && major!=0){
						playcurrency =  playcurrency+Constants.STAR+fillerWave+Constants.STAR+Constants.SS+minor+Constants.number+Constants.STAR+minorCurrency;
					}else if(minor!=0){
						playcurrency =Constants.SS+minor+Constants.number+Constants.STAR+minorCurrency;
					}else if(major == 0 && minor == 0){
						playcurrency =Constants.SS+major+Constants.number+Constants.STAR+majorCurrency;
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