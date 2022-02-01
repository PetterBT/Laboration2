package com;

public class Calculator {

    static int add(String numbers) {
        if (numbers.isEmpty())
        return 0;
        else if (numbers.contains(",")) {
            String[] numbersArr = numbers.split(",");
            return Integer.parseInt(numbersArr[0]) + Integer.parseInt(numbersArr[1]);
        }
        else {
            return Integer.parseInt(numbers);
        }
    }
}
