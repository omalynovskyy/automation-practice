package lesson09.custom_expected_comdition;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchTest {
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public void checkSearch(){
        driver.findElement(By.id("search_query_top")).clear();
        driver.findElement(By.id("search_query_top")).sendKeys("Printed Printed Dress");
        driver.findElement(By.name("submit_search")).click();

        boolean serchCountAnd1stMatch = (new WebDriverWait(driver,10))
                .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"center_column\"]/div[1]/div[2]/div[2]"),"of 3 items"))&&
                (new WebDriverWait(driver,10)).until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a"),"Printed Summer Dress"));

    }


}
