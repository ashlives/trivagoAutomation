package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Created by Lenovo G50-70 on 25-07-2017.
 */
public class BaseSetup {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium Webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://room5.trivago.com/");
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
