package ru.qa.yandex.disk.utils;

import java.util.UUID;

public class PathUtils {
    public static String uniquePath(String prefix) {
        return "/" + prefix + "-" + System.currentTimeMillis() + "-" + UUID.randomUUID().toString().substring(0, 8);
    }
}
