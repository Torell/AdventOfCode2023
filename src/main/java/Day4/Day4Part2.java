package Day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Day4Part2 {


    public static void main(String[] args) {

        Path path = Paths.get("src/main/java/Day4/TestdataDay4");
        String line;
        double totalSum = 0;
        HashMap<HashMap<String, Double>, Integer> mapOfMaps = new HashMap<>();
        List<HashMap<Double, Double>> listOfMaps = new ArrayList<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {

            while ((line = bufferedReader.readLine()) != null) {
                HashMap<Double, Double> mapOfNumbers = new HashMap<>();
                String matchName = line.substring(0, line.indexOf(":"));
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
                HashMap<Double, Double> currentGame = new HashMap<>();
                currentGame.put(1.0, matchingCards);
                listOfMaps.add(currentGame);


            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        int totalSize = 0;
        for (HashMap<Double, Double> map : listOfMaps) {
            totalSize += map.size();
        }

        System.out.println("Next loop");
        List<Double> processedList = new ArrayList<>();
        double[][] arrayOfWinningCards = new double[totalSize][2];
        int i = 0;
        for (HashMap<Double, Double> map : listOfMaps) {
            for (Map.Entry<Double, Double> entry : map.entrySet()) {
                arrayOfWinningCards[i][0] = entry.getKey();
                arrayOfWinningCards[i][1] = entry.getValue();
                i++;
            }

        }

        for (int j = 0; j <arrayOfWinningCards.length ; j++) {
            for (int k = 0; k <arrayOfWinningCards[j].length ; k++) {
                System.out.println(arrayOfWinningCards[i][j]);
            }

        }

/*
        for (HashMap<Double, Double> map : listOfMaps) {
            for (Map.Entry<Double, Double> entry : map.entrySet()) {
                double key = entry.getKey();
                double value = entry.getValue();
                System.out.println(key + " " + value);
            }
        }
        for (int i = 0; i < listOfMaps.size(); i++) {
            HashMap<Double, Double> currentMap = listOfMaps.get(i);
            for (double key : currentMap.keySet()) {
                processedList.add(key);
                System.out.println("------------");
                double points = currentMap.get(key);
                totalSum += points;
                System.out.println(points);

                for (int j = i + 1; points > 0 && j < listOfMaps.size(); j++) {
                    HashMap<Double, Double> nextMap = listOfMaps.get(j);
                    for (double nextKey : nextMap.keySet()) {
                        double nextQuantity = nextMap.get(key);
                        double pointsToDistribute = Math.min(points, 1);
                        nextMap.put(nextKey,nextQuantity + pointsToDistribute);
                        processedList.add(nextKey);
                        points -= pointsToDistribute;

                        if (points <= 0) {
                            break; // Break if all points from the current card are distributed
                        }


                    }
                }
            }
        }

        Collections.sort(processedList);

        for (Double s : processedList) {
            System.out.println(s);
        }
        System.out.println(processedList.size());


 */
    }






    public static double countGameScore(double powerOf) {
        if (powerOf > 0) {
            return Math.pow(2, powerOf - 1);
        }
        return 0.0;
    }
}
