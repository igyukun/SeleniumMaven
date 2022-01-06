package Class8_HW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
Q: Is running tests on multiple browsers in parallel is
possible? Which tool can be used for it?

A: By initializing two instances of WebDriver and working with them
 */

public class Q10 {
    private WebDriver driverChrome1;
    private WebDriver driverChrome2;
    private String url1 = "https://www.facebook.com/";
    private String url2 = "https://www.amazon.com/";

    @BeforeClass
    public void initChrome() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome Beta\\Application\\chrome.exe");
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\IGOR\\Documents\\Studies\\QA Experts\\WebDrivers\\chromedriver_win32\\chromedriver.exe");
        driverChrome1 = new ChromeDriver(options);
        driverChrome2 = new ChromeDriver(options);
    }

    @Test
    public void runTwoBrowsers(){
        System.out.println("Kuku");
        driverChrome1.get(url1);
        driverChrome2.get(url2);
    }
}
