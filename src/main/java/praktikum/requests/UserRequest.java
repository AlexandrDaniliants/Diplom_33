package praktikum.requests;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import praktikum.user.User;

import static io.restassured.RestAssured.given;
import static praktikum.constants.UserConstants.*;

public class UserRequest extends ApiUri{

    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    @Step("Создание пользователя")
    public void createUser(User user){
        setUpUri();
        given()
                .contentType(ContentType.JSON)
                .body(user)
                .post(CREATE_USER_PATH);
    }

    @Step("Авторизация пользователя")
    public Response loginUser(User user) {
        setUpUri();
        return given()
                .contentType(ContentType.JSON)
                .body(user)
                .post(LOGIN_USER_PATH);
    }

    @Step("Удаление пользователя")
    public void deleteUser(String accessToken) {
        setUpUri();
        given().log().all()
                .header("Authorization", accessToken)
                .when()
                .delete(DELETE_USER_PATH);
    }
}
