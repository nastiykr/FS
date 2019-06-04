
package junitdemo;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import demo.Calculator;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TimingExtension.class)
class JUnitJupiterCalculatorTests {

	private final Calculator calculator = new Calculator();

	@Test
	void add() {
		assertEquals(5, calculator.add(2, 3), () -> "2 + 3 = " + (2 + 3));
	}

	@Test
	void divideZero() {
		assertNotEquals(1, calculator.divide(0, 1));
	}

	@Test
	@DisplayName("Division by zero should throw an ArithmeticException")
	void divideByZero() {
		Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
		assertEquals("/ by zero", exception.getMessage());
	}

	@Test
	@DisplayName("Ensure Fibonacci computation is 'fast enough'")
	void fibonacci() {
		// f(42) - f(45) will likely take longer than 1000 ms.
		// assertTimeout(ofMillis(1000), () -> calculator.fibonacci(30));         	 // Тест упадёт после выполнения лямбда-выражения, если оно превысит 1000 мс
		assertTimeoutPreemptively(ofMillis(1000), () -> calculator.fibonacci(30));// Тест упадёт, как только время выполнения превысит 1000 мс
	}

}
