package DemoQAPO.element;

import DemoQAPUI.element.WebTablesPUI;
import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class WebTablesPO extends BasePage {
    private WebDriver driver;

    public WebTablesPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click Add button")
    public void clickAddButton() {
        waitForElementClickable(driver, WebTablesPUI.ADD_BUTTON);
        clickToElement(driver, WebTablesPUI.ADD_BUTTON);
    }

    @Step("Fill the form")
    public void fillForm(String firstName, String lastName, String email, String age, String salary, String department) {
        sendkeyToElement(driver, WebTablesPUI.FIRST_NAME_INPUT, firstName);
        sendkeyToElement(driver, WebTablesPUI.LAST_NAME_INPUT, lastName);
        sendkeyToElement(driver, WebTablesPUI.EMAIL_INPUT, email);
        sendkeyToElement(driver, WebTablesPUI.AGE_INPUT, age);
        sendkeyToElement(driver, WebTablesPUI.SALARY_INPUT, salary);
        sendkeyToElement(driver, WebTablesPUI.DEPARTMENT_INPUT, department);
    }

    @Step("Submit the form")
    public void submitForm() {
        waitForElementClickable(driver, WebTablesPUI.SUBMIT_BUTTON);
        clickToElement(driver, WebTablesPUI.SUBMIT_BUTTON);
    }

    @Step("Search for record")
    public void searchRecord(String keyword) {
        sendkeyToElement(driver, WebTablesPUI.SEARCH_BOX, keyword);
    }

    @Step("Update record")
    public void updateRecord(String oldName, String firstName, String lastName, String newEmail, String newAge, String newSalary, String newDepartment) {
        String editButtonLocator = String.format(WebTablesPUI.EDIT_BUTTON_BY_NAME, oldName);
        waitForElementClickable(driver, editButtonLocator);
        clickToElement(driver, editButtonLocator);

        // Update data
        sendkeyToElement(driver, WebTablesPUI.FIRST_NAME_INPUT, firstName);
        sendkeyToElement(driver, WebTablesPUI.LAST_NAME_INPUT, lastName);
        sendkeyToElement(driver, WebTablesPUI.EMAIL_INPUT, newEmail);
        sendkeyToElement(driver, WebTablesPUI.AGE_INPUT, newAge);
        sendkeyToElement(driver, WebTablesPUI.SALARY_INPUT, newSalary);
        sendkeyToElement(driver, WebTablesPUI.DEPARTMENT_INPUT, newDepartment);

        clickToElement(driver, WebTablesPUI.SUBMIT_BUTTON);
    }

    @Step("Delete record")
    public void deleteRecord(String fullName) {
        String deleteButtonLocator = String.format(WebTablesPUI.DELETE_BUTTON_BY_NAME, fullName);
        waitForElementClickable(driver, deleteButtonLocator);
        clickToElement(driver, deleteButtonLocator);
    }

    @Step("Check if record is displayed")
    public boolean isRecordDisplayed(String fullName) {
        String recordLocator = String.format(WebTablesPUI.RECORD_BY_NAME, fullName);
        return isElementDisplayed(driver, recordLocator);
    }
}
