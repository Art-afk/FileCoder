public class FileEncoderApp {
    Debug debug;
    Config config;


    public FileEncoderApp(Config config) {
        this.config = config;
        this.debug = new Debug(config.getDebugMode());
    }

    public void start() throws Exception {
        StringEncoder stringEncoder = new StringEncoder(config);
        FileProcessor fileProcessor = new FileProcessor();
        debug.out("Work mod before start: " + config.getWorkMod().toString() + " Debug Mod: " + config.getDebugMode() + " InputPath: " + config.getInputPath() + " PathToOut: " + config.getOutputPath());
        switch (config.getWorkMod()) {
            case ENCODE:
                debug.out("Start CODER section");
                String textForCoder = fileProcessor.readFromFile(config.getInputPath());
                String textCoded = stringEncoder.encode(textForCoder);
                debug.out("Get encode text: " + textCoded);
                fileProcessor.writeToFile(config.getOutputPath(), true, textCoded);

                break;
            case DECODE:
                debug.out("Start DECODER section");
                String textForDecode = fileProcessor.readFromFile(config.getInputPath());
                String textDecoded = stringEncoder.decode(textForDecode);
                debug.out("Get Decoded text: " + textDecoded);
                fileProcessor.writeToFile(config.getOutputPath(), true, textDecoded);
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
