package Scenario1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    By contactLink = By.xpath("//a[@href='https://automationpanda.com/contact/']");
    By contactTitle = By.xpath("//h1[@class='entry-title' and text()='Contact']");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnContactLink(){
        driver.findElement(contactLink).click();
    }

    public String getContactTitleText(){
        return driver.findElement(contactTitle).getText();
    }
}
