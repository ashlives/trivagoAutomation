package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import room5.trivago.pages.HeaderPageObjectModel;

/**
 * Created by Lenovo G50-70 on 25-07-2017.
 */
public class CookiePopUpTest extends BaseSetup {
    HeaderPageObjectModel objHeader;

    @Test
    public void cookiePopupAppeared(){
        objHeader = new HeaderPageObjectModel(driver);
        Boolean cookiesPopupApeared = objHeader.verifyCookiesPopup();
        Assert.assertTrue(cookiesPopupApeared);
        objHeader.acceptCookies();
    }
}
