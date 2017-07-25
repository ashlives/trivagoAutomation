package room5.trivago.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Lenovo G50-70 on 25-07-2017.
 */
public class HeaderPageObjectModel {
    WebDriver driver;

    public HeaderPageObjectModel(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "cookie-notice")
    WebElement cookieNotice;

    @FindBy(id = "cn-accept-cookie")
    WebElement cookieOkBtn;

    @FindBy(className = "nav-icon")
    WebElement menuBtn;

    @FindBy(className = "room5-icons-search")
    WebElement searchBtn;

    public void acceptCookies(){
        cookieOkBtn.click();
    }

    public Boolean verifyCookiesPopup(){
        Boolean status = cookieNotice.isDisplayed();
        return status;
    }
}
