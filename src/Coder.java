import java.util.ArrayList;

public class Coder {

    private final Debug debug;

    public Coder(Config config) {
        this.debug = new Debug(config.getDebugMode());
    }
    /**
     * @return Encrypted String List Array
     */
    public ArrayList<String> start(ArrayList<String> listLine){
        //
        ArrayList<String> encryptedStringList = new ArrayList<>();

        debug.out("Coder get text to coding: " + listLine);
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
                    if (countRep == 1) assembledString += letter;
                    else {
                        assembledString += countRep + letter;
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
