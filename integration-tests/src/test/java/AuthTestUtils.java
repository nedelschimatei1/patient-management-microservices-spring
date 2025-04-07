import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class AuthTestUtils {

    public static Response login(String email, String password, int expectedStatusCode, boolean validateToken) {
        String loginPayload = """
                {
                    "email": "%s",
                    "password": "%s"
                }
                """.formatted(email, password);

        var requestSpecs = given()
                .contentType("application/json")
                .body(loginPayload)
                .when()
                .post("/auth/login")
                .then()
                .statusCode(expectedStatusCode);


        if (validateToken && expectedStatusCode == 200) {
            requestSpecs.body("token", notNullValue());
        }

        return requestSpecs.extract().response();
    }

    public static Response loginSuccessful(String email, String password) {
        return login(email, password, 200, true);
    }

    public static Response loginFailed(String email, String password) {
        return login(email, password, 401, false);
    }
}