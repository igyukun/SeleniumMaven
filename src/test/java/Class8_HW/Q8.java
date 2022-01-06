package Class8_HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
 Open Chrome browser on Facebook website
https://www.facebook.com/
 Login into Facebook (No need to send me credentials).
 */
public class Q8 {
    private WebDriver driverChrome;
    private String url = "https://www.facebook.com/";
    private String username = "blablabla@gmail.com";
    private String password = "SoMePaSsWoRd";

    @BeforeClass
    public void initChrome() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome Beta\\Application\\chrome.exe");
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\IGOR\\Documents\\Studies\\QA Experts\\WebDrivers\\chromedriver_win32\\chromedriver.exe");
        driverChrome = new ChromeDriver(options);
        driverChrome.get(url);
    }

    @Test
    public void loginFB(){
        WebElement usernameField = driverChrome.findElement(By.name("email"));
        WebElement passwordField = driverChrome.findElement(By.name("pass"));
        WebElement loginButton = driverChrome.findElement(By.name("login"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.submit();
    }
}
