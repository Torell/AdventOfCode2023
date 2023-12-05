package Day5;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        ReadDataAndCreateObjectsPart2 data = new ReadDataAndCreateObjectsPart2();
        ListOfMaps listOfMaps = data.getListOfMaps();
        listOfMaps.sort();

        SeedNumberCalculator2v2 seedNumberCalculator2v2 = new SeedNumberCalculator2v2(listOfMaps);

    }
}
