public class LogicProcessor {
    Debug debug;
    Config config;

    public LogicProcessor() {
    }

    public LogicProcessor(Debug debug, Config config) {
        this.debug = debug;
        this.config = config;
    }
    public String Start(){
        debug.out(config.getWorkMod().toString());
        String resoult = "";
        switch (config.getWorkMod()){
            case CODER:
                debug.out("Start coder section");
                break;
            case DECODER:
                debug.out("Start decoder section");
            break;
        }


     return resoult;
    }

}
