package ru.qa.yandex.disk.utils;

import java.util.UUID;

/*
 * Утилита для генерации уникальных путей ресурсов
 * Гарантирует независимость тестов — каждый тест создает уникальную папку
 * Пример: /test-folder-1743242502613-ab12cd34
 */

public class PathUtils {
    public static String uniquePath(String prefix) {
        return "/" + prefix + "-" + System.currentTimeMillis() + "-" + UUID.randomUUID().toString().substring(0, 8);
    }
}
