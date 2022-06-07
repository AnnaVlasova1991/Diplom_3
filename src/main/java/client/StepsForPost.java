package client;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import model.UserCreate;

import static io.restassured.RestAssured.given;
public class StepsForPost extends BaseHttpClient {
    @Step(value = "Создаем пользователя. Делаем POST запрос по endpoint: \"/api/auth/register\". Передаем email, password, name")
    public static Response doPostRequestForCreateUser(UserCreate userCreate) {
        return given()
                .header("Content-Type", "application/json")
                .and()
                .body(userCreate)
                .when()
                .post(BASEURL + "/api/auth/register");
    }

}
