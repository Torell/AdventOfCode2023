package Day8;

import java.util.List;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        String path = "src/main/java/Day10/Day7.txt";

        Reader reader = new Reader(path);

        List<Integer> instructions = reader.getInstructions();
        TreeMap<String, String[]> map = reader.getMap();

        String nextKey = map.firstKey();

        int counter = 0;

        outerloop:
        while (true) {
            for (int leftOrRight : instructions) {
                System.out.println("------------------");
                System.out.println("looking up " + nextKey);
                nextKey = map.get(nextKey)[leftOrRight];
                System.out.println("Going " + leftOrRight + " to " + nextKey);
                if (nextKey.equals("ZZZ")) {
                    counter++;
                    break outerloop;
                }
                counter++;
                break outerloop;
            }

        }

        System.out.println("Step taken: " + counter);





    }
}
