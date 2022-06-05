import PageObject.AccountProfilePage;
import PageObject.LoginBurgerPage;
import PageObject.MainPageBurger;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class LogoutTest extends TestParent {
    @Test
    @DisplayName("выход по кнопке «Выйти» в личном кабинете")
    @Description("выход по кнопке «Выйти» в личном кабинете")
    public void logoutTest() {
        //открывается страница и создается экземпляр класса страницы
        MainPageBurger mainPageBurger = open("https://stellarburgers.nomoreparties.site/", PageObject.MainPageBurger.class);

        //кликнуть по кнопке "Войти в аккаунт"
        LoginBurgerPage loginBurgerPage = mainPageBurger.clickButtonSignIn();

        //авторизация пользователя
        loginBurgerPage.loginUser("isebe@mail.ru", "dfeffe");

        //Кликнуть кнопку "Личный кабинет"
        AccountProfilePage accountProfilePage = mainPageBurger.clickButtonPersonalAreaAccPage();

        //клик по кнопке "Выход"
        loginBurgerPage = accountProfilePage.clickButtonlogout();
        loginBurgerPage.getButtonIn().shouldBe(Condition.visible);

        //проверка, что открыта нужная страница
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/login", loginBurgerPage.getUrl());

    }

}
