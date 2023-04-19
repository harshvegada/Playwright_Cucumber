package steps;

import base.PredefinedActions;
import com.epam.reportportal.service.ReportPortal;
import com.epam.ta.reportportal.ws.model.FinishTestItemRQ;
import com.epam.ta.reportportal.ws.model.StartRQ;
import com.epam.ta.reportportal.ws.model.StartTestItemRQ;
import com.epam.ta.reportportal.ws.model.launch.StartLaunchRQ;
import com.epam.ta.reportportal.ws.model.log.SaveLogRQ;
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
