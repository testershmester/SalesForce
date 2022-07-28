package by.teachmeskills.pages;

import by.teachmeskills.dto.Account;
import by.teachmeskills.wrappers.AccountDetailsTextField;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
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
            log.debug("The page {} was opened successfully", "Account Details");
            return true;
        } catch (TimeoutException e) {
            log.error("The page {} was not opened because of error: {}", "Account Details", e.getMessage());
            return false;
        }
    }

    @Override
    //TODO implement open method
    public AccountDetailsPage open() {
        return this;
    }

    public Account getAccountDetails() {
        return Account.builder()
                      .accountName(getAccountName())
                      .type(getType())
                      .webSite(getWebsite())
                      .build();
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
