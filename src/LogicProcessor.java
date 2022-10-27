import java.util.ArrayList;

public class LogicProcessor {
    Debug debug;
    Config config;


    public LogicProcessor(Config config) {
        this.config = config;
        this.debug = new Debug(config.getDebugMode());
    }

    public String Start() throws Exception {
        FileWork fileWork = new FileWork(config);
        debug.out("Work mod before start: " + config.getWorkMod().toString() + " Debug Mod: " + config.getDebugMode() + " Path: " + config.getPath() + " PathToOut: " + config.getPathTo());
        String resoult = "";
        switch (config.getWorkMod()) {
            case CODER:
                debug.out("Start CODER section");
                Coder coder = new Coder(config);
                ArrayList<String> coderList = fileWork.readFromFile(config.getPath());
                ArrayList<String> StringCoded = coder.Start(coderList);
                debug.out("Get encode text: " + StringCoded);
                fileWork.writeToFile(config.getPathTo(), false, ""); //clear file
                for (String coderText : StringCoded) {
                    fileWork.writeToFile(config.getPathTo(), true, coderText);
                }
                break;
            case DECODER:
                debug.out("Start DECODER section");
                Decoder decoder = new Decoder(config);
                ArrayList<String> deCoderList = fileWork.readFromFile(config.getPath());
                ArrayList<String> stringDecoded = decoder.Start(deCoderList);
                debug.out("Get Decode text: " + stringDecoded);
                fileWork.writeToFile(config.getPathTo(), false, "");
                for (String decoderText : stringDecoded) {
                    fileWork.writeToFile(config.getPathTo(), true, decoderText);
                }
                break;
        }


        return resoult;
    }

}
