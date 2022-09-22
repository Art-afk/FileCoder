import java.util.ArrayList;

public class Decoder {
      FileWork fileWork = new FileWork();
    public ArrayList<String> start(String path) throws Exception {
        //3a2sear3sr2ma
        //aaassearsssrmm
        //aaassearsssrmm
      final ArrayList<String> listLineFromFile = fileWork.readFromFile(path);
        ArrayList<String> decryptedStringList = new ArrayList<>();
        for (int i = 0; i<= listLineFromFile.size() -1; i++){
            String decryptedString = "";
            for (int key = 0; key <= listLineFromFile.get(i).length() - 1; key++) {
                if(Character.isDigit(listLineFromFile.get(i).charAt(key))){
                    for (int b = 1; b <= Character.getNumericValue(listLineFromFile.get(i).charAt(key)) -1 ;b++){
                        decryptedString = decryptedString + listLineFromFile.get(i).charAt(key+1);
                    }
                }else{
                    decryptedString = decryptedString + listLineFromFile.get(i).charAt(key);
                }
            }//for word
            decryptedStringList.add(decryptedString + "\n");
        }//for listline
        return decryptedStringList;
    }//start


}//decoder
