package com;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    static int add(String numbers) {
       if (numbers.isEmpty())
           return 0;
       else {
           List<Integer> numbersList = toInt(getSplit(numbers));
           checkForNegativeNumbers(numbersList);
           return getSum(numbersList);
       }
    }
    private static String[] getSplit(String numbers) {
        String delimiter = "[,\n]";
        if (numbers.startsWith("//")) {
            String[] parts = numbers.split("\n",2);
            delimiter = parts[0].substring(2);
            numbers = parts[1];
        }
        return numbers.split(delimiter);
    }

    private static List<Integer> toInt(String[] numbers) {
        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void checkForNegativeNumbers(List<Integer> numbers) {
        StringBuilder builder = new StringBuilder();
        numbers.stream()
                .filter(n -> n < 0)
                .forEach(n -> builder.append(n).append(" "));
        printNegatives(builder);
    }

    private static void printNegatives(StringBuilder builder) {
        if (!builder.toString().isEmpty()) {
            throw new RuntimeException("negatives not allowed " + builder);}
    }
    private static int getSum(List<Integer> numbers) {
        int sum = 0;
        for (Integer n : numbers) {
            sum += n;
        }
        return sum;
    }
}
