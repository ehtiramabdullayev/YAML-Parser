import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @author Ehtiram_Abdullayev on 2/12/2020
 * @project YAMLParser
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        InputStream inputStream = classLoader.getResourceAsStream("input.yaml");
        Map<String, String> s = new Parser().parse(inputStream);

        System.out.println(s);

    }




}
