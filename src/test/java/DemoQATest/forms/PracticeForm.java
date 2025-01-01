package DemoQATest.forms;

import DemoQAPO.forms.PracticeFormPO;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class PracticeForm {
    WebDriver driver = new ChromeDriver();
    private PracticeFormPO practiceFormPage;

    @BeforeClass
    public void setup() {
        // Setup WebDriver
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demoqa.com/automation-practice-form");

        // Initialize Practice Form Page Object
        practiceFormPage = new PracticeFormPO(driver);
    }

    @Description("TC_01: Submit practice form with valid data")
    @Test
    public void TC_01_SubmitFormWithValidData() {
        practiceFormPage.enterFirstName("John");
        practiceFormPage.enterLastName("Doe");
        practiceFormPage.enterEmail("john.doe@example.com");
        practiceFormPage.selectGender("Male");
        practiceFormPage.enterMobileNumber("1234567890");
        practiceFormPage.enterDateOfBirth("01 Jan 2000");
        practiceFormPage.enterSubjects("Math");
//        practiceFormPage.selectHobby("Sports");
        practiceFormPage.uploadPicture(System.getProperty("user.home") + "/Downloads/sampleFile.jpeg");
        practiceFormPage.enterAddress("123 Elm Street");
        practiceFormPage.selectState("NCR");
        practiceFormPage.selectCity("Delhi");
        practiceFormPage.submitForm();

        assertTrue(practiceFormPage.isSuccessModalDisplayed(), "Form submission was not successful!");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
