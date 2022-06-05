import PageObject.AccountProfilePage;
import PageObject.LoginBurgerPage;
import PageObject.MainPageBurger;
import client.StepsForDelete;
import client.StepsForPost;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import model.UserCreate;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class PersonalAreaTransitionTest extends TestParent {
    String email = Faker.instance().internet().emailAddress();
    String password = Faker.instance().internet().password();
    String name = Faker.instance().name().firstName();
    String accessToken;

    @After
    public void deleteData() {
        StepsForDelete.doDeleteRequestForDeleteUser(accessToken);
    }

    @Test
    @DisplayName("переход по клику на «Конструктор»")
    @Description("переход по клику на «Конструктор»")
    public void personalAreaTransitionConstructorTest() {
        //создание пользователя
        Response response = StepsForPost.doPostRequestForCreateUser(new UserCreate(email, password, name));

        //получение токена для удаления данных после теста
        accessToken = response.body().as(UserCreate.class).getAccessToken();

        //открывается страница и создается экземпляр класса страницы
        MainPageBurger mainPageBurger = open("https://stellarburgers.nomoreparties.site/", PageObject.MainPageBurger.class);

        //кликнуть по кнопке "Войти в аккаунт"
        mainPageBurger.clickButtonSignIn();

        //открывается страница авторизации и создается экземпляр класса страницы
        LoginBurgerPage loginBurgerPage = open("https://stellarburgers.nomoreparties.site/login", PageObject.LoginBurgerPage.class);

        //авторизация пользователя
        loginBurgerPage.loginUser(email, password);

        //Кликнуть кнопку "Личный кабинет"
        AccountProfilePage accountProfilePage = mainPageBurger.clickButtonPersonalAreaAccPage();

        //кликнуть по кнопке "Конструктор"
        accountProfilePage.clickButtonConstructor();

        //проверка, что открыта нужная страница
        Assert.assertEquals(mainPageBurger.getUrl(), "https://stellarburgers.nomoreparties.site/");
        WebDriverRunner.driver().close();
    }

    @Test
    @DisplayName("переход по клику на логотип Stellar Burgers")
    @Description("переход по клику на логотип Stellar Burgers")
    public void personalAreaTransitionLogoStellarTest() {
        //создание пользователя
        Response response = StepsForPost.doPostRequestForCreateUser(new UserCreate(email, password, name));

        //получение токена для удаления данных после теста
        accessToken = response.body().as(UserCreate.class).getAccessToken();

        //открывается страница и создается экземпляр класса страницы
        MainPageBurger mainPageBurger = open("https://stellarburgers.nomoreparties.site/", PageObject.MainPageBurger.class);

        //кликнуть по кнопке "Войти в аккаунт"
        LoginBurgerPage loginBurgerPage = mainPageBurger.clickButtonSignIn();

        //авторизация пользователя
        loginBurgerPage.loginUser(email, password);

        //Кликнуть кнопку "Личный кабинет"
        AccountProfilePage accountProfilePage = mainPageBurger.clickButtonPersonalAreaAccPage();

        //Клик по логотипу
        accountProfilePage.clickLogoStellar();

        //проверка, что открыта нужная страница
        Assert.assertEquals(mainPageBurger.getUrl(), "https://stellarburgers.nomoreparties.site/");
        WebDriverRunner.driver().close();
    }
}
