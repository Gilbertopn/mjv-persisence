package com.mjv.curso.model;

public class User {
    private String fullName;
    private int age;
    private String profession;

    public User(String fullName, int age, String profession) {
        this.fullName = fullName;
        this.age = age;
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "Nome: " + fullName + ", Idade: " + age + ", Profissão: " + profession;
    }
}
