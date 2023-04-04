package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AttractionsPage {
    private final By TOP_DESTINATIONS_SECOND_CARD = By.cssSelector(".css-4vvnf9 .css-1t3v2n3:nth-child(2)");

    public AttractionsPage clickTopDestinationCard() {
        $(TOP_DESTINATIONS_SECOND_CARD).click();
        return this;
    }
}
