package info.pojo;

import info.base.Reusableclass;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutoshiftOld_POJO extends Reusableclass
{
	public AutoshiftOld_POJO()
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
	
//	public final By AutoShftCode= ById.id("ContentPlaceHolder1_txtAutoShiftCode");
	
	@FindBy(id = "ContentPlaceHolder1_txtAddShiftName")
	public WebElement AutoShiftName;

	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_txtFromTime_0")
	public WebElement From;
	
	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_txtToTime_0")
	public WebElement To;

	@FindBy(id = "ContentPlaceHolder1_gvAutoShiftSettings_ddllistShifts_0_DropDiv")
	public WebElement ShiftDropDown;
	
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
	
	//*[@id="ContentPlaceHolder1_lblErrorMsg"]

}
