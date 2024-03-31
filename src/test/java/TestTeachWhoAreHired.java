
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.*;

public class TestTeachWhoAreHired {
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
    public void testGetPythonCourses() {
        driver.get("https://skillfactory.ru/");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector("li:nth-child(1) > .directions__list-link > span")).click();
        vars.put("win9528", waitForWindow(2000));
        driver.switchTo().window(vars.get("win9528").toString());
        driver.findElement(By.linkText("Python")).click();
    }
    @Test
    public void testGetDataScienceCourses() {
        driver.get("https://skillfactory.ru/");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector("li:nth-child(2) > .directions__list-link > span")).click();
        vars.put("win9528", waitForWindow(2000));
        driver.switchTo().window(vars.get("win9528").toString());
    }
    @Test
    public void testGetAnalystCourses() {
        driver.get("https://skillfactory.ru/");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector("li:nth-child(3) > .directions__list-link > span")).click();
        vars.put("win9528", waitForWindow(2000));
        driver.switchTo().window(vars.get("win9528").toString());
    }
    @Test
    public void testGetTestingCourses() {
        driver.get("https://skillfactory.ru/");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector("li:nth-child(4) > .directions__list-link > span")).click();
        vars.put("win9528", waitForWindow(2000));
        driver.switchTo().window(vars.get("win9528").toString());
    }
    @Test
    public void testGetHighEducation() {
        driver.get("https://skillfactory.ru/");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector("li:nth-child(5) > .directions__list-link > span")).click();
        vars.put("win9528", waitForWindow(2000));
        driver.switchTo().window(vars.get("win9528").toString());
        {
            WebElement element = driver.findElement(By.linkText("Выбрать программу"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.linkText("Выбрать программу")).click();
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
    }
    @Test
    public void testGetDesignCourses() {
        driver.get("https://skillfactory.ru/");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector("li:nth-child(6) > .directions__list-link > span")).click();
        vars.put("win9528", waitForWindow(2000));
        driver.switchTo().window(vars.get("win9528").toString());
    }
}