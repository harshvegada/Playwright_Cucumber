package pages;

import base.PredefinedActions;


public class HomePage extends PredefinedActions {

    private String amazonSearchBar = "#twotabsearchtextbox";
    private String searchBarIcon = "//input[contains(@id,'search-submit-button')]";
    private String searchedProduct = "span.a-color-state.a-text-bold";
    private String allText = "//node()[contains(text(),'%s')]";
    private String seeMoreButtonForFilters = "//div[@id='brandsRefinements']//span[text()='%s']/parent::div//following-sibling::ul//span[contains(text(),'See more')]";
    private String filterOptionsSelection = "//span[contains(text(),'%s')]/parent::div//following-sibling::ul//span[text()='%s']";

    public void searchForItem(String itemtoBeSearch) {
        setText(amazonSearchBar, itemtoBeSearch);
        clickOnElement(searchBarIcon);
    }

    public String getPageTitle() {
        return getTitleOfPage();
    }

    public String getSearchedValue() {
        return getTextOfElement(searchedProduct);
    }

    public boolean lookForText(String text) {
        String locator = String.format(allText, text);
        scrolTillLocator(locator);
        return isLocatorVisible(locator);
    }

    public void applyFilter(String filterType, String filterValues) {
        clickOnSeeMoreIfDisplayed(filterType);
        for (int index = 0; index < filterValues.split("!").length; index++) {
            selectFilterValues(filterType, filterValues.split("!")[index]);
        }
    }

    private void selectFilterValues(String filterType, String filterValue) {
        clickOnElement(String.format(filterOptionsSelection, filterType, filterValue));
    }

    private void clickOnSeeMoreIfDisplayed(String filter) {
        if (isLocatorVisible(String.format(seeMoreButtonForFilters, filter)))
            clickOnElement(String.format(seeMoreButtonForFilters, filter));
    }
}
