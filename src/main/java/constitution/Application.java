package constitution;

/**
 * Created by Dawid Tomasiewicz on 02.12.16.
 */
public class Application {
    public static void main(String[] args) {
        OptionsParser options = new OptionsParser(args);
        Constitution constitution = new ConstitutionParser().parseConstitution(options.getFilename());
        constitution.display(options.getOption(), options.getFirstNumber(), options.getSecondNumber());
    }
}
