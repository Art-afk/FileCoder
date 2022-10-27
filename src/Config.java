public class Config {
    private final DebugMode debugMode;
    private final String inputPath;
    private final WorkMode workMode;
    private final String outputPath;

    public Config(DebugMode debugMode, WorkMode workMode, String inputPath, String outputPath) {
        this.debugMode = debugMode;
        this.workMode = workMode;
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

    public WorkMode getWorkMod() {
        return workMode;
    }
}
