/**
 * Debug enable/disable
 */
public class Debug {
    private DebugMode debugMode;

    public Debug(DebugMode debugMode){
        this.debugMode = debugMode;
    }
    /**
     * @param text sout debug test to console
     */
    public void out(String text){
        if(debugMode == DebugMode.ENABLE)
        System.out.println("*DEBUG* " + text);
    }
}
