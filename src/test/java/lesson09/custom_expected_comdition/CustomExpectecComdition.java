package lesson09.custom_expected_comdition;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

public class CustomExpectecComdition {
    public static ExpectedCondition<WebElement> listNthElementHasTest(
            By locator, int no, String expTextPart) {
        return new ExpectedCondition<WebElement>() {
            private String nthElementText ="";
            int size = 0;
            @NullableDecl
            @Override
            public WebElement apply(@NullableDecl WebDriver driver) {
                try{
                    List<WebElement> elements = driver.findElements(locator);
                    size = elements.size();
                    WebElement element = elements.get(no);
                    nthElementText = element.getText();
                    return nthElementText.contains(expTextPart)? element: null;
                } catch (IndexOutOfBoundsException e){
                    return null;
                }

            }

            @Override
            public String toString() {
                return String.format("%dth element \nof list \nto have text: %s\nwhile actual text was: %s\n",
                        no, expTextPart, nthElementText);
            }
        };
    }
    public static ExpectedCondition<String> pageIsLoaded(String expUrl, String expTitle){
        return new ExpectedCondition<String>() {
           String loadedURL;
           String loadedTitle;
            @NullableDecl
            @Override
            public String apply(@NullableDecl WebDriver webDriver) {
                loadedURL = webDriver.getCurrentUrl();
                loadedTitle = webDriver.getTitle();
                return loadedURL.contains(expUrl)&loadedTitle.contains(expTitle)? loadedTitle + ": " + loadedURL: null;
            }

            @Override
            public String toString() {
                return "$classname{" +
                        "loadedURL='" + loadedURL + '\'' +
                        ", loadedTitle='" + loadedTitle + '\'' +
                        '}';
            }
        };
    }

    public static ExpectedCondition<String> stalenessOfElement(WebElement elToBeDisappeared){
        return new ExpectedCondition<String>() {
            String checkResult;

            @NullableDecl
            @Override

            public String apply(@NullableDecl WebDriver webDriver) {
                if (!elToBeDisappeared.isDisplayed()) {
                    return checkResult="Element is gone";
                } else {
                    checkResult="Element is still present";
                    return null;
                }
                }

            @Override
            public String toString() {
                return "$classname{" +
                        "checkResult='" + checkResult + '\'' +
                        '}';
            }
        };
    }

}
