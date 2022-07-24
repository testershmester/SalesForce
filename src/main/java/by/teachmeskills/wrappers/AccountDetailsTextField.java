package by.teachmeskills.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDetailsTextField {

    WebDriver driver;
    String label;

    public AccountDetailsTextField(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public String getNonClickableValue() {
        By fullLocator = By.xpath(String.format("//span[text()='%s']/ancestor::records-record-layout-item[contains(@class," +
                                                        " 'slds-form__item')]//lightning-formatted-text", label));
        return driver.findElement(fullLocator).getText();
    }

    public String getClickableValue() {
        By fullLocator = By.xpath(String.format("//span[text()='%s']/ancestor::records-record-layout-item[contains(@class," +
                                                        " 'slds-form__item')]//a", label));
        return driver.findElement(fullLocator).getText();
    }
}
