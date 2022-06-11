package info.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import info.base.Reusableclass;

public class User_POJO extends Reusableclass
{

	public User_POJO() 
	{

		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "txtLogin")
	public WebElement Username;

	@FindBy(id = "txtPassword")
	public WebElement password;

	@FindBy(id = "btnLogin")
	public WebElement click; /*Login*/

	@FindBy(xpath = "//img[@src='../../../Artifacts/images/ChangeCustomer.svg']")
	public WebElement ChangeDB;

	@FindBy(id = "txtCustomerSearch")
	public WebElement DBname;

	@FindBy(xpath = "//*[@id=\"tblCustomerList\"]/tbody/tr[1]/td/li/a")
	public WebElement DBnameselect;

	@FindBy(id = "txtCustomerSearch")
	public WebElement DBnameenter;

	@FindBy(xpath = "//*[@id=\"tblCustomerList\"]/tbody/tr[1]/td/li/a")
	public WebElement DBnameselectteja;

	@FindBy(xpath = "//main//div//tr//td[@class='ng-binding']")
	public WebElement ClickEmail;

	@FindBy(xpath = "//span[normalize-space()='Logout']")
	public WebElement logoutuser;

	@FindBy(xpath = "(//a[@class='btn bgSuccess'])[2]")
	public WebElement changepassworduser;

	@FindBy(xpath = "(//input[@class='form-control'])[1]")
	public WebElement currentpassworduser;

	@FindBy(id = "ContentPlaceHolder1_tabContainer_tabProfile_txtNewPassword")
	public WebElement newpasschangeuser;

	@FindBy(id = "ContentPlaceHolder1_tabContainer_tabProfile_txtReEnterPassword")
	public WebElement renewpasschangeuser;

	@FindBy(id = "ContentPlaceHolder1_tabContainer_tabProfile_btnSavePassword")
	public WebElement savechangepassworduser;

	@FindBy(id="inbox_field")
	public WebElement SearchMailinator;

	public void setUsername(WebElement username) {
		Username = username;
	}

	public void setPassword(WebElement password) {
		this.password = password;
	}

	public void setClick(WebElement click) {
		this.click = click;
	}

	public void setChangeDB(WebElement changeDB) {
		ChangeDB = changeDB;
	}

	public void setDBname(WebElement dBname) {
		DBname = dBname;
	}

	public void setDBnameselect(WebElement dBnameselect) {
		DBnameselect = dBnameselect;
	}

	public void setDBnameenter(WebElement dBnameenter) {
		DBnameenter = dBnameenter;
	}

	public void setDBnameselectteja(WebElement dBnameselectteja) {
		DBnameselectteja = dBnameselectteja;
	}

	public void setClickEmail(WebElement clickEmail) {
		ClickEmail = clickEmail;
	}

	public void setLogoutuser(WebElement logoutuser) {
		this.logoutuser = logoutuser;
	}

	public void setChangepassworduser(WebElement changepassworduser) {
		this.changepassworduser = changepassworduser;
	}

	public void setCurrentpassworduser(WebElement currentpassworduser) {
		this.currentpassworduser = currentpassworduser;
	}

	public void setNewpasschangeuser(WebElement newpasschangeuser) {
		this.newpasschangeuser = newpasschangeuser;
	}

	public void setRenewpasschangeuser(WebElement renewpasschangeuser) {
		this.renewpasschangeuser = renewpasschangeuser;
	}

	public void setSavechangepassworduser(WebElement savechangepassworduser) {
		this.savechangepassworduser = savechangepassworduser;
	}

	public void setSearchMailinator(WebElement searchMailinator) {
		SearchMailinator = searchMailinator;
	}

	public void setScrollmailinator(WebElement scrollmailinator) {
		this.scrollmailinator = scrollmailinator;
	}

	public void setMailinatorname(WebElement mailinatorname) {
		this.mailinatorname = mailinatorname;
	}

	public void setNewpasswordreset(WebElement newpasswordreset) {
		Newpasswordreset = newpasswordreset;
	}

	public void setReNewpasswordreset(WebElement reNewpasswordreset) {
		ReNewpasswordreset = reNewpasswordreset;
	}

	public void setSavepasswordreset(WebElement savepasswordreset) {
		this.savepasswordreset = savepasswordreset;
	}

	public void setFrames(WebElement frames) {
		this.frames = frames;
	}

	public void setMailinatorresetpass(WebElement mailinatorresetpass) {
		this.mailinatorresetpass = mailinatorresetpass;
	}

	public void setMailinatorvisiblemail(WebElement mailinatorvisiblemail) {
		this.mailinatorvisiblemail = mailinatorvisiblemail;
	}

	public void setAdministrator(WebElement administrator) {
		Administrator = administrator;
	}

	public void setUserCreation(WebElement userCreation) {
		UserCreation = userCreation;
	}

	public void setNewUser(WebElement newUser) {
		NewUser = newUser;
	}

	public void setDisplayname(WebElement displayname) {
		Displayname = displayname;
	}

	public void setAllowloginusingcheckbox(WebElement allowloginusingcheckbox) {
		this.allowloginusingcheckbox = allowloginusingcheckbox;
	}

	public void setPrimaryemail(WebElement primaryemail) {
		this.primaryemail = primaryemail;
	}

	public void setMobilearea(WebElement mobilearea) {
		this.mobilearea = mobilearea;
	}

	public void setMobilenumber(WebElement mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public void setShowbasicsalary(WebElement showbasicsalary) {
		this.showbasicsalary = showbasicsalary;
	}

	public void setAllowlockattendencedetails(WebElement allowlockattendencedetails) {
		this.allowlockattendencedetails = allowlockattendencedetails;
	}

	public void setAllowunlockattendencedetails(WebElement allowunlockattendencedetails) {
		this.allowunlockattendencedetails = allowunlockattendencedetails;
	}

	public void setAppAccess(WebElement appAccess) {
		AppAccess = appAccess;
	}

	public void setETms(WebElement eTms) {
		ETms = eTms;
	}

	public void setELeave(WebElement eLeave) {
		ELeave = eLeave;
	}

	public void setEPayroll(WebElement ePayroll) {
		EPayroll = ePayroll;
	}

	public void setEAttendence(WebElement eAttendence) {
		EAttendence = eAttendence;
	}

	public void setEClaim(WebElement eClaim) {
		EClaim = eClaim;
	}

	public void setEAppraisal(WebElement eAppraisal) {
		EAppraisal = eAppraisal;
	}

	public void setAppAccessSave(WebElement appAccessSave) {
		AppAccessSave = appAccessSave;
	}

	public void setAppAccessCancel(WebElement appAccessCancel) {
		AppAccessCancel = appAccessCancel;
	}

	public void setCompanyAcess(WebElement companyAcess) {
		CompanyAcess = companyAcess;
	}

	public void setSelectcompany(WebElement selectcompany) {
		Selectcompany = selectcompany;
	}

	public void setCompanyAccessSave(WebElement companyAccessSave) {
		CompanyAccessSave = companyAccessSave;
	}

	public void setCompanyAccessCancel(WebElement companyAccessCancel) {
		CompanyAccessCancel = companyAccessCancel;
	}

	public void setDepartmentAccess(WebElement departmentAccess) {
		DepartmentAccess = departmentAccess;
	}

	public void setETmsSuperadmin(WebElement eTmsSuperadmin) {
		ETmsSuperadmin = eTmsSuperadmin;
	}

	public void setELeaveSuperadmin(WebElement eLeaveSuperadmin) {
		ELeaveSuperadmin = eLeaveSuperadmin;
	}

	public void setEPayrollSuperadmin(WebElement ePayrollSuperadmin) {
		EPayrollSuperadmin = ePayrollSuperadmin;
	}

	public void setEAttendenceSuperadmin(WebElement eAttendenceSuperadmin) {
		EAttendenceSuperadmin = eAttendenceSuperadmin;
	}

	public void setEClaimSuperadmin(WebElement eClaimSuperadmin) {
		EClaimSuperadmin = eClaimSuperadmin;
	}

	public void setEAppraisalSuperadmin(WebElement eAppraisalSuperadmin) {
		EAppraisalSuperadmin = eAppraisalSuperadmin;
	}

	public void setDepartmentAccessSave(WebElement departmentAccessSave) {
		DepartmentAccessSave = departmentAccessSave;
	}

	public void setDepartmentAccessCancel(WebElement departmentAccessCancel) {
		DepartmentAccessCancel = departmentAccessCancel;
	}

	public void setLocationAccess(WebElement locationAccess) {
		LocationAccess = locationAccess;
	}

	public void setLocationAll(WebElement locationAll) {
		LocationAll = locationAll;
	}

	public void setLocationSave(WebElement locationSave) {
		LocationSave = locationSave;
	}

	public void setLocationDelete(WebElement locationDelete) {
		LocationDelete = locationDelete;
	}

	@FindBy(xpath = "(//a[@rel='nofollow'])[5]")
	public WebElement scrollmailinator;

	@FindBy(xpath = "//td[@class='ng-binding']")
	public WebElement mailinatorname;

	@FindBy(id = "txtNewPassword")
	public WebElement Newpasswordreset;

	@FindBy(id = "txtReEnterPassword")
	public WebElement ReNewpasswordreset;

	@FindBy(id = "btnSavePassword")
	public WebElement savepasswordreset;

	@FindBy(xpath = "(//iframe[@title='HTML Email Message Body'])[1]")
	public WebElement frames;

	@FindBy(xpath = "(//a[contains(text(),'click here')])[1]")
	public WebElement mailinatorresetpass;

	@FindBy(xpath = "//td[@class='ng-binding']")
	public WebElement mailinatorvisiblemail;

	@FindBy(xpath = "(//span[@class='title'])[9]")
	public WebElement Administrator;

	@FindBy(xpath = "//a[@menu-caption='User Creation']")
	public WebElement UserCreation;

	@FindBy(id = "ContentPlaceHolder1_tabUsers_tabActiveUsers_lnkManage")
	public WebElement NewUser;

	@FindBy(id = "ContentPlaceHolder1_TabContainer1_TabPanel_Main_txtDisplayName")
	public WebElement Displayname;

	@FindBy(id = "chkIsMobNoLoginEnabled")
	public WebElement allowloginusingcheckbox;

	@FindBy(id = "ContentPlaceHolder1_TabContainer1_TabPanel_Main_txtEmail")
	public WebElement primaryemail;

	@FindBy(xpath = "//*[@id=\"ddlMobISO\"]/option[102]")
	public WebElement mobilearea;

	@FindBy(id = "txtMobileNo")
	public WebElement mobilenumber;

	@FindBy(id = "ContentPlaceHolder1_TabContainer1_TabPanel_Main_chkShowBasicSalary")
	public WebElement showbasicsalary;

	@FindBy(id = "ContentPlaceHolder1_TabContainer1_TabPanel_Main_chkAllowtolockAtd")
	public WebElement allowlockattendencedetails;

	@FindBy(id = "ContentPlaceHolder1_TabContainer1_TabPanel_Main_chkAllowtoUnlockAtd")
	public WebElement allowunlockattendencedetails;

	@FindBy(id = "__tab_ContentPlaceHolder1_TabContainer1_TabPanel_AppRights")
	public WebElement AppAccess;

	@FindBy(id = "ContentPlaceHolder1_TabContainer1_TabPanel_AppRights_dlETMSAccess")
	public WebElement ETms;

	@FindBy(id = "ContentPlaceHolder1_TabContainer1_TabPanel_AppRights_dlELeaveAccess")
	public WebElement ELeave;

	@FindBy(id = "ContentPlaceHolder1_TabContainer1_TabPanel_AppRights_dlEPayrollAccess")
	public WebElement EPayroll;

	@FindBy(id = "ContentPlaceHolder1_TabContainer1_TabPanel_AppRights_dlMobileAttendanceAccess")
	public WebElement EAttendence;

	@FindBy(id = "ContentPlaceHolder1_TabContainer1_TabPanel_AppRights_dlEClaimAccess")
	public WebElement EClaim;

	@FindBy(id = "ContentPlaceHolder1_TabContainer1_TabPanel_AppRights_dlEAppraisalAccess")
	public WebElement EAppraisal;

	@FindBy(id = "ContentPlaceHolder1_btnSave")
	public WebElement AppAccessSave;

	@FindBy(id = "ContentPlaceHolder1_btnCancel")
	public WebElement AppAccessCancel;

	@FindBy(id = "__tab_ContentPlaceHolder1_TabContainer1_TabPanel_CompanyRights")
	public WebElement CompanyAcess;

	@FindBy(id = "ContentPlaceHolder1_TabContainer1_TabPanel_CompanyRights_gvCompany_chkCompany_0")
	public WebElement Selectcompany;

	@FindBy(id = "ContentPlaceHolder1_btnSave")
	public WebElement CompanyAccessSave;

	@FindBy(id = "ContentPlaceHolder1_btnCancel")
	public WebElement CompanyAccessCancel;

	@FindBy(xpath= "//a[@id='__tab_ContentPlaceHolder1_TabContainer1_TabPanel_UserRights']")
	public WebElement DepartmentAccess;

	@FindBy(id = "ContentPlaceHolder1_TabContainer1_TabPanel_UserRights_chkETMSIsSuperAdmin")
	public WebElement ETmsSuperadmin;

	@FindBy(id = "ContentPlaceHolder1_TabContainer1_TabPanel_UserRights_chkELEAVEIsSuperAdmin")
	public WebElement ELeaveSuperadmin;

	@FindBy(id = "ContentPlaceHolder1_TabContainer1_TabPanel_UserRights_chkEPAYROLLIsSuperAdmin")
	public WebElement EPayrollSuperadmin;

	@FindBy(id = "ContentPlaceHolder1_TabContainer1_TabPanel_UserRights_chkMOBILEATTENDANCEIsSuperAdmin")
	public WebElement EAttendenceSuperadmin;

	@FindBy(id = "ContentPlaceHolder1_TabContainer1_TabPanel_UserRights_chkECLAIMIsSuperAdmin")
	public WebElement EClaimSuperadmin;

	@FindBy(id = "ContentPlaceHolder1_TabContainer1_TabPanel_UserRights_chkEAPPRAISALIsSuperAdmin")
	public WebElement EAppraisalSuperadmin;

	@FindBy(id = "ContentPlaceHolder1_btnSave")
	public WebElement DepartmentAccessSave;

	@FindBy(id = "ContentPlaceHolder1_btnCancel")
	public WebElement DepartmentAccessCancel;

	@FindBy(xpath= "//a[@id='__tab_ContentPlaceHolder1_TabContainer1_tbpLocationAccess']")
	public WebElement LocationAccess;

	@FindBy(id = "chkLocationAll")
	public WebElement LocationAll;

	@FindBy(id = "ContentPlaceHolder1_btnSave")
	public WebElement LocationSave;

	@FindBy(id = "ContentPlaceHolder1_btnCancel")
	public WebElement LocationDelete;

	public WebElement getUsername() {
		return Username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getClick() {
		return click;
	}

	public WebElement getChangeDB() {
		return ChangeDB;
	}

	public WebElement getDBname() {
		return DBname;
	}

	public WebElement getDBnameselect() {
		return DBnameselect;
	}

	public WebElement getDBnameenter() {
		return DBnameenter;
	}

	public WebElement getDBnameselectteja() {
		return DBnameselectteja;
	}

	public WebElement getClickEmail() {
		return ClickEmail;
	}

	public WebElement getLogoutuser() {
		return logoutuser;
	}

	public WebElement getChangepassworduser() {
		return changepassworduser;
	}

	public WebElement getCurrentpassworduser() {
		return currentpassworduser;
	}

	public WebElement getNewpasschangeuser() {
		return newpasschangeuser;
	}

	public WebElement getRenewpasschangeuser() {
		return renewpasschangeuser;
	}

	public WebElement getSavechangepassworduser() {
		return savechangepassworduser;
	}

	public WebElement getSearchMailinator() {
		return SearchMailinator;
	}

	public WebElement getScrollmailinator() {
		return scrollmailinator;
	}

	public WebElement getMailinatorname() {
		return mailinatorname;
	}

	public WebElement getNewpasswordreset() {
		return Newpasswordreset;
	}

	public WebElement getReNewpasswordreset() {
		return ReNewpasswordreset;
	}

	public WebElement getSavepasswordreset() {
		return savepasswordreset;
	}

	public WebElement getFrames() {
		return frames;
	}

	public WebElement getMailinatorresetpass() {
		return mailinatorresetpass;
	}

	public WebElement getMailinatorvisiblemail() {
		return mailinatorvisiblemail;
	}

	public WebElement getAdministrator() {
		return Administrator;
	}

	public WebElement getUserCreation() {
		return UserCreation;
	}

	public WebElement getNewUser() {
		return NewUser;
	}

	public WebElement getDisplayname() {
		return Displayname;
	}

	public WebElement getAllowloginusingcheckbox() {
		return allowloginusingcheckbox;
	}

	public WebElement getPrimaryemail() {
		return primaryemail;
	}

	public WebElement getMobilearea() {
		return mobilearea;
	}

	public WebElement getMobilenumber() {
		return mobilenumber;
	}

	public WebElement getShowbasicsalary() {
		return showbasicsalary;
	}

	public WebElement getAllowlockattendencedetails() {
		return allowlockattendencedetails;
	}

	public WebElement getAllowunlockattendencedetails() {
		return allowunlockattendencedetails;
	}

	public WebElement getAppAccess() {
		return AppAccess;
	}

	public WebElement getETms() {
		return ETms;
	}

	public WebElement getELeave() {
		return ELeave;
	}

	public WebElement getEPayroll() {
		return EPayroll;
	}

	public WebElement getEAttendence() {
		return EAttendence;
	}

	public WebElement getEClaim() {
		return EClaim;
	}

	public WebElement getEAppraisal() {
		return EAppraisal;
	}

	public WebElement getAppAccessSave() {
		return AppAccessSave;
	}

	public WebElement getAppAccessCancel() {
		return AppAccessCancel;
	}

	public WebElement getCompanyAcess() {
		return CompanyAcess;
	}

	public WebElement getSelectcompany() {
		return Selectcompany;
	}

	public WebElement getCompanyAccessSave() {
		return CompanyAccessSave;
	}

	public WebElement getCompanyAccessCancel() {
		return CompanyAccessCancel;
	}

	public WebElement getDepartmentAccess() {
		return DepartmentAccess;
	}

	public WebElement getETmsSuperadmin() {
		return ETmsSuperadmin;
	}

	public WebElement getELeaveSuperadmin() {
		return ELeaveSuperadmin;
	}

	public WebElement getEPayrollSuperadmin() {
		return EPayrollSuperadmin;
	}

	public WebElement getEAttendenceSuperadmin() {
		return EAttendenceSuperadmin;
	}

	public WebElement getEClaimSuperadmin() {
		return EClaimSuperadmin;
	}

	public WebElement getEAppraisalSuperadmin() {
		return EAppraisalSuperadmin;
	}

	public WebElement getDepartmentAccessSave() {
		return DepartmentAccessSave;
	}

	public WebElement getDepartmentAccessCancel() {
		return DepartmentAccessCancel;
	}

	public WebElement getLocationAccess() {
		return LocationAccess;
	}

	public WebElement getLocationAll() {
		return LocationAll;
	}

	public WebElement getLocationSave() {
		return LocationSave;
	}

	public WebElement getLocationDelete() {
		return LocationDelete;
	}


	
}
