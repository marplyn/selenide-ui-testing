package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HotelPage {
    private final By HOTEL_NAME = By.cssSelector("h2[class*=\"pp-header__title\"]");
    private final By HOTEL_STARS = By.cssSelector("[data-testid='rating-stars']");
    private final By HOTEL_RATING = By.cssSelector("[data-testid=review-score-right-component] .b5cd09854e.d10a6220b4");
    private final By HOTEL_REVIEWS = By.cssSelector("[data-testid=review-score-right-component] .c90c0a70d3.db63693c62");
    private final By HOTEL_PRICE = By.cssSelector("[class=\"prco-valign-middle-helper\"]");

    @Step("Проверить стоимость отеля на его странице")
    public HotelPage checkPrice(String mapValue) {
        $(HOTEL_PRICE).shouldHave(text(mapValue));
        return this;
    }

    @Step("Проверить количество отзывов отеля на его странице")
    public HotelPage checkReviews(String mapValue) {
        $(HOTEL_REVIEWS).shouldHave(text(mapValue));
        return this;
    }

    @Step("Проверить оценку отеля на его странице")
    public HotelPage checkRating(String mapValue) {
        $(HOTEL_RATING).shouldHave(text(mapValue));
        return this;
    }

    @Step("Проверить звезды отеля на его странице")
    public HotelPage checkStars(int mapValue) {
        $(HOTEL_STARS).should(exist);
        ElementsCollection allElements = $$(HOTEL_STARS);
        for (SelenideElement selenideElement : allElements) {
            ElementsCollection hotelStars = selenideElement.findAll(By.cssSelector("span"));
            hotelStars.shouldHave(CollectionCondition.size(mapValue));
        }
        return this;
    }

    @Step("Проверить название отеля на его странице")
    public HotelPage checkName(String mapValue) {
        $(HOTEL_NAME).should(exist);
        $(HOTEL_NAME).shouldHave(text(mapValue));
        return this;
    }
}
