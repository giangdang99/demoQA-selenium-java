package DemoQAPO.element;

import DemoQAPUI.element.ButtonsPUI;
import DemoQAPUI.element.LinksPUI;
import DemoQAPUI.element.RadioButtonPUI;
import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class LinksPO extends BasePage {
    private WebDriver driver;

    public LinksPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click Home link")
    public void clickHomeLink() {
        clickToElement(driver, LinksPUI.HOME_LINK);
    }

    @Step("Click API link")
    public void clickApiLink() {
        clickToElement(driver, LinksPUI.API_LINK);
    }

    @Step("Verify Home link redirection")
    public boolean isHomeLinkRedirected() {
        return verifyCurrentUrl(driver, "https://demoqa.com/");
    }

    @Step("API Response is displayed")
    public String getAPIResponse() {
        waitForElementVisible(driver, LinksPUI.API_MESSAGE);
        return getElementText(driver, LinksPUI.API_MESSAGE);
    }

}