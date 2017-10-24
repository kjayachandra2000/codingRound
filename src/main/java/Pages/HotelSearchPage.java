package Pages;

import hooks.BrowserManagement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class HotelSearchPage extends BrowserManagement {
    private By localityTextBox = By.id("Tags");
    private By resultLst = By.cssSelector("ul[id='ui-id-1']>li[class='list']");
    private By searchButton = By.id("SearchHotelsButton");
    private By travellerSelection = By.id("travellersOnhome");
    private By default_startDate = By.cssSelector("td[data-handler='selectDay']");
    private By hotelsList = By.cssSelector("li[class*='listItem listUnit']");

    public void searchForHotel(String cityLocation, String travellers) {
        findElementWithTimeout(localityTextBox).sendKeys(cityLocation);
        findElementWithTimeout(resultLst).click();
        findElementWithTimeout(default_startDate).click();
        waitFor(1000);
        findElementWithTimeout(default_startDate).click();
        new Select(findElementWithTimeout(travellerSelection)).selectByVisibleText(travellers);
        findElementWithTimeout(searchButton).click();
    }

    public boolean isSearchResultsDisplayed() {
        return findElementWithTimeout(hotelsList).isDisplayed();
    }
}
