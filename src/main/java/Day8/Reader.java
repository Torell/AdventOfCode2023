package Day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Reader {

    private List<Integer> instructions;

    private TreeMap<String, String[]> map;

    public Reader(String path) {
        instructions = new ArrayList<>();
        map = new TreeMap<>();
        Path pathToData = Paths.get(path);

        try(BufferedReader bufferedReader = Files.newBufferedReader(pathToData)) {
            String line;

            line = bufferedReader.readLine();
            line += bufferedReader.readLine();
            System.out.println(line);

            for (char c : line.toCharArray()) {
                if (c == 'L') {
                    instructions.add(0);
                } else {
                    instructions.add(1);
                }
            }

            while ((line = bufferedReader.readLine()) != null) {
                String pureString = line.replaceAll("=", " ").
                        replaceAll("\\(", " ")
                        .replaceAll("\\)", " ")
                        .replaceAll(",", " ");
                String[] splitIntoThreeParts = pureString.split("\\s+");

                map.put(splitIntoThreeParts[0].trim(), new String[]{splitIntoThreeParts[1].trim(), splitIntoThreeParts[2].trim()});
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Integer> getInstructions() {
        return instructions;
    }

    public TreeMap<String, String[]> getMap() {
        return map;
    }
}
