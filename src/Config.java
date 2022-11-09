public class Config {
    private final DebugMode debugMode;
    private final String inputPath;
    private final WorkMode workMode;
    private final String outputPath;
    private final StringBuildMode strBuild;

    public Config(DebugMode debugMode, WorkMode workMode, StringBuildMode strBuild, String inputPath, String outputPath) {
        this.debugMode = debugMode;
        this.workMode = workMode;
        this.inputPath = inputPath;
        this.outputPath = outputPath;
        this.strBuild = strBuild;

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

    public StringBuildMode getStrBuildMod() {
        return strBuild;
    }
}
