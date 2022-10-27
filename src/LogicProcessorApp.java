public class LogicProcessorApp {
    Debug debug;
    Config config;


    public LogicProcessorApp(Config config) {
        this.config = config;
        this.debug = new Debug(config.getDebugMode());
    }

    public void start() throws Exception {
        StringEncoder stringEncoder = new StringEncoder(config);
        FileProcessor fileProcessor = new FileProcessor();
        debug.out("Work mod before start: " + config.getWorkMod().toString() + " Debug Mod: " + config.getDebugMode() + " InputPath: " + config.getInputPath() + " PathToOut: " + config.getOutputPath());
        switch (config.getWorkMod()) {
            case CODER:
                debug.out("Start CODER section");
                String coderList = fileProcessor.readFromFile(config.getInputPath());
                String StringCoded = stringEncoder.coder(coderList);
                debug.out("Get encode text: " + StringCoded);
                fileProcessor.ifTheFileIsNotCreatedWeCreateItIfExistsWeClearIt(config.getOutputPath());
                fileProcessor.writeToFile(config.getOutputPath(), true, StringCoded);

                break;
            case DECODER:
                debug.out("Start DECODER section");
                String deCoderList = fileProcessor.readFromFile(config.getInputPath());
                String stringDecoded = stringEncoder.decoder(deCoderList);
                debug.out("Get Decode text: " + stringDecoded);
                fileProcessor.ifTheFileIsNotCreatedWeCreateItIfExistsWeClearIt(config.getOutputPath());
                fileProcessor.writeToFile(config.getOutputPath(), true, stringDecoded);
                break;
            case HELP:
                System.out.println("Specifies that you want to Encode or Decode: \n" + "Example:\n" + "./encoderApp -coder ~\\IdeaProjects\\FileCoder\\Tests\\stdCoder.txt ~\\IdeaProjects\\FileCoder\\Tests\\stdCoderOUT.txt \n" + "./encoderApp -decode ~\\IdeaProjects\\FileCoder\\Tests\\stdDecoder.txt ~\\IdeaProjects\\FileCoder\\Tests\\stdDecoderOUT.txt \n" + "You can Debug enable: \n" + "./encoderApp -debug -coder ~\\IdeaProjects\\FileCoder\\Tests\\stdCoder.txt ~\\IdeaProjects\\FileCoder\\Tests\\stdCoderOUT.txt");
                System.exit(0);
                break;
            default:
                System.out.println("For show help add args: -help");
        }
    }
}
