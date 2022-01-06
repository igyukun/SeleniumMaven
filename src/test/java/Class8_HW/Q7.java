package Class8_HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

/*
 Open Youtube web page
 Type a name of a song (any)
 Click on search.
 */
public class Q7 {
    private WebDriver driverChrome;
    private String url = "https://www.youtube.com/";

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
    public void searchSong() {
        WebElement searchBox = driverChrome.findElement(By.cssSelector("input[id=search]"));
        searchBox.sendKeys("Winterhorde Maestro");
        searchBox.submit();
        driverChrome.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println(driverChrome.getTitle());
    }
}
