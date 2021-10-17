package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import stringCalculatorTDD.Calculator;

class StringCalculatorShould {

    @Test
    public void empty_string_should_return_0() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void string_with_single_number_should_return_number_as_int() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(1, stringCalculator.add("1"));
    }
    
    @Test
	public void shouldReturnSumOfNumbersOnTwoStrings() {
		assertEquals(3, Calculator.add("1,2"));
	}
    
    @Test
	public void shouldReturnSumOfAllNumbers() {
		assertEquals(6,Calculator.add("1,2,3"));
	}
    
    @Test
	public void shouldAllowNewLineAsDelimiter() {
		assertEquals(6,Calculator.add("1\n2,3"));
	}
    
    @Test
	public void shouldAllowCustomDelimiter() {
		assertEquals(3,Calculator.add("//;\n1;2"));
	}
    
    @Test
	public void shouldAllowRegexCharAsCustomDelimiter() {
		assertEquals(3,Calculator.add("//.\n1.2"));
	}
    
    @Test
	public void shouldThrowExceptionForNegativeNumbers() {
		try{
			Calculator.add("1,-2,3");
			fail("Exception expected");
		}catch(RuntimeException e) {
		}
	}
    
    @Test
	public void shouldHaveNegativeNumbersInException() {
		try{
			Calculator.add("-1,-2,3");
			fail("Exception expected");
		}catch(RuntimeException e) {
			assertEquals("negatives not allowed: -1, -2",e.getMessage());
		}
	}
}
