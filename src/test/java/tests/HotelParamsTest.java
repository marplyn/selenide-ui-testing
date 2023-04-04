package tests;

import org.junit.Test;
import pages.HomePage;
import pages.SearchResultsPage;
import pages.HotelPage;

import static com.codeborne.selenide.Selenide.switchTo;

public class HotelParamsTest extends BaseTest {
    // 1.1 зайти на сайт https://www.booking.com/
    // 1.2 ввести в поиске любой город (заграничный)
    // 1.3 выбрать случайные даты
    // 1.4 нажать на кнопку «Найти»
    // 1.5 нажать на кнопку «Показать на карте»
    // 1.6 навести курсор на первый отель (карточка слева)
    // 1.7 сохранить (в переменные) название отеля, количество звезд, среднюю оценку,
    // количество отзывов, стоимость
    // 1.8 нажать на прыгающий маркер на карте
    // 1.9 на открывшейся странице отеля проверить название отеля, количество звезд, среднюю оценку,
    // количество отзывов и стоимость
    @Test
    public void testScenario() {
        String cityName = "San Francisco";

        HomePage homePage = new HomePage();
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        HotelPage hotelPage = new HotelPage();

        homePage.openPage();
        homePage.acceptCookies();
        homePage.findByCity(cityName);
        searchResultsPage.viewOnMap();
        String mapHotelName = searchResultsPage.mapHotelName;
        int mapHotelStars = searchResultsPage.mapHotelStars.size();
        String mapHotelRating = searchResultsPage.mapHotelRating;
        String mapHotelReviews = searchResultsPage.mapHotelReviews;
        String mapHotelPrice = searchResultsPage.mapHotelPrice;
        switchTo().window(1);
        hotelPage.checkName(mapHotelName);
        hotelPage.checkStars(mapHotelStars);
        hotelPage.checkRating(mapHotelRating);
        hotelPage.checkReviews(mapHotelReviews);
        hotelPage.checkPrice(mapHotelPrice);
    }
}
