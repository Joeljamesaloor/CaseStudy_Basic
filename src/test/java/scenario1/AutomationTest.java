package scenario1;

import Scenario1.ContactPage;
import Scenario1.HomePage;
import common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

public class AutomationTest extends BaseTest {
    private HomePage homePage;
    private ContactPage contactPage;
    private final String baseUrl = "https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/";

    @BeforeClass
    public void setup() {
        driver.get(baseUrl);
        homePage = new HomePage(driver);
        contactPage = new ContactPage(driver);
    }

    @Test(priority = 1)
    public void verifyContactTitle() throws InterruptedException {
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

}
