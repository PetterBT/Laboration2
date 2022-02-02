package com;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void emptyStringShouldReturnZero() {
        assertThat(calculator.add("")).isEqualTo(0);
    }
    @Test
    void stringWithOneNumberShouldReturnNumber() {
        assertThat(calculator.add("5")).isEqualTo(5);
        assertThat(calculator.add("69")).isEqualTo(69);
    }
    @Test
    void twoNumbersShouldReturnTheirsSum() {
        assertThat(calculator.add("2,6")).isEqualTo(8);
        assertThat(calculator.add("151,349")).isEqualTo(500);
    }
    @Test
    void shouldReturnSumRegardlessOfAmountOfNumbers() {
        assertThat(calculator.add("34,66")).isEqualTo(100);
        assertThat(calculator.add("1,2,3,50,944")).isEqualTo(1000);
    }
    @Test
    void shouldAcceptNewLineInsteadOfCommaAsDelimiter() {
        assertThat(calculator.add("2\n3,5")).isEqualTo(10);
        assertThatThrownBy(() -> calculator.add("2,\n3"))
                .isInstanceOf(NumberFormatException.class);
    }
    @Test
    void shouldChangeDelimiterWhenInputStartsWithDubbleForwardSlash() {
        assertThat(calculator.add("//;\n2;4;4")).isEqualTo(10);
        assertThat(calculator.add("//-\n10-16-76-98")).isEqualTo(200);
    }
    @Test
    void negativeNumbersShouldThrowExceptionWithMessage() {
        assertThatThrownBy(() -> calculator.add("-19989"))
                .hasMessageContaining("negatives not allowed")
                .hasMessageContaining("-19989");
        assertThatThrownBy(() -> calculator.add("-1,7,-3"))
                .hasMessageContaining("negatives not allowed ")
                .hasMessageContaining("-1 -3");
    }
    @Test
    void numbersLargerThan1000ShouldBeIgnored() {
        assertThat(calculator.add("2,1002,5")).isEqualTo(7);
        assertThat(calculator.add("1009,1008")).isEqualTo(0);
    }
    @Test
    void delimiterCanConsistOfSeveralCharacters() {
        assertThat(calculator.add("//kkk\n5kkk5")).isEqualTo(10);
        assertThat(calculator.add("//***\n5***5***69")).isEqualTo(79);
    }
}
