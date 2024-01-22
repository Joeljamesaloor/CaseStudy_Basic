package Scenario1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactPage {
    WebDriver driver;
    By nameInput = By.id("g3-name");
    By emailInput = By.id("g3-email");
    By messageTextArea = By.id("contact-form-comment-g3-message");
    By submitButton = By.xpath("//button[contains(@class, 'wp-block-button__link') and contains(., 'Contact Me')]");
    By messageSent = By.id("contact-form-success-header");

    public ContactPage(WebDriver driver){
        this.driver = driver;
    }

    // Method to fill all fields
    public void fillFields(String name, String email, String message) {
        enterText(nameInput, name);
        enterText(emailInput, email);
        enterText(messageTextArea, message);
    }
    // Helper method to enter text in a field
    private void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public void clickOnSubmit(){
        driver.findElement(submitButton).click();
    }

    public boolean isMessageSentDisplayed(){
        return driver.findElement(messageSent).isDisplayed();
    }
}

