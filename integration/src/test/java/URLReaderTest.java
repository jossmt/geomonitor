import com.jmt.geomonitor.integration.config.URLReader;
import org.apache.commons.lang3.Validate;
import org.junit.Test;

import java.io.*;
import java.util.Properties;

/**
 * Test for {@link URLReader}
 */
public class URLReaderTest {

    /** Test url. */
    private static final String testURL = "http://www.google.com";

    /**
     * Tests reader with random url
     */
    @Test
    public void testReader() {

        URLReader.readFile(testURL);

        final File file = new File(System.getProperty("user.dir") + "/src/test/resources/temp.html");

        Validate.isTrue(file.isFile());

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;
            while ((line = br.readLine()) != null) {

                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
