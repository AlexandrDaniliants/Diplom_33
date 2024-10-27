package praktikum.constants;

import org.openqa.selenium.By;

public class LocatorConstants {

    //Кнопка "Войти в аккаунт"
    public static final By LOG_IN_ACCOUNT_BUTTON = By.xpath("//button[text()='Войти в аккаунт']");
    //Кнопка "Личный кабинет"
    public static final By PERSONAL_ACCOUNT_BUTTON = By.xpath(".//p[text()='Личный Кабинет']");
    //Активная секция раздела "Булки"
    public static final By ACTIVE_SECTION_BUN = By.xpath("//div[@class='tab_tab__1SPyG " +
            "tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");
    //Неактивная секция раздела "Булки"
    public static final By INACTIVE_SECTION_BUN = By.xpath("//div[@class='tab_tab__1SPyG  " +
            "pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");
    //Активная секция раздела "Соусы"
    public static final By ACTIVE_SECTION_SAUCE = By.xpath("//div[@class='tab_tab__1SPyG " +
            "tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");
    //Неактивная секция раздела "Соусы"
    public static final By INACTIVE_SECTION_SAUCE = By.xpath("//div[@class='tab_tab__1SPyG  " +
            "pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");
    //Активная секция раздела "Начинки"
    public static final By ACTIVE_SECTION_FILLING = By.xpath("//div[@class='tab_tab__1SPyG " +
            "tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");
    //Неактивная секция раздела "Начинки"
    public static final By INACTIVE_SECTION_FILLING = By.xpath("//div[@class='tab_tab__1SPyG  " +
            "pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");
    //Заголовок Соберите бургер
    public static final By HEADLINE_MAKE_BURGER = By.xpath("//h1[@class='text text_type_main-large mb-5 mt-10']");
    //Кнопка Оформить заказ
    public static final By SET_ORDER_BUTTON = By.xpath("//button[text()='Оформить заказ']");
    //Заголовок Вход
    public static final By HEADLINE_LOGIN = By.xpath("//h2[text()='Вход']");
    //Поле Email
    public static final By EMAIL_LOGIN_FIELD = By.xpath("//input[@name='name']");
    //Поле Пароль
    public static final By PASSWORD_LOGIN_FIELD = By.xpath("//input[@name='Пароль']");
    //Кнопка Войти
    public static final By LOGIN_BUTTON = By.xpath("//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx " +
            "button_button_size_medium__3zxIa']");
    //Ссылка Зарегистироваться
    public static final By REGISTER_LINK = By.xpath("//a[@href='/register']");
    //Сссылка Восстановить пароль
    public static final By FORGOT_PASSWORD_LINK = By.xpath("//a[@href='/forgot-password']");
    //Кнопка Конструктор
    public static final By CONSTRUCTOR_BUTTON = By.xpath("//p[text()='Конструктор']");
    //Логотип
    public static final By LOGO = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']/a");
    //Кнопка Профиль
    public static final By PROFILE_BUTTON = By.xpath("//a[@href='/account/profile']");
    //Кнопка Выход
    public static final By LOGOUT_BUTTON = By.xpath("//li[@class='Account_listItem__35dAP']/button");
    //Заголовок Регистрация
    public static final By HEADLINE_REGISTRATION = By.xpath("//h2[text()='Регистрация']");
    //Поле Имя
    public static final By NAME_REGISTRATION_FIELD = By.xpath("//label[text()='Имя']/../input");
    //Поле Email
    public static final By EMAIL_REGISTRATION_FIELD = By.xpath("//label[text()='Email']/../input");
    //Поле Пароль
    public static final By PASSWORD_REGISTRATION_FIELD = By.xpath("//label[text()='Пароль']/../input");
    //Кнопка Зарегистрироваться
    public static final By REGISTER_BUTTON = By.xpath("//button[@class='button_button__33qZ0 " +
            "button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    //Предупреждение Некорректный пароль
    public static final By WARNING_INCORRECT_PASSWORD = By.xpath("//p[@class='input__error text_type_main-default']");
    //Ссылка Войти
    public static final By LOGIN_LINK = By.xpath("//a[@href='/login']");
    //Заголовок Восстановление пароля
    public static final By HEADLINE_PASSWORD_RECOVERY = By.xpath("//h2[text()='Восстановление пароля']");
}
