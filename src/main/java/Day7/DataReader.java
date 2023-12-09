package Day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class DataReader {

    private List<Hand> listOfHands;

    private Path path;

    public List<Hand> getListOfHands() {
        return listOfHands;
    }

    public DataReader(String path) {
        this.path = Paths.get(path);
        String line;
        listOfHands = new ArrayList<>();

        try(BufferedReader bufferedReader = Files.newBufferedReader(this.path)) {

            while((line = bufferedReader.readLine()) != null) {

                String[] split = line.split(" ");
                System.out.println(split[0] + " bid: " + split[1]);
                LinkedHashMap<Integer, Integer> tempHand = new LinkedHashMap<>();

                double counter = 1000;
                double decimal = 0;
                double totalDecimal = 0;


                for (char c : split[0].toCharArray()) {
                    int convertedCharacter = replaceCharWithInt(c);
                    decimal = (double) convertedCharacter / counter;
                    totalDecimal += decimal;
                    System.out.println(c);
                    System.out.println(convertedCharacter);
                    System.out.println(decimal);
                    System.out.println(totalDecimal);
                    tempHand.put(convertedCharacter,tempHand.getOrDefault(convertedCharacter, 0)+1);
                    counter = counter * 1000;
                }

                Hand hand = new Hand(tempHand, Integer.parseInt(split[1]), totalDecimal);
                listOfHands.add(hand);

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public int replaceCharWithInt(char input) {
        switch (input) {
            case 'A':
                return 14;
            case 'K':
                return 13;
            case 'Q':
                return 12;
            case 'J':
                return 11;
            case 'T':
                return 10;
            default:
                return Character.getNumericValue(input); // Converts the digit character to its numeric value.
        }
    }



}
