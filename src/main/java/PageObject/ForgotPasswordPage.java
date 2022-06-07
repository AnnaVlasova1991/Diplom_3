package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class ForgotPasswordPage {
    //Локатор кнопки "Войти"
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/main/div/div/p/a")
    private SelenideElement buttonLogin;

    //Метод клика по кнопке "Войти"
    public LoginBurgerPage clickButtonLogin() {
        buttonLogin.click();
        return page(LoginBurgerPage.class);
    }
}
