public class FileEncoderApp {
    private final Debug debug;
    private final Config config;
    private AbstractEncoder stringEncoder;
    private final FileProcessor fileProcessor;

    public FileEncoderApp(Config config) {
        this.config = config;
        this.debug = new Debug(config.getDebugMode());
        this.fileProcessor = new FileProcessor();
    }

    public void start() throws Exception {
        if (config.getStrBuildMod() == StringBuildMode.STRING) {
            stringEncoder = new StringEncoder(config);
        } else if (config.getStrBuildMod() == StringBuildMode.COMPARE) {
            stringEncoder = new ComparableStringBuilderEncoder(config);
        } else {
            stringEncoder = new StringBuilderEncoder(config);
        }
        FileProcessor fileProcessor = new FileProcessor();
        debug.out("Work mod before start: " + config.getWorkMod().toString() + " Debug Mod: " + config.getDebugMode() + " InputPath: " + config.getInputPath() + " PathToOut: " + config.getOutputPath());
        switch (config.getWorkMod()) {
            case ENCODE:
                startEncodeMethod();
                break;
            case DECODE:
                startDecodeMethod();
                break;
            case HELP:
                printHelp();
                System.exit(0);
                break;
            default:
                throw new IllegalArgumentException("Args add wrong, please recheck");
        }
    }

    private void printHelp() {
        System.out.println("Specifies that you want to Encode or Decode: \n" + "Example:\n" + "./encoderApp -coder ~\\IdeaProjects\\FileCoder\\Tests\\stdCoder.txt ~\\IdeaProjects\\FileCoder\\Tests\\stdCoderOUT.txt \n" + "./encoderApp -decode ~\\IdeaProjects\\FileCoder\\Tests\\stdDecoder.txt ~\\IdeaProjects\\FileCoder\\Tests\\stdDecoderOUT.txt \n" + "You can use StringBuild for work mod or use compare logic. Example:" + "./encoderApp -coder -strbuild ~\\IdeaProjects\\FileCoder\\Tests\\stdCoder.txt ~\\IdeaProjects\\FileCoder\\Tests\\stdCoderOUT.txt" + "./encoderApp -coder -strbuildcompare ~\\IdeaProjects\\FileCoder\\Tests\\stdCoder.txt ~\\IdeaProjects\\FileCoder\\Tests\\stdCoderOUT.txt" + "You can Debug enable: \n" + "./encoderApp -debug -coder ~\\IdeaProjects\\FileCoder\\Tests\\stdCoder.txt ~\\IdeaProjects\\FileCoder\\Tests\\stdCoderOUT.txt");
    }

    private void startDecodeMethod() throws Exception {
        String textDecoded = null;
        debug.out("Start DECODER section");
        String textForDecode = fileProcessor.readFromFile(config.getInputPath());
        textDecoded = stringEncoder.decode(textForDecode);
        debug.out("Get Decoded text: " + textDecoded);
        fileProcessor.writeToFile(config.getOutputPath(), true, textDecoded);
    }

    private void startEncodeMethod() throws Exception {
        String textCoded = null;
        debug.out("Start CODER section");
        String textForCoder = fileProcessor.readFromFile(config.getInputPath());
        textCoded = stringEncoder.encode(textForCoder);
        debug.out("Get encode text: " + textCoded);
        fileProcessor.writeToFile(config.getOutputPath(), true, textCoded);

    }
}
