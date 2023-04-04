package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage {
    private final By SHOW_ON_MAP_BTN = By.cssSelector("[data-testid=map-trigger]");
    private final By MAP_LOADING_BANNER = By.cssSelector("[class=map_left_cards__list--loading]");
    private final By MAP_LEFT_HOTEL_CARD = By.cssSelector("a.map-card__container:nth-child(1)[class=map-card__container]");

    private String hotelId;
    public String mapHotelName;
    public ElementsCollection mapHotelStars;
    public String mapHotelRating;
    public String mapHotelReviews;
    public String mapHotelPrice;

    public SearchResultsPage getHotelPrice() {
        mapHotelPrice = $(By.cssSelector("[data-marker-id=\"" + hotelId + "\"" + "] [class=\"prco-valign-middle-helper\"]"))
                .getText();
        return this;
    }

    public SearchResultsPage getHotelReviews() {
        mapHotelReviews = $(By.cssSelector("[data-marker-id=\"" + hotelId + "\"" + "] [class=\"bui-review-score__text\"]"))
                .getText();
        return this;
    }

    public SearchResultsPage getHotelRating() {
        mapHotelRating = $(By.cssSelector("[data-marker-id=\"" + hotelId + "\"" + "] [class=bui-review-score__badge]"))
                .getText();
        return this;
    }

    public SearchResultsPage getHotelStars() {
        ElementsCollection allElements = $$(By.cssSelector("[data-marker-id=\"" + hotelId + "\"" + "] [class*=bui-rating--smaller]"));
        for (SelenideElement selenideElement : allElements) {
            mapHotelStars = selenideElement.findAll(By.cssSelector("span"));
        }
        return this;
    }

    public SearchResultsPage getHotelName() {
        mapHotelName = $(By.cssSelector("[data-marker-id=\"" + hotelId + "\"" + "] [class=map-card__title-link]"))
                .getText();
        return this;
    }

    public SearchResultsPage viewOnMap() {
        $(SHOW_ON_MAP_BTN).click();
        $(MAP_LOADING_BANNER).shouldBe(not(visible));
        $(MAP_LEFT_HOTEL_CARD).shouldBe(interactable);
        hotelId = $(MAP_LEFT_HOTEL_CARD).getAttribute("data-marker-id");
        getHotelName();
        getHotelStars();
        getHotelRating();
        getHotelReviews();
        getHotelPrice();
        $(MAP_LEFT_HOTEL_CARD).hover();
        $(By.cssSelector(".atlas-marker[data-atlas-id=\"hotel_" + hotelId + "\"]")).click();
        return this;
    }

}
