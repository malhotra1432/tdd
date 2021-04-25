package mockito.sender;

import mockito.article.Article;
import mockito.client.Channel;
import mockito.database.ArticleDataAccess;

public class ArticleDistributor {
  private final Channel sports;
  private final Channel entertainment;
  private final Channel other;
  private final ArticleDataAccess dataAccess;

  public ArticleDistributor(
      Channel sports, Channel entertainment, Channel other, ArticleDataAccess dataAccess) {
    this.sports = sports;
    this.entertainment = entertainment;
    this.other = other;
    this.dataAccess = dataAccess;
  }

  public void distributeTodays() {
    for (Article article : dataAccess.getTodaysArticles()) {
      switch (article.getType()) {
        case SPORTS:
          sports.accept(article);
          break;
        case ENTERTAINMENT:
          entertainment.accept(article);
          break;
        default:
          other.accept(article);
          break;
      }
    }
  }
}
