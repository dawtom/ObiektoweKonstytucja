package constitution;

/**
 * Created by Dawid Tomasiewicz on 02.12.16.
 */
public class Application {
    public static void main(String[] args) {
        OptionsParser optionsParser = new OptionsParser(args);
        Constitution constitution = new ConstitutionParser().parseConstitution(optionsParser.getFilename());
        constitution.display(optionsParser.getOption(), optionsParser.getFirstNumber(), optionsParser.getSecondNumber());
    }
}
