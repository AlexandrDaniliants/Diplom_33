package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import praktikum.pageObject.LoginPage;
import praktikum.pageObject.MainPage;
import praktikum.pageObject.RegisterPage;
import praktikum.user.User;
import praktikum.user.UserRandomData;
import praktikum.webDriverInit.WebDriverInitiator;

import static org.junit.Assert.assertTrue;
import static praktikum.constants.MessageConstants.*;

public class TestRegister extends WebDriverInitiator {

    private MainPage mainPage;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private User user;

    @Before
    public void setUp() {

        initWebDriver();

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);

        // Клик по кнопке "Войти в аккаунт"
        mainPage.clickLoginAccountButton();
        // Ждем загрузки страницы Вход
        loginPage.waitForLoadAuthorizationPage();
        // Проверяем, что на странице Вход виден заголовок Вход
        assertTrue(AUTHORIZATION_PAGE_NOT_LOAD,
                loginPage.checkVisibilityHeadlineLogin());
        // Клик по ссылке Зарегистроваться
        loginPage.clickRegisterLink();
        //ждем загрузки страницы Регистрация
        registerPage.waitForLoadRegistrationPage();
        // Проверяем, что на странице Регистрация виден заголовок Регистрация
        assertTrue(AUTHORIZATION_PAGE_NOT_LOAD,
                registerPage.checkVisibilityHeadlineRegistration());
    }

    @Test
    @DisplayName("Проверка успешной регистрации")
    @Description("Проверка регистрации пользователя с полными и корректными " +
            "данными пользователя")
    public void checkRegisterNewUser() {

        user = UserRandomData.generateRandomUser();
        // Заполняем форму регистрации
        registerPage.completingRegistrationForm(user);
        // Клик по кнопке Зарегистрироваться
        registerPage.clickRegisterButton();
        // Ждем загрузки страницы Вход
        loginPage.waitForLoadAuthorizationPage();
        // Проверяем, что на странице Вход виден заголовок Вход
        assertTrue(AUTHORIZATION_PAGE_NOT_LOAD,
                loginPage.checkVisibilityHeadlineLogin());
        // Заполняем форму авторизации
        loginPage.completingAuthorizationForm(user.getEmail(), user.getPassword());
        // Клик по кнопке Войти
        loginPage.clickLoginButton();
        //ждем загрузки главной страницы
        mainPage.waitForLoadMainPage();
        //проверяем что появилась кнопка заказа
        assertTrue(SET_ORDER_BUTTON_NOT_APPEAR,
                mainPage.checkVisibilitySetOrderButton());
    }

    @Test
    @DisplayName("Проверка ошибки для некорректного пароля. Минимальный пароль - шесть символов")
    @Description("Проверка появления сообщения об ошибке 'Некорректный пароль' " +
            "при попытке ввода пароля пользователя длинной менее шести символов")
    public void checkWarningIncorrectPassword() {
        // Создаем пользователя с некорректным паролем
        user = UserRandomData.generateRandomUserWithIncorrectPassword();
        // Заполняем форму регистрации
        registerPage.completingRegistrationForm(user);
        // Клик по кнопке Зарегистрироваться
        registerPage.clickRegisterButton();
        // Проверяем что появилось сообщение об ошибке Некорректный пароль
        assertTrue(WARNING_INCORRECT_PASSWORD_NOT_APPEAR,
                registerPage.checkVisibilityWarningIncorrectPassword());
    }
}
