import PageObject.LoginBurgerPage;
import PageObject.MainPageBurger;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class PersonalAreaInTest extends TestParent {
    @Test
    @DisplayName("переход по клику на «Личный кабинет»")
    @Description("переход по клику на «Личный кабинет»")
    public void personalAreaInTest() {
        //открывается страница и создается экземпляр класса страницы
        MainPageBurger mainPageBurger = open(urlMainPage, PageObject.MainPageBurger.class);

        //Кликнуть кнопку "Личный кабинет"
        LoginBurgerPage loginBurgerPage = mainPageBurger.clickButtonPersonalAreaLogPage();

        //проверка, что открыта нужная страница
        Assert.assertEquals(loginBurgerPage.getUrl(), urlLoginPage);
    }
}
