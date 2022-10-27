public class Config {
    private DebugMode debugMode;
    private String path;
    private WorkMod workMod;
    private String pathTo;

    public Config(DebugMode debugMode, WorkMod workMod, String path, String pathTo) {
        this.debugMode = debugMode;
        this.workMod = workMod;
        this.path = path;
        this.pathTo = pathTo;

    }

    public DebugMode getDebugMode() {

        return debugMode;
    }

    public String getPath() {

        return path;
    }

    public String getPathTo() {

        return pathTo;
    }

    public WorkMod getWorkMod() {
        return workMod;
    }
}
