package Class8_HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*
Open Chrome browser on Amazon website:
https://www.amazon.com/
 Assert website title.
 Search for “Leather shoes”.
 */
public class Q5 {
    private WebDriver driverChrome;
    private final String url = "https://www.amazon.com/";
    private final String title = "Amazon.com. Spend less. Smile more.";
    private final String searchProduct = "Leather shoes";
    private final String titleSearchProduct = "Amazon.com : Leather shoes";

    @BeforeClass
    public void initChrome() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome Beta\\Application\\chrome.exe");
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\IGOR\\Documents\\Studies\\QA Experts\\WebDrivers\\chromedriver_win32\\chromedriver.exe");
        driverChrome = new ChromeDriver(options);
        driverChrome.get(url);
    }

    @Test (priority = 0)
    public void findTitle(){
        Assert.assertEquals(driverChrome.getTitle(),title);
    }

    @Test (priority = 1)
    public void searchOnSite(){

        WebElement searchBox = driverChrome.findElement(By.id("twotabsearchtextbox"));
       // driverChrome.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        searchBox.sendKeys(searchProduct);
        searchBox.submit();
        driverChrome.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals(driverChrome.getTitle(),titleSearchProduct);
    }

    @AfterClass
    public void closeDriver(){
        driverChrome.quit();
    }
}
