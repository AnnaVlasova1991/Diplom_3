package PageObject;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class MainPageBurger {
    //Локатор кнопки "Личный кабинет"
    @FindBy(how = How.LINK_TEXT,using = "Личный Кабинет")
    private SelenideElement buttonPersonalArea;

    //Локатор кнопки "Войти в аккаунт"
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/main/section[2]/div/button")
    private SelenideElement buttonSignIn;

    //локатор кнопки "Соусы"
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/main/section[1]/div[1]/div[2]/span")
    private SelenideElement souse;

    //локатор кнопки "Булки"
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/main/section[1]/div[1]/div[1]/span")
    private SelenideElement buns;

    //локатор кнопки "Начинки"
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/main/section[1]/div[1]/div[3]/span")
    private SelenideElement ingredient;

    //локатор блока "Булки"
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/main/section[1]/div[2]/ul[1]")
    private SelenideElement blockBuns;

    //локатор блока "Соусы"
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/main/section[1]/div[2]/ul[2]")
    private SelenideElement blockSouse;

    //локатор блока "Начинки"
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/main/section[1]/div[2]/ul[3]")
    private SelenideElement blockIngredient;

    //Локатор кнопки "Оформить заказ"
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/main/section[2]/div/button")
    private SelenideElement doOrderButton;

    public SelenideElement getDoOrderButton() {
        return doOrderButton;
    }

    public AccountProfilePage clickButtonPersonalAreaAccPage() {
        buttonPersonalArea.click();
        return page(AccountProfilePage.class);
    }

    public LoginBurgerPage clickButtonPersonalAreaLogPage() {
        buttonPersonalArea.click();
        return page(LoginBurgerPage.class);
    }

    //получение урла страницы
    public String getUrl() {
        String urlPage = WebDriverRunner.url();
        return urlPage;
    }

    //метод клика по кнопке "Войти в аккаунт"
//    public void clickButtonSignIn() {
//        buttonSignIn.click();
//    }
    public LoginBurgerPage clickButtonSignIn() {
        buttonSignIn.click();
        return page(LoginBurgerPage.class);
    }

    //метод клика по кнопке "Булки"
    public void clickButtonBuns() {
        buns.click();
    }

    //метод клика по кнопке "Соусы"
    public void clickButtonSouse() {
        souse.click();
    }

    //метод клика по кнопке "Начинки"
    public void clickButtonIngredients() {
        ingredient.click();
    }

    //метод возврата булок
    public SelenideElement bunsReturn() {
        return buns;
    }

    //метод возврата соуса
    public SelenideElement souseReturn() {
        return souse;
    }

    //метод возврата начинок
    public SelenideElement ingredientReturn() {
        return ingredient;
    }

}
