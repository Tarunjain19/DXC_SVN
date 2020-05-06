package com.servion.util;

import java.util.ArrayList;

import com.avaya.sce.runtimecommon.ITraceInfo;

public class DynamicMenu {
	public static String playPrompt(ArrayList<String> dynamicValueList, String initialPrompt,String count, String menuID, ITraceInfo trace){
		
		String value = AppConstant.EMPTY_STRING,Key = AppConstant.EMPTY_STRING;
		int intCount=0;
		trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Generate Initial Prompt");
		trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Prompt from Property File :" +initialPrompt);
		trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Count Value :" +count);
		trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"dynamic Value List :" +dynamicValueList);
		trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Menu ID :" +menuID);
		try {
			if(dynamicValueList!=null){
				for(int i=0; i<dynamicValueList.size();i++){
					value = dynamicValueList.get(i);
					if(value.contains(AppConstant.currency)){
						value = value.replaceAll(AppConstant.currency, AppConstant.EMPTY_STRING);
						
						SayItSmart objSayItSmart = new SayItSmart();
						value=objSayItSmart.playCurrency(trace, value);
					}
					
					Key = AppConstant.OPEN_BRACE+i+AppConstant.CLOSE_BRACE;
					initialPrompt = initialPrompt.replaceAll(Key,value);
					
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Dynamic value : "+value);
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Key Formed:" +Key);
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Initial Prompt:" +initialPrompt);
				}
			}else{
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Dynamic Value List is Null");
			}
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Initial Prompt After Dynamic Value Insertion:" +initialPrompt);
			
			if(count!=null && !AppConstant.EMPTY_STRING.equals(count) && !AppConstant.NA.equalsIgnoreCase(count)){
				intCount = Integer.parseInt(count);
				String[] optionGroup = initialPrompt.split(AppConstant.SEPERATOR_PIPE);
				initialPrompt = AppConstant.EMPTY_STRING;
				for(int i = 0 ;i<intCount;i++){
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Option Waves :"+ optionGroup);
					initialPrompt= initialPrompt+optionGroup[i]+AppConstant._Star;
				}
				
			}else{
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Count is not given so all waves are returned");
			}
		} catch (Exception e) {
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR,"Exception in forming Dynamic Wave :" +e);
			StackTrace.PrintException(e);
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
