package ru.qa.yandex.disk;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/*
 * Простой тест для проверки работоспособности:
 * - JUnit 4 + Gradle
 * - IntelliJ/CLI запуск
 * GREEN = вся тестовая инфраструктура работает
 */

public class SimpleTest {

    @Test
    public void testOne() {
        assertTrue(true);
    }

    @Test
    public void testTwo() {
        assertThat(1 + 1, equalTo(2));
    }
}