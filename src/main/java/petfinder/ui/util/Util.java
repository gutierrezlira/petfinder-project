package petfinder.ui.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Util {
    public static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return  new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions
                        .presenceOfElementLocated(by));
    }
}
