public class ConfigBuilder {

    public ConfigBuilder() {
    }

    public Config build(String[] args) {
        String outputPath = null;
        String inputPath = null;
        DebugMode debugMod = DebugMode.DISABLE;
        WorkMode workMode = null;
        StringBuildMode strBuild = StringBuildMode.STRING;
        for (int i = 0; i <= args.length - 1; i++) {
            if (args[i].startsWith("-")) {
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
                        workMode = WorkMode.ENCODE;
                        break;
                    case "-decoder":
                        inputPath = args[i + 1];
                        outputPath = args[i + 2];
                        workMode = WorkMode.DECODE;
                        break;
                    case "-strbuild":
                        strBuild = StringBuildMode.STRING_BUILDER;
                        break;
                    case "-strbuildcompare":
                        strBuild = StringBuildMode.COMPARE;
                        break;
                    default:
                        throw new IllegalArgumentException("Args add wrong, recheck please");

                }
            }

        }
        Config config = new Config(debugMod, workMode, strBuild, inputPath, outputPath);
        return config;
    }
}
