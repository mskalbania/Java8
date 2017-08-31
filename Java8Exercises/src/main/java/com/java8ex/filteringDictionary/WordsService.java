package com.java8ex.filteringDictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class WordsService {

    private final Predicate<String> palindromePredicate = string -> {
        String[] letters = string.split("");
        for (int i = 0; i < (string.length() / 2); i++) {
            boolean letterMatch = Objects.equals(letters[i], letters[(string.length() - 1) - i]);
            if (!letterMatch) return false;
        }
        return true;
    };

    public List<String> getAllContaining(List<String> wordList, String subString) {
        return wordList.stream()
                .filter(s -> s.contains(subString))
                .collect(Collectors.toList());
    }

    public List<String> getOnlyPalindromes(List<String> wordList) {
        return wordList.stream()
                .filter(palindromePredicate)
                .collect(Collectors.toList());
    }

    public List<String> getAllLength(List<String> wordList, int length) {
        return wordList.stream()
                .filter(s -> s.length() == length)
                .collect(Collectors.toList());
    }

    public Double getAverageLength(List<String> wordList) {
        return wordList.stream()
                .mapToDouble(String::length)
                .average()
                .orElseThrow(() -> new RuntimeException("List is empty"));
    }

    public Integer getMedian(List<String> wordList) {

        List<Integer> sortedLengths = wordList.stream()
                .map(String::length)
                .sorted()
                .collect(Collectors.toList());

        if ((sortedLengths.size() % 2) == 0) {
            int middle1 = sortedLengths.get((sortedLengths.size() / 2) - 1);
            int middle2 = sortedLengths.get((sortedLengths.size() / 2));
            return (middle1 + middle2) / 2;
        } else {
            return sortedLengths.get(sortedLengths.size() / 2);
        }
    }

    public List<LetterStatistic> getAverageStatisticsForAllLetters(List<String> wordList) {
        Long allLettersAmount = getAllLettersAmount(wordList);
        List<LetterStatistic> letterStatistics = new ArrayList<>();
        for (int i = 97; i <= 122; i++) {
            String letter = String.valueOf((char) i);
            Double percentages = getAverageForLetter(wordList, letter, allLettersAmount);
            letterStatistics.add(new LetterStatistic(letter, percentages));
        }
        return letterStatistics;
    }

    private Long getAllLettersAmount(List<String> wordList) {
        return wordList.stream()
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .count();
    }

    private Double getAverageForLetter(List<String> wordList, String letter, Long allLettersAmount) {

        long specifiedLettersAmount = wordList.stream()
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .filter(s -> s.equals(letter))
                .count();
        return calculatePercentages(allLettersAmount, specifiedLettersAmount);
    }

    private Double calculatePercentages(long allLettersAmount, long specifiedLettersAmount) {
        return ((double) specifiedLettersAmount / (double) allLettersAmount) * 100.0;
    }
}
