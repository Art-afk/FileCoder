import java.util.ArrayList;

public class Coder {
    /**
     * @return Encrypted String List Array
     * @throws Exception
     */
    private final Debug debug;
    private final Config config;

    public Coder(Config config) {
        this.config = config;
        this.debug = new Debug(config.getDebugMode());
    }

    public ArrayList<String> Start(ArrayList<String> listLine) throws Exception {
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
