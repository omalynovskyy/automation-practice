package lesson10_pFactory;

import lesson10_pFactory.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
    WebDriver driver;

    @FindBy (xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
    private WebElement signOutBtn;

    public AccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    LoginPage signOut(){
        signOutBtn.click();
        return new LoginPage(driver);
    }
}
