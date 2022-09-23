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
        for (String line : listLineFromFile) {
            String decryptedString = "";
            for (char letter : line.toCharArray()) {
                if (Character.isDigit(letter)) {
                    for (int b = 1; b <= Character.getNumericValue(letter) - 1; b++) {
                        decryptedString = decryptedString + listLineFromFile.get(i).charAt(key + 1);
                    }
                } else {
                    decryptedString = decryptedString + listLineFromFile.get(i).charAt(key);
                }
            }//for word
            decryptedStringList.add(decryptedString + "\n");
        }//for listline
        return decryptedStringList;
    }//start
}//decoder
