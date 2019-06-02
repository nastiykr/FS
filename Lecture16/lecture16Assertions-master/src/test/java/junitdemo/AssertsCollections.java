
package junitdemo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class AssertsCollections {

	@Test
	void assertArrayEqualsDemo() {
		//Test will pass
		assertArrayEquals(new int[]{1,2,3}, new int[]{1,2,3}, "Array Equal Test");

		//Test will fail because element order is different
		//assertArrayEquals(new int[]{1,2,3}, new int[]{1,3,2}, "Array Equal Test");

		//Test will fail because number of elements are different
		//assertArrayEquals(new int[]{1,2,3}, new int[]{1,2,3,4}, "Array Equal Test");
	}

	@Test
	void assertIterableEqualsDemo()
	{
		Iterable<Integer> listOne = new ArrayList<>(Arrays.asList(1,2,3,4));
		Iterable<Integer> listTwo = new ArrayList<>(Arrays.asList(1,2,3,4));
		Iterable<Integer> listThree = new ArrayList<>(Arrays.asList(1,2,3));
		Iterable<Integer> listFour = new ArrayList<>(Arrays.asList(1,2,4,3));
		Iterable<Integer> listFive = new HashSet<>(Arrays.asList(1,2,4,3));
		Iterable<Integer> listSix = new HashSet<>(Arrays.asList(2,1,4,3));
		assertIterableEquals(listFive, listSix);

		//Test will pass
		//assertIterableEquals(listOne, listTwo);

		//Test will fail
		//assertIterableEquals(listOne, listThree);

		//Test will fail
		//assertIterableEquals(listOne, listFour);
	}
}
