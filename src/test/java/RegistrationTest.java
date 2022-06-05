import PageObject.LoginBurgerPage;
import PageObject.MainPageBurger;
import PageObject.RegisterBurgerPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;


public class RegistrationTest extends TestParent {
    String email = Faker.instance().internet().emailAddress();
    String password = Faker.instance().internet().password();
    String name = Faker.instance().name().firstName();

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Успешная регистрация")
    public void successRegistrationTest() {
        //открывается страница и создается экземпляр класса страницы
        MainPageBurger mainPageBurger = open("https://stellarburgers.nomoreparties.site/", PageObject.MainPageBurger.class);

        //Кликнуть кнопку "Личный кабинет"
        LoginBurgerPage loginBurgerPage = mainPageBurger.clickButtonPersonalAreaLogPage();

        //кликнуть "Зарегистрироваться"
        RegisterBurgerPage registerBurgerPage = loginBurgerPage.clickButtonPersonalArea();

        //регистрация пользователя
        loginBurgerPage = registerBurgerPage.registrationUser(name, email, password);

        //Нажимаем на кнопку "Войти"
        loginBurgerPage.getButtonIn().shouldBe(Condition.visible);
        try{
            Thread.sleep(10000);
        }
        catch (Exception e){}

        //проверка, что открыта нужная страница
        Assert.assertEquals(loginBurgerPage.getUrl(), "https://stellarburgers.nomoreparties.site/login");
        WebDriverRunner.driver().close();
    }

    @Test
    @DisplayName("Ошибка для некорректного пароля")
    @Description("Ошибка для некорректного пароля")
    public void uncorrectPasswordRegistrationTest() {
        //открывается страница и создается экземпляр класса страницы
        MainPageBurger mainPageBurger = open("https://stellarburgers.nomoreparties.site/", PageObject.MainPageBurger.class);

        //Кликнуть кнопку "Личный кабинет"
        LoginBurgerPage loginBurgerPage = mainPageBurger.clickButtonPersonalAreaLogPage();

        //кликнуть "Зарегистрироваться"
        RegisterBurgerPage registerBurgerPage = loginBurgerPage.clickButtonPersonalArea();

        //заполнение поля пароль некорректным значением
        registerBurgerPage.registrationUser(name, email, "pas");

        //Появление текста о некорректном вводе пароля
        registerBurgerPage.getIncorrectPassword().shouldHave(Condition.exactText("Некорректный пароль"));
        WebDriverRunner.driver().close();
    }
}
