import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dawid Tomasiewicz on 02.12.16.
 */
public class Chapter {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    private Integer number;
    private List<Article> articles = new LinkedList<Article>();


    public Chapter(Integer number) {
        this.number = number;
    }


    @Override
    public String toString(){
        String result = new String();
        for (Article article :
                this.articles) {
            result += article.toString();
        }
        return "Rozdział " + this.number.toString() + "\n" + result;
    }
}
