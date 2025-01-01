package DemoQAPO.alertsFrameWindows;

import DemoQAPUI.alertsFrameWindows.AlertsPUI;
import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertsPO extends BasePage {
    private WebDriver driver;

    public AlertsPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click the alert button")
    public void clickAlertButton() {
        clickToElement(driver, AlertsPUI.ALERT_BUTTON);
    }

    @Step("Click the timer alert button")
    public void clickTimerAlertButton() {
        clickToElement(driver, AlertsPUI.TIMER_ALERT_BUTTON);
    }

    @Step("Click the confirm button")
    public void clickConfirmButton() {
        clickToElement(driver, AlertsPUI.CONFIRM_BUTTON);
    }

    @Step("Click the prompt button")
    public void clickPromptButton() {
        clickToElement(driver, AlertsPUI.PROMPT_BUTTON);
    }

    @Step("Handle the alert")
    public String handleAlert(boolean accept, String inputText) {
        Alert alert = waitForAlertPresence(driver);
        if (inputText != null) {
            alert.sendKeys(inputText);
        }
        if (accept) {
            alert.accept();
        } else {
            alert.dismiss();
        }
        return inputText;
    }

    @Step("Get confirm result text")
    public String getConfirmResultText() {
        return getElementText(driver, AlertsPUI.CONFIRM_RESULT_TEXT);
    }

    @Step("Get prompt result text")
    public String getPromptResultText() {
        return getElementText(driver, AlertsPUI.PROMPT_RESULT_TEXT);
    }
}