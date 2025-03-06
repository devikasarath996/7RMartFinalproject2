package testScript;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;

public class SubCategoryTest extends Base {
	@Test(description = "Verification of User able to add new item", groups = { "smoke" })
	public void verifyIsUserAbleToAddNewItemToSubCategory() throws AWTException, IOException {

		LoginPage login = new LoginPage(driver);

		String username = ExcelUtility.getStringdata(1, 0, "LoginPage");
		String password = ExcelUtility.getStringdata(1, 1, "LoginPage");

		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();

		SubCategoryPage category = new SubCategoryPage(driver);
		category.clickSubCategoryIcon().clickNewIcon().selectCategory();

		String enterName = ExcelUtility.getStringdata(1, 0, "SubCategoryPage");
		category.enterSubCategory(enterName).uploadImage().saveSelection();

		boolean isAlertDisplayedfornewSubCategory = category.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayedfornewSubCategory, Messages.NEWSUBCATEGORYNOTADDED);

	}

	@Test(description = "Verification of User able to search item", groups = { "smoke" })
	public void verifyUserIsAbleToSearchItem() throws IOException {
		LoginPage login = new LoginPage(driver);

		String username = ExcelUtility.getStringdata(1, 0, "LoginPage");
		String password = ExcelUtility.getStringdata(1, 1, "LoginPage");

		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();

		SubCategoryPage category = new SubCategoryPage(driver);
		category.chooseSubcategory().clickSearchIcon().chooseCategory();

		String inputSubCategory = ExcelUtility.getStringdata(1, 0, "SubCategoryPage");
		category.enterSubCategory(inputSubCategory).chooseSearch();

		boolean isSearchTableDisplayed = category.isTableDisplayed();
		Assert.assertTrue(isSearchTableDisplayed, Messages.TABLENOTDISPLAYED);

	}

	@Test(description = "Verify user is able to reset the existing search result")
	public void verifyUserIsAbleToResetItem() throws IOException {
		LoginPage login = new LoginPage(driver);

		String username = ExcelUtility.getStringdata(1, 0, "LoginPage");
		String password = ExcelUtility.getStringdata(1, 1, "LoginPage");

		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();

		SubCategoryPage category = new SubCategoryPage(driver);
		category.chooseSubcategory().clickSearchIcon().chooseCategory();

		String inputSubCategory = ExcelUtility.getStringdata(1, 0, "SubCategoryPage");
		category.enterSubCategory(inputSubCategory).chooseSearch().selectReset();
		boolean assertReset = category.isRestWorking();
		Assert.assertFalse(assertReset, Messages.RESETFAILED);

	}

}
