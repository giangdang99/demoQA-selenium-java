package DemoQATest.element;

import DemoQAPO.element.WebTablesPO;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class E_04_WebTables {
    WebDriver driver = new ChromeDriver();
    private WebTablesPO webTablesPage;

    @BeforeClass
    public void setup() {
        // Setup WebDriver
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demoqa.com/webtables");

        // Initialize WebTables Page Object
        webTablesPage = new WebTablesPO(driver);
    }

    @Description("TC_01: Add a new record")
    @Test
    public void TC_01_AddNewRecord() {
        webTablesPage.clickAddButton();
        webTablesPage.fillForm("John1", "Doe", "john.doe@example.com", "30", "50000", "IT");
        webTablesPage.submitForm();
        webTablesPage.searchRecord("John1");
        assertTrue(webTablesPage.isRecordDisplayed("John1"), "New record is not displayed!");
    }

    @Description("TC_03: Update a record")
    @Test
    public void TC_03_UpdateRecord() {
        webTablesPage.updateRecord( "John1","Ngoan", "Smith", "jane.smith@example.com", "28", "60000", "HR");
        webTablesPage.searchRecord("Ngoan");
        assertTrue(webTablesPage.isRecordDisplayed("Ngoan"), "Updated record is not displayed!");
    }

    @Description("TC_04: Delete a record")
    @Test
    public void TC_04_DeleteRecord() {
        webTablesPage.deleteRecord("Ngoan");
        assertTrue(!webTablesPage.isRecordDisplayed("Ngoan"), "Record is not deleted!");
    }


    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
