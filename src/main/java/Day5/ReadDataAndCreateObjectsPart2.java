package Day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadDataAndCreateObjectsPart2 {
    ListOfMaps listOfMaps;

    public ReadDataAndCreateObjectsPart2() throws IOException {
        this.listOfMaps = new ListOfMaps();

        Path path = Paths.get("src/main/java/Day5/Day5.txt");
        int lowestNumber = Integer.MIN_VALUE;
        String line;

        String allData = Files.readString(path);


        String[] splitData = allData.split(":");


        String[] seedsStr = splitData[1].substring(0, splitData[1].lastIndexOf("\n")).split(" ");
        String[] seedToSoilStr = splitData[2].substring(splitData[2].indexOf("\n") + 1, splitData[2].lastIndexOf("\n") - 1).split("\n");
        String[] soilToFertilizerStr = splitData[3].substring(splitData[3].indexOf("\n") + 1, splitData[3].lastIndexOf("\n") - 1).split("\n");
        String[] fertilizerToWaterStr = splitData[4].substring(splitData[4].indexOf("\n") + 1, splitData[4].lastIndexOf("\n") - 1).split("\n");
        String[] waterToLightStr = splitData[5].substring(splitData[5].indexOf("\n") + 1, splitData[5].lastIndexOf("\n") - 1).split("\n");
        String[] lightToTemperatureStr = splitData[6].substring(splitData[6].indexOf("\n") + 1, splitData[6].lastIndexOf("\n") - 1).split("\n");
        String[] temperatureToHumidityStr = splitData[7].substring(splitData[7].indexOf("\n") + 1, splitData[7].lastIndexOf("\n") - 1).split("\n");
        String[] humidityToLocationStr = splitData[8].substring(splitData[8].indexOf("\n") + 1, splitData[8].lastIndexOf("\n")).split("\n");

        int counter = 1;
        List<Double> values = new ArrayList<>();
        List<Double> ranges = new ArrayList<>();
        for (String str : seedsStr) {

            if (!str.isEmpty()) {

                if (counter % 2 == 0) {
                    ranges.add(Double.parseDouble(str));
                    counter++;
                    continue;
                }
                values.add(Double.parseDouble(str));
                counter++;

            }
        }

        for (int i = 0; i < values.size(); i++) {
            Seed seed = new Seed(values.get(i), ranges.get(i));
            listOfMaps.addToSeedList(seed);

        }

        for (Seed seed : listOfMaps.getSeedList()) {
            System.out.println("seed nr: " + seed.getSeedNumber());
        }



        for (String str : seedToSoilStr) {
            String[] inData = str.trim().split(" ");
            System.out.println("-------");
            SeedToSoil seedToSoil = new SeedToSoil((Double.parseDouble(inData[0])), (Double.parseDouble(inData[1])), (Double.parseDouble(inData[2])));
            listOfMaps.addToSeedSoilList(seedToSoil);
            System.out.println(seedToSoil.getDestinationRange());
            System.out.println(seedToSoil.getSourceRange());
            System.out.println(seedToSoil.getRangeLength());
            System.out.println("--------");
        }

        for (String str : soilToFertilizerStr) {
            String[] inData = str.trim().split(" ");
            System.out.println("..........");
            SoilToFertilizer soilToFertilizer = new SoilToFertilizer((Double.parseDouble(inData[0])), (Double.parseDouble(inData[1])), (Double.parseDouble(inData[2])));
            listOfMaps.addToSoilFertilizerList(soilToFertilizer);
            System.out.println(soilToFertilizer.getDestinationRange());
            System.out.println(soilToFertilizer.getSourceRange());
            System.out.println(soilToFertilizer.getRangeLength());
            System.out.println("--------");
        }

        for (String str : fertilizerToWaterStr) {
            String[] inData = str.trim().split(" ");
            System.out.println("++++++++++");
            FertilizerToWater fertilizerToWater = new FertilizerToWater((Double.parseDouble(inData[0])), (Double.parseDouble(inData[1])), (Double.parseDouble(inData[2])));
            listOfMaps.addToFertilizerWaterList(fertilizerToWater);
            System.out.println(fertilizerToWater.getDestinationRange());
            System.out.println(fertilizerToWater.getSourceRange());
            System.out.println(fertilizerToWater.getRangeLength());
            System.out.println("--------");
        }


        for (String str : waterToLightStr) {
            String[] inData = str.trim().split(" ");
            System.out.println("'*********");
            WaterToLight waterToLight = new WaterToLight((Double.parseDouble(inData[0])), (Double.parseDouble(inData[1])), (Double.parseDouble(inData[2])));
            listOfMaps.addToWaterLightList(waterToLight);
            System.out.println(waterToLight.getDestinationRange());
            System.out.println(waterToLight.getSourceRange());
            System.out.println(waterToLight.getRangeLength());
            System.out.println("--------");
        }

        for (String str : lightToTemperatureStr) {
            String[] inData = str.trim().split(" ");
            System.out.println("&&&&&&&&");
            LightToTemperature lightToTemperature = new LightToTemperature((Double.parseDouble(inData[0])), (Double.parseDouble(inData[1])), (Double.parseDouble(inData[2])));
            listOfMaps.addToLightTemperatureList(lightToTemperature);
            System.out.println(lightToTemperature.getDestinationRange());
            System.out.println(lightToTemperature.getSourceRange());
            System.out.println(lightToTemperature.getRangeLength());
            System.out.println("--------");
        }

        for (String str : temperatureToHumidityStr) {
            String[] inData = str.trim().split(" ");
            System.out.println("%%%%%%%%");
            TemperatureToHumidity temperatureToHumidity = new TemperatureToHumidity((Double.parseDouble(inData[0])), (Double.parseDouble(inData[1])), (Double.parseDouble(inData[2])));
            listOfMaps.addToTemperatureHumidityList(temperatureToHumidity);
            System.out.println(temperatureToHumidity.getDestinationRange());
            System.out.println(temperatureToHumidity.getSourceRange());
            System.out.println(temperatureToHumidity.getRangeLength());
            System.out.println("--------");
        }



        for (String str : humidityToLocationStr) {
            String[] inData = str.trim().split(" ");
            System.out.println("///////Double");
            HumidityToLocation humidityToLocation = new HumidityToLocation((Double.parseDouble(inData[0])), (Double.parseDouble(inData[1])), (Double.parseDouble(inData[2])));
            listOfMaps.addToHumidityLocationList(humidityToLocation);
            System.out.println(humidityToLocation.getDestinationRange());
            System.out.println(humidityToLocation.getSourceRange());
            System.out.println(humidityToLocation.getRangeLength());
            System.out.println("--------");
        }
    }

    public ListOfMaps getListOfMaps() {
        return listOfMaps;
    }
}
