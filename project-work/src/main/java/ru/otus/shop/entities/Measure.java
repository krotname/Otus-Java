package ru.otus.shop.entities;

public enum Measure {
    UNIT("unit"), PAIR("pair"), LITER("liter"), KILOGRAM("kg"), GRAM("g");

    private final String name;

    Measure(String name) {
        this.name = name;
    }

    public String getMeasureName() {
        return name;
    }
}
