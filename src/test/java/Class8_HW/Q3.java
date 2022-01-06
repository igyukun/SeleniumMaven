package Class8_HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
 Open FireFox browser.
 Navigate to youtube: https://www.youtube.com/
 Find Youtube button using id locator and print the
WebElement you created.
e.g. System.out.println(driver.findElement…)
 */
public class Q3 {
    private WebDriver driverFireFox;
    private String url = "https://www.youtube.com/";

    @BeforeClass
    public void initFireFoxDriver(){
        System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\IGOR\\Documents\\Studies\\QA Experts\\WebDrivers\\geckodriver-v0.30.0-win64\\geckodriver.exe");
        driverFireFox = new FirefoxDriver();
    }

    @Test
    public void getButtonElement(){
        driverFireFox.get(url);
        WebElement button = driverFireFox.findElement(By.id("logo"));
        System.out.println(button);
    }

    @AfterClass
    public void closeDriver(){
        driverFireFox.quit();
    }
}
