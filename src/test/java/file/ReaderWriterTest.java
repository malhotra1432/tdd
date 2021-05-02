package file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReaderWriterTest {

  @Test
  public void readLinesItWords() throws Exception {
    File tempFolder = File.createTempFile("tmp", "file");
    tempFolder.delete();
    tempFolder.mkdir();

    List<String> someLines = asList("Hey", "Hello", "Hola");
    File writtenFile = ReaderWriter.write(tempFolder, "MyFile", someLines);

    List<String> readLines = ReaderWriter.read(writtenFile);

    assertEquals(someLines, readLines);

    assertTrue(writtenFile.delete());
    assertTrue(tempFolder.delete());
  }
}
