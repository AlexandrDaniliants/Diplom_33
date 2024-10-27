package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import praktikum.pageObject.MainPage;
import praktikum.webDriverInit.WebDriverInitiator;

import static org.junit.Assert.assertTrue;
import static praktikum.constants.MessageConstants.*;

public class TestConstructor extends WebDriverInitiator {

    MainPage mainPage;

    @Before
    public void setUp() {

        initWebDriver();

        mainPage = new MainPage(driver);
    }

    @Test
    @DisplayName("Проверка работы перехода к разделу «Булки»")
    @Description("Проверка работы перехода к разделу «Булки» с предварительной " +
            "деактивацией раздела «Булки» кликом по кнопке неактивного " +
            "раздела «Начинки» и последующим кликом по кнопке уже неактивного " +
            "раздела «Булки»")
    public void checkActiveBunInConstructor()throws Exception{
        // Клик по неактивной кнопке Начинки, в начальном состоянии кнопка Булки активна,
        // клик по неактивной кнопке Начинки, переводит кнопку Булки в неактивное состояние
        mainPage.clickInactiveFillingButton();
        Thread.sleep(1_000);
        // Клик по неактивной кнопке Булки
        mainPage.clickInactiveBunButton();
        Thread.sleep(1_000);
        // Проверка активности секции Булки
        assertTrue(BUN_SECTION_NOT_ACTIVE, mainPage.checkActivityBunSection());
    }

    @Test
    @DisplayName("Проверка работы перехода к разделу «Соусы»")
    @Description("Проверка работы перехода к разделу «Соусы» кликом по кнопке " +
            "неактивного раздела «Соусы»")
    public void checkActiveSauceInConstructor(){
        // Клик по неактивной кнопке Соусы
        mainPage.clickInactiveSauceButton();
        // Проверка активности секции Соусы
        assertTrue(SAUCE_SECTION_NOT_ACTIVE, mainPage.checkActivitySaucesSection());
    }

    @Test
    @DisplayName("Проверка работы перехода к разделу «Начинки»")
    @Description("Проверка работы перехода к разделу «Начинки» кликом по кнопке " +
            "неактивного раздела «Начинки»")
    public void checkActiveFillingInConstructor(){
        // Клик по неактивной кнопке Начинки
        mainPage.clickInactiveFillingButton();
        // Проверка активности секции Начинки
        assertTrue(FILLING_SECTION_NOT_ACTIVE, mainPage.checkActivityFillingSection());
    }
}
