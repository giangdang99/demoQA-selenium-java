package DemoQATest.element;

import DemoQAPO.element.RadioButtonPO;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class E_03_RadioButton {
    WebDriver driver = new ChromeDriver();
    private RadioButtonPO RadioButtonPage;


    @BeforeClass
    public void setup() {
        // Cài đặt đường dẫn WebDriver
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // Mở URL
        driver.get("https://demoqa.com/radio-button");

        // Initialize the page object for TextBox
        RadioButtonPage = new RadioButtonPO(driver);
    }

    @Description("TC_01: Click to radio button Yes")
    @Test
    public void TC_01_ClickToYes() {
        RadioButtonPage.clickToRadioButtonYes();
        String textExpect = "You have selected Yes";
        assertEquals(RadioButtonPage.getTextOfResult(), textExpect, "Result not match text expect");
    }

    @Description("TC_02: Click to radio button Impressive")
    @Test
    public void TC_02_ClickToImpressive() {
        driver.navigate().refresh();
        RadioButtonPage.clickToRadioButtonImpressive();
        String textExpect = "You have selected Impressive";
        assertEquals(RadioButtonPage.getTextOfResult(), textExpect, "Result not match text expect");
    }



    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
