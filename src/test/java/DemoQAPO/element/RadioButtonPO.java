package DemoQAPO.element;

import DemoQAPUI.element.RadioButtonPUI;
import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import DemoQAPUI.element.CheckBoxPUI;

public class RadioButtonPO extends BasePage {
    private WebDriver driver;

    public RadioButtonPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click to radio button: Yes")
    public void clickToRadioButtonYes() {
        waitForElementClickable(driver, RadioButtonPUI.RADIOBTN_YES);
        clickToElement(driver, RadioButtonPUI.RADIOBTN_YES);
    }

    @Step("Click to radio button: Impressive")
    public void clickToRadioButtonImpressive() {
        waitForElementClickable(driver, RadioButtonPUI.RADIOBTN_IMPRESSIVE);
        clickToElement(driver, RadioButtonPUI.RADIOBTN_IMPRESSIVE);
    }

    @Step("get text of result")
    public String getTextOfResult() {
        waitForElementVisible(driver, RadioButtonPUI.RESULT);
        return getElementText(driver, RadioButtonPUI.RESULT);
    }
}