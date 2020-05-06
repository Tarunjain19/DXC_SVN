package com.rcom.red.utils;

import java.util.ArrayList;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.rcom.red.constants.Constants;

public class DynamicMenu {
	public String playPrompt(ArrayList<String> dynamicValueList, String initialPrompt,String count,ITraceInfo trace){
		
		String value = Constants.EMPTY_STRING,Key = Constants.EMPTY_STRING;
		int intCount=0;
		trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Generate Initial Prompt");
		trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Prompt from Property File :" +initialPrompt);
		trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Count Value :" +count);
		trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"dynamic Value List :" +dynamicValueList);
		
		try {
			if(dynamicValueList!=null){
				for(int i=0; i<dynamicValueList.size();i++){
					value = dynamicValueList.get(i);
					if(value.contains(Constants.currency)){
						value = value.replaceAll(Constants.currency, Constants.EMPTY_STRING);
						
						SayItSmart objSayItSmart = new SayItSmart();
						value=objSayItSmart.playCurrency(trace, value);
					}
					
					Key = Constants.OPEN_BRACE+i+Constants.CLOSE_BRACE;
					initialPrompt = initialPrompt.replaceAll(Key,value);
					
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Dynamic value : "+value);
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Key Formed:" +Key);
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Initial Prompt:" +initialPrompt);
				}
			}else{
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Dynamic Value List is Null");
			}
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Initial Prompt After Dynamic Value Insertion:" +initialPrompt);
			
			if(count!=null && !Constants.EMPTY_STRING.equals(count) && !Constants.NA.equalsIgnoreCase(count)){
				intCount = Integer.parseInt(count);
				String[] optionGroup = initialPrompt.split(Constants.PIPE);
				initialPrompt = Constants.EMPTY_STRING;
				for(int i = 0 ;i<intCount;i++){
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Option Waves :"+ optionGroup);
					initialPrompt= initialPrompt+optionGroup[i]+Constants.Star;
				}
				
			}else{
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Count is not given so all waves are returned");
			}
		} catch (Exception e) {
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR,"Exception in forming Dynamic Wave :" +e);
			PrintStackTrace.PrintException(e);
		}
		
		trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Initial Prompt Final Wave :"+initialPrompt);
		return initialPrompt;
	}
	
	public static void main(String[] args) {
		String temp = "N*{3}";
		String key = "\\{3\\}";
		String value = "Hi";
		
		temp = temp.replaceAll(key, value);
		
		System.out.println(temp);
		
	}
}
