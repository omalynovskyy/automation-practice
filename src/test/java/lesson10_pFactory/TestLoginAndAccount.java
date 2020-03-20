package lesson10_pFactory;

import org.hamcrest.CoreMatchers;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;

public class TestLoginAndAccount {
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public void loginByOneMthd(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        Assert.assertThat(driver.getTitle(), CoreMatchers.containsString("Login"));
        AccountPage accountPage = loginPage.login("email4test@gmail.com", "passwd4test");
        Assert.assertThat(driver.getTitle(), CoreMatchers.containsString("My account"));
        loginPage = accountPage.signOut();
    }

    @Test
    public void signOutTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        AccountPage accountPage = loginPage.login("email4test@gmail.com", "passwd4test");
        loginPage = accountPage.signOut();
        Assert.assertThat(driver.getTitle(), CoreMatchers.containsString("Login"));
    }

    @Test
    public void loginByThreeMthd(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.enterUserName("email4test@gmail.com");
        loginPage.enterPassword("passwd4test");
        loginPage.clickSignInBtn();
        Assert.assertThat(driver.getTitle(), CoreMatchers.containsString("My account"));
        AccountPage accountPage = new AccountPage(driver);
        loginPage = accountPage.signOut();
    }

}
