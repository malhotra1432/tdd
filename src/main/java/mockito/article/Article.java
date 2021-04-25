package mockito.article;

public class Article {
    private String content;
    private Type type;

    public String getContent() {
        return content;
    }

    public Type getType() {
        return type;
    }

    public Article(String content, Type type) {
        this.content = content;
        this.type = type;
    }
}
