package com.java8ex.filteringRandomUsers;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class UserService {

    public List<String> getAllNames(List<User> userList) {
        return userList.stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }

    public Set<String> getUniqueNames(List<User> userList) {
        return userList.stream()
                .map(User::getName)
                .collect(Collectors.toSet());
    }

    public Double getAverageAge(List<User> userList) {
        return userList.stream()
                .map(User::getAge)
                .reduce(0, (u1, u2) -> u1 += u2)
                .doubleValue() / userList.size();
    }

    public Integer getMaximumAge(List<User> userList) {
        return userList.stream()
                .mapToInt(User::getAge)
                .max()
                .orElseThrow(() -> new RuntimeException("List is empty"));
    }

    public Integer getMinimumAge(List<User> userList) {
        return userList.stream()
                .mapToInt(User::getAge)
                .min()
                .orElseThrow(() -> new RuntimeException("List is empty"));
    }

    public Map<Integer, User> groupById(List<User> userList) {
        return userList.stream()
                .collect(Collectors.toMap(User::getId, user -> user));
    }

    public String joinNamesByDelimiter(List<User> userList, String delimiter) {
        StringBuilder sb = new StringBuilder();
        userList.forEach(user -> sb.append(user.getName()).append(delimiter));
        return sb.toString();
    }

    public List<Skill> getAllSkills(List<User> userList) {
        return userList.stream()
                .map(User::getSkills)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public Set<Skill> getUniqueSkills(List<User> userList) {
        return userList.stream()
                .map(User::getSkills)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }


}
