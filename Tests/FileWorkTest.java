import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FileWorkTest {

    @Test
    public void writeToFile() {
    }

    @Test
    public void readFromFile()throws Exception {
        ArrayList<String> listOfLines = new ArrayList<>();
    //    listOfLines = FileWork.readFromFile("c:\\Users\\Zar\\IdeaProjects\\FileEncoderApp\\Tests\\stdCoder.txt");
        for (String list: listOfLines
             ) {
            System.out.println(list);

        }
    }


}