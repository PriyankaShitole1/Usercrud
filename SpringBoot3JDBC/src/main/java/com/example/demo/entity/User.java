package com.example.demo.entity;

public class User {
    private int id;
    private String name;
    private int age;
    private String city;

    // Constructors
    public User() {
    }

    public User(int id, String name, int age, String city) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // ✅ toString method for readable output
    @Override
    public String toString() {
        return "User { " +
               "id = " + id +
               ", name = '" + name + '\'' +
               ", age = " + age +
               ", city = '" + city + '\'' +
               " }";
    }
}
