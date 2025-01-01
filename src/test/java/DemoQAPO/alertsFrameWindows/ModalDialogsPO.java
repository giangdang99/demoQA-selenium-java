package DemoQAPO.alertsFrameWindows;

import DemoQAPUI.alertsFrameWindows.ModalDialogsPUI;
import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ModalDialogsPO extends BasePage {
    private WebDriver driver;

    public ModalDialogsPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open Small Modal")
    public void openSmallModal() {
        clickToElement(driver, ModalDialogsPUI.SMALL_MODAL_BUTTON);
    }

    @Step("Open Large Modal")
    public void openLargeModal() {
        clickToElement(driver, ModalDialogsPUI.LARGE_MODAL_BUTTON);
    }

    @Step("Close Small Modal")
    public void closeSmallModal() {
        clickToElement(driver, ModalDialogsPUI.SMALL_MODAL_CLOSE_BUTTON);
    }

    @Step("Close Large Modal")
    public void closeLargeModal() {
        clickToElement(driver, ModalDialogsPUI.LARGE_MODAL_CLOSE_BUTTON);
    }

    @Step("Get Small Modal Text")
    public String getSmallModalText() {
        return getElementText(driver, ModalDialogsPUI.SMALL_MODAL_TEXT);
    }

    @Step("Get Large Modal Text")
    public String getLargeModalText() {
        return getElementText(driver, ModalDialogsPUI.LARGE_MODAL_TEXT);
    }
}