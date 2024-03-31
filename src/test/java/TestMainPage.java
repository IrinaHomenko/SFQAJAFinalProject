import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;



import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMainPage {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testHomePageTitle() {
        driver.get("https://skillfactory.ru/");
        driver.manage().window().setSize(new Dimension(1920, 1080));
        assertEquals("Онлайн-школа Skillfactory — онлайн-обучение востребованным IT-профессиям", driver.getTitle());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
