package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import pages.HomePage;
import pages.AttractionsPage;
import pages.AttractionsSearchPage;
import pages.SingleAttractionPage;

import static com.codeborne.selenide.Selenide.switchTo;

@DisplayName("Проверка совпадения данных достопримечательности в поиске и на ее странице")
public class AttractionsParamsTest extends BaseTest {
    // 2.1 зайти на сайт https://www.booking.com/
    // 2.2 нажать на кнопку "Варианты досуга"
    // 2.3 выбрать вторую карточку в разделе "Популярные направления"
    // 2.4 сохранить название и продолжительность у первого предложения в списке
    // 2.5 нажать на первое предложение в списке
    // 2.6 проверить название и продолжительность на открывшейся вкладке
    @Test
    @Description("Проверка названия и продолжительности посещения достопримечательности")
    public void testAttractionParams() {
        HomePage homePage = new HomePage();
        AttractionsPage attractionsPage = new AttractionsPage();
        AttractionsSearchPage attractionsSearchPage = new AttractionsSearchPage();
        SingleAttractionPage singleAttractionPage = new SingleAttractionPage();

        homePage.openPage();
        homePage.acceptCookies();
        homePage.clickAttractionsBtn();

        attractionsPage.clickTopDestinationCard();
        attractionsSearchPage.getSearchAttractionParams();
        String attractionSearchName = attractionsSearchPage.attractionSearchName;
        String attractionSearchDuration = attractionsSearchPage.attractionSearchDuration;
        switchTo().window(1);
        singleAttractionPage.selectAttractionDate();
        singleAttractionPage.checkAttractionName(attractionSearchName);
        singleAttractionPage.checkAttractionDuration(attractionSearchDuration);
    }
}
