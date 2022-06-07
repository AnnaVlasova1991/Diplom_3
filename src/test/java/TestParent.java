import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;

public class TestParent {

    protected String urlMainPage = "https://stellarburgers.nomoreparties.site/";
    protected String urlLoginPage = "https://stellarburgers.nomoreparties.site/login";

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\asvlasova\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\driver\\yandexdriver.exe");
        System.setProperty("selenide.browser", "Chrome");
    }

    @After
    public void closeBrowser() {
        WebDriverRunner.driver().close();
    }
}
