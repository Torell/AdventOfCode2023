package Day8;

import java.util.*;

public class Part2 {
    public static void main(String[] args) {
        String path = "src/main/java/Day10/Day7.txt";

        Reader reader = new Reader(path);

        List<Integer> instructions = reader.getInstructions();
        TreeMap<String, String[]> map = reader.getMap();

        String nextKey1 = "AAA";
        String nextKey2 = "VKA";
        String nextKey3 = "PBA";
        String nextKey4 = "LSA";
        String nextKey5 = "VSA";
        String nextKey6 = "QVA";
        /*
        int endsWithACount = 0;
        int endsWithZCount = 0;
        String[] keyEndsWithA = new String[6];
        String[] keyEndsWithZ = new String[6];


         */
        /*

        for (String key : map.keySet()) {
            if (endsWithA(key)) {
                keyEndsWithA[endsWithACount] = key;
                endsWithACount++;
            }
            if (endsWithZ(key)) {
                keyEndsWithZ[endsWithZCount] = key;
                endsWithZCount++;
            }
        }


         */
        List<List<Integer>> listOfStepsTaken = new ArrayList<>();
        HashMap<Integer, Integer> mapOfAllStartingKeysZFound = new HashMap<>();
        long stepCounter = 0;
        int instancesOfZFound = 0;

        /*

        for (String nextKey : keyEndsWithA) {
            instancesOfZFound = 0;
            System.out.println("loop starting");

            List<Integer> stepsTaken = new ArrayList<>();


         */

        outerloop:
        while (true) {

            for (int leftOrRight : instructions) {
                stepCounter++;
                nextKey1 = map.get(nextKey1)[leftOrRight];
                nextKey2 = map.get(nextKey2)[leftOrRight];
                nextKey3 = map.get(nextKey3)[leftOrRight];
                nextKey4 = map.get(nextKey4)[leftOrRight];
                nextKey5 = map.get(nextKey5)[leftOrRight];
                nextKey6 = map.get(nextKey6)[leftOrRight];


                if (!endsWithZ(nextKey1)) {
                    continue;
                }

                if (!endsWithZ(nextKey2)) {

                    continue;
                }


                if (!endsWithZ(nextKey3)) {
                    continue;
                }
                System.out.println("1 + 2 +3 = " + stepCounter);

                if (!endsWithZ(nextKey4)) {
                    continue;
                }

                if (!endsWithZ(nextKey5)) {
                    continue;
                }

                if (!endsWithZ(nextKey6)) {
                    continue;
                }
                System.out.println("1 + 2 + 3 + 4 + 5 + 6= " + stepCounter);

                break outerloop;

            }
        }
        System.out.println(stepCounter);


            /*
            outerloop:
            while (true) {

                for (int leftOrRight : instructions) {
                    stepCounter++;
                    nextKey = map.get(nextKey)[leftOrRight];
                    if (endsWithZ(nextKey)) {
                        instancesOfZFound++;
                        stepsTaken.add(stepCounter);
                        mapOfAllStartingKeysZFound.put(stepCounter, mapOfAllStartingKeysZFound.getOrDefault(stepCounter, 0) +1);
                    }

                    if (instancesOfZFound == 600) {
                        listOfStepsTaken.add(stepsTaken);
                        break outerloop;
                    }
                }
            }

        }


        for (List<Integer> list : listOfStepsTaken) {
            for (int steps : list) {
                System.out.println(steps);
            }
        }
        int sixTimes = 0;

        for (Map.Entry entry : mapOfAllStartingKeysZFound.entrySet()) {
            sixTimes = (Integer) entry.getValue();
            if (sixTimes == 6) {
                System.out.println("Steps taken " + entry.getKey() + " " + entry.getValue() + " times");
            }


             */

}








    public static boolean endsWithZ(String input) {
        return input.charAt(2) == 'Z';
    }

    public static boolean endsWithA(String input) {
        return input.charAt(2) == 'A';
    }

}
