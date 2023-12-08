package PageObjectModel;

import Utils.CommonMethods;
import Utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeePage extends CommonMethods {


    @FindBy(id="menu_pim_viewPimModule")
    public WebElement pimBtn;

    @FindBy(id="menu_pim_addEmployee")
    public WebElement addEmpBtn;

    @FindBy(id="firstName")
    public WebElement firstNameTextBox;

   @FindBy(id="middleName")
    public WebElement middleNameTextBox;

    @FindBy(id="lastName")
    public WebElement lastNameTextBox;

    @FindBy(id="btnSave")
    public WebElement saveBtn;

// below is the constructor to initialize the object
    public AddEmployeePage(){

        PageFactory.initElements(driver,this);
    }

 }
