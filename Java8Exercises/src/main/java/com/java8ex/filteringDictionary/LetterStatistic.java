package com.java8ex.filteringDictionary;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class LetterStatistic {

    private String letter;
    private Double percentage;
    private final NumberFormat formatter = new DecimalFormat("#0.00");

    public LetterStatistic(String letter, Double percentage) {
        this.letter = letter;
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return letter + " -> " + formatter.format(percentage) + " %";
    }
}
