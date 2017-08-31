package com.java8ex.filteringRandomUsers;

import java.util.List;

public class User {

    private int id;
    private String name;
    private int age;
    private List<Skill> skills;

    public User(int id, String name, int age, List<Skill> skills) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.skills = skills;
    }

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

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public static UserBuilder createUser() {
        return new UserBuilder();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", skills=" + skills +
                '}';
    }
}
