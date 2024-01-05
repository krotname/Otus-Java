package ru.otus;

public class Cat {
    String breed;
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ToString
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @ToString
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
