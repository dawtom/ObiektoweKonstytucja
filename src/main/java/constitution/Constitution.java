package constitution;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dawid Tomasiewicz on 02.12.16.
 */
public class Constitution {
    public Constitution(List<Chapter> chapters, List<Article> articles) {
        this.chapters = chapters;
        this.articles = articles;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public List<Article> getArticles() {
        return articles;
    }

    private List <Chapter> chapters = new LinkedList<Chapter>();
    private List <Article> articles = new LinkedList<Article>();

    private void displayArticle(Integer articleNumber){
        System.out.println(this.getArticles().get(articleNumber - 1));
    }

    private String getArticlesToDisplay(Integer start, Integer stop){
        String result = "";
        List <Article> articlesSublist = this.getArticles().subList(start - 1, stop );
        for (Article article :
                articlesSublist) {
            result += article.toString();
        }
        return result;
    }

    private void displayArticles(Integer start, Integer stop){
        System.out.println(getArticlesToDisplay(start, stop));
    }

    private void displayChapter(Integer chapterNumber){
        Chapter tmpChapter = this.getChapters().get(chapterNumber - 1);
        System.out.println(tmpChapter.toString() +
                getArticlesToDisplay(tmpChapter.getStartArticleNumber(),tmpChapter.getEndArticleNumber()));
    }

    @Override
    public String toString(){
        String result = "";
        for (Article article:
             articles) {
            result += article.toString() + "\n";
        }
        return result;
    }

    public void display(String option, Integer firstNumber, Integer secondNumber) {
        if (option.equals("articles")){displayArticles(firstNumber,secondNumber);}
        if (option.equals("article")){displayArticle(firstNumber);}
        if (option.equals("chapter")){displayChapter(firstNumber);}

    }
}
