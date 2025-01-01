package DemoQATest.alertsFrameWindows;

import DemoQAPO.alertsFrameWindows.FramesPO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class A_03_Frames {
    private WebDriver driver;
    private FramesPO framesPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demoqa.com/frames");

        framesPage = new FramesPO(driver);
    }

    @Test
    public void TC_01_VerifyFrame1Heading() {
        framesPage.switchToFrame1();
        String frame1Heading = framesPage.getFrameHeadingText();
        Assert.assertEquals(frame1Heading, "This is a sample page", "Frame 1 heading text is incorrect");
        framesPage.switchToMainContent();
    }

    @Test
    public void TC_02_VerifyFrame2Heading() {
        framesPage.switchToFrame2();
        String frame2Heading = framesPage.getFrameHeadingText();
        Assert.assertEquals(frame2Heading, "This is a sample page", "Frame 2 heading text is incorrect");
        framesPage.switchToMainContent();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
