package app.aliexpress.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.util.Set;

public class SetUpPage {

    private WebDriver driver;
    //setProperty for Chrome
    String driverChrome = "webdriver.chrome.driver";
    String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
    //setProperty for IE
    String driverIE = "webdriver.ie.driver";
    String iePath = System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe";
    //setProperty for Firefox
    String driverfirefox = "webdriver.gecko.driver";
    String firefoxPath = System.getProperty("user.dir") + "\\drivers\\geckodriver.exe";

    public SetUpPage(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver CreateMyDriver(DRIVERS myDriver) {
        switch (myDriver) {
            case CHROME:
                setProperty(driverChrome, chromePath);
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                return driver;
            case FIREFOX:
                setProperty(driverfirefox, firefoxPath);
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                return driver;
            case IE:
                setProperty(driverIE, iePath);
                driver = new InternetExplorerDriver();
                driver.manage().window().maximize();
                return driver;
            default:
                throw new IllegalArgumentException("Driver provided is not implemented.");
        }
    }

    private void setProperty(String webDriver, String path){
        System.setProperty(webDriver, path);
    }

    public WebElement findElement(By locator){
        return getDriver().findElement(locator);
    }

    public boolean isDisplay(By locator){
        try {
            return getDriver().findElement(locator).isDisplayed();
        } catch(org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void click(By locator){
        getDriver().findElement(locator).click();
    }

    public void type(String inputText, By locator){
        getDriver().findElement(locator).sendKeys(inputText);
    }

    public void visitTo(String url){
        getDriver().get(url);
    }

    public void scrollPage(By locator){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,3500)","");
    }

    public void findElementWithJs(By locator){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String txt= (String) js.executeScript("return arguments[0].childNodes[0].textContent", locator);
    }

    public void windowHandle(){
        String mainWindow = getDriver().getWindowHandle();

        Set<String> windowHandles = getDriver().getWindowHandles();
        String otherWindow = null;
        for(String windowHandle: windowHandles){
            if(!windowHandle.equals(mainWindow))
                otherWindow = windowHandle;
        }
        switchWindow(otherWindow);
    }

    public void switchWindow(String windowHandle){
         getDriver().switchTo().window(windowHandle);
    }

    public WebDriver getDriver() {
        return driver;
    }

    private void setDriver(WebDriver driver){
        this.driver = driver;
    }

}
