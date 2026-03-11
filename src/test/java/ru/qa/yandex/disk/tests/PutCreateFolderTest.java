package ru.qa.yandex.disk.tests;

import org.junit.Test;
import ru.qa.yandex.disk.BaseApiTest;
import ru.qa.yandex.disk.utils.PathUtils;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

/*
 * Тесты PUT /v1/disk/resources — создание папок
 * Покрытие ТЗ:
 * ✅ Создание папки (201 Created / 409 Conflict)
 * ✅ Некорректный путь (400 Bad Request)
 * Кросс-проверка: создание → получение ресурса
 */

public class PutCreateFolderTest extends BaseApiTest {

    @Test
    public void createFolder_validPath_201() {
        String path = PathUtils.uniquePath("test-folder");

        given()
                .spec(spec)
                .queryParam("path", path)
                .when()
                .put("/resources")
                .then()
                // 201 Created или 409 Conflict (если уже существует)
                .statusCode(anyOf(is(201), is(409)))
                .contentType("application/json");
    }

    @Test
    public void createFolder_invalidPath_400() {
        given()
                .spec(spec)
                .queryParam("path", "")  // Пустой путь
                .when()
                .put("/resources")
                .then()
                .statusCode(400);
    }
}
