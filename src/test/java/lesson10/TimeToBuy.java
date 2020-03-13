package lesson10;

import lesson09.custom_expected_comdition.CustomExpectecComdition;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class TimeToBuy {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("email4test@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("passwd4test");
        driver.findElement(By.id("SubmitLogin")).click();
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
        }
//    @After
//    public void backToMain(){
//        driver.get("http://automationpractice.com/index.php?controller=my-account");
//    }

    @Test
    public void checkSearch() {
        driver.findElement(By.id("search_query_top")).clear();
        driver.findElement(By.id("search_query_top")).sendKeys("Printed Chiffon Dress");
        driver.findElement(By.name("submit_search")).click();
        boolean wait = (new WebDriverWait(driver, 15))
                .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"center_column\"]/h1/span[1]"),"PRINTED CHIFFON DRESS"));
//        List<WebElement> list = (List<WebElement>) driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li[1]"));
//        WebElement searchItem = list.stream()
//                .filter(element -> element.getAttribute("title").matches("Printed Chiffon Dress")).findFirst().orElse(null);
//        searchItem.click();
        driver.findElement(By.id("list")).click();
//        WebElement addToChart = (new WebDriverWait(driver, 15))
//                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"center_column\"]/div/div/div[3]/h1")));
        WebElement addToChart = (new WebDriverWait(driver, 15))
                  .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div/div[3]/div/div[2]/a[1]")));
        addToChart.click();
        WebElement proceed = (new WebDriverWait(driver, 15))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")));
        proceed.click();
        WebElement proceed01 = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]")));
        proceed01.click();
        WebElement proceed03 = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"center_column\"]/form/p/button")));
        proceed03.click();
        WebElement confirm = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"uniform-cgv\"]")));
        confirm.click();
        WebElement proceed04 = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"form\"]/p/button")));
        proceed04.click();
        WebElement payByCheck = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a")));
        payByCheck.click();
        WebElement confirmOrder = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cart_navigation\"]/button")));
        confirmOrder.click();
        WebElement myOrders = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"footer\"]/div/section[5]/div/ul/li[1]/a")));
        myOrders.click();
        WebElement firstOrder = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"order-list\"]/tbody/tr[1]/td[1]/a")));
        firstOrder.click();
        boolean verifyOrder = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.textToBePresentInElement(By.xpath("//*[@id=\"order-detail-content\"]/table/tbody/tr/td[2]/label"),"Printed Chiffon Dress"));

    }


}
