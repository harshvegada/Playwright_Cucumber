package steps;

import base.PredefinedActions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        PredefinedActions.startBrowser("", "");
    }


    @After
    public void afterScenario(Scenario scenario) {
        if(scenario.isFailed())
            scenario.attach(PredefinedActions.capatureScreenShot(),"image/png",scenario.getName());
        PredefinedActions.closeBrowser();
    }

}
