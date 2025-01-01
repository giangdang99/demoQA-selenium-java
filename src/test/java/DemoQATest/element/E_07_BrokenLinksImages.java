package DemoQATest.element;

import DemoQAPO.element.BrokenLinksImagesPO;
import DemoQAPUI.element.BrokenLinksImagesPUI;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class E_07_BrokenLinksImages {
    WebDriver driver = new ChromeDriver();
    private BrokenLinksImagesPO brokenLinksImagesPage;

    @BeforeClass
    public void setup() {
        // Setup WebDriver
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demoqa.com/broken");

        // Initialize Broken Links Images Page Object
        brokenLinksImagesPage = new BrokenLinksImagesPO(driver);
    }

    @Description("TC_01: Verify valid image")
    @Test
    public void TC_01_VerifyValidImage() {
        assertTrue(brokenLinksImagesPage.isValidImageDisplayed(), "Valid image is not displayed correctly!");
    }

//    @Description("TC_02: Verify broken image")
//    @Test
//    public void TC_02_VerifyBrokenImage() {
//        boolean isDisplayedCorrectly = brokenLinksImagesPage.isElementDisplayed(driver,BrokenLinksImagesPUI.BROKEN_IMAGE)
//                && brokenLinksImagesPage.isBrokenImageDisplayed();
//        assertTrue(isDisplayedCorrectly, "Broken image is not displayed correctly or missing!");
//    }


    @Description("TC_03: Verify valid link")
    @Test
    public void TC_03_VerifyValidLink() {
        brokenLinksImagesPage.clickValidLink();
        assertTrue(brokenLinksImagesPage.isValidLinkRedirected(), "Valid link did not redirect correctly!");
    }

    @Description("TC_04: Verify broken link")
    @Test
    public void TC_04_VerifyBrokenLink() {
        driver.navigate().back();
        brokenLinksImagesPage.clickBrokenLink();
        assertFalse(brokenLinksImagesPage.isBrokenLinkHandled(), "Broken link is not handled correctly!");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
