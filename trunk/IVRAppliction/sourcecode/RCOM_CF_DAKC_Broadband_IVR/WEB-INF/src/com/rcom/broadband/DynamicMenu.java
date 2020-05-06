package com.rcom.broadband;

import java.util.ArrayList;
import java.util.List;

import com.avaya.sce.runtimecommon.ITraceInfo;


public class DynamicMenu {
	
	public static String playPrompt(List<String> dynamicValue, String initialPrompt,String count, String menuID, ITraceInfo trace){
			String value = Constants.EMPTY,Key = Constants.EMPTY;
			int intCount=Constants.ZERO;
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Initial Prompt Generation :: "+menuID);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Prompt from Property File :" +initialPrompt);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Count Value :" +count);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"dynamic Value List :" +dynamicValue);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"dynamic Value List Length:" +dynamicValue.size());
			
			try {/** Replacing the dynamic Value **/
				if(dynamicValue!=null){
					for(int i=0; i<dynamicValue.size();i++){
						value = dynamicValue.get(i);
						if(value.contains(Constants.currency)){
							value = value.replaceAll(Constants.currency, Constants.EMPTY);
							
							SayItSmart objSayItSmart = new SayItSmart();
							value=objSayItSmart.playCurrency(trace, value);
						}
						if(value.contains(Constants.time)){
							value = value.replaceAll(Constants.time, Constants.EMPTY);
							
							SayItSmartTime objSayItSmartTime = new SayItSmartTime();
							value=objSayItSmartTime.playTime(trace, value);
						}
						Key = Constants.OPEN_BRACE+i+Constants.CLOSE_BRACE;
						initialPrompt = initialPrompt.replace(Key,value);
					}
					trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Initial Prompt After Dynamic Value Insertion :" +initialPrompt);
				}
				/** Reconstructing the prompt based on the Count **/		
				if(count!=null && !Constants.EMPTY.equals(count) && !Constants.NA.equalsIgnoreCase(count)){
					intCount = Integer.parseInt(count);
					String[] optionGroup = initialPrompt.split(Constants.PIPE_SEPERATOR);
					initialPrompt = Constants.EMPTY;
					for(int i = 0 ;i<intCount;i++){
						trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Option Waves :"+ optionGroup[i]);
						initialPrompt= initialPrompt+optionGroup[i]+Constants.STAR;
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
	
	public static String playPromptTest(List<String> dynamicValue, String initialPrompt,String count, String menuID){
		String value = Constants.EMPTY,Key = Constants.EMPTY;
		int intCount=Constants.ZERO;
		System.out.println("Initial Prompt Generation :: "+menuID);
		System.out.println("Prompt from Property File :" +initialPrompt);
		System.out.println("Count Value :" +count);
		System.out.println("dynamic Value List :" +dynamicValue);
		System.out.println("dynamic Value List Length:" +dynamicValue.size());
		
		try {/** Replacing the dynamic Value **/
			if(dynamicValue!=null){
				for(int i=0; i<dynamicValue.size();i++){
					value = dynamicValue.get(i);
					Key = Constants.OPEN_BRACE+i+Constants.CLOSE_BRACE;
					initialPrompt = initialPrompt.replace(Key,value);
				}
				System.out.println("Initial Prompt After Dynamic Value Insertion :" +initialPrompt);
			}
			/** Reconstructing the prompt based on the Count **/		
			if(count!=null && !Constants.EMPTY.equals(count) && !Constants.NA.equalsIgnoreCase(count)){
				intCount = Integer.parseInt(count);
				String[] optionGroup = initialPrompt.split(Constants.PIPE_SEPERATOR);
				initialPrompt = Constants.EMPTY;
				for(int i = 0 ;i<intCount;i++){
					System.out.println("Option Waves :"+ optionGroup[i]);
					initialPrompt= initialPrompt+optionGroup[i]+Constants.STAR;
				}
				
			}else{
				System.out.println("Count is not given so all waves are returned");
			}
			
		} catch (Exception e) {
			System.out.println("Exception in forming Dynamic Wave :" +e);
			StackTrace.PrintException(e);
		}
		return initialPrompt;
	}
	
	public static void main(String[] args)
	{
		ArrayList<String> arrLang = new ArrayList<String>();
		arrLang.add("HotDeal1");
		
		String intitalPrompt = "1043.wav*{0}";
		
		System.out.println(intitalPrompt);
		
		System.out.println(playPromptTest(arrLang, intitalPrompt, null, "DAKC_MN_0001"));
	}
	}

