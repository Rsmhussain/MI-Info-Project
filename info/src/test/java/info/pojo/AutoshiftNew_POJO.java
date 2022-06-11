package info.pojo;

import info.base.Reusableclass;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutoshiftNew_POJO extends Reusableclass
{
	
	public AutoshiftNew_POJO()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[contains(text(),'Shift Settings')]")
	public WebElement Shiftsetting;
	
	public final By Shiftsettings=ById.xpath("//span[contains(text(),'Shift Settings')]");
	
	@FindBy(linkText = "Auto Shift")
	public WebElement Autoshift;
	
//	@FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_lnkManage\"]/i")
//	public WebElement NewAS;
	
	@FindBy(id="ContentPlaceHolder1_lnkManage")
	public WebElement NewAutoShift;

	
	@FindBy(id = "ContentPlaceHolder1_txtAutoShiftCode")
	public WebElement AutoShiftCode;
	
	@FindBy(id = "ContentPlaceHolder1_txtAddShiftName")
	public WebElement AutoShiftName;

	//Row 1
	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_txtFromTime_0")
	public WebElement From1;
	
	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_txtToTime_0")
	public WebElement To1;

	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_ddllistShifts_0_DropDiv")
	public WebElement ShiftDropDown1;
	
	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_ddllistShifts_0_Input")
	public WebElement ShiftDropDownText1;
	
	//ContentPlaceHolder1_gvAutoShiftSettings_ddllistShifts_"+s+"_Input
	
	//Row 2
	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_txtFromTime_1")
	public WebElement From2;
		
	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_txtToTime_1")
	public WebElement To2;

	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_ddllistShifts_1_DropDiv")
	public WebElement ShiftDropDown2;
	
	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_ddllistShifts_1_Input")
	public WebElement ShiftDropDownText2;
	
	
	//Row 3
	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_txtFromTime_2")
	public WebElement From3;
			
	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_txtToTime_2")
	public WebElement To3;

	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_ddllistShifts_2_DropDiv")
	public WebElement ShiftDropDown3;

	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_ddllistShifts_2_Input")
	public WebElement ShiftDropDownText3;
	
	
	//Row 4
	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_txtFromTime_3")
	public WebElement From4;
				
	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_txtToTime_3")
	public WebElement To4;

	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_ddllistShifts_3_DropDiv")
	public WebElement ShiftDropDown4;

	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_ddllistShifts_3_Input")
	public WebElement ShiftDropDownText4;
	
	
	//Row 5
	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_txtFromTime_4")
	public WebElement From5;
				
	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_txtToTime_4")
	public WebElement To5;

	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_ddllistShifts_4_DropDiv")
	public WebElement ShiftDropDown5;

	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_ddllistShifts_4_Input")
	public WebElement ShiftDropDownText5;
	
	//Row 6
	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_txtFromTime_5")
	public WebElement From6;
				
	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_txtToTime_5")
	public WebElement To6;

	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_ddllistShifts_5_DropDiv")
	public WebElement ShiftDropDown6;

	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_ddllistShifts_5_Input")
	public WebElement ShiftDropDownText6;
	
	//Row 7
	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_txtFromTime_6")
	public WebElement From7;
					
	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_txtToTime_6")
	public WebElement To7;

	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_ddllistShifts_6_DropDiv")
	public WebElement ShiftDropDown7;

	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_ddllistShifts_6_Input")
	public WebElement ShiftDropDownText7;
	
	//Row 8
	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_txtFromTime_7")
	public WebElement From8;
						
	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_txtToTime_7")
	public WebElement To8;

	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_ddllistShifts_7_DropDiv")
	public WebElement ShiftDropDown8;

	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_ddllistShifts_7_Input")
	public WebElement ShiftDropDownText8;
	
	//Row 9
	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_txtFromTime_8")
	public WebElement From9;
							
	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_txtToTime_8")
	public WebElement To9;

	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_ddllistShifts_8_DropDiv")
	public WebElement ShiftDropDown9;

	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_ddllistShifts_8_Input")
	public WebElement ShiftDropDownText9;
	
	//Row 10
	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_txtFromTime_9")
	public WebElement From10;
								
	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_txtToTime_9")
	public WebElement To10;

	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_ddllistShifts_9_DropDiv")
	public WebElement ShiftDropDown10;

	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_ddllistShifts_9_Input")
	public WebElement ShiftDropDownText10;
	
	
	
	
	
	@FindBy(xpath="//input[@id='ContentPlaceHolder1_btnAdd']")
	public WebElement Savebutton;

	@FindBy(id = "ContentPlaceHolder1_txtEmpSearchText")
	public WebElement Shiftsearch;
	
	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_divDetails\"]/div/div/div/div[2]/div[1]/div/div/div/button/i")
	public WebElement Shiftsearchclick;
	
	@FindBy(id="ContentPlaceHolder1_gvAutoShiftAllo_lnkASEdit_0")
	public WebElement Editbutton;
	
	@FindBy(id="ContentPlaceHolder1_btnUpdate")
	public WebElement Updatebutton;
	
	public final By AutoShftError= ById.xpath("//*[@id=\"ContentPlaceHolder1_lblErrorMsg\"]");
	
	@FindBy(id="ContentPlaceHolder1_btnCancelAdd")
	public WebElement Cancelbutton;

}
