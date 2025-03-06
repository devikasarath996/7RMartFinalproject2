package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUserPage {

	WebDriver driver;
	PageUtility pageutility = new PageUtility();

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class=\"nav-icon fas fa-users\"]")
	private WebElement click_Admin;
	@FindBy(xpath = "(//a[text()=' New'])")
	private WebElement new_user;
	@FindBy(id = "username")
	private WebElement enterusername;
	@FindBy(id = "password")
	private WebElement enterpassword;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement dropdown_usertype;
	@FindBy(xpath = "(//*[@class='fa fa-save'])")
	private WebElement clicksave;

	@FindBy(xpath = "//*[@class='alert alert-success alert-dismissible']")
	private WebElement alertCheck;

	public HomePage clickAdmin() {
		click_Admin.click();
		return new HomePage(driver);
	}

	public AdminUserPage clickNew() {
		new_user.click();
		return this;
	}

	public AdminUserPage enterNewUserData(String newusername, String newpassword) {
		enterusername.sendKeys(newusername);
		enterpassword.sendKeys(newpassword);
		return this;
	}

	public AdminUserPage chooseUserDataType(String userType) {
		pageutility.selectByVisibleText(dropdown_usertype, userType);
		return this;
	}

	public AdminUserPage save_userdata() {
		clicksave.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alertCheck.isDisplayed();

	}

}
