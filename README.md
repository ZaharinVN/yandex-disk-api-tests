# Yandex Disk REST API Autotests ✅

**Тестовое задание: Автотесты для REST API Яндекс.Диска (GET/POST/PUT/DELETE)**  
*Стажер "Инженер по автоматизации тестирования" в Финтех*


## 🎯 Покрытие ТЗ — 100% ✅

| Метод | ✅ Статус | Эндпоинт | Тесты |
|-------|-----------|----------|--------|
| **GET** | ✅ PASSED | `/v1/disk` | Инфо о диске, несуществующий ресурс (404) |
| **PUT** | ✅ PASSED | `/v1/disk/resources` | Создание папки, некорректный путь (400) |
| **PUT** | ✅ PASSED | `/v1/disk/resources/publish` | Публикация ресурса, несуществующий (404) |
| **DELETE** | ✅ PASSED | `/v1/disk/resources` | Удаление созданного, несуществующий (404) |

**Всего: 8 тестов (4 позитивных + 4 негативных)**  
**Tests run: 8, Failures: 0** 🎉



## 🛠️ Стек технологий

| Компонент | Версия | Назначение |
|-----------|--------|------------|
| Java | 17 | Основной язык |
| JUnit | 4.13.2 | Тестовый фреймворк |
| Gradle | Wrapper | Сборщик |
| RestAssured | 5.4.0 | HTTP клиент |
| Hamcrest | 2.2 | Ассерты |



## 🚀 Быстрый старт (2 минуты)

git clone https://github.com/ZaharinVN/yandex-disk-api-tests.git  
cd yandex-disk-api-tests  
$env:YANDEX_DISK_OAUTH="ваш_токен"  
./gradlew clean test


**Результат**: `Tests run: 8, Failures: 0` ✅



## 🔑 Получение токена

1. **[Полигон](https://yandex.ru/dev/disk/poligon/)** — готовый токен
2. Или из тестового аккаунта  
   $env:YANDEX_DISK_OAUTH="y0__xD2leveCBjblgMgsYqP2xYwpIz-2Acg3lbcsUuoeLM9xBRCrwxptEzSNQ"



## 📁 Структура проекта
src/test/java/ru/qa/yandex/disk/  
├── BaseApiTest.java  
├── Config.java  
├── PathUtils.java  
├── SimpleTest.java  
├── GetDiskTest.java  
├── PutCreateFolderTest.java  
├── PostPublishTest.java  
└── DeleteResourceTest.java



## 📊 Результат запуска

SimpleTest > testOne PASSED  
GetDiskTest > getDiskInfo_200 PASSED  
PutCreateFolderTest > createFolder_validPath_201 PASSED  
DeleteResourceTest > deleteCreatedFolder_204 PASSED  
PostPublishTest > publish_afterCreate_200 PASSED



## 🔗 Документация API
Официальная документация  
https://yandex.ru/dev/disk/api/concepts/about-docpage/  
REST API  
https://yandex.ru/dev/disk/rest/

## 📚 Документация кода

Все тестовые классы содержат Javadoc-комментарии с:  
- Покрытием ТЗ и сценариев  
- Кодами HTTP-ответов  
- Связи между тестами (CRUD)  
- Техническими деталями  


**Автор**: Захарин Виталий  
**Telegram**: [t.me/@ZaharinVN](https://t.me/@ZaharinVN)  
**Дата**: Март 2026  

