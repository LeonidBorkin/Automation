package pageObjects.tradair;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ClientTradingPage {

    //Widget Icons OFF
    @FindBy(how = How.ID, using = "plus")
    public static WebElement widgetCreate_plus;


    //Widget Icons ON
    @FindBy(how = How.LINK_TEXT, using = "FWD")
    public static WebElement widgetSet_fwd;

    @FindBy(how = How.TAG_NAME, using = "title")
    public static List<WebElement> widgetSet_popout;

    @FindBy(how = How.LINK_TEXT, using = "FWD")
    public static WebElement widgetSet_settings;

    @FindBy(how = How.LINK_TEXT, using = "FWD")
    public static WebElement widgetSet_close;



    //Widget Icons Carousel
    @FindBy(how = How.CSS, using = "*[attributeName='data-widget-name']")
    public static List<WebElement> widgetCarousel_nameIt;

    @FindBy(how = How.NAME, using = "*[attributeName='data-widget-name']")
    public static List<WebElement> widgetCarousel_Market;

    @FindBy(how = How.NAME, using = "*[attributeName='data-widget-name']")
    public static List<WebElement> widgetCarousel_FullSum;



    //Full Sum Widget
    @FindBy(how = How.XPATH, using = "//*[@id='1']/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[2]/div/span[1]")
    public static WebElement fullSumWidget_buy_pre;

    @FindBy(how = How.XPATH, using = "//*[@id='1']/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[2]/div/span[2]")
    public static WebElement fullSumWidget_buy_big;

    @FindBy(how = How.XPATH, using = "//*[@id='1']/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/div[1]/div[2]/div/span[3]")
    public static WebElement fullSumWidget_buy_post;

}
