package constitution;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Dawid Tomasiewicz on 11.12.16.
 */
public class ArticleTest {
    private Article article = new Article(5);
    @Test
    public void addToContentTest() throws Exception {
        article.addToContent("First");
        assertEquals(article.getContent(),"First");
        article.addToContent("Second");
        assertEquals(article.getContent(),"FirstSecond");
    }

}