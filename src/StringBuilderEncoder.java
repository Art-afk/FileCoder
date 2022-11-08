public class StringBuilderEncoder extends AbstractEncoder {

    private final Debug debug;

    public StringBuilderEncoder(Config config) {
        this.debug = new Debug(config.getDebugMode());
    }

    @Override
    public String encode(String stringFromFile) {
        StringBuilder sbAssembledString = new StringBuilder();
        StringBuilder sbEncryptedString = new StringBuilder();
        debug.out("StringBuild get text to coding: " + stringFromFile);
        char[] listLineChars = stringFromFile.toCharArray();
        int countRepeatWord = 1;
        char previousLetter = '\0';
        for (char letter : listLineChars) {
            if (previousLetter == letter) {
                countRepeatWord++;
            } else {
                if (countRepeatWord == 1) sbAssembledString.append(letter);
                else {
                    sbAssembledString.append(countRepeatWord).append(Character.toString(letter));
                    countRepeatWord = 1;
                }
                previousLetter = letter;
            }
        }//for
        if (countRepeatWord != 1) {
            sbAssembledString.append(countRepeatWord);
        }
        sbEncryptedString.append(sbEncryptedString).append(sbAssembledString);
        return sbEncryptedString.toString();    }

    @Override
    public String decode(String stringFromFile) {
        debug.out("stringBuilder get text to decoding: " + stringFromFile);
        StringBuilder sbDecryptedString = new StringBuilder();
        StringBuilder sbDecryptedStringFinish = new StringBuilder();

        char firstLetter = '\0';
        for (char letter : stringFromFile.toCharArray()) { //convert line to char
            if (Character.isDigit(letter)) {
                sbDecryptedString.append(Character.toString(firstLetter).repeat(Character.getNumericValue(letter) - 1));
            } else {
                sbDecryptedString.append(letter);
            }
            firstLetter = letter;
        }//for word
        sbDecryptedStringFinish.append(sbDecryptedString);
        return sbDecryptedStringFinish.toString();
    }
}
