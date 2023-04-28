package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class SingleAttractionPage {
    private final By ATTRACTION_NAME = By.cssSelector("[class=\"e1f827110f css-1uk1gs8\"]");
    private final By ATTRACTION_DURATION = By.xpath("//div[contains(text(), 'Duration')] | //div[contains(text(), 'Продолжительность')]");

    private final By ATTRACTION_DATE = By.xpath("//button[@class=\"css-1pnyj7a\"]");

    @Step("Проверить название достопримечательности на ее странице")
    public SingleAttractionPage checkAttractionName(String searchPageValue) {
        $(ATTRACTION_NAME).shouldHave(text(searchPageValue));
        return this;
    }

    @Step("Проверить продолжительность посещения достопримечательности на ее странице")
    public SingleAttractionPage checkAttractionDuration(String searchPageValue) {
        $(ATTRACTION_DURATION).shouldBe(visible);
        $(ATTRACTION_DURATION).shouldHave(text(searchPageValue));
        return this;
    }

    @Step("Выставить дату посещения достопримечательности на ее странице")
    public SingleAttractionPage selectAttractionDate() {
        $(ATTRACTION_DATE).shouldBe(interactable);
        $(ATTRACTION_DATE).click();
        return this;
    }
}
