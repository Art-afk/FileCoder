public class StringEncoder {
    private final Debug debug;

    public StringEncoder(Config config) {
        this.debug = new Debug(config.getDebugMode());
    }

    /**
     * @return Encrypted String List Array
     */
    public String encode(String listLine) {
        String encryptedString = "";
        debug.out("Coder get text to coding: " + listLine);
        char[] listLineChars = listLine.toCharArray();
        String assembledString = "";
        int countRep = 1;
        char previousLetter = '\0';
        for (char letter : listLineChars) {
            if (previousLetter == letter) {
                countRep++;
            } else {
                if (countRep == 1) assembledString += letter;
                else {
                    assembledString += countRep + Character.toString(letter);
                    countRep = 1;
                }
                previousLetter = letter;
            }
        }
        encryptedString = encryptedString + assembledString;

        return encryptedString;
    }//coder

    /**
     * @param stringFromFile encode text for decoding
     * @return decoded string array String
     */
    public String decode(String stringFromFile) {
        debug.out("Decoder get text to decoding: " + stringFromFile);
        String decryptedStringFinish = "";
        String line = stringFromFile;
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
        decryptedStringFinish = decryptedStringFinish + decryptedString;
        return decryptedStringFinish;
    }//start

}//StringEncoder
