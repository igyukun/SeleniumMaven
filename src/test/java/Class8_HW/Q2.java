package Class8_HW;
/*
Open Chrome browser.
 Navigate to Google Translate website:
https://translate.google.com/
 Find translation box (where you enter text to be
translated) using 2 different locators and print the
WebElement you created.
e.g: System.out.println(driver.findElement…
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Q2 {
    private WebDriver driverChrome;
    private String url = "https://translate.google.com/";

    @BeforeClass
    public void initChrome() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome Beta\\Application\\chrome.exe");
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\IGOR\\Documents\\Studies\\QA Experts\\WebDrivers\\chromedriver_win32\\chromedriver.exe");
        driverChrome = new ChromeDriver(options);
    }

    @Test
    public void findTranslationBox(){
        driverChrome.get(url);
        WebElement translBox = driverChrome.findElement(By.cssSelector("textarea[class=er8xn]"));
        System.out.println(translBox);
    }

    @AfterClass
    public void closeDriver(){
        driverChrome.quit();
    }
}
