import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @author Ehtiram_Abdullayev on 2/12/2020
 * @project YAMLParser
 */
public class MainTest {
    static Map<String, String> map;

    @BeforeClass
    public static void setup() throws IOException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("input.yaml");
        map = new Parser().parse(inputStream);
    }

    @Test
    public void testCase1() throws IOException {
        Assert.assertEquals("3.3", map.get(".version"));
    }

    @Test
    public void testCase2() throws IOException {
        Assert.assertEquals("db_data:/var/lib/mysql", map.get(".services.db.volumes.0"));
    }

    @Test
    public void testCase3() throws IOException {
        Assert.assertEquals("db:3306", map.get(".services.wordpress.environment.WORDPRESS_DB_HOST"));
    }
}
