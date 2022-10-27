import java.util.ArrayList;

public class ConfigBuilder {

    public ConfigBuilder() {
    }

    public Config build(String[] args) throws Exception {
        String outputPath = null;
        String inputPath = null;
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
                    inputPath = args[i + 1];
                    outputPath = args[i + 2];
                    workMod = WorkMod.CODER;
                    break;
                case "-decoder":
                    inputPath = args[i + 1];
                    outputPath = args[i + 2];
                    workMod = WorkMod.DECODER;
                    break;
                default:
                    System.out.println("something wrong");
            }
        }
        Config config = new Config(debugMod, workMod, inputPath, outputPath);
        return config;
    }
}
