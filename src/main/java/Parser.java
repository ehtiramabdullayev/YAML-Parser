import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Ehtiram_Abdullayev on 2/12/2020
 * @project YAMLParser
 */
class Parser {

    Map<String, String> parse(InputStream inputStream) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        Map<String, String> vals = new HashMap<>();
        List<String> parents = new LinkedList<>();
        String line;
        while (((line = br.readLine()) != null)) {
            if (line.trim().isEmpty()) {
                continue;
            }
            String[] parts = line.split(":", 2);

            String name = parts[0].trim();

            int level = 0;
            while (line.charAt(level) == ' ') {
                level = level + 2;
            }
            level = level / 2;

            while (parents.size() <= level) {
                parents.add("");
            }
            if (level == 0) {
                name = "." + name;
            } else {
                name = parents.get(level - 1) + "." + name;
            }
            String value = parts[1].trim();
            if (!value.isEmpty()) {
                vals.put(name, value);
            }
            parents.add(level, name);
        }

        return vals;
    }
}