package praktikum.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static praktikum.constants.LocatorConstants.*;

public class ProfilePage extends VisibilityWaiter {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Step("Ожидание загрузки страницы Профиль")
    public void waitForLoadProfileButton() {
        waitForVisibility(PROFILE_BUTTON);
    }

    @Step("Проверка видимости кнопки 'Профиль'")
    public boolean checkVisibilityProfileButton() {
        return driver.findElement(PROFILE_BUTTON).isDisplayed();
    }

    @Step("Клик по кнопке Конструктор")
    public void clickConstructorButton() {
        driver.findElement(CONSTRUCTOR_BUTTON).click();
    }

    @Step("Клик по логотипу")
    public void clickLogo() {
        driver.findElement(LOGO).click();
    }

    @Step("Клик по кнопке Выйти")
    public void clickLogoutButton() {
        driver.findElement(LOGOUT_BUTTON).click();
    }
}
