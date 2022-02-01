package com;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {

    @Test
    void emptyStringShouldReturnZero() {
        assertThat(Calculator.add("")).isEqualTo(0);
    }

}
