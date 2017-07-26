package room5.trivago.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Lenovo G50-70 on 26-07-2017.
 */
public class ContactPageObjectModel {
    WebDriver driver;

    public ContactPageObjectModel(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "message")
    WebElement txtMessage;

    @FindBy(id = "full_name")
    WebElement txtFullName;

    @FindBy(id = "email")
    WebElement txtEmail;

    @FindBy(id = "contactform-submit")
    WebElement btnSubmit;

    public void enterMessage(String text){
        txtMessage.sendKeys(text);
    }

    public void enterEmail(String text){
        txtEmail.sendKeys(text);
    }

    public void enterFullName(String text){
        txtFullName.sendKeys(text);
    }

    public void clickSubmit(){
        btnSubmit.click();
    }
}
