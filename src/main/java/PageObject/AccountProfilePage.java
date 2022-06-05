package PageObject;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class AccountProfilePage {
    //Локатор кнопки "Конструктор"
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/header/nav/ul/li[1]/a/p")
    private SelenideElement buttonConstructor;

    //Локатор логотипа
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/header/nav/div")
    private SelenideElement logoStellar;

    //Локатор кнопки "Выход"
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/main/div/nav/ul/li[3]/button")
    private SelenideElement logoutButton;

    //метод клика на кнопку "Конструктор"
    public void clickButtonConstructor() {
        buttonConstructor.shouldBe(visible).click();
    }

    //метод клика на логотип
    public void clickLogoStellar() {
        logoStellar.click();
    }

    //получение урла страницы
    public String getUrl() {
        String urlPage = WebDriverRunner.url();
        return urlPage;
    }

    //метод клика на кнопку "Выход"
    public LoginBurgerPage clickButtonlogout() {
        //logoutButton.shouldBe(visible).click();
        logoutButton.click();
        return page(LoginBurgerPage.class);

    }
}
