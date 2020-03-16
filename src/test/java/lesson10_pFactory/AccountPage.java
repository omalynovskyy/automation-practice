package lesson10_pFactory;

import lesson10_pFactory.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage {
    WebDriver driver;

    @FindBy (xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
    private WebElement signOutBtn;

    protected AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    LoginPage signOut(){
        (new WebDriverWait(driver,15)).until(ExpectedConditions.elementToBeClickable(signOutBtn)).click();
        return new LoginPage(driver);
    }
}
