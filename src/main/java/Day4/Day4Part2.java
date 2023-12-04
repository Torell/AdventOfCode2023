package Day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Day4Part2 {


    public static void main(String[] args) {

        Path path = Paths.get("src/main/java/Day4/Day4.txt");
        String line;
        double totalSum = 0;
        List<Double[]> listOfWinningGames = new ArrayList<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {

            while ((line = bufferedReader.readLine()) != null) {
                HashMap<Double, Double> mapOfNumbers = new HashMap<>();
                String matchNameRemoved = line.substring(line.indexOf(":") + 1);
                String[] allNumber = matchNameRemoved.split("\\|");
                String[] winNumber = allNumber[0].split(" ");
                String[] elfsNumber = allNumber[1].split(" ");
                double matchingCards = 0;

                for (String entry : winNumber) {
                    if (!entry.isEmpty()) {
                        mapOfNumbers.put(Double.parseDouble(entry), 0.0);
                    }
                }

                for (String entry : elfsNumber) {
                    if (!entry.isEmpty()) {
                        double temp = Double.parseDouble(entry);

                        if (mapOfNumbers.containsKey(temp)) {
                            double currentValue = mapOfNumbers.get(temp);
                            mapOfNumbers.put(temp, currentValue + 1);
                        }
                    }


                }
                for (double value : mapOfNumbers.values()) {
                    matchingCards += value;
                }
                Double[] currentGame = new Double[2];
                currentGame[0] = 1.0;
                currentGame[1] = matchingCards;
                listOfWinningGames.add(currentGame);


            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < listOfWinningGames.size(); i++) {
            double copyCards = listOfWinningGames.get(i)[1];
            double amountOfCards = listOfWinningGames.get(i)[0];
            for (int j = 0; j < amountOfCards; j++) {

                for (int k = i; k < i+copyCards; k++) {
                    listOfWinningGames.get(k+1)[0] += 1.0;


                }
            }


        }


        for (Double[] games : listOfWinningGames) {
            totalSum += games[0];
        }

        System.out.println(totalSum);


    }


    public static double countGameScore(double powerOf) {
        if (powerOf > 0) {
            return Math.pow(2, powerOf - 1);
        }
        return 0.0;
    }
}
