package info.pojo;

import info.base.Reusableclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImportStaffProfile_POJO extends Reusableclass
{
	public ImportStaffProfile_POJO()
	{		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[contains(text(),'Master')]")
	public WebElement MasterMenu;
	
	@FindBy(xpath = "//a[@data-text='~/CommonMasters/EmpImportProfile.aspx']")
	public WebElement EmpImportProfileMenu;
		
	@FindBy(id = "ContentPlaceHolder1_btnSubmit")
	public WebElement Submit;
	
	
	
	
}
