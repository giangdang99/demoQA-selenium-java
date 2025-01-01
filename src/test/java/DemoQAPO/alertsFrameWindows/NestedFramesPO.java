package DemoQAPO.alertsFrameWindows;

import DemoQAPUI.alertsFrameWindows.NestedFramesPUI;
import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class NestedFramesPO extends BasePage {
    private WebDriver driver;
    private String mainWindowHandle;


    public NestedFramesPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Switch to Parent Frame")
    public void switchToParentFrame() {
        switchToFrameIframe(driver, NestedFramesPUI.PARENT_FRAME);
    }

    @Step("Switch to Child Frame")
    public void switchToChildFrame() {
        switchToFrameIframe(driver, NestedFramesPUI.CHILD_FRAME);
    }

    @Step("Switch back to the main content")
    public void switchToMainContent() {
        driver.switchTo().window(mainWindowHandle);
    }

    @Step("Get text from Parent Frame")
    public String getParentFrameText() {
        return getElementText(driver, NestedFramesPUI.PARENT_FRAME_TEXT);
    }

    @Step("Get text from Child Frame")
    public String getChildFrameText() {
        return getElementText(driver, NestedFramesPUI.CHILD_FRAME_TEXT);
    }
}