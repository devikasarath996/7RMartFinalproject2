package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {

	@Test(priority = 1, description = "Verification of User login with valid credentials", retryAnalyzer = retry.Retry.class)
	public void verifyUserLoginWithValidUsernameAndValidPassword() throws IOException {

		LoginPage login = new LoginPage(driver);

		String username = ExcelUtility.getStringdata(1, 0, "LoginPage");
		String password = ExcelUtility.getStringdata(1, 1, "LoginPage");

		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();

		String expected = "Dashboard | 7rmart supermarket";
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected, Messages.LOGINFAILED);
	}

	@Test(priority = 3, description = "Verification of User login with Invalid Username And Valid Password", groups = {
			"smoke" })
	public void verifyUserLoginWithInvalidUsernameAndValidPassword() throws IOException {
		LoginPage login = new LoginPage(driver);

		String username = ExcelUtility.getStringdata(2, 0, "LoginPage");
		String password = ExcelUtility.getStringdata(2, 1, "LoginPage");

		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();

		Assert.assertEquals(driver.getTitle(), "Login | 7rmart supermarket", Messages.INVALIDUSERNAMELOGIN);

	}

	@Test(priority = 4, description = "Verification of User login with Valid Username And Invalid Password", groups = {
			"smoke" })
	public void verifyUserWithValidUsernameAndInvalidPassword() throws IOException {
		LoginPage login = new LoginPage(driver);

		String username = ExcelUtility.getStringdata(3, 0, "LoginPage");
		String password = ExcelUtility.getStringdata(3, 1, "LoginPage");

		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();

		Assert.assertEquals(driver.getTitle(), "Login | 7rmart supermarket", Messages.INVALIDPASSWORDLOGIN);

	}

	@Test(priority = 2, description = "Verification of User login with Invalid Credentials", dataProvider = "loginProvider")
	public void verifyUserWithInvalidUsernameAndInvalidPassword(String username, String password) throws IOException {
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();

		Assert.assertEquals(driver.getTitle(), "Login | 7rmart supermarket", Messages.INVALIDPASSWORDANDUSERNAMELOGIN);

	}

	@DataProvider(name = "loginProvider") // mechanism to read data other than excel
	public Object[][] getDataFromDataProvider() throws IOException {
		return new Object[][] { new Object[] { "adminty67", "admin0987" }, new Object[] { "123", "123" },
				// return new Object[][] { new Object[] {ExcelUtility.getStringdata(3,
				// 0,"LoginPage"),ExcelUtility.getStringdata(3,1 ,"LoginPage")} //reading data
				// from excel, alternative method
		};
	}
}
