package DemoQAPO.element;

import DemoQAPUI.element.BrokenLinksImagesPUI;
import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class BrokenLinksImagesPO extends BasePage {
    private WebDriver driver;

    public BrokenLinksImagesPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Check if valid image is displayed")
    public boolean isValidImageDisplayed() {
        return isImageLoaded(driver, BrokenLinksImagesPUI.VALID_IMAGE);
    }

    @Step("Check if broken image is displayed")
    public boolean isBrokenImageDisplayed() {
        return !isImageLoaded(driver, BrokenLinksImagesPUI.BROKEN_IMAGE);
    }

    @Step("Click valid link")
    public void clickValidLink() {
        clickToElement(driver, BrokenLinksImagesPUI.VALID_LINK);
    }

    @Step("Check if valid link redirected correctly")
    public boolean isValidLinkRedirected() {
        return verifyCurrentUrl(driver, "https://demoqa.com/");
    }

    @Step("Click broken link")
    public void clickBrokenLink() {
        clickToElement(driver, BrokenLinksImagesPUI.BROKEN_LINK);
    }

    @Step("Check if broken link is handled")
    public boolean isBrokenLinkHandled() {
        return verifyCurrentUrl(driver, "http://the-internet.herokuapp.com/status_codes/500");
    }
}