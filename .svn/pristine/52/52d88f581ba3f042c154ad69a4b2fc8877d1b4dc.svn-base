package tomcat.monitor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

public class GetTotalsession {
	
	String HUB="";
	static Logger log = Logger.getLogger(GetTotalsession.class.getName());
	
	//static String  a= "";
	 StringBuilder  EastCount;
	 int totalSessionperip=0;
	 
	 Calendar cal = Calendar.getInstance();
	 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   

	
	String x="";
	   GetTotalsession()   {
		   
		   try{
		   
		   StringBuilder EastCount=new StringBuilder();  
		   String IP=Readprop.Proper("Ip");//Reading  IP from Loder.properties
		   
		   String ListOfIpseperatedbycommas=Readprop.Proper(IP);//Getting List of Application 
		   
		   
		   for (String ListofIP: ListOfIpseperatedbycommas.split(",")){
		         System.out.println("ListOfIP"+ListofIP);
		      
	
		List<String> Getlist=ListOfApplication.applicationList();
		
		
		for (String Applist : Getlist) {
		
		TomcatSessionMangement gettotalsession= new TomcatSessionMangement();
		String Username=Readprop.Proper("TomcatUserName");
		String Pass=Readprop.Proper("TomcatPassword");
		
		String Port=Readprop.Proper("Port");
		int session=gettotalsession.GetSessions(Username, Pass, ListofIP, Port, Applist);
		
		EastCount.append("<html><body><TABLE BORDER=2 CELLSPACING=2 CELLPADDING=2 width=600 style='table-layout:fixed'><col width=90> <col width=90> <col width=90> <col width=40><TR><TD BGCOLOR=#06F78F>"+"DateTime"+"<TD BGCOLOR=#06F78F>"+"I.P"+"<TD BGCOLOR=#06F78F>"+"Application Name"+"<TD BGCOLOR=#06F78F>"+"Session"+"</TD>	</TD></TD></TD></TR></TABLE></body></html>");
		
				
		if(ListofIP.contains("132")){
			
			HUB="NORTH";
			
			
			totalSessionperip=totalSessionperip+session;
			
			
		}
		
						else if(ListofIP.contains("184")){
			HUB="WEST";
		}
								else if(ListofIP.contains("172")){
									
		HUB="EAST";
		totalSessionperip=totalSessionperip+session;
		 
		
		
		EastCount.append("<html><body><TABLE BORDER=2 CELLSPACING=2 CELLPADDING=2 width=600 style='table-layout:fixed'><col width=90> <col width=90> <col width=90> <col width=40><TR><TD BGCOLOR=#CEF6F5>"+dateFormat.format(cal.getTime())+"<TD BGCOLOR=#CEF6F5>"+ListofIP+"<TD BGCOLOR=#CEF6F5>"+Applist+"<TD BGCOLOR=#CEF6F5>"+session+"</TD>	</TD></TD></TD></TR></TABLE></body></html>");
		
		
			
		}
											else if(ListofIP.contains("156")){
			HUB="SOUTH";
}
		  
	    
	}
		
		EastCount.append("<html><body><table BORDER=4 CELLSPACING=4 CELLPADDING=4 width=600 style='table-layout:fixed'><col width=80> <col width=90> <col width=41><tr><td BGCOLOR=#CEF6F5><b>"+"Total Sessions at </b>"+ListofIP+" are <b>"+totalSessionperip+"</b></td></tr></table></body></html>");
				
		totalSessionperip=0; //resetting Total Session counter
		Getlist.clear();
	 }
	  
		     
		   String mailBody="<html><body><i><b>"+"Dear Team, Please find Below Tomcat  Sessions For "+HUB+"</i></b></body></html>";
		   
		   
		// int x=  totalSessionperip;
		   
		  SendMail.mail(mailBody+"\r\n\r\n"+EastCount, "TOMCAT SESSION REPORT| "+HUB);
		  log.info("Dear Team, Please find Below Sessions for "+HUB+"\r\n"+EastCount+ "Session Report "+HUB);
			
		   
		   }
		   catch (Exception e) {
			   
			   log.error("Error in GetTotalSession.java "+e.getMessage());
			// TODO: handle exception
		}
	}
		   
		  
		   
	   
	  

}
