package Scenario1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactPage {
    WebDriver driver;
    By nameInput = By.id("g3-name");
    By emailInput = By.id("g3-email");
    By messageTextArea = By.id("contact-form-comment-g3-message");
    By submitButton = By.xpath("//button[contains(@class, 'wp-block-button__link') and contains(., 'Contact Me')]");
    By messageSent = By.id("contact-form-success-header");
    private final int TIMEOUT = 60; // Timeout in seconds

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
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    public void clickOnSubmit(){
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        element.click();
    }

    public boolean isMessageSentDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(messageSent)).isDisplayed();
    }
}
