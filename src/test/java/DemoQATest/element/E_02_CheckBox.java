package DemoQATest.element;

import DemoQAPO.element.CheckBoxPO;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class E_02_CheckBox {
    WebDriver driver = new ChromeDriver();
    private CheckBoxPO checkBoxPage;


    @BeforeClass
    public void setup() {
        // Cài đặt đường dẫn WebDriver
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // Mở URL
        driver.get("https://demoqa.com/checkbox");

        // Initialize the page object for TextBox
        checkBoxPage = new CheckBoxPO(driver);
    }

    @Description("TC_01: Click to checkbox")
    @Test
    public void TC_01_ClickToCheckBox() {
        checkBoxPage.clickToCheckBox();
        String textExpect = "You have selected :\nhome\ndesktop\nnotes\ncommands\ndocuments\nworkspace\nreact\nangular\nveu\noffice\npublic\nprivate\nclassified\ngeneral\ndownloads\nwordFile\nexcelFile";
        assertEquals(checkBoxPage.getTextOfResult(), textExpect, "Result not match text expect");
    }



    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
