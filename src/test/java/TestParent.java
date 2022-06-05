import org.junit.Before;

public class TestParent {

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\asvlasova\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\driver\\yandexdriver.exe");
        System.setProperty("selenide.browser", "Chrome");
    }
}
