package testScript;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.AdminUserPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUserTest extends Base {
	@Test(description = "Add new user to the admin user page")
	public void verifyUserIsAbleToAddNewUser() throws IOException {

		LoginPage login = new LoginPage(driver);

		String username = ExcelUtility.getStringdata(1, 0, "LoginPage");
		String password = ExcelUtility.getStringdata(1, 1, "LoginPage");

		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();

		AdminUserPage admin = new AdminUserPage(driver);
		admin.clickAdmin().clickManageUser().clickNew();

		FakerUtility faker = new FakerUtility();
		String newusername = faker.createUserName();
		String newpassword = faker.createPassword();

		admin.enterNewUserData(newusername, newpassword).chooseUserDataType("Staff").save_userdata();

		boolean isAlertCheck = admin.isAlertDisplayed();
		Assert.assertTrue(isAlertCheck, Messages.NEWUSERNOTADDED);

	}

}
