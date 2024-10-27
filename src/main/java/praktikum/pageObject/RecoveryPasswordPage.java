package praktikum.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static praktikum.constants.LocatorConstants.HEADLINE_PASSWORD_RECOVERY;
import static praktikum.constants.LocatorConstants.LOGIN_LINK;

public class RecoveryPasswordPage extends VisibilityWaiter {

    public RecoveryPasswordPage(WebDriver driver) {
        super(driver);
    }

    @Step("Клик по ссылке Войти")
    public void clickLoginLink() {
        driver.findElement(LOGIN_LINK).click();
    }

    @Step("Ожидание загрузки страницы восстановления пароля")
    public void waitForLoadPasswordRecoveryPage() {
        waitForVisibility(HEADLINE_PASSWORD_RECOVERY);
    }
}
