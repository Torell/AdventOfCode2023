package Day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class DataReaderPart2 {

    private List<Hand> listOfHands;

    private Path path;

    public List<Hand> getListOfHands() {
        return listOfHands;
    }

    public DataReaderPart2(String path) {
        this.path = Paths.get(path);
        String line;
        listOfHands = new ArrayList<>();

        try(BufferedReader bufferedReader = Files.newBufferedReader(this.path)) {

            while((line = bufferedReader.readLine()) != null) {


                String[] split = line.split(" ");
                LinkedHashMap<Integer, Integer> tempHand = new LinkedHashMap<>();

                double counter = 1;
                double decimal;
                double totalDecimal = 0;
                int jackCounter = 0;

                System.out.println("New loop");
                for (char c : split[0].toCharArray()) {
                    System.out.printf("%.12f%n",totalDecimal);
                    counter = counter * 100;
                    int convertedCharacter = replaceCharWithInt(c);



                    if (convertedCharacter == 11) {
                        jackCounter++;
                        decimal = (double) 1 / counter;
                        System.out.println("-------");
                        totalDecimal += decimal;
                        System.out.println("jack found: ");

                        continue;
                    }
                    decimal = (double) convertedCharacter / counter;
                    System.out.println("-------");
                    totalDecimal += decimal;
                    System.out.printf("%.12f%n",decimal);

                    tempHand.put(convertedCharacter,tempHand.getOrDefault(convertedCharacter, 0)+1);
                }


                if (jackCounter> 0 && jackCounter< 5) {

                    int highestKey = 0;

                    List<Map.Entry<Integer, Integer>> topGuy = tempHand.entrySet()
                            .stream()
                            .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()
                                    .thenComparing(Map.Entry.<Integer, Integer>comparingByKey().reversed()))
                            .toList();

                    List<Map.Entry<Integer, Integer>> topEntry = topGuy.stream()
                            .limit(1)
                            .toList();

                    Iterator <Map.Entry<Integer, Integer>> iterator = topEntry.iterator();

                    if (iterator.hasNext()) {

                        highestKey = iterator.next().getKey();
                    }
                    if (tempHand.size() == 4) {
                        Integer lastKey = null;
                        for (Integer key : tempHand.keySet()) {
                            lastKey = key;
                        }

                        // Add to the value of the last key
                        if (lastKey != null) {
                            tempHand.put(lastKey, tempHand.get(lastKey) + 1);
                        }
                    }
                    else {

                        tempHand.put(highestKey, tempHand.get(highestKey) + jackCounter);

                    }


                }

                if (jackCounter == 5) {
                    tempHand.put(14, 5);
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
