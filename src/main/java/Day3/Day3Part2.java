package Day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Day3Part2 {

    double totalSum;


    public Day3Part2() throws IOException {
        this.totalSum = 0;
        Path path = Paths.get("src/main/java/Day3/Day3.txt");
        char[][] dataset = new char[140][140];
        String line;
        int lineCount = 0;


        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            while ((line = bufferedReader.readLine()) != null) {
                char[] tempArray = line.toCharArray();
                for (int i = 0; i < tempArray.length; i++) {
                    dataset[lineCount][i] = tempArray[i];
                }
                lineCount++;
            }
        }

        for (int i = 0; i < dataset.length; i++) {
            for (int j = 0; j < dataset[i].length; j++) {
               if (isGear(dataset[i][j])) {
                   System.out.println("++++++++++++++++++++++++++++");
                   Object[] toMultiply = gearAdjacentToNumber(dataset,i,j).toArray();
                   if (toMultiply.length == 2) {
                       totalSum += (Double)(toMultiply[0]) *(Double) (toMultiply[1]);
                   }

               }
            }
            System.out.println(totalSum);
        }
    }


    public HashSet<Double> gearAdjacentToNumber(char[][] dataset, int row, int col) {
        int[] rowOffsets = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colOffsets = {-1, 0, 1, -1, 1, -1, 0, 1};
        HashSet<Double> listOfNumbers = new HashSet<>();

        for (int k = 0; k < rowOffsets.length; k++) {
            System.out.println("------------");
            StringBuilder stringToParse = new StringBuilder();
            int adjRow = row + rowOffsets[k];
            int adjCol = col + colOffsets[k];
            if (adjRow >= 0 && adjRow < dataset.length && adjCol >= 0 && adjCol < dataset[adjRow].length) {
                System.out.println(dataset[adjRow][adjCol]);
                if (Character.isDigit(dataset[adjRow][adjCol])) {
                    if ((dataset[adjRow][adjCol - 1]) != '.' && !isSymbol((dataset[adjRow][adjCol - 1]))) {
                        if ((dataset[adjRow][adjCol - 2]) != '.' && !isSymbol((dataset[adjRow][adjCol - 2]))) {
                            stringToParse.append(dataset[adjRow][adjCol - 2]);
                        }
                        stringToParse.append(dataset[adjRow][adjCol - 1]);
                    }
                    stringToParse.append(dataset[adjRow][adjCol]);
                    if ((dataset[adjRow][adjCol + 1]) != '.' && !isSymbol((dataset[adjRow][adjCol + 1]))) {
                        stringToParse.append(dataset[adjRow][adjCol + 1]);
                        if ((dataset[adjRow][adjCol + 2]) != '.' && !isSymbol((dataset[adjRow][adjCol + 2]))) {
                            stringToParse.append(dataset[adjRow][adjCol + 2]);
                        }
                    }

                    System.out.println(stringToParse);
                }
                if (!stringToParse.toString().isEmpty())
                    listOfNumbers.add(Double.parseDouble(stringToParse.toString()));
            }

        }

        if (listOfNumbers.size() == 2) {
            return listOfNumbers;
        }
        return new HashSet<>();
    }

    public boolean isGear(char input) {
        return input == '*';

    }

    public boolean isSymbol(char input) {
        return input == '*' ||
                input == '/' ||
                input == '#' ||
                input == '&' ||
                input == '@' ||
                input == '$' ||
                input == '+' ||
                input == '-' ||
                input == '=' ||
                input == '%';
    }

    public static void main(String[] args) {
        try {
            new Day3Part2();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

