package tomcat.monitor;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import org.apache.log4j.Logger;


/*
 * @Author
 * Ajay Mishra
 */
@SuppressWarnings("serial")
public class ControlPanel extends JFrame {
	 static Calendar cal = Calendar.getInstance();
	 static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	JLabel background=new JLabel(new ImageIcon("C:\\MonitoringResource\\East.png"));
	private JLabel label;
	//private JButton button;
	JButton button1 = new JButton();

	//
	
	static Logger log = Logger.getLogger(ControlPanel.class.getName());

public int running; // program will not run until this is 1



public ControlPanel() {
setLayout(new FlowLayout());

label = new JLabel("Not Running");

Border border = LineBorder.createGrayLineBorder();
button1.setText("Start");
button1.setForeground(Color.BLACK);
button1.setHorizontalTextPosition(JLabel.RIGHT);
button1.setVerticalTextPosition(JLabel.TOP);
button1.setBorder(border);
JPanel addPanel = new JPanel();
addPanel.setToolTipText("Auther AJ");
addPanel.add(button1);
addPanel.add(label);
/**Add Components**/

this.add(addPanel);

event f = new event();
button1.addActionListener(f);





label.setForeground(Color.RED);

label.setFont(new Font("Serif", Font.BOLD, 13));
label.setLocation(100, 120);
add(background);
background.setLayout(new FlowLayout());
}






public class event implements ActionListener {
 @Override
    public void actionPerformed(ActionEvent f) {
	 if(f.getActionCommand()=="Start"){
		
		 
		// button.setLocation(0, 2);
		try {
		new SchedulerMain("Start");
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		
		log.error("EXecption in Contol class while Running Schedular"+"\r\n");
		e.printStackTrace();
	}
		label.setForeground(Color.red);
		 label.setText("Now Its Running!!, To Stop the Task click close button at the Top");
		
		 button1.setText("Stop");
	 }
	 else if  (f.getActionCommand()=="Stop"){
	 label.setText("Click cross button at the TOP,Process Still Running!");
		 
	 }
        
}
 
 
}




public static void main(String[] args) throws InterruptedException, AWTException {
	
	try{
 final ControlPanel gui = new ControlPanel();
//BackgroundImageJFrame j = new BackgroundImageJFrame();

gui.setResizable(true);
gui.setResizable(false);
gui.setSize(420, 230);
gui.setVisible(true);
gui.setResizable(false);
gui.setTitle("SMonitoring");

gui.addWindowListener(new java.awt.event.WindowAdapter() {
    @Override
    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
        if (JOptionPane.showConfirmDialog(gui,"Are you sure to close this window?closing this notify admin", "Really Closing?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
        	System.out.println("ajay");
        	
        	String mailBody="<html><body><i><b>"+"Dear Team, Please login to Mumbai 89 Server with Administrator  and check for the running application  "+""+"|"+""+"</i></b></body></html>";
        	SendMail.mail(mailBody, dateFormat.format(cal.getTime())+"A user has just closed the Monitoring Application");
        	log.error("application has been terminated deliberately");
        	gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
        	
        	
           
        }
        else{
        	
        	gui.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        }
              
    }
});
//gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	catch (Exception e) {
		
		log.error("error in Controlpannel.java"+e.getMessage());
		System.exit(0);
		// TODO: handle exception
	}
}

}
