package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import praktikum.pageObject.LoginPage;
import praktikum.pageObject.MainPage;
import praktikum.pageObject.RecoveryPasswordPage;
import praktikum.pageObject.RegisterPage;
import praktikum.user.User;
import praktikum.user.UserRandomData;
import praktikum.webDriverInit.WebDriverInitiator;

import static org.junit.Assert.assertTrue;
import static praktikum.constants.MessageConstants.AUTHORIZATION_PAGE_NOT_LOAD;
import static praktikum.constants.MessageConstants.SET_ORDER_BUTTON_NOT_APPEAR;

public class TestLogin extends WebDriverInitiator {

    private MainPage mainPage;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private RecoveryPasswordPage recoveryPasswordPage;
    private User user;

@Before
public void setUp() {

    initWebDriver();

    mainPage = new MainPage(driver);
    loginPage = new LoginPage(driver);
    registerPage = new RegisterPage(driver);
    recoveryPasswordPage = new RecoveryPasswordPage(driver);

    user = UserRandomData.generateRandomUser();
    userRequest.createUser(user);
}

    @Test
    @DisplayName("Проверка входа по кнопке «Войти в аккаунт» на главной странице")
    @Description("Проверка возможности входа в аккаунт зарегистрированного пользователя " +
            "кликом по кнопке «Войти в аккаунт» на главной странице с последующей " +
            "авторизацией на появившейся странице авторизации")
    public void checkLoginOnMainPage() {
        // Клик по кнопке Войти в аккаунт
        mainPage.clickLoginAccountButton();
        // Ждем загрузки страницы Вход
        loginPage.waitForLoadAuthorizationPage();
        // Проверяем, что на странице Вход виден заголовок Вход
        assertTrue(AUTHORIZATION_PAGE_NOT_LOAD,
                loginPage.checkVisibilityHeadlineLogin());
        // Заполняем форму авторизации
        loginPage.completingAuthorizationForm(user.getEmail(), user.getPassword());
        // Клик по кнопке Войти
        loginPage.clickLoginButton();
        // Ждем загрузки главной страницы
        mainPage.waitForLoadMainPage();
        //Проверяем что на главной странице появилась кнопка оформить заказ
        assertTrue(SET_ORDER_BUTTON_NOT_APPEAR,
                mainPage.checkVisibilitySetOrderButton());
    }

    @Test
    @DisplayName("Проверка входа через кнопку «Личный кабинет»")
    @Description("Проверка возможности входа в аккаунт зарегистрированного пользователя " +
            "кликом по кнопке «Личный кабинет» на главной странице с последующей " +
            "авторизацией на появившейся странице авторизации")
    public void checkLoginByPersonalButton() {
        // Клик по кнопке Личный кабинет
        mainPage.clickPersonalAccountButton();
        // Ждем загрузки страницы Вход
        loginPage.waitForLoadAuthorizationPage();
        // Проверяем, что на странице Вход виден заголовок Вход
        assertTrue(AUTHORIZATION_PAGE_NOT_LOAD,
                loginPage.checkVisibilityHeadlineLogin());
        // Заполняем форму авторизации
        loginPage.completingAuthorizationForm(user.getEmail(), user.getPassword());
        // Клик по кнопке Войти
        loginPage.clickLoginButton();
        // Ждем загрузки главной страницы
        mainPage.waitForLoadMainPage();
        //Проверяем что на главной странице появилась кнопка оформить заказ
        assertTrue(SET_ORDER_BUTTON_NOT_APPEAR,
                mainPage.checkVisibilitySetOrderButton());
    }

    @Test
    @DisplayName("Проверка входа через кнопку в форме регистрации")
    @Description("Проверка возможности входа в аккаунт зарегистрированного пользователя " +
            "кликом по ссылке Войти на странице Регистрация с последующей авторизацией " +
            "на появившейся странице авторизации")
    public void checkLoginOnRegistrationPage() {
        // Клик по кнопке Войти в аккаунт
        mainPage.clickLoginAccountButton();
        // Ждем загрузки страницы Вход
        loginPage.waitForLoadAuthorizationPage();
        // Проверяем, что на странице Вход виден заголовок Вход
        assertTrue(AUTHORIZATION_PAGE_NOT_LOAD,
                loginPage.checkVisibilityHeadlineLogin());
        //Клик по ссылке Зарегистроваться
        loginPage.clickRegisterLink();
        // Ждем загрузки страницы регистрация
        registerPage.waitForLoadRegistrationPage();
        // Клик по ссылке Войти
        registerPage.clickLoginLink();
        // Ждем загрузки страницы Вход
        loginPage.waitForLoadAuthorizationPage();
        // Проверяем, что на странице Вход виден заголовок Вход
        assertTrue(AUTHORIZATION_PAGE_NOT_LOAD,
                loginPage.checkVisibilityHeadlineLogin());
        // Заполняем форму авторизации
        loginPage.completingAuthorizationForm(user.getEmail(), user.getPassword());
        // Клик по кнопке Войти
        loginPage.clickLoginButton();
        // Ждем загрузки главной страницы
        mainPage.waitForLoadMainPage();
        //Проверяем что на главной странице появилась кнопка оформить заказ
        assertTrue(SET_ORDER_BUTTON_NOT_APPEAR,
                mainPage.checkVisibilitySetOrderButton());
    }

    @Test
    @DisplayName("Проверка входа через кнопку в форме восстановления пароля")
    @Description("Проверка возможности входа в аккаунт зарегистрированного пользователя " +
            "кликом по ссылке Войти на странице Восстановление пароля с последующей " +
            "авторизацией на появившейся странице авторизации")
    public void checkLoginOnResetPasswordPage() {
        // Клик по кнопке Войти в аккаунт
        mainPage.clickLoginAccountButton();
        // Ждем загрузки страницы Вход
        loginPage.waitForLoadAuthorizationPage();
        // Проверяем, что на странице Вход виден заголовок Вход
        assertTrue(AUTHORIZATION_PAGE_NOT_LOAD,
                loginPage.checkVisibilityHeadlineLogin());
        // Клик по ссылке Восстановить пароль
        loginPage.clickForgotPasswordLink();
        // Ждем загрузки страницы Восстановление пароля
        recoveryPasswordPage.waitForLoadPasswordRecoveryPage();
        // Клик по ссылке Войти
        recoveryPasswordPage.clickLoginLink();
        // Ждем загрузки страницы авторизации
        loginPage.waitForLoadAuthorizationPage();
        // Заполняем форму авторизации
        loginPage.completingAuthorizationForm(user.getEmail(), user.getPassword());
        // Клик по кнопке Войти
        loginPage.clickLoginButton();
        // Ждем загрузки главной страницы
        mainPage.waitForLoadMainPage();
        //Проверяем что на главной странице появилась кнопка оформить заказ
        assertTrue(SET_ORDER_BUTTON_NOT_APPEAR,
                mainPage.checkVisibilitySetOrderButton());
    }
}
