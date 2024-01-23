package Scenario2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import java.util.NoSuchElementException;

public class HomePage {
    WebDriver driver;
    private final int TIMEOUT = 60; // Timeout in seconds

    By logo = By.xpath("//picture[@title='Flipkart']/img");
    By searchBox1 = By.className("Pke_EE");
    By productNameLocator = By.className("_4rR01T");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLogoDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
            WebElement logoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(logo));
            return logoElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public int getProductCount() {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        List<WebElement> items = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productNameLocator));
        return items.size(); // Returns the number of product items found
    }

    public void enterSearchTerm() {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        WebElement searchBoxElement = wait.until(ExpectedConditions.elementToBeClickable(searchBox1));
        searchBoxElement.sendKeys("iphone 14" + Keys.ENTER);
    }

    public void clickFirstSearchItem() {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        List<WebElement> productElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productNameLocator));
        WebElement firstProductElement = productElements.get(0); // Get the first product element
        firstProductElement.click();
    }
}
