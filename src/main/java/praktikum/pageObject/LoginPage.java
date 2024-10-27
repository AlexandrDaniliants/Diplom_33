package praktikum.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static praktikum.constants.LocatorConstants.*;

public class LoginPage extends VisibilityWaiter {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ожидание загрузки страницы авторизации")
    public void waitForLoadAuthorizationPage() {
        waitForVisibility(HEADLINE_LOGIN);
    }

    @Step("Клик по ссылке Зарегистрироваться")
    public void clickRegisterLink() {
        driver.findElement(REGISTER_LINK).click();
    }

    @Step("Заполнение формы авторизации")
    public void completingAuthorizationForm(String email, String password) {
        driver.findElement(EMAIL_LOGIN_FIELD).sendKeys(email);
        driver.findElement(PASSWORD_LOGIN_FIELD).sendKeys(password);
    }

    @Step("Клик по кнопке Войти")
    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Клик по ссылке Восстановить пароль")
    public void clickForgotPasswordLink() {
        driver.findElement(FORGOT_PASSWORD_LINK).click();
    }

    @Step("Проверка видимости заголовка Войти")
    public boolean checkVisibilityHeadlineLogin() {
        return driver.findElement(HEADLINE_LOGIN).isDisplayed();
    }
}
