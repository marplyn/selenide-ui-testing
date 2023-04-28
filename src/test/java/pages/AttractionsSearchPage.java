package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class AttractionsSearchPage {
    private final By ATTRACTION_NAME = By.cssSelector("h4[data-testid=\"card-title\"]");
    private final By ATTRACTION_DURATION = By.cssSelector("[class=\"db29ecfbe2 css-j786b1\"]");
    public String attractionSearchName;
    public String attractionSearchDuration;

    @Step("Сохранить название достопримечательности в поиске")
    private AttractionsSearchPage getAttractionName() {
        attractionSearchName = $(ATTRACTION_NAME).getText();
        return this;
    }

    @Step("Сохранить продолжительность посещения достопримечательности в поиске")
    private AttractionsSearchPage getAttractionDuration() {
        attractionSearchDuration = $(ATTRACTION_DURATION).getText();
        return this;
    }

    @Step("Посмотреть карточку первого варианта из достопримечательностей в поиске")
    public AttractionsSearchPage getSearchAttractionParams() {
        getAttractionName();
        getAttractionDuration();
        $(ATTRACTION_NAME).click();
        return this;
    }
}
