package constitution;

import java.util.LinkedList;
import java.util.List;


import static java.lang.System.exit;

/**
 * Created by Dawid Tomasiewicz on 02.12.16.
 */
public class OptionsParser {
    private String filename;
    private String option;

    public OptionsParser(String[] args) {
        this.parse(args);
    }

    private Integer firstNumber;
    private Integer secondNumber;

    public String getFilename() {
        return filename;
    }

    public String getOption() {
        return option;
    }

    public Integer getFirstNumber() {
        return firstNumber;
    }

    public Integer getSecondNumber() {
        return secondNumber;
    }

    private void parse(String[] args){
        List <String> result = new LinkedList<String>();
        String message = "\nCorrect arguments are: <filename> <whatToDisplay> <number> <number> \n" +
                "Second argument can be 'articles', 'article' or 'chapter'\n" +
                "Third argument is article/chapter number or first of articles to display\n" +
                "Fourth argument is needed when second is 'articles', it is a number of the last article to display";

        if (args.length == 0){
            System.out.println("No arguments" + message);
            exit(1);
        }

        if (args.length < 3){
            System.out.println("Too few arguments." + message);
            exit(1);
        }

        if (args.length > 4){
            System.out.println("Too many arguments. Maximum four will be used.");
        }

        this.filename = args[0];    //another function will check whether this is a filename
        this.option = args[1];      //
        if (args[1].equals("articles")){
            try{
                this.firstNumber = Integer.parseInt(args[2]);
            }
            catch (NumberFormatException ex){
                System.out.println("Invalid third argument. It should be a number");
                exit(1);
            }
            try{
                this.secondNumber = Integer.parseInt(args[3]);
                if (this.getFirstNumber() >= this.getSecondNumber()){
                    System.out.println("Invalid numbers. Second number should be greater than the first.");
                    exit(1);
                }
                if (this.getFirstNumber() < 1 || this.getSecondNumber() < 1 ||
                        this.getSecondNumber() > 243 || this.getFirstNumber() > 243){
                    System.out.println("constitution.Article numbers should be between 1 inclusive and 243 inclusive");
                    exit(1);
                }
            }
            catch (NumberFormatException ex){
                System.out.println("Invalid fourth argument. It should be a number");
                exit(1);
            }


        }
        else
            if (args[1].equals("article")) {
                try{
                    this.firstNumber = Integer.parseInt(args[2]);
                    if (this.firstNumber < 1 || this.firstNumber > 243){
                        System.out.println("constitution.Article number should be between 1 inclusive and 243 inclusive");
                        exit(1);
                    }
                }
                catch (NumberFormatException ex){
                    System.out.println("Invalid third argument. It should be a number");
                    exit(1);
                }
            }
            else
                if (args[1].equals("chapter")){
                    try{
                        this.firstNumber = Integer.parseInt(args[2]);
                        if (this.firstNumber < 1 || this.firstNumber > 13){
                            System.out.println("constitution.Chapter number should be between 1 inclusive and 13 inclusive");
                            exit(1);
                        }
                    }
                    catch (NumberFormatException ex){
                        System.out.println("Invalid third argument. It should be a number");
                        exit(1);
                    }

                }
            else {
                    System.out.println("Invalid second argument." + message);
                    exit(1);
                }


    }

}
