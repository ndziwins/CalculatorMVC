package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Calculations;
import model.ICalculate;

public class CalculationsTest {
	private String input,expected,result;
	ICalculate calc;
	
	@BeforeEach
	public void createCalculate() {
		calc = new Calculations();
	}
	
	@Test
	public void comaTest() {
		input = "1.2";
		expected = "1,2";
		result = calc.calculate(input);
		assertEquals(expected, result);
		
		input = "1,32";
		expected = "1,32";
		result = calc.calculate(input);
		assertEquals(expected, result);
	}
	
	@Test
	public void plusTest() {
		input = "2.0+2";
		expected = "4,0";
		result = calc.calculate(input);
		assertEquals(expected, result);
		
		input = "2+2+3";
		expected = "7";
		result = calc.calculate(input);
		assertEquals(expected, result);
	}
	
	@Test
	public void minusTest() {
		input = "22,5-10";
		expected = "12,5";
		result = calc.calculate(input);
		assertEquals(expected, result);
		
		input = "1.0-11";
		expected = "-10,0";
		result = calc.calculate(input);
		assertEquals(expected, result);
	}
	
	@Test
	public void multiplyTest() {
		input = "10*20";
		expected = "200";
		result = calc.calculate(input);
		assertEquals(expected, result);
		
		input = "1,6 * 2 * 10";
		expected = "32,0";
		result = calc.calculate(input);
		assertEquals(expected, result);
	}
	
	@Test
	public void divideTest() {
		input = "1.0";
		expected = "-10,0";
		result = calc.calculate(input);
		assertEquals(expected, result);
	}
	
}
