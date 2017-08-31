package com.java8ex.filteringDictionary;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class TestClass {

    public static void main(String[] args) {

        FileLoader fileLoader = new FileLoader();
        WordsService wordsService = new WordsService();
        List<String> words = fileLoader.getAllWords("src/main/resources/dictionary.txt");

        NumberFormat format = new DecimalFormat("#0.00");

        System.out.println("DEMO");
        System.out.println("ALL CONTAINING 'abcd': " + wordsService.getAllContaining(words, "abcd"));
        System.out.println("PALINDROMES: " + wordsService.getOnlyPalindromes(words));
        System.out.println("ALL LENGTH 9: " + wordsService.getAllLength(words, 9));
        System.out.println("AVERAGE LENGTH: " + format.format(wordsService.getAverageLength(words)));
        System.out.println("MEDIAN: " + wordsService.getMedian(words));
        System.out.println("STATS: ");
        wordsService.getAverageStatisticsForAllLetters(words).forEach(System.out::println);

    }
}
