
package junitdemo;

import org.junit.jupiter.api.Test;

import static demo.StringUtils.isPalindrome;
import static org.junit.jupiter.api.Assertions.*;

class JUnitJupiterStringTests {

	@Test
	void isPalindromeTest() {
		String palindrome = "madam";

		assertTrue(isPalindrome(palindrome));
	}

	@Test
	void isPalindromeTestNegative() {
		String palindrome = "Mister";

		assertFalse(isPalindrome(palindrome));
	}
}
