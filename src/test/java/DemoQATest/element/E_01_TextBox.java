package DemoQATest.element;

import DemoQAPO.element.TextBoxPO;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class E_01_TextBox {
    WebDriver driver = new ChromeDriver();
    private TextBoxPO textBoxPage;
    String fullName = "John Doe";
    String email = "john.doe@example.com";
    String currentAddress = "123 Main Street";
    String permanentAddress = "456 Elm Street";
    String emailInvalid = "john.doe@example";


    @BeforeClass
    public void setup() {
        // Cài đặt đường dẫn WebDriver
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Mở URL
        driver.get("https://demoqa.com/text-box");

        // Initialize the page object for TextBox
        textBoxPage = new TextBoxPO(driver);
    }

    @Description("TC_01: Input information is valid")
    @Test
    public void TC_01_InputInfoValid() {
        textBoxPage.inputToAllFields(fullName, email, currentAddress, permanentAddress);
        textBoxPage.sleepInSecond(2);

        // Click the submit button
        textBoxPage.clickToSubmit();
        textBoxPage.sleepInSecond(10);

        // Verify results after submitting
        assertEquals(textBoxPage.getTextOfUsername(), fullName, "Full name does not match!");
        assertEquals(textBoxPage.getTextOfEmail(), email, "Email does not match!");
        assertEquals(textBoxPage.getTextOfCurrentAddress(), currentAddress, "Current Address does not match!");
        assertEquals(textBoxPage.getTextOfPermanentAddress(), permanentAddress, "Permanent Address does not match!");
    }

    @Description("TC_01: Input email is invalid")
    @Test
    public void TC_02_InputEmailInvalid() {
        driver.navigate().refresh();

        textBoxPage.inputToAllFields(fullName, emailInvalid, currentAddress, permanentAddress);
        textBoxPage.sleepInSecond(5);

        // Click the submit button
        textBoxPage.clickToSubmit();
    }


    @Description("TC_01: Input information is valid")
    @Test
    public void TC_03_InputInfoSpace() {
        textBoxPage.inputToAllFields(" ", " ", " ", " ");

        // Click the submit button
        textBoxPage.clickToSubmit();
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
