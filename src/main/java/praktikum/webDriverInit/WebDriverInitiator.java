package praktikum.webDriverInit;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import praktikum.requests.UserRequests;
import praktikum.user.User;

import static praktikum.constants.ApiRequestsConstants.API_REQUEST_URI;

public class WebDriverInitiator1 {
    public WebDriver driver;
    public String name;
    public String email;
    public String password;

    public UserRequests userRequests = new UserRequests();

    public void initWebDriver() {

        //Для запуска тестов на Yandex
        //System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
        //ChromeOptions options = new ChromeOptions();
        //options.setBinary("C:\\ProjectsPraktikum\\Yandex\\YandexBrowser\\Application\\browser.exe");
        //driver = new ChromeDriver(options);

        //Для запуска тестов на Chrome
        driver = new ChromeDriver();

        driver.get(API_REQUEST_URI);
    }

    @After
    public void tearDown() {

        String accessToken = userRequests.loginUser(new User(email,password)).then().extract().path("accessToken");
        if (accessToken != null) {
            userRequests.deleteUser(accessToken);
        }
        driver.quit();
    }
}
