public class StringEncoder extends AbstractEncoder {
    private final Debug debug;

    public StringEncoder(Config config) {
        this.debug = new Debug(config.getDebugMode());
    }

    /**
     * @return encoded text
     * @stringFromFile put text for encode
     */

    public String encode(String stringFromFile) {
        String encryptedString = "";
        debug.out("Coder get text to coding: " + stringFromFile);
        char[] listLineChars = stringFromFile.toCharArray();
        String assembledString = "";
        int countRepeatWord = 1;
        char previousLetter = '\0';
        for (char letter : listLineChars) {
            if (previousLetter == letter) {
                countRepeatWord++;
            } else {
                if (countRepeatWord == 1) assembledString += letter;
                else {
                    assembledString += countRepeatWord + Character.toString(letter);
                    countRepeatWord = 1;
                }
                previousLetter = letter;
            }
        }//for
        if (countRepeatWord != 1) {
            assembledString += countRepeatWord;
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
        String decryptedString = "";
        char firstLetter = '\0';
        for (char letter : stringFromFile.toCharArray()) { //convert line to char
            if (Character.isDigit(letter)) {
                decryptedString = decryptedString + Character.toString(firstLetter).repeat(Character.getNumericValue(letter) - 1);
            } else {
                decryptedString = decryptedString + letter;
            }
            firstLetter = letter;
        }//for word
        decryptedStringFinish = decryptedStringFinish + decryptedString;
        return decryptedStringFinish;
    }//decode


}//StringEncoder
