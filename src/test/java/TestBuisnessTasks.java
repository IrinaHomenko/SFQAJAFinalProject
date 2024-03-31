import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestBuisnessTasks {
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
    public void testWhiteHackerCourse() {
        driver.get("https://skillfactory.ru/");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        js.executeScript("window.scrollTo(0,2500)");
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.linkText("на курсе «Тестировщик-автоматизатор»")).click();
        vars.put("win132", waitForWindow(2000));
        vars.put("root", driver.getWindowHandle());
        driver.switchTo().window(vars.get("win132").toString());
        driver.switchTo().window(vars.get("root").toString());
        driver.switchTo().window(vars.get("win132").toString());
        driver.findElement(By.linkText("Записаться на курс")).click();
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.linkText("Положением о персональных данных")).click();
        vars.put("win4315", waitForWindow(2000));
        driver.switchTo().window(vars.get("win4315").toString());
        driver.switchTo().window(vars.get("win132").toString());
        driver.switchTo().window(vars.get("win4315").toString());
        driver.close();
        driver.switchTo().window(vars.get("win132").toString());
        driver.findElement(By.id("input_1495810359387")).click();
        driver.findElement(By.id("input_1495810359387")).sendKeys("fd");
        driver.findElement(By.id("input_1495810354468")).click();
        driver.findElement(By.id("input_1495810354468")).sendKeys("dsads");
        driver.findElement(By.id("input_1495810410810")).click();
        driver.findElement(By.id("input_1495810410810")).sendKeys("(312) 3");
        driver.findElement(By.linkText("У меня есть промокод")).click();
        driver.findElement(By.id("input_1650379112455")).click();
        driver.findElement(By.id("input_1650379112455")).sendKeys("3213");
    }
}
