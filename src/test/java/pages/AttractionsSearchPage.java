package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class AttractionsSearchPage {
    private final By ATTRACTION_NAME = By.cssSelector("[data-testid=sr-list] .css-9o4v84:nth-child(1) .bdb988fcaf:nth-child(1) h4[data-testid=\"card-title\"]");
    private final By ATTRACTION_DURATION = By.cssSelector("[class=\"db29ecfbe2 css-j786b1\"]");
    private final By ATTRACTION_PRICE = By.cssSelector("[data-testid=sr-list] .css-9o4v84:nth-child(1) .bdb988fcaf:nth-child(1) .css-12m1zyc .ac78a73c96");
    private final By ATTRACTION_CARD = By.cssSelector("[data-testid=\"card\"]");
    public String attractionSearchName;
    public String attractionSearchDuration;
    public String attractionSearchPrice;

    private AttractionsSearchPage getAttractionPrice() {
        attractionSearchPrice = $(ATTRACTION_PRICE).getText();
        return this;
    }

    private AttractionsSearchPage getAttractionName() {
        attractionSearchName = $(ATTRACTION_NAME).getText();
        return this;
    }

    private AttractionsSearchPage getAttractionDuration() {
        attractionSearchDuration = $(ATTRACTION_DURATION).getText();
        return this;
    }

    public AttractionsSearchPage getSearchAttractionParams() {
        $(ATTRACTION_CARD).shouldBe(interactable);
        getAttractionName();
        getAttractionDuration();
        $(ATTRACTION_CARD).click();
        return this;
    }
}
