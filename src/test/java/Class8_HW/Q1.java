package Class8_HW;
/*
Write a TestNG test that will open the following:
a. Chrome – https://www.walla.co.il
b. FireFox – https://www.ynet.co.il
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Q1 {
    private WebDriver driverChrome;
    private WebDriver driverFireFox;
    private String urlWalla = "https://www.walla.co.il";
    private String urlYnet = "https://www.ynet.co.il";


    @BeforeClass
    public void initChrome() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome Beta\\Application\\chrome.exe");
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\IGOR\\Documents\\Studies\\QA Experts\\WebDrivers\\chromedriver_win32\\chromedriver.exe");
        driverChrome = new ChromeDriver(options);
    }

    @BeforeClass
    public void initFireFoxDriver(){
        System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\IGOR\\Documents\\Studies\\QA Experts\\WebDrivers\\geckodriver-v0.30.0-win64\\geckodriver.exe");
        driverFireFox = new FirefoxDriver();
    }

    @Test
    public void openUrlChrome() {
        driverChrome.get(urlWalla);
    }

    @Test
    public void openUrlFireFox() {
        driverFireFox.get(urlYnet);
    }

    @AfterClass
    public void closeDriver(){
        driverChrome.quit();
        driverFireFox.quit();
    }
}
