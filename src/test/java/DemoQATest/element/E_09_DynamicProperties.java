package DemoQATest.element;

import DemoQAPO.element.DynamicPropertiesPO;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class E_09_DynamicProperties {
    WebDriver driver = new ChromeDriver();
    private DynamicPropertiesPO dynamicPropertiesPage;

    @BeforeClass
    public void setup() {
        // Setup WebDriver
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demoqa.com/dynamic-properties");

        // Initialize Dynamic Properties Page Object
        dynamicPropertiesPage = new DynamicPropertiesPO(driver);
    }

    @Description("TC_01: Verify button becomes enabled after 5 seconds")
    @Test
    public void TC_01_VerifyButtonEnabledAfterDelay() {
        assertTrue(dynamicPropertiesPage.isButtonEnabledAfterDelay(), "Button did not become enabled after delay!");
    }

    @Description("TC_02: Verify button changes color dynamically")
    @Test
    public void TC_02_VerifyDynamicButtonColorChange() {
        assertTrue(dynamicPropertiesPage.isButtonColorChanged(), "Button color did not change dynamically!");
    }

    @Description("TC_03: Verify button becomes visible after delay")
    @Test
    public void TC_03_VerifyButtonVisibleAfterDelay() {
        assertTrue(dynamicPropertiesPage.isButtonVisibleAfterDelay(), "Button did not become visible after delay!");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}