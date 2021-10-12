package extentions;

import io.qameta.allure.Step;
import lpsim.ReceiverApp;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pageObjects.tradair.ClientHomePage;
import pageObjects.tradair.ClientTradingPage;
import utilities.CommonOps;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class UIActions extends CommonOps {

    final static String CAROUSEL_WIDGET_MARKET = "Market";
    final static String CAROUSEL_WIDGET_NAME = "carousel_widgetName";

    @Step("Click On Element")
    public static void click(WebElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.click();
    }

    @Step("Double Click On Element")
    public static void doubleClickFromCarousel(WebElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        action.doubleClick(elem).build().perform();
    }

    @Step("Update Text Element")
    public static void updateText(WebElement elem, String text) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }

    @Step("Update DropDown Element ")
    public static void updateDropDown(WebElement elem, String value) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        Select dropdown = new Select(elem);
        dropdown.selectByVisibleText(value);
    }

    @Step("Mouse Hover Element")
    public static void mouseHover(WebElement elem1, WebElement elem2) {
        wait.until(ExpectedConditions.visibilityOf(elem1));
        action.moveToElement(elem1).moveToElement(elem2).build().perform();
    }

    @Step("Switch Top Panel Tab")
    public static void switchTopPanelTab(WebElement elem) {
        UIActions.click(elem);
    }

    @Step("Choose Item From Carousel")
    public static void chooseFromCarousel(List<WebElement> carouselList, String nodeName) {
        for (WebElement widget:carouselList) {

        }
    }

    public static void loopCarouselByTextDoubleClick(String widgetName, String widgetText){
        List<WebElement> elements = driver.findElements(By.className(widgetName));
        for (WebElement element : elements) {
            if (element.getAttribute("text").equalsIgnoreCase(widgetText)) {
                action.doubleClick(element);
                //element.click();
                break;
            }
        }
    }


    @Step("Add Widget")
    public static void addWidget_____try() {
       UIActions.click(ClientTradingPage.widgetCreate_plus);
       loopCarouselByTextDoubleClick(CAROUSEL_WIDGET_NAME, CAROUSEL_WIDGET_MARKET);
       //UIActions.doubleClick(ClientHomePage.widgetCarousel_nameIt);
    }

    @Step("Remove Widget")
    public static void removeWidget____try() {
        WebElement c = driver.findElement(By.tagName("Close"));
        //List<WebElement> webElementList =
    }

    @Step("Configure Widget 1")
    public static void configWidget(String ccpPair, String platform, String tif, String mode){

    }

    @Step("Configure Widget JS")
    public static void closeAllWidgets() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Object widget = js.executeScript("return document.querySelectorAll('div > a.taIcon.theme-text-color-disabled.fa.fa-times');").toString();

        if (widget != null){
            List allWidgets = (List) widget;
            for(Object element : allWidgets){
                RemoteWebElement re = (RemoteWebElement) element;
                try {
                    Thread.sleep(2_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                re.click();
            }
            allWidgets.forEach(System.err::println);
        }

    }


}
