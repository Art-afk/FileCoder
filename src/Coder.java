import java.util.ArrayList;

public class Coder {
    public String path;
    public String pathToOut;
    Debug debug = new Debug();
    FileWork fileWork = new FileWork();

    public void start() throws Exception {
       ArrayList <String> listLine = fileWork.readFromFile(path);
       ArrayList<String> wordList = new ArrayList<>();
        ArrayList<String> coderList = new ArrayList<>();
       String lineCoderString ="";

       if (debug.ON) System.out.println("*DEBUG* Coder get path: "+ listLine);

       for(int i = 0; i<= listLine.size()-1; i++){
           char[] word = new char[listLine.size()];
           String s = "";
           word = listLine.get(i).toCharArray();
           int count = 1;
           for (int v = 0; v <= word.length-1; v++) {
               s = s + String.valueOf(word[v]);
               if (v < (word.length - 1)) {
                   if ((word[v] == word[v + 1])) {
                       count++;
                   } else if (count > 1) {
                //      if(debug.ON) System.out.println(count);
                       wordList.add(count +""+ word[v-1]);
                       s = s + String.valueOf(word[v]);
                       count = 1;
                   }
               }
               else {

                   wordList.add(count +""+ word[v-1]);
              //     if (debug.ON) System.out.println(count);

               }

           }

           if(debug.ON) System.out.println(wordList);
           if(debug.ON) System.out.println(" new word");
           System.out.println("hz : "+ s);


       }


    }
}
