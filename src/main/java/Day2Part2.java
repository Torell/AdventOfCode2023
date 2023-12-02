import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Day2Part2 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/Day2.txt"))) {
            String line;

            double countOfValidGames = 0;
            String green = "green";
            String blue = "blue";
            String red = "red";

            outerloop:
            while ((line = reader.readLine()) != null) {

                double minGreen = 1;
                double minBlue = 1;
                double minRed = 1;

                String gameNumberRemoved = line.trim().substring(line.indexOf(":") + 1);
                String[] games = gameNumberRemoved.split(";");
                for (String game : games) {
                    HashMap<String, Double> gameMap = new HashMap<>();
                    gameMap.put(red, 0.0);
                    gameMap.put(blue, 0.0);
                    gameMap.put(green, 0.0);
                    String[] pairs = game.split(",");
                    for (String pair : pairs) {
                        String pairSplit = pair.substring(1);
                        String[] parts = pairSplit.split(" ");
                        double quantity = Double.parseDouble(parts[0]);
                        String color = parts[1];
                        gameMap.put(color, gameMap.getOrDefault(color, 1.0) + quantity);

                        if (minRed < gameMap.get(red)) {
                            minRed = gameMap.get(red);
                        }
                        if (minBlue < gameMap.get(blue)) {
                            minBlue = gameMap.get(blue);
                        }
                        if (minGreen < gameMap.get(green)) {
                            minGreen = gameMap.get(green);
                        }
                    }
                    System.out.println(minBlue);
                    System.out.println(minRed);
                    System.out.println(minGreen);
                }

                double powerOfCubes = minBlue * minGreen * minRed;
                countOfValidGames += powerOfCubes;

            }
            System.out.println(countOfValidGames);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
