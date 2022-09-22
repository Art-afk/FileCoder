import java.util.ArrayList;

public class ArgsWorking {
Coder coder = new Coder();
Decoder decoder = new Decoder();
Debug debug = new Debug();
FileWork fileWork = new FileWork();


    public void workingWithArguments(String[] args) throws Exception {
        ArrayList<String> coderList = new ArrayList<>();
        for (int i =0; i<= args.length-1;i++) {
            //System.out.println(args[i]);
            switch (args[i]) {
                case "-coder":
                    coder.path = args[i+1];
                    coder.pathToOut = args[i+2];
                    if(debug.ON)System.out.println("*DEBUG* " + " first key: " + args[i] +" path: "+ args[i+1] + " out: " + args[i+2]);

                   coderList = coder.start();
                    fileWork.writeToFile(args[i+2],false,"");
                    for (String key: coderList
                         ) {
                        fileWork.writeToFile(args[i+2],true,key);
                    }

                    break;
                case "-decoder":
                    decoder.path = args[i+1];
                    decoder.pathToOut = args[i+2];
                    if(debug.ON)System.out.println("*DEBUG* " + " first key: " + args[i] +" path: "+ args[i+1] + " out: " + args[i+2]);
                    break;
            }
        }
    }
}
