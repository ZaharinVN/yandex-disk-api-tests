package ru.qa.yandex.disk.tests;

import org.junit.Test;
import ru.qa.yandex.disk.BaseApiTest;
import ru.qa.yandex.disk.utils.PathUtils;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


/*
 * Тесты публикации ресурсов PUT /v1/disk/resources/publish
 * Сценарий:
 * 1. PUT /resources — создаем папку
 * 2. PUT /resources/publish — публикуем (200 OK)
 * Покрытие:
 * ✅ Публикация существующего ресурса
 * ✅ Публикация несуществующего (404)
 */

public class PostPublishTest extends BaseApiTest {

    @Test
    public void publish_afterCreate_200() {
        String path = PathUtils.uniquePath("publish-test");

        // 1. Создаём папку
        given().spec(spec).queryParam("path", path).put("/resources");

        // 2. ПУБЛИКУЕМ (PUT, не POST!)
        given()
                .spec(spec)
                .queryParam("path", path)
                .when()
                .put("/resources/publish")  // ← PUT вместо POST
                .then()
                .statusCode(200)
                .body("href", notNullValue());
    }

    @Test
    public void publish_nonExisting_404() {
        String path = PathUtils.uniquePath("non-existing");
        given()
                .spec(spec)
                .queryParam("path", path)
                .when()
                .put("/resources/publish")
                .then()
                .statusCode(404);
    }
}
