import java.util.ArrayList;

public class Coder {
    /**
     * @return Encrypted String List Array
     * @throws Exception
     */
private Debug debug;
    public ArrayList<String> start(ArrayList<String> listLine) throws Exception {
       //
        ArrayList<String> encryptedStringList = new ArrayList<>();



         debug.out("Coder get path: " + listLine);
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
