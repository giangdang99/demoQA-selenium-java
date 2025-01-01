package DemoQATest.alertsFrameWindows;

import DemoQAPO.alertsFrameWindows.BrowserWindowsPO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class A_01_BrowserWindows {
    WebDriver driver = new ChromeDriver();
    private BrowserWindowsPO browserWindowsPage;

    @BeforeClass
    public void setup() {
        // Setup WebDriver
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demoqa.com/automation-practice-form");

        // Initialize Practice Form Page Object
        browserWindowsPage = new BrowserWindowsPO(driver);
    }

    @Test
    public void TC_01_OpenNewTab() {
        browserWindowsPage.clickNewTabButton();
        browserWindowsPage.switchToNewTabOrWindow();
        String actualText = browserWindowsPage.getNewTabOrWindowText();
        Assert.assertEquals(actualText, "This is a sample page", "New tab text is incorrect");
        browserWindowsPage.switchToMainWindow(); // Quay lại cửa sổ chính
    }

    @Test
    public void TC_02_OpenNewWindow() {
        browserWindowsPage.clickNewWindowButton();
        browserWindowsPage.switchToNewTabOrWindow();
        String actualText = browserWindowsPage.getNewTabOrWindowText();
        Assert.assertEquals(actualText, "This is a sample page", "New window text is incorrect");
        browserWindowsPage.switchToMainWindow(); // Quay lại cửa sổ chính
    }

    @Test
    public void TC_03_OpenWindowWithMessage() {
        browserWindowsPage.clickNewWindowMessageButton();
        browserWindowsPage.switchToNewTabOrWindow();
        String actualText = browserWindowsPage.getNewTabOrWindowText();
        Assert.assertTrue(actualText.contains("Knowledge increases by sharing"), "Window message is incorrect");
        browserWindowsPage.switchToMainWindow(); // Quay lại cửa sổ chính
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
