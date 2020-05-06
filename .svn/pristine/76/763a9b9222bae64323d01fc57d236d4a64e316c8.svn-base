package com.rcom.rdtv;

import java.util.List;

import com.avaya.sce.runtimecommon.ITraceInfo;


public class DynamicMenu {
	
	public static String playPrompt(List<String> dynamicValue, String initialPrompt,String count, String menuID, ITraceInfo trace){
			String value = Constants.EMPTY,Key = Constants.EMPTY;
			int intCount=Constants.zero;
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Initial Prompt Generation :: "+menuID);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Prompt from Property File :" +initialPrompt);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Count Value :" +count);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"dynamic Value List Length:" +dynamicValue.size());
			
			try {/** Replacing the dynamic Value **/
				if(dynamicValue!=null){
					for(int i=0; i<dynamicValue.size();i++){
						value = dynamicValue.get(i);
						if(value.contains(Constants.currency)){
							value = value.replaceAll(Constants.currency, Constants.EMPTY_STRING);
							
							SayItSmart objSayItSmart = new SayItSmart();
							value=objSayItSmart.playCurrency(trace, value);
						}
						if(value.contains(Constants.time)){
							value = value.replaceAll(Constants.time, Constants.EMPTY_STRING);
							
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
						trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Option Waves :"+ optionGroup);
						initialPrompt= initialPrompt+optionGroup[i]+Constants._Star;
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
	
	public static void main(String[] args) {
		String initialPrompt = "ENG_1003.wav*ENG.wav*ENG_1003a.wav*ENG_1130.wav|HIN_1003.wav*HIN.wav*HIN_1003a.wav*HIN_1131.wav|LANG_2_1003.wav*{2}*LANG_2_1003a.wav*LANG_2_1132.wav|LANG_3_1003.wav*{3}*LANG_3_1003a.wav*LANG_3_1133.wav|LANG_4_1003.wav*{4}*LANG_4_1134.wav|LANG_5_1003.wav*{5}*LANG_5_1135.wav|LANG_6_1003.wav*{6}*LANG_7_1003a.wav*LANG_6_1136.wav|LANG_7_1003.wav*{7}*LANG_7_1003a.wav*LANG_7_1137.wav";
		String count = "2";
		if(count!=null && !Constants.EMPTY.equals(count) && !Constants.NA.equalsIgnoreCase(count)){
			int intCount = Integer.parseInt(count);
			String[] optionGroup = initialPrompt.split(Constants.PIPE_SEPERATOR);
			initialPrompt = Constants.EMPTY;
			for(int i = 0 ;i<intCount;i++){
				System.out.println("Option Waves :"+ optionGroup);
				initialPrompt= initialPrompt+optionGroup[i]+Constants._Star;
				System.out.println(initialPrompt);
			}
			
		}else{
			System.out.println("Count is not given so all waves are returned");
		}
	}
	}

