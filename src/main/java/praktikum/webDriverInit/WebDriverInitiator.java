package praktikum.webDriverInit;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import praktikum.requests.UserRequest;
import praktikum.user.User;

import static praktikum.constants.ApiRequestsConstants.API_REQUEST_URI;

public class WebDriverInitiator {
    public WebDriver driver;
    public String name;
    public String email;
    public String password;

    public UserRequest userRequest = new UserRequest();

    public void initWebDriver() {

//        //Запуск Яндекса
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.setBinary("C:\\Users\\79262\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
//        driver = new ChromeDriver(options);

//        //Запуск Мозиллы
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();

        //Запуск Chrome
        driver = new ChromeDriver();

        driver.get(API_REQUEST_URI);
    }

    @After
    public void tearDown() {

        String accessToken = userRequest.loginUser(new User(email,password)).then().extract().path("accessToken");
        if (accessToken != null) {
            userRequest.deleteUser(accessToken);
        }
        driver.quit();
    }
}
