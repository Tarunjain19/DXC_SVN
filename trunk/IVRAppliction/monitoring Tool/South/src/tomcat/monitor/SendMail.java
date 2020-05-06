package tomcat.monitor;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import org.apache.log4j.Logger;
public class SendMail {
	
    public static void mail(String Body,String Subject) {
    	Logger log = Logger.getLogger(SendMail.class.getName());
    	
    	Readprop.Proper("MailServerIp");

        String host = Readprop.Proper("MailServerIp");
       // String to = "mishra44@avaya.com";
        //String to = "aepalmteam@avaya.com";
        String to=  Readprop.Proper("To");
        String from = Readprop.Proper("From");
        String subject = Subject;
        boolean sessionDebug = false;
        Properties props = System.getProperties();
        props.put("mail.host", host);
        props.put("mail.transport.protocol", "smtp");
        Session session = Session.getDefaultInstance(props, null);
        session.setDebug(sessionDebug);
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = { new InternetAddress(to) };
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setContent(Body,"text/html" );
            msg.setSentDate(new Date());
            msg.setHeader("X-Priority", "1");
            Transport.send(msg);
            log.info("MailSent for subject"+subject);
            
        } catch (MessagingException mex) {
        	
        	log.error("Exection in mail"+mex.getMessage());
            //mex.printStackTrace();
        }
    }
}