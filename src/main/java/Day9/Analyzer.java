package Day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Analyzer {

    List<Integer[][]> listOfAllReadings;

    public Analyzer(Path path) throws IOException {
        listOfAllReadings = new ArrayList<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {

            String line;

            while ((line = bufferedReader.readLine()) != null) {

                String[] toBeConverted = line.split(" ");
                List<Integer> readings = Arrays.stream(toBeConverted)
                        .map(Integer::valueOf)
                        .toList();


                Integer[][] array2DReadingsWithDifferences = listTo2DArray(readings);


                listOfAllReadings.add(array2DReadingsWithDifferences);
            }

        }
    }

    public Integer[][] listTo2DArray(List<Integer> list) {
        int size = list.size();
        Integer[][] arrayToReturn = new Integer[size][size];


        for (int i = 0; i < list.size(); i++) {
            arrayToReturn[0][i] = list.get(i);
        }


        for (int row = 1; row < size; row++) {
            boolean allZeroes = true;
            for (int i = 0; i < size - row; i++) {
                if (arrayToReturn[row - 1][i] != null) {
                    arrayToReturn[row][i] = arrayToReturn[row - 1][i + 1] - arrayToReturn[row - 1][i];
                    if (arrayToReturn[row][i] != 0) {
                        allZeroes = false;
                    }

                }

            }
            if (allZeroes) {
                return arrayToReturn;

            }

        }
        return arrayToReturn;
    }


    public List<Integer[][]> getListOfAllReadings() {
        return listOfAllReadings;
    }
}

