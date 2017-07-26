package tests;

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

    @Test
    public void contactTest(){
        objFooter = new FooterPageObjectModel(driver);
        objContact = new ContactPageObjectModel(driver);
        objCookies = new CookiesNoticePageObjectModel(driver);
        objCookies.acceptCookies();
        objFooter.clickContact();
        objContact.enterMessage("Some message");
        objContact.enterEmail("ademo@email.com");
        objContact.enterFullName("My Name");
        objContact.clickSubmit();
    }
}
