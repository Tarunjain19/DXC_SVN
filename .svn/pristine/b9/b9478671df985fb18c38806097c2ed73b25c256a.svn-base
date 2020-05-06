package com.rcom.energy;



import com.avaya.sce.runtimecommon.ITraceInfo;


public class SayItSmartTime {
	
	public String playTime(ITraceInfo trace, String strData)
	{		
		
		String playcurrency = AppConstants.EMPTY_STRING;
		String hours = AppConstants.Hours;
		String minutes = AppConstants.Minutes;
		String fillerWave = AppConstants.Filler;
		
		try{

			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Time Given :"+strData);
			
			if(strData!=null && !AppConstants.EMPTY_STRING.equals(strData)){
				
				String[] arrayData = strData.split("\\:");
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Hour :"+arrayData[0]);
				int hour = Integer.parseInt(arrayData[0]);
				if(hour!=0){
					playcurrency = AppConstants.SS+arrayData[0]+AppConstants.number;
					
					if(hour==1){
						playcurrency = playcurrency+AppConstants._Star+hours;
					}else{
						playcurrency = playcurrency+AppConstants._Star+hours;
					}
				}
				if(arrayData.length>1){
					int minute = Integer.parseInt(arrayData[1]);
					if(minute!=0 && hour!=0){
						playcurrency =  playcurrency+AppConstants._Star+fillerWave+AppConstants._Star+AppConstants.SS+minute+AppConstants.number+AppConstants._Star+minutes;
					}else if(minute!=0){
						playcurrency =AppConstants.SS+minute+AppConstants.number+AppConstants._Star+minutes;
					}else if(hour == 0 && minute == 0){
						playcurrency =AppConstants.SS+hour+AppConstants.number+AppConstants._Star+hours;
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
	
	public static void main(String[] args) {
		/*SimpleDateFormat sdFormat = new SimpleDateFormat("MMMyy");
		SimpleDateFormat sdFormat2 = new SimpleDateFormat("yyyyMM");
		Date dstartDate;
		try {
			dstartDate = sdFormat.parse("MAR07");
			String e = sdFormat2.format(dstartDate);
			System.out.println(e);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
	}
}
