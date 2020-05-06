package tomcat.monitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import sun.misc.BASE64Encoder;

import com.sun.jmx.snmp.daemon.CommunicationException;
public class TomcatSessionMangement {
	
	int totalsession;
		
	static Logger log = Logger.getLogger(TomcatSessionMangement.class.getName());
	 Calendar cal = Calendar.getInstance();
	 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	int  GetSessions( String TomcatUsername, String TomcatPass,String IP,String Port,String ApplicationName)   {
		
		
		
		 URL url;
		 BASE64Encoder e;
		 BufferedReader in = null;
		 InputStream content = null;
		 HttpURLConnection connection = null;

	try {
		 
		
		
		//System.out.println("value of falg in try"+flag);
		String SourceUrl="http://"+IP+":"+Port+"/"+"manager/text/sessions?path=/"+ApplicationName;
		System.out.println("Source_URL::"+SourceUrl);
		url = new URL(SourceUrl);
		e = new BASE64Encoder();
		//String encoding = e.encode("admin:admin".getBytes());
		String encoding = e.encode((TomcatUsername+":"+TomcatPass).getBytes("UTF-8"));
		connection = (HttpURLConnection)url.openConnection();
		 		connection.setRequestMethod("GET");
		connection.setDoOutput(true);
		
		//connection.setRequestProperty("Authorization", "Basic" + encoding);
		connection.setRequestProperty("Authorization", String.format("Basic %s", encoding));
		content = connection.getInputStream();
		 in = new BufferedReader(new InputStreamReader(content));
		//System.out.println(SourceUrl);
	

Pattern patt = Pattern.compile("\\d+ sessions");
String line;

int sum=0;
System.out.println("Tomcat response: ");
while ((line = in.readLine()) != null) {
	
	

	 Matcher m = patt.matcher(line);
	 while (m.find()) {
           int start = m.start(0);
           int end = m.end(0);
           String SessionsWtParse=line.substring(start, end);
           int sumofsession=Integer.parseInt(SessionsWtParse.replaceAll("[\\D]", ""));
           sum=sum+sumofsession;
           totalsession=sum;
           
	 }
}




} 
	
	//10.172.87.81,10.172.87.82,10.172.87.83,10.172.87.84,10.172.87.85,10.172.87.86,10.172.87.87,10.172.87.88
catch (ConnectException e2) {
	
	 log.info("Dear Team, Tomcat is Down AT "+IP+" Please Login to System and Check Catalina Logs");
	
	 		if(IP.contains("172")&&ApplicationName.contains("PREPAID")){
		
		
		
		 String mailBody="<html><body><i><b>"+"Dear Team, Tomcat is Down AT "+IP+" Please Login to System and Check Catalina Logs"+"</i></b></body></html>";
		   
		   
		
			   
			  SendMail.mail(mailBody+"\r\n\r\n",dateFormat.format(cal.getTime())+ " TOMCAT DOWN AT  | "+IP+"|EAST");
			 
		
		
		
		
	}
	
	

	  
 
}

catch (CommunicationException ex) {
	
	log.info("Dear Team, Tomcat is Down AT "+IP+" Please Login to System and Check Catalina Logs");
	
		if(IP.contains("172")&&ApplicationName.contains("PREPAID")){



 String mailBody="<html><body><i><b>"+"Dear Team, Tomcat is Down AT "+IP+" Please Login to System and Check Catalina Logs"+"</i></b></body></html>";
   
   

	   
 SendMail.mail(mailBody+"\r\n\r\n", dateFormat.format(cal.getTime())+" TOMCAT DOWN AT  | "+IP+"|EAST|");
	 

	
	
		}
	
	
}

catch ( Exception exc) {
	
	log.info("Dear Team, Tomcat is Down AT "+IP+" Please Login to System and Check Catalina Logs");
	
		if(IP.contains("172")&&ApplicationName.contains("PREPAID")){



 String mailBody="<html><body><i><b>"+"Dear Team, Tomcat is Down AT "+IP+" Please Login to System and Check Catalina Logs"+"</i></b></body></html>";
   
   

	   
 SendMail.mail(mailBody+"\r\n\r\n", dateFormat.format(cal.getTime())+" TOMCAT DOWN AT  | "+IP+"|EAST|");
	 
		}
	
	//e.printStackTrace();
  }

finally{
			
 // System.out.println("value of flag ="+flag);
	
	//System.out.println("executing finally ");
if(in!=null){
	
	try {
		in.close();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
}

if(content!=null){
	try {
		content.close();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
}
if(connection!=null){
	connection.disconnect();
}

	
}
//System.err.println(z);
return totalsession;


    }
	
	 

	
}
