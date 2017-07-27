package tests;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModels.CookiesNoticePageObjectModel;
import pageObjectModels.FooterPageObjectModel;

/**
 * Created by Lenovo G50-70 on 27-07-2017.
 */
public class CountrySelectionTest extends BaseSetup {

    @Test
    public void CountrySelection(){
        logger = extent.createTest("Country Selection Test","Testing country selection dropdown");
        objFooter = new FooterPageObjectModel(driver);
        objCookies = new CookiesNoticePageObjectModel(driver);
        objCookies.acceptCookies();
        logger.log(Status.INFO,"Accepted cookies.");
        objFooter.selectCountry("France");
        logger.log(Status.INFO, "Selected country France from dropdown in footer.");
        String currentURL = driver.getCurrentUrl();
        logger.log(Status.INFO, "Navigated to "+currentURL);
        Assert.assertTrue(currentURL.contains("fr"));
        logger.log(Status.PASS, "Website switched to France.");
    }
}
