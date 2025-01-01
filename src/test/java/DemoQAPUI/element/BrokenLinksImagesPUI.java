package DemoQAPUI.element;

public class BrokenLinksImagesPUI {
    public static final String VALID_IMAGE = "xpath=//img[contains(@src, 'Toolsqa')]";
    public static final String BROKEN_IMAGE = "xpath=/img[src='/images/Toolsqa_1.jpg']";
    public static final String VALID_LINK = "xpath=//a[text()='Click Here for Valid Link']";
    public static final String BROKEN_LINK = "xpath=//a[text()='Click Here for Broken Link']";
}
