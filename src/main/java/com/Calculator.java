package com;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    static int add(String numbers) {
        if (!numbers.isEmpty()) {

            String delimiter = "[,\n]";
            if (numbers.startsWith("//")) {
                String[] parts = numbers.split("\n",2);
                delimiter = parts[0].substring(2);
                numbers = parts[1];
            }
            String[] numbersArr = numbers.split(delimiter);
            noNegativeNumbers(toInt(numbersArr));
            return getSum(numbersArr);
        }
        else return 0;
    }
    private static void noNegativeNumbers(List<Integer> numbers) {
        StringBuilder builder = new StringBuilder();
        numbers.stream()
                .filter(n -> n < 0)
                .forEach(n -> builder.append(n).append(" "));
        if (!builder.toString().isEmpty()) {
            throw new RuntimeException("negatives not allowed " + builder.toString());}
    }
    private static int getSum(String[] numbersArr) {
        int sum = 0;
        for (String s : numbersArr) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }
    private static List<Integer> toInt(String[] numbers) {
        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
