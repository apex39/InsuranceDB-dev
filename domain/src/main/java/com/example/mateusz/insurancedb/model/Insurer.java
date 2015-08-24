package com.example.mateusz.insurancedb.model;

/**
 * Created by mateusz on 27.12.14.
 */
public class Insurer {
    private final String name;
    private final String surname;
    private final String id;

    public Insurer(String name, String surname, String id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getId() {
        return id;
    }
}
