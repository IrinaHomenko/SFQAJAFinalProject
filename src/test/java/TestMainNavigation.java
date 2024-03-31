import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMainNavigation {
    private WebDriver driver;
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
        vars = new HashMap<String, Object>();
    }

    @Test
    public void testGetAllCourses() {
        driver.get("https://skillfactory.ru/");
        driver.manage().window().setSize(new Dimension(1920, 1020));
        {
            WebElement element = driver.findElement(By.cssSelector(".t978__tm-link:nth-child(1)"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.cssSelector(".t978__tm-link_active")).click();
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector(".t978__menu-item:nth-child(1) .t978__typo_623893182 > .t978__link-inner")).click();
        vars.put("win2715", waitForWindow(2000));
        driver.switchTo().window(vars.get("win2715").toString());
        assertEquals("Онлайн-курсы: обучение IT-профессиям - Skillfactory", driver.getTitle());

    }

    @Test
    public void testGetAllFreeMaterials() {
        driver.get("https://skillfactory.ru/");
        driver.manage().window().setSize(new Dimension(1920, 1080));
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.linkText("БЕСПЛАТНО")).click();
        vars.put("win2715", waitForWindow(2000));
        driver.switchTo().window(vars.get("win2715").toString());
        assertEquals("Бесплатные курсы, онлайн обучение профессиям с получением сертификата, семинары и вебинары бесплатно от Skillfactory", driver.getTitle());

    }
    @Test
    public void testMoveToCareerCenter() {
        driver.get("https://skillfactory.ru/");
        driver.manage().window().setSize(new Dimension(1920, 1080));
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector("li:nth-child(3) > .main__nav-item")).click();
        vars.put("win2715", waitForWindow(2000));
        driver.switchTo().window(vars.get("win2715").toString());
        assertEquals("Центр карьеры Skillfactory", driver.getTitle());
    }
    @Test
    public void testMoveToContacts() {
        driver.get("https://skillfactory.ru/");
        driver.manage().window().setSize(new Dimension(1920, 1080));
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector("li:nth-child(4) > .main__nav-item")).click();
        vars.put("win2715", waitForWindow(2000));
        driver.switchTo().window(vars.get("win2715").toString());
        assertEquals("Контакты школы по работе с данными Skillfactory", driver.getTitle());
    }
    @Test
    public void testMoveToMedia() {
        driver.get("https://skillfactory.ru/");
        driver.manage().window().setSize(new Dimension(1920, 1080));
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector("li:nth-child(5) > .main__nav-item")).click();
        vars.put("win2715", waitForWindow(2000));
        driver.switchTo().window(vars.get("win2715").toString());
        assertEquals("Skillfactory media – Честные истории о карьере в IT из реальной среды", driver.getTitle());
    }
    @Test
    public void testGetAllCorporateCourses() {
        driver.get("https://skillfactory.ru/");
        driver.manage().window().setSize(new Dimension(1920, 1080));
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector("li:nth-child(6) > .main__nav-item")).click();
        vars.put("win2715", waitForWindow(2000));
        driver.switchTo().window(vars.get("win2715").toString());
        assertEquals("Корпоративное обучение от онлайн-школы SkillFactory", driver.getTitle());
    }


    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
