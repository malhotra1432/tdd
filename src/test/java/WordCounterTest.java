import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordCounterTest {
  private final WordCounter counter = new WordCounter();

  @Test
  void shouldCheckIfGivenWordIsEmpty() {
    counter.add("");

    assertEquals(0, counter.getUniqueWordsCount());
  }

  @Test
  void shouldCountSingleWord() {
    counter.add("Hello");

    assertEquals(1, counter.getUniqueWordsCount());
  }

  @Test
  void shouldCountMultipleWords() {
    counter.add("Hello");
    counter.add("World");

    assertEquals(2, counter.getUniqueWordsCount());
  }

  @Test
  void shouldCountMultipleWordsInASingleStringByIgnoringSpaces() {
    counter.add("Hello World");
    counter.add("Hello World! I am dead!");

    assertEquals(5, counter.getUniqueWordsCount());
  }

  @Test
  void shouldTrimAndCountMultipleWordsInASingleStringByIgnoringSpaces() {
    counter.add("   Hello     World");
    counter.add("Hello     World! I am     dead!");

    assertEquals(5, counter.getUniqueWordsCount());
  }

  @Test
  void shouldCountRepeatedWordsOnlyOnce() {
    counter.add("Hello Hello Hello");

    assertEquals(1, counter.getUniqueWordsCount());
  }

  @Test
  void shouldCountMixedCaseWordsOnlyOnce() {
    counter.add("Hello HELLO hello HeLLo");

    assertEquals(1, counter.getUniqueWordsCount());
  }

  @Test
  void shouldIgnorePunctuationInString() {
    counter.add("Hello. ");
    counter.add("Hello ");
    counter.add("Hey; ");
    counter.add("Hey ");
    counter.add("Hola ");
    counter.add("Hola! ");

    assertEquals(3, counter.getUniqueWordsCount());
  }
}
