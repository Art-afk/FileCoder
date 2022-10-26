import java.util.ArrayList;

public class ConfigBuilder {

    public ConfigBuilder(){}



    public Config build(String[] args) throws Exception {
        String pathToOut = null;
        String path = null;
        DebugMode debugMod = DebugMode.DISABLE;
        WorkMod workMod = null;
        for (int i = 0; i <= args.length - 1; i++) {
            switch (args[i]) {
                case "-help":
                    System.out.println("Specifies that you want to Encode or Decode: \n" + "Example:\n" + "./encoderApp -coder ~\\IdeaProjects\\FileCoder\\Tests\\stdCoder.txt ~\\IdeaProjects\\FileCoder\\Tests\\stdCoderOUT.txt \n" + "./encoderApp -decode ~\\IdeaProjects\\FileCoder\\Tests\\stdDecoder.txt ~\\IdeaProjects\\FileCoder\\Tests\\stdDecoderOUT.txt \n" + "You can Debug enable: \n" + "./encoderApp -debug -coder ~\\IdeaProjects\\FileCoder\\Tests\\stdCoder.txt ~\\IdeaProjects\\FileCoder\\Tests\\stdCoderOUT.txt");
                    break;
                case "-debug":
                    debugMod = DebugMode.ENABLE;
                    break;
                case "-coder":
                    // ArrayList<String> coderList = new ArrayList<>();
                    path = args[i + 1];
                    pathToOut = args[i + 2];
                    workMod = WorkMod.CODER;
                    break;
                case "-decoder":
                    // ArrayList<String> deCoderList = new ArrayList<>();
                    path = args[i + 1];
                    pathToOut = args[i + 2];
                    workMod = WorkMod.DECODER;
                    //deCoderList = decoder.start(args[i + 1]);
                    //fileWork.writeToFile(args[i + 2], false, "");
                    // for (String key : deCoderList) {
                    //    fileWork.writeToFile(args[i + 2], true, key);
                    // }
                    // System.out.println("Finish");
                    break;
            }
        }
        Config config = new Config(debugMod, workMod, path, pathToOut);
        System.out.println("Debug Mod: " + debugMod + " WorkMod: " + workMod + " Path: "
                + path + " PathTo: " + pathToOut);

        return config;
    }
}
