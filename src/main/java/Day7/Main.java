package Day7;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String path = "src/main/java/Day9/Day7.txt";
        DataReaderPart2 dataReader = new DataReaderPart2(path);

        List<Hand> listOfHands = dataReader.getListOfHands();

        for (Hand hand : listOfHands) {
            System.out.println("new hand: ");
            hand.calculateHandPower();
            System.out.println("decimal: " + hand.getEqualScoreSettler());
        }




        Collections.sort(listOfHands, Comparator.comparingDouble(Hand::getHandPower));

        int counter = 1;
        double total = 0;

        for (Hand hand : listOfHands) {
            System.out.println("---------");
            LinkedHashMap<Integer, Integer> temp = hand.getCards();

            for (Map.Entry<Integer, Integer> entry: temp.entrySet()) {
                System.out.println(entry.getValue() + " of " + entry.getKey()   );
            }

            System.out.printf("Handpower: %.10f%n",  hand.getHandPower());
            hand.setRank(counter);

            System.out.printf("Rank: %f100%n", hand.getRank());
            System.out.printf("bid: %f100%n", hand.getBid());
            double pointsToAdd = hand.getBid() * hand.getRank();

            System.out.printf("Points to add: %.2f%n", pointsToAdd);
            total += pointsToAdd;
            System.out.printf("new total: %.2f%n", total);
            counter++;
        }

        System.out.printf("Total: %f%n",  total);




        /*
        for (Hand hand : listOfHands) {

            System.out.println("Hand: " + hand.getCards());
            System.out.println("decimal " + hand.getEqualScoreSettler());
            System.out.println("Handpower " + hand.getHandPower());

            System.out.println("--------");
        }


         */

    }

}
