public class FileEncoderApp {
    Debug debug;
    Config config;


    public FileEncoderApp(Config config) {
        this.config = config;
        this.debug = new Debug(config.getDebugMode());
    }

    public void start() throws Exception {
        AbstractEncoder stringEncoder = null;
        CompareMethod compareMethod = null;
        if (config.getStrBuildMod() == StringBuildMode.STRING) {
            stringEncoder = new StringEncoder(config);
        } else if (config.getStrBuildMod() == StringBuildMode.COMPARE) {
            compareMethod = new CompareMethod(config);
        } else {
            stringEncoder = new StringBuilderEncoder(config);
        }
        FileProcessor fileProcessor = new FileProcessor();
        debug.out("Work mod before start: " + config.getWorkMod().toString() + " Debug Mod: " + config.getDebugMode() + " InputPath: " + config.getInputPath() + " PathToOut: " + config.getOutputPath());
        switch (config.getWorkMod()) {
            case ENCODE:
                String textCoded = null;
                debug.out("Start CODER section");
                String textForCoder = fileProcessor.readFromFile(config.getInputPath());
                if (config.getStrBuildMod() == StringBuildMode.COMPARE) {
                    textCoded = compareMethod.compareEncodingMethod(textForCoder);
                } else {
                    textCoded = stringEncoder.encode(textForCoder);
                }
                debug.out("Get encode text: " + textCoded);
                fileProcessor.writeToFile(config.getOutputPath(), true, textCoded);
                break;
            case DECODE:
                String textDecoded = null;
                debug.out("Start DECODER section");
                String textForDecode = fileProcessor.readFromFile(config.getInputPath());
                if (config.getStrBuildMod() == StringBuildMode.COMPARE) {
                    textDecoded = compareMethod.compareDecodingMethod(textForDecode);
                } else {
                    textDecoded = stringEncoder.decode(textForDecode);
                }
                debug.out("Get Decoded text: " + textDecoded);
                fileProcessor.writeToFile(config.getOutputPath(), true, textDecoded);
                break;
            case HELP:
                printHelp();
                System.exit(0);
                break;
            default:
                throw new IllegalArgumentException("Args add wrong, please recheck");
        }
    }

    private void printHelp(){
     so
        System.out.println("Specifies that you want to Encode or Decode: \n" + "Example:\n" + "./encoderApp -coder ~\\IdeaProjects\\FileCoder\\Tests\\stdCoder.txt ~\\IdeaProjects\\FileCoder\\Tests\\stdCoderOUT.txt \n" + "./encoderApp -decode ~\\IdeaProjects\\FileCoder\\Tests\\stdDecoder.txt ~\\IdeaProjects\\FileCoder\\Tests\\stdDecoderOUT.txt \n" + "You can use StringBuild for work mod or use compare logic. Example:" + "./encoderApp -coder -strbuild ~\\IdeaProjects\\FileCoder\\Tests\\stdCoder.txt ~\\IdeaProjects\\FileCoder\\Tests\\stdCoderOUT.txt" + "./encoderApp -coder -strbuildcompare ~\\IdeaProjects\\FileCoder\\Tests\\stdCoder.txt ~\\IdeaProjects\\FileCoder\\Tests\\stdCoderOUT.txt" + "You can Debug enable: \n" + "./encoderApp -debug -coder ~\\IdeaProjects\\FileCoder\\Tests\\stdCoder.txt ~\\IdeaProjects\\FileCoder\\Tests\\stdCoderOUT.txt")
    }
}
