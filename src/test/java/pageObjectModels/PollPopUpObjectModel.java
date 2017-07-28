package pageObjectModels;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

/**
 * Created by Lenovo G50-70 on 25-07-2017.
 */
public class PollPopUpObjectModel {
    WebDriver driver;

    public PollPopUpObjectModel(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    @FindBy(xpath = "//*[@id='_hj_poll_container']/div/a/span")
    WebElement popupOpenClose;

    @FindBy(xpath = ".//*[@id='_hj_poll_container']/div/div[3]/div[1]/div/ul/li")
    List<WebElement> popupScores;

    @FindBy(xpath = ".//*[@id='_hj_poll_container']/div/div[3]/div[2]/div[2]")
    WebElement sendBtn;

    @FindBy(xpath = ".//*[@id='_hj_poll_container']/div/div[4]/p")
    WebElement postSubmitMesg;

    @FindBy(xpath = ".//*[@id='_hj_poll_container']/div/div[4]//p/button")
    WebElement closeBtn;

    public void selectScore(String score){
        for (WebElement opt:popupScores){
            if (opt.getText().equals(score)){
                opt.click();
                return;
            }
        }
        throw new NoSuchElementException("Can't find " + score + " in dropdown");
    }

    public void clickSend(){
        sendBtn.click();
    }

    public String getMsg(){
        return postSubmitMesg.getText();
    }

    public void clickClose(){
        closeBtn.click();
    }
}
