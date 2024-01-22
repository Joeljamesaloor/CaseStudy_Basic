package scenario1;

import Scenario1.ContactPage;
import Scenario1.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutomationTest {
    private WebDriver driver;
    private HomePage homePage;
    private ContactPage contactPage;
    private final String baseUrl = "https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/";

    @BeforeClass
    public void setup() {
        // Set the path for the chromedriver relative to the project root directory
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver"); // Ensure this path is correct

        // Initialize the ChromeDriver instance
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        homePage = new HomePage(driver);
        contactPage = new ContactPage(driver);
    }

    @Test(priority = 1)
    public void verifyContactTitle() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnContactLink();
        String expectedContactTitle = "CONTACT"; // The expected text of the <h1> element
        String contactTitleText = homePage.getContactTitleText();
        Assert.assertEquals(contactTitleText, expectedContactTitle, "The title of the contact page does not match the expected value.");
    }

    @Test(priority = 2)
    public void verifyContactPageFunctionality() {
        contactPage.fillFields("Joel James", "joeljames@virtusa.com", "Test message");
        contactPage.clickOnSubmit();
        Assert.assertTrue(contactPage.isMessageSentDisplayed());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
