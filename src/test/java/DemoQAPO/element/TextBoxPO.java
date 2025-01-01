package DemoQAPO.element;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import DemoQAPUI.element.TextBoxPUI;

public class TextBoxPO extends BasePage {
    private WebDriver driver;

    public TextBoxPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToSubmit() {
        waitForElementClickable(driver, TextBoxPUI.SUBMIT_BUTTON);
        clickToElement(driver, TextBoxPUI.SUBMIT_BUTTON);
    }

    //Input username
    public void inputToUsername(String username, String value) {
        waitForElementVisible(driver, TextBoxPUI.FULLNAME_TEXTBOX, username);
        sendkeyToElement(driver, TextBoxPUI.FULLNAME_TEXTBOX, value, username);
    }

    //Input email
    public void inputToEmail(String email, String value) {
        waitForElementVisible(driver, TextBoxPUI.EMAIL_TEXTBOX, email);
        sendkeyToElement(driver, TextBoxPUI.EMAIL_TEXTBOX, value, email);
    }

    //Input current Address
    public void inputToCurrentAddress(String currentAddress, String value) {
        waitForElementVisible(driver, TextBoxPUI.CURRENT_ADDRESS_TEXTBOX, currentAddress);
        sendkeyToElement(driver, TextBoxPUI.CURRENT_ADDRESS_TEXTBOX, value, currentAddress);
    }

    //Input permanent Address
    public void inputToPermanentAddress(String permanentAddress, String value) {
        waitForElementVisible(driver, TextBoxPUI.PERMANENT_ADDRESS_TEXTBOX, permanentAddress);
        sendkeyToElement(driver, TextBoxPUI.PERMANENT_ADDRESS_TEXTBOX, value, permanentAddress);
    }

    //input information
    public void inputToAllFields(String fullName, String email, String currentAddress, String permanentAddress) {
        inputToUsername(fullName, fullName);
        inputToEmail(email, email);
        inputToCurrentAddress(currentAddress, currentAddress);
        inputToPermanentAddress(permanentAddress, permanentAddress);
    }

    @Step("get username")
    public String getTextOfUsername() {
        waitForElementVisible(driver, TextBoxPUI.RESULT_FULLNAME);
        String fullText = getElementText(driver, TextBoxPUI.RESULT_FULLNAME); // Lấy toàn bộ chuỗi
        return fullText.substring(fullText.indexOf(":") + 1).trim(); // Lấy phần sau dấu ":" và loại bỏ khoảng trắng
    }

    @Step("get email")
    public String getTextOfEmail() {
        waitForElementVisible(driver, TextBoxPUI.RESULT_EMAIL);
        String fullText = getElementText(driver, TextBoxPUI.RESULT_EMAIL); // Lấy toàn bộ chuỗi
        return fullText.substring(fullText.indexOf(":") + 1).trim(); // Lấy phần sau dấu ":" và loại bỏ khoảng trắng
    }

    @Step("get current Address")
    public String getTextOfCurrentAddress() {
        waitForElementVisible(driver, TextBoxPUI.RESULT_CURRENT_ADDRESS);
        String fullText = getElementText(driver, TextBoxPUI.RESULT_CURRENT_ADDRESS); // Lấy toàn bộ chuỗi
        return fullText.substring(fullText.indexOf(":") + 1).trim(); // Lấy phần sau dấu ":" và loại bỏ khoảng trắng
    }

    @Step("get permanent Address")
    public String getTextOfPermanentAddress() {
        waitForElementVisible(driver, TextBoxPUI.RESULT_PERMANENT_ADDRESS);
        String fullText = getElementText(driver, TextBoxPUI.RESULT_PERMANENT_ADDRESS); // Lấy toàn bộ chuỗi
        return fullText.substring(fullText.indexOf(":") + 1).trim(); // Lấy phần sau dấu ":" và loại bỏ khoảng trắng
    }


}
