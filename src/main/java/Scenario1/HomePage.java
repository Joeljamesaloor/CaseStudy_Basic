package Scenario1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage {
    WebDriver driver;
    By contactLink = By.xpath("//a[@href='https://automationpanda.com/contact/']");
    By contactTitle = By.xpath("//h1[@class='entry-title' and text()='Contact']");
    private final int TIMEOUT = 60; // Timeout in seconds

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnContactLink(){
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(contactLink));
        element.click();
    }

    public String getContactTitleText(){
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(contactTitle));
        return element.getText();
    }
}
