package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import praktikum.pageObject.LoginPage;
import praktikum.pageObject.MainPage;
import praktikum.pageObject.ProfilePage;
import praktikum.user.User;
import praktikum.user.UserRandomData;
import praktikum.webDriverInit.WebDriverInitiator;

import static org.junit.Assert.assertTrue;
import static praktikum.constants.MessageConstants.*;

public class TestProfile extends WebDriverInitiator {

    private MainPage mainPage;
    private LoginPage loginPage;
    private ProfilePage profilePage;

    @Before
    public void setUp() throws Exception {

        initWebDriver();

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);

        User user = UserRandomData.generateRandomUser();
        userRequest.createUser(user);

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
        Thread.sleep(1_000);
        //Проверяем что на главной странице появилась кнопка оформить заказ
        assertTrue(SET_ORDER_BUTTON_NOT_APPEAR,
                mainPage.checkVisibilitySetOrderButton());
    }

    @Test
    @DisplayName("Проверка перехода по клику на «Личный кабинет»")
    @Description("Проверка возможности перехода авторизованного пользователя " +
            "в личный кабинет кликом по кнопке «Личный кабинет»")
    public void checkEnterPersonalAccount() {
        // Клик по кнопке Личный кабинет
        mainPage.clickPersonalAccountButton();
        // Ждем загрузки страницы Личный кабинет
        profilePage.waitForLoadProfileButton();
        // Проверяем, что на странице Личный кабинет видна кнопка Профиль
        assertTrue(LOGIN_TO_PERSONAL_ACCOUNT_NOT_COMPLETED,
                profilePage.checkVisibilityProfileButton());
    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета в конструктор по клику на «Конструктор»")
    @Description("Проверка возможности перехода авторизованного пользователя из личного кабинета " +
            "в конструктор кликом по кнопке «Конструктор»")
    public void checkEnterConstructorByConstructorButton() {
        // Клик по кнопке Личный кабинет
        mainPage.clickPersonalAccountButton();
        // Ждем загрузки страницы Личный кабинет
        profilePage.waitForLoadProfileButton();
        // Проверяем, что на странице Личный кабинет видна кнопка Профиль
        assertTrue(LOGIN_TO_PERSONAL_ACCOUNT_NOT_COMPLETED,
                profilePage.checkVisibilityProfileButton());
        // Клик по кнопке Конструктор
        profilePage.clickConstructorButton();
        // Ждем загрузки главной страницы
        mainPage.waitForLoadMainPage();
        //Проверяем что на главной странице появилась кнопка оформить заказ
        assertTrue(TRANSITION_TO_CONSTRUCTOR_FAILED,
                mainPage.checkVisibilitySetOrderButton());
    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета в конструктор по клику на логотип Stellar Burgers")
    @Description("Проверка возможности перехода авторизованного пользователя из личного кабинета " +
            "в конструктор кликом по логотипу Stellar Burgers")
    public void checkEnterConstructorByLogo() throws Exception {
        // Клик по кнопке Личный кабинет
        mainPage.clickPersonalAccountButton();
        // Ждем загрузки страницы Личный кабинет
        profilePage.waitForLoadProfileButton();
        Thread.sleep(1_000);
        // Проверяем, что на странице Личный кабинет видна кнопка Профиль
        assertTrue(LOGIN_TO_PERSONAL_ACCOUNT_NOT_COMPLETED,
                profilePage.checkVisibilityProfileButton());
        // Клик по логотипу
        profilePage.clickLogo();
        // Ждем загрузки главной страницы
        mainPage.waitForLoadMainPage();
        //Проверяем что на главной странице появилась кнопка оформить заказ
        assertTrue(TRANSITION_TO_CONSTRUCTOR_FAILED,
                mainPage.checkVisibilitySetOrderButton());
    }

    @Test
    @DisplayName("Проверка выхода из аккаунта по кнопке «Выйти» в личном кабинете")
    @Description("Проверка возможности выхода из аккаунта авторизованного пользователя " +
            "кликом по кнопке «Выйти» в личном кабинете")
    public void checkLogoutByButtonLogout() throws Exception {
        // Клик по кнопке Личный кабинет
        mainPage.clickPersonalAccountButton();
        // Ждем загрузки страницы Личный кабинет
        profilePage.waitForLoadProfileButton();
        Thread.sleep(1_000);
        // Проверяем, что на странице Личный кабинет видна кнопка Профиль
        assertTrue(LOGIN_TO_PERSONAL_ACCOUNT_NOT_COMPLETED,
                profilePage.checkVisibilityProfileButton());
        // Клик по кнопке Выйти
        profilePage.clickLogoutButton();
        // Ждем загрузки страницы Вход
        loginPage.waitForLoadAuthorizationPage();
        // Проверяем, что на странице Вход виден заголовок Вход
        assertTrue(EXIT_BUTTON_FAILED,
                loginPage.checkVisibilityHeadlineLogin());
    }
}
