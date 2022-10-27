import javax.imageio.IIOException;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class FileProcessor {



    /**
     * @param outputPath to file
     * @param rewrite    false\true to write or rewrite file
     * @param text       text
     * @throws Exception return error is can't write to file
     */
    public void writeToFile(String outputPath, boolean rewrite, String text) throws Exception {
        try (FileOutputStream fos = new FileOutputStream(outputPath, rewrite)) {
            fos.write(text.getBytes(StandardCharsets.UTF_8));
        } catch (IIOException e) {
            System.out.println("Exception" + e);
        }
    }

    /**
     * @param inputPath to file to be read
     * @return array read line by line reading
     * @throws Exception return error if can't read from file
     */
    public ArrayList<String> readFromFile(String inputPath) throws Exception {
        ArrayList<String> listOfLines = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(inputPath); InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8); BufferedReader reader = new BufferedReader(isr)) {
           String line = reader.readLine();
            while (line != null) {
                listOfLines.add(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IIOException e) {
            e.printStackTrace();
        }
        return listOfLines;
    }
}
