package by.teachmeskills.steps;

import by.teachmeskills.dto.Account;
import by.teachmeskills.pages.AccountDetailsPage;
import by.teachmeskills.pages.AccountsPage;
import by.teachmeskills.pages.NewAccountModal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AccountSteps {

    WebDriver driver;
    WebDriverWait wait;

    public AccountSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public AccountDetailsPage createNewAccount(Account account) {
        AccountsPage accountsPage = new AccountsPage(driver);
        if (!accountsPage.isPageOpened()) {
            accountsPage.open();
            Assert.assertTrue(accountsPage.isPageOpened(), "Account page is not opened");
        }
        NewAccountModal accountModal = accountsPage.clickNewButton();
        Assert.assertTrue(accountModal.isPageOpened(), "Account modal dialog is not opened");
        accountModal.fillInNewAccountModal(account)
                    .saveAccount();
        return new AccountDetailsPage(driver);
    }
}
