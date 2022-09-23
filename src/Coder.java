import java.util.ArrayList;

public class Coder {
    public String path;
    public String pathToOut;
    Debug debug = new Debug();
    FileWork fileWork = new FileWork();

    /**
     * @return Encrypted String List Array
     * @throws Exception
     */

    public ArrayList<String> start() throws Exception {
        ArrayList<String> listLine = fileWork.readFromFile(path);
        ArrayList<String> encryptedStringList = new ArrayList<>();
        if (debug.ON) debug.out("Coder get path: " + listLine);
        for (String key : listLine) {
            char[] word;
            String assembledString = "";
            word = key.toCharArray();
            int countRep = 1;
            char previousLetter = '\0';
            for (char letter : word) {
                if (previousLetter == letter) {
                    countRep++;
                } else {
                    if (countRep == 1) assembledString = assembledString + letter;
                    else {
                        assembledString = assembledString + countRep + letter;
                        countRep = 1;
                    }
                    previousLetter = letter;
                }
            }
            encryptedStringList.add(assembledString + "\n");
        }
        return encryptedStringList;
    }//start
}
