package lesson10_pFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class LoginPage {

    protected WebDriver driver;
    @FindBy (id = "email")
    private WebElement loginField;

    @FindBy (id = "passwd")
    private WebElement passwordField;

    @FindBy (id = "SubmitLogin")
    private WebElement submitLogin;

    private String loginPageUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    protected LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void openLoginPage() {
        driver.get(loginPageUrl);
    }

    AccountPage login (String userName, String password){
        enterUserName(userName);
        enterPassword(password);
        clickSignInBtn();
        return new AccountPage(driver);
    }

    void enterUserName(String userName){
        loginField.clear();
        loginField.sendKeys(userName);
    }

    void enterPassword (String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    void clickSignInBtn(){
        submitLogin.click();
    }



}
