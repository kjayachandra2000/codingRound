package Pages;

import hooks.BrowserManagement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FlightSearchPage extends BrowserManagement {
    private By fromCity = By.id("FromTag");
    private By toCity = By.id("ToTag");
    private By defaultDate = By.cssSelector("td[data-handler='selectDay']");
    private By searchButton = By.id("SearchBtn");
    private By searchResults = By.className("searchSummary");

    public void searchOneWay(String origin, String destination) {
        selectOriginDestination(findElementWithTimeout(fromCity), origin, 1);
        selectOriginDestination(findElementWithTimeout(toCity), destination, 2);

        findElementWithTimeout(defaultDate).click();
        findElementWithTimeout(searchButton).click();
    }

    public boolean isFlightSearchResultsDisplayed() {
        return findElementWithTimeout(searchResults).isDisplayed();
    }

    private void selectOriginDestination(WebElement elm, String cityName, Integer listType) {
        elm.click();
        elm.sendKeys(cityName);
        waitFor(1000);
        findElementWithTimeout(By.cssSelector("ul[id='ui-id-" + listType + "']>li[class='list']")).click();
        waitFor(500);
    }
}
