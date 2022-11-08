import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringEncoderTest {
    DebugMode debugMod = DebugMode.DISABLE;
    WorkMode workMode = WorkMode.ENCODE;
    StringBuildMode strBuild = StringBuildMode.DISABLE;
    String inputPath = null;
    String outputPath = null;
    Config config = new Config(debugMod, workMode,strBuild, inputPath, outputPath);
    StringEncoder stringEncoder = new StringEncoder(config);


    @Test
    public void encode() {
        assertEquals("a3bdfr3z2",stringEncoder.encode("aaabdfrrrzz"));

    }

    @Test
    @Ignore
    public void encodeBuild() {
        //assertEquals("a3bdfr3z2",stringEncoder.encodeBuild("aaabdfrrrzz"));
    }


    @Test
    @Ignore
    public void decode() {
        assertEquals("aaabdfrrrzz",stringEncoder.decode("a3bdfr3z2"));

    }

    @Test
    public void decodeBuild() {
        //assertEquals("aaabdfrrrzz",stringEncoder.decodeBuild("a3bdfr3z2"));

    }
}