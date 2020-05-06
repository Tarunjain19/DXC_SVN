package tomcat.monitor;



import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;



public class Readprop{
	static Logger log = Logger.getLogger(Readprop.class.getName());

	 public static String Proper(String key) {
		 
			
		 String Details=null;
		 
		
		 
		try{

			 if(key==null){
				 log.error("Key value passed to Property File  is NULL");
				 
							 
			 }
			
			Properties prop = new Properties();
			
			
			FileInputStream fr=new FileInputStream("C:\\MonitoringResource\\West.prop");
			prop.load(fr);
			Details=prop.getProperty(key);
			
			//System.out.println(Details);
			
			
		
		  
		//String DBNAME=prop.getProperty("DBNAME");
		
			}
			catch (Exception e) {
				log.error("PLEASE CHECK LODER.PROP FILE AT C:\\loder.prop");
				//e.printStackTrace();
				
			}
		return Details;
		
	}
	


	   }
   
   

