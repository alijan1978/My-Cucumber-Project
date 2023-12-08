package Utils;

import StepDefinitions.PageInitializer;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.DOMConfiguration;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class CommonMethods extends PageInitializer {

    public static WebDriver driver;

    public static void openBrowserAndLaunchApplication() {
        ConfigReader.readProperties();

        String browserType = ConfigReader.getPropertyValue("browserType");
        switch (browserType) {
            case "Chrome":
                ChromeOptions ops = new ChromeOptions();
                ops.addArguments("--no-sandbox"); // we put limitation to Chrome not check other thing
                ops.addArguments("--remote-allow-origins=*");
                if(ConfigReader.getPropertyValue("Headless").equals("true")){
                    ops.addArguments("--headless=new");
                }
                driver = new ChromeDriver(ops); // pass the ops object of ChromeOptions here/ browser disappear
                break;
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            default:
                driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(Constants.WAIT_TIME));

// Below will initialize all the page we have in our PageInitializer class along with the launching the application
        initializePageObject();

// To Configure the File and the pattern it has--> to define the format what we want Uppercase/Lowercase, Year/Hour format
        DOMConfigurator.configure("log4j.xml");
        Log.startTestCase("This is the beginning of my test case");
        Log.info("My testcase is executing right now");
        Log.warning("My test case might have some trivial issues");

    }

    public static void closeBrowser() {
        Log.info("This test case is about to get completed");
        Log.endTestCase("This test case is finished");
        driver.close();
    }

    public static void doClick(WebElement element){
        element.click();
    }

    public static void sendText(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }

    public static Select clickOnDropDown(WebElement element){
        Select select = new Select(element);
        return select;
    }

    public static void selectByValue(WebElement element, String value){
        clickOnDropDown(element).selectByValue(value);
    }

    public static void selectByVisibleText(WebElement element, String text){
        clickOnDropDown(element).selectByVisibleText(text);
    }

    public static void selectByIndex(WebElement element, int index){
        clickOnDropDown(element).selectByIndex(index);
    }

    public static void selectByOptions(WebElement element, String text){
        List<WebElement> options = clickOnDropDown(element).getOptions();
        for(WebElement option : options){
            String ddlOptionText = option.getText();
            if(ddlOptionText.equals(text)){
                option.click();
            }
        }
    }

//--------------------  SCREENSHOT -----------------------------

    public static byte[] takeScreenshot(String imageName){

// This is casting the webDriver instance "driver" to TakeScreenshot Interface
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
// Below: Screenshots are saved (return type) in Array of byte (small sizes) because we take multiple screenshot
        byte[] pictureBytes = takesScreenshot.getScreenshotAs(OutputType.BYTES);
// Below line captures screenshot and stores it as a file in the sourceFile variable
        File sourcePath = takesScreenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourcePath, new File(Constants.SCREENSHOT_FILEPATH+imageName+getTimeStamp("YYYY-MM-DD-HH-mm-ss")+ ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
// When we deal with some outside source, always use try/catch block
        }
        return pictureBytes; // since return type is byte [] , so we changed the method in line # 89
    }
// Below: getTimeStamp captures the date and time of my system

    public static String getTimeStamp(String pattern){

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);


    }

}






