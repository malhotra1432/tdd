package mockito.sender;

import mockito.article.Article;
import mockito.client.Channel;
import mockito.database.ArticleDataAccess;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static mockito.article.Type.*;
import static org.mockito.Mockito.*;

class ArticleDistributorTest {

  Channel sports = mock(Channel.class);
  Channel entertainment = mock(Channel.class);
  Channel other = mock(Channel.class);
  ArticleDataAccess articleDataAccess = mock(ArticleDataAccess.class);

  @Test
  void shouldReturnArticlesList() {

    ArticleDistributor articleDistributor =
        new ArticleDistributor(sports, entertainment, other, articleDataAccess);

    List<Article> articlesList =
        asList(
            new Article("This is dirty politics", SPORTS),
            new Article("I am the only Big Bull.", FINANCE));
    when(articleDataAccess.getTodaysArticles()).thenReturn(articlesList);

    articleDistributor.distributeTodays();

    verify(sports).accept(any());
    verify(other).accept(any());
    verify(entertainment, never()).accept(any());
  }
}
