package tests;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModels.CookiesNoticePageObjectModel;

/**
 * Created by Lenovo G50-70 on 25-07-2017.
 */
public class CookiePopUpTest extends BaseSetup {

    @Test
    public void cookiePopupAppeared(){
        logger = extent.createTest("Cookies PopUp Test");
        objCookies = new CookiesNoticePageObjectModel(driver);
        Boolean cookiesPopupApeared = objCookies.verifyCookiesPopup();
        Assert.assertTrue(cookiesPopupApeared);
        logger.log(Status.PASS, "Cookie Pop Up Appeared.");
        objCookies.acceptCookies();
        logger.log(Status.INFO, "Clicked on 'OK' button on cookies pop-up.");
        System.out.println("Test Passed.");
    }
}
