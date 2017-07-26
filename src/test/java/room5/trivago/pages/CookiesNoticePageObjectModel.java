package room5.trivago.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Lenovo G50-70 on 26-07-2017.
 */
public class CookiesNoticePageObjectModel {
    WebDriver driver;

    public CookiesNoticePageObjectModel(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "cookie-notice")
    WebElement cookieNotice;

    @FindBy(id = "cn-accept-cookie")
    WebElement cookieOkBtn;

    public void acceptCookies(){
        cookieOkBtn.click();
        System.out.println("Accepted cookies notice.");
    }

    public Boolean verifyCookiesPopup(){
        Boolean status = cookieNotice.isDisplayed();
        if (status=true){
            System.out.println("Cookies Notice displayed.");
        } else
            System.out.println("Cookies Notice not appeared.");
        return status;
    }
}