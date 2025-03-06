package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement clickAdmin;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	private WebElement clickLogout;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signinclick;
	@FindBy(xpath = "//p[text()='Manage Users']")
	private WebElement click_ManageUser;

	public HomePage verifyUserIsAbleToClickAdmin() {
		clickAdmin.click();
		return this;
	}

	public LoginPage verifyUserIsAbleToLogout() {
		clickLogout.click();
		return new LoginPage(driver);

	}

	public boolean isSignButtonDisplayed() {
		return signinclick.isDisplayed();

	}

	public AdminUserPage clickManageUser() {
		click_ManageUser.click();
		return new AdminUserPage(driver);
	}

}