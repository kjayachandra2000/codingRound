package Pages;

import hooks.BrowserManagement;
import org.openqa.selenium.By;

public class HomePage extends BrowserManagement {

    private By yourTrip = By.linkText("Your trips");
    private By signInLnk = By.id("SignIn");
    private By hotelLink = By.linkText("Hotels");
    private By FlightLink = By.linkText("Flights");

    public void clickYourTrips() {
        findElementWithTimeout(yourTrip).click();
    }

    public void navigateToSignInPage() {
        findElementWithTimeout(signInLnk).click();
    }

    public void navigateToHotelPage() {
        findElementWithTimeout(hotelLink).click();
    }

    public void navigateToFlightSearch() {
        findElementWithTimeout(FlightLink).click();
    }
}
