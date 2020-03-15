package lesson10_pFactory;

import org.hamcrest.CoreMatchers;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class TestLoginAndAccount {
    static WebDriver driver;

    LoginPage chainedLoginPage;
    AccountPage chainedAccountPage;

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
    //@Ignore
    public void loginByOneMthd(){
        LoginPage loginPage = new LoginPage(driver);
        //loginPage.openLoginPage(); - почему с этим не работает, что не так?
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        Assert.assertThat(driver.getTitle(), CoreMatchers.containsString("Login"));
        chainedAccountPage = loginPage.login("email4test@gmail.com", "passwd4test");
        Assert.assertThat(driver.getTitle(), CoreMatchers.containsString("My account"));

    }

    @Test
    //@Ignore
    public void signOutTest(){
        Assert.assertThat(driver.getTitle(), CoreMatchers.containsString("My account"));
        chainedLoginPage = chainedAccountPage.signOut();
        Assert.assertThat(driver.getTitle(), CoreMatchers.containsString("Login"));

    }


    @Test
    //@Ignore
    public void loginByThreeMthd(){
        //LoginPage loginPage = new LoginPage(driver);
        //loginPage.openLoginPage(); - почему с этим не работает, что не так?
        //driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        Assert.assertThat(driver.getTitle(), CoreMatchers.containsString("Login"));
        chainedLoginPage.enterUserName("email4test@gmail.com");
        chainedLoginPage.enterPassword("passwd4test");
        chainedLoginPage.clickSignInBtn();
        Assert.assertThat(driver.getTitle(), CoreMatchers.containsString("My account"));

    }




}
