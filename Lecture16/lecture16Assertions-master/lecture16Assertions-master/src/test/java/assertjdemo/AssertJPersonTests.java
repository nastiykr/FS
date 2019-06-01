
package assertjdemo;

import demo.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static demo.StringUtils.isPalindrome;
import static org.assertj.core.api.Assertions.assertThat;

class AssertJPersonTests {

	@Test
	void assertEqualsObject(){
		Person homer = new Person("Homer", "Simpson");
		Person homer2 = new Person("Homer", "Simpson");

		//assertEquals(homer, homer2);
		//assertThat(homer).isEqualTo(homer2);
		assertThat(homer).isEqualToComparingFieldByFieldRecursively(homer2);
	}

	@Test
	void assertIsTrue(){
		String palindrome = "madam";

		assertThat(isPalindrome(palindrome)).isTrue();
	}

	@Test
	void assertMessage(){
		String expected = "Bart Simpson";
		Person bart = new Person("Bart", "Simpson");

		assertThat(bart.getFullName())
				.as("Bart full name should be %s", expected)
				.isEqualTo(expected);
	}

	@Test
	void assertIterables(){
		List<String> list = Arrays.asList();
/*

		assertThat(list).contains("1");
		assertThat(list).startsWith("1");

		assertThat(list)
				.isNotEmpty()
				.contains("1")
				.doesNotContainNull()
				.containsSequence("2", "3")
				.hasSize(3);
*/

		List<String> list2 = Arrays.asList();

		//assertThat(list).isEqualTo(list2);

		assertThat(list).containsAll(list2);
	}

	@Test
	void assertCharacter(){
		char someCharacter = 'b';

		assertThat(someCharacter)
				.isNotEqualTo('a')
				.inUnicode()
				.isGreaterThanOrEqualTo('b')
				.isLowerCase();
	}

	@Test
	void assertDate(){
		Date today = new Date();

		assertThat(today).isBeforeYear(2020).isAfterYear(2016);
	}
}
