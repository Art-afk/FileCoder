public class Config {
    private final DebugMode debugMode;
    private final String path;
    private final WorkMod workMod;
    private final String pathTo;

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
