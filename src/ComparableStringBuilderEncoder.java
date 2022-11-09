public class ComparableStringBuilderEncoder extends AbstractEncoder {
    private final Debug debug;
    private final Config config;
    private AbstractEncoder stringEncoder;
    private AbstractEncoder stringBuilderEncoder;


    public ComparableStringBuilderEncoder(Config config) {
        this.config = config;
        this.debug = new Debug(config.getDebugMode());
        this.stringEncoder = new StringEncoder(config);
        this.stringBuilderEncoder = new StringBuilderEncoder(config);
    }

    public String encode(String text) {
        String textOut;
        long start = System.currentTimeMillis();
        debug.out("time start encode: " + start);
        String textOutString = stringEncoder.encode(text);
        long end = System.currentTimeMillis();
        debug.out("time stop encode: " + end);
        float sec = (end - start) / 1000F;
        System.out.println("Without StringBuilder: " + sec + " seconds");
        long start2 = System.currentTimeMillis();
        String textOutStringBuilder = stringBuilderEncoder.encode(text);
        long end2 = System.currentTimeMillis();
        sec = (end2 - start2) / 1000F;
        System.out.println("With use StringBuilder: " + sec + " seconds");
        if (textOutString.equals(textOutStringBuilder)) {
            textOut = textOutString;
        } else {
            throw new IllegalStateException("Args add wrong, please recheck");
        }
        return textOut;
    }

    public String decode(String text) {
        AbstractEncoder stringEncoder = new StringEncoder(config);
        AbstractEncoder stringBuilderEncoder = new StringBuilderEncoder(config);
        String textOut;
        long start = System.currentTimeMillis();
        String textOutString = stringEncoder.decode(text);
        long end = System.currentTimeMillis();
        float sec = (end - start) / 1000F;
        System.out.println("Without StringBuilder: " + sec + " seconds");

        long start2 = System.currentTimeMillis();
        String textOutStringBuilder = stringBuilderEncoder.decode(text);
        long end2 = System.currentTimeMillis();
        sec = (end2 - start2) / 1000F;
        System.out.println("With use StringBuilder: " + sec + " seconds");
        if (textOutString.equals(textOutStringBuilder)) {
            textOut = textOutString;
        } else {
            throw new IllegalArgumentException("Args add wrong, please recheck");
        }
        return textOut;
    }
}
