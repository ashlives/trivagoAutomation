package tests;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjectModels.*;

/**
 * Created by Lenovo G50-70 on 26-07-2017.
 */
public class ContactUsFormTest extends BaseSetup {
    FooterPageObjectModel objFooter;
    ContactPageObjectModel objContact;
    CookiesNoticePageObjectModel objCookies;

    @BeforeClass
    public void navigateToContact(){
        objFooter = new FooterPageObjectModel(driver);
        objContact = new ContactPageObjectModel(driver);
        objCookies = new CookiesNoticePageObjectModel(driver);
        if(objCookies.verifyCookiesPopup()){
        objCookies.acceptCookies();}
        objFooter.clickContact();
    }

    @Test
    public void contactTestSuccess(){
        logger = extent.createTest("Contact Form Test - Sucess Message");
        String messageText = "some message";
        String email = "ademo@email.com";
        String fullName = "some name";
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

    @Test
    public void contactTestFailure(){
        String messageText = "some message";
        String email = "ademo@email.com";
        String fullName = "";
        logger = extent.createTest("Contact Form Test - Failure Message");
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
        Assert.assertEquals(status, "Error");
        logger.log(Status.PASS, "Test Passed.");
        System.out.print("Test Passed.");
    }
}
