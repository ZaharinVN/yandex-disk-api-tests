package ru.qa.yandex.disk.tests;

import org.junit.Test;
import ru.qa.yandex.disk.BaseApiTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetDiskTest extends BaseApiTest {

    @Test
    public void getDiskInfo_200() {
        given()
                .spec(spec)
                .when()
                .get("/")
                .then()
                .statusCode(200)
                .body("total_space", notNullValue())
                .body("used_space", notNullValue());
    }
}

