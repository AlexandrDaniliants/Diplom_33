package praktikum.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static praktikum.constants.LocatorConstants.*;

public class MainPage extends VisibilityWaiter {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Клик по кнопке 'Войти в аккаунт' на главной странице")
    public void clickLoginAccountButton() {
        driver.findElement(LOG_IN_ACCOUNT_BUTTON).click();
    }

    @Step("Ожидание загрузки главной страницы")
    public void waitForLoadMainPage() {
        waitForVisibility(HEADLINE_MAKE_BURGER);
    }

    @Step("Проверка видимости кнопки 'Оформить заказ'")
    public boolean checkVisibilitySetOrderButton() {
        return driver.findElement(SET_ORDER_BUTTON).isDisplayed();
    }

    @Step("Клик по кнопке Личный кабинет")
    public void clickPersonalAccountButton() {
        driver.findElement(PERSONAL_ACCOUNT_BUTTON).click();
    }

    @Step("Клик по неактивной кнопке 'Соусы'")
    public void clickInactiveSauceButton() {
        driver.findElement(INACTIVE_SECTION_SAUCE).click();
    }

    @Step("Проверка активности секции 'Соусы'")
    public boolean checkActivitySaucesSection() {
        return driver.findElement(ACTIVE_SECTION_SAUCE).isDisplayed();}

    @Step("Клик по неактивной кнопке 'Начинки'")
    public void clickInactiveFillingButton() {
        driver.findElement(INACTIVE_SECTION_FILLING).click();
    }

    @Step("Проверка активности секции 'Начинки'")
    public boolean checkActivityFillingSection() {
        return driver.findElement(ACTIVE_SECTION_FILLING).isDisplayed();
    }

    @Step("Клик по неактивной кнопке 'Булки'")
    public void clickInactiveBunButton() {
        driver.findElement(INACTIVE_SECTION_BUN).click();
    }

    @Step("Проверка активности кнопки 'Булки'")
    public boolean checkActivityBunSection() {
        return driver.findElement(ACTIVE_SECTION_BUN).isDisplayed();
    }
}
