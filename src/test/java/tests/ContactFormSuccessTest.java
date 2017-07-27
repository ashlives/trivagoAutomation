package tests;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModels.*;

/**
 * Created by Lenovo G50-70 on 26-07-2017.
 */
public class ContactFormSuccessTest extends BaseSetup {

    @Test
    public void contactTestSuccess(){
        logger = extent.createTest("Contact Form Test - Sucess Message", "Testing the contact form functionality with all fields correctly filled.");
        String messageText = "some message";
        String email = "ademo@email.com";
        String fullName = "some name";
        objFooter = new FooterPageObjectModel(driver);
        objContact = new ContactPageObjectModel(driver);
        objCookies = new CookiesNoticePageObjectModel(driver);
        objCookies.acceptCookies();
        logger.log(Status.INFO,"Accepted cookies.");
        objFooter.clickContact();
        logger.log(Status.INFO,"Clicked on Contact link in footer.");
        objContact.enterMessage(messageText);
        logger.log(Status.INFO, "Entered message test: "+messageText);
        objContact.enterEmail(email);
        logger.log(Status.INFO, "Entered email: "+email);
        objContact.enterFullName(fullName);
        logger.log(Status.INFO, "Entered full name: "+fullName);
        objContact.clickSubmit();
        logger.log(Status.INFO, "Clicked on Submit button");
        String status = objContact.getSuccessStatus();
        logger.log(Status.INFO, "Status of message: "+status);
        Assert.assertEquals(status, "Success");
        logger.log(Status.PASS, "Test Passed.");
        System.out.println("Test Passed.");
    }
}
