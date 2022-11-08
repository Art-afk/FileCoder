public class CompareMethod {
    Debug debug;
    Config config;


    public CompareMethod(Config config) {
        this.config = config;
        this.debug = new Debug(config.getDebugMode());
    }


    public String compareEncodingMethod(String text) {
        AbstractEncoder stringEncoder = new StringEncoder(config);
        AbstractEncoder stringBuilderEncoder = new StringBuilderEncoder(config);
        String textOut;
        long start = System.currentTimeMillis();
        String textOutString = stringEncoder.encode(text);
        long end = System.currentTimeMillis();
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
            throw new IllegalArgumentException("Args add wrong, please recheck");
        }
        return textOut;
    }

    public String compareDecodingMethod(String text) {
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
