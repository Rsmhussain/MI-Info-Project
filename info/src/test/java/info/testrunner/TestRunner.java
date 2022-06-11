

package info.testrunner;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import cucumber.api.Scenario;
import info.base.Mailing;

	//@RunWith(Cucumber.class)
	//@Test
	@CucumberOptions
	(
			tags= "@LoginNew or @SavedCustomReports",
			plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", 
					"timeline:test-output-thread"},
			features= {"src\\test\\resources\\Features"},
			glue= {"info.stepdefinition","info.hooks"},
			dryRun=false,
			monochrome=true
	)
	
	public class TestRunner extends AbstractTestNGCucumberTests 
	{		
			
		
	}
			
	
	
	
	
	
	
	
	
	
	
	
	
		


