import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dawid Tomasiewicz on 02.12.16.
 */
public class Chapter {
    private String title;
    private Integer number;
    private Integer startArticleNumber;
    private Integer endArticleNumber;

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


    public Integer getStartArticleNumber() {
        return startArticleNumber;
    }

    public void setStartArticleNumber(Integer startArticleNumber) {
        this.startArticleNumber = startArticleNumber;
    }

    public Integer getEndArticleNumber() {
        return endArticleNumber;
    }

    public void setEndArticleNumber(Integer endArticleNumber) {
        this.endArticleNumber = endArticleNumber;
    }

    public Chapter(Integer number, Integer startArticleNumber) {
        this.number = number;
        this.startArticleNumber = startArticleNumber;

    }


    @Override
    public String toString(){
        return "Rozdział " + this.number.toString() + "\n" + this.getTitle() + "\n";
    }
}
