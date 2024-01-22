package Scenario2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FlipkartTest {
    private WebDriver driver;
    private HomePage homePage;
    private ProductPage productPage;
    private final String baseUrl = "https://www.flipkart.com/";

    @BeforeClass
    public void setup() {
        // Set the path for the chromedriver
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

        // Initialize the ChromeDriver instance
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl); // Use baseUrl variable
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
    }

    @Test(priority = 1)
    public void verifyLogoPresence() {
        // Verify Flipkart logo is present on the page
        boolean isLogoDisplayed = homePage.isLogoDisplayed();
        Assert.assertTrue(isLogoDisplayed, "The logo is not displayed on the page.");
        System.out.println("Verified: Flipkart logo is displayed on the page.");
    }


    @Test(priority = 2)
    public void enterSearchTerm() {
        homePage.enterSearchTerm("iphone 14");
        System.out.println("Search term 'iphone 14' entered.");
    }

    @Test(priority = 3)
    public void clickFirstSearchItemAndVerify() {
        homePage.clickFirstSearchItem();
        int productCount = homePage.getProductCount();
        System.out.println("Total number of products displayed: " + productCount);
        productPage.switchToNewTab();
        String expectedTitle = "iPhone 14";
        String actualTitle = productPage.getPageTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Title of the new tab does not contain expected text.");
        System.out.println("Verified: Navigated to the correct page. Page title: " + actualTitle);

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}