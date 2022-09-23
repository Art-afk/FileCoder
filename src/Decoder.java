import java.util.ArrayList;

public class Decoder {
    FileWork fileWork = new FileWork();

    /**
     * @param path to the file to be decoded
     * @return decoded string array String
     * @throws Exception
     */
    public ArrayList<String> start(String path) throws Exception {
        final ArrayList<String> listLineFromFile = fileWork.readFromFile(path);
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
