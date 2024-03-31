import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class TestChooseDirection {
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
    public void testITxray() {
        driver.get("https://skillfactory.ru/");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        js.executeScript("window.scrollTo(0,2423)");
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.linkText("Участвовать")).click();
        vars.put("win5153", waitForWindow(2000));
        driver.switchTo().window(vars.get("win5153").toString());
        {
            WebElement element = driver.findElement(By.name("email"));
            Boolean isEditable = element.isEnabled() && element.getAttribute("readonly") == null;
            assertTrue(isEditable);
        }
        {
            WebElement element = driver.findElement(By.id("input_1698157702529"));
            Boolean isEditable = element.isEnabled() && element.getAttribute("readonly") == null;
            assertTrue(isEditable);
        }
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
