package tomcat.monitor;



import java.util.Date;
import java.util.TimerTask;

import org.apache.log4j.Logger;

/**
 * 
 * @author AJ
 */
// Create a class extends with TimerTask
public class ScheduledTask extends TimerTask {
	// p = new Process();
	static Logger log = Logger.getLogger(ScheduledTask.class.getName());
	Date now; // to display current time
	// GetTotalsession total= new GetTotalsession();
	
	

	
	
	// Add your task here
	public void run( ) {
		
		
		
		
		
		 log.info(",HUB\t\t"+",IP"+",\t\t\t"+"ApplicationName"+",\t\t"+"TOTALSESSION\r\n");
		 
		
		new GetTotalsession();
		 
		// System.out.println("AJ##"+y);
	//	 new GetTotalsession();
		
		
	}
	
	
	@Override
	public boolean cancel() {
		
		
		System.out.println("Stopping task");
		// TODO Auto-generated method stub
		return super.cancel();
	}
	
}

