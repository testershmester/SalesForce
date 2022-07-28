package by.teachmeskills;

import by.teachmeskills.dto.Account;
import by.teachmeskills.pages.AccountDetailsPage;
import by.teachmeskills.steps.AccountSteps;
import by.teachmeskills.steps.LoginSteps;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AccountsTest extends BaseTest {

    @BeforeMethod
    public void login() {
        new LoginSteps(driver).loginAsDefaultUser();
    }

    @Test
    public void createAccountTest() {
        Faker faker = new Faker();

        String accountName = faker.company().name();
        String url = faker.internet().url();

        Account expAccount = Account.builder()
                                    .accountName(accountName)
                                    .type("Analyst")
                                    .webSite(url)
                                    .build();

        AccountDetailsPage accountDetailsPage = new AccountSteps(driver).createNewAccount(expAccount);
        assertTrue(accountDetailsPage.isAccountCreationNotificationDisplayed(), "Notification is not displayed");
        String message = accountDetailsPage.getAccountCreationNotificationMessage();
        assertTrue(message.contains(accountName), "Notification does not contain account name");

        Account actAccount = accountDetailsPage.getAccountDetails();
        assertEquals(actAccount, expAccount, "Account was not created correctly");
    }
}
