import PageObject.ForgotPasswordPage;
import PageObject.LoginBurgerPage;
import PageObject.MainPageBurger;
import PageObject.RegisterBurgerPage;
import client.StepsForDelete;
import client.StepsForPost;
import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import model.UserCreate;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends TestParent {

    String email = Faker.instance().internet().emailAddress();
    String password = Faker.instance().internet().password();
    String name = Faker.instance().name().firstName();
    String accessToken;

    @After
    public void deleteData() {
        StepsForDelete.doDeleteRequestForDeleteUser(accessToken);
    }

    @Test
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    @Description("вход по кнопке «Войти в аккаунт» на главной")
    public void loginSignInButtonCorrectTest() {

        //создание пользователя
        Response response = StepsForPost.doPostRequestForCreateUser(new UserCreate(email, password, name));

        //получение токена для удаления данных после теста
        accessToken = response.body().as(UserCreate.class).getAccessToken();

        //открывается страница и создается экземпляр класса страницы
        MainPageBurger mainPageBurger = open("https://stellarburgers.nomoreparties.site/", PageObject.MainPageBurger.class);

        //кликнуть по кнопке "Войти в аккаунт"
        LoginBurgerPage loginBurgerPage = mainPageBurger.clickButtonSignIn();

        //авторизация пользователя
        mainPageBurger = loginBurgerPage.loginUser(email, password);

        try{
            Thread.sleep(10000);
        }
        catch (Exception e){}

        //проверка, что открыта нужная страница
        Assert.assertEquals(mainPageBurger.getUrl(), "https://stellarburgers.nomoreparties.site/");
        WebDriverRunner.driver().close();
    }

    @Test
    @DisplayName("вход через кнопку «Личный кабинет»")
    @Description("вход через кнопку «Личный кабинет»")
    public void loginButtonPersonalAreaCorrectTest() {
        //создание пользователя
        Response response = StepsForPost.doPostRequestForCreateUser(new UserCreate(email, password, name));

        //получение токена для удаления данных после теста
        accessToken = response.body().as(UserCreate.class).getAccessToken();

        //открывается страница и создается экземпляр класса страницы
        MainPageBurger mainPageBurger = open("https://stellarburgers.nomoreparties.site/", PageObject.MainPageBurger.class);

        //Кликнуть кнопку "Личный кабинет"
        LoginBurgerPage loginBurgerPage = mainPageBurger.clickButtonPersonalAreaLogPage();

        //авторизация пользователя
        mainPageBurger = loginBurgerPage.loginUser(email, password);

        try{
            Thread.sleep(10000);
        }
        catch (Exception e){}

        //проверка, что открыта нужная страница
        Assert.assertEquals(mainPageBurger.getUrl(), "https://stellarburgers.nomoreparties.site/");
        WebDriverRunner.driver().close();
    }

    @Test
    @DisplayName("вход через кнопку в форме регистрации")
    @Description("вход через кнопку в форме регистрации")
    public void loginInRegisterPageTest() {
        //создание пользователя
        Response response = StepsForPost.doPostRequestForCreateUser(new UserCreate(email, password, name));

        //получение токена для удаления данных после теста
        accessToken = response.body().as(UserCreate.class).getAccessToken();

        //открывается страница и создается экземпляр класса страницы
        MainPageBurger mainPageBurger = open("https://stellarburgers.nomoreparties.site/", PageObject.MainPageBurger.class);

        //Кликнуть кнопку "Личный кабинет"
        LoginBurgerPage loginBurgerPage = mainPageBurger.clickButtonPersonalAreaLogPage();

        //кликнуть "Зарегистрироваться"
        RegisterBurgerPage registerBurgerPage = loginBurgerPage.clickButtonPersonalArea();

        //кликнуть по кнопке "Войти"
        loginBurgerPage = registerBurgerPage.clickLoginButton();

        //авторизация пользователя
        mainPageBurger = loginBurgerPage.loginUser(email, password);

        try{
            Thread.sleep(10000);
        }
        catch (Exception e){}

        //проверка, что открыта нужная страница
        Assert.assertEquals(mainPageBurger.getUrl(), "https://stellarburgers.nomoreparties.site/");
        WebDriverRunner.driver().close();
    }

    @Test
    @DisplayName("вход через кнопку в форме восстановления пароля")
    @Description("вход через кнопку в форме восстановления пароля")
    public void loginForgotPasswordTest() {
        //создание пользователя
        Response response = StepsForPost.doPostRequestForCreateUser(new UserCreate(email, password, name));

        //получение токена для удаления данных после теста
        accessToken = response.body().as(UserCreate.class).getAccessToken();

        //открывается страница и создается экземпляр класса страницы
        MainPageBurger mainPageBurger = open("https://stellarburgers.nomoreparties.site/", PageObject.MainPageBurger.class);

        //Кликнуть кнопку "Личный кабинет"
        LoginBurgerPage loginBurgerPage = mainPageBurger.clickButtonPersonalAreaLogPage();

        //кликнуть по кнопке "Восстановить пароль"
        ForgotPasswordPage forgotPasswordPage = loginBurgerPage.clickRestorePasswordButton();

        //кликнуть по кнопке "Войти" на странице восстановления пароля
        loginBurgerPage = forgotPasswordPage.clickButtonLogin();

        //авторизация пользователя
        mainPageBurger = loginBurgerPage.loginUser(email, password);

        try{
            Thread.sleep(10000);
        }
        catch (Exception e){}

        //проверка, что открыта нужная страница
        Assert.assertEquals(mainPageBurger.getUrl(), "https://stellarburgers.nomoreparties.site/");
        WebDriverRunner.driver().close();
    }
}
