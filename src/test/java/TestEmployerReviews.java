import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestEmployerReviews {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void testSwipeEmployerReviews() {
        driver.get("https://skillfactory.ru/");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        js.executeScript("window.scrollTo(0,800)");
        driver.findElement(By.id("employer-reviews-next-btn")).click();
        {
            List<WebElement> elements = driver.findElements(By.cssSelector(".swiper-slide-active .employer-reviews__text:nth-child(3)"));
            assert (elements.size() > 0);
        }
    }
}
