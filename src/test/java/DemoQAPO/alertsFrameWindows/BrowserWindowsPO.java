package DemoQAPO.alertsFrameWindows;

import DemoQAPUI.alertsFrameWindows.BrowserWindowsPUI;
import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsPO extends BasePage {
    private WebDriver driver;
    private String mainWindowHandle;

    public BrowserWindowsPO(WebDriver driver) {
        this.driver = driver;
        this.mainWindowHandle = driver.getWindowHandle(); // Lưu lại cửa sổ chính
    }

    @Step("Click button to open a new tab")
    public void clickNewTabButton() {
        clickToElement(driver, BrowserWindowsPUI.NEW_TAB_BUTTON);
    }

    @Step("Click button to open a new window")
    public void clickNewWindowButton() {
        clickToElement(driver, BrowserWindowsPUI.NEW_WINDOW_BUTTON);
    }

    @Step("Click button to open a new window with message")
    public void clickNewWindowMessageButton() {
        clickToElement(driver, BrowserWindowsPUI.NEW_WINDOW_MESSAGE_BUTTON);
    }

    @Step("Switch to newly opened tab or window")
    public void switchToNewTabOrWindow() {
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    @Step("Switch back to the main window")
    public void switchToMainWindow() {
        driver.switchTo().window(mainWindowHandle);
    }

    @Step("Get the text from the current tab or window")
    public String getNewTabOrWindowText() {
        return getElementText(driver, BrowserWindowsPUI.NEW_TAB_OR_WINDOW_TEXT);
    }
}


