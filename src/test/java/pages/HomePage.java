package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static tests.BaseTest.config;

public class HomePage {
    private final By DESTINATION = By.cssSelector("input[name=ss]");
    private final By ACCEPT_COOKIES_BUTTON = By.cssSelector("button[id=onetrust-accept-btn-handler]");
    // private final By CLOSE_MODAL_WIN = By.cssSelector("button[class*=\"ae1678b153\"]");
    private final By DROPDOWN_LIST_ITEMS = By.cssSelector("[class=a80e7dc237]");
    private final By SEARCH_BTN = By.cssSelector("button[type=submit]");
    private final By CHECK_IN_DATE = By.cssSelector("[data-date=\"2023-04-17\"]");
    private final By CHECK_OUT_DATE = By.cssSelector("[data-date=\"2023-04-23\"]");
    private final By ATTRACTIONS_BUTTON = By.id("attractions");

    public HomePage openPage() {
        open(config.baseUrl());
        return this;
    }

    public HomePage acceptCookies() {
        $(ACCEPT_COOKIES_BUTTON).shouldBe(visible, enabled);
        $(ACCEPT_COOKIES_BUTTON).click();
        return this;
    }

    public HomePage findByCity(String cityName) {
        $(DESTINATION).sendKeys(cityName);
        $$(DROPDOWN_LIST_ITEMS).get(0).shouldHave(Condition.text(cityName)).click();
        $(CHECK_IN_DATE).click();
        $(CHECK_OUT_DATE).click();
        $(SEARCH_BTN).click();
        return this;
    }

    public HomePage clickAttractionsBtn() {
        $(ATTRACTIONS_BUTTON).click();
        return this;
    }
}
