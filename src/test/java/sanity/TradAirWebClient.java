package sanity;

import extentions.UIActions;
import extentions.Verifications;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.w3c.dom.*;
import pageObjects.tradair.ClientHomePage;
import pageObjects.tradair.ClientTradingPage;
import quickfix.FieldNotFound;
import quickfix.IncorrectDataFormat;
import quickfix.IncorrectTagValue;
import quickfix.UnsupportedMessageType;
import utilities.CommonOps;
import workflows.WebFlow;

import static pageObjects.tradair.ClientTradingPage.*;


@Listeners(utilities.Listeners.class)
public class TradAirWebClient extends CommonOps {


    @Test(priority = 0, description = "Test 1 - Login")
    @Description("This Test Login and Verify Header")
    public void tradAirUserLoginTest(){
        WebFlow.skipConnectionIsNotPrivate();
        WebFlow.loginTradAir("LeoAutoTest", "Panda230");
        WebFlow.VerifyLogo();
    }

    @Test(priority = 1)
    @Description("This Test Switch Tab and Add Widget")
    public void tradAirUserBuyTest(){
        UIActions.switchTopPanelTab(ClientHomePage.topPanelTab_Trading);
        //UIActions.addWidget_____try();

    }

    @Test(priority = 2)
    @Description("This Test Sends Price To LP")
    public static void taFixTest() throws UnsupportedMessageType, IncorrectTagValue, FieldNotFound, IncorrectDataFormat, InterruptedException {
        /*int counter = 0;

        while (!myApp.isLoggedOn() || counter>=5){
            Thread.sleep(500);
            counter++;
        }

        if (!myApp.isLoggedOn()){
            System.out.println("Counter Reached maximum loop, App not LoggedOn !!!!! ");
            return;
        }*/
        myApp.sendPrice(1.11111, 1.22222);
        //WebFlow.getRates("EUR/USD", );



        //WebFlow.runReceiverApp();
    }


    @Test(priority = 3)
    @Description("This Test Verifies the buy and sell price of Full Sum Table")
    public static void fullSumTest(){

        WebFlow.getWidgetFullPrice(getData("EUR_USD"), fullSumWidget_buy_pre, fullSumWidget_buy_big, fullSumWidget_buy_post);


        /*WebElement elem = driver.findElement(By.xpath("//*[@id='1']/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/div[1]/div[2]/div/span[1]"));
        String preNum1, bigNum1, postNum1, fiNum1;
        double preNum2, bigNum2, postNum2, fiNum2;
        float preNum3, bigNum3, postNum3, fiNum3;






         //WebElement element = fullSumWidget_buy_pre_css
        //System.out.println("elem txt ==  " +elem.getAttribute("price"));
        //System.out.println("elem text: " + elem.getAttribute("value"));
        //preNum1 = String.valueOf(fullSumWidget_buy_pre_xpath.getCssValue(""));
        //fiNum3 = Float.parseFloat(fullSumWidget_buy_pre.getText());
        //preNum2 = Double.parseDouble(fullSumWidget_buy_pre_xpath.getAttribute("value"));


        preNum1  = fullSumWidget_buy_pre.getText();
        bigNum1 = fullSumWidget_buy_big.getText();
        postNum1 = fullSumWidget_buy_post.getText();
        //fiNum = preNum.concat(bigNum).concat(postNum);

        //System.out.println(fiNum);

        System.err.println(" THIS IS preNUm: " + preNum1);
        System.err.println(" THIS IS bigNum: " + bigNum1);
        System.err.println(" THIS IS postNUm: " + postNum1);*/




    }





}
