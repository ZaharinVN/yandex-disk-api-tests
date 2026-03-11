package ru.qa.yandex.disk.config;


/*
 * Конфигурация для API Яндекс.Диска
 * Читает OAuth-токен из переменной окружения YANDEX_DISK_OAUTH
 * Выбрасывает IllegalStateException при отсутствии токена
 * Использование: Config.getOAuthToken()
 */

public class Config {
    public static String getOAuthToken() {
        String token = System.getenv("YANDEX_DISK_OAUTH");
        if (token == null || token.isEmpty()) {
            throw new IllegalStateException("❌ Установите YANDEX_DISK_OAUTH=ваш_токен");
        }
        return token;
    }
}
