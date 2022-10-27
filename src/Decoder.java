import java.util.ArrayList;

public class Decoder {
    Debug debug;
    Config config;

    public Decoder(Config config) {
        this.config = config;
        this.debug = new Debug(config.getDebugMode());
    }

    /**
     * @param listLineFromFile encode text for decoding
     * @return decoded string array String
     * @throws Exception
     */
    public ArrayList<String> Start(ArrayList<String> listLineFromFile) throws Exception {
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
}//decoder
