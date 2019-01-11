package comm;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailNotify {
	public void sendEmail(Object email) throws AddressException, MessagingException{
		String mail=email.toString();
		String title="Notification Of Booking";
		String mess="The coustmer has been booked you.You have to attend that coustomer timely";
	  Mailer.send("lavisabharwal43@gmail.com","wahegurug31",mail,title,mess);
}
	public void sendPasswordResetEmail(Sahayak s,String pass) throws AddressException, MessagingException{
		String email=s.getEmail();
		String mail=email.toString();
		String title="Password Alert";
		String mess="Password Retreived as per your request. Your Password is :"+pass;
	  Mailer.send("lavisabharwal43@gmail.com","wahegurug31",mail,title,mess);
	}
}
class Mailer{  
    public static void send(String from,String password,String to,String sub,String msg) throws AddressException, javax.mail.MessagingException, MessagingException{  
          //Get properties object    
          Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "587");   
          //get Session   
          Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,password);  
           }    
          });    
          MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
           message.setSubject(sub);    
           message.setText(msg);    
           //send message  
           Transport.send(message);    
           System.out.println("message sent successfully");    
    }        
    }