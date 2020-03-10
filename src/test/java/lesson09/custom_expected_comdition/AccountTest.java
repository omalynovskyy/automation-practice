package lesson09.custom_expected_comdition;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AccountTest {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("oleksiy.malynovskyy@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("1-1Cfesd1");
        driver.findElement(By.id("SubmitLogin")).click();
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
        }
    @After
    public void backToMain(){
        driver.get("http://automationpractice.com/index.php?controller=my-account");
    }

     @Test
    public void orderHistory(){
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a")).click();
        String orderHistoryLoaded = (new WebDriverWait(driver,10))
                .until(CustomExpectecComdition.pageIsLoaded("history","history"));

    }

    @Test
    public void orderSlip(){
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[2]/a")).click();
        String orderHistoryLoaded = (new WebDriverWait(driver,10))
                .until(CustomExpectecComdition.pageIsLoaded("slip","slip"));

    }

    @Test
    public void myAdresses(){
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[3]/a")).click();
        String orderHistoryLoaded = (new WebDriverWait(driver,10))
                .until(CustomExpectecComdition.pageIsLoaded("address","Address"));

    }

    @Test
    public void myPersonalInfo(){
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a")).click();
        String orderHistoryLoaded = (new WebDriverWait(driver,10))
                .until(CustomExpectecComdition.pageIsLoaded("identity","Identity"));
    }

    @Test
    public void myWishList(){
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[2]/ul/li/a")).click();
        String orderHistoryLoaded = (new WebDriverWait(driver,10))
                .until(CustomExpectecComdition.pageIsLoaded("wishlist","Store"));
    }
}
