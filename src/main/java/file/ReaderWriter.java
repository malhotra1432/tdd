package file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderWriter {
  public static File write(File directory, String fileName, List<String> lines) {
    File file = new File(directory, fileName);
    try (FileWriter writer = new FileWriter(file)) {
      for (String line : lines) {
        writer.write(line + "\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return file;
  }

  public static List<String> read(File file) throws IOException {
    return Files.lines(file.toPath()).collect(Collectors.toList());
  }
}
