package com;

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
            return getSum(numbersArr);
        }
        else return 0;
    }
    private static int getSum(String[] numbersArr) {
        int sum = 0;
        for (String s : numbersArr) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }
}
