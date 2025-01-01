package DemoQAPO.element;

import DemoQAPUI.element.TextBoxPUI;
import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import DemoQAPUI.element.CheckBoxPUI;

public class CheckBoxPO extends BasePage {
    private WebDriver driver;

    public CheckBoxPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click to chekcbox")
    public void clickToCheckBox() {
        waitForElementClickable(driver, CheckBoxPUI.SUBMIT_BUTTON);
        clickToElement(driver, CheckBoxPUI.SUBMIT_BUTTON);
    }

    @Step("get text of result")
    public String getTextOfResult() {
        waitForElementVisible(driver, CheckBoxPUI.RESULT);
        return getElementText(driver, CheckBoxPUI.RESULT);
    }
}