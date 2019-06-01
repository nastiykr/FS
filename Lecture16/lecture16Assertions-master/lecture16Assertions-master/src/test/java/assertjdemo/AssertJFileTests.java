
package assertjdemo;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.Charset;

import static org.assertj.core.api.Assertions.assertThat;

class AssertJFileTests {

	@Test
	void assertFile(){
		File xFile = writeFile("xFile", "The Truth Is Out There");

		assertThat(xFile)
				.exists()
				.isFile()
				.canRead()
				.canWrite();
	}

	private File writeFile(String fileName, String fileContent) {
		return writeFile(fileName, fileContent, Charset.defaultCharset());
	}

	private File writeFile(String fileName, String fileContent, Charset charset) {
		File file = new File("src/test/resources/" + fileName);

		try {
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset));
			out.write(fileContent);
			out.close();
		} catch (IOException e) {}
		return file;
	}
}
