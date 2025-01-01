package DemoQAPO.element;

import DemoQAPUI.element.UploadAndDownloadPUI;
import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class UploadAndDownloadPO extends BasePage {
    private WebDriver driver;

    public UploadAndDownloadPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click download button")
    public void clickDownloadButton() {
        clickToElement(driver, UploadAndDownloadPUI.DOWNLOAD_BUTTON);
    }

    @Step("Verify if file is downloaded")
    public boolean isFileDownloaded(String fileName) {
        String downloadPath = System.getProperty("user.home") + "/Downloads"; // Default download directory for most systems
        return isFileDownloadedInDirectory(downloadPath, fileName);
    }

    @Step("Upload file")
    public void uploadFile(String fileName) {
        // Dynamically construct the file path
        String filePath = System.getProperty("user.home") + "/Downloads/" + fileName;
        sendkeyToElement(driver, UploadAndDownloadPUI.UPLOAD_INPUT, filePath);
    }



    @Step("Verify if file is uploaded")
    public boolean isFileUploaded(String expectedFileName) {
        String uploadedFileName = getElementText(driver, UploadAndDownloadPUI.UPLOADED_FILE_PATH);
        return uploadedFileName.contains(expectedFileName);
    }
}
