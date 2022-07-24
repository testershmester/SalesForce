package by.teachmeskills.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactDropDown {

     WebDriver driver;
     String label;

     public ContactDropDown(WebDriver driver, String label) {
          this.driver = driver;
          this.label = label;
     }

     public ContactDropDown select(String option) {
          new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='salutation']")));
          driver.findElement(By.xpath("//button[@name='salutation']")).click();
          driver.findElement(By.xpath(String.format("//span[@title='%s']", option))).click();
          return this;
     }
}
