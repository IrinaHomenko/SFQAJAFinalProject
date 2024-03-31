import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class TestHelpGetHighEducation {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

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
    @Test
    public void testGetHighEducation() {
        driver.get("https://skillfactory.ru/");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        js.executeScript("window.scrollTo(0,1517)");
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.linkText("Выбрать программу")).click();
        vars.put("win5288", waitForWindow(2000));
        driver.switchTo().window(vars.get("win5288").toString());
        {
            WebElement element = driver.findElement(By.cssSelector(".tn-elem__7211345981689594433388 > .tn-atom"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.cssSelector(".tn-elem__7211345981689594433388 > .tn-atom")).click();
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        {
            List<WebElement> elements = driver.findElements(By.cssSelector(".t702__wrapper"));
            assert(elements.size() > 0);
        }
        {
            WebElement element = driver.findElement(By.id("input_1495810354468"));
            Boolean isEditable = element.isEnabled() && element.getAttribute("readonly") == null;
            assertTrue(isEditable);
        }
        {
            WebElement element = driver.findElement(By.id("input_1495810359387"));
            Boolean isEditable = element.isEnabled() && element.getAttribute("readonly") == null;
            assertTrue(isEditable);
        }
        {
            WebElement element = driver.findElement(By.id("input_1495810410810"));
            Boolean isEditable = element.isEnabled() && element.getAttribute("readonly") == null;
            assertTrue(isEditable);
        }
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
