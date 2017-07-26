package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import room5.trivago.pages.CookiesNoticePageObjectModel;
import room5.trivago.pages.HeaderPageObjectModel;

/**
 * Created by Lenovo G50-70 on 25-07-2017.
 */
public class CookiePopUpTest extends BaseSetup {
    CookiesNoticePageObjectModel objHeader;

    @Test
    public void cookiePopupAppeared(){
        objHeader = new CookiesNoticePageObjectModel(driver);
        Boolean cookiesPopupApeared = objHeader.verifyCookiesPopup();
        Assert.assertTrue(cookiesPopupApeared);
        objHeader.acceptCookies();
        System.out.print("Test Passed.");
    }
}
