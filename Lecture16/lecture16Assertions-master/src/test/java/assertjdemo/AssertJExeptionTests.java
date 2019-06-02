
package assertjdemo;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AssertJExeptionTests {

	@Test
	void assertException(){
		assertThatThrownBy(() -> {
			List<String> list = Arrays.asList("String one", "String two");
			list.get(2);
		}).isInstanceOf(IndexOutOfBoundsException.class)
				.hasMessageContaining("2");
	}

	@Test
	void aa(){
		List<String> list = Arrays.asList("String one", "String two");
		list.get(2);
	}
}
