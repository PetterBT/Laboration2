package com;

public class Calculator {

    static int add(String numbers) {
        if (!numbers.isEmpty()) {
            String[] numbersArr = numbers.split(",");
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
