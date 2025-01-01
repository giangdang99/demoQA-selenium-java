package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class BasePage {
	
	public static BasePage getBasePageObject() {
		return new BasePage();
	}

	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshToPage(WebDriver driver) {
		driver.navigate().refresh();
	}

//	public Alert waitForAlertPresence(WebDriver driver) {
//		WebDriverWait explicitWait = new WebDriverWait(driver,Duration.ofSeconds(5));
//		return explicitWait.until(ExpectedConditions.alertIsPresent());
//	}

	public Alert waitForAlertPresence(WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			return wait.until(ExpectedConditions.alertIsPresent());
		} catch (TimeoutException e) {
			return null;
		}
	}

	public boolean isAlertPresent(WebDriver driver) {
		try {
			Alert alert = driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}



	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	public String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	public void sendkeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}

	public void sendkeyToAlertAuthen(WebDriver driver, String textValue ) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}

	public void switchToWindowByID(WebDriver driver,String windowID) 
	{
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if (!id.equals(windowID)){
				driver.switchTo().window(id);
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver,String tabTitle) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			driver.switchTo().window(id);
			String actualTitle = driver.getTitle();
			if (actualTitle.equals(tabTitle)){
				break;
			}
		}
	}

	public void closeAllTabWithoutParents(WebDriver driver,String parentID) {
		Set<String> allWindowIDs = driver.getWindowHandles();

		for (String id : allWindowIDs) {
			if (!id.equals(parentID)){
				driver.switchTo().window(id);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}
	

	private By getByLocator(String locatorType) {
		By by = null;
		if(locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
			by = By.id(locatorType.substring(3));
		} else if (locatorType.startsWith("css=")|| locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {
			by = By.cssSelector(locatorType.substring(4));
		} else if (locatorType.startsWith("xpath=")|| locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")) {
			by = By.xpath(locatorType.substring(6));
		} else if (locatorType.startsWith("name=")|| locatorType.startsWith("NAME=") || locatorType.startsWith("Name=")) {
			by = By.name(locatorType.substring(5));
		} else if (locatorType.startsWith("class=")|| locatorType.startsWith("CLASS=") || locatorType.startsWith("Class=")) {
			by = By.className(locatorType.substring(6));
		} else {
			throw new RuntimeException("Locator type is not supported!");
		}
		return by;
	}
	

	protected String getDynamicXpath(String locatorType, String... values) {
	if (locatorType.startsWith("xpath=")|| locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")) {
			locatorType = String.format(locatorType, (Object[]) values);
		}
		return locatorType;
	}

	protected WebElement getWebElement(WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}

	protected List<WebElement> getListWebElement(WebDriver driver, String locatorType) {
		return driver.findElements(getByLocator(locatorType));

	}


	public void clickToElement(WebDriver driver, String locatorType) {
		getWebElement(driver, locatorType).click();
	}
	
	public void clickdoubleToElement(WebDriver driver, String locatorType) {
		Actions actions = new Actions(driver);
		actions.doubleClick(getWebElement(driver, locatorType)).perform();
	}


	// Double-click vào phần tử
	public void doubleClickToElement(WebDriver driver, String locatorType) {
		Actions actions = new Actions(driver);
		actions.doubleClick(getWebElement(driver, locatorType)).perform();
	}

	// Right-click vào phần tử
	public void rightClickToElement(WebDriver driver, String locatorType) {
		Actions actions = new Actions(driver);
		actions.contextClick(getWebElement(driver, locatorType)).perform();
	}
	
	public void clickToElement(WebDriver driver, String locatorType, String... dynamicValues) {
		locatorType = getDynamicXpath(locatorType, dynamicValues);
		getWebElement(driver,locatorType).click();
	}

	public void sendkeyToElement(WebDriver driver, String locatorType, String textValue) {
		WebElement element = getWebElement(driver, locatorType);
		element.clear();
		element.sendKeys(textValue);
	}
	
	public void sendkeyToElement(WebDriver driver, String locatorType, String textValue, String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		element.clear();
		element.sendKeys(textValue);
	}

	public void selectItemInSpanDropdown(WebDriver driver, String locatorType, String textItem, String... dynamicValues) {
	    WebElement dropdown = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
	    dropdown.click();

	    for (WebElement option : getListWebElement(driver, locatorType)) {
	        if (option.getText().equals(textItem)) {
	            option.click();
	            break;
	        }
	    }
	}
	
	public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem) {
		Select select = new Select(getWebElement(driver, locatorType));
		select.selectByVisibleText(textItem);
	}
	
	
	public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem, String... dynamicValues) {
		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		select.selectByVisibleText(textItem);
	}

	public String getSelectedItemDefaultDropdown(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver,String parentXpath, String childXpath, String expectedTextItem) {
		getWebElement(driver, parentXpath).click();
		sleepInSecond(1);

		WebDriverWait explicitWait= new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
		List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childXpath)));
		for (WebElement item: allItems) {
			if (item.getText().trim().equals(expectedTextItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);
				item.click();
				break;
			}
		}
	}
	
	public void selectItemInCustomDropdown(WebDriver driver,String parentXpath, String childXpath, String expectedTextItem,  String... dynamicValues) {
		getWebElement(driver, parentXpath).click();
		sleepInSecond(1);

		WebDriverWait explicitWait= new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
		List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childXpath)));
		for (WebElement item: allItems) {
			if (item.getText().trim().equals(expectedTextItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);
				item.click();
				break;
			}
		}
	}


	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time *1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getElementAttribute(WebDriver driver, String locatorType, String attributeName) {
		return getWebElement(driver, locatorType).getAttribute(attributeName);
	}
	
	public String getElementAttribute(WebDriver driver, String locatorType, String attributeName, String... dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).getAttribute(attributeName);
	}


	public String getElementText(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).getText();
	}
	
	public String getElementText(WebDriver driver, String locatorType, String... dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).getText();
	}

	// Kiểm tra bất kỳ thuộc tính CSS hợp lệ nào của phần tử - color - background-color- .....
	//Test User Interface - font-size/color/width/height/margin-top/....
	public String getElementCssValue(WebDriver driver, String locatorType, String propertyName) {
		return getWebElement(driver, locatorType).getCssValue(propertyName);
	}


	public String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}

	public int getElementHeight(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		return element.getSize().getHeight();
	}

	public String getElementBackgroundColor(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		String rgbaValue = element.getCssValue("background-color");
		return getHexaColorFromRGBA(rgbaValue);
	}

	//Kiểm tra vị trí của phần tử:
	public Point getElementPosition(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		return element.getLocation();
	}

	public int getElementSize(WebDriver driver, String locatorType) {
		return getListWebElement(driver, locatorType).size();
	}
	
	public int getElementSize(WebDriver driver, String locatorType, String... dynamicValues) {
		return getListWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).size();
	}

	//CHECKBOX - RADIO
	public void checkToDefaultCheckboxOrRadio(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if(!element.isSelected()) {
			element.click();
		}
	}
	
	public void checkToDefaultCheckboxOrRadio(WebDriver driver, String locatorType,  String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		if(!element.isSelected()) {
			element.click();
		}
	}


	public void uncheckToDefaultCheckboxRadio(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if(element.isSelected()) {
			element.click();
		}
	}
	
	public void uncheckToDefaultCheckboxRadio(WebDriver driver, String locatorType,  String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		if(element.isSelected()) {
			element.click();
		}
	}
	
	//TOGGLE 
	public void toggleSwitchOn(WebDriver driver, String locatorType) {
	    WebElement element = getWebElement(driver, locatorType);
	    if (!element.isSelected()) {
	        element.click();
	    }
	}

	public void toggleSwitchOff(WebDriver driver, String locatorType) {
	    WebElement element = getWebElement(driver, locatorType);
	    if (element.isSelected()) {
	        element.click();
	    }
	}
	
	public void toggleSwitchOn(WebDriver driver, String locatorType, String... dynamicValues) {
	    WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
	    if (!element.isSelected()) {
	        element.click();
	    }
	}

	public void toggleSwitchOff(WebDriver driver, String locatorType, String... dynamicValues) {
	    WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
	    if (element.isSelected()) {
	        element.click();
	    }
	}
	
	//ELEMENT
	public boolean isElementDisplayed(WebDriver driver, String locatorType) {
		return getWebElement(driver,locatorType).isDisplayed();
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locatorType, String... dynamicValues) {
		return getWebElement(driver,getDynamicXpath(locatorType, dynamicValues)).isDisplayed();
	}



	public boolean isElementEnable(WebDriver driver, String locatorType) {
		return getWebElement(driver,locatorType).isEnabled();
	}


	public boolean isElementSelected(WebDriver driver, String locatorType) {
		return getWebElement(driver,locatorType).isSelected();
	}

	public void switchToFrameIframe(WebDriver driver, String locatorType) {
		driver.switchTo().frame(getWebElement(driver, locatorType));
	}
	

	public void switchToDefaultContent(WebDriver driver, String locatorType) {
		driver.switchTo().defaultContent();
	}
	

	public void hoverMouseToElement(WebDriver driver, String locatorType) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locatorType)).perform();
	}
	

	public void scrollToBottomPage(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}


	public void highlightElement(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		String originalStyle = element.getAttribute("style");
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locatorType) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, locatorType));
	}

	public void scrollToElement(WebDriver driver, String locatorType) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locatorType));
	}

	public void removeAttributeInDOM(WebDriver driver, String locatorType, String attributeRemove) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locatorType));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
			}
		};
		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locatorType) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getWebElement(driver, locatorType));
	}

	public boolean isImageLoaded(WebDriver driver, String locatorType) {
		boolean status = (boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getWebElement(driver, locatorType));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	private long longTimeout = 30;


	public void waitForElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
	}
	
	public void waitForElementVisible(WebDriver driver, String locatorType, String...dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}
	
	public void waitForAllElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
	}
	
	public void waitForAllElementVisible(WebDriver driver, String locatorType, String...dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}
	
	public void waitForElementInvisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
	}
	
	public void waitForElementInvisible(WebDriver driver, String locatorType, String...dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	public boolean waitForElementInvisibleTo(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
		return explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
	}

	public boolean waitForElementInvisibleTo(WebDriver driver, String locatorType, String...dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
		return explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	
	public void waitForElementClickable(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}
	
	public void waitForElementClickable(WebDriver driver, String locatorType, String...dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}


	public void openNewTab(WebDriver driver, String locatorType, String...dynamicValues) {
		 ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(tabs.get(1));
		 driver.get(getDynamicXpath(locatorType, dynamicValues));
	}


	public void dragAndDrop(WebDriver driver, String sourceXpath, String targetXpath) {
		new Actions(driver)
				.dragAndDrop(getWebElement(driver, sourceXpath),
						getWebElement(driver, targetXpath)).perform();
	}


	public boolean verifyCurrentUrl(WebDriver driver, String expectedUrl) {
		try {
			String currentUrl = driver.getCurrentUrl();
			return currentUrl.equals(expectedUrl);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	public boolean isFileDownloadedInDirectory(String directoryPath, String fileName) {
		File dir = new File(directoryPath);
		File[] files = dir.listFiles();

		if (files == null || files.length == 0) {
			return false;
		}

		for (File file : files) {
			if (file.getName().equals(fileName)) {
				return true; // File found
			}
		}

		return false; // File not found
	}


	public boolean waitForElementEnabled(WebDriver driver, String locator, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		try {
			return wait.until(d -> getWebElement(driver, locator).isEnabled());
		} catch (Exception e) {
			return false;
		}
	}

	public boolean waitForElementColorChange(WebDriver driver, String locator, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		try {
			String initialColor = getWebElement(driver, locator).getCssValue("color");
			return wait.until(d -> {
				String currentColor = getWebElement(driver, locator).getCssValue("color");
				return !initialColor.equals(currentColor);
			});
		} catch (Exception e) {
			return false;
		}
	}

	// For Keys object
	public void pressKey(WebDriver driver, String locatorType, Keys key) {
		WebElement element = getWebElement(driver, locatorType);
		element.sendKeys(key);
	}

	// For String key
	public void pressKey(WebDriver driver, String locatorType, String keyAsString) {
		Keys key = Keys.valueOf(keyAsString.toUpperCase());
		pressKey(driver, locatorType, key);
	}


}
