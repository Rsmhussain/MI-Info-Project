package info.stepdefinition;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import info.base.Reusableclass;
import info.pojo.AutoshiftNew_POJO;
import info.pojo.AutoshiftOld_POJO;
import info.pojo.User_POJO;
import info.utilities.ExcelReader;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Autoshift extends Reusableclass
{
	AutoshiftNew_POJO asp;
	User_POJO usp;
	
@Before("@Login")
public void login() throws InvalidFormatException, IOException, InterruptedException, AWTException
{
	browserLaunch();
	toMaximize();
	deletecookies();
	launchUrl("https://staging.info-tech.com.sg");
	asp = new AutoshiftNew_POJO();
	usp = new User_POJO();
	
//	ExcelReader reader=new ExcelReader();
//	List<Map<String,String>> testData=reader.getData("C:\\Users\\Sheik Mohammed\\Desktop\\info\\src\\test\\resources\\Excel File\\Test Data.xlsx",SheetName);
//	String username=testData.get(RowNumber).get("Username");
//	String password=testData.get(RowNumber).get("Password");
//	String dbname=testData.get(RowNumber).get("DB Name");
	
	WebDriverWait wait1 = new WebDriverWait(driver,100);
	wait1.until(ExpectedConditions.elementToBeClickable(usp.Username));
	tofill(usp.Username, "i1@gmail.com");
	//Thread.sleep(1000);
	WebDriverWait wait2 = new WebDriverWait(driver,100);
	wait2.until(ExpectedConditions.elementToBeClickable(usp.password));
	tofill(usp.password, "Pr0gram@2022");
	toClick(usp.click);
	implicitwait();
	
	//Change DB
	Thread.sleep(1000);
	toClick(usp.ChangeDB);
	Thread.sleep(2000);
	
	//Explicit Wait for Change DB
	WebDriverWait wait3 = new WebDriverWait(driver,100);
	wait3.until(ExpectedConditions.elementToBeClickable(usp.DBnameenter));
	
	Thread.sleep(1000);
	toClick(usp.DBnameenter);
	tofill(usp.DBnameenter,"SHEIK");
	
	Thread.sleep(1000);
	totabkey();
	Thread.sleep(1000);
	
	toenter();
	
}


@Given("User is on Home Page")
public void user_is_on_home_page() 
{
	browserLaunch();
	toMaximize();
	deletecookies();
	launchUrl("https://staging.info-tech.com.sg");
}

@When("User enter the user name {string} and password {int}")
public void user_enter_the_user_name_and_password(String SheetName, Integer RowNumber)  throws IOException, InvalidFormatException, AWTException, InterruptedException 
{
	ExcelReader reader=new ExcelReader();
	asp = new AutoshiftNew_POJO();
	usp = new User_POJO();
	List<Map<String,String>> testData=reader.getData("C:\\Users\\Sheik Mohammed\\eclipse-workspace\\info\\src\\test\\resources\\Excel File\\Test Data.xlsx", SheetName);
	String username=testData.get(RowNumber).get("Username");
	String password=testData.get(RowNumber).get("Password");
	String dbname=testData.get(RowNumber).get("DB Name");
	
	tofill(usp.Username, username);
	tofill(usp.password, password);
	toClick(usp.click);
	implicitwait();
	toClick(usp.ChangeDB);
	toClick(usp.DBnameenter);
	tofill(usp.DBnameenter,dbname);
	Thread.sleep(1000);
	totabkey();
	Thread.sleep(1000);
	toenter();
}

@Then("User Login to the application")
public void user_login_to_the_application() throws InterruptedException 
{	
	asp = new AutoshiftNew_POJO();
	Thread.sleep(400);
	tomovethecursor(asp.Shiftsetting);
	toClick(asp.Shiftsetting);
	
	
}

@Then("User Navigate to Autoshift Page")
public void user_navigate_to_autoshift_page_user() 
{
	asp = new AutoshiftNew_POJO();
	toClick(asp.Autoshift);
	System.out.println("Auto Shift Page Is Opened");
	
}

@When("User enter the autoshift details {string} and {int}")
public void user_enter_the_autoshift_details_and_password(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException, InterruptedException, AWTException 
{
	ExcelReader reader=new ExcelReader();
	
	
	String Sheet="C:\\Users\\Sheik Mohammed\\eclipse-workspace\\info\\src\\test\\resources\\Excel File\\Test Data.xlsx";
	int rowcount = getRowcount("Auto Shift Data");
	// Row Loop For Inserting Data into WebElements
	//for(int e = 1; e <= rowcount; e++)
	//{
	
		
		List<Map<String,String>> testData=reader.getData("C:\\Users\\Sheik Mohammed\\eclipse-workspace\\info\\src\\test\\resources\\Excel File\\Test Data.xlsx", SheetName);
		//List<Map<String,String>>=reader.getCellValue("C:\\Users\\Sheik Mohammed\\eclipse-workspace\\info\\src\\test\\resources\\Excel File\\Test Data.xlsx", RowNumber, ColumnName);
		String autoshiftcode=testData.get(RowNumber).get("Autoshift Code");
		String autoshiftname=testData.get(RowNumber).get("Autoshift Name");
		
		
			//System.out.println("Total Execel Row Count"+rowcount);
			//int i=2;
			//int s=0;
	asp = new AutoshiftNew_POJO();
	toClick(asp.NewAutoShift);
	
	WebDriverWait wait1 = new WebDriverWait(driver,50);
	wait1.until(ExpectedConditions.elementToBeClickable(asp.AutoShiftCode));
	
	tofill(asp.AutoShiftCode, autoshiftcode);
	
	Thread.sleep(1000);
	WebDriverWait wait2 = new WebDriverWait(driver,50);
	wait2.until(ExpectedConditions.elementToBeClickable(asp.AutoShiftCode));
	
	tofill(asp.AutoShiftName, autoshiftname);
	
	//Row 1
	
	String From1=testData.get(RowNumber).get("From1");
	if(From1!=null)
	{
	actionssendkeysdelete(asp.From1);
	tofill(asp.From1, From1);
	}
	else
	{
		System.out.println("Form1 value is not Enterted");
	}
	
	String To1=testData.get(RowNumber).get("To1");
	if(To1!=null)
	{
	actionssendkeysdelete(asp.To1);
	tofill(asp.To1, To1);
	}
	else
	{
		System.out.println("To1 value is not Enterted");
	}
	
	String dropdown1=testData.get(RowNumber).get("Assigned Shift1");
	if(To1!=null)
	{
	
	mouseclick(asp.ShiftDropDown1);
	actionssendkeysdelete(asp.ShiftDropDownText1);
	Thread.sleep(1000);
	clickjavascript(asp.ShiftDropDownText1);
	tofill(asp.ShiftDropDownText1, dropdown1);
	Thread.sleep(2000);
	todown();
	toenter();
	}
	else
	{
		System.out.println("DropDown1 value is not Enterted");
	}
	
	
	
	//Row 2
	String From2=testData.get(RowNumber).get("From2");
	if(From2.trim().isEmpty())
	{
		System.out.println("Form2 value is not Enterted");
	
	}
	else
	{
		Thread.sleep(2000);
		actionssendkeysdelete(asp.From2);
		Thread.sleep(2000);
		tofill(asp.From2, From2);
		System.out.println(From2);
		
	}
	
	Thread.sleep(1000);
	
	String To2=testData.get(RowNumber).get("To2");
	if(To2.trim().isEmpty())
	{
		System.out.println("To2 value is not Enterted");
	}
	else
	{
		Thread.sleep(2000);
		actionssendkeysdelete(asp.To2);
		Thread.sleep(2000);
		tofill(asp.To2, To2);
	}
	
	String dropdown2=testData.get(RowNumber).get("Assigned Shift2");
	if(dropdown2.trim().isEmpty())
	{
		System.out.println("Dropdown2 value is not Enterted");
	}
	else
	{
		toClick(asp.ShiftDropDown2);
		Thread.sleep(1000);
		actionssendkeysdelete(asp.ShiftDropDownText2);
		clickjavascript(asp.ShiftDropDownText2);
		Thread.sleep(1000);
		tofill(asp.ShiftDropDownText2, dropdown2);
		Thread.sleep(2000);
		todown();
		toenter();
	}
	
		//Row 3
		String From3=testData.get(RowNumber).get("From3");
		if(From3.trim().isEmpty())
		{
			System.out.println("Form3 value is not Enterted");
		
		}
		else
		{
			Thread.sleep(2000);
			actionssendkeysdelete(asp.From3);
			Thread.sleep(2000);
			tofill(asp.From3, From3);
			System.out.println(From3);
		}
		
		Thread.sleep(1000);
		
		String To3=testData.get(RowNumber).get("To3");
		if(To3.trim().isEmpty())
		{
			System.out.println("To3 value is not Enterted");
		}
		else
		{
			actionssendkeysdelete(asp.To3);
			Thread.sleep(1000);
			tofill(asp.To3, To3);
		}
		
		String dropdown3=testData.get(RowNumber).get("Assigned Shift3");
		if(dropdown3.trim().isEmpty())
		{
			System.out.println("Dropdown3 value is not Enterted");
		}
		else
		{
			toClick(asp.ShiftDropDown3);
			Thread.sleep(1000);
			actionssendkeysdelete(asp.ShiftDropDownText3);
			clickjavascript(asp.ShiftDropDownText3);
			Thread.sleep(1000);
			tofill(asp.ShiftDropDownText3, dropdown2);
			Thread.sleep(2000);
			todown();
			toenter();
		}
		
		//Row 4
		String From4=testData.get(RowNumber).get("From4");
		if(From4.trim().isEmpty())
		{
			System.out.println("Form4 value is not Enterted");

		}
		else
		{
			Thread.sleep(2000);
			actionssendkeysdelete(asp.From4);
			Thread.sleep(2000);
			tofill(asp.From4, From4);
			System.out.println(From4);
		}

		Thread.sleep(1000);

		String To4=testData.get(RowNumber).get("To4");
		if(To4.trim().isEmpty())
		{
			System.out.println("To4 value is not Enterted");
		}
		else
		{
			actionssendkeysdelete(asp.To4);
			Thread.sleep(1000);
			tofill(asp.To4, To4);
		}

		String dropdown4=testData.get(RowNumber).get("Assigned Shift4");
		if(dropdown4.trim().isEmpty())
		{
			System.out.println("Dropdown4 value is not Enterted");
		}
		else
		{
			toClick(asp.ShiftDropDown4);
			Thread.sleep(1000);
			actionssendkeysdelete(asp.ShiftDropDownText4);
			clickjavascript(asp.ShiftDropDownText4);
			Thread.sleep(1000);
			tofill(asp.ShiftDropDownText4, dropdown4);
			Thread.sleep(2000);
			todown();
			toenter();
		}
					
	
		//Row 5
		String From5=testData.get(RowNumber).get("From5");
		if(From4.trim().isEmpty())
		{
			System.out.println("Form5 value is not Enterted");

		}
		else
		{
			Thread.sleep(2000);
			actionssendkeysdelete(asp.From5);
			Thread.sleep(2000);
			tofill(asp.From5, From5);
			System.out.println(From5);
		}

		Thread.sleep(1000);

		String To5=testData.get(RowNumber).get("To5");
		if(To5.trim().isEmpty())
		{
			System.out.println("To5 value is not Enterted");
		}
		else
		{
			actionssendkeysdelete(asp.To5);
			Thread.sleep(1000);
			tofill(asp.To5, To5);
		}

		String dropdown5=testData.get(RowNumber).get("Assigned Shift5");
		if(dropdown5.trim().isEmpty())
		{
			System.out.println("Dropdown5 value is not Enterted");
		}
		else
		{
			toClick(asp.ShiftDropDown5);
			Thread.sleep(1000);
			actionssendkeysdelete(asp.ShiftDropDownText5);
			clickjavascript(asp.ShiftDropDownText5);
			Thread.sleep(1000);
			tofill(asp.ShiftDropDownText5, dropdown5);
			Thread.sleep(2000);
			todown();
			toenter();
		}		
	
		//Row 6
		String From6=testData.get(RowNumber).get("From6");
		if(From6.trim().isEmpty())
		{
			System.out.println("Form6 value is not Enterted");

		}
		else
		{
			Thread.sleep(2000);
			actionssendkeysdelete(asp.From6);
			Thread.sleep(2000);
			tofill(asp.From6, From6);
			System.out.println(From6);
		}

		Thread.sleep(1000);

		String To6=testData.get(RowNumber).get("To6");
		if(To6.trim().isEmpty())
		{
			System.out.println("To6 value is not Enterted");
		}
		else
		{
			
			actionssendkeysdelete(asp.To6);
			Thread.sleep(2000);
			tofill(asp.To6, To6);
		}

		String dropdown6=testData.get(RowNumber).get("Assigned Shift6");
		if(dropdown6.trim().isEmpty())
		{
			System.out.println("Dropdown5 value is not Enterted");
		}
		else
		{
			toClick(asp.ShiftDropDown6);
			Thread.sleep(1000);
			actionssendkeysdelete(asp.ShiftDropDownText6);
			clickjavascript(asp.ShiftDropDownText6);
			Thread.sleep(1000);
			tofill(asp.ShiftDropDownText6, dropdown6);
			Thread.sleep(2000);
			todown();
			toenter();
		}		

		//Row 7
		Scrolldownjavascript();
		
		String From7=testData.get(RowNumber).get("From7");
		if(From7.trim().isEmpty())
		{
			System.out.println("Form6 value is not Enterted");

		}
		else
		{
			Thread.sleep(2000);
			actionssendkeysdelete(asp.From7);
			Thread.sleep(2000);
			tofill(asp.From7, From7);
			System.out.println(From7);
		}

		Thread.sleep(1000);

		String To7=testData.get(RowNumber).get("To7");
		if(To7.trim().isEmpty())
		{
			System.out.println("To7 value is not Enterted");
		}
		else
		{
			actionssendkeysdelete(asp.To7);
			Thread.sleep(1000);
			tofill(asp.To7, To7);
		}

		String dropdown7=testData.get(RowNumber).get("Assigned Shift7");
		if(dropdown7.trim().isEmpty())
		{
			System.out.println("Dropdown7 value is not Enterted");
		}
		else
		{
			toClick(asp.ShiftDropDown7);
			Thread.sleep(1000);
			actionssendkeysdelete(asp.ShiftDropDownText7);
			clickjavascript(asp.ShiftDropDownText7);
			Thread.sleep(1000);
			tofill(asp.ShiftDropDownText7, dropdown7);
			Thread.sleep(2000);
			todown();
			toenter();
		}		
		
		
		//Row 8
		String From8=testData.get(RowNumber).get("From8");
		if(From8.trim().isEmpty())
		{
			System.out.println("Form8 value is not Enterted");

		}
		else
		{
			Thread.sleep(2000);
			actionssendkeysdelete(asp.From8);
			Thread.sleep(2000);
			tofill(asp.From8, From8);
			System.out.println(From8);
		}

		Thread.sleep(1000);

		String To8=testData.get(RowNumber).get("To8");
		if(To8.trim().isEmpty())
		{
			System.out.println("To8 value is not Enterted");
		}
		else
		{
			actionssendkeysdelete(asp.To8);
			Thread.sleep(1000);
			tofill(asp.To8, To8);
		}

		String dropdown8=testData.get(RowNumber).get("Assigned Shift8");
		if(dropdown8.trim().isEmpty())
		{
			System.out.println("Dropdown8 value is not Enterted");
		}
		else
		{
			toClick(asp.ShiftDropDown8);
			Thread.sleep(1000);
			actionssendkeysdelete(asp.ShiftDropDownText8);
			clickjavascript(asp.ShiftDropDownText8);
			Thread.sleep(1000);
			tofill(asp.ShiftDropDownText8, dropdown8);
			Thread.sleep(2000);
			todown();
			toenter();
		}		

		
		//Row 9
		String From9=testData.get(RowNumber).get("From9");
		if(From9.trim().isEmpty())
		{
			System.out.println("Form9 value is not Enterted");

		}
		else
		{
			Thread.sleep(2000);
			actionssendkeysdelete(asp.From9);
			Thread.sleep(2000);
			tofill(asp.From9, From9);
			System.out.println(From9);
		}

		Thread.sleep(1000);

		String To9=testData.get(RowNumber).get("To9");
		if(To9.trim().isEmpty())
		{
			System.out.println("To9 value is not Enterted");
		}
		else
		{
			actionssendkeysdelete(asp.To9);
			Thread.sleep(2000);
			tofill(asp.To9, To9);
		}

		String dropdown9=testData.get(RowNumber).get("Assigned Shift9");
		if(dropdown9.trim().isEmpty())
		{
			System.out.println("Dropdown9 value is not Enterted");
		}
		else
		{
			toClick(asp.ShiftDropDown9);
			Thread.sleep(1000);
			actionssendkeysdelete(asp.ShiftDropDownText9);
			clickjavascript(asp.ShiftDropDownText9);
			Thread.sleep(1000);
			tofill(asp.ShiftDropDownText9, dropdown9);
			Thread.sleep(2000);
			todown();
			toenter();
		}		
		
		
		//Row10
		String From10=testData.get(RowNumber).get("From10");
		if(From10.trim().isEmpty())
		{
			System.out.println("Form10 value is not Enterted");

		}
		else
		{
			Thread.sleep(2000);
			actionssendkeysdelete(asp.From10);
			Thread.sleep(2000);
			tofill(asp.From10, From10);
			System.out.println(From10);
		}

		Thread.sleep(1000);

		String To10=testData.get(RowNumber).get("To10");
		if(To10.trim().isEmpty())
		{
			System.out.println("To10 value is not Enterted");
		}
		else
		{
			actionssendkeysdelete(asp.To10);
			Thread.sleep(1000);
			tofill(asp.To10, To10);
		}

		String dropdown10=testData.get(RowNumber).get("Assigned Shift10");
		if(dropdown10.trim().isEmpty())
		{
			System.out.println("Dropdown10 value is not Enterted");
		}
		else
		{
			toClick(asp.ShiftDropDown10);
			Thread.sleep(1000);
			actionssendkeysdelete(asp.ShiftDropDownText10);
			clickjavascript(asp.ShiftDropDownText10);
			Thread.sleep(1000);
			tofill(asp.ShiftDropDownText10, dropdown10);
			Thread.sleep(2000);
			todown();
			toenter();
		}		

	System.out.println("Table Value Instered Successfully");
	Scrolldownjavascript();
	
	
	
	Thread.sleep(1000);
	clickjavascript(asp.Savebutton);
	implicitwait();
	Scrollupjavascript();
	Thread.sleep(300);
	
	System.out.println("New Auto Shift Created Successfully");
	
	//driver.quit();
	//}// For Loop For Inserting Data into WebElements -Closed
}

}







//java.util.List<WebElement> table=driver.findElements(By.xpath("//*[@id=\"ContentPlaceHolder1_gvAutoShiftSettings\"]/tbody/tr"));
//int rcount=table.size();
//System.out.println("No of WebElement Table rows are : " +table.size()); 

/*Newly Added Coded Instead of Column Loop*/
/*
//Filling Data in From 
actionssendkeysdelete(asp.From);
String from1=testData.get(RowNumber).get("From1");
tofill(asp.From, from1);
//System.out.println("Postion Of Column Inserted: "+c);

//Filling Data in To
actionssendkeysdelete(asp.To);
String to1=testData.get(RowNumber).get("To1");
tofill(asp.To, to1);

//Filling Data in ShiftDropDown
Scrolldownjavascript();

WebElement ASDropDown = driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_gvAutoShiftSettings_ddllistShifts_"+s+"_Input\"]"));
mouseclick(ASDropDown);
//Thread.sleep(3000);
System.out.println("Drop Down Selected In the Row: "+s);
Thread.sleep(3000);

//Choosing Drop Down Value Directly
actionssendkeysdelete(ASDropDown);
clickjavascript(ASDropDown);
Thread.sleep(300);
//c++;

String shiftdropdown1=testData.get(RowNumber).get("Assigned Shift Name1");
tofill(ASDropDown, shiftdropdown);
Thread.sleep(2000);
todown();
toenter();
System.out.println("Excel Row Instered :"+e);
Thread.sleep(1000);
*/






/*Newly Added Coded Instead of Column Loop - Closed*/



//int columncount=getCellcount("Auto Shift Data", e);
//System.out.println("Column Count :"+columncount+" In Row "+e);



/*
for(int c=5;c<columncount;c++)
{//Column Loop
	try
	{//try block
	Thread.sleep(1000);
	WebElement ASFrom = driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_gvAutoShiftSettings\"]/tbody/tr["+i+"]/td[1]/input"));
	WebElement ASTo = driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_gvAutoShiftSettings\"]/tbody/tr["+i+"]/td[2]/input"));
	
	//int columncount=getCellcount("Auto Shift Data", e);
	//System.out.println("Column Count :"+columncount+" In Row "+e);
	
	
	//Gird Table Data Element Inserting
	
	//Row 1
	actionssendkeysdelete(ASFrom);
	String from1=testData.get(RowNumber).get(6);
	tofill(ASFrom, from1);
	System.out.println(from1);
	
	
//	actionssendkeysdelete(ASFrom);
//	String from2=testData.get(RowNumber).get("From2");
//	tofill(ASFrom, from2);
	
	c++;
	
	actionssendkeysdelete(ASTo);
	String to1=testData.get(RowNumber).get(7);
	tofill(ASTo, to1);
	
//	actionssendkeysdelete(ASTo);
//	String to2=testData.get(RowNumber).get("To2");
//	tofill(ASTo, to2);
	
	System.out.println("Excel Row No:"+e+" Inserted into Web Element "+i);
	
	Thread.sleep(1000);
			
	Scrolldownjavascript();
	
	WebElement ASDropDown = driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_gvAutoShiftSettings_ddllistShifts_"+s+"_Input\"]"));
	mouseclick(ASDropDown);
	//Thread.sleep(3000);
	System.out.println("Drop Down Selected In the Row: "+s);
	Thread.sleep(3000);
	
	//Choosing Drop Down Value Directly
	actionssendkeysdelete(ASDropDown);
	clickjavascript(ASDropDown);
	Thread.sleep(300);
	c++;
	String shiftdropdown1=testData.get(RowNumber).get(8);
	tofill(ASDropDown, shiftdropdown1);
	Thread.sleep(2000);
	todown();
	toenter();
	
//	String shiftdropdown2=testData.get(RowNumber).get("Assigned Shift Name2");
//	tofill(ASDropDown, shiftdropdown2);
//	Thread.sleep(2000);
//	todown();
//	toenter();
	
	//System.out.println("Postion Of Column Inserted: "+c);
	
	Thread.sleep(1000);
	
	if(i==11)
	{
		break;
	}
	i++;
			
	s++;

	//Row 2
	
	
	
	
	
	
	
	
	
	
	
	
	//Thread.sleep(3000); 

	//System.out.println("Column Loop Completed: "+c);
	
}//try block closed
catch(Exception u)
{
	System.out.println(u.getMessage());
}
						
}//Column Loop Closed

*/