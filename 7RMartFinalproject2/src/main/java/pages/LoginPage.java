package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// to initialize elements
	}

	@FindBy(xpath = "//input[@name='username']")
	private WebElement usernamefield;// private given for security purpose
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordfield;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signinclick;

	public LoginPage enterUserNameOnUserNameField(String username) {
		usernamefield.sendKeys(username);
		return this;
	}

	public LoginPage enterPasswordOnPasswordField(String password) {
		passwordfield.sendKeys(password);
		return this;
	}

	public HomePage clickOnSignInButton() {
		signinclick.click();
		return new HomePage(driver);
	}
}
