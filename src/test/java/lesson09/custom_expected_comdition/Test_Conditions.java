package lesson09.custom_expected_comdition;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test_Conditions {

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }


    @Test
    @Ignore
    public void verifyFirstTipIsCorrect_viaAssertTrue() {
        driver.findElement(By.id("search_query_top"))
                .clear();
        driver.findElement(By.id("search_query_top"))
                .sendKeys("Dress");

        WebElement fifthTip = (new WebDriverWait(driver, 10))
                .until(CustomExpectecComdition.listNthElementHasTest(By.xpath("//*[@id=\"index\"]/div[2]/ul/li"),
                        4,
                        "Dress"
                ));

    }

    @Test
    public void verifyPageLoad(){
        String pageLoad = (new WebDriverWait(driver, 10))
                .until(CustomExpectecComdition.pageIsLoaded("autom","Store"));
    }
    @Test
    public void checkElementIsNotPresent(){
        driver.findElement(By.id("search_query_top")).clear();
        driver.findElement(By.id("search_query_top")).sendKeys("Dress");
        WebElement firstRow = driver.findElement(By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]"));
        driver.findElement(By.id("search_query_top")).clear();

        String checkEl = (new WebDriverWait(driver, 10))
                .until(CustomExpectecComdition.stalenessOfElement(firstRow));
    }

    @Test
    public void checkAllRowsHaveText(){
        driver.findElement(By.id("search_query_top")).clear();
        driver.findElement(By.id("search_query_top")).sendKeys("Dress");
        WebElement searchBox = (new WebDriverWait(driver, 10))
                .until(CustomExpectecComdition.allRowsTextCheck(By.xpath("//*[@id=\"index\"]/div[2]/ul/li"),"Dres"));
    }

}
