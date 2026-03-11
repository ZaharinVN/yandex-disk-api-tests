Yandex Disk REST API Autotests
Пример проекта автотестов для REST API Яндекс.Диска.
Разработан для тестового задания на вакансию стажёра «Инженер по автоматизации тестирования» в Финтех.

🎯 Цель проекта
Покрыть основные операции CRUD с использованием методов GET, POST, PUT, DELETE:
GET — информация о диске, проверка ресурсов
PUT — создание папок
POST — публикация ресурсов
DELETE — удаление ресурсов

Тесты независимы, используют уникальные пути, пропускаются при отсутствии OAuth-токена.

🛠️ Стек технологий
Компонент	Версия	Назначение
Java	17+	Основной язык
Gradle	latest	Сборщик проекта
JUnit 5	5.10.2	Тестовый фреймворк
RestAssured	5.4.0	HTTP-клиент
AssertJ	3.25.3	Удобные ассерты
📋 Требования
JDK 17+

Gradle (используется wrapper ./gradlew)

Интернет (доступ к https://cloud-api.yandex.net)

OAuth-токен Яндекс.Диска (инструкция ниже)

🔑 Настройка OAuth-токена
ВАЖНО: Не используйте личный аккаунт. Создайте тестовый или используйте токен от рекрутера.

Способ 1: Переменная окружения (рекомендуется)
bash
# Linux/macOS
export YANDEX_DISK_OAUTH="ваш_токен_здесь"

# Windows (cmd)
set YANDEX_DISK_OAUTH=ваш_токен_здесь
Способ 2: Системное свойство
bash
./gradlew test -Dyandex.disk.oauth=ваш_токен_здесь
Где взять токен?
Перейдите на Полигон Яндекс.Диска

Или создайте OAuth-приложение: Документация

Scope: cloud_api:disk.read cloud_api:disk.write

Скопируйте полученный токен

🚀 Запуск тестов
bash
# Клонировать репозиторий
git clone https://github.com/ваш-username/yandex-disk-api-tests.git
cd yandex-disk-api-tests

# Установить токен (см. раздел выше)

# Собрать проект
./gradlew build

# Запустить все тесты
./gradlew test

# Конкретный класс
./gradlew test --tests GetDiskApiTest

# С отладкой (логи запросов/ответов)
./gradlew test --info
✅ Если токен не установлен — тесты пропустятся (SKIPPED) с понятным сообщением.

📊 Покрытие тестов
Метод	Эндпоинт	Позитивные сценарии	Негативные сценарии
GET	/v1/disk	Информация о диске (total_space, used_space)	-
GET	/v1/disk/resources	Существующий ресурс	Несуществующий путь (404)
PUT	/v1/disk/resources	Создание папки → проверка GET	Некорректный путь (400)
POST	/v1/disk/resources/publish	Публикация существующей папки	Несуществующий ресурс (404)
DELETE	/v1/disk/resources	Удаление → проверка отсутствия	Несуществующий ресурс (404)
Всего тестов: 10+ (позитив/негатив + кросс-проверки)

📁 Структура проекта
text
yandex-disk-api-tests/
├── build.gradle                 # Зависимости, конфигурация
├── gradlew                      # Gradle wrapper
├── src/
│   └── test/java/ru/qa/yandex/disk/
│       ├── BaseApiTest.java     # Базовый класс тестов
│       ├── config/
│       │   └── Config.java      # Настройки (токен, baseUrl)
│       ├── client/
│       │   └── YandexDiskClient.java  # API-методы
│       ├── tests/               # Тестовые классы
│       │   ├── GetDiskApiTest.java
│       │   ├── PutCreateFolderTest.java
│       │   ├── PostPublishResourceTest.java
│       │   └── DeleteResourceTest.java
│       └── utils/
│           └── PathGenerator.java  # Уникальные пути
└── README.md
🧪 Пример вывода тестов
text
GetDiskApiTest > getDiskInfo_shouldReturnBasicInfo STANDARD_OUT
API Запрос: GET https://cloud-api.yandex.net/v1/disk
API Ответ: 200 OK {"total_space":...,"used_space":...}

Tests run: 12, Failures: 0, Errors: 0, Skipped: 0
🔍 Отчёт о покрытии
text
./gradlew test jacocoTestReport
Отчёты: build/reports/jacoco/test/html/index.html

⚠️ Возможные проблемы
Проблема	Решение
SKIPPED тесты	Установите YANDEX_DISK_OAUTH
401 Unauthorized	Проверьте валидность токена
Connection refused	Проверьте интернет
409 Conflict	Нормально для повторного создания
🚀 Расширения (для будущего)
Allure-отчёты: io.qameta.allure

Retry-логика для асинхронных операций

Docker-контейнер с mock-сервером для CI

GitHub Actions с секретами токена

Load-тестирование с Artillery/JMeter

Contract-тестирование (Pact)

📄 Лицензия
MIT License — используйте свободно для портфолио и обучения.

Автор: [Ваше имя]
Дата: Март 2026
Контакты: ваш-email@example.com
GitHub: github.com/ваш-username