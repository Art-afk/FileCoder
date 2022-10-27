import java.util.ArrayList;

public class StringEncoder {
    private final Debug debug;

    public StringEncoder(Config config) {
        this.debug = new Debug(config.getDebugMode());
    }

    /**
     * @return Encrypted String List Array
     */
    public ArrayList<String> coder(ArrayList<String> listLine) {
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
    }//coder

    /**
     * @param listLineFromFile encode text for decoding
     * @return decoded string array String
     */
    public ArrayList<String> decoder(ArrayList<String> listLineFromFile) {
        debug.out("Decoder get text to decoding: " + listLineFromFile);
        ArrayList<String> decryptedStringList = new ArrayList<>();
        for (String line : listLineFromFile) { // read line by line
            String decryptedString = "";
            char firstLetter = '\0';
            for (char letter : line.toCharArray()) { //convert line to char
                if (Character.isDigit(letter)) {
                    decryptedString = decryptedString + Character.toString(firstLetter).repeat(Character.getNumericValue(letter) - 1);
                } else {
                    decryptedString = decryptedString + letter;
                }
                firstLetter = letter;
            }//for word
            decryptedStringList.add(decryptedString + "\n");
        }//for listline
        return decryptedStringList;
    }//start

}//StringEncoder
