package constitution;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by Dawid Tomasiewicz on 02.12.16.
 */
public class ConstitutionParser {

    private Constitution tmpConstitution = new Constitution(new LinkedList<Chapter>(), new LinkedList<Article>());
    public Constitution parseConstitution(String inputFileName){
        FileReader fileReader = null;
        String tmpLine = new String();
        Integer tmpChapterNumber = 1;
        Integer tmpArticleNumber = 0;

        try {
            fileReader = new FileReader(inputFileName);
        } catch (FileNotFoundException e) {
            System.out.println("Error while opening file");
            System.exit(1);
        }
        BufferedReader bfr = new BufferedReader(fileReader);

        try {
            while((tmpLine = bfr.readLine()) != null && !tmpLine.startsWith("Rozdział ")){
                //omit everything while it is not a first chapter
            }
            tmpConstitution.getChapters().add(new Chapter(tmpChapterNumber, tmpArticleNumber + 1));
            if ((tmpLine = bfr.readLine()) != null){
                tmpConstitution.getChapters().get(tmpChapterNumber - 1).setTitle(tmpLine);
            }
            while ((tmpLine = bfr.readLine()) != null) {
                if (tmpLine.equals("©Kancelaria Sejmu")) {
                    tmpLine = bfr.readLine();
                    //I am sure, that under "©Kancelaria Sejmu" there is a date, so it's not null and it is useless
                }
                else
                    if (tmpLine.startsWith("Rozdział ")){
                        tmpConstitution.finishChapter(tmpChapterNumber,tmpArticleNumber);
                        tmpChapterNumber++;
                        tmpConstitution.addNewChapter(bfr, tmpChapterNumber,tmpArticleNumber);
                    }
                    else
                        if (tmpLine.startsWith("Art. ")){
                            tmpArticleNumber++;
                            tmpConstitution.getArticles().add(new Article(tmpArticleNumber));
                        }
                        else
                        {
                            if (tmpLine.endsWith("-")){
                                tmpLine = tmpLine.substring(0, tmpLine.length()-1);
                                tmpConstitution.getArticles().get(tmpArticleNumber - 1)
                                        .setContent(tmpConstitution.getArticles().get(tmpArticleNumber - 1).
                                                getContent().concat(tmpLine));
                                //add tmpLine to current article (content += tmpLine)
                            }
                            else
                            {
                                if (!tmpLine.toUpperCase().equals(tmpLine)){
                                    tmpConstitution.getArticles().get(tmpArticleNumber - 1)
                                            .setContent(tmpConstitution.getArticles().get(tmpArticleNumber - 1).
                                                    getContent().concat(tmpLine + "\n"));
                                }
                            }


                        }
                tmpConstitution.getChapters().get(tmpChapterNumber - 1).setEndArticleNumber(tmpArticleNumber);
            }

        } catch (IOException e) {
            System.out.println("BŁĄD ODCZYTU Z PLIKU!");
            System.exit(2);
        }

        return tmpConstitution;
    }


}
