package com.java8ex.filteringRandomUsers;

import java.util.ArrayList;
import java.util.List;

public class RandomUserGenerator {

    private int currentId;

    public List<User> generateRandomUsers(int amount) {
        this.currentId = 0;
        List<User> outputList = new ArrayList<>();
        while ((amount--) > 0) {
            outputList.add(generateRandomUser());
        }
        currentId = 0;
        return outputList;
    }

    private User generateRandomUser() {
        currentId++;
        return User.createUser()
                .withId(currentId)
                .withName(generateRandomString())
                .withAge(generateNumberBetween(1, 100))
                .withSkill(new Skill(generateRandomString()))
                .withSkill(new Skill(generateRandomString()))
                .build();
    }

    public String generateRandomString() {
        int randomNameLength = generateNumberBetween(5, 15);
        char[] randomName = new char[randomNameLength];
        for (int i = 0; i < randomNameLength; i++) {
            int generatedAsciiCode = generateNumberBetween(97, 122);
            if (i == 0) {
                randomName[i] = Character.toUpperCase((char) generatedAsciiCode);
            } else {
                randomName[i] = (char) generatedAsciiCode;
            }
        }
        return new String(randomName);
    }

    private int generateNumberBetween(int a, int b) {
        return a + (int) (Math.random() * ((b - a) + 1));
    }
}
