import PageObject.AccountProfilePage;
import PageObject.LoginBurgerPage;
import PageObject.MainPageBurger;
import client.StepsForDelete;
import client.StepsForPost;
import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import model.UserCreate;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class LogoutTest extends TestParent {
    String email = Faker.instance().internet().emailAddress();
    String password = Faker.instance().internet().password();
    String name = Faker.instance().name().firstName();
    String accessToken;

    @After
    public void deleteData() {
        StepsForDelete.doDeleteRequestForDeleteUser(accessToken);
    }

    @Test
    @DisplayName("выход по кнопке «Выйти» в личном кабинете")
    @Description("выход по кнопке «Выйти» в личном кабинете")
    public void logoutTest() {
        //создание пользователя
        Response response = StepsForPost.doPostRequestForCreateUser(new UserCreate(email, password, name));

        //получение токена для удаления данных после теста
        accessToken = response.body().as(UserCreate.class).getAccessToken();

        //открывается страница и создается экземпляр класса страницы
        MainPageBurger mainPageBurger = open(urlMainPage, PageObject.MainPageBurger.class);

        //кликнуть по кнопке "Войти в аккаунт"
        LoginBurgerPage loginBurgerPage = mainPageBurger.clickButtonSignIn();

        //авторизация пользователя
        loginBurgerPage.loginUser(email, password);

        //Кликнуть кнопку "Личный кабинет"
        AccountProfilePage accountProfilePage = mainPageBurger.clickButtonPersonalAreaAccPage();

        //клик по кнопке "Выход"
        loginBurgerPage = accountProfilePage.clickButtonlogout();
        loginBurgerPage.getButtonIn().shouldBe(Condition.visible);

        //проверка, что открыта нужная страница
        Assert.assertEquals(urlLoginPage, loginBurgerPage.getUrl());
    }

}
