package base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;
import constants.Filepath;
import utility.PropertyUtils;

import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class PredefinedActions {

    protected static Page page;

    public static void startBrowser(String browserName, String env) {
        Map<String, String> envGrid = new HashMap<>();
        envGrid.put("SELENIUM_REMOTE_URL", "http://16.170.205.102:4444");
        List<String> cap = Arrays.asList("--start-maximized");
        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome").setEnv(envGrid));
        BrowserContext browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate("https://www.amazon.in/");
    }

    private String getApplicationURL(String env) {
        return PropertyUtils.getValue(Filepath.CONFIGPATH, env.toLowerCase());
    }

    public static void closeBrowser() {
        page.close();
    }

    protected void setText(String locator, String textToSet) {
        page.locator(locator).fill(textToSet);
    }

    protected void clickOnElement(String locator) {
        page.locator(locator).click();
    }

    public void waitUntilNetworkToBeStable() {
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }

    protected String getTitleOfPage() {
        return page.title();
    }

    protected String getTextOfElement(String locator) {
        return page.locator(locator).textContent();
    }

    protected boolean isLocatorVisible(String locator){
        return page.locator(locator).isVisible();
    }

    public static byte[] capatureScreenShot() {
        return page.screenshot();
    }

    protected void scrolTillLocator(String locator){
        page.locator(locator).scrollIntoViewIfNeeded();
    }
}
