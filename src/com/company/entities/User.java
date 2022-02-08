package com.company.entities;

public class User
{
    private int id;
    private String name;
    private String surname;


    public User(String name, String surname) {
        setName(name);
        setSurname(surname);
    }

    public User(int id, String name, String surname) {
        this(name, surname);
        setId(id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + surname;
    }
}
