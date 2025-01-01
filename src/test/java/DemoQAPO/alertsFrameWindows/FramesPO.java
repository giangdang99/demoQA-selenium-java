package DemoQAPO.alertsFrameWindows;

import DemoQAPUI.alertsFrameWindows.FramesPUI;
import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FramesPO extends BasePage {
    private WebDriver driver;

    public FramesPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Switch to Frame 1")
    public void switchToFrame1() {
        WebElement frame1 = getWebElement(driver, FramesPUI.FRAME_1);
        driver.switchTo().frame(frame1);
    }

    @Step("Switch to Frame 2")
    public void switchToFrame2() {
        WebElement frame2 = getWebElement(driver, FramesPUI.FRAME_2);
        driver.switchTo().frame(frame2);
    }

    @Step("Switch back to the main content")
    public void switchToMainContent() {
        driver.switchTo().defaultContent();
    }

    @Step("Get the heading text from the current frame")
    public String getFrameHeadingText() {
        return getElementText(driver, FramesPUI.FRAME_HEADING);
    }
}
