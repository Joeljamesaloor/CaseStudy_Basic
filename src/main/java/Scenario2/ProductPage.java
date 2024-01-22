package Scenario2;

import org.openqa.selenium.WebDriver;
import java.util.ArrayList;

public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToNewTab() {
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); // Switch to second tab
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}

