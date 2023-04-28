package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AttractionsPage {
    private final By TOP_DESTINATIONS_SECOND_CARD = By.xpath("(//a[@class='css-c3fma7'])[2]");

    @Step("Выбрать вторую карточку из популярных направлений")
    public AttractionsPage clickTopDestinationCard() {
        $(TOP_DESTINATIONS_SECOND_CARD).scrollIntoView(true).click();
        return this;
    }
}
