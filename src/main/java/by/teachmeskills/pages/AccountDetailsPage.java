package by.teachmeskills.pages;

import by.teachmeskills.dto.Account;
import by.teachmeskills.wrappers.AccountDetailsTextField;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountDetailsPage extends BasePage {

    private final By detailsTabLocator = By.xpath("//a[text()='Details']");
    private final By accCreationToastMsgLocator = By.xpath("//span[contains(@class,'toastMessage')]");

    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        waitForPageLoaded();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(detailsTabLocator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    @Override
    //TODO implement open method
    public AccountDetailsPage open() {
        return this;
    }

    public Account getAccountDetails() {
        Account account = new Account(getAccountName());
        account.setWebSite(getWebsite());
        account.setType(getType());
        return account;
    }

    public String getAccountName() {
        return new AccountDetailsTextField(driver, "Account Name").getNonClickableValue();
    }

    public String getType() {
        return new AccountDetailsTextField(driver, "Type").getNonClickableValue();
    }

    public String getWebsite() {
        return new AccountDetailsTextField(driver, "Website").getClickableValue();
    }

    public boolean isAccountCreationNotificationDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(accCreationToastMsgLocator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String getAccountCreationNotificationMessage() {
        return driver.findElement(accCreationToastMsgLocator).getText();
    }
}
