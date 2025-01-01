package DemoQAPO.element;

import DemoQAPUI.element.DynamicPropertiesPUI;
import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class DynamicPropertiesPO extends BasePage {
    private WebDriver driver;

    public DynamicPropertiesPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Check if button is enabled after delay")
    public boolean isButtonEnabledAfterDelay() {
        return waitForElementEnabled(driver, DynamicPropertiesPUI.ENABLE_AFTER_BUTTON, 10); // Adjust timeout as needed
    }

    @Step("Check if button color changes dynamically")
    public boolean isButtonColorChanged() {
        return waitForElementColorChange(driver, DynamicPropertiesPUI.COLOR_CHANGE_BUTTON, 10); // Adjust timeout as needed
    }

    @Step("Check if button is visible after delay")
    public boolean isButtonVisibleAfterDelay() {
        try {
            waitForElementVisible(driver, DynamicPropertiesPUI.VISIBLE_AFTER_BUTTON);
            return true; // If no exception, the element is visible
        } catch (Exception e) {
            return false; // If an exception occurs, the element is not visible
        }
    }

}
