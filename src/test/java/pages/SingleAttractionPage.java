package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SingleAttractionPage {
    private final By ATTRACTION_NAME = By.cssSelector("[class=\"e1f827110f css-1uk1gs8\"]");
    private final By ATTRACTION_DURATION = By.cssSelector("[class=\"css-1qm1lh\"] > ul > :nth-child(2) [class=\"af628afe65\"]");

    public SingleAttractionPage checkAttractionName(String searchPageValue) {
        $(ATTRACTION_NAME).shouldHave(text(searchPageValue));
        return this;
    }

    public SingleAttractionPage checkAttractionDuration(String searchPageValue) {
        $(ATTRACTION_DURATION).shouldHave(text(searchPageValue));
        return this;
    }
}
