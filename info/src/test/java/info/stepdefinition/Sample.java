package info.stepdefinition;

import org.openqa.selenium.WebDriver;

import info.base.Reusableclass;
import info.pojo.User_POJO;
import io.cucumber.java.en.Given;

public class Sample extends Reusableclass
{
	Sample sap;
	
	@Given("tools qa pratice page")
	public void tools_qa_pratice_page() throws Throwable 
	
	{
		sap=new Sample();
		System.out.println("Driver Status : "+driver);
		System.out.println(driver instanceof WebDriver);
		browserLaunch();
		launchUrl("https://www.toolsqa.com/");
		
	}

}
