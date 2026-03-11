# Yandex Disk REST API Autotests ✅

**Тестовое задание: Автотесты для REST API Яндекс.Диска (GET/POST/PUT/DELETE)**

[![Tests](https://github.com/ZaharinVN/yandex-disk-api-tests/actions/workflows/test.yml/badge.svg)](https://github.com/ZaharinVN/yandex-disk-api-tests/actions)

## 🎯 Покрытие ТЗ

| Метод | ✅ Статус | Эндпоинт |
|-------|-----------|----------|
| **GET** | ✅ 2 теста | `/v1/disk`, `/v1/disk/resources` |
| **PUT** | ✅ 2 теста | `/v1/disk/resources` (создание папки) |
| **POST** | ✅ 2 теста | `/v1/disk/resources/publish` (публикация) |
| **DELETE** | ✅ 2 теста | `/v1/disk/resources` (удаление) |

**Всего: 8 тестов (4 позитив + 4 негатив)**

## 🛠️ Стек
- **Java 17** + **JUnit 4.13.2**
- **Gradle** (wrapper)
- **RestAssured 5.4.0**
- **100% GREEN** локально

## 🚀 Быстрый старт

```powershell
# 1. Клонировать
git clone https://github.com/ZaharinVN/yandex-disk-api-tests.git
cd yandex-disk-api-tests

# 2. Токен (полигон: https://yandex.ru/dev/disk/poligon/)
$env:YANDEX_DISK_OAUTH="y0__xD2leveCBjblgMgsYqP2xYwpIz-2Acg3lbcsUuoeLM9xBRCrwxptEzSNQ"

# 3. Все тесты
./gradlew clean test

# Результат: Tests run: 8, Failures: 0 ✅

#  📁 Структура проекта
src/test/java/ru/qa/yandex/disk/
├── BaseApiTest.java      # Базовый класс
├── Config.java           # OAuth токен
├── PathUtils.java        # Уникальные пути
├── SimpleTest.java       # Проверка JUnit
├── GetDiskTest.java      # GET тесты
├── PutCreateFolderTest.java # PUT тесты
├── PostPublishTest.java  # POST/PUT publish
└── DeleteResourceTest.java # DELETE тесты

# ✅ Результат запуска
Tests run: 8, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESSFUL

# 🔗 Документация API
Официальная документация
https://yandex.ru/dev/disk/api/concepts/about-docpage/
Полигон для токена
https://yandex.ru/dev/disk/poligon/
REST API
https://yandex.ru/dev/disk/rest/

# Автор: Захарин Виталий (t.me/@ZaharinVN)
Дата: Март 2026
Статус: ✅ ВСЕ ТРЕБОВАНИЯ ВЫПОЛНЕНЫ