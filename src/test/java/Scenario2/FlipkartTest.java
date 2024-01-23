package Scenario2;

import common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

public class FlipkartTest extends BaseTest {
    private HomePage homePage;
    private ProductPage productPage;
    private final String baseUrl = "https://www.flipkart.com/";

    @BeforeClass
    public void setup() {
        driver.get(baseUrl);
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
        homePage.enterSearchTerm();
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


}