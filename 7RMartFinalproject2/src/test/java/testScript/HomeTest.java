package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {

	@Test(description = "Verification of User is able to logout from the application")

	public void verifyIsUserAbleToLogout() throws InterruptedException, IOException {

		LoginPage login = new LoginPage(driver);

		String username = ExcelUtility.getStringdata(1, 0, "LoginPage");
		String password = ExcelUtility.getStringdata(1, 1, "LoginPage");

		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();

		HomePage home = new HomePage(driver);
		home.verifyUserIsAbleToClickAdmin().verifyUserIsAbleToLogout();

		boolean isSignButtonDisplayed = home.isSignButtonDisplayed();
		Assert.assertTrue(isSignButtonDisplayed, Messages.LOGOUTFAILED);

	}

}
