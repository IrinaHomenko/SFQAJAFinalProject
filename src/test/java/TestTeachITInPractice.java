import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestTeachITInPractice {

    private WebDriver driver;
    JavascriptExecutor js;
    private Map<String, Object> vars;

    public String waitForWindow(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> whNow = driver.getWindowHandles();
        Set<String> whThen = (Set<String>) vars.get("window_handles");
        if (whNow.size() > whThen.size()) {
            whNow.removeAll(whThen);
        }
        return whNow.iterator().next();
    }
    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @Test
    public void testGetCourse() {
        driver.get("https://skillfactory.ru/");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        js.executeScript("window.scrollTo(0,800)");
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".card__link:nth-child(3)")));
        }
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector(".card__link:nth-child(3) > .card__top")).click();
        vars.put("win8823", waitForWindow(2000));
        driver.switchTo().window(vars.get("win8823").toString());
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector(".internal-link > u")).click();
        vars.put("win7996", waitForWindow(2000));
        driver.switchTo().window(vars.get("win7996").toString());
        driver.close();
        driver.switchTo().window(vars.get("win8823").toString());
        js.executeScript("window.scrollTo(0,3631)");
        driver.findElement(By.linkText("Записаться на курс")).click();
        {
            List<WebElement> elements = driver.findElements(By.cssSelector(".t-popup_show .t702__wrapper"));
            assert(elements.size() > 0);
        }
    }
    @Test
    public void testGetAICourses() {
        driver.get("https://skillfactory.ru/");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector(".all-link:nth-child(4) > span")).click();
        vars.put("win9785", waitForWindow(2000));
        driver.switchTo().window(vars.get("win9785").toString());
        driver.findElement(By.linkText("Data Science")).click();
        driver.findElement(By.linkText("Искусственный интеллект")).click();
        {
            List<WebElement> elements = driver.findElements(By.cssSelector(".tn-elem__5690895861678366726776 > .tn-atom"));
            assert(elements.size() > 0);
        }
    }


    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
