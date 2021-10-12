package extentions;

import io.qameta.allure.Step;
import lpsim.FIXReceiver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import quickfix.*;
import utilities.CommonOps;

import java.util.List;

public class Verifications extends CommonOps {

    @Step("Verify Text In Element")
    public static void verifyVisibilityOfElement(WebElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        Assert.assertTrue(elem.isDisplayed(), "Sorry " + elem.getText() + " not Displayed");
    }

    @Step("Verify Text In Element")
    public static void verifyTextElement(WebElement elem, String expected) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        Assert.assertEquals(elem.getText(), expected);
    }

    @Step("Verify Number of Elements")
    public static void numberOfElements(List<WebElement>elems, String expected) {
        wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size()-1)));
        Assert.assertEquals(elems.size(), expected);
    }

    @Step("Verify Visibility of Elements")
    public static void visibilityOfElements(List<WebElement> elems) {
        for (WebElement elem:elems){
            softAssert.assertTrue(elem.isDisplayed(), "Sorry " + elem.getText() + " not Displayed");
        }
        softAssert.assertAll("Some Elements Weren't Displayed");
    }

    @Test
    public static void priceAssert(WebElement elem, FIXReceiver fix, SessionID sessionID, Message message) throws UnsupportedMessageType, IncorrectTagValue, FieldNotFound, IncorrectDataFormat {
        wait.until(ExpectedConditions.visibilityOf(elem));
        //String myFix = myApp.fromApp(message, sessionID);
        //Assert.assertEquals(elem.getText().equalsIgnoreCase(myApp.fromApp(message, sessionID)));

    }



}
