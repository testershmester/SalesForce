package by.teachmeskills.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDropDown {

    WebDriver driver;
    String label;

    public AccountDropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public AccountDropDown select(String option) {
        By fullLocator = By.xpath(String.format("//span[text()='%s']//ancestor::div[contains(@class,'uiInput')]//a", label));
        driver.findElement(fullLocator).click();
        driver.findElement(By.xpath(String.format("//div[contains(@class, 'visible')]//a[@title='%s']", option))).click();
        return this;
    }
}
