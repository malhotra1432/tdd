package file;

import org.junit.jupiter.api.*;

import java.io.File;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReaderWriterRefactoredTest {

  private File writtenFile;
  private File tempFolder;

  @BeforeEach
  public void setUp() throws Exception {
    tempFolder = File.createTempFile("tmp", "file");
    tempFolder.delete();
    tempFolder.mkdir();
  }

  @AfterEach
  public void tearDown() throws Exception {
    assertTrue(writtenFile.delete());
    assertTrue(tempFolder.delete());
  }

  @Test
  public void readLinesItWrote() throws Exception {

    List<String> someLines = asList("Hey", "Hello", "Hola");
    writtenFile = ReaderWriter.write(tempFolder, "MyFile", someLines);

    List<String> readLines = ReaderWriter.read(writtenFile);

    assertEquals(someLines, readLines);
  }

  @Test
  public void readZeroLinesItWrote() throws Exception {

    List<String> someLines = asList("Hey", "Hello", "Hola");
    writtenFile = ReaderWriter.write(tempFolder, "MyFile", someLines);

    List<String> readLines = ReaderWriter.read(writtenFile);

    assertEquals(someLines, readLines);
  }
}
