package Day9;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Path path = Paths.get("src/main/java/Day9/Day9.txt");

        Analyzer analyzer = new Analyzer(path);

        List<Integer[][]> allReadings = analyzer.getListOfAllReadings();

        int tempNumber = 0;
        int totalCurrentRow = 0;
        int totalAllReadings = 0;


        //part1
        for (Integer[][] reading : allReadings) {
            for (Integer[] row : reading) {

                if (row != null) {
                    for (Integer num : row) {
                        if (num != null) {
                            tempNumber = num;
                        }
                    }
                    totalCurrentRow += tempNumber;
                }
            }

        }
        System.out.println("Big total: " + totalCurrentRow);

        for (Integer[][] reading : allReadings) {
            for (Integer[] row : reading) {
                if (row != null) {  // Check if row is not null
                    for (Integer num : row) {
                        if (num != null) {  // Check if element is not null
                            System.out.print(num + " ");
                        }
                    }
                    System.out.println();
                }
            }
            System.out.println("-----"); // To separate different readings
        }
        //part2

        int part2Total = 0;
        int difference = 0;
        int tempInt = 0;

        for (Integer[][] array : allReadings) {

            tempInt = 0;

            for (int i = array.length - 1; i >= 0; i--) {
                if (array[i] != null && array[i].length > 0 && array[i][0] != null) {
                    System.out.println("current number: " + array[i][0]);

                    difference = array[i][0] - tempInt;
                    tempInt = difference;

                }
            }
            System.out.println(difference);
            part2Total+= tempInt;
            System.out.println("---------");
        }

        System.out.println("Part2 total: " + part2Total);
        }


    }












