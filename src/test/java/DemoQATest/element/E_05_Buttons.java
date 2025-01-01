package DemoQATest.element;

import DemoQAPO.element.ButtonsPO;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class E_05_Buttons {
    WebDriver driver = new ChromeDriver();
    private ButtonsPO buttonsPage;

    @BeforeClass
    public void setup() {
        // Setup WebDriver
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demoqa.com/buttons");

        // Initialize Buttons Page Object
        buttonsPage = new ButtonsPO(driver);
    }

    @Description("TC_01: Double click button")
    @Test
    public void TC_01_DoubleClickButton() {
        buttonsPage.doubleClickButton();
        assertTrue(buttonsPage.isDoubleClickMessageDisplayed(), "Double click message is not displayed!");
    }

    @Description("TC_02: Right click button")
    @Test
    public void TC_02_RightClickButton() {
        buttonsPage.rightClickButton();
        assertTrue(buttonsPage.isRightClickMessageDisplayed(), "Right click message is not displayed!");
    }

    @Description("TC_03: Dynamic click button")
    @Test
    public void TC_03_DynamicClickButton() {
        buttonsPage.dynamicClickButton();
        assertTrue(buttonsPage.isDynamicClickMessageDisplayed(), "Dynamic click message is not displayed!");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}