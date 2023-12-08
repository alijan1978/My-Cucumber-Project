package StepDefinitions;

import Utils.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends CommonMethods {

    @Before
    public void preConditions(){
        openBrowserAndLaunchApplication();
    }

    @After
    public void postConditions(Scenario scenario){
        byte [] pic;
        if(scenario.isFailed()){
            pic = takeScreenshot("Failed/"+ scenario.getName());
        }else {
            pic = takeScreenshot("Passed/" + scenario.getName());
        }
        scenario.attach(pic, "image/png", scenario.getName());
        closeBrowser();
    }
}

// Hooks annotations will always execute first in the Framework or any class
// To take Screenshot-- Scenario class holds the complete information of your tests execution in Cucumber framework
// Now, we should attach the Screenshot in my Report --> scenario.attach(pic...) line 23