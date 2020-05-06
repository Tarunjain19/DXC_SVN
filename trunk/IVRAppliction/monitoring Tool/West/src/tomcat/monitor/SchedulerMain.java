package tomcat.monitor;



import java.util.Timer;

import org.apache.log4j.Logger;

public class SchedulerMain {
	 static Logger log = Logger.getLogger(SchedulerMain.class.getName());
	 SchedulerMain(String Action) throws InterruptedException {
		
		 	Timer time = new Timer(); // Instantiate Timer Object
			ScheduledTask st = new ScheduledTask();
			Every30Sec schedule= new Every30Sec();
			
			
			// Instantiate SheduledTask class
		 if(Action.equals("Start")){
			 
			String DashBoard= Readprop.Proper("DashBordTimer");//Defualt 3600000
			String StatusTimer= Readprop.Proper("StatusTimer");//Default 180000
			
			int DValue=Integer.parseInt(DashBoard);//parsing Sting to Integer value
			int Svalue=Integer.parseInt(StatusTimer);//parsing Sting to Integer value
			time.schedule(st, 0, DValue);
			time.schedule(schedule,0, Svalue);
		
		 }
		 
		 else{
			 
			 
			
			st.cancel();
			time.cancel();
			time.purge();
			 
			 
			
			 
		 }
		 
        
		

	}
	 
	
}