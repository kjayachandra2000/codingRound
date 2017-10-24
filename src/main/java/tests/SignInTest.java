package tests;

import Pages.HomePage;
import Pages.SignInPage;
import hooks.BrowserManagement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class SignInTest extends BrowserManagement {

    private HomePage homePage;
    private SignInPage signInPage;

    @BeforeTest
    public void before() {
        homePage = new HomePage();
        signInPage = new SignInPage();
    }

    @Test(description = "Negative Test with our Sign-in details")
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
        homePage.clickYourTrips();
        homePage.navigateToSignInPage();

        signInPage.clickSignIn();

        assertThat(signInPage.getErrorMsg(),
                containsString("There were errors in your submission"));
    }
}
