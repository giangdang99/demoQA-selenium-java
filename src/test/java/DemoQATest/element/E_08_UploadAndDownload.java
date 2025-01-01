package DemoQATest.element;

import DemoQAPO.element.UploadAndDownloadPO;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class E_08_UploadAndDownload {
    WebDriver driver = new ChromeDriver();
    private UploadAndDownloadPO uploadAndDownloadPage;

    @BeforeClass
    public void setup() {
        // Setup WebDriver
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demoqa.com/upload-download");

        // Initialize Upload and Download Page Object
        uploadAndDownloadPage = new UploadAndDownloadPO(driver);
    }

    @Description("TC_01: Verify file download")
    @Test
    public void TC_01_VerifyFileDownload() {
        uploadAndDownloadPage.clickDownloadButton();
        assertTrue(uploadAndDownloadPage.isFileDownloaded("sampleFile.jpeg"), "File was not downloaded successfully!");
    }

    @Description("TC_02: Verify File Upload")
    @Test
    public void TC_02_VerifyFileUpload() {
        // Call the updated uploadFile method with just the file name
        uploadAndDownloadPage.uploadFile("sampleFile.jpeg");

        // Verify that the file upload was successful
        assertTrue(uploadAndDownloadPage.isFileUploaded("sampleFile.jpeg"), "File upload was not successful!");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
