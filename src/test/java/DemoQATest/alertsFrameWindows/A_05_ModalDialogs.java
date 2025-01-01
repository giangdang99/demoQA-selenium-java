package DemoQATest.alertsFrameWindows;

import DemoQAPO.alertsFrameWindows.ModalDialogsPO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class A_05_ModalDialogs {
    private WebDriver driver;
    private ModalDialogsPO modalDialogPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demoqa.com/modal-dialogs");

        modalDialogPage = new ModalDialogsPO(driver);
    }

    @Test
    public void TC_01_VerifySmallModalText() {
        modalDialogPage.openSmallModal();
        String smallModalText = modalDialogPage.getSmallModalText();
        Assert.assertTrue(smallModalText.contains("This is a small modal."), "Small modal text is incorrect");
        modalDialogPage.closeSmallModal();
    }

    @Test
    public void TC_02_VerifyLargeModalText() {
        modalDialogPage.openLargeModal();
        String largeModalText = modalDialogPage.getLargeModalText();
        Assert.assertTrue(largeModalText.contains("Lorem Ipsum is simply dummy text"), "Large modal text is incorrect");
        modalDialogPage.closeLargeModal();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}