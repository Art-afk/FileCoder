import java.util.ArrayList;

public class ConfigBuilder {

    public ConfigBuilder() {
    }

    public Config build(String[] args) throws Exception {
        String pathToOut = null;
        String path = null;
        DebugMode debugMod = DebugMode.DISABLE;
        WorkMod workMod = null;
        for (int i = 0; i <= args.length - 1; i++) {
            switch (args[i]) {
                case "-help":
                    workMod = WorkMod.HELP;
                    break;
                case "-debug":
                    debugMod = DebugMode.ENABLE;
                    break;
                case "-coder":
                    path = args[i + 1];
                    pathToOut = args[i + 2];
                    workMod = WorkMod.CODER;
                    break;
                case "-decoder":
                    path = args[i + 1];
                    pathToOut = args[i + 2];
                    workMod = WorkMod.DECODER;
                    break;
                default:
                    System.out.println("something wrong");
            }
        }
        Config config = new Config(debugMod, workMod, path, pathToOut);
        return config;
    }
}
