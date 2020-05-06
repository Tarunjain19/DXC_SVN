package com.dnd.util;


import com.avaya.sce.runtimecommon.ITraceInfo;
import com.dnd.util.AppConstant;

public class DynamicMenu {
	
	public static String playPrompt(String[] dynamicValueList, String initialPrompt,String count, String menuID, ITraceInfo trace){
			
			String value = AppConstant.EMPTY_STRING,Key = AppConstant.EMPTY_STRING;
			int intCount=AppConstant.Zero;
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Initial Prompt Generation :: "+menuID);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Prompt from Property File :" +initialPrompt);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Count Value :" +count);
						
			try {/** Replacing the dynamic Value **/
				if(dynamicValueList!=null){
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"dynamic Value List :" +dynamicValueList.toString());
					for(int i=0; i<=dynamicValueList.length;i++){
						value = dynamicValueList[i];
						Key = AppConstant.OPEN_BRACE+i+AppConstant.CLOSE_BRACE;
						initialPrompt = initialPrompt.replaceAll(Key,value);
					}
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Initial Prompt After Dynamic Value Insertion :" +initialPrompt);
				}else{
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Dynamic Value List is Null");
				}
				
				/** Reconstructing the prompt based on the Count **/		
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
			return initialPrompt;
		}
	}

