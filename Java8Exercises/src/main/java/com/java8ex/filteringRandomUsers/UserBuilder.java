package com.java8ex.filteringRandomUsers;

import java.util.ArrayList;
import java.util.List;

public class UserBuilder {

    private int id;
    private String name;
    private int age;
    private List<Skill> skills;

    public UserBuilder(){
        skills = new ArrayList<>();
    }

    public User build() {
        return new User(this.id, this.name, this.age, this.skills);
    }

    public UserBuilder withId(int id){
        this.id = id;
        return this;
    }

    public UserBuilder withName(String name){
        this.name = name;
        return this;
    }

    public UserBuilder withAge(int age){
        this.age = age;
        return this;
    }

    public UserBuilder withSkill(Skill skill){
        skills.add(skill);
        return this;
    }

}
