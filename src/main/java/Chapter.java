import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dawid Tomasiewicz on 02.12.16.
 */
public class Chapter {
    private String title;
    private Integer number;
    private List<Article> articles = new LinkedList<Article>();





    @Override
    public String toString(){
        return "I am a chapter. Update my toString method";
        //TODO update this method
    }
}
