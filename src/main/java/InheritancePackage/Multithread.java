
package InheritancePackage;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;
/**
 *
 * @author Muhammad Faheem
 */
public class Multithread implements Runnable{
    String message;
    String toEmail;
    String subject;
    Multithread(String toEmail,String subject,String message){
        this.message = message;
        this.subject = subject;
        this.toEmail = toEmail;
    }
public void run(){
    sendEmail(toEmail,subject,message);
}

    public static void sendEmail(String toEmail,String subject,String  message){
        String username="ICS4u0.WF@gmail.com";
        String password="compsci2019";

        Properties props= System.getProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put( "mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props,new Authenticator(){
        @Override
        protected PasswordAuthentication getPasswordAuthentication(){
           return new PasswordAuthentication(username,password);
        }
        
        });  
        Message messages = prepareMessage(session,username,toEmail,subject,message);
        try {
            Transport.send(messages);
        } catch (Exception ex) {
            Logger.getLogger(Multithread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
        private static Message prepareMessage(Session session,String username,String toEmail,String subject,String message){
        try {
            Message messages = new MimeMessage(session);
            messages.setFrom(new InternetAddress(username));
            messages.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            messages.setSubject(subject);
            messages.setContent(message, "text/plain");
            return messages;

        } catch (Exception ex) {
            Logger.getLogger(Multithread.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        }
        

   }




    

