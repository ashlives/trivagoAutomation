package pageObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * Created by Lenovo G50-70 on 25-07-2017.
 */
public class HeaderPageObjectModel {
    WebDriver driver;

    public HeaderPageObjectModel(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    @FindBy(className = "nav-icon")
    WebElement menuBtn;

    @FindBy(className = "room5-icons-search")
    WebElement searchBtn;

    @FindBy(className = "logo home-page-link")
    WebElement home;

    @FindBy(className = "nav-icon open")
    WebElement closeNavMenuBtn;

}
