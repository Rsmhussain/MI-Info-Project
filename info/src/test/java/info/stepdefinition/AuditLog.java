package info.stepdefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import info.base.Reusableclass;
import info.pojo.AuditLog_POJO;
import info.pojo.AutoshiftNew_POJO;
import info.pojo.BranchScheduler_POJO;
import info.pojo.EmployeeAllocation_POJO;
import info.pojo.EmployeeScheduler_POJO;
import info.pojo.UpdateByDepartment_POJO;
import info.pojo.UpdateByIndividual_POJO;
import info.pojo.UpdateByBranch_POJO;
import info.pojo.UpdateBySection_POJO;

import info.utilities.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AuditLog extends Reusableclass
{
	UpdateByIndividual_POJO uip;
	UpdateByDepartment_POJO udp;
	UpdateByBranch_POJO ubp;
	UpdateBySection_POJO usp;
	AuditLog_POJO alp;
	
	//@Test(description="User On Aduit Log Page")
	@Given("User is on Audit Log Page")
	public void user_is_on_audit_log_page() 
	{
		uip = new UpdateByIndividual_POJO();
		udp = new UpdateByDepartment_POJO();
		ubp = new UpdateByBranch_POJO();
		usp = new UpdateBySection_POJO();
		alp = new AuditLog_POJO();
		
		// Explicit Wait for AdministrationMenu
		WebDriverWait wait1 = new WebDriverWait(driver, 100);
		wait1.until(ExpectedConditions.elementToBeClickable(alp.AdministrationMenu));
		mouseOver(alp.AdministrationMenu);
		
		// Explicit Wait for AuditLog Menu
		WebDriverWait wait2 = new WebDriverWait(driver, 100);
		wait2.until(ExpectedConditions.elementToBeClickable(alp.AuditLogMenu));
		toClick(alp.AuditLogMenu);
		
	}

	//@Test(description="User Verify the late scenario for update Individual")
	@When("User verifying the late scenario {string} and {int}")
	public void user_verifying_the_late_scenario_and(String SheetName, Integer RowNumber) throws InvalidFormatException, Throwable 
	{
	   	uip = new UpdateByIndividual_POJO();
		udp = new UpdateByDepartment_POJO();
		ubp = new UpdateByBranch_POJO();
		usp = new UpdateBySection_POJO();
		alp = new AuditLog_POJO();
		WebDriverWait wait = new WebDriverWait(driver, 100);
		
		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> ALData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx", SheetName);
		
		// Explicit Wait for From Date
		String FromDate = ALData.get(RowNumber).get("From Date");
		
		wait.until(ExpectedConditions.elementToBeClickable(alp.FromDate));
		Thread.sleep(500);
		actionssendkeysdelete(alp.FromDate);
		Thread.sleep(500);
		tofill(alp.FromDate, FromDate);
		totabkey();
		toenter();
		
		// Explicit Wait for Log Date
		String LogDate = ALData.get(RowNumber).get("Log Date");
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(alp.LogDate));
		Thread.sleep(500);
		actionssendkeysdelete(alp.LogDate);
		Thread.sleep(500);
		tofill(alp.LogDate, LogDate);
		toenter();
		
		// ========= Update By Individual - Late Scenario =========== //
		/*
		// Explicit Wait for WebPage Drop Down
		String Page = ALData.get(RowNumber).get("WebPage Name");
		
		//Click WebPage Button
		System.out.println("Excel Web Page Name: "+Page);
		wait.until(ExpectedConditions.elementToBeClickable(alp.WebPage));
		toClick(alp.WebPage);

		//=============== Select WebPage Value From Drop Down
	    
	    List WebPageDD = driver.findElements(By.xpath("//select[@id='gs_WebPageName']/option"));
	    System.out.println(WebPageDD.size());
	    Thread.sleep(2000);
	    
	    for (int i = 0; i <= WebPageDD.size(); i++) 
	    {
	    	//Thread.sleep(500);
	    	WebElement WebPageDDValue = driver.findElement(By.xpath("//input[@id='ui-multiselect-gs_WebPageName-option-"+i+"']"));
	    	String WebDDvalue=WebPageDDValue.getAttribute("value");
	    	String expectedVal = Page;
	    	Thread.sleep(500);
	    	System.out.println("Available Web Page List:"+WebDDvalue);
	    	
	    	if(WebDDvalue.equals(expectedVal))
	    	{
	    	Thread.sleep(500);
	    	
	    	//driver.findElement(By.xpath("//input[@id='ui-multiselect-gs_WebPageName-option-"+i+"' and @type='checkbox']")).click();
	    	driver.findElement(By.xpath("//input[@id='ui-multiselect-gs_WebPageName-option-"+i+"' and @type='checkbox']"));
	    	
	    	//String WDVvalue=WebPageDDValue.getAttribute("value");
	    	
	    	WebDriverWait wait1 = new WebDriverWait(driver, 10);
	    	//wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='ui-multiselect-gs_WebPageName-option-"+i+"']//span[contains(text(),'UPDATE BY INDIVIDUAL')]")));
	    	//WebElement WDV =driver.findElement(By.xpath("/html[1]/body[1]/div[8]/ul[1]/li[8]/label[1]/span[1]"));
	    	//WebElement WDV =driver.findElement(By.xpath("//label[@for='ui-multiselect-gs_WebPageName-option-"+i+"']//span[contains(text(),'UPDATE BY INDIVIDUAL')]"));
	    	WebElement WDV = driver.findElement(By.xpath("//input[@id='ui-multiselect-gs_WebPageName-option-"+i+"' and @type='checkbox']"));
	    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",WDV);
			Thread.sleep(500);
	    	
	    	//WebElement WDV =driver.findElement(By.xpath("/html/body/div[14]/ul/li[7]/label/span"));
	    	//WebElement WDV =driver.findElement(By.xpath("//label[contains(.,'UPDATE BY INDIVIDUAL')]"));
	    	//driver.findElement(By.xpath("//ul[@class='ui-multiselect-checkboxes ui-helper-reset']//following::span[contains(text(),'"+Page+"')]")).click(); // Working Xpath
	    	//WebElement WDV=driver.findElement(By.xpath("//ul[@class='ui-multiselect-checkboxes ui-helper-reset']//following::span[contains(text(),'"+Page+"')]"));
	    	clickjavascript(WDV);   	
	    	//WDV.sendKeys(Keys.ENTER);
	    	Actions action = new Actions(driver);
	    	WebElement element= driver.findElement(By.xpath("//label[@for='ui-multiselect-gs_WebPageName-option-"+i+"']//span[contains(text(),'UPDATE BY INDIVIDUAL')]"));
	    	action.moveToElement(element).click().perform();
	    	//mouseclick(WDV);
	    	//ul[@class='ui-multiselect-checkboxes ui-helper-reset']//following::span[contains(text(),'UPDATE BY INDIVIDUAL')]
	    	totabkey();
	    	break;
	    	//span[contains(text(),'UPDATE BY INDIVIDUAL')]//preceding::input[@id='ui-multiselect-gs_WebPageName-option-6' and @value='UPDATE BY INDIVIDUAL' and @type='checkbox' and @name='multiselect_gs_WebPageName']
	    	//WebElement WebUBI = driver.findElement(By.xpath("//span[contains(text(),'"+Page+"')]//preceding::input[@id='ui-multiselect-gs_WebPageName-option-"+i+"' and @value='"+Page+"' and @type='checkbox' and @name='multiselect_gs_WebPageName']"));
	    	//WebElement WebUBI = driver.findElement(By.xpath("//input[@id='ui-multiselect-gs_WebPageName-option-"+i+"']"));
	    	//WebElement WebUBI= driver.findElement(By.xpath("//label[contains(.,'"+Page+"')]"));
	    	//driver.findElement(By.xpath("//input[@value='UPDATE BY INDIVIDUAL']")).click();

	    	}
	    }*/
	    
	    //==================
	   /* 
    	//Transaction
    	String Transaction = ALData.get(RowNumber).get("Transaction");
       	System.out.println("Excel Transaction Name: "+Transaction);
       	
       	wait.until(ExpectedConditions.elementToBeClickable(alp.Transaction));
       	toClick(alp.Transaction);
       	
		//=============== Select Transaction Value From Drop Down
	    
	    List TransactionDD = driver.findElements(By.xpath("//select[@id='gs_TransactionType']/option"));
	    System.out.println(WebPageDD.size());
	    Thread.sleep(2000);
	    
	    for (int j = 0; j <= TransactionDD.size(); j++) 
	    {
	    	//Thread.sleep(500);
	    	WebElement TransactionDDValue = driver.findElement(By.xpath("//input[@id='ui-multiselect-gs_TransactionType-option-"+j+"']"));
	    	String TranDDvalue=TransactionDDValue.getAttribute("value");
	    	String expectedTranVal = Transaction;
	    	Thread.sleep(500);
	    	System.out.println("Available Transactions List:"+TranDDvalue);
	    	
	    	if(TranDDvalue.equals(expectedTranVal))
	    	{
	    	Thread.sleep(500);
	    	
	    	driver.findElement(By.xpath("//label/input[@value='"+Transaction+"']")).click(); // Working Xpath
	    	//driver.findElement(By.xpath("//input[@id='ui-multiselect-gs_WebPageName-option-"+i+"' and @type='checkbox']")).click();
	    	//driver.findElement(By.xpath("//label[contains(.,'UPDATE BY INDIVIDUAL')]")).click();
	    	//driver.findElement(By.xpath("//ul[@class='ui-multiselect-checkboxes ui-helper-reset']//following::span[contains(text(),'UPDATE')]")).click();
	    	//ul[@class='ui-multiselect-checkboxes ui-helper-reset']//following::span[contains(text(),'UPDATE BY INDIVIDUAL')]
	    	totabkey();
	    	break;
	    	
	    	}
	    }
	    */
	    //==================
       	
    	// Explicit Wait for Records
     	String Record = ALData.get(RowNumber).get("Record");
     		
     	wait.until(ExpectedConditions.elementToBeClickable(alp.Record));
     	Thread.sleep(500);
     	actionssendkeysdelete(alp.Record);
     	Thread.sleep(500);
     	tofill(alp.Record,Record);
     	toenter();
        
     	// Explicit Wait for Field Name
     	String FieldName = ALData.get(RowNumber).get("Field Name");
     		
     	wait.until(ExpectedConditions.elementToBeClickable(alp.FieldName));
     	Thread.sleep(500);
     	actionssendkeysdelete(alp.FieldName);
     	Thread.sleep(500);
     	tofill(alp.FieldName,FieldName);
     	toenter();
     	
     	// Explicit Wait for Old Value
     	String OldValue = ALData.get(RowNumber).get("Old Value");
     		
     	wait.until(ExpectedConditions.elementToBeClickable(alp.Oldvalue));
     	Thread.sleep(500);
     	actionssendkeysdelete(alp.Oldvalue);
     	Thread.sleep(500);
     	tofill(alp.Oldvalue,OldValue);
     	toenter();
     	
     	// Explicit Wait for New Value
     	String NewValue = ALData.get(RowNumber).get("New Value");
     		
     	wait.until(ExpectedConditions.elementToBeClickable(alp.Newvalue));
     	Thread.sleep(500);
     	actionssendkeysdelete(alp.Newvalue);
     	Thread.sleep(500);
     	tofill(alp.Newvalue,NewValue);
     	toenter();
     
     	/*// Explicit Wait for User Name
     	String Username = ALData.get(RowNumber).get("User Name");
     	System.out.println("Excel User Name :"+Username);
     	wait.until(ExpectedConditions.elementToBeClickable(alp.UserName));
     	clickjavascript(alp.UserName);
     	
     	//=============== Select User Name Value From Drop Down
	    
	    List UsernameDD = driver.findElements(By.xpath("//select[@id='gs_DisplayNameC']/option"));
	    System.out.println(UsernameDD.size());
	    Thread.sleep(2000);
	    
	    for (int k = 0; k <= UsernameDD.size(); k++) 
	    {
	    	//Thread.sleep(500);
	    	WebElement UsernameDDValue = driver.findElement(By.xpath("//input[@id='ui-multiselect-gs_DisplayNameC-option-"+k+"']"));
	    	String UsrDDvalue=UsernameDDValue.getAttribute("value");
	    	String expectedTranVal = "System";
	    	Thread.sleep(500);
	    	System.out.println("Available Transactions List:"+UsrDDvalue);
	    	
	    	if(UsrDDvalue.equals(expectedTranVal))
	    	{
	    	Thread.sleep(500);
	    	
	    	driver.findElement(By.xpath("//label/input[@value='"+Username+"']")).click(); // Working Xpath
	    	//driver.findElement(By.xpath("//input[@id='ui-multiselect-gs_WebPageName-option-"+i+"' and @type='checkbox']")).click();
	    	//driver.findElement(By.xpath("//label[contains(.,'UPDATE BY INDIVIDUAL')]")).click();
	    	//driver.findElement(By.xpath("//ul[@class='ui-multiselect-checkboxes ui-helper-reset']//following::span[contains(text(),'UPDATE')]")).click();
	    	//ul[@class='ui-multiselect-checkboxes ui-helper-reset']//following::span[contains(text(),'UPDATE BY INDIVIDUAL')]
	    	totabkey();
	    	break;
	    	
	    	}
	    }*/
	    
	    //==================
	    
     	//Assertion for Late - 
    	
    	String LateExp = "9:30";
		Thread.sleep(500);
				
		WebElement Late1 = driver.findElement(By.xpath("//*[@id='1']/td[9]"));
		wait.until(ExpectedConditions.elementToBeClickable(Late1));
		String LatenessAct1 = Late1.getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(LateExp, LatenessAct1);
		System.out.println("Latness for Row 1 : Expected: "+LateExp+" Actual: "+LatenessAct1);
		
		WebElement Late2 = driver.findElement(By.xpath("//*[@id='2']/td[9]"));
		wait.until(ExpectedConditions.elementToBeClickable(Late2));
		String LatenessAct2= Late2.getText();
		soft.assertEquals(LateExp, LatenessAct2);
		//highlightElements(Late);
				
		System.out.println("Latness for Row 2 : Expected: "+LateExp+" Actual: "+LatenessAct2);
	
		WebElement Late3 = driver.findElement(By.xpath("//*[@id='3']/td[9]"));
		wait.until(ExpectedConditions.elementToBeClickable(Late3));
		String LatenessAct3= Late3.getText();
		soft.assertEquals(LateExp, LatenessAct3);
		//highlightElements(Late);
				
		System.out.println("Latness for Row 3 : Expected: "+LateExp+" Actual: "+LatenessAct3);
		
		WebElement Late4 = driver.findElement(By.xpath("//*[@id='4']/td[9]"));
		wait.until(ExpectedConditions.elementToBeClickable(Late4));
		String LatenessAct4= Late4.getText();
		soft.assertEquals(LateExp, LatenessAct4);
		//highlightElements(Late);
				
		System.out.println("Latness for Row 4 : Expected: "+LateExp+" Actual: "+LatenessAct4);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",Late4);
		Thread.sleep(500);
		
		Thread.sleep(3000);
	}
	
	//@Test(description="User Verify the under scenario for update Individual")
	@When("User verifying the Under scenario {string} and {int}")
	public void user_verifying_the_under_scenario_and(String SheetName, Integer RowNumber) throws AWTException, InterruptedException, Throwable, IOException 
	{
		uip = new UpdateByIndividual_POJO();
		udp = new UpdateByDepartment_POJO();
		ubp = new UpdateByBranch_POJO();
		usp = new UpdateBySection_POJO();
		alp = new AuditLog_POJO();
		WebDriverWait wait = new WebDriverWait(driver, 100);
		
		// ========= Update By Individual - Under Scenario =========== //
		
		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> ALData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx", SheetName);
	
		// Explicit Wait for Records
     	String Record = ALData.get(RowNumber).get("Record");
     		
     	wait.until(ExpectedConditions.elementToBeClickable(alp.Record));
     	Thread.sleep(500);
     	actionssendkeysdelete(alp.Record);
     	Thread.sleep(500);
     	tofill(alp.Record,Record);
     	toenter();
		
		// Field Data Insert
		String FieldName = ALData.get(RowNumber).get("Field Name");
     			
		wait.until(ExpectedConditions.elementToBeClickable(alp.FieldName));
		Thread.sleep(500);
		actionssendkeysdelete(alp.FieldName);
		Thread.sleep(500);
		tofill(alp.FieldName, FieldName);
		toenter();
		
		// New Value Data Insert
     	String NewValue = ALData.get(RowNumber).get("New Value");
     		
     	wait.until(ExpectedConditions.elementToBeClickable(alp.Newvalue));
     	Thread.sleep(500);
     	actionssendkeysdelete(alp.Newvalue);
     	Thread.sleep(500);
     	tofill(alp.Newvalue,NewValue);
     	toenter();
		
		// Assertion for Under in New Value Field

		String UnderExp = "17:30";
		Thread.sleep(500);

		WebElement under1 = driver.findElement(By.xpath("//*[@id='1']/td[9]"));
		wait.until(ExpectedConditions.elementToBeClickable(under1));
		String UnderAct1 = under1.getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(UnderExp, UnderAct1);
		//highlightElements(under);
		System.out.println("Under for Row 1 : Expected: " + UnderExp + " Actual: " + UnderAct1);
		
		WebElement under2 = driver.findElement(By.xpath("//*[@id='2']/td[9]"));
		wait.until(ExpectedConditions.elementToBeClickable(under2));
		String UnderAct2 = under2.getText();
		soft.assertEquals(UnderExp, UnderAct2);
		System.out.println("Under for Row 2 : Expected: " + UnderExp + " Actual: " + UnderAct2);
	
		WebElement under3 = driver.findElement(By.xpath("//*[@id='3']/td[9]"));
		wait.until(ExpectedConditions.elementToBeClickable(under3));
		String UnderAct3 = under3.getText();
		soft.assertEquals(UnderExp, UnderAct3);
		System.out.println("Under for Row 3 : Expected: " + UnderExp + " Actual: " + UnderAct3);
		
		WebElement under4 = driver.findElement(By.xpath("//*[@id='4']/td[9]"));
		wait.until(ExpectedConditions.elementToBeClickable(under4));
		String UnderAct4 = under4.getText();
		soft.assertEquals(UnderExp, UnderAct4);
		System.out.println("Under for Row 4 : Expected: " + UnderExp + " Actual: " + UnderAct4);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",under4);
		Thread.sleep(500);
		
		Thread.sleep(3000);
		
	}
	
	//@Test(description="User Verify the OT scenario for update Individual")
	@When("User verifying the OT scenario {string} and {int}")
	public void user_verifying_the_ot_scenario_and(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException, Throwable 
	{
		uip = new UpdateByIndividual_POJO();
		udp = new UpdateByDepartment_POJO();
		ubp = new UpdateByBranch_POJO();
		usp = new UpdateBySection_POJO();
		alp = new AuditLog_POJO();
		WebDriverWait wait = new WebDriverWait(driver, 100);
		
		// ========= Update By Individual - OT Scenario =========== //
		
		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> ALData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx", SheetName);
	
		// Explicit Wait for Records
     	String Record = ALData.get(RowNumber).get("Record");
     		
     	wait.until(ExpectedConditions.elementToBeClickable(alp.Record));
     	Thread.sleep(500);
     	actionssendkeysdelete(alp.Record);
     	Thread.sleep(500);
     	tofill(alp.Record,Record);
     	toenter();
	
		// Field Data Insert
		String FieldName = ALData.get(RowNumber).get("Field Name");
     			
		wait.until(ExpectedConditions.elementToBeClickable(alp.FieldName));
		Thread.sleep(500);
		actionssendkeysdelete(alp.FieldName);
		Thread.sleep(500);
		tofill(alp.FieldName, FieldName);
		toenter();
		
		// New Value Data Insert
     	String NewValue = ALData.get(RowNumber).get("New Value");
     		
     	wait.until(ExpectedConditions.elementToBeClickable(alp.Newvalue));
     	Thread.sleep(500);
     	actionssendkeysdelete(alp.Newvalue);
     	Thread.sleep(500);
     	tofill(alp.Newvalue,NewValue);
     	toenter();
		
		// Assertion for Under in New Value Field

		String OTExp = "21:00";
		Thread.sleep(500);

		WebElement OT1 = driver.findElement(By.xpath("//tr[@id='1']/td[9]"));
		wait.until(ExpectedConditions.elementToBeClickable(OT1));
		String OTAct1 = OT1.getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(OTExp, OTAct1);
		System.out.println("OT for Individual : Expected: " + OTExp + " Actual: " + OTAct1);
	
		WebElement OT2 = driver.findElement(By.xpath("//tr[@id='2']/td[9]"));
		wait.until(ExpectedConditions.elementToBeClickable(OT2));
		String OTAct2 = OT2.getText();
		soft.assertEquals(OTExp, OTAct2);
		System.out.println("OT for Individual : Expected: " + OTExp + " Actual: " + OTAct2);
		
		WebElement OT3 = driver.findElement(By.xpath("//tr[@id='3']/td[9]"));
		wait.until(ExpectedConditions.elementToBeClickable(OT3));
		String OTAct3 = OT3.getText();
		soft.assertEquals(OTExp, OTAct3);
		System.out.println("OT for Individual : Expected: " + OTExp + " Actual: " + OTAct3);
		
		WebElement OT4 = driver.findElement(By.xpath("//tr[@id='4']/td[9]"));
		wait.until(ExpectedConditions.elementToBeClickable(OT4));
		String OTAct4 = OT4.getText();
		soft.assertEquals(OTExp, OTAct4);
		System.out.println("OT for Individual : Expected: " + OTExp + " Actual: " + OTAct4);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",OT4);
		Thread.sleep(500);
		
		Thread.sleep(3000);
		
	}
	
	@When("User verifying the Absent and Insufficient Scenario {string} and {int}")
	public void user_verifying_the_absent_and_insufficient_scenario_and(String SheetName, Integer RowNumber) throws InvalidFormatException, Throwable 
	{
		uip = new UpdateByIndividual_POJO();
		udp = new UpdateByDepartment_POJO();
		ubp = new UpdateByBranch_POJO();
		usp = new UpdateBySection_POJO();
		alp = new AuditLog_POJO();
		WebDriverWait wait = new WebDriverWait(driver, 100);
		
		// ========= Update By Individual - Absent & Insufficient Scenario =========== //
		
		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> ALData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx", SheetName);
	
		// Explicit Wait for Records
     	String Record = ALData.get(RowNumber).get("Record");
     		
     	wait.until(ExpectedConditions.elementToBeClickable(alp.Record));
     	Thread.sleep(500);
     	actionssendkeysdelete(alp.Record);
     	Thread.sleep(500);
     	tofill(alp.Record,Record);
     	toenter();
		
		// Field Data Insert
		String FieldName = ALData.get(RowNumber).get("Field Name");
     			
		wait.until(ExpectedConditions.elementToBeClickable(alp.FieldName));
		Thread.sleep(500);
		actionssendkeysdelete(alp.FieldName);
		Thread.sleep(500);
		tofill(alp.FieldName, FieldName);
		toenter();
		
		// New Value Data Insert
     	String NewValue = ALData.get(RowNumber).get("New Value");
     		
     	wait.until(ExpectedConditions.elementToBeClickable(alp.Newvalue));
     	Thread.sleep(500);
     	actionssendkeysdelete(alp.Newvalue);
     	Thread.sleep(500);
     	tofill(alp.Newvalue,NewValue);
     	toenter();
		
		// Assertion for Ansent in New Value Field

		String AbsentExp = "ABS :: ABSENT";
		Thread.sleep(500);

		WebElement Absent = driver.findElement(By.xpath("//tr[@id='1']/td[9]"));
		wait.until(ExpectedConditions.elementToBeClickable(Absent));

		String AbsentAct = Absent.getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(AbsentExp, AbsentAct);

		System.out.println("Absent & Insufficient : Expected: " + AbsentExp + " Actual: " + Absent.getText());
	    
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",Absent);
		Thread.sleep(500);
		
		Thread.sleep(3000);
	}
	

	// ======================== Update By Department ================================ //
	
	@When("User verifying the late scenario for update by department {string} and {int}")
	public void user_verifying_the_late_scenario_for_update_by_department_and(String SheetName, Integer RowNumber) throws Throwable, IOException 
	{
		uip = new UpdateByIndividual_POJO();
		udp = new UpdateByDepartment_POJO();
		ubp = new UpdateByBranch_POJO();
		usp = new UpdateBySection_POJO();
		alp = new AuditLog_POJO();
		WebDriverWait wait = new WebDriverWait(driver, 100);
		
		// ========= Update By Department - Late Scenario - 1 =========== //
		
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> ALData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx", SheetName);
		
		// Explicit Wait for WebPage Drop Down
		String Page = ALData.get(RowNumber).get("WebPage Name");
		String PerviousWebPage = ALData.get(RowNumber).get("PerviousWebPage");
		System.out.println("Excel Web Page Name: "+Page);
		
		//Webpage Button Click
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='gs_WebPageName']//following::button[@type='button']//span[contains(text(),'"+PerviousWebPage+"')]")));
		WebElement WebPageButton= driver.findElement(By.xpath("//select[@id='gs_WebPageName']//following::button[@type='button']//span[contains(text(),'"+PerviousWebPage+"')]"));
		toClick(WebPageButton);

		//Click No Button - Unselect
		WebElement UnSelectWebPageDDValue = driver.findElement(By.xpath("//span[contains(text(),'"+PerviousWebPage+"')]//preceding::input[@type='checkbox' and @name='multiselect_gs_WebPageName' and @value='"+PerviousWebPage+"']"));
		clickjavascript(UnSelectWebPageDDValue);
		
		//WebPage DroDown Click
		Thread.sleep(500);
		//driver.findElement(By.xpath("//ul[@class='ui-multiselect-checkboxes ui-helper-reset']//following::span[contains(text(),'UPDATE BY INDIVIDUAL')]")).click(); // Working Xpath
		//WebElement WebPageDDValue = driver.findElement(By.xpath("//span[contains(text(),'"+Page+"')]//preceding::input[@type='checkbox' and @name='multiselect_gs_WebPageName' and @value='"+Page+"']"));
		WebElement WebPageDDValue= driver.findElement(By.xpath("//label[contains(.,'"+Page+"')]")); // Working Xpath 
		Thread.sleep(500);
		clickjavascript(WebPageDDValue);
		if (WebPageDDValue.isSelected()) 
		{
			System.out.println(" *** Update By Department Is Selected *** " + WebPageDDValue.getText());
		}
		
	
		// Transaction
		String Transaction = ALData.get(RowNumber).get("Transaction");
		String PreviousTransaction = ALData.get(RowNumber).get("PreviousTransaction");
		System.out.println("Excel Transaction Name: " + Transaction);
		
		//Transaction Button Click
		wait.until(ExpectedConditions.elementToBeClickable(alp.Transaction));
		toClick(alp.Transaction);
		
		//Click No Button
		WebElement NoButtonTran = driver.findElement(By.xpath("//span[contains(text(),'"+PreviousTransaction+"')]//preceding::input[@type='checkbox' and @name='multiselect_gs_TransactionType' and @value='"+PreviousTransaction+"']"));
		clickjavascript(NoButtonTran);

		//Transaction DropDown Click
		Thread.sleep(500);
		WebElement TransactionDDValue = driver.findElement(By.xpath("//span[contains(text(),'"+Transaction+"')]//preceding::input[@type='checkbox' and @name='multiselect_gs_TransactionType' and @value='"+Transaction+"']"));
		//WebElement TransactionDDValue= driver.findElement(By.xpath("//label/input[@value='"+Transaction+"']")); //working Xpath
		Thread.sleep(500);
		clickjavascript(TransactionDDValue);
		
		if(TransactionDDValue.isSelected()) 
		{
			System.out.println(" *** Update Is Selected for Department *** " + TransactionDDValue.getText());
			
		}
		
		/*
		// Explicit Wait for Records
		String Record = ALData.get(RowNumber).get("Record");

		wait.until(ExpectedConditions.elementToBeClickable(alp.Record));
		Thread.sleep(2000);
		actionssendkeysdelete(alp.Record);
		Thread.sleep(500);
		tofill(alp.Record, Record);
		toenter();*/

		// Explicit Wait for Field Name
		String FieldName = ALData.get(RowNumber).get("Field Name");

		wait.until(ExpectedConditions.elementToBeClickable(alp.FieldName));
		Thread.sleep(500);
		actionssendkeysdelete(alp.FieldName);
		Thread.sleep(500);
		tofill(alp.FieldName, FieldName);
		toenter();

		// Explicit Wait for Old Value
		String OldValue = ALData.get(RowNumber).get("Old Value");

		wait.until(ExpectedConditions.elementToBeClickable(alp.Oldvalue));
		Thread.sleep(500);
		actionssendkeysdelete(alp.Oldvalue);
		Thread.sleep(500);
		tofill(alp.Oldvalue, OldValue);
		toenter();

		// Explicit Wait for New Value
		String NewValue = ALData.get(RowNumber).get("New Value");

		wait.until(ExpectedConditions.elementToBeClickable(alp.Newvalue));
		Thread.sleep(500);
		actionssendkeysdelete(alp.Newvalue);
		Thread.sleep(500);
		tofill(alp.Newvalue, NewValue);
		toenter();
		
		// Assertion for Late

		String LateExp = "9:30";
		Thread.sleep(500);

		WebElement Late = driver.findElement(By.xpath("//*[@id='1']/td[9]"));
		wait.until(ExpectedConditions.elementToBeClickable(Late));

		String LatenessAct = Late.getText();

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(LateExp, LatenessAct);

		System.out.println("Latness For Department : Expected: " + LateExp + " Actual: " + Late.getText());
		
	}

	@When("User verifying the under scenario for update by department {string} and {int}")
	public void user_verifying_the_under_scenario_for_update_by_department_and(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException, Throwable 
	{
		
		uip = new UpdateByIndividual_POJO();
		udp = new UpdateByDepartment_POJO();
		ubp = new UpdateByBranch_POJO();
		usp = new UpdateBySection_POJO();
		alp = new AuditLog_POJO();
		WebDriverWait wait = new WebDriverWait(driver, 100);
		
		// ========= Update By Department - Under Scenario - 2 =========== //
		
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> ALData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx",SheetName);
		
		// Explicit Wait for Field Name
		String FieldName = ALData.get(RowNumber).get("Field Name");

		wait.until(ExpectedConditions.elementToBeClickable(alp.FieldName));
		Thread.sleep(500);
		actionssendkeysdelete(alp.FieldName);
		Thread.sleep(500);
		tofill(alp.FieldName, FieldName);
		toenter();
		
		// Explicit Wait for New Value
		String NewValue = ALData.get(RowNumber).get("New Value");

		wait.until(ExpectedConditions.elementToBeClickable(alp.Newvalue));
		Thread.sleep(500);
		actionssendkeysdelete(alp.Newvalue);
		Thread.sleep(500);
		tofill(alp.Newvalue, NewValue);
		toenter();

		// Assertion for Under in New Value Field

		String UnderExp = "17:30";
		Thread.sleep(500);

		WebElement under = driver.findElement(By.xpath("//*[@id='1']/td[9]"));
		wait.until(ExpectedConditions.elementToBeClickable(under));

		String UnderAct = under.getText();
				
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(UnderExp, UnderAct);

		System.out.println("Under for Department : Expected: " + UnderExp + " Actual: " + under.getText());
					
	}
	
	@When("User verifying the OT scenario for update by department {string} and {int}")
	public void user_verifying_the_ot_scenario_for_update_by_department_and(String SheetName, Integer RowNumber) throws InvalidFormatException, Throwable 
	{
		uip = new UpdateByIndividual_POJO();
		udp = new UpdateByDepartment_POJO();
		ubp = new UpdateByBranch_POJO();
		usp = new UpdateBySection_POJO();
		alp = new AuditLog_POJO();
		WebDriverWait wait = new WebDriverWait(driver, 100);
		
		// ========= Update By Department - OT Scenario - 3 =========== //
		
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> ALData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx",SheetName);
		
		// Explicit Wait for Field Name
		String FieldName = ALData.get(RowNumber).get("Field Name");

		wait.until(ExpectedConditions.elementToBeClickable(alp.FieldName));
		Thread.sleep(500);
		actionssendkeysdelete(alp.FieldName);
		Thread.sleep(500);
		tofill(alp.FieldName, FieldName);
		toenter();
		
		// Explicit Wait for New Value
		String NewValue = ALData.get(RowNumber).get("New Value");

		wait.until(ExpectedConditions.elementToBeClickable(alp.Newvalue));
		Thread.sleep(500);
		actionssendkeysdelete(alp.Newvalue);
		Thread.sleep(500);
		tofill(alp.Newvalue, NewValue);
		toenter();

		// Assertion for OT in New Value Field

		String OTExp = "21:00";
		Thread.sleep(500);

		WebElement OT = driver.findElement(By.xpath("//*[@id='1']/td[9]"));
		wait.until(ExpectedConditions.elementToBeClickable(OT));

		String OTAct = OT.getText();

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(OTExp, OTAct);

		System.out.println("OT For Department : Expected: " + OTExp + " Actual: " + OT.getText());		
		
	}

	// ======================== Update By Branch ================================ //
	
	@When("User verifying the late scenario for update by branch {string} and {int}")
	public void user_verifying_the_late_scenario_for_update_by_branch_and(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException, Throwable 
	{
		uip = new UpdateByIndividual_POJO();
		udp = new UpdateByDepartment_POJO();
		ubp = new UpdateByBranch_POJO();
		usp = new UpdateBySection_POJO();
		alp = new AuditLog_POJO();
		WebDriverWait wait = new WebDriverWait(driver, 100);
		
		// ========= Update By Branch - Late Scenario - 1 =========== //
		
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> ALData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx", SheetName);
		
		// Explicit Wait for WebPage Drop Down
		String Page = ALData.get(RowNumber).get("WebPage Name");
		String PerviousWebPage = ALData.get(RowNumber).get("PerviousWebPage");
		System.out.println("Excel Web Page Name: "+Page);
		
		//WebPage Drop Down Button Click
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='gs_WebPageName']//following::button[@type='button']//span[contains(text(),'"+PerviousWebPage+"')]")));
		WebElement WebPageButton= driver.findElement(By.xpath("//select[@id='gs_WebPageName']//following::button[@type='button']//span[contains(text(),'"+PerviousWebPage+"')]"));
		toClick(WebPageButton);

		//Click Previous Button
		WebElement UnSelectWebPageDDValue = driver.findElement(By.xpath("//span[contains(text(),'"+PerviousWebPage+"')]//preceding::input[@type='checkbox' and @name='multiselect_gs_WebPageName' and @value='"+PerviousWebPage+"']"));
		clickjavascript(UnSelectWebPageDDValue);
		
		//WebPage Value Selection
		Thread.sleep(500);
		WebElement WebPageDDValue = driver.findElement(By.xpath("//span[contains(text(),'"+Page+"')]//preceding::input[@type='checkbox' and @name='multiselect_gs_WebPageName' and @value='"+Page+"']"));
		Thread.sleep(500);
		clickjavascript(WebPageDDValue);
		if (WebPageDDValue.isSelected()) 
		{
			System.out.println(" *** Update By Department Is Selected *** " + WebPageDDValue.getText());
		}
		
		

		// Transaction

		String Transaction = ALData.get(RowNumber).get("Transaction");
		String PreviousTransaction = ALData.get(RowNumber).get("PreviousTransaction");
		System.out.println("Excel Transaction Name: " + Transaction);
		
		//Transaction Button Click
		wait.until(ExpectedConditions.elementToBeClickable(alp.Transaction));
		toClick(alp.Transaction);

		//Click No Button
		WebElement NoButtonTran = driver.findElement(By.xpath("//span[contains(text(),'"+PreviousTransaction+"')]//preceding::input[@type='checkbox' and @name='multiselect_gs_TransactionType' and @value='"+PreviousTransaction+"']"));
		clickjavascript(NoButtonTran);

		//Transaction Dropdown Value Selection
		Thread.sleep(500);
		WebElement TransactionDDValue = driver.findElement(By.xpath("//span[contains(text(),'"+Transaction+"')]//preceding::input[@type='checkbox' and @name='multiselect_gs_TransactionType' and @value='"+Transaction+"']"));
		//WebElement TransactionDDValue= driver.findElement(By.xpath("//label/input[@value='"+Transaction+"']"));
		Thread.sleep(500);
		clickjavascript(TransactionDDValue);
		if(TransactionDDValue.isSelected()) 
		{
			System.out.println(" *** Update Is Selected for Department *** " + TransactionDDValue.getText());
		}
		
		
		/*// Explicit Wait for Records
		String Record = ALData.get(RowNumber).get("Record");

		wait.until(ExpectedConditions.elementToBeClickable(alp.Record));
		Thread.sleep(500);
		actionssendkeysdelete(alp.Record);
		Thread.sleep(500);
		tofill(alp.Record, Record);
		toenter();
		*/
		
		// Explicit Wait for Field Name
		String FieldName = ALData.get(RowNumber).get("Field Name");

		wait.until(ExpectedConditions.elementToBeClickable(alp.FieldName));
		Thread.sleep(500);
		actionssendkeysdelete(alp.FieldName);
		Thread.sleep(500);
		tofill(alp.FieldName, FieldName);
		toenter();

		// Explicit Wait for Old Value
		String OldValue = ALData.get(RowNumber).get("Old Value");

		wait.until(ExpectedConditions.elementToBeClickable(alp.Oldvalue));
		Thread.sleep(500);
		actionssendkeysdelete(alp.Oldvalue);
		Thread.sleep(500);
		tofill(alp.Oldvalue, OldValue);
		toenter();

		// Explicit Wait for New Value
		String NewValue = ALData.get(RowNumber).get("New Value");

		wait.until(ExpectedConditions.elementToBeClickable(alp.Newvalue));
		Thread.sleep(500);
		actionssendkeysdelete(alp.Newvalue);
		Thread.sleep(500);
		tofill(alp.Newvalue, NewValue);
		toenter();

		// Assertion for Late

		String LateExp = "9:30";
		Thread.sleep(500);

		WebElement Late = driver.findElement(By.xpath("//*[@id='1']/td[9]"));
		wait.until(ExpectedConditions.elementToBeClickable(Late));

		String LatenessAct = Late.getText();

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(LateExp, LatenessAct);

		System.out.println("Latness For Branch : Expected: " + LateExp + " Actual: " + Late.getText());
	
	}

	@When("User verifying the under scenario for update by branch {string} and {int}")
	public void user_verifying_the_under_scenario_for_update_by_branch_and(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException, Throwable
	{
		uip = new UpdateByIndividual_POJO();
		udp = new UpdateByDepartment_POJO();
		ubp = new UpdateByBranch_POJO();
		usp = new UpdateBySection_POJO();
		alp = new AuditLog_POJO();
		WebDriverWait wait = new WebDriverWait(driver, 100);
		
		// ========= Update By Branch - Under Scenario - 2 =========== //
		
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> ALData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx",SheetName);
		
		// Explicit Wait for Field Name
		String FieldName = ALData.get(RowNumber).get("Field Name");

		wait.until(ExpectedConditions.elementToBeClickable(alp.FieldName));
		Thread.sleep(500);
		actionssendkeysdelete(alp.FieldName);
		Thread.sleep(500);
		tofill(alp.FieldName, FieldName);
		toenter();
		
		// Explicit Wait for New Value
		String NewValue = ALData.get(RowNumber).get("New Value");

		wait.until(ExpectedConditions.elementToBeClickable(alp.Newvalue));
		Thread.sleep(500);
		actionssendkeysdelete(alp.Newvalue);
		Thread.sleep(500);
		tofill(alp.Newvalue, NewValue);
		toenter();

		// Assertion for Under in New Value Field

		String UnderExp = "17:30";
		Thread.sleep(500);

		WebElement under = driver.findElement(By.xpath("//*[@id='1']/td[9]"));
		wait.until(ExpectedConditions.elementToBeClickable(under));

		String UnderAct = under.getText();
				
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(UnderExp, UnderAct);

		System.out.println("Under for Branch : Expected: " + UnderExp + " Actual: " + under.getText());
		
	}

	@When("User verifying the OT scenario for update by branch {string} and {int}")
	public void user_verifying_the_ot_scenario_for_update_by_branch_and(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException, Throwable
	{
		uip = new UpdateByIndividual_POJO();
		udp = new UpdateByDepartment_POJO();
		ubp = new UpdateByBranch_POJO();
		usp = new UpdateBySection_POJO();
		alp = new AuditLog_POJO();
		WebDriverWait wait = new WebDriverWait(driver, 100);
		
		// ========= Update By Branch - OT Scenario - 3 =========== //
		
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> ALData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx",SheetName);
		
		// Explicit Wait for Field Name
		String FieldName = ALData.get(RowNumber).get("Field Name");

		wait.until(ExpectedConditions.elementToBeClickable(alp.FieldName));
		Thread.sleep(500);
		actionssendkeysdelete(alp.FieldName);
		Thread.sleep(500);
		tofill(alp.FieldName, FieldName);
		toenter();
		
		// Explicit Wait for New Value
		String NewValue = ALData.get(RowNumber).get("New Value");

		wait.until(ExpectedConditions.elementToBeClickable(alp.Newvalue));
		Thread.sleep(500);
		actionssendkeysdelete(alp.Newvalue);
		Thread.sleep(500);
		tofill(alp.Newvalue, NewValue);
		toenter();

		// Assertion for OT in New Value Field

		String OTExp = "21:00";
		Thread.sleep(500);

		WebElement OT = driver.findElement(By.xpath("//*[@id='1']/td[9]"));
		wait.until(ExpectedConditions.elementToBeClickable(OT));

		String OTAct = OT.getText();

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(OTExp, OTAct);

		System.out.println("OT For Branch : Expected: " + OTExp + " Actual: " + OT.getText());		

	}
	
	// ======================== Update By Section ================================ //
	
	@When("User verifying the late scenario for update by section {string} and {int}")
	public void user_verifying_the_late_scenario_for_update_by_section_and(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException, Throwable
	{
		uip = new UpdateByIndividual_POJO();
		udp = new UpdateByDepartment_POJO();
		ubp = new UpdateByBranch_POJO();
		usp = new UpdateBySection_POJO();
		alp = new AuditLog_POJO();
		WebDriverWait wait = new WebDriverWait(driver, 100);
		
		// ========= Update By Section - Late Scenario - 1 =========== //
		
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> ALData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx", SheetName);
		
		// Explicit Wait for WebPage Drop Down
		String Page = ALData.get(RowNumber).get("WebPage Name");
		String PerviousWebPage = ALData.get(RowNumber).get("PerviousWebPage");
		System.out.println("Excel Web Page Name: "+Page);
		
		//WebPage Drop Down Button Click
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='gs_WebPageName']//following::button[@type='button']//span[contains(text(),'"+PerviousWebPage+"')]")));
		WebElement WebPageButton= driver.findElement(By.xpath("//select[@id='gs_WebPageName']//following::button[@type='button']//span[contains(text(),'"+PerviousWebPage+"')]"));
		clickjavascript(WebPageButton);

		//Unselect the Webpage Drop Down Value
		WebElement UnSelectWebPageDDValue = driver.findElement(By.xpath("//span[contains(text(),'"+PerviousWebPage+"')]//preceding::input[@type='checkbox' and @name='multiselect_gs_WebPageName' and @value='"+PerviousWebPage+"']"));
		clickjavascript(UnSelectWebPageDDValue);
		
		/*Thread.sleep(500);
		WebElement WebPageDDValue = driver.findElement(By.xpath("//span[contains(text(),'"+Page+"')]//preceding::input[@type='checkbox' and @name='multiselect_gs_WebPageName' and @value='"+Page+"']"));
		Thread.sleep(500);
		clickjavascript(WebPageDDValue);
		
		if (WebPageDDValue.isSelected()) 
		{
			System.out.println(" *** Update By Department Is Selected *** " + WebPageDDValue.getText());
		}*/
		
		//=============== Select WebPage Value From Drop Down
	    
	    List WebPageDD = driver.findElements(By.xpath("//select[@id='gs_WebPageName']/option"));
	    System.out.println(WebPageDD.size());
	    Thread.sleep(2000);
	    
	    for (int i = 0; i <= WebPageDD.size(); i++) 
	    {
	    	//Thread.sleep(500);
	    	WebElement WebPageDDValue = driver.findElement(By.xpath("//input[@id='ui-multiselect-gs_WebPageName-option-"+i+"']"));
	    	String WebDDvalue=WebPageDDValue.getAttribute("value");
	    	String expectedVal = Page;
	    	Thread.sleep(500);
	    	System.out.println("Available Web Page List:"+WebDDvalue);
	    	
	    	if(WebDDvalue.equals(expectedVal))
	    	{
	    	Thread.sleep(500);
	    	
	    	//driver.findElement(By.xpath("//input[@id='ui-multiselect-gs_WebPageName-option-"+i+"' and @type='checkbox']")).click();
	    	//driver.findElement(By.xpath("//label[contains(.,'UPDATE BY INDIVIDUAL')]")).click();
	    	driver.findElement(By.xpath("//ul[@class='ui-multiselect-checkboxes ui-helper-reset']//following::span[contains(text(),'"+Page+"')]")).click(); // Working Xpath
	    	//ul[@class='ui-multiselect-checkboxes ui-helper-reset']//following::span[contains(text(),'UPDATE BY INDIVIDUAL')]
	    	totabkey();
	    	break;
	    	//span[contains(text(),'UPDATE BY INDIVIDUAL')]//preceding::input[@id='ui-multiselect-gs_WebPageName-option-6' and @value='UPDATE BY INDIVIDUAL' and @type='checkbox' and @name='multiselect_gs_WebPageName']
	    	//WebElement WebUBI = driver.findElement(By.xpath("//span[contains(text(),'"+Page+"')]//preceding::input[@id='ui-multiselect-gs_WebPageName-option-"+i+"' and @value='"+Page+"' and @type='checkbox' and @name='multiselect_gs_WebPageName']"));
	    	//WebElement WebUBI = driver.findElement(By.xpath("//input[@id='ui-multiselect-gs_WebPageName-option-"+i+"']"));
	    	//WebElement WebUBI= driver.findElement(By.xpath("//label[contains(.,'"+Page+"')]"));
	    	//driver.findElement(By.xpath("//input[@value='UPDATE BY INDIVIDUAL']")).click();

	    	}
	    }
	    
	    //==================
		
		
		
		// Transaction

		String Transaction = ALData.get(RowNumber).get("Transaction");
		String PreviousTransaction = ALData.get(RowNumber).get("PreviousTransaction");
		System.out.println("Excel Transaction Name: " + Transaction);
		
		//Transaction Button Click
		wait.until(ExpectedConditions.elementToBeClickable(alp.Transaction));
		toClick(alp.Transaction);

		//Click No Button
		WebElement NoButtonTran = driver.findElement(By.xpath("//span[contains(text(),'"+PreviousTransaction+"')]//preceding::input[@type='checkbox' and @name='multiselect_gs_TransactionType' and @value='"+PreviousTransaction+"']"));
		clickjavascript(NoButtonTran);
		
		//Transaction Dropdown Value Selection
		Thread.sleep(500);
		WebElement TransactionDDValue = driver.findElement(By.xpath("//span[contains(text(),'"+Transaction+"')]//preceding::input[@type='checkbox' and @name='multiselect_gs_TransactionType' and @value='"+Transaction+"']"));
		//WebElement TransactionDDValue= driver.findElement(By.xpath("//label/input[@value='"+Transaction+"']"));
		Thread.sleep(500);
		clickjavascript(TransactionDDValue);
		if (TransactionDDValue.isSelected()) 
		{
			System.out.println(" *** Update Is Selected for Department *** " + TransactionDDValue.getText());	
		}
		
		/*// Explicit Wait for Records
		String Record = ALData.get(RowNumber).get("Record");

		wait.until(ExpectedConditions.elementToBeClickable(alp.Record));
		Thread.sleep(500);
		actionssendkeysdelete(alp.Record);
		Thread.sleep(500);
		tofill(alp.Record, Record);
		toenter();*/

		// Explicit Wait for Field Name
		String FieldName = ALData.get(RowNumber).get("Field Name");

		wait.until(ExpectedConditions.elementToBeClickable(alp.FieldName));
		Thread.sleep(500);
		actionssendkeysdelete(alp.FieldName);
		Thread.sleep(500);
		tofill(alp.FieldName, FieldName);
		toenter();

		// Explicit Wait for Old Value
		String OldValue = ALData.get(RowNumber).get("Old Value");

		wait.until(ExpectedConditions.elementToBeClickable(alp.Oldvalue));
		Thread.sleep(500);
		actionssendkeysdelete(alp.Oldvalue);
		Thread.sleep(500);
		tofill(alp.Oldvalue, OldValue);
		toenter();

		// Explicit Wait for New Value
		String NewValue = ALData.get(RowNumber).get("New Value");

		wait.until(ExpectedConditions.elementToBeClickable(alp.Newvalue));
		Thread.sleep(500);
		actionssendkeysdelete(alp.Newvalue);
		Thread.sleep(500);
		tofill(alp.Newvalue, NewValue);
		toenter();

		
		// Assertion for Late

		String LateExp = "9:30";
		Thread.sleep(500);

		WebElement Late = driver.findElement(By.xpath("//*[@id='1']/td[9]"));
		wait.until(ExpectedConditions.elementToBeClickable(Late));

		String LatenessAct = Late.getText();

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(LateExp, LatenessAct);

		System.out.println("Latness For Section : Expected: " + LateExp + " Actual: " + Late.getText());
	
		
	}

	@When("User verifying the under scenario for update by section {string} and {int}")
	public void user_verifying_the_under_scenario_for_update_by_section_and(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException, Throwable
	{
		uip = new UpdateByIndividual_POJO();
		udp = new UpdateByDepartment_POJO();
		ubp = new UpdateByBranch_POJO();
		usp = new UpdateBySection_POJO();
		alp = new AuditLog_POJO();
		WebDriverWait wait = new WebDriverWait(driver, 100);
		
		// ========= Update By Section - Under Scenario - 2 =========== //
		
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> ALData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx",SheetName);
		
		// Explicit Wait for Field Name
		String FieldName = ALData.get(RowNumber).get("Field Name");

		wait.until(ExpectedConditions.elementToBeClickable(alp.FieldName));
		Thread.sleep(500);
		actionssendkeysdelete(alp.FieldName);
		Thread.sleep(500);
		tofill(alp.FieldName, FieldName);
		toenter();
		
		// Explicit Wait for New Value
		String NewValue = ALData.get(RowNumber).get("New Value");

		wait.until(ExpectedConditions.elementToBeClickable(alp.Newvalue));
		Thread.sleep(500);
		actionssendkeysdelete(alp.Newvalue);
		Thread.sleep(500);
		tofill(alp.Newvalue, NewValue);
		toenter();

		// Assertion for Under in New Value Field

		String UnderExp = "17:30";
		Thread.sleep(500);

		WebElement under = driver.findElement(By.xpath("//*[@id='1']/td[9]"));
		wait.until(ExpectedConditions.elementToBeClickable(under));

		String UnderAct = under.getText();
				
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(UnderExp, UnderAct);

		System.out.println("Under for Section : Expected: " + UnderExp + " Actual: " + under.getText());

		
	}

	@When("User verifying the OT scenario for update by section {string} and {int}")
	public void user_verifying_the_ot_scenario_for_update_by_section_and(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException, Throwable
	{
		
		uip = new UpdateByIndividual_POJO();
		udp = new UpdateByDepartment_POJO();
		ubp = new UpdateByBranch_POJO();
		usp = new UpdateBySection_POJO();
		alp = new AuditLog_POJO();
		WebDriverWait wait = new WebDriverWait(driver, 100);
		
		// ========= Update By Section - OT Scenario - 3 =========== //
		
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> ALData = reader.getData("src\\test\\resources\\Excel File\\Test Data.xlsx",SheetName);
		
		// Explicit Wait for Field Name
		String FieldName = ALData.get(RowNumber).get("Field Name");

		wait.until(ExpectedConditions.elementToBeClickable(alp.FieldName));
		Thread.sleep(500);
		actionssendkeysdelete(alp.FieldName);
		Thread.sleep(500);
		tofill(alp.FieldName, FieldName);
		toenter();
		
		// Explicit Wait for New Value
		String NewValue = ALData.get(RowNumber).get("New Value");

		wait.until(ExpectedConditions.elementToBeClickable(alp.Newvalue));
		Thread.sleep(500);
		actionssendkeysdelete(alp.Newvalue);
		Thread.sleep(500);
		tofill(alp.Newvalue, NewValue);
		toenter();

		// Assertion for OT in New Value Field

		String OTExp = "21:00";
		Thread.sleep(500);

		WebElement OT = driver.findElement(By.xpath("//*[@id='1']/td[9]"));
		wait.until(ExpectedConditions.elementToBeClickable(OT));

		String OTAct = OT.getText();

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(OTExp, OTAct);

		System.out.println("OT For Section : Expected: " + OTExp + " Actual: " + OT.getText());	
		
		System.out.println("Transaction Verification Completed in Audit Log Screen");	
		
	}


}


		//WebPage DropDown Selection
		/*Thread.sleep(1000);
		//WebElement WebPageDDValue= driver.findElement(By.xpath("//label[contains(.,'"+Page+"')]"));
		WebElement WebPageDDValue= driver.findElement(By.xpath("//span[contains(text(),'"+Page+"')]//preceding::input[@type='checkbox' and @name='multiselect_gs_WebPageName' and @value='"+Page+"']"));
		//WebElement WebPageDDValue= driver.findElement(By.xpath("//label[contains(.,'"+Page+"')]"));
		Thread.sleep(500);
	    clickjavascript(WebPageDDValue);
		
	    if (WebPageDDValue.isSelected()) 
		{
			System.out.println(" *** Update By Department Is Selected *** " + WebPageDDValue.getText());
		}
		 
		 //input[@id='ui-multiselect-gs_WebPageName-option-0' or @value='CC LEAVE RECALCULATE']
		 //span[contains(text(),'UPDATE BY INDIVIDUAL')]//preceding::input[@id='ui-multiselect-gs_WebPageName-option-6' and @value='UPDATE BY INDIVIDUAL' and @type='checkbox' and @name='multiselect_gs_WebPageName']
	    	//WebElement WebUBI = driver.findElement(By.xpath("//span[contains(text(),'"+Page+"')]//preceding::input[@id='ui-multiselect-gs_WebPageName-option-"+i+"' and @value='"+Page+"' and @type='checkbox' and @name='multiselect_gs_WebPageName']"));
	    	//WebElement WebUBI = driver.findElement(By.xpath("//input[@id='ui-multiselect-gs_WebPageName-option-"+i+"']"));
	    	//WebElement WebUBI= driver.findElement(By.xpath("//label[contains(.,'"+Page+"')]"));
	    	//driver.findElement(By.xpath("//input[@value='UPDATE BY INDIVIDUAL']")).click();

		 */
		 
		


	/* Transaction Direct Selection
	//WebElement TransactionDDValue= driver.findElement(By.xpath("//label/input[@value='"+Transaction+"']"));
	WebElement TransactionDDValue= driver.findElement(By.xpath("//span[contains(text(),'"+Transaction+"')]//preceding::input[@type='checkbox' and @name='multiselect_gs_WebPageName' and @value='"+Transaction+"']"));
	//WebElement TransactionDDValue= driver.findElement(By.xpath("/html[1]/body[1]/div[9]/ul[1]/li[4]/label[1]/span[1]"));
	Thread.sleep(500);
	clickjavascript(TransactionDDValue);
	if(TransactionDDValue.isSelected())
	{
	System.out.println(" *** Update Is Selected for Individual *** "+TransactionDDValue.getText()); 
	}
	totabkey();
	*/

