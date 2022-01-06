package Class8_HW;
/*
Open FireFox browser.
 Navigate to selenium website:
http://www.seleniumhq.org/
 Find the search text field using name locator and print
the WebElement you created.
e.g. System.out.println(driver.findElement…)
 Send the word “selenium” to this text box
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;


public class Q4 {
    private WebDriver driverFireFox;
    private String url = "http://www.seleniumhq.org/";

    @BeforeClass
    public void initFireFoxDriver(){
        System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\IGOR\\Documents\\Studies\\QA Experts\\WebDrivers\\geckodriver-v0.30.0-win64\\geckodriver.exe");
        driverFireFox = new FirefoxDriver();
    }

    @Test
    public void findSearchBox(){
        driverFireFox.get(url);
        List<WebElement> searchboxes = driverFireFox.findElements(By.cssSelector("input"));
        for(WebElement w: searchboxes){
            if (w.getAttribute("type").equalsIgnoreCase("search"))
                System.out.printf("Found: %d elements. The matching one is: %s.", searchboxes.size(), w);
        }
    }

    @AfterClass
    public void closeDriver(){
        driverFireFox.quit();
    }
}
