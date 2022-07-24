package by.teachmeskills.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    private final By homeTabLocator = By.xpath("//one-app-nav-bar-item-root[contains(@class, 'slds-is-active')]//span[text()='Home']");

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isPageOpened() {
        waitForPageLoaded();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(homeTabLocator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public HomePage open() {
        driver.get(baseUrl + "lightning/page/home");
        return this;
    }
}
