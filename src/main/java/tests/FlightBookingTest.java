package tests;

import Pages.FlightSearchPage;
import Pages.HomePage;
import hooks.BrowserManagement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FlightBookingTest extends BrowserManagement {


    private HomePage homePage;
    private FlightSearchPage flightSearchPage;
    private String origin = "Bangalore";
    private String destination = "Delhi";

    @BeforeTest
    public void before() {
        homePage = new HomePage();
        flightSearchPage = new FlightSearchPage();
    }

    @Test(description = "User should be able to do a flight search")
    public void testThatResultsAppearForAOneWayJourney() {
        homePage.navigateToFlightSearch();

        flightSearchPage.searchOneWay(origin, destination);

        assertThat(flightSearchPage.isFlightSearchResultsDisplayed(), is(true));
    }
}
