package DemoQATest.alertsFrameWindows;

import DemoQAPO.alertsFrameWindows.NestedFramesPO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class A_04_NestedFrames {
    private WebDriver driver;
    private NestedFramesPO nestedFramesPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demoqa.com/nestedframes");

        nestedFramesPage = new NestedFramesPO(driver);
    }

    @Test
    public void TC_01_VerifyParentFrameText() {
        nestedFramesPage.switchToParentFrame();
        String parentText = nestedFramesPage.getParentFrameText();
        Assert.assertTrue(parentText.contains("Parent frame"), "Parent frame text is incorrect");
        nestedFramesPage.switchToMainContent();
    }

    @Test
    public void TC_02_VerifyChildFrameText() {
        nestedFramesPage.switchToParentFrame();
        nestedFramesPage.switchToChildFrame();
        String childText = nestedFramesPage.getChildFrameText();
        Assert.assertTrue(childText.contains("Child Iframe"), "Child frame text is incorrect");
        nestedFramesPage.switchToMainContent();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
