package Day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day3Part2 {

    double totalSum;

    double tempNumber1;
    double tempNumber2;

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

        for (int i = 0; i < dataset.length ; i++) {
            System.out.println("------------");
            for (int j = 0; j < dataset[i].length; j++) {
                if (dataset[i][j] == '.') {
                    continue;
                }
                if (isGear(dataset[i][j])) {
                    List<Double> analyzeNumber = gearAdjacentToNumber(dataset, i, j);
                    for (double number: analyzeNumber) {
                        System.out.println(number);
                    }
                }

                }
            }
            
        }





    public List<Double> gearAdjacentToNumber(char[][] dataset, int row, int col) {
        char[][] arrayToReturn = new char[3][7];
        // int[] rowOffsets = {-1,-1,-1,-1,-1,-1,-1, 0, 0, 0, 0, 0, 0, 1, 1, 1,1,1,1,1};
        //int[] colOffsets = {-3,-2,-1, 0, 1, 2, 3,-3,-2,-1, 1, 2, 3,-3,-2,-1,0,1,2,3};
        int[] rowOffsets = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colOffsets = {-1, 0, 1, -1, 1, -1, 0, 1};
        List<Double> listOfNumbers = new ArrayList<>();
        int counter;

        for (int k = 0; k < rowOffsets.length - 1; k++) {
            StringBuilder stringToParse = new StringBuilder();
            int adjRow = row + rowOffsets[k];
            int adjCol = col + colOffsets[k];
            if (adjRow >= 0 && adjRow < dataset.length && adjCol >= 0 && adjCol < dataset[adjRow].length) {
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
                    }
                    if ((dataset[adjRow][adjCol + 2]) != '.' && !isSymbol((dataset[adjRow][adjCol + 2]))) {
                        stringToParse.append(dataset[adjRow][adjCol + 2]);
                    }

                }
                if (!stringToParse.toString().isEmpty())
                    listOfNumbers.add(Double.parseDouble(stringToParse.toString()));
            }

        }

        /*if (Character.isDigit((dataset[adjRow][adjCol+1]))) {
            k++;
            if (Character.isDigit((dataset[adjRow][adjCol+2]))) {
                k++;
            }
        }

         */
        if (listOfNumbers.size() == 2) {
            return listOfNumbers;
        }
        return new ArrayList<>();
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

