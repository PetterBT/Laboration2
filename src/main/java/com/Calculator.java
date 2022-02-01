package com;

public class Calculator {

    static int add(String numbers) {
        if (numbers.isEmpty())
        return 0;
        else if (numbers.contains(",")) {
            String[] numbersArr = numbers.split(",");
            int sum = 0;
            for (int i = 0; i < numbersArr.length; i++) {
                sum += Integer.parseInt(numbersArr[i]);
            }
            return sum;
        }
        else {
            return Integer.parseInt(numbers);
        }
    }
}
