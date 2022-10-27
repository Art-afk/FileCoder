public class Config {
    private final DebugMode debugMode;
    private final String inputPath;
    private final WorkMod workMod;
    private final String outputPath;

    public Config(DebugMode debugMode, WorkMod workMod, String inputPath, String outputPath) {
        this.debugMode = debugMode;
        this.workMod = workMod;
        this.inputPath = inputPath;
        this.outputPath = outputPath;

    }

    public DebugMode getDebugMode() {

        return debugMode;
    }

    public String getInputPath() {

        return inputPath;
    }

    public String getOutputPath() {

        return outputPath;
    }

    public WorkMod getWorkMod() {
        return workMod;
    }
}
