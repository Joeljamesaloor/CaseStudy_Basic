package Scenario2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.NoSuchElementException;

public class HomePage {
    WebDriver driver;

    By logo = By.xpath("//picture[@title='Flipkart']/img");
    By searchBox1 = By.className("Pke_EE");
    By productNameLocator = By.className("_4rR01T");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLogoDisplayed() {
        try {
            return driver.findElement(logo).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public int getProductCount() {
        List<WebElement> items = driver.findElements(productNameLocator);
        return items.size(); // Returns the number of product items found
    }

    public void enterSearchTerm(String searchTerm) {
        WebElement searchBoxElement = driver.findElement(searchBox1);
        searchBoxElement.sendKeys(searchTerm + Keys.ENTER);
    }


    public void clickFirstSearchItem() {
        List<WebElement> productElements = driver.findElements(productNameLocator);
        WebElement firstProductElement = productElements.get(0); // Get the first product element
        firstProductElement.click();
    }
}

