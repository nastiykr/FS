
package junitdemo;

import org.junit.jupiter.api.Test;

import demo.Person;

import static org.junit.jupiter.api.Assertions.*;

class JUnitJupiterPersonTests {

	@Test
	void getterMethods() {
		Person bart = new Person("Bart", "Simpson");

		assertAll("Person getter methods", //
				() -> assertEquals("Bart Simpson", bart.getFullName()), //
				() -> assertEquals("Bart ", bart.getFirstName()), //
				() -> assertEquals("Simpson ", bart.getLastName())//
		);
	}

	@Test
	void cloneTest(){
		Person homer = new Person("Homer", "Simpson");

		Person bart = homer.cloneWithdifferentName("Bart");

		assertNotNull(bart);
	}

	@Test
	void assertSameDemo(){
		Person homer = new Person("Homer", "Simpson");
		//Person homer2 = new Person("Homer", "Simpson");
		Person homer2 = homer;

		assertSame(homer, homer2);
	}

	@Test
	void assertEqualsObject(){
		Person homer = new Person("Homer", "Simpson");
		Person homer2 = new Person("Homer", "Simpson");

		assertEquals(homer, homer2);
	}

}
