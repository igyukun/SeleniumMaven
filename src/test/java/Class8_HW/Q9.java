package Class8_HW;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
Press an element using JavaScript code (from inside your
Java code)
HINT: read on JavaScriptExecutor interface.
 */
public class Q9 {
    private WebDriver driverChrome;
    private String url = "https://www.facebook.com/";
    private String titleExpected = "Facebook - Log In or Sign Up";

    @BeforeClass
    public void initChrome() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome Beta\\Application\\chrome.exe");
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\IGOR\\Documents\\Studies\\QA Experts\\WebDrivers\\chromedriver_win32\\chromedriver.exe");
        driverChrome = new ChromeDriver(options);
        driverChrome.get(url);
        driverChrome.manage().window().minimize();
    }

    @Test
    public void getTitleWithJS(){
        //Creating JavascriptExecutor by casting of WebDriver object
        JavascriptExecutor js = (JavascriptExecutor)driverChrome;
        //Execute script that returns the page title
        String titleJS = js.executeScript("return document.title;").toString();
        System.out.printf("JavaScript:%s%nExpected:%s%n", titleJS, titleExpected);
        Assert.assertEquals(titleJS, titleExpected);

    }

    @Test
    public void getTitleWithSel() {
        String titleSel = driverChrome.getTitle();
        System.out.printf("Selenium:%s%nExpected:%s%n", titleSel, titleExpected);
        Assert.assertEquals(titleSel, titleExpected);
    }

    @AfterClass
    public void closeDriver(){
        driverChrome.quit();
    }
}
