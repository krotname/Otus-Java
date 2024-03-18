package ru.otus.shop.utils;

import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class AppUtil {
    public static String randomUUID() {
        return UUID.randomUUID().toString();
    }
}
