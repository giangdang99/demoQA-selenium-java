package DemoQATest.alertsFrameWindows;

import DemoQAPO.alertsFrameWindows.AlertsPO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class A_02_Alerts {
    WebDriver driver = new ChromeDriver();
    private AlertsPO alertsPage;

    @BeforeClass
    public void setup() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demoqa.com/alerts");
        alertsPage = new AlertsPO(driver);
    }

    @Test
    public void TC_01_HandleAlert() {
        alertsPage.clickAlertButton();
        alertsPage.handleAlert(true, null);
    }

    @Test
    public void TC_02_HandleTimerAlert() {
        alertsPage.clickTimerAlertButton();
        alertsPage.handleAlert(true, null);
    }

    @Test
    public void TC_03_HandleConfirm() {
        alertsPage.clickConfirmButton();
        alertsPage.handleAlert(false, null);
        String result = alertsPage.getConfirmResultText();
        Assert.assertTrue(result.contains("Cancel"), "Confirm result is incorrect");
    }

    @Test
    public void TC_04_HandlePrompt() {
        String inputText = "Test Prompt";
        alertsPage.clickPromptButton();
        alertsPage.handleAlert(true, inputText);
        String result = alertsPage.getPromptResultText();
        Assert.assertTrue(result.contains(inputText), "Prompt result is incorrect");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}