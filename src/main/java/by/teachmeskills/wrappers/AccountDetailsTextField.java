package by.teachmeskills.wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
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
        String locator = String.format("//span[text()='%s']/ancestor::records-record-layout-item[contains(@class," +
                                              " 'slds-form__item')]//a", label);
        By fullLocator = By.xpath(locator);
        log.info("The element will be found by xpath locator {}", locator);
        return driver.findElement(fullLocator).getText();
    }
}
