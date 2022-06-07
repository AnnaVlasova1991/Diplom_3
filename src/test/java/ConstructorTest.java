import PageObject.MainPageBurger;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class ConstructorTest extends TestParent {

    @Test
    @DisplayName("Переход к разделу Булки")
    @Description("Переход к разделу Булки")
    public void bunConstructorTest() {
        //открывается страница и создается экземпляр класса страницы
        MainPageBurger mainPageBurger = open("https://stellarburgers.nomoreparties.site/", PageObject.MainPageBurger.class);

        //кликнуть по кнопке соусы
        mainPageBurger.clickButtonSouse();

        //кликнуть по кнопке булки
        mainPageBurger.clickButtonBuns();

        //Проверка видимости блока булки
        mainPageBurger.bunsReturn().shouldBe(visible);
    }

    @Test
    @DisplayName("Переход к разделу Соусы")
    @Description("Переход к разделу Соусы")
    public void souseConstructorTest() {
        //открывается страница и создается экземпляр класса страницы
        MainPageBurger mainPageBurger = open(urlMainPage, PageObject.MainPageBurger.class);

        //кликнуть по кнопке соусы
        mainPageBurger.clickButtonSouse();

        //Проверка видимости блока булки
        mainPageBurger.souseReturn().shouldBe(visible);
    }

    @Test
    @DisplayName("Переход к разделу Ингридиенты")
    @Description("Переход к разделу Ингридиенты")
    public void ingredientsConstructorTest() {
        //открывается страница и создается экземпляр класса страницы
        MainPageBurger mainPageBurger = open(urlMainPage, PageObject.MainPageBurger.class);

        //кликнуть по кнопке соусы
        mainPageBurger.clickButtonIngredients();

        //Проверка видимости блока булки
        mainPageBurger.ingredientReturn().shouldBe(visible);
    }
}
