package steps;

import base.PredefinedActions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println(ANSI_BLUE + "Scenario Started: " + scenario.getName() + ANSI_RESET);
        PredefinedActions.startBrowser("", "");
    }


    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println(ANSI_RED+ "Scenario Failed: " + scenario.getName()+ANSI_RESET);
            scenario.attach(PredefinedActions.capatureScreenShot(), "image/png", scenario.getName());
        }
        System.out.println(ANSI_GREEN+"Scenario Passed: " + scenario.getName()+ANSI_RESET);
        PredefinedActions.closeBrowser();
    }

}
