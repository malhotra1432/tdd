import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class WordCounter {
  private final Set<String> wordsINString = new HashSet<String>();

  public void add(String sentence) {
    if (!sentence.isEmpty()) {
      wordsINString.addAll(
          Arrays.asList(sentence.toLowerCase(Locale.ROOT).trim().split("[.,!; ]+")));
    }
  }

  public int getUniqueWordsCount() {
    return wordsINString.size();
  }
}
