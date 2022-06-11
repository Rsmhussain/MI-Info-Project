package info.stepdefinition;

import java.awt.AWTException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import info.base.Reusableclass;
import info.pojo.AutoshiftNew_POJO;
import info.pojo.Dutyroster_New_POJO;
import info.pojo.User_POJO;
import info.utilities.ExcelReader;
import io.cucumber.java.en.Given;

public class DutyRoster extends Reusableclass
{
	AutoshiftNew_POJO asp;
	User_POJO usp;
	Dutyroster_New_POJO drp;
		

@Given("User enter the employee code, employee name {string} and shift details {int}")
public void user_enter_the_employee_code_employee_name_and_shift_details(String SheetName1, Integer RowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException 
{
	ExcelReader reader=new ExcelReader();
	drp=new Dutyroster_New_POJO();
	asp=new AutoshiftNew_POJO();
		
	//clicking shift settings using sleector option for click by mouse
	//byClickByMouse(asp.Shiftsettings);
	toClick(asp.Shiftsetting);
	toClick(drp.DutyrosterMenu);
	System.out.println("Duty Roster Page Is Opened");
	toClick(drp.NewDutyroster);
	
	
	
	List<Map<String,String>> DutyData=reader.getData("C:\\Users\\Sheik Mohammed\\eclipse-workspace\\info\\src\\test\\resources\\Excel File\\Test Data.xlsx", SheetName1);
	toClick(drp.DutyrosterCode);
	String DutyCode=DutyData.get(RowNumber).get("Duty Roster Code");
	
	tofill(drp.DutyrosterCode, DutyCode);
	Thread.sleep(1000);
	
	toClick(drp.DutyrosterName);
	String DutyName=DutyData.get(RowNumber).get("Duty Roster Name");
	tofill(drp.DutyrosterName, DutyName);
		
	String EffectiveFrom=DutyData.get(RowNumber).get("Effective From");
	actionssendkeysdelete(drp.DREffectiveFrom);
	tofill(drp.DREffectiveFrom, EffectiveFrom);
	toenter();
	
	String RecurrenceDays=DutyData.get(RowNumber).get("Recurrence Days");
	String GroupInvolved=DutyData.get(RowNumber).get("Group Involved");
	
	toselectbyvisibletext(drp.DRRecurrenceDays, RecurrenceDays);
	toselectbyvisibletext(drp.DRGroupinvolved, GroupInvolved);
	

	try//Try Block
	{
		//Row 1 Drop Selection Block
		
		//Row 1
		//G1DR1
		String DD1R0=DutyData.get(RowNumber).get("G1DR1");
		System.out.println(DD1R0);
		
		Thread.sleep(500);
		WebDriverWait wait1 = new WebDriverWait(driver,100);
		wait1.until(ExpectedConditions.elementToBeClickable(drp.DD1R0));
		toClick(drp.DD1R0);
		
		Thread.sleep(500);
		
		WebDriverWait wait24 = new WebDriverWait(driver,100);
		wait24.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='ContentPlaceHolder1_gvFirstWeek_ddlShift2_3']/option[contains(text(), '"+DD1R0+"')]")));
		driver.findElement(By.xpath("//select[@id='ContentPlaceHolder1_gvFirstWeek_ddlShift0_0']/option[contains(text(), '"+DD1R0+"')]")).click();
		System.out.println(DD1R0);
		Thread.sleep(1000);
		
		//G1DR2
		String DD1R1=DutyData.get(RowNumber).get("G1DR2");
		System.out.println(DD1R1);
		
		Thread.sleep(2000);
		WebDriverWait wait2 = new WebDriverWait(driver,100);
		wait2.until(ExpectedConditions.elementToBeClickable(drp.DD1R1));
		toClick(drp.DD1R1);
		
		Thread.sleep(500);
		
		WebDriverWait wait23 = new WebDriverWait(driver,100);
		wait23.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='ContentPlaceHolder1_gvFirstWeek_ddlShift2_3']/option[contains(text(), '"+DD1R1+"')]")));
		driver.findElement(By.xpath("//select[@id='ContentPlaceHolder1_gvFirstWeek_ddlShift1_0']/option[contains(text(), '"+DD1R1+"')]")).click();
		System.out.println(DD1R1);
		Thread.sleep(2000);
		
		//G1DR3
		String DD1R2=DutyData.get(RowNumber).get("G1DR3");
		System.out.println(DD1R2);
		
		Thread.sleep(2000);
		WebDriverWait wait3 = new WebDriverWait(driver,100);
		wait3.until(ExpectedConditions.elementToBeClickable(drp.DD1R2));
		toClick(drp.DD1R2);
				
		Thread.sleep(500);
		
		WebDriverWait wait22 = new WebDriverWait(driver,100);
		wait22.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='ContentPlaceHolder1_gvFirstWeek_ddlShift2_3']/option[contains(text(), '"+DD1R2+"')]")));
		driver.findElement(By.xpath("//select[@id='ContentPlaceHolder1_gvFirstWeek_ddlShift2_0']/option[contains(text(), '"+DD1R2+"')]")).click();
		System.out.println(DD1R2);
		Thread.sleep(2000);
		
		
		//Row 2
		//G2DR1
		String DD2R0=DutyData.get(RowNumber).get("G2DR1");
		System.out.println(DD2R0);

		Thread.sleep(2000);
		WebDriverWait wait4 = new WebDriverWait(driver,100);
		wait2.until(ExpectedConditions.elementToBeClickable(drp.DD2R0));
		toClick(drp.DD2R0);
		
		Thread.sleep(500);
		
		WebDriverWait wait21 = new WebDriverWait(driver,100);
		wait21.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='ContentPlaceHolder1_gvFirstWeek_ddlShift2_3']/option[contains(text(), '"+DD2R0+"')]")));
		driver.findElement(By.xpath("//select[@id='ContentPlaceHolder1_gvFirstWeek_ddlShift0_1']/option[contains(text(), '"+DD2R0+"')]")).click();
		System.out.println(DD2R0);
		Thread.sleep(2000);

		//G2DR2
		String DD2R1=DutyData.get(RowNumber).get("G2DR2");
		System.out.println(DD2R1);
		
		Thread.sleep(2000);
		WebDriverWait wait5 = new WebDriverWait(driver,100);
		wait5.until(ExpectedConditions.elementToBeClickable(drp.DD2R1));
		toClick(drp.DD2R1);

		Thread.sleep(500);
		
		WebDriverWait wait20 = new WebDriverWait(driver,100);
		wait20.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='ContentPlaceHolder1_gvFirstWeek_ddlShift2_3']/option[contains(text(), '"+DD2R1+"')]")));
		driver.findElement(By.xpath("//select[@id='ContentPlaceHolder1_gvFirstWeek_ddlShift1_1']/option[contains(text(), '"+DD2R1+"')]")).click();
		System.out.println(DD2R1);
		Thread.sleep(2000);
		//G2DR3
		String DD2R2=DutyData.get(RowNumber).get("G2DR3");
		System.out.println(DD2R2);
		
		Thread.sleep(2000);
		WebDriverWait wait6 = new WebDriverWait(driver,100);
		wait6.until(ExpectedConditions.elementToBeClickable(drp.DD2R2));
		toClick(drp.DD2R2);
		
		Thread.sleep(500);
		WebDriverWait wait19 = new WebDriverWait(driver,100);
		wait19.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='ContentPlaceHolder1_gvFirstWeek_ddlShift2_3']/option[contains(text(), '"+DD2R2+"')]")));
		driver.findElement(By.xpath("//select[@id='ContentPlaceHolder1_gvFirstWeek_ddlShift2_1']/option[contains(text(), '"+DD2R2+"')]")).click();
		System.out.println(DD2R2);
		
		Thread.sleep(2000);
		//Row 3
		//G3DR1
		String DD3R0=DutyData.get(RowNumber).get("G3DR1");
		System.out.println(DD3R0);

		Thread.sleep(2000);
		WebDriverWait wait7 = new WebDriverWait(driver,100);
		wait7.until(ExpectedConditions.elementToBeClickable(drp.DD3R0));
		toClick(drp.DD3R0);
		
		Thread.sleep(500);
		
		WebDriverWait wait18 = new WebDriverWait(driver,100);
		wait18.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='ContentPlaceHolder1_gvFirstWeek_ddlShift2_3']/option[contains(text(), '"+DD3R0+"')]")));
		driver.findElement(By.xpath("//select[@id='ContentPlaceHolder1_gvFirstWeek_ddlShift0_2']/option[contains(text(), '"+DD3R0+"')]")).click();
		System.out.println(DD3R0);
		Thread.sleep(2000);

		//G3DR2
		String DD3R1=DutyData.get(RowNumber).get("G3DR2");
		System.out.println(DD3R1);
		
		
		Thread.sleep(2000);
		WebDriverWait wait8 = new WebDriverWait(driver,100);
		wait8.until(ExpectedConditions.elementToBeClickable(drp.DD3R1));
		toClick(drp.DD3R1);
		
		Thread.sleep(500);
		
		WebDriverWait wait17 = new WebDriverWait(driver,100);
		wait17.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='ContentPlaceHolder1_gvFirstWeek_ddlShift2_3']/option[contains(text(), '"+DD3R1+"')]")));
		
		driver.findElement(By.xpath("//select[@id='ContentPlaceHolder1_gvFirstWeek_ddlShift1_2']/option[contains(text(), '"+DD3R1+"')]")).click();
		System.out.println(DD3R1);
		Thread.sleep(2000);

		//G3DR3
		String DD3R2=DutyData.get(RowNumber).get("G3DR3");
		System.out.println(DD3R2);

		Thread.sleep(2000);
		WebDriverWait wait9 = new WebDriverWait(driver,100);
		wait9.until(ExpectedConditions.elementToBeClickable(drp.DD3R2));
		toClick(drp.DD3R2);

		Thread.sleep(500);
		
		WebDriverWait wait16 = new WebDriverWait(driver,100);
		wait16.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='ContentPlaceHolder1_gvFirstWeek_ddlShift2_3']/option[contains(text(), '"+DD3R2+"')]")));
		
		driver.findElement(By.xpath("//select[@id='ContentPlaceHolder1_gvFirstWeek_ddlShift2_2']/option[contains(text(), '"+DD3R2+"')]")).click();
		System.out.println(DD3R2);
		Thread.sleep(2000);
		//Row 4
		//G4DR1
		String DD4R0=DutyData.get(RowNumber).get("G4DR1");
		System.out.println(DD4R0);

		Thread.sleep(2000);
		WebDriverWait wait10 = new WebDriverWait(driver,100);
		wait10.until(ExpectedConditions.elementToBeClickable(drp.DD4R0));
		toClick(drp.DD4R0);

		Thread.sleep(500);
		
		WebDriverWait wait15 = new WebDriverWait(driver,100);
		wait15.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='ContentPlaceHolder1_gvFirstWeek_ddlShift2_3']/option[contains(text(), '"+DD4R0+"')]")));
		driver.findElement(By.xpath("//select[@id='ContentPlaceHolder1_gvFirstWeek_ddlShift0_3']/option[contains(text(), '"+DD4R0+"')]")).click();
		System.out.println(DD4R0);
		Thread.sleep(2000);

		//G4DR2
		String DD4R1=DutyData.get(RowNumber).get("G4DR2");
		System.out.println(DD4R1);

		Thread.sleep(2000);
		WebDriverWait wait11 = new WebDriverWait(driver,100);
		wait11.until(ExpectedConditions.elementToBeClickable(drp.DD4R1));
		toClick(drp.DD4R1);

		Thread.sleep(500);
		
		WebDriverWait wait14 = new WebDriverWait(driver,100);
		wait14.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='ContentPlaceHolder1_gvFirstWeek_ddlShift2_3']/option[contains(text(), '"+DD4R1+"')]")));
		driver.findElement(By.xpath("//select[@id='ContentPlaceHolder1_gvFirstWeek_ddlShift1_3']/option[contains(text(), '"+DD4R1+"')]")).click();
		System.out.println(DD4R1);
		Thread.sleep(2000);

		//G2DR3
		String DD4R2=DutyData.get(RowNumber).get("G4DR3");
		System.out.println(DD4R2);

		Thread.sleep(2000);
		WebDriverWait wait12 = new WebDriverWait(driver,100);
		wait12.until(ExpectedConditions.elementToBeClickable(drp.DD4R2));
		toClick(drp.DD4R2);

		Thread.sleep(2000);
		WebDriverWait wait13 = new WebDriverWait(driver,100);
		wait13.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='ContentPlaceHolder1_gvFirstWeek_ddlShift2_3']/option[contains(text(), '"+DD4R2+"')]")));
		
		driver.findElement(By.xpath("//select[@id='ContentPlaceHolder1_gvFirstWeek_ddlShift2_3']/option[contains(text(), '"+DD4R2+"')]")).click();
		System.out.println(DD4R2);
		Thread.sleep(2000);
		//Save
		Scrolldownjavascript();
		Scrolldownjavascript();
		Thread.sleep(2000);
		WebDriverWait wait25 = new WebDriverWait(driver,100);
		wait25.until(ExpectedConditions.elementToBeClickable(drp.DRSaveButton));
		//toClick(drp.DRSaveButton);
		clickjavascript(drp.DRSaveButton);
	}
	catch(Exception e)
	{
	System.out.println("Error Message:"+e);
	}
	
	}//Method Closing

}//Class Closing


/*
	int excelrowcount = getRowcount("Duty Roster");
	System.out.println("Total Excel Row Count: "+excelrowcount);
	int er=2;
	
	
	
	
	for(int r=1;r<=excelrowcount;r++)
	{
	
	int columncount=getCellcount("Duty Roster", 1); 
	
	System.out.println("Excel Column Count: "+columncount);
	
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,300)", "");
	
	
	
	try//Try Block
	{
	
		
		int ec=2;
		int brlw=1;
		
	for(int c=6;c<columncount;c++)//column Loop Block //Total Wait:3000
	{			 
			System.out.println("Inserting Column No: "+c);
			
			Thread.sleep(1500); // Mandatory - If Remove this sleep Element will not be visible 
			
			
			//Once the Week Decided then control goes to Xpath Section
			
			if(c>12)// In Excel column count >12 means it will goes to 2nd Week
			{
				brlw=2;
				System.out.println("Inserting in Second Week: "+brlw+" Excel Column No: "+c);
			}
			if(c>19)// In Excel column count >19 means it will goes to 3rd Week
			{
				brlw=3;
				System.out.println("Inserting in Third Week: "+brlw+" Excel Column No: "+c);
			}
			if(c>26)// In Excel column count >26 means it will goes to 4th Week
			{
				brlw=4;
				System.out.println("Inserting in Fourth Week: "+brlw+" Excel Column No: "+c);
			}
			if(c>33)// In Excel column count >33 means it will goes to 5th Week
			{
				brlw=5;
				System.out.println("Inserting in Fivth Week: "+brlw+" Excel Column No: "+c);
			}
			if(c>40)// In Excel column count >40 means it will goes to 6th Week
			{
				brlw=6;
				System.out.println("Inserting in Sixth Week: "+brlw+" Excel Column No: "+c);
			}
			if(c<13)// In Excel column count <13 means it will goes to 1st Week
			{
				brlw=1;
				System.out.println("Inserting in First Week: "+brlw+" Excel Column No: "+c);
			}
			
			Thread.sleep(1000); // Mandatory - If Remove this sleep Element will not be visible  
			
			WebElement ShiftDropDown=driver.findElement(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[2]/section[2]/div[2]/div/div/div/div[2]/div[2]/div/div["+brlw+"]/div[2]/div/div/table/tbody/tr["+er+"]/td["+ec+"]/select"));
			//html/body/form/div[5]/div[2]/div[3]/div[2]/section[2]/div[2]/div/div/div/div[2]/div[2]/div/div[1]/div[2]/div/div/table/tbody/tr[3]/td[2]/select
			
			//clickjavascript(ShiftDropDown);
			toClick(ShiftDropDown);
			System.out.println("Xpath Row Selected: "+er);
			System.out.println("Xpath Column Selected: "+ec);
			System.out.println("\n");
			
			//Thread.sleep(500); //optional If u required uncomment it based on Performance
			java.util.List<WebElement> Availableshifts=driver.findElements(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[2]/section[2]/div[2]/div/div/div/div[2]/div[2]/div/div["+brlw+"]/div[2]/div/div/table/tbody/tr["+er+"]/td["+ec+"]/select/option"));
			System.out.println("Row: "+er+" In column: "+ec+" Total Available Shifts: "+Availableshifts.size());
			System.out.println("\n");
			
			//String ExcelDropDownValue=excelReadValue("Duty Roster", r, c);
			String ExcelDropDownValue=DutyData.get(RowNumber).get("G1Day");
			
			
			
			System.out.println("****** Available Shifts Loading ******");
			System.out.println("\n");
			
			//Comparing drop down shift with excel data
			for(WebElement listItem:Availableshifts) 
			{ 
				String Shift=listItem.getText();
				
				if (Shift.contains(ExcelDropDownValue)) 
				{ 
					listItem.click();
					System.out.println("Shift Selected ---> "+listItem+" In Web Table Column"+ec);
					break; 
				} 
				 
			} 

			Thread.sleep(500); // Mandatory - If Remove this sleep Element will not be visible 
			
			//Xpath Column Incrementing Section
			if(ec<8)
			{
				ec++;
				//System.out.println("In Xpath row: "+er+" Xpath Column Incremented: "+ec);
			}
			else
			{	
			//Resetting the Xpath Column and Week Table Incrementing Section
			System.out.println("\n Week Table Completed: --> "+brlw);
			ec=2;
			brlw++;
			System.out.println("\n Table Count[div] After Incremented: --> "+brlw);
			}
			System.out.println("\n Column Loop Completed For --> "+c);
			
			
	}//Column Loop Closed
	
	}//try closed
	catch(Exception e)
	{
		throw new NoSuchElementException(String.format("The following element was not visible: %s ", e));
	}

	er++; //Table Row Increment
	
	//JavascriptExecutor js2 = (JavascriptExecutor) driver;
	//js2.executeScript("window.scrollBy(0,300)", "");
	
	
	
	
	System.out.println("\n ***** Browser Launch If Loop Closed *****");
	
	//}//Browser If closing
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	else // NO Browser Launch 
	{
		int columncount=getCellcount("Duty Roster", r);
		System.out.println("Column Count :"+columncount+" In Group "+r);
		int nbrlec=2;
		int nec=2;
		
		try //Try Block
		{
		
		for(int c=6;c<columncount;c++)
		{
			
			//Once the Week Decided then control goes to Xpath Section
			
			if(c>12)// In Excel column count >12 means it will goes to 2nd Week
			{
				nbrlec=2;
				System.out.println("Inserting in Second Week: "+nbrlec+" Excel Column No: "+c);
			}
			if(c>19)// In Excel column count >19 means it will goes to 3rd Week
			{
				nbrlec=3;
				System.out.println("Inserting in Third Week: "+nbrlec+" Excel Column No: "+c);
			}
			if(c>26)// In Excel column count >26 means it will goes to 4th Week
			{
				nbrlec=4;
				System.out.println("Inserting in Fourth Week: "+nbrlec+" Excel Column No: "+c);
			}
			if(c>33)// In Excel column count >33 means it will goes to 5th Week
			{
				nbrlec=5;
				System.out.println("Inserting in Fivth Week: "+nbrlec+" Excel Column No: "+c);
			}
			if(c>40)// In Excel column count >40 means it will goes to 6th Week
			{
				nbrlec=6;
				System.out.println("Inserting in Sixth Week: "+nbrlec+" Excel Column No: "+c);
			}
			if(c<13)// In Excel column count <13 means it will goes to 1st Week
			{
				nbrlec=1;
				System.out.println("Inserting in First Week: "+nbrlec+" Excel Column No: "+c);
			}
			
			Thread.sleep(1000);
			java.util.List<WebElement> Availableshifts=driver.findElements(By.xpath("/html/body/form/div[5]/div[2]/div[3]/div[2]/section[2]/div[2]/div/div/div/div[2]/div[2]/div/div["+nbrlec+"]/div[2]/div/div/table/tbody/tr["+er+"]/td["+nec+"]/select/option"));
			System.out.println("Row: "+er+" In column: "+nec+" Total Available Shifts: "+Availableshifts.size());
			System.out.println("\n");
			String ExcelDropDownValue=excelReadValue("Duty Roster", r, c);
			
			System.out.println("****** Available Shifts Loading ******");
			System.out.println("\n");
			
			//Comparing drop down shift with excel data
			for(WebElement listItem:Availableshifts) 
			{ 
				String Shift=listItem.getText();
				
				if (Shift.contains(ExcelDropDownValue)) 
				{ 
					listItem.click();
					System.out.println("Shift Selected ---> "+listItem+" In Web Table Column"+ec);
					break; 
				} 
				 
			} 

			Thread.sleep(1000);
			
			//Xpath Column Incrementing Section
			if(nec<8)
			{
				nec++;
				//System.out.println("In Xpath row: "+er+" Xpath Column Incremented: "+ec);
			}
			else
			{	
			//Resetting the Xpath Column and Week Table Incrementing Section
			System.out.println("\n Week Table Completed: --> "+nbrlec);
			nec=2;
			nbrlec++;
			System.out.println("\n Table Count[div] After Incremented: --> "+nbrlec);
			}
			System.out.println("\n Column Loop Completed For --> "+c);
			
						
		}// Excel Column Loop Closed
		
		}//try Closed
		catch(Exception ee)
		{
			throw new NoSuchElementException(String.format("The following element was not visible: %s ", ee));
		}
		
		er++;
		
	}//else Closed
	
	
	
	
		
    
}
}
}*/

			
		




//String DRRecDays =excelReadValue("Duty Roster", r, 4);
//String DRgroup =excelReadValue("Duty Roster", r, 5);
//
//int RecDays= Integer.parseInt(DRRecDays);
//int groupcount= Integer.parseInt(DRgroup);
//
//System.out.println("Recurrecne Days: "+DRRecDays);
//System.out.println("Group: "+DRgroup);
//
//int columncount=getCellcount("Duty Roster", r);

//System.out.println("This Column Count is Considering From One:"+columncount+" In Group "+r);
//System.out.println("\n");
//System.out.println("***** Column Looping Section *****");
//System.out.println("\n");
