package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[p[text()='Manage News']]")
	private WebElement clickManageNews;
	@FindBy(xpath = "//a[text()=' New']")
	private WebElement clickNew;
	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement enterNews;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement clickSave;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertCheck;

	public ManageNewsPage clickManageNews() {
		clickManageNews.click();
		return this;

	}

	public ManageNewsPage clickNew() {
		clickNew.click();
		return this;
	}

	public ManageNewsPage enterNews(String textNews) {
		enterNews.sendKeys(textNews);
		return this;

	}

	public ManageNewsPage clickSave() {
		clickSave.click();
		return this;

	}

	public boolean isAlertDisplayed() {
		return alertCheck.isDisplayed();
	}
}
