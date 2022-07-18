package by.teachmeskills;

import by.teachmeskills.pages.AccountsPage;
import by.teachmeskills.pages.LoginPage;
import by.teachmeskills.pages.NewAccountModal;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void createAccountTest() {
        new LoginPage(driver).open()
                             .fillInUserName("qa14_onl_kz-swqa@force.com")
                             .fillInPassword("Qwerty123456")
                             .submitForm();
        new AccountsPage(driver).open()
                                .clickNewButton();

        Faker faker = new Faker();
        new NewAccountModal(driver).fillInNewAccountModal(faker.company().name(), faker.internet().url(),
                                           faker.phoneNumber().phoneNumber(), "Competitor")
                                   .saveAccount();
    }
}
