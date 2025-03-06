package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	@Test(description = "Verification of User able to enter new News")
	public void verifyUserIsAbleToEnterNews(String textnews) throws IOException {

		LoginPage login = new LoginPage(driver);

		String username = ExcelUtility.getStringdata(1, 0, "LoginPage");
		String password = ExcelUtility.getStringdata(1, 1, "LoginPage");

		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
		
		String textNews = ExcelUtility.getStringdata(1, 0, "NewsPage"); 
		
		ManageNewsPage ManageNews = new ManageNewsPage(driver);
		ManageNews.clickManageNews().clickNew().enterNews(textNews).clickSave();
		
		boolean isAlertDisplayedforManagenews = ManageNews.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayedforManagenews, Messages.NEWSNOTADDED);

	}

}
