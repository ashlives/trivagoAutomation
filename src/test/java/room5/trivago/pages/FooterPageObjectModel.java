package room5.trivago.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Lenovo G50-70 on 25-07-2017.
 */
public class FooterPageObjectModel {
    WebDriver driver;

    public FooterPageObjectModel(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "select-country")
    WebElement countryDropdown;

    @FindBy(xpath = ".//*[@id='footer']/div/div/div[2]/div/ul/li[1]/a")
    WebElement about;

    @FindBy(xpath = ".//*[@id='footer']/div/div/div[2]/div/ul/li[2]/a")
    WebElement contact;

    @FindBy(xpath = ".//*[@id='footer']/div/div/div[2]/div/ul/li[3]/a")
    WebElement downloadApp;

    @FindBy(xpath = ".//*[@id='footer']/div/div/div[2]/div/ul/li[4]/a")
    WebElement cookiePolicy;
}
