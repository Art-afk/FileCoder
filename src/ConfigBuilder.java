public class ConfigBuilder {

    public ConfigBuilder() {
    }

    public Config build(String[] args) {
        String outputPath = null;
        String inputPath = null;
        DebugMode debugMod = DebugMode.DISABLE;
        WorkMode workMode = null;
        for (int i = 0; i <= args.length - 1; i++) {
            switch (args[i]) {
                case "-help":
                    workMode = WorkMode.HELP;
                    break;
                case "-debug":
                    debugMod = DebugMode.ENABLE;
                    break;
                case "-coder":
                    inputPath = args[i + 1];
                    outputPath = args[i + 2];
                    workMode = WorkMode.CODER;
                    break;
                case "-decoder":
                    inputPath = args[i + 1];
                    outputPath = args[i + 2];
                    workMode = WorkMode.DECODER;
                    break;
                default:
                    System.out.println("something wrong");
            }
        }
        Config config = new Config(debugMod, workMode, inputPath, outputPath);
        return config;
    }
}
