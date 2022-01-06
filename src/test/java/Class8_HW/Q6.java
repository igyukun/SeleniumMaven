package Class8_HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Locale;

/*
Create a TestNG test with the following:
 Open Google Translate web page
 Write anything in Hebrew in the text area
 */
public class Q6 {
    private WebDriver driverChrome;
    private final String url = "https://translate.google.com/";

    @BeforeClass
    public void initChrome() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome Beta\\Application\\chrome.exe");
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\IGOR\\Documents\\Studies\\QA Experts\\WebDrivers\\chromedriver_win32\\chromedriver.exe");
        driverChrome = new ChromeDriver(options);
        driverChrome.get(url);
    }

    @Test(priority = 0)
    public void sendKeyTranslate(){
        WebElement inputBox = driverChrome.findElement(By.cssSelector("textarea[class=er8xn]"));
        inputBox.sendKeys("שלום חבר");
    }

    @AfterClass
    public void closeDriver(){
        driverChrome.quit();
    }
}
