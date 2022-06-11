package info.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;


import info.base.Mailing;
import info.base.Reusableclass;

public class Hooks extends Reusableclass
{

	public static WebDriver driver;
	
	@Before("@Browser")
	public void browserLogin()
	{
	WebDriverManager.chromedriver().setup();

	driver = new ChromeDriver();
	driver.get("https://angiejones.tech/inheriting-webdriver/");
	}
	
	//Taking Screenshot Attach to Report
	@After(order=1)
	public void screenShot(Scenario scenario) throws Exception
	{
		
		try
		{
			
	    if (scenario.isFailed()) 
	    { 
		
		// Take a screenshot...
	     // final byte[] screenshotn = attachScreenShot();
	      // embed it in the report.
	    //  scenario.embed(screenshot, "image/png"); 
	      scenario.attach(takeScreenShot(), "image/png", scenario.getName());
	      //scenario.attach(screenshotn, "image/png", "image"); 
		
	      System.out.println("Screenshot Attached"+scenario.getName());
	    }
		}
	    catch (WebDriverException wde) 
	    {
            System.err.println(wde.getMessage());
        } catch (ClassCastException cce) 
		{
            cce.printStackTrace();
        }
    }

	/*@AfterSuite   // Sending Mail*/
	@After(order=2)
	public static void SendingMail() throws AddressException, IOException, MessagingException
	{
	
		Runtime r=Runtime.getRuntime();  	  
		r.addShutdownHook(new Thread()
		{  
		public void run()
		{  
			Mailing sm = new Mailing();
			try 
			{
				sm.mail();
				System.out.println("Report has been sent"); 
			}
			catch (IOException | MessagingException e)
			{
				e.printStackTrace();
			}
			
		    }  
		}
		
		); 
		
		try{Thread.sleep(5000);}catch (Exception e) 
		{
			System.out.println(e);
		}  
		
		}
	
	
	
}
