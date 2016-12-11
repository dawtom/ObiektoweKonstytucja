package constitution;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Dawid Tomasiewicz on 11.12.16.
 */
public class OptionsParserTest {

    String[] args = {"../Konstytucja.txt","article","4"};
    OptionsParser optionsParser= new OptionsParser(args);
    @Test
    public void parseTestGetFirstNumber(){
        assertEquals(optionsParser.getFirstNumber(),new Integer(4));
    }
    @Test
    public void parseTestGetOption(){
        assertEquals(optionsParser.getOption(),"article");
    }


}