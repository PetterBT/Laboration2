package com;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

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
    @Test
    void twoNumbersShouldReturnTheirsSum() {
        assertThat(Calculator.add("2,6")).isEqualTo(8);
        assertThat(Calculator.add("151,1349")).isEqualTo(1500);
    }
    @Test
    void shouldReturnSumRegardlessOfAmountOfNumbers() {
        assertThat(Calculator.add("34,66")).isEqualTo(100);
        assertThat(Calculator.add("1,2,3,50,944")).isEqualTo(1000);
    }
    @Test
    void shouldAcceptNewLineInsteadOfCommaAsDelimiter() {
        assertThat(Calculator.add("2\n3,5")).isEqualTo(10);
        assertThatThrownBy(() -> Calculator.add("2,\n3"))
                .isInstanceOf(NumberFormatException.class);
    }
    @Test
    void shouldChangeDelimiterWhenInputStartsWithDubbleForwardSlash() {
        assertThat(Calculator.add("//;\n2;4;4")).isEqualTo(10);
        assertThat(Calculator.add("//-\n10-16-76-98")).isEqualTo(200);
    }
    @Test
    void negativeNumbersShouldThrowExceptionWithMessage() {
        assertThatThrownBy(() -> Calculator.add("-19989"))
                .hasMessageContaining("negatives not allowed")
                .hasMessageContaining("-19989");
        assertThatThrownBy(() -> Calculator.add("-1,7,-3"))
                .hasMessageContaining("negatives not allowed ")
                .hasMessageContaining("-1 -3");
    }
}
