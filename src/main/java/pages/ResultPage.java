package pages;

import base.PredefinedActions;

public class ResultPage extends PredefinedActions {


    private String firstResultItemImage="//span[text()='Results']//ancestor::div[contains(@class,'result-item')]/following-sibling::div//img";

    private String firstItemTitle="(//span[text()='Results']//ancestor::div[contains(@class,'result-item')]/following-sibling::div//h2//span)[1]";

    private String firstItemPrice="(//span[text()='Results']//ancestor::div[contains(@class,'result-item')]/following-sibling::div//span[@class='a-price'])[1]";


}
