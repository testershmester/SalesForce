package by.teachmeskills;

import by.teachmeskills.dto.Account;
import by.teachmeskills.steps.AccountSteps;
import by.teachmeskills.steps.LoginSteps;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccountsTest extends BaseTest {

    @BeforeMethod
    public void login() {
        new LoginSteps(driver).loginAsDefaultUser();
    }

    @Test
    public void createAccountTest() {
        Faker faker = new Faker();

        String accountName = faker.company().name();
        Account expAccount = new Account(accountName);
        expAccount.setAccountName(accountName);
        expAccount.setWebSite(faker.internet().url());
        expAccount.setType("Analyst");

        new AccountSteps(driver).createNewAccount(expAccount);
    }
}
