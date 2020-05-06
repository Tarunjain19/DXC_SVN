package com.servion.util;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;

public class GetCircle {
	
	
	public static String DipCircle(int OrgDnis,SCESession mySession){
		
		ITraceInfo trace = mySession.getTraceOutput();
	//	GetCircle =
		
		 trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, " In DNIS file DNIS value :"+OrgDnis);
		 
		 String dnis_MH=AppProperties.GetInstance(AppConstant.DNIS_CONFIG).getIVRProp(AppConstant.DefaultLanguage_MH);
         String dnis_MU= AppProperties.GetInstance(AppConstant.DNIS_CONFIG).getIVRProp(AppConstant.DefaultLanguage_MU);
         String dnis_DL= AppProperties.GetInstance(AppConstant.DNIS_CONFIG).getIVRProp(AppConstant.DefaultLanguage_DL);
         String dnis_PU= AppProperties.GetInstance(AppConstant.DNIS_CONFIG).getIVRProp(AppConstant.DefaultLanguage_PU);
         String dnis_PJ= AppProperties.GetInstance(AppConstant.DNIS_CONFIG).getIVRProp(AppConstant.DefaultLanguage_PJ);
         String dnis_HR= AppProperties.GetInstance(AppConstant.DNIS_CONFIG).getIVRProp(AppConstant.DefaultLanguage_HR);
         String dnis_HP= AppProperties.GetInstance(AppConstant.DNIS_CONFIG).getIVRProp(AppConstant.DefaultLanguage_HP);
         String dnis_JK= AppProperties.GetInstance(AppConstant.DNIS_CONFIG).getIVRProp(AppConstant.DefaultLanguage_JK);
         String dnis_AP= AppProperties.GetInstance(AppConstant.DNIS_CONFIG).getIVRProp(AppConstant.DefaultLanguage_AP);
         String dnis_KT= AppProperties.GetInstance(AppConstant.DNIS_CONFIG).getIVRProp(AppConstant.DefaultLanguage_KT);
         String dnis_KL= AppProperties.GetInstance(AppConstant.DNIS_CONFIG).getIVRProp(AppConstant.DefaultLanguage_KL);
         String dnis_TN= AppProperties.GetInstance(AppConstant.DNIS_CONFIG).getIVRProp(AppConstant.DefaultLanguage_TN);
         String dnis_GJ= AppProperties.GetInstance(AppConstant.DNIS_CONFIG).getIVRProp(AppConstant.DefaultLanguage_GJ);
         String dnis_MP= AppProperties.GetInstance(AppConstant.DNIS_CONFIG).getIVRProp(AppConstant.DefaultLanguage_MP);
         String dnis_OR= AppProperties.GetInstance(AppConstant.DNIS_CONFIG).getIVRProp(AppConstant.DefaultLanguage_UPE);
         String dnis_UPE= AppProperties.GetInstance(AppConstant.DNIS_CONFIG).getIVRProp(AppConstant.DefaultLanguage_PU);
         String dnis_UPW= AppProperties.GetInstance(AppConstant.DNIS_CONFIG).getIVRProp(AppConstant.DefaultLanguage_UPW);
         String dnis_WB= AppProperties.GetInstance(AppConstant.DNIS_CONFIG).getIVRProp(AppConstant.DefaultLanguage_WB);
         String dnis_BH= AppProperties.GetInstance(AppConstant.DNIS_CONFIG).getIVRProp(AppConstant.DefaultLanguage_BH);
         String dnis_RJ= AppProperties.GetInstance(AppConstant.DNIS_CONFIG).getIVRProp(AppConstant.DefaultLanguage_RJ);
         String dnis_NA= AppProperties.GetInstance(AppConstant.DNIS_CONFIG).getIVRProp(AppConstant.DefaultLanguage_NA);
         String dnis_KO= AppProperties.GetInstance(AppConstant.DNIS_CONFIG).getIVRProp(AppConstant.DefaultLanguage_KO);
         String dnis_AS= AppProperties.GetInstance(AppConstant.DNIS_CONFIG).getIVRProp(AppConstant.DefaultLanguage_AS);
         String dnis_CG= AppProperties.GetInstance(AppConstant.DNIS_CONFIG).getIVRProp(AppConstant.DefaultLanguage_CG);
         String dnis_JD= AppProperties.GetInstance(AppConstant.DNIS_CONFIG).getIVRProp(AppConstant.DefaultLanguage_JD);
         String dnis_NE= AppProperties.GetInstance(AppConstant.DNIS_CONFIG).getIVRProp(AppConstant.DefaultLanguage_NE);
         
         
         
         
         String DNIS_Return = "";
         
         //System.out.println("dnis is "+dnis_MH);
         
         trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, " Before If condition :");
         trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, " dnis_MU :"+dnis_MU);
        
         if(dnis_MH.indexOf(OrgDnis+";")!=-1)
         {
        
        // System.out.println(  " Yes it is present :"+dnis_MH.indexOf(OrgDnis+";"));
        	 trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Circle :"+dnis_MH.indexOf(OrgDnis+";"));
        // System.out.println(  " Yes it is MH :"+);
         DNIS_Return="MH";
         }
         else if(dnis_MU.indexOf(OrgDnis+";")!=-1)
         {
              // System.out.println(  " Yes it is present :"+dnis_MU.indexOf(OrgDnis+";"));
              // System.out.println(  " Yes it is MUM :"+dnis_MU.indexOf(OrgDnis+";"));
        	  trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Circle :"+dnis_MU.indexOf(OrgDnis+";"));
               DNIS_Return="MU";
               
         }       
       
         else if(dnis_PJ.indexOf(OrgDnis+";")!=-1)
         {
             //  System.out.println(  " Yes it is present :"+dnis_PJ.indexOf(OrgDnis+";"));
               trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Circle :"+dnis_PJ.indexOf(OrgDnis+";"));
              // System.out.println(  " Yes it is MUM :"+dnis_MU.indexOf(OrgDnis+";"));
               DNIS_Return="PJ";
         }
         
         else if(dnis_DL.indexOf(OrgDnis+";")!=-1)
         {
             //  System.out.println(  " Yes it is present :"+dnis_PJ.indexOf(OrgDnis+";"));
               trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Circle :"+dnis_DL.indexOf(OrgDnis+";"));
              // System.out.println(  " Yes it is MUM :"+dnis_MU.indexOf(OrgDnis+";"));
               DNIS_Return="DL";
         }
         
         
         else if(dnis_HR.indexOf(OrgDnis+";")!=-1)
         {
               //System.out.println(  " Yes it is present :"+dnis_HR.indexOf(OrgDnis+";"));
               trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Circle :"+dnis_HR.indexOf(OrgDnis+";"));
               
              // System.out.println(  " Yes it is MUM :"+dnis_MU.indexOf(OrgDnis+";"));
               DNIS_Return="HR";
         }
         
         else if(dnis_HP.indexOf(OrgDnis+";")!=-1)
         {
               //system.out.println(  " Yes it is present :"+dnis_HP.indexOf(OrgDnis+";"));
               trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Circle :"+dnis_HP.indexOf(OrgDnis+";"));
              // //system.out.println(  " Yes it is MUM :"+dnis_MU.indexOf(OrgDnis+";"));
               DNIS_Return="HP";
         }
         
         else if(dnis_JK.indexOf(OrgDnis+";")!=-1)
         {
               //system.out.println(  " Yes it is present :"+dnis_JK.indexOf(OrgDnis+";"));
               trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Circle :"+dnis_JK.indexOf(OrgDnis+";"));
              // //system.out.println(  " Yes it is MUM :"+dnis_MU.indexOf(OrgDnis+";"));
               DNIS_Return="JK";
         }
         
         else if(dnis_AP.indexOf(OrgDnis+";")!=-1)
         {
        	 
        	 trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Circle :"+dnis_AP.indexOf(OrgDnis+";"));
               //system.out.println(  " Yes it is present :"+dnis_AP.indexOf(OrgDnis+";"));
              // //system.out.println(  " Yes it is MUM :"+dnis_MU.indexOf(OrgDnis+";"));
               DNIS_Return="AP";
         }
         
         else if(dnis_KT.indexOf(OrgDnis+";")!=-1)
         {
        	 trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Circle :"+dnis_KT.indexOf(OrgDnis+";"));
               //system.out.println(  " Yes it is present :"+dnis_KT.indexOf(OrgDnis+";"));
              // //system.out.println(  " Yes it is MUM :"+dnis_MU.indexOf(OrgDnis+";"));
               DNIS_Return="KT";
         }
         
         else if(dnis_KL.indexOf(OrgDnis+";")!=-1)
        	 
         {
               //system.out.println(  " Yes it is present :"+dnis_KL.indexOf(OrgDnis+";"));
               trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Circle :"+dnis_KL.indexOf(OrgDnis+";"));
              // //system.out.println(  " Yes it is MUM :"+dnis_MU.indexOf(OrgDnis+";"));
               DNIS_Return="KL";
         }
         
         else if(dnis_TN.indexOf(OrgDnis+";")!=-1)
         {
               //system.out.println(  " Yes it is present :"+dnis_TN.indexOf(OrgDnis+";"));
               trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Circle :"+dnis_TN.indexOf(OrgDnis+";"));
              // //system.out.println(  " Yes it is MUM :"+dnis_MU.indexOf(OrgDnis+";"));
               DNIS_Return="TN";
         }
         
         else if(dnis_GJ.indexOf(OrgDnis+";")!=-1)
         {
               //system.out.println(  " Yes it is present :"+dnis_GJ.indexOf(OrgDnis+";"));
               trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Circle :"+dnis_GJ.indexOf(OrgDnis+";"));
              // //system.out.println(  " Yes it is MUM :"+dnis_MU.indexOf(OrgDnis+";"));
               DNIS_Return="GJ";
         }
         
         else if(dnis_MP.indexOf(OrgDnis+";")!=-1)
         {
               //system.out.println(  " Yes it is present :"+dnis_MP.indexOf(OrgDnis+";"));
               trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Circle :"+dnis_MP.indexOf(OrgDnis+";"));
              // //system.out.println(  " Yes it is MUM :"+dnis_MU.indexOf(OrgDnis+";"));
               DNIS_Return="MP";
         }
         
         else if(dnis_OR.indexOf(OrgDnis+";")!=-1)
         {
               //system.out.println(  " Yes it is present :"+dnis_OR.indexOf(OrgDnis+";"));
               trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Circle :"+dnis_OR.indexOf(OrgDnis+";"));
              // //system.out.println(  " Yes it is MUM :"+dnis_MU.indexOf(OrgDnis+";"));
               DNIS_Return="OR";
         }
         
         else if(dnis_UPE.indexOf(OrgDnis+";")!=-1)
         {
               //system.out.println(  " Yes it is present :"+dnis_UPE.indexOf(OrgDnis+";"));
               trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Circle :"+dnis_UPE.indexOf(OrgDnis+";"));
              // //system.out.println(  " Yes it is MUM :"+dnis_MU.indexOf(OrgDnis+";"));
               DNIS_Return="UPE";
         }
         
         else if(dnis_UPW.indexOf(OrgDnis+";")!=-1)
         {
               //system.out.println(  " Yes it is present :"+dnis_UPW.indexOf(OrgDnis+";"));
               
               trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Circle :"+dnis_UPW.indexOf(OrgDnis+";"));
              // //system.out.println(  " Yes it is MUM :"+dnis_MU.indexOf(OrgDnis+";"));
               DNIS_Return="UPW";
         }
         
        
         
         else if(dnis_WB.indexOf(OrgDnis+";")!=-1)
         {
               //system.out.println(  " Yes it is present :"+dnis_WB.indexOf(OrgDnis+";"));
              // //system.out.println(  " Yes it is MUM :"+dnis_MU.indexOf(OrgDnis+";"));
               DNIS_Return="WB";
         }
         
       
         else if(dnis_BH.indexOf(OrgDnis+";")!=-1)
         {
               //system.out.println(  " Yes it is present :"+dnis_BH.indexOf(OrgDnis+";"));
               trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Circle :"+dnis_BH.indexOf(OrgDnis+";"));
              // //system.out.println(  " Yes it is MUM :"+dnis_MU.indexOf(OrgDnis+";"));
               DNIS_Return="BH";
         }
         
         else if(dnis_RJ.indexOf(OrgDnis+";")!=-1)
         {
               //system.out.println(  " Yes it is present :"+dnis_RJ.indexOf(OrgDnis+";"));
               trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Circle :"+dnis_RJ.indexOf(OrgDnis+";"));
              // //system.out.println(  " Yes it is MUM :"+dnis_MU.indexOf(OrgDnis+";"));
               DNIS_Return="RJ";
         }
         
         else if(dnis_NA.indexOf(OrgDnis+";")!=-1)
         {
               //system.out.println(  " Yes it is present :"+dnis_NA.indexOf(OrgDnis+";"));
               trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Circle :"+dnis_NA.indexOf(OrgDnis+";"));
              // //system.out.println(  " Yes it is MUM :"+dnis_MU.indexOf(OrgDnis+";"));
               DNIS_Return="NA";
         }
         
         else if(dnis_KO.indexOf(OrgDnis+";")!=-1)
         {
               //system.out.println(  " Yes it is present :"+dnis_KO.indexOf(OrgDnis+";"));
               trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Circle :"+dnis_KO.indexOf(OrgDnis+";"));
              // //system.out.println(  " Yes it is MUM :"+dnis_MU.indexOf(OrgDnis+";"));
               DNIS_Return="KO";
         }
         
         else if(dnis_AS.indexOf(OrgDnis+";")!=-1)
         {
               //system.out.println(  " Yes it is present :"+dnis_AS.indexOf(OrgDnis+";"));
               trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Circle :"+dnis_AS.indexOf(OrgDnis+";"));
              // //system.out.println(  " Yes it is MUM :"+dnis_MU.indexOf(OrgDnis+";"));
               DNIS_Return="AS";
         }
         
         else if(dnis_CG.indexOf(OrgDnis+";")!=-1)
         {
               //system.out.println(  " Yes it is present :"+dnis_CG.indexOf(OrgDnis+";"));
              // //system.out.println(  " Yes it is MUM :"+dnis_MU.indexOf(OrgDnis+";"));
               DNIS_Return="CG";
         }
         
         else if(dnis_JD.indexOf(OrgDnis+";")!=-1)
         {
               //system.out.println(  " Yes it is present :"+dnis_JD.indexOf(OrgDnis+";"));
              // //system.out.println(  " Yes it is MUM :"+dnis_MU.indexOf(OrgDnis+";"));
               DNIS_Return="JD";
         }
         
         else if(dnis_NE.indexOf(OrgDnis+";")!=-1)
         {
               //system.out.println(  " Yes it is present :"+dnis_NE.indexOf(OrgDnis+";"));
               trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Circle :"+dnis_NE.indexOf(OrgDnis+";"));
              // //system.out.println(  " Yes it is MUM :"+dnis_MU.indexOf(OrgDnis+";"));
               DNIS_Return="NE";
         }
         
         
       
         
         
         
         else
         {
        	 trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "NO MAtch Found ");
              //sys //system.out.println(  "Not present");
               
               DNIS_Return="NIL";
         }
         
         trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, " DNIS_Return :"+DNIS_Return);
		return DNIS_Return;
		
	}

}
