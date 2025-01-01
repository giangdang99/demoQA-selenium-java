package DemoQAPO.forms;

import DemoQAPUI.element.TextBoxPUI;
import DemoQAPUI.forms.PracticeFormPUI;
import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PracticeFormPO extends BasePage {
    private WebDriver driver;

    public PracticeFormPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter first name: {0}")
    public void enterFirstName(String firstName) {
        sendkeyToElement(driver, PracticeFormPUI.FIRST_NAME_INPUT, firstName);
    }

    @Step("Enter last name: {0}")
    public void enterLastName(String lastName) {
        sendkeyToElement(driver, PracticeFormPUI.LAST_NAME_INPUT, lastName);
    }

    @Step("Enter email: {0}")
    public void enterEmail(String email) {
        sendkeyToElement(driver, PracticeFormPUI.EMAIL_INPUT, email);
    }

    @Step("Select gender: {0}")
    public void selectGender(String gender) {
        clickToElement(driver, String.format(PracticeFormPUI.GENDER_RADIO_BUTTON, gender));
    }

    @Step("Enter mobile number: {0}")
    public void enterMobileNumber(String mobileNumber) {
        sendkeyToElement(driver, PracticeFormPUI.MOBILE_NUMBER_INPUT, mobileNumber);
    }

    @Step("Enter date of birth: {0}")
    public void enterDateOfBirth(String dateOfBirth) {
        sendkeyToElement(driver, PracticeFormPUI.DATE_OF_BIRTH_INPUT, dateOfBirth);
        pressKey(driver, PracticeFormPUI.FIRST_NAME_INPUT, Keys.ENTER);
    }

    @Step("Enter subjects: {0}")
    public void enterSubjects(String subjects) {
        sendkeyToElement(driver, PracticeFormPUI.SUBJECTS_INPUT, subjects);
        pressKey(driver, PracticeFormPUI.SUBJECTS_INPUT, "ENTER");
    }

//    @Step("Select hobbies: {0}")
//    public void selectHobby(String hobby) {
//        waitForElementVisible(driver, PracticeFormPUI.HOBBIES_CHECKBOX,hobby);
//        clickToElement(driver, PracticeFormPUI.HOBBIES_CHECKBOX, hobby);
//    }

    public void selectHobby(String hobby) {
        waitForElementVisible(driver,PracticeFormPUI.HOBBIES_CHECKBOX,hobby);
        clickToElement(driver,PracticeFormPUI.HOBBIES_CHECKBOX,hobby);
    }


    @Step("Upload picture: {0}")
    public void uploadPicture(String filePath) {
        sendkeyToElement(driver, PracticeFormPUI.UPLOAD_PICTURE_BUTTON, filePath);
    }

    @Step("Enter address: {0}")
    public void enterAddress(String address) {
        sendkeyToElement(driver, PracticeFormPUI.ADDRESS_TEXTAREA, address);
    }

    @Step("Select state: {0}")
    public void selectState(String state) {
        selectItemInDefaultDropdown(driver, PracticeFormPUI.STATE_DROPDOWN, state);
    }

    @Step("Select city: {0}")
    public void selectCity(String city) {
        selectItemInDefaultDropdown(driver, PracticeFormPUI.CITY_DROPDOWN, city);
    }

    @Step("Submit the form")
    public void submitForm() {
        clickToElement(driver, PracticeFormPUI.SUBMIT_BUTTON);
    }

    @Step("Is success modal displayed?")
    public boolean isSuccessModalDisplayed() {
        return isElementDisplayed(driver, PracticeFormPUI.SUCCESS_MODAL);
    }


}
