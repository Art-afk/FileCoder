import java.util.ArrayList;

public class Coder {
    public String path;
    public String pathToOut;
    FileWork fileWork = new FileWork();

    public void start() throws Exception {
       ArrayList <String> listLine = fileWork.readFromFile(path);

    }
}
