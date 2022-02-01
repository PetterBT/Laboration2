package com;

public class Calculator {

    static int add(String numbers) {
        if (numbers.isEmpty())
        return 0;
        else {
            return Integer.parseInt(numbers);
        }
    }
}
