package by.teachmeskills.pages;

import by.teachmeskills.wrappers.DropDown;
import by.teachmeskills.wrappers.Input;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAccountModal extends BasePage {

    @FindBy(xpath = "//button[@title='Save']")
    private WebElement saveButton;

    public NewAccountModal(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public NewAccountModal fillInNewAccountModal(String accountName, String website, String phone, String type) {
        new Input(driver, "Account Name").fillIn(accountName);
        new Input(driver, "Website").fillIn(website);
        new Input(driver, "Phone").fillIn(phone);
        new DropDown(driver, "Type").select(type);
        return this;
    }

    public NewAccountModal saveAccount() {
        saveButton.click();
        return this;
    }
}
