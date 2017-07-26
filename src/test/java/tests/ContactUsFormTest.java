package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import room5.trivago.pages.ContactPageObjectModel;
import room5.trivago.pages.CookiesNoticePageObjectModel;
import room5.trivago.pages.FooterPageObjectModel;

/**
 * Created by Lenovo G50-70 on 26-07-2017.
 */
public class ContactUsFormTest extends BaseSetup {
    FooterPageObjectModel objFooter;
    ContactPageObjectModel objContact;
    CookiesNoticePageObjectModel objCookies;

    @BeforeTest
    public void navigateToContact(){
        objFooter = new FooterPageObjectModel(driver);
        objContact = new ContactPageObjectModel(driver);
        objCookies = new CookiesNoticePageObjectModel(driver);
        objCookies.acceptCookies();
        objFooter.clickContact();
    }

    @Test
    public void contactTestSuccess(){
        objContact.enterMessage("Some message");
        objContact.enterEmail("ademo@email.com");
        objContact.enterFullName("My Name");
        objContact.clickSubmit();
        String status = objContact.getSuccessStatus();
        Assert.assertEquals(status, "Success");
        System.out.print("Test Passed.");
    }

    @Test
    public void contactTestFailure(){
        objContact.enterMessage("Some message");
        objContact.enterEmail("");
        objContact.enterFullName("My Name");
        objContact.clickSubmit();
        String status = objContact.getSuccessStatus();
        Assert.assertEquals(status, "Error");
        System.out.print("Test Passed.");
    }
}
