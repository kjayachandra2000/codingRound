package tests;

import Pages.HomePage;
import Pages.HotelSearchPage;
import Pages.SignInPage;
import hooks.BrowserManagement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HotelBookingTest extends BrowserManagement {

    private HomePage homePage;
    private HotelSearchPage hotelSearchPage;

    @BeforeTest
    public void before() {
        homePage = new HomePage();
        hotelSearchPage = new HotelSearchPage();
    }

    @Test(description = "User should be able to search for a Hotel")
    public void shouldBeAbleToSearchForHotels() {
        homePage.navigateToHotelPage();

        hotelSearchPage.searchForHotel("Indiranagar, Bangalore", "1 room, 2 adults");
        assertThat(hotelSearchPage.isSearchResultsDisplayed(), is(true));

    }
}
