package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import Utils.Constants;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddEmployee extends CommonMethods {

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {

//        WebElement pimBtn = driver.findElement(By.id("menu_pim_viewPimModule"));
        doClick(addEmployeePage.pimBtn);

    }
    @When("user clicks on add employee button")
    public void user_clicks_on_add_employee_button() {

//        WebElement addEmpBtn = driver.findElement(By.id("menu_pim_addEmployee"));
        doClick(addEmployeePage.addEmpBtn);

    }
    @When("user enters firstname and middle name lastname")
    public void user_enters_firstname_and_middle_name_lastname() {

//        driver.findElement(By.id("firstName")).sendKeys(ConfigReader.getPropertyValue("firstName"));
//        driver.findElement(By.id("middleName")).sendKeys(ConfigReader.getPropertyValue("middleName"));
//        driver.findElement(By.id("lastName")).sendKeys(ConfigReader.getPropertyValue("lastName"));

//     WebElement firstNameTextBox = driver.findElement(By.id("firstName"));
     sendText(addEmployeePage.firstNameTextBox, ConfigReader.getPropertyValue("firstName"));

//     WebElement middleNameTextBox = driver.findElement(By.id("middleName"));
     sendText(addEmployeePage.middleNameTextBox, ConfigReader.getPropertyValue("middleName"));

//     WebElement lastNameTextBox = driver.findElement(By.id("lastName"));
     sendText(addEmployeePage.lastNameTextBox, ConfigReader.getPropertyValue("lastName"));


    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {

//        WebElement saveBtn = driver.findElement(By.id("btnSave"));
        doClick(addEmployeePage.saveBtn);
    }
    @When("close the browser")
    public void close_the_browser() {
        closeBrowser();
    }



}
