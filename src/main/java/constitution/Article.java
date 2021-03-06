package constitution;

/**
 * Created by Dawid Tomasiewicz on 02.12.16.
 */
public class Article {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Article(Integer number) {
        this.number = number;
        this.content = "";
    }

    private Integer number;


    @Override
    public String toString(){

        return "Art. " + this.number.toString() + "\n" + content;
    }

    public void addToContent(String tmpLine) {
        this.content = this.content.concat(tmpLine);
    }
}
