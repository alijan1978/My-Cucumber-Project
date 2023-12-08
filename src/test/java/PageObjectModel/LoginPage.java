package PageObjectModel;

import Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// Page Factory Model
public class LoginPage extends CommonMethods {


  public LoginPage(){

      PageFactory.initElements(driver,this);
// Constructor to initialize web elements that use in PageFactory with driver in this LoginPage
// since in below page factory approach, we are not related to the web element by driver, so we create constructor
  }

//    WebElement userNameTextBox = driver.findElement(By.id("txtUsername"));
    //    WebElement loginBtn = driver.findElement(By.id("btnLogin"));
    //    WebElement passwordTextBox = driver.findElement(By.id("txtPassword"));

    @FindBy(id="txtUsername")
    public WebElement userNameTextBox;


    @FindBy(id="txtPassword")
    public WebElement passwordTextBox;

    @FindBy(id="btnLogin")
    public WebElement loginBtn;

//WebElement welcomeIcon = driver.findElement(By.id("welcome"));
//WebElement logoutLink = driver.findElement(By.xpath("//a[text()='Logout']"));

    @FindBy(id="welcome")
    public WebElement welcomeIcon;

    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement logoutLink;



}
