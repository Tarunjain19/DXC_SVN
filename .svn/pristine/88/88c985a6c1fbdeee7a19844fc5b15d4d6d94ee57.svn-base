package com.rcom.energy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.avaya.sce.runtimecommon.ITraceInfo;


public class DynamicMenu {
	
	public static String playPrompt(String[] dynamicValue, String initialPrompt,String count, String menuID, ITraceInfo trace){
			List<String> dynamicValueList = new ArrayList<>(Arrays.asList(dynamicValue));
			String value = AppConstants.EMPTY,Key = AppConstants.EMPTY;
			int intCount=AppConstants.Zero;
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Initial Prompt Generation :: "+menuID);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Prompt from Property File :" +initialPrompt);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Count Value :" +count);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"dynamic Value List Length:" +dynamicValueList.size());
			
			try {/** Replacing the dynamic Value **/
				if(dynamicValueList!=null){
					for(int i=0; i<dynamicValueList.size();i++){
						value = dynamicValueList.get(i);
						if(value.contains(AppConstants.currency)){
							value = value.replaceAll(AppConstants.currency, AppConstants.EMPTY_STRING);
							
							SayItSmart objSayItSmart = new SayItSmart();
							value=objSayItSmart.playCurrency(trace, value);
						}
						if(value.contains(AppConstants.time)){
							value = value.replaceAll(AppConstants.time, AppConstants.EMPTY_STRING);
							
							SayItSmartTime objSayItSmartTime = new SayItSmartTime();
							value=objSayItSmartTime.playTime(trace, value);
						}
						Key = AppConstants.OPEN_BRACE+i+AppConstants.CLOSE_BRACE;
						initialPrompt = initialPrompt.replace(Key,value);
					}
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Initial Prompt After Dynamic Value Insertion :" +initialPrompt);
				}
				/** Reconstructing the prompt based on the Count **/		
				if(count!=null && !AppConstants.EMPTY.equals(count) && !AppConstants.NA.equalsIgnoreCase(count)){
					intCount = Integer.parseInt(count);
					String[] optionGroup = initialPrompt.split(AppConstants.PIPE_SEPERATOR);
					initialPrompt = AppConstants.EMPTY;
					for(int i = 0 ;i<intCount;i++){
						trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Option Waves :"+ optionGroup);
						initialPrompt= initialPrompt+optionGroup[i]+AppConstants._Star;
					}
					
				}else{
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Count is not given so all waves are returned");
				}
				
			} catch (Exception e) {
				trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR,"Exception in forming Dynamic Wave :" +e);
				StackTrace.PrintException(e);
			}
			return initialPrompt;
		}
	}

