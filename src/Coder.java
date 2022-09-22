import java.util.ArrayList;

public class Coder {
    public String path;
    public String pathToOut;
    Debug debug = new Debug();
    FileWork fileWork = new FileWork();

    /**
     *
     * @return Encrypted String List Array
     * @throws Exception
     */

    public ArrayList<String> start() throws Exception {
        ArrayList<String> listLine = fileWork.readFromFile(path);
        ArrayList<String> encryptedStringList = new ArrayList<>();
        if (debug.ON) System.out.println("*DEBUG* Coder get path: " + listLine);
        for (int i = 0; i <= listLine.size() - 1; i++) {
            char[] word = new char[listLine.size()];
            String assembledString = "";
            word = listLine.get(i).toCharArray();
            int countRep = 1; // я бы на самом деле взял бы тут цифру 0 и прибавлял везде 2 а не 1, но что-то пошло не так)
            for (int v = 0; v <= word.length - 1; v++) {
                if (v < (word.length - 1)) {
                    if ((word[v] == word[v + 1])) {
                        countRep++;
                    } else if (countRep > 1) {
                        assembledString = assembledString + countRep + String.valueOf(word[v]);
                        countRep = 1;
                    } else assembledString = assembledString + String.valueOf(word[v]);
                } else {
                    assembledString = assembledString + countRep + String.valueOf(word[v]);
                }
            }
            encryptedStringList.add(assembledString + "\n");
        }
        return encryptedStringList;
    }//start
}
