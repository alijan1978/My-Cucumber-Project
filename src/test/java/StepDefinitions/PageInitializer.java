package StepDefinitions;

import PageObjectModel.AddEmployeePage;
import PageObjectModel.LoginPage;

public class PageInitializer {

// This class will manage the object creation of different page objects in our framework.
// instead of calling the page objects repeatedly, this class will take care of that step.

    public static LoginPage login; // make LoginPage as global variable to be accessed in whole class

    public static AddEmployeePage addEmployeePage; // global variable

    public static void initializePageObject(){

        login = new LoginPage();
        addEmployeePage = new AddEmployeePage();


    }

}
