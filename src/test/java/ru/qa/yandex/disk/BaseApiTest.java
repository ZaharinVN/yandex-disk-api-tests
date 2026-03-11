package ru.qa.yandex.disk;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;
import ru.qa.yandex.disk.config.Config;

public abstract class BaseApiTest {

    public static RequestSpecification spec;

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://cloud-api.yandex.net/v1/disk";

        String token = Config.getOAuthToken();
        spec = new RequestSpecBuilder()
                .addHeader("Authorization", "OAuth " + token)
                .setAccept("application/json")
                .log(io.restassured.filter.log.LogDetail.ALL)
                .build();
    }
}
