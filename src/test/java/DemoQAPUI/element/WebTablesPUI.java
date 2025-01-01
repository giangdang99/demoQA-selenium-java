package DemoQAPUI.element;

public class WebTablesPUI {
    public static final String ADD_BUTTON = "xpath=//button[text()='Add']";
    public static final String FIRST_NAME_INPUT = "id=firstName";
    public static final String LAST_NAME_INPUT = "id=lastName";
    public static final String EMAIL_INPUT = "id=userEmail";
    public static final String AGE_INPUT = "id=age";
    public static final String SALARY_INPUT = "id=salary";
    public static final String DEPARTMENT_INPUT = "id=department";
    public static final String SUBMIT_BUTTON = "id=submit";
    public static final String SEARCH_BOX = "id=searchBox";

    public static final String RECORD_BY_NAME = "xpath=//div[contains(text(),'%s')]";
    public static final String EDIT_BUTTON_BY_NAME = "xpath=//div[contains(text(),'%s')]/following-sibling::div//span[@title='Edit']";
    public static final String DELETE_BUTTON_BY_NAME = "xpath=//div[contains(text(),'%s')]/following-sibling::div//span[@title='Delete']";
}
