package com.rcom.broadband;


import com.avaya.sce.runtimecommon.ITraceInfo;


public class SayItSmartTime {
	
	public String playTime(ITraceInfo trace, String strData)
	{		
		
		String playcurrency = Constants.EMPTY;
		String hours = Constants.Hours;
		String minutes = Constants.Minutes;
		String fillerWave = Constants.Filler;
		
		try{

			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Time Given :"+strData);
			
			if(strData!=null && !Constants.EMPTY.equals(strData)){
				
				String[] arrayData = strData.split("\\:");
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Hour :"+arrayData[0]);
				int hour = Integer.parseInt(arrayData[0]);
				if(hour!=0){
					playcurrency = Constants.SS+arrayData[0]+Constants.number;
					
					if(hour==1){
						playcurrency = playcurrency+Constants.STAR+hours;
					}else{
						playcurrency = playcurrency+Constants.STAR+hours;
					}
				}
				if(arrayData.length>1){
					int minute = Integer.parseInt(arrayData[1]);
					if(minute!=0 && hour!=0){
						playcurrency =  playcurrency+Constants.STAR+fillerWave+Constants.STAR+Constants.SS+minute+Constants.number+Constants.STAR+minutes;
					}else if(minute!=0){
						playcurrency =Constants.SS+minute+Constants.number+Constants.STAR+minutes;
					}else if(hour == 0 && minute == 0){
						playcurrency =Constants.SS+hour+Constants.number+Constants.STAR+hours;
					}
				}
			}else{
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Time is given Empty");
			}
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Time Returned :"+playcurrency);
		}catch(Exception e){
			StackTrace.PrintException(e);
		}
		return playcurrency;
	}
	
	/*public static void main(String[] args) {
		SimpleDateFormat sdFormat = new SimpleDateFormat("ddMMyyyy");
		SimpleDateFormat sdFormat2 = new SimpleDateFormat("yyyyMMdd");
		Date dstartDate;
		try {
			dstartDate = sdFormat.parse("31072007");
			String e = sdFormat2.format(dstartDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}*/
}
