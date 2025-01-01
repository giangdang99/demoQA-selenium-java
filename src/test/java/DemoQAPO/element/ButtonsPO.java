package DemoQAPO.element;

import DemoQAPUI.element.ButtonsPUI;
import DemoQAPUI.element.WebTablesPUI;
import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ButtonsPO extends BasePage {
    private WebDriver driver;

    public ButtonsPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Double click the button")
    public void doubleClickButton() {
        waitForElementClickable(driver, ButtonsPUI.DOUBLE_CLICK_BUTTON);
        doubleClickToElement(driver, ButtonsPUI.DOUBLE_CLICK_BUTTON);
    }

    @Step("Right click the button")
    public void rightClickButton() {
        waitForElementClickable(driver, ButtonsPUI.RIGHT_CLICK_BUTTON);
        rightClickToElement(driver, ButtonsPUI.RIGHT_CLICK_BUTTON);
    }

    @Step("Perform a dynamic click on the button")
    public void dynamicClickButton() {
        waitForElementClickable(driver, ButtonsPUI.DYNAMIC_CLICK_BUTTON);
        clickToElement(driver, ButtonsPUI.DYNAMIC_CLICK_BUTTON);
    }

    @Step("Check if double click message is displayed")
    public boolean isDoubleClickMessageDisplayed() {
        waitForElementClickable(driver, ButtonsPUI.DOUBLE_CLICK_MESSAGE);
        return isElementDisplayed(driver, ButtonsPUI.DOUBLE_CLICK_MESSAGE);
    }

    @Step("Check if right click message is displayed")
    public boolean isRightClickMessageDisplayed() {
        waitForElementClickable(driver, ButtonsPUI.RIGHT_CLICK_MESSAGE);
        return isElementDisplayed(driver, ButtonsPUI.RIGHT_CLICK_MESSAGE);
    }

    @Step("Check if dynamic click message is displayed")
    public boolean isDynamicClickMessageDisplayed() {
        waitForElementClickable(driver, ButtonsPUI.DYNAMIC_CLICK_MESSAGE);
        return isElementDisplayed(driver, ButtonsPUI.DYNAMIC_CLICK_MESSAGE);
    }
}