package praktikum.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import praktikum.user.User;

import static praktikum.constants.LocatorConstants.*;

public class RegisterPage extends VisibilityWaiter {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ожидание загрузки страницы Регистрация")
    public void waitForLoadRegistrationPage() {
        waitForVisibility(NAME_REGISTRATION_FIELD);
    }

    @Step("Заполнение формы регистрации")
    public void completingRegistrationForm(User user) {
        // Заполнение поля Имя
        driver.findElement(NAME_REGISTRATION_FIELD).sendKeys(user.getName());
        // Заполнение поля Email
        driver.findElement(EMAIL_REGISTRATION_FIELD).sendKeys(user.getEmail());
        // Заполнение поля Пароль
        driver.findElement(PASSWORD_REGISTRATION_FIELD).sendKeys(user.getPassword());
    }

    @Step("Клик по кнопке Зарегистрироваться")
    public void clickRegisterButton() {
        driver.findElement(REGISTER_BUTTON).click();
    }

    @Step("Проверка видимости предупреждения Некорректный пароль")
    public boolean checkVisibilityWarningIncorrectPassword() {
        return driver.findElement(WARNING_INCORRECT_PASSWORD).isDisplayed();
    }

    @Step("Проверка видимости заголовка Регистрация")
    public boolean checkVisibilityHeadlineRegistration() {
        return driver.findElement(HEADLINE_REGISTRATION).isDisplayed();
    }

    @Step("Клик по кнопке Войти")
    public void clickLoginLink() {
        driver.findElement(LOGIN_LINK).click();
    }
}
