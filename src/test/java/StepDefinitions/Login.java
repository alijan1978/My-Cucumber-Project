package StepDefinitions;

import PageObjectModel.LoginPage;
import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

public class Login extends CommonMethods {

    @Given("Open the browser and launch HRMS application")
    public void open_the_browser_and_launch_hrms_application() {

        openBrowserAndLaunchApplication();
    }

    @When("User enters valid email and valid password")
    public void user_enters_valid_email_and_valid_password() {
//        driver.findElement(By.id("txtUsername")).sendKeys(ConfigReader.getPropertyValue("username"));

        //    WebElement userNameTextBox = driver.findElement(By.id("txtUsername"));
        //    WebElement passwordTextBox = driver.findElement(By.id("txtPassword"));
//        LoginPage login= new LoginPage();

    sendText(login.userNameTextBox, ConfigReader.getPropertyValue("username"));
    sendText(login.passwordTextBox, ConfigReader.getPropertyValue("password"));

    }
    @When("Click on login button")
    public void click_on_login_button() {
// WebElement loginBtn = driver.findElement(By.id("btnLogin"));

//        LoginPage login = new LoginPage();
        doClick(login.loginBtn);

    }
    @Then("User is logged in successfully")
    public void user_is_logged_in_successfully() {

        boolean userLoggedIn = driver.findElement(By.xpath("//a[contains(text(),'Welcome')]")).isDisplayed();
        if (userLoggedIn) {
            System.out.println("User is logged in Successfully");
        }
    }

    @Then("Close the browser")
        public void close_the_browser() {
          closeBrowser();
    }

    @When("User enters valid {string} and valid {string}")
    public void user_enters_valid_and_valid(String username, String password) {

//        WebElement userNameTextBox = driver.findElement(By.id("txtUsername"));
//        WebElement passwordTextBox = driver.findElement(By.id("txtPassword"));

//        LoginPage login = new LoginPage();

        sendText(login.userNameTextBox, username);
        sendText(login.passwordTextBox, password);
    }

        @When("user enters username and password and verifies login")
        public void user_enters_username_and_password_and_verifies_login(DataTable dataTable) {

//        LoginPage login = new LoginPage();

            List<Map<String,String>> userCredentials  = dataTable.asMaps();
            for(Map<String,String> userCreds : userCredentials){
                String username = userCreds.get("username");
                String password = userCreds.get("password");
//                WebElement userNameTextBox = driver.findElement(By.id("txtUsername"));
                sendText(login.userNameTextBox, username);
//                WebElement passwordTextBox = driver.findElement(By.id("txtPassword"));
                sendText(login.passwordTextBox, password);
//                WebElement loginBtn = driver.findElement(By.id("btnLogin"));
                doClick(login.loginBtn);

//                WebElement welcomeIcon = driver.findElement(By.id("welcome"));
                doClick(login.welcomeIcon);
//                WebElement logoutLink = driver.findElement(By.xpath("//a[text()='Logout']"));
                doClick(login.logoutLink);



        }
    }
}
