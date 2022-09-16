import java.util.ArrayList;

public class Coder {
    public String path;
    public String pathToOut;
    Debug debug = new Debug();
    FileWork fileWork = new FileWork();

    public void start() throws Exception {
       ArrayList <String> listLine = fileWork.readFromFile(path);
       if (debug.ON) System.out.println("*DEBUG* Coder get path: "+ listLine);

    }
}
