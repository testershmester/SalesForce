package by.teachmeskills.steps;

import by.teachmeskills.pages.HomePage;
import by.teachmeskills.pages.LoginPage;
import by.teachmeskills.utils.PropertiesLoader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Properties;

public class LoginSteps {

    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String CONFIGURATION_PROPERTIES = "configuration.properties";

    WebDriver driver;
    LoginPage loginPage;

    public LoginSteps(WebDriver webDriver) {
        this.driver = webDriver;
        loginPage = new LoginPage(webDriver);
    }

    public void login(String username, String password) {
        loginPage.open()
                 .fillInUserName(username)
                 .fillInPassword(password)
                 .submitForm();
    }

    public void loginAsDefaultUser() {
        Properties properties = PropertiesLoader.loadProperties(CONFIGURATION_PROPERTIES);
        login(properties.getProperty(USERNAME), properties.getProperty(PASSWORD));
        Assert.assertTrue(new HomePage(driver).isPageOpened(), "Home page was not opened");
    }
}
