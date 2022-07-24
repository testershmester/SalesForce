package by.teachmeskills.pages;

import by.teachmeskills.dto.Account;
import by.teachmeskills.wrappers.AccountDropDown;
import by.teachmeskills.wrappers.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewAccountModal extends BasePage {

    @FindBy(xpath = "//button[@title='Save']")
    private WebElement saveButton;

    private final By accountInfoText = By.xpath("//span[text()='Account Information']");

    public NewAccountModal(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isPageOpened() {
        waitForPageLoaded();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(accountInfoText));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    @Override
    public NewAccountModal open() {
        driver.get(baseUrl + "lightning/o/Account/new");
        return this;
    }

    public NewAccountModal fillInNewAccountModal(Account account) {
        new Input(driver, "Account Name").fillIn(account.getAccountName());
        new Input(driver, "Website").fillIn(account.getWebSite());
        new AccountDropDown(driver, "Type").select(account.getType());
        return this;
    }

    public NewAccountModal saveAccount() {
        saveButton.click();
        return this;
    }
}
