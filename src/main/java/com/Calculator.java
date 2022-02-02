package com;

import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Calculator {

    private String delimiter;
    private String numbers;

    public Calculator() {}
    public Calculator(String delimiter, String numbers) {
        this.delimiter = delimiter;
        this.numbers = numbers;
    }

    int add(String input) {
       if (input.isEmpty())
           return 0;
       else {
           return sortOutNumbers(input).getSum();
       }
    }
    private static Calculator sortOutNumbers(String input) {
        if (!input.startsWith("//"))
            return new Calculator(",|\n", input);
        else {
        String[] delimiterAndNumbers = input.split("\n", 2);
            return new Calculator(getCustomDelimiter(delimiterAndNumbers[0]), delimiterAndNumbers[1]);
        }
    }
    private static String getCustomDelimiter(String customDelimiter) {
        String delimiter = customDelimiter.substring(2);
        if (delimiter.startsWith("[")) {
            delimiter = delimiter.substring(1, delimiter.length() - 1);
        }
        return Stream.of(delimiter.split("]\\["))
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
    }
    private int getSum() {
        checkForNegativeNumbers();
        return getNumbers().sum();
    }
    private void checkForNegativeNumbers() {
        String negativeNumbers = getNumbers().filter(n -> n < 0)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(" "));
        printNegativeNumbers(negativeNumbers);
    }
    private void printNegativeNumbers(String negatives) {
        if (!negatives.isEmpty()) {
            throw new RuntimeException("negatives not allowed " + negatives);}
    }
    private IntStream getNumbers() {
        return Stream.of(numbers.split(delimiter))
                .mapToInt(Integer::parseInt)
                .filter(n -> n < 1000);
    }
}
