package Day5;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        ReadDataAndCreateObjectsPart2 data = new ReadDataAndCreateObjectsPart2();
        ListOfMaps listOfMaps = data.getListOfMaps();



      //  SeedNumberCalculator seedNumberCalculator = new SeedNumberCalculator(listOfMaps);
        SeedNumberCalculator2v2 seedNumberCalculator2v21 = new SeedNumberCalculator2v2(listOfMaps);

    }
}
