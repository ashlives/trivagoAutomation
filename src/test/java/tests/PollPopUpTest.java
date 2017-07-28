package tests;

import com.aventstack.extentreports.Status;
import org.junit.Assert;
import org.testng.annotations.Test;
import pageObjectModels.PollPopUpObjectModel;

/**
 * Created by Lenovo G50-70 on 28-07-2017.
 */
public class PollPopUpTest extends BaseSetup {

    @Test
    public void pollPopup(){
        String score = "5";
        logger = extent.createTest("Poll PopUp Test", "Testing the poll popup by submitting a poll.");
        objPoll = new PollPopUpObjectModel(driver);
        objPoll.selectScore(score);
        logger.log(Status.INFO,"Gave score of "+score);
        objPoll.clickSend();
        logger.log(Status.INFO,"Clicked on Send button");
        String message = objPoll.getMsg();
        logger.log(Status.INFO,"Got message "+message);
        Assert.assertTrue(message.contains("Thank you"));
        logger.log(Status.PASS,"Test Passed");
        objPoll.clickClose();
        logger.log(Status.INFO,"Clicked Close button.");
    }
}
