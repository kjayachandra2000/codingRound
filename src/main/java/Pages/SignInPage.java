package Pages;

import hooks.BrowserManagement;
import org.openqa.selenium.By;

public class SignInPage extends BrowserManagement {

    private By signInBtn = By.id("signInButton");
    private By loginFrame = By.id("modal_window");
    private By errMsg = By.id("errors1");

    public void clickSignIn() {
        switchToLoginFrame();
        findElementWithTimeout(signInBtn).click();
    }

    private void switchToLoginFrame() {
        driver.switchTo().frame(findElementWithTimeout(loginFrame));
    }

    public String getErrorMsg() {
        return findElementWithTimeout(errMsg).getText();
    }
}
