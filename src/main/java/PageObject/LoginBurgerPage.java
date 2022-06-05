package PageObject;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class LoginBurgerPage {


    //Локатор кнопки "Зарегистрироваться"
    @FindBy(how = How.LINK_TEXT,using = "Зарегистрироваться")
    private SelenideElement buttonLogin;

    //Локатор кнопки "Войти"
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/main/div/form/button")
    private SelenideElement buttonIn;

    //Локатор поля email
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input")
    private SelenideElement email;

    //локатор поля password
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input")
    private SelenideElement password;

    //Локатор кнопки "Восстановить пароль"
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/main/div/div/p[2]/a")
    private SelenideElement restorePasswordButton;

    //метод клика по кнопке "Зарегистрироваться"
    public RegisterBurgerPage clickButtonPersonalArea() {
        buttonLogin.click();
        return page(RegisterBurgerPage.class);
    }

    //метод клика по кнопке "Войти"
    public MainPageBurger clickButtonIn() {
        buttonIn.click();
        return page(MainPageBurger.class);
    }

    //метод заполнения поля ввода email
    public void setUserEmail(String userEmail) {
        elementToBeClickable(email);
        email.click();
        email.setValue(userEmail);
    }

    //метод заполнения поля ввода password
    public void setUserPassword(String userPassword) {
        elementToBeClickable(password);
        password.click();
        password.setValue(userPassword);
    }

    //метод для авторизации
    public MainPageBurger loginUser(String userEmail, String userPassword) {
        setUserEmail(userEmail);
        setUserPassword(userPassword);
        return clickButtonIn();
    }


    //метод клика по кнопке "Восстановить пароль"
    public ForgotPasswordPage clickRestorePasswordButton() {
        restorePasswordButton.click();
        return page(ForgotPasswordPage.class);
    }

    //получение урла страницы
    public String getUrl() {
        String urlPage = WebDriverRunner.url();
        return urlPage;
    }

    //геттер для кнопки "Войти"
    public SelenideElement getButtonIn(){
        return buttonIn;
    }
}
