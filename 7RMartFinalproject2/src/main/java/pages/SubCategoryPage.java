package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants.Constants;
import utilities.PageUtility;

public class SubCategoryPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();

	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[p[text()='Sub Category']]")
	private WebElement subCategory;
	@FindBy(xpath = "//a[text()=' New']")
	private WebElement clickNew;
	@FindBy(xpath = "//select[@id='cat_id']")
	private WebElement clickCategory;
	@FindBy(xpath = "//input[@class='form-control']")
	private WebElement clickSubCategory;
	@FindBy(xpath = "//input[@name='main_img']")
	private WebElement chooseImage;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement clickSave;

	// @FindBy(xpath = "//*[@class='alert alert-danger alert-dismissible']")
	// private WebElement alertCheck;

	@FindBy(xpath = "//a[p[text()='Sub Category']]")
	private WebElement subCategory1;
	@FindBy(xpath = "//a[text()=' Search']")
	private WebElement clickSearch;
	@FindBy(xpath = "//select[@class='form-control selectpicker']")
	private WebElement inputCategory;
	@FindBy(xpath = "//input[@class='form-control']")
	private WebElement enterSubCategory;
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement inputSearch;

	// @FindBy(xpath = "//a[p[text()='Sub Category']]")
	// private WebElement subCategory2;
	@FindBy(xpath = "//a[text()=' Reset']")
	private WebElement clickReset;

	@FindBy(xpath = "//*[text()=' Alert!']")
	private WebElement alertCheck;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td")
	private WebElement resultTable;
	@FindBy(xpath = "(//div[@class='row'])[2]")
	private WebElement resetAssert;

	public SubCategoryPage clickSubCategoryIcon() {
		subCategory.click();
		return this;
	}

	public SubCategoryPage clickNewIcon() {
		clickNew.click();
		return this;
	}

	public SubCategoryPage selectCategory() {

		pageutility.selectByVisibleText(clickCategory, "biscuit");
		return this;

	}

	public SubCategoryPage enterSubCategory(String enterName) {
		clickSubCategory.sendKeys(enterName);
		return this;
	}

	public SubCategoryPage uploadImage() {
		chooseImage.sendKeys(Constants.IMAGEFILE);
		return this;
	}

	public SubCategoryPage saveSelection() {
		clickSave.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alertCheck.isDisplayed();
	}

	public SubCategoryPage chooseSubcategory() {

		subCategory1.click();
		return this;
	}

	public SubCategoryPage clickSearchIcon() {
		clickSearch.click();
		return this;
	}

	public SubCategoryPage chooseCategory() {
		pageutility.selectByVisibleText(inputCategory, "biscuit");
		return this;

	}

	public SubCategoryPage inputSubCategory(String inputSubCategory) {
		enterSubCategory.sendKeys(inputSubCategory);
		return this;
	}

	public SubCategoryPage chooseSearch() {
		inputSearch.click();
		return this;
	}

	public boolean isTableDisplayed() {
		return resultTable.isDisplayed();
	}

	public SubCategoryPage selectReset() {
		clickReset.click();
		return this;
	}

	public boolean isRestWorking() {
		return resetAssert.isDisplayed();
	}

}
