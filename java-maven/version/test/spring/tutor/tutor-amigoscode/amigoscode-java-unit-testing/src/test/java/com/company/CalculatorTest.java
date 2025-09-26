package com.company;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    public void canAddNumbers() {
        var calculator = new Calculator();
        var result = calculator.add(1, 2);
        assertEquals(3, result);
        Assertions.assertThat(result).isEqualTo(3);
    }
}