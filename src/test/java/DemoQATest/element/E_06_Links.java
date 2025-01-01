package DemoQATest.element;

import DemoQAPO.element.LinksPO;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class E_06_Links {
    WebDriver driver = new ChromeDriver();
    private LinksPO linksPage;

    @BeforeClass
    public void setup() {
        // Setup WebDriver
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demoqa.com/links");

        // Initialize Links Page Object
        linksPage = new LinksPO(driver);
    }

    @Description("TC_01: Verify Home link")
    @Test
    public void TC_01_VerifyHomeLink() {
        String parentID = driver.getWindowHandle();
        linksPage.clickHomeLink(); // Nhấp vào liên kết để mở tab mới
        for (String tab : driver.getWindowHandles()) { // Lấy tất cả các tab
            if (!tab.equals(parentID)) {
                driver.switchTo().window(tab); // Chuyển sang tab mới
                assertTrue(linksPage.isHomeLinkRedirected(), "Home link did not redirect correctly!"); // Kiểm tra
                driver.close(); // Đóng tab mới
            }
        }
        driver.switchTo().window(parentID); // Quay lại tab chính

    }

    @Description("TC_02: Verify API link")
    @Test
    public void TC_02_VerifyApiLink() {
        linksPage.clickApiLink();
        assertEquals(linksPage.getAPIResponse(),"Link has responded with staus 201 and status text Created","API link did not redirect correctly!");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}