import java.util.ArrayList;

public class ArgsWorking {
Coder coder = new Coder();
Decoder decoder = new Decoder();
Debug debug = new Debug();
FileWork fileWork = new FileWork();


    public void workingWithArguments(String[] args) throws Exception {

        for (int i =0; i<= args.length-1;i++) {
            //System.out.println(args[i]);
            switch (args[i]) {
                case "-coder":
                    ArrayList<String> coderList = new ArrayList<>();
                    coder.path = args[i+1];
                    coder.pathToOut = args[i+2];
                    if(debug.ON)System.out.println("*DEBUG* " + " first key: " + args[i] +" path: "+ args[i+1] + " out: " + args[i+2]);
                   coderList = coder.start();
                    fileWork.writeToFile(args[i+2],false,""); //clear file
                    for (String key: coderList
                         ) {
                        fileWork.writeToFile(args[i+2],true,key);
                    }
                    break;
                case "-decoder":
                    ArrayList<String> deCoderList = new ArrayList<>();
                    if(debug.ON)System.out.println("*DEBUG* " + " first key: " + args[i] +" path: "+ args[i+1] + " out: " + args[i+2]);
                    deCoderList = decoder.start(args[i+1]);
                    fileWork.writeToFile(args[i+2],false, "");
                    for (String key: deCoderList
                         ) {
                        fileWork.writeToFile(args[i+2],true, key);
                    }

                    break;
            }
        }
    }
}
