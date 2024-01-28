package ru.otus.util;

import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class AppUtil {
    public static String randomUUID() {
        return UUID.randomUUID().toString();
    }
}
