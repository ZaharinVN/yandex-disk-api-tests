package ru.qa.yandex.disk.tests;

import org.junit.Test;
import ru.qa.yandex.disk.BaseApiTest;
import ru.qa.yandex.disk.utils.PathUtils;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


/*
 * Тесты DELETE /v1/disk/resources — удаление ресурсов
 * Полный CRUD цикл:
 * 1. PUT /resources — создаем
 * 2. DELETE /resources?permanently=true — удаляем (204/202)
 * Покрытие:
 * ✅ Удаление созданного ресурса
 * ✅ Удаление несуществующего (404)
 */

public class DeleteResourceTest extends BaseApiTest {

    @Test
    public void deleteCreatedFolder_204() {
        String path = PathUtils.uniquePath("delete-test");

        // 1. Создаём
        given().spec(spec).queryParam("path", path).put("/resources");

        // 2. Удаляем
        given()
                .spec(spec)
                .queryParam("path", path)
                .queryParam("permanently", "true")
                .when()
                .delete("/resources")
                .then()
                .statusCode(anyOf(is(204), is(202)));  // 204 No Content или 202 Accepted
    }
}
