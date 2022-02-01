package com;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {

    @Test
    void emptyStringShouldReturnZero() {
        assertThat(Calculator.add("")).isEqualTo(0);
    }
    @Test
    void stringWithOneNumberShouldReturnNumber() {

        assertThat(Calculator.add("5")).isEqualTo(5);
        assertThat(Calculator.add("69")).isEqualTo(69);
    }

}
