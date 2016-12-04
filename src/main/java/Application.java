import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Dawid Tomasiewicz on 02.12.16.
 */
public class Application {
    public static void main(String[] args) {
        Constitution constitution = new ConstitutionParser().parseConstitution("../Konstytucja.txt");
        System.out.println(constitution.toString());
    }
}
