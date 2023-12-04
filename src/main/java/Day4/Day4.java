package Day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class Day4 {

    public static void main(String[] args) {

        Path path = Paths.get("src/main/java/Day4/Day4.txt");
        String line;
        double totalSum = 0;

        try(BufferedReader bufferedReader = Files.newBufferedReader(path)) {

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("----------------------------");
                HashMap<Double, Double> mapOfNumbers = new HashMap<>();
                String matchNameRemoved = line.substring(line.indexOf(":")+1);
                String[] allNumber = matchNameRemoved.split("\\|");
                String[] winNumber = allNumber[0].split(" ");
                String[] elfsNumber = allNumber[1].split(" ");
                double matchingCards = 0;

                for (String entry: winNumber) {
                    if (!entry.isEmpty()) {
                        mapOfNumbers.put(Double.parseDouble(entry), 0.0);
                        System.out.println("winning number: " + entry);
                    }
                }

                for (String entry: elfsNumber) {
                    if (!entry.isEmpty()) {
                        double temp = Double.parseDouble(entry);
                        System.out.println("Elf number " + temp);

                        if (mapOfNumbers.containsKey(temp)) {
                            System.out.println("it's a match!");
                            double currentValue = mapOfNumbers.get(temp);
                            mapOfNumbers.put(temp, currentValue + 1);
                        }
                    }





                }
                for (double value : mapOfNumbers.values()) {
                    matchingCards += value;
                }
                double valueToAddToTotal = countGameScore(matchingCards);

                System.out.println("Matching cards: " + matchingCards);
                System.out.println("Value to add " + valueToAddToTotal);
                System.out.println("----------------------------");


                totalSum += valueToAddToTotal;

                System.out.println(totalSum);

            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double countGameScore(double powerOf) {
        if (powerOf > 0) {
            return Math.pow(2, powerOf - 1);
        }
        return 0.0;
    }
}
