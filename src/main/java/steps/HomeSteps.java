package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.opentest4j.TestSkippedException;
import pages.HomePage;

import java.io.File;

public class HomeSteps {

    HomePage homePage = new HomePage();
    static int counter = 0;

    @When("User search for product {string} in search bar")
    public void userSearchForProductInSearchBar(String productName) {
        homePage.searchForItem(productName);
    }

    @Then("User validate product name {string} displayed in title tab")
    public void userValidateProductNameDisplayedInTitleTab(String productName) {
        Assert.assertTrue("Product Title not coming", homePage.getSearchedValue().contains(productName));
    }

    @And("User scroll till text {string} on page")
    public void userScrollTillTextOnPage(String text) {
        Assert.assertTrue("Unable to find text: " + text, homePage.lookForText(text));
    }

    @And("User applied filter on {string} select the value {string}")
    public void userAppliedFilterAs(String filterType, String filyterValues) {
        homePage.applyFilter(filterType, filyterValues);
    }
}
