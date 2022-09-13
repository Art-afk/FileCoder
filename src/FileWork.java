import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FileWork {
    /**
     * @param path to file
     * @param rewrite false\true to write or rewrite file
     * @param text text
     * @throws Exception
     */
    public static void writeToFile(String path,boolean rewrite, String text) throws Exception {
        try (FileOutputStream fos = new FileOutputStream(path, rewrite);
        ) {
            fos.write(text.getBytes(StandardCharsets.UTF_8));

        } catch (IIOException e) {
            System.out.println("Exception" + e);
        }
    }

    public static String readFromFile(String path) throws Exception{
        String text = "";
        try(FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis,StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(isr);
            ) {
            int i;
            while ((i = reader.read() != -1)) {
                text += Character.toString(i);
            }
            return text;
        }
    }
}
