package info.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mailing extends Reusableclass
{
	static String key,data,from,to,password;
	static String[] AllToAdress;
	static String host = "smtp.gmail.com";
	
	public void GetData() throws IOException
	{
		
		File prop = new File("Input/credentials.properties");
		FileInputStream input =new FileInputStream(prop);
		Properties props = new Properties();
		props.load(input);
	    
		Enumeration value = props.keys();
		
		while(value.hasMoreElements()){
			key = (String) value.nextElement();
			data = props.getProperty(key);
			
			if(key.equals("to")){
				to=data;
			}
			if(key.equals("from")){
				from=data;
			}
			if(key.equals("password")){
				password=data;
			}
			
		}
		
		AllToAdress = to.split(",");
		
	}
	
public void mail() throws IOException, AddressException, MessagingException
{

	GetData();
	
	browserLaunch();
	toMaximize();
	
	launchUrl("C:\\Users\\Sheik Mohammed\\Desktop\\info\\SparkReport\\Spark.html");
	
	//Taking Overall Report Screenshot
	//takeScreenShot();
	ScreenShot(driver,"OverallReport");
	
	
	try{
	//System properties	
	Properties SysmProp = System.getProperties();
	SysmProp.put("mail.smtp.starttls.enable", "true");
	SysmProp.put("mail.smtp.host", host);
	SysmProp.put("mail.smtp.ssl.trust", host);
	SysmProp.put("mail.smtp.user", from);
	SysmProp.put("mail.smtp.password", password);
	SysmProp.put("mail.smtp.port", "587");
	SysmProp.put("mail.smtp.auth", "true");
	SysmProp.put("mail.smtp.starttls.required", "true");
	SysmProp.put("mail.smtp.ssl.protocols", "TLSv1.2");
	SysmProp.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	
	
	//Creating session and mime message object	
	Session session = Session.getInstance(SysmProp);
	MimeMessage message = new MimeMessage(session) ;
	message.setFrom(new InternetAddress(from)); 
		
	//Form Internet address array
	InternetAddress[] ia = new InternetAddress[AllToAdress.length];
	
	for(int i=0; i<AllToAdress.length;i++)
	{
		ia[i] = new InternetAddress(AllToAdress[i]);		
	}
	
	for(int j=0;j<AllToAdress.length;j++)
	{
		message.addRecipient(Message.RecipientType.TO, ia[j]);		
	}
	
	Date dt = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
    String strDate= formatter.format(dt);  
	
    //Set subject and body and adding attachments.
	message.setSubject("Execution report on "+strDate);	
	
	MimeMultipart multipart = new MimeMultipart("related");
	
	//Section 1 ( Report Link )
	BodyPart messageBodyPart = new MimeBodyPart();
	//messageBodyPart.setText("Test Report");
	message.setText("UTF-8","html");
	
	String htmlText = "<H6>Detailed Report : </H6> <a href='file:///C:/Users/Sheik%20Mohammed/Desktop/info/SparkReport/Spark.html#'>Click Here</a> <img src='cid:image'>";
	//String link ="file:///C:/Users/Sheik%20Mohammed/Desktop/info/SparkReport/Spark.html";
	//String htmlText = "<a href=\"file:///C:/Users/Sheik%20Mohammed/Desktop/info/SparkReport/Spark.html\">Visit Detailed Report</a>";
	/*String message1 = "<html>" +
			"<head><title>Report Mailing</title></head>" +
			"<body>" +
			"Click <a href=\"file:///C:/Users/Sheik%20Mohammed/Desktop/info/SparkReport/Spark.html\">here</a> to activate your free subscription." +
			"</body>" +
			"</html>";*/
	messageBodyPart.setContent(htmlText, "text/html");
	multipart.addBodyPart(messageBodyPart);
	
	//Section 2 ( Mail Message )
/*	messageBodyPart = new MimeBodyPart();
	messageBodyPart.setText("Hello, Good day! \n"
			+ "\n"
			+ "All scenarios have been executed. Please find the attached report of the execution.  \n"
			+ "\n"
			+ "Thanks,\n"
			+ "Sheik.R");
	multipart.addBodyPart(messageBodyPart);*/
	
	//Section 3 ( In line Image)
	messageBodyPart = new MimeBodyPart();
    DataSource source = new FileDataSource("C:\\Users\\Sheik Mohammed\\Desktop\\info\\Report\\OverallReport.png");
    messageBodyPart.setDataHandler(new DataHandler(source));
    messageBodyPart.setHeader("Content-ID", "<image>");
 	multipart.addBodyPart(messageBodyPart);
    
 	//Section 3 ( Download Report )
 	//File file2 = new File("C:\\Users\\Sheik Mohammed\\Desktop\\info\\SparkReport\\Spark.html");
 	
 	 File file = new File(System.getProperty("user.dir") + "\\PdfReport\\ExtentPdf.pdf");
     BodyPart messageBodyPart_2 = new MimeBodyPart();
     DataSource sources = new FileDataSource(file.getAbsolutePath());
     messageBodyPart_2.setDataHandler(new DataHandler(sources));
     messageBodyPart_2.setFileName("PDFReport" + strDate + ".PDF");
     multipart.addBodyPart(messageBodyPart_2);
 	
	 File file3 = new File(System.getProperty("user.dir") + "\\SparkReport\\Spark.html");
     BodyPart messageBodyPart_3 = new MimeBodyPart();
     DataSource sources3 = new FileDataSource(file.getAbsolutePath());
     messageBodyPart_3.setDataHandler(new DataHandler(sources));
     messageBodyPart_3.setFileName("Over All Report" + strDate + ".html");
     multipart.addBodyPart(messageBodyPart_3);
 	
 	
 	
 	
 /*	messageBodyPart = new MimeBodyPart();
	DataSource source1 = new FileDataSource(file2.getAbsolutePath());
    messageBodyPart.setDataHandler(new DataHandler(source1));
    messageBodyPart.setFileName("Report_"+strDate+".html");
    multipart.addBodyPart(messageBodyPart);*/
    
	message.setContent(multipart);
	
	//Transport.send(emailMessage);
	
	
	
	
	
	//MimeMultipart content = new MimeMultipart();
		
	
	
	/*Multipart multipart = new MimeMultipart();
	
		
	File file2 = new File("C:\\Users\\Sheik Mohammed\\Desktop\\info\\SparkReport\\Spark.html");
	
	//File file2 = new File("C:\\Users\\Sheik Mohammed\\Desktop\\info\\screenshot\\Report.png");
	
	messageBodyPart = new MimeBodyPart();
	DataSource source = new FileDataSource(file2.getAbsolutePath());
    messageBodyPart.setDataHandler(new DataHandler(source));
    //messageBodyPart.setFileName("Report_"+strDate+".html");
    multipart.addBodyPart(messageBodyPart);
    message.setContent(multipart);*/
	
    //Start transportation of message
	
	Transport trans = session.getTransport("smtp");
	trans.connect(host, from, password);
	trans.sendMessage(message, message.getAllRecipients());
	
	for(String address:AllToAdress)
	{
		System.out.println("Mail has been sent to "+address);		
	}
	
	trans.close();
	}catch(AddressException ae ){
		System.out.println("Address exception: "+ae);
	}catch(MessagingException me){
		System.out.println("Messaging exception: "+me);
	}catch(Exception e){
		System.out.println(e);
	}
	
}

}
