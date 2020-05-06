package tomcat.monitor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

public class CheckStatus30Sec {
	
	String HUB="";
	static Logger log = Logger.getLogger(GetTotalsession.class.getName());
	
	//static String  a= "";
	 StringBuilder  EastCount;
	 int totalSessionperipeast=0;
	 
	 Calendar cal = Calendar.getInstance();
	 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 String TS=Readprop.Proper("THRESHOLD_Start_point");//configurable start point Threashold
		String ES=Readprop.Proper("THRESHOLD_End_point");// End point Threashold
		
		int ITS=Integer.parseInt(TS);
		int IES=Integer.parseInt(ES);
	   

	
	String x="";
	CheckStatus30Sec()   {
		
		try{
		   StringBuilder EastCount=new StringBuilder();  
		   String IP=Readprop.Proper("Ip");//Reading  IP from Loder.properties
		   
		   String ListOfIpseperatedbycommas=Readprop.Proper(IP);//Getting List of Application 
		   
		   
		   for (String ListofIP: ListOfIpseperatedbycommas.split(",")){
		         System.out.println("ListOfIP"+ListofIP);
		      
	
		List<String> Getlist=ListOfApplication.applicationList();
		
		
		for (String Applist : Getlist) {
			
			log.info("Getting application list "+Applist);
		
		TomcatSessionMangement gettotalsession= new TomcatSessionMangement();
		String Username=Readprop.Proper("TomcatUserName");
		String Pass=Readprop.Proper("TomcatPassword");
		
		String Port=Readprop.Proper("Port");
		int session=gettotalsession.GetSessions(Username, Pass, ListofIP, Port, Applist);
		
				
		if(ListofIP.contains("132")){
			
			HUB="NORTH";
			totalSessionperipeast=totalSessionperipeast+session;
			EastCount.append("<html><body><TABLE BORDER=4 CELLSPACING=2 CELLPADDING=2 width=600 style='table-layout:fixed'><col width=80> <col width=90> <col width=80> <col width=41><TR><TD BGCOLOR=#CEF6F5>"+dateFormat.format(cal.getTime())+"<TD BGCOLOR=#CEF6F5>"+ListofIP+"<TD BGCOLOR=#CEF6F5>"+Applist+"<TD BGCOLOR=#CEF6F5>"+session+"</TD>	</TD></TD></TD></TR></TABLE></body></html>");
			
			
		}
		
						else if(ListofIP.contains("184")){
							
			HUB="WEST";
			totalSessionperipeast=totalSessionperipeast+session;
			EastCount.append("<html><body><TABLE BORDER=4 CELLSPACING=2 CELLPADDING=2 width=600 style='table-layout:fixed'><col width=80> <col width=90> <col width=80> <col width=41><TR><TD BGCOLOR=#CEF6F5>"+dateFormat.format(cal.getTime())+"<TD BGCOLOR=#CEF6F5>"+ListofIP+"<TD BGCOLOR=#CEF6F5>"+Applist+"<TD BGCOLOR=#CEF6F5>"+session+"</TD>	</TD></TD></TD></TR></TABLE></body></html>");
		}
								else if(ListofIP.contains("172")){
									
		HUB="EAST";
		
		log.info("Session value for IP + "+ListofIP+"="+session+" For App"+Applist+"\r\n");
		totalSessionperipeast=totalSessionperipeast+session;
		log.info("TotalSession for IP"+ListofIP+"="+totalSessionperipeast);
		EastCount.append("<html><body><TABLE BORDER=4 CELLSPACING=2 CELLPADDING=2 width=600 style='table-layout:fixed'><col width=80> <col width=90> <col width=80> <col width=41><TR><TD BGCOLOR=#CEF6F5>"+dateFormat.format(cal.getTime())+"<TD BGCOLOR=#CEF6F5>"+ListofIP+"<TD BGCOLOR=#CEF6F5>"+Applist+"<TD BGCOLOR=#CEF6F5>"+session+"</TD>	</TD></TD></TD></TR></TABLE></body></html>");
		
		
			
		}
											else if(ListofIP.contains("156")){
												
			HUB="SOUTH";
			totalSessionperipeast=totalSessionperipeast+session;
			EastCount.append("<html><body><TABLE BORDER=4 CELLSPACING=2 CELLPADDING=2 width=600 style='table-layout:fixed'><col width=80> <col width=90> <col width=80> <col width=41><TR><TD BGCOLOR=#CEF6F5>"+dateFormat.format(cal.getTime())+"<TD BGCOLOR=#CEF6F5>"+ListofIP+"<TD BGCOLOR=#CEF6F5>"+Applist+"<TD BGCOLOR=#CEF6F5>"+session+"</TD>	</TD></TD></TD></TR></TABLE></body></html>");
}
	  
	    
	}
		
		
		log.info("THRESHOLD_Start_point "+ITS);
		log.info("THRESHOLD_End_point "+IES);
		
		
		
		if(totalSessionperipeast>=ITS&&totalSessionperipeast<=IES){
			
			log.info("threashold limit condition met");
			String mailBody="<html><body><i><b>"+"Dear Team, Sessions are increasing on  "+ListofIP+"|"+HUB+"</i></b></body></html>";
			
			SendMail.mail(mailBody+"\r\n\r\n"+totalSessionperipeast, dateFormat.format(cal.getTime())+" THRESHOLD LIMIT EXCEEDING FOR | "+HUB+"|"+ListofIP);
			
		}
		
		
		
		else{
			
		log.info("Total Sessions are  below/above threashold limit of "+ITS+" for I.P |"+ListofIP+" are "+totalSessionperipeast);
		}
		
		//EastCount.append("<html><body><table BORDER=4 CELLSPACING=4 CELLPADDING=4 width=600 style='table-layout:fixed'><col width=80> <col width=90> <col width=41><tr><td BGCOLOR=#CEF6F5><b>"+"Total Sessions at </b>"+ListofIP+" are <b>"+totalSessionperip+"</b></td></tr></table></body></html>");
			log.info("Resetting counter to 0 now ");	
		totalSessionperipeast=0; //resetting Total Session counter
		
		
		Getlist.clear();
		   }
		   
		   
		}
		// log.info("Dear Team, Please find Below Sessions for "+HUB+"\r\n"+EastCount+ "Session Report "+HUB);
			
		   
	
		   catch (Exception e) {
			   
			   log.error("error in checkStatus30Sec.java  "+e.getMessage());
			// TODO: handle exception
		}
		   
	}
		   
		  
		   
	   
	  

}
