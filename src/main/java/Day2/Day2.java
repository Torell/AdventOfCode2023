package Day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Day2 {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/Day2.txt"))) {
            String line;

            double countOfValidGames = 0;
            String green = "green";
            String blue = "blue";
            String red = "red";

            outerloop:
            while ((line = reader.readLine()) != null) {

                String gameNumberRemoved = line.trim().substring(line.indexOf(":") + 1);
                String gameNumber = line.substring(line.indexOf(" "), line.indexOf(":"));
                String[] games = gameNumberRemoved.split(";");
                System.out.println(gameNumberRemoved);
                for (String game : games) {
                    HashMap<String, Double> gameMap = new HashMap<>();
                    gameMap.put(red, 0.0);
                    gameMap.put(blue, 0.0);
                    gameMap.put(green, 0.0);
                    String[] pairs = game.split(",");
                    for (String pair : pairs) {
                        System.out.println(pair);
                        String pairSplit = pair.substring(1);
                        String[] parts = pairSplit.split(" ");
                            double quantity = Double.parseDouble(parts[0]);
                            String color = parts[1];
                            gameMap.put(color, gameMap.getOrDefault(color, 0.0) + quantity);

                            if (gameMap.get(green) > 13 || gameMap.get(red) > 12 || gameMap.get(blue) > 14) {
                                continue outerloop;
                            }

                    }

                }
                countOfValidGames += Double.parseDouble(gameNumber);

            }
            System.out.println(countOfValidGames);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
