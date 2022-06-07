package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class RegisterBurgerPage {
    //локатор поля ввода имени
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input")
    private SelenideElement name;

    //локатор поля ввода email
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input")
    private SelenideElement email;

    //локатор поля ввода пароль
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/div/input")
    private SelenideElement password;

//    //Локатор кнопки "Зарегистрироваться"
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/main/div/form/button")
    private SelenideElement buttonRegister;


    //Локатор записи "Некорректный пароль"
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/p")
    private SelenideElement incorrectPassword;

    //Локатор кнопки "Войти"
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/main/div/div/p/a")
    private SelenideElement loginButton;

    //метод заполнения поля ввода "Имя"
    public void setUserName(String userName) {
        elementToBeClickable(name);
        name.click();
        name.setValue(userName);
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

    //метод клика по кнопке "Зарегистрироваться"
    public void clickButtonRegister() {
        buttonRegister.click();
    }

    //метод регистрации
    public LoginBurgerPage registrationUser(String userName, String userEmail, String userPassword) {
        setUserName(userName);
        setUserEmail(userEmail);
        setUserPassword(userPassword);
        clickButtonRegister();
        return page(LoginBurgerPage.class);
    }

    //метод возврата текста некорректного ввода пароля
    public SelenideElement getIncorrectPassword() {
        return incorrectPassword;
    }

    //метод клика на кнопку "Войти"
    public LoginBurgerPage clickLoginButton() {
        loginButton.click();
        return page(LoginBurgerPage.class);
    }

}
