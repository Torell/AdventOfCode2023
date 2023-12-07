package Day6;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        double counter = 0;
        double totalValue = 1;
        BoatRace test1 = new BoatRace(7,9);
        BoatRace test2 = new BoatRace(15,40);
        BoatRace test3 = new BoatRace(30,200);



        BoatRace boatRace1 = new BoatRace(44,283);
        BoatRace boatRace2 = new BoatRace(70,1134);
        BoatRace boatRace3 = new BoatRace(70,1134);
        BoatRace boatRace4 = new BoatRace(80,1491);




        BoatRace part2 = new BoatRace(44707080,283113411341491d     );
        BoatRace part2Test = new BoatRace(71530, 940200);

        List<BoatRace> testList = new ArrayList<>();
        List<BoatRace> listOfRaces = new ArrayList<>();

        testList.add(test1);testList.add(test2);testList.add(test3);

        listOfRaces.add(boatRace1);listOfRaces.add(boatRace2);
        listOfRaces.add(boatRace3);listOfRaces.add(boatRace4);

/* Part 1
        for (BoatRace boatRace : listOfRaces) {
            counter = 0;
            for (int i = 0; i <boatRace.getTime() ; i++) {
                if (boatRace.raceWin(i)) {
                    counter++;
                }
            }

            System.out.println(counter);
        }




        System.out.println(29 * 19 * 19 * 21);

 */
        // Part 2

        for (int i = 0; i < part2.getTime() ; i++) {
            if (part2.raceWin(i)) {
                counter++;
            }
        }


        System.out.println(counter);

        //part 2 math

        System.out.println("x: ");
        System.out.printf("%.0f%n", part2.solveForX());
        System.out.println("x2:");
        System.out.printf("%.0f%n", part2.solveForX2());


        System.out.println(part2.solveForX2() - part2.solveForX());
        System.out.println("answer: " + part2.calculatePart2());
    }
}
